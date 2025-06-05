package Controller;

import Model.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;


public class PedidoController {
    private List<Pedido> pedidos;
    private static final String ARQUIVO_PEDIDOS = "data/pedidos.txt";
    private static final NumberFormat numberFormat = NumberFormat.getInstance(new Locale("pt", "BR"));

    public PedidoController() {
        this.pedidos = new ArrayList<>();
        carregarPedidos();
    }

    public Pedido criarPedido(String usuario) {
        Pedido pedido = new Pedido(usuario);
        pedidos.add(pedido);
        return pedido;
    }

    public void adicionarItem(Pedido pedido, ItemPedido item) {
        pedido.adicionarItem(item);
    }

    public void removerItem(Pedido pedido, ItemPedido item) {
        pedido.removerItem(item);
    }

    public boolean processarPagamento(Pedido pedido, Pagamento pagamento) {
        boolean sucesso = pedido.processarPagamento(pagamento);
        if (sucesso && pedido.getItens().size() > 0) {
            salvarPedidos();
        }
        return sucesso;
    }

    public Pedido buscarPedido(int numeroPedido) {
        for (Pedido pedido : pedidos) {
            if (pedido.getNumeroPedido() == numeroPedido) {
                return pedido;
            }
        }
        return null;
    }

    public List<Pedido> listarPedidos() {
        return new ArrayList<>(pedidos);
    }

    private void salvarPedidos() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARQUIVO_PEDIDOS))) {
            for (Pedido pedido : pedidos) {
                // Só salva pedidos que têm itens e pagamento processado
                if (pedido.getItens().size() > 0 && pedido.getFormaPagamento() != null) {
                    writer.println(pedido.resumoPedido());
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar pedidos: " + e.getMessage());
        }
    }

    private void carregarPedidos() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_PEDIDOS))) {
            String linha;
            Pedido pedidoAtual = null;
            List<String> linhasPedido = new ArrayList<>();
            
            while ((linha = reader.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;
                
                if (linha.startsWith("Pedido #")) {
                    // Se já temos um pedido sendo processado, salvamos ele
                    if (pedidoAtual != null) {
                        pedidos.add(pedidoAtual);
                    }
                    
                    // Iniciamos um novo pedido
                    String[] partes = linha.split("\\|");
                    if (partes.length >= 2) {
                        String usuario = partes[1].trim().replace("Usuário: ", "");
                        pedidoAtual = new Pedido(usuario);
                        linhasPedido.clear();
                    }
                } else if (pedidoAtual != null && linha.startsWith("- ")) {
                    // Processa item do pedido
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
                }
            }
            
            // Adiciona o último pedido se existir
            if (pedidoAtual != null) {
                pedidos.add(pedidoAtual);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar pedidos: " + e.getMessage());
        }
    }
}
