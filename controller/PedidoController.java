package controller;

import model.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class PedidoController {
    private List<Pedido> pedidos;
    private static final String ARQUIVO_PEDIDOS = "data/pedidos.txt";
    private static final NumberFormat numberFormat = NumberFormat.getInstance(Locale.of("pt", "BR"));
    private int proximoNumeroPedido;

    public PedidoController() {
        this.pedidos = new ArrayList<>();
        this.proximoNumeroPedido = 1;
        carregarPedidos();
    }

    // Cria novo pedido e adiciona à lista
    public Pedido criarPedido(String usuario) {
        Pedido pedido = new Pedido(usuario, proximoNumeroPedido++);
        pedidos.add(pedido);
        return pedido;
    }

    public void adicionarItem(Pedido pedido, ItemPedido item) {
        pedido.adicionarItem(item);
    }

    public void removerItem(Pedido pedido, ItemPedido item) {
        pedido.removerItem(item);
    }

    // Processa pagamento e salva pedidos se sucesso
    public boolean processarPagamento(Pedido pedido, Pagamento pagamento) {
        if (pedido == null || pedido.isPago()) {
            return false;
        }
        boolean sucesso = pedido.processarPagamento(pagamento);
        if (sucesso && pedido.getItens().size() > 0) {
            salvarPedidos();
        }
        return sucesso;
    }

    // Busca pedido pelo número
    public Pedido buscarPedido(int numeroPedido) {
        for (Pedido pedido : pedidos) {
            if (pedido.getNumeroPedido() == numeroPedido) {
                return pedido;
            }
        }
        return null;
    }

    // Retorna cópia da lista para evitar modificações externas
    public List<Pedido> listarPedidos() {
        return new ArrayList<>(pedidos);
    }

    // Retorna lista de pedidos pendentes do usuário
    public List<Pedido> listarPedidosPendentes(String usuario) {
        List<Pedido> pedidosPendentes = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getUsuario().equals(usuario) && !pedido.isPago()) {
                pedidosPendentes.add(pedido);
            }
        }
        return pedidosPendentes;
    }

    // Remove um pedido da lista
    public boolean removerPedido(int numeroPedido) {
        Pedido pedido = buscarPedido(numeroPedido);
        if (pedido != null && !pedido.isPago()) {
            pedidos.remove(pedido);
            return true;
        }
        return false;
    }

    // Cria um novo item de pedido
    public ItemPedido criarItemPedido(String nomeProduto, int quantidade) {
        Cafe cafe = new Cafe(nomeProduto, 5.0f, "Produto temporário");
        return new ItemPedido(cafe, quantidade);
    }

    // Salva pedidos no arquivo mantendo os números originais
    private void salvarPedidos() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARQUIVO_PEDIDOS))) {
            for (Pedido pedido : pedidos) {
                if (pedido.getItens().size() > 0) {
                    writer.println(pedido.resumoPedido());
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar pedidos: " + e.getMessage());
        }   
    }

    // Carrega pedidos do arquivo e recria objetos
    private void carregarPedidos() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_PEDIDOS))) {
            String linha;
            Pedido pedidoAtual = null;
            List<String> linhasPedido = new ArrayList<>();
            
            while ((linha = reader.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;
                
                // Checa se foi pago
                boolean isPago = linha.startsWith("[PAGO]");
                if (linha.startsWith("[PAGO]") || linha.startsWith("[PENDENTE]")) {
                    linha = linha.substring(linha.indexOf("]") + 1).trim();
                }
                
                if (linha.startsWith("Pedido #")) {
                    if (pedidoAtual != null) {
                        pedidos.add(pedidoAtual);
                    }
                    
                    String[] partes = linha.split("\\|");
                    if (partes.length >= 2) {
                        String usuario = partes[1].trim().replace("Usuário: ", "");
                        // Extrai o número do pedido do texto
                        int numeroPedido = Integer.parseInt(linha.split("#")[1].split("\\|")[0].trim());
                        pedidoAtual = new Pedido(usuario, numeroPedido);
                        // Atualiza o próximo número de pedido
                        if (numeroPedido >= proximoNumeroPedido) {
                            proximoNumeroPedido = numeroPedido + 1;
                        }
                        linhasPedido.clear();
                    }
                } else if (pedidoAtual != null && linha.startsWith("- ")) {
                    String[] partes = linha.substring(2).split(" x");
                    if (partes.length >= 2) {
                        String nome = partes[0].trim();
                        String[] quantidadePreco = partes[1].split(" - R\\$ ");
                        if (quantidadePreco.length >= 2) {
                            int quantidade = Integer.parseInt(quantidadePreco[0].trim());
                            try {
                                float preco = numberFormat.parse(quantidadePreco[1].trim()).floatValue();
                                Cafe cafe = new Cafe(nome, preco, "Café expresso tradicional");
                                ItemPedido item = new ItemPedido(cafe, quantidade);
                                pedidoAtual.adicionarItem(item);
                            } catch (ParseException e) {
                                System.err.println("Erro ao processar preço: " + e.getMessage());
                            }
                        }
                    }
                } else if (pedidoAtual != null && linha.startsWith("Forma de Pagamento: ")) {
                    // Se o pedido foi pago, cria um pagamento
                    if (isPago) {
                        String formaPagamento = linha.replace("Forma de Pagamento: ", "").trim();
                        Pagamento pagamento = null;
                        switch (formaPagamento) {
                            case "Cartão" -> pagamento = new PagamentoCartao("0000000000000000");
                            case "PIX" -> pagamento = new PagamentoPix("chave.pix@teste.com");
                            case "Dinheiro" -> pagamento = new PagamentoDinheiro(pedidoAtual.getValorTotal());
                        }
                        if (pagamento != null) {
                            pedidoAtual.processarPagamento(pagamento);
                        }
                    }
                }
            }
            
            if (pedidoAtual != null) {
                pedidos.add(pedidoAtual);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar pedidos: " + e.getMessage());
        }
    }

    // Registra um novo pedido com item
    public void registrarNovoPedido(String usuario, String nomeProduto, int quantidade) {
        Pedido pedido = criarPedido(usuario);
        ItemPedido item = criarItemPedido(nomeProduto, quantidade);
        adicionarItem(pedido, item);
    }

    // Lista todos os pedidos de um usuário
    public List<Pedido> listarPedidosUsuario(String usuario) {
        List<Pedido> pedidosUsuario = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getUsuario().equals(usuario)) {
                pedidosUsuario.add(pedido);
            }
        }
        return pedidosUsuario;
    }
}
