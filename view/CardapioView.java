package view;

import controller.CardapioController;
import model.Produto;
import model.CategoriaProduto;
import utils.Cores;
import utils.InputHelper;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Comparator;

public class CardapioView {

    private static CardapioController controller;
    private static Scanner input = new Scanner(System.in);


    public CardapioView(CardapioController controller) {
        this.controller = controller;
    }

    private static String pedirInput(String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void exibirCardapioCompleto() {
        System.out.println(Cores.CREME + "\n=============================================" + Cores.RESET);
        System.out.println(Cores.LAVENDER + "              NOSSO CARDÁPIO                 " + Cores.RESET);
        System.out.println(Cores.CREME + "=============================================");

        sleep(340);

        List<Produto> produtos = controller.getTodosOsProdutos();

        if (produtos.isEmpty()) {
            System.out.println("\nO cardápio está vazio no momento.");
            System.out.println("------------------------------------------");
            pedirInput("\nPressione Enter para continuar...");
            return;
        }

        Map<CategoriaProduto, List<Produto>> produtosPorCategoria = produtos.stream()
                .sorted(Comparator.comparing(Produto::getCategoria))
                .collect(Collectors.groupingBy(Produto::getCategoria));

        int numeroItem = 1;

        for (CategoriaProduto categoria : CategoriaProduto.values()) {
            List<Produto> itensDaCategoria = produtosPorCategoria.get(categoria);
            if (itensDaCategoria != null && !itensDaCategoria.isEmpty()) {
                System.out.println("\n>>>>> " + Cores.LAVENDER + categoria.name().replace("_", " ") +
                        Cores.RESET + Cores.CREME +" <<<<<");
                System.out.println("---------------------------------------------");

                for (Produto produto : itensDaCategoria) {
                    System.out.println(numeroItem + ". " + produto.descricaoDetalhada());
                    System.out.println("---------------------------------------------");
                    numeroItem++;

                    sleep(250);
                }
            }
        }
        System.out.println("\n>>>>> " + Cores.LAVENDER + "FIM DO CARDÁPIO" + Cores.RESET + Cores.CREME + " <<<<<" );
        System.out.println(Cores.CREME + "=============================================");
        pedirInput("\nPressione Enter para prosseguir...");
        System.out.println();
    }

    public static void buscarProdutosPorCategoria() {
        System.out.print("\n\n>>>>");
        System.out.print(Cores.LAVENDER + " BUSCAR PRODUTOS POR CATEGORIA " + Cores.RESET + Cores.CREME);
        System.out.println("<<<<");
        System.out.println(Cores.LAVENDER + "\n>>" + Cores.RESET + Cores.CREME + " Categorias disponíveis:");

        CategoriaProduto[] categorias = CategoriaProduto.values();
        for (int i = 0; i < categorias.length; i++) {
            System.out.println((i + 1) + ". " + categorias[i].name().replace("_", " "));
        }

        System.out.print(Cores.LAVENDER + "\n>>" + Cores.RESET + Cores.CREME + " Escolha o número da categoria: ");
        int escolhaCategoriaNum = InputHelper.lerInt();

        if (escolhaCategoriaNum < 1 || escolhaCategoriaNum > categorias.length) {
            System.out.println("\nNúmero de categoria inválido.");
            pedirInput("\nPressione Enter para continuar...");
            return;
        }

        CategoriaProduto categoriaSelecionada = categorias[escolhaCategoriaNum - 1];

        List<Produto> produtosEncontrados = controller.buscarPorCategoria(categoriaSelecionada);
        System.out.print("\n-----");
        System.out.print(Cores.LAVENDER + " PRODUTOS NA CATEGORIA: " + categoriaSelecionada.name().replace("_", " ")
                + Cores.RESET + Cores.CREME);
        System.out.println(" -----");
        if (produtosEncontrados.isEmpty()) {
            System.out.println("\nNenhum produto encontrado nesta categoria.");
        } else {
            int numeroItem = 1;
            for (Produto produto : produtosEncontrados) {
                System.out.println(numeroItem + ". " + produto.descricaoDetalhada());
                System.out.println("------------------------------------------");
                numeroItem++;
                sleep(340);
            }
        }

        pedirInput("\nPressione Enter para continuar...");
    }
}