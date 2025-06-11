package view;

import controller.CardapioController; // Importa o CardapioController
import model.Produto; // Importa a classe Produto
import model.CategoriaProduto; // Importa o enum CategoriaProduto
import java.util.List;
import java.util.Scanner;
import java.util.Map; // Para agrupar por categoria
import java.util.stream.Collectors; // Para usar o Collectors.groupingBy

public class CardapioView {

    private Scanner input; //  inicializar no construtor
    private CardapioController controller; // Referência ao Controller

    // Construtor da View, que recebe o Controller
    public CardapioView(CardapioController controller) {
        this.input = new Scanner(System.in);
        this.controller = controller; // Associa o Controller à View
    }

    //Metodo principal
    public void iniciar() {
        int opcao;
        do {
            exibirMenuPrincipal();
            opcao = input.nextInt(); // Lê a opção do usuário
            input.nextLine(); // Consome a quebra de linha

            switch (opcao) {
                case 1:
                    exibirCardapioCompleto(); // Chama o metodo para exibir o cardápio
                    break;
                case 0:
                    System.out.println("Saindo do módulo de Cardápio. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void exibirMenuPrincipal() {
        System.out.println("\n--- Você selecionou ver o Cardápio! ---");
        System.out.println("1. Ver Cardápio Completo");
        // Irei adicionar aqui no futuro buscar produto
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Metodo para exibir o cardápio completo, agora fazendo a lógica de agrupamento
    public void exibirCardapioCompleto() {
        System.out.println("\n--- NOSSO CARDÁPIO ---");

        // O Controller agora precisa ter um metodo para pegar todos os produtos
        List<Produto> produtos = controller.getTodosOsProdutos();

        if (produtos.isEmpty()) {
            System.out.println("O cardápio está vazio no momento.");
            return;
        }

        // Agrupa os produtos por categoria
        Map<CategoriaProduto, List<Produto>> produtosPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria));

        int numeroItem = 1; // Para numerar os itens

        // Itera sobre cada categoria e exibe os produtos
        for (CategoriaProduto categoria : CategoriaProduto.values()) {
            List<Produto> itensDaCategoria = produtosPorCategoria.get(categoria);
            if (itensDaCategoria != null && !itensDaCategoria.isEmpty()) {
                System.out.println("\n===== " + categoria.name().replace("_", " ") + " ====="); // Título da categoria sem underline sla o nome dessa porra

                for (Produto produto : itensDaCategoria) {
                    System.out.println(numeroItem + ". " + produto.descricaoDetalhada()); // Exibe a descrição detalhada
                    numeroItem++; // Incrementa para o próximo item
                }
            }
        }
        System.out.println("\n--------------------------");
        System.out.println("Pressione Enter para continuar...");
        input.nextLine(); // Espera o usuário pressionar Enter
    }

}