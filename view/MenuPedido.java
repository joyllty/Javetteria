package view;

import model.Pedido;
import java.util.List;
import utils.Cores;

public class MenuPedido {
    public void exibirMenu() {
        System.out.println(Cores.CREME + "\n ╔═════════════════════════╗");
        System.out.println(" ║                         ║");
        System.out.println(" ║ [1] REGISTRAR PEDIDO    ║");
        System.out.println(" ║ [2] ACOMPANHAR PEDIDOS  ║");
        System.out.println(" ║ [3] REMOVER PEDIDO      ║");
        System.out.println(" ║ [4] PAGAMENTO           ║");
        System.out.println(" ║ [0] VOLTAR              ║");
        System.out.println(" ║                         ║");
        System.out.println(" ╚═════════════════════════╝" + Cores.RESET);
        System.out.print("\n" + (Cores.LAVENDER + ">>" + Cores.RESET) + Cores.CREME + " Selecione uma opção: " + Cores.RESET);
    }

    public void exibirMensagem(String mensagem, String cor) {
        System.out.println(cor + mensagem + Cores.RESET);
    }

    public void exibirPedido(Pedido pedido) {
        System.out.println(Cores.CREME + "\n" + pedido.resumoPedido() + Cores.RESET);
    }

    public void exibirListaPedidos(List<Pedido> pedidos) {
        for (Pedido pedido : pedidos) {
            exibirPedido(pedido);
        }
    }

    public void exibirFormasPagamento() {
        System.out.println(Cores.CREME + "\n ╔═════════════════════════╗");
        System.out.println(" ║                         ║");
        System.out.println(" ║ [1] CARTÃO              ║");
        System.out.println(" ║ [2] PIX                 ║");
        System.out.println(" ║ [3] DINHEIRO            ║");
        System.out.println(" ║                         ║");
        System.out.println(" ╚═════════════════════════╝" + Cores.RESET);
        System.out.print("\n" + (Cores.LAVENDER + ">>" + Cores.RESET) + Cores.CREME + " Escolha: " + Cores.RESET);
    }

    public void exibirPrompt(String prompt) {
        System.out.print(Cores.CREME + prompt + Cores.RESET);
    }

    public void exibirInformacoesPagamento(String informacoes) {
        if (!informacoes.isEmpty()) {
            System.out.println(Cores.CREME + informacoes + Cores.RESET);
        }
    }
}
