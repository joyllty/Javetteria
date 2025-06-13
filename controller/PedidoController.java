package controller;

import model.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import utils.Utils;
import model.StatusPedido;

public class PedidoController {
    private List<Pedido> pedidos;
    private static final String ARQUIVO_PEDIDOS = "data/pedidos.txt";
    private static final NumberFormat numberFormat = NumberFormat.getInstance(Locale.of("pt", "BR"));
    private int proximoNumeroPedido;
    private final Cardapio cardapio;

    public PedidoController() {
        this.pedidos = new ArrayList<>();
        this.cardapio = new Cardapio();
        this.proximoNumeroPedido = 1;
        carregarPedidos();
    }

    public Pedido criarPedido(String usuario) {
        Pedido pedido = new Pedido(usuario, proximoNumeroPedido++);
        pedidos.add(pedido);
        return pedido;
    }

    public void adicionarItem(Pedido pedido, ItemPedido item) {
        pedido.adicionarItem(item);
        salvarPedidos();
    }

    public void removerItem(Pedido pedido, ItemPedido item) {
        pedido.removerItem(item);
        salvarPedidos();
    }

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

    public List<Pedido> listarPedidosPendentes(String usuario) {
        List<Pedido> pedidosPendentes = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getUsuario().equals(usuario) && !pedido.isPago()) {
                pedidosPendentes.add(pedido);
            }
        }
        return pedidosPendentes;
    }

    public boolean removerPedido(int numeroPedido) {
        Pedido pedido = buscarPedido(numeroPedido);
        if (pedido != null && !pedido.isPago()) {
            pedidos.remove(pedido);
            return true;
        }
        return false;
    }

    public ItemPedido criarItemPedido(String nomeProduto, int quantidade) {
        String nomeNormalizado = Utils.normalizarTexto(nomeProduto);
        Produto produto = cardapio.getProdutos().stream()
            .filter(p -> Utils.normalizarTexto(p.getNome()).equals(nomeNormalizado))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado: " + nomeProduto));
        return new ItemPedido(produto, quantidade);
    }

    public void salvarPedidos() {
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

    private void carregarPedidos() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_PEDIDOS))) {
            String linha;
            Pedido pedidoAtual = null;
            while ((linha = reader.readLine()) != null) {
                boolean isPago = linha.startsWith(StatusPedido.PAGO.getTag());
                if (linha.startsWith(StatusPedido.PAGO.getTag()) || linha.startsWith(StatusPedido.PENDENTE.getTag())) {
                    linha = linha.substring(linha.indexOf("]") + 1).trim();
                }

                if (linha.startsWith("Pedido #")) {
                    String[] partes = linha.split(" - ");
                    if (partes.length >= 2) {
                        int numeroPedido = Integer.parseInt(partes[0].substring(8));
                        String usuario = partes[1].trim();
                        pedidoAtual = new Pedido(usuario, numeroPedido);
                        pedidos.add(pedidoAtual);
                        if (numeroPedido >= proximoNumeroPedido) {
                            proximoNumeroPedido = numeroPedido + 1;
                        }
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
                                String nomeNormalizado = Utils.normalizarTexto(nome);
                                Produto produto = cardapio.getProdutos().stream()
                                    .filter(p -> Utils.normalizarTexto(p.getNome()).equals(nomeNormalizado))
                                    .findFirst()
                                    .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado: " + nome));
                                ItemPedido item = new ItemPedido(produto, quantidade);
                                pedidoAtual.adicionarItem(item);
                            } catch (ParseException e) {
                                System.err.println("Erro ao processar preço: " + e.getMessage());
                            }
                        }
                    }
                } else if (pedidoAtual != null && linha.startsWith("Forma de Pagamento: ")) {
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
        } catch (IOException e) {
            System.err.println("Erro ao carregar pedidos: " + e.getMessage());
        }
    }

    public List<Pedido> listarPedidosUsuario(String usuario) {
        List<Pedido> pedidosUsuario = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getUsuario().equals(usuario)) {
                pedidosUsuario.add(pedido);
            }
        }
        return pedidosUsuario;
    }

    public List<Pedido> listarPedidosPendentesGlobal() {
        List<Pedido> pendentes = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (!pedido.isPago()) {
                pendentes.add(pedido);
            }
        }
        return pendentes;
    }
}
