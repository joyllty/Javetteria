package Controller;

import Model.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PedidoController {
    private List<Pedido> pedidos;
    private static final String ARQUIVO_PEDIDOS = "Data/pedidos.txt";

    public PedidoController() {
        this.pedidos = new ArrayList<>();
        carregarPedidos();
    }

    public Pedido criarPedido(String usuario) {
        Pedido pedido = new Pedido(usuario);
        pedidos.add(pedido);
        salvarPedido(pedido);
        return pedido;
    }

    public void adicionarItem(Pedido pedido, ItemPedido item) {
        pedido.adicionarItem(item);
        salvarPedido(pedido);
    }

    public void removerItem(Pedido pedido, ItemPedido item) {
        pedido.removerItem(item);
        salvarPedido(pedido);
    }

    public boolean processarPagamento(Pedido pedido, Pagamento pagamento) {
        boolean sucesso = pedido.processarPagamento(pagamento);
        if (sucesso) {
            salvarPedido(pedido);
        }
        return sucesso;
    }

    public Optional<Pedido> buscarPedido(int numeroPedido) {
        return pedidos.stream()
                .filter(p -> p.getNumeroPedido() == numeroPedido)
                .findFirst();
    }

    public List<Pedido> listarPedidos() {
        return new ArrayList<>(pedidos);
    }

    private void salvarPedido(Pedido pedido) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARQUIVO_PEDIDOS, true))) {
            writer.println(pedido.toString());
        } catch (IOException e) {
            System.err.println("Erro ao salvar pedido: " + e.getMessage());
        }
    }

    private void carregarPedidos() {
        // Simples: não carrega nada, apenas inicializa a lista vazia
    }
}
