package view;
import controller.EstoqueController;
import model.Ingrediente;
import utils.InputHelper;
import java.util.List;
import java.util.Scanner;


//entrada de dados

public class EstoqueView {
    public static final String LAVENDER = "\u001B[38;5;183m";
    public static final String CREME = "\u001B[38;5;229m";
    public static final String BROWN = "\u001B[38;5;130m";
    public static final String RESET = "\u001B[0m";
    //---------------------------#--------------------------//

    static Scanner input = new Scanner(System.in);

    public void executar() {
        int opEstoque = 0;
        do {
            view.EstoqueView.menuEstoque();
            opEstoque = InputHelper.lerInt();
            verificarOp(opEstoque);

        } while (opEstoque != 5);
    }


    public void verificarOp(int op){

        switch (op) {
            case 1 -> listarItens();
            case 2 -> adicionarItem();
            case 3 -> System.out.println("remover"); //atualizarItens();
            case 4 -> System.out.println("atualizar"); //removerItens();
            default -> System.out.println("Opção inválida!");
        }
    }


    public static void menuEstoque(){
        System.out.println("\n  ========= ESTOQUE =========");
        System.out.println(" ╔═══════════════════════════╗");
        System.out.println(" ║                           ║");
        System.out.println(" ║ [1] LISTAR ESTOQUE        ║");
        System.out.println(" ║ [2] ADICIONAR ITENS       ║");
        System.out.println(" ║ [3] REMOVER ITENS         ║");
        System.out.println(" ║ [4] ATUALIZAR QUANTIDADES ║");
        System.out.println(" ║ [5] VOLTAR                ║");
        System.out.println(" ║                           ║");
        System.out.println(" ╚═══════════════════════════╝ ");

        System.out.print("\n" + (LAVENDER + ">>" + RESET) + CREME + " Selecione uma opção: ");

    }

    private void listarItens() {
        List<Ingrediente> lista = EstoqueController.listarIngredientes(); //cria uma lista pegando a lista do estoque

        System.out.println("\n╔════╦════════════════════════╦══════════════╦════════════╗");
        System.out.printf("║ %-2s ║ %-22s ║ %-12s ║ %-10s ║\n", "ID", "Nome", "Quantidade", "Unidade");
        System.out.println("╠════╬════════════════════════╬══════════════╬════════════╣");

        for (Ingrediente i : lista) {
            System.out.printf("║ %-2d ║ %-22s ║ %-12d ║ %-10s ║\n",
                    i.getId(), i.getNome(), i.getQuantidade(), i.getUnidade());
        }

        System.out.println("╚════╩════════════════════════╩══════════════╩════════════╝");

    }


    public static void adicionarItem() {
        System.out.println("\n=================================");
        System.out.println("Digite os dados do item a ser adicionado: ");
        System.out.print((LAVENDER + "\n>>" + RESET) + CREME + " ID: ");
        int id = InputHelper.lerInt();

        System.out.print((LAVENDER + "\n>>" + RESET) + CREME + " Nome: ");
        String nome = InputHelper.lerString();

        System.out.print((LAVENDER + "\n>>" + RESET) + CREME + " Quantidade: ");
        int quantidade = InputHelper.lerInt();

        System.out.print((LAVENDER + "\n>>" + RESET) + CREME + " Unidade (g, ml, unid...): ");
        String unidade = InputHelper.lerString();

        EstoqueController.adicionarItem(id, nome, quantidade, unidade);
        System.out.println("Ingrediente adicionado com sucesso!");
    }



}
