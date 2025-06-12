package view;

import model.Pedido;
import java.util.List;

public class MenuPedido {
    public static final String LAVENDER = "\u001B[38;5;183m";
    public static final String CREME = "\u001B[38;5;229m";
    public static final String BROWN = "\u001B[38;5;130m";
    public static final String RESET = "\u001B[0m";

    // Pure display methods
    public void exibirMenu() {
        System.out.println("\n ╔═════════════════════════╗");
        System.out.println(" ║                         ║");
        System.out.println(" ║ [1] REGISTRAR PEDIDO    ║");
        System.out.println(" ║ [2] ACOMPANHAR PEDIDOS  ║");
        System.out.println(" ║ [3] REMOVER PEDIDO      ║");
        System.out.println(" ║ [4] PAGAMENTO           ║");
        System.out.println(" ║ [5] VOLTAR              ║");
        System.out.println(" ║                         ║");
        System.out.println(" ╚═════════════════════════╝");
        System.out.print("\n" + (LAVENDER + ">>" + RESET) + CREME + " Selecione uma opção: " + RESET);
    }

    public void exibirMensagem(String mensagem, String cor) {
        System.out.println(cor + mensagem + RESET);
    }

    public void exibirPedido(Pedido pedido) {
        System.out.println("\n" + pedido.resumoPedido());
    }

    public void exibirListaPedidos(List<Pedido> pedidos) {
        for (Pedido pedido : pedidos) {
            exibirPedido(pedido);
        }
    }

    public void exibirFormasPagamento() {
        System.out.println("Formas de pagamento:");
        System.out.println("[1] Cartão\n[2] PIX\n[3] Dinheiro");
        System.out.print("Escolha: ");
    }

    public void exibirPrompt(String prompt) {
        System.out.print(prompt);
    }

    public void exibirInformacoesPagamento(String informacoes) {
        if (!informacoes.isEmpty()) {
            System.out.println(CREME + informacoes + RESET);
        }
    }
}
