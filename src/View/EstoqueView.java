package view;
import controller.EstoqueController;
import model.Ingrediente;
import model.Menu;
import utils.InputHelper;
import java.util.List;


public class EstoqueView implements Menu {
    //#---------------- CORES ----------------#
    public static final String LAVENDER = "\u001B[38;5;183m";
    public static final String CREME = "\u001B[38;5;229m";
    public static final String BROWN = "\u001B[38;5;130m";
    public static final String RESET = "\u001B[0m";
    //---------------------------#--------------------------//

    // função principal do menu estoque - sobrescrita
    @Override
    public void executar() {
        int opEstoque = 0;
        do {
            menuEstoque();
            opEstoque = InputHelper.lerInt();
            verificarOp(opEstoque);

        } while (opEstoque != 6);
    }

    // ler opção do menu
    public void verificarOp(int op){

        switch (op) {
            case 1 -> listarItens();
            case 2 -> adicionarItem();
            case 3 -> removerItem();
            case 4 -> editarItem();
            case 5 -> EstoqueController.exportarEstoque();
            case 6 -> System.out.println("\nVoltando...");
            default -> System.out.print("\n" + (LAVENDER + ">>" + RESET) + CREME + "Opção inválida! Digite novamente: ");
        }
    }

    // view menu estoque
    public static void menuEstoque(){
        System.out.println("\n  ========= ESTOQUE =========");
        System.out.println(" ╔═══════════════════════════╗");
        System.out.println(" ║                           ║");
        System.out.println(" ║ [1] LISTAR ESTOQUE        ║");
        System.out.println(" ║ [2] ADICIONAR ITENS       ║");
        System.out.println(" ║ [3] REMOVER ITENS         ║");
        System.out.println(" ║ [4] ATUALIZAR QUANTIDADES ║");
        System.out.println(" ║ [5] EXPORTAR ESTOQUE      ║");
        System.out.println(" ║ [6] VOLTAR                ║");
        System.out.println(" ║                           ║");
        System.out.println(" ╚═══════════════════════════╝ ");

        System.out.print("\n" + (LAVENDER + ">>" + RESET) + CREME + " Selecione uma opção: ");
    }

    // listar os itens do estoque
    private void listarItens() {
        List<Ingrediente> lista = EstoqueController.listarItens(); //cria uma lista pegando a lista do estoque

        System.out.println("\n╔════╦════════════════════════╦══════════════╦════════════╗");
        System.out.printf("║ %-2s ║ %-22s ║ %-12s ║ %-10s ║\n", "ID", "Nome", "Quantidade", "Unidade");
        System.out.println("╠════╬════════════════════════╬══════════════╬════════════╣");

        for (Ingrediente i : lista) {
            System.out.printf("║ %-2d ║ %-22s ║ %-12d ║ %-10s ║\n",
                    i.getId(), i.getNome(), i.getQuantidade(), i.getUnidade());
        }

        System.out.println("╚════╩════════════════════════╩══════════════╩════════════╝");
    }

    // adicionar itens ao estoque
    public static void adicionarItem() {
        System.out.println("\n============" + (LAVENDER + " ADICIONAR ITEM " + RESET) + CREME + "============");
        System.out.println("\nDigite os dados do item a ser adicionado: ");
        System.out.print((LAVENDER + "\n>>" + RESET) + CREME + " ID: ");
        int id = InputHelper.lerInt();

        System.out.print((LAVENDER + "\n>>" + RESET) + CREME + " Nome: ");
        String nome = InputHelper.lerString();

        System.out.print((LAVENDER + "\n>>" + RESET) + CREME + " Quantidade: ");
        int quantidade = InputHelper.lerInt();

        System.out.print((LAVENDER + "\n>>" + RESET) + CREME + " Unidade (g, ml, unid...): ");
        String unidade = InputHelper.lerString();

        EstoqueController.adicionarItem(id, nome, quantidade, unidade);
        EstoqueController.exportarEstoque(); // adiciona estoque atualizado no arquivo estoque.txt
        System.out.println("\nItem adicionado com sucesso!");
        System.out.println("=========================================");
    }

    // remover itens do estoque
    public static void removerItem(){
        System.out.println("\n============" + (LAVENDER + " REMOVER ITEM " + RESET) + CREME + "============");
        System.out.print("\nDigite o id do item a ser removido: ");
        int id = InputHelper.lerInt();

        if(EstoqueController.removerItem(id)){
            System.out.println((LAVENDER + "\n>>" + RESET) + CREME + " Item removido!");
            EstoqueController.exportarEstoque(); // adiciona estoque atualizado no arquivo estoque.txt
        } else {
            System.out.println((LAVENDER + "\n>>" + RESET) + CREME + " Item não encontrado!");
        }

        System.out.println("======================================");
    }

    // editar quantidade dos itens do estoque
    public static void editarItem() {
        System.out.println("\n============" + (LAVENDER + " EDITAR ITEM " + RESET) + CREME + "============");
        System.out.println("\nDigite o ID do item a ser alterado: ");
        System.out.print((LAVENDER + "\n>>" + RESET) + CREME + " ID: ");
        int id = InputHelper.lerInt();

        System.out.print((LAVENDER + "\n>>" + RESET) + CREME + " Digite a nova quantidade: ");
        int quantidade = InputHelper.lerInt();

        EstoqueController.atualizarItem(id, quantidade);
        EstoqueController.exportarEstoque();

        System.out.println("\nItem editado com sucesso!");
        System.out.println("=====================================");
    }

    // mostrar a mensagem de sucesso da exportação do estoque
    public static void mostrarMensagem(String msg) {
        // mostrar a mensagem da exportação do estoque
        System.out.println(msg);
    }


}
