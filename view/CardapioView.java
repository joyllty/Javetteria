package view;

import controller.CardapioController;
import model.Produto;
import model.CategoriaProduto;
import utils.InputHelper; // Importa a classe InputHelper
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Comparator;

public class CardapioView {

    private CardapioController controller;

    public CardapioView(CardapioController controller) {
        this.controller = controller;
    }

    public void iniciar() {
        int opcao;
        do {
            exibirMenuPrincipal();
            System.out.print("Escolha uma opção: "); // Imprime o prompt ANTES
            opcao = InputHelper.lerInt(); // Chama lerInt sem argumentos

            switch (opcao) {
                case 1:
                    exibirCardapioCompleto();
                    break;
                case 2:
                    buscarProdutosPorCategoria();
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
        System.out.println("\n-----------------------------------------");
        System.out.println("           Módulo de Cardápio          ");
        System.out.println("-----------------------------------------");
        System.out.println(" 1. Ver Cardápio Completo              ");
        System.out.println(" 2. Buscar Produtos por Categoria      ");
        System.out.println(" 0. Sair                               ");
        System.out.println("-----------------------------------------");
    }

    public void exibirCardapioCompleto() {
        System.out.println("\n");
        System.out.println("==========================================");
        System.out.println("           NOSSO CARDÁPIO                 ");
        System.out.println("==========================================");

        List<Produto> produtos = controller.getTodosOsProdutos();

        if (produtos.isEmpty()) {
            System.out.println("\nO cardápio está vazio no momento.");
            System.out.println("------------------------------------------");
            System.out.print("Pressione Enter para continuar..."); // Imprime o prompt ANTES
            InputHelper.lerString(); // Chama lerString sem argumentos
            return;
        }

        Map<CategoriaProduto, List<Produto>> produtosPorCategoria = produtos.stream()
                .sorted(Comparator.comparing(Produto::getCategoria))
                .collect(Collectors.groupingBy(Produto::getCategoria));

        int numeroItem = 1;

        for (CategoriaProduto categoria : CategoriaProduto.values()) {
            List<Produto> itensDaCategoria = produtosPorCategoria.get(categoria);
            if (itensDaCategoria != null && !itensDaCategoria.isEmpty()) {
                System.out.println("\n--- " + categoria.name().replace("_", " ") + " ---");
                System.out.println("------------------------------------------");

                for (Produto produto : itensDaCategoria) {
                    System.out.println(numeroItem + ". " + produto.descricaoDetalhada());
                    System.out.println("------------------------------------------");
                    numeroItem++;
                }
            }
        }
        System.out.println("\n--- FIM DO CARDÁPIO ---");
        System.out.println("==========================================");
        System.out.print("Pressione Enter para continuar..."); // Imprime o prompt ANTES
        InputHelper.lerString(); // Chama lerString sem argumentos
    }

    private void buscarProdutosPorCategoria() {
        System.out.println("\n--- BUSCAR PRODUTOS POR CATEGORIA ---");
        System.out.println("Categorias disponíveis:");

        CategoriaProduto[] categorias = CategoriaProduto.values();
        for (int i = 0; i < categorias.length; i++) {
            System.out.println((i + 1) + ". " + categorias[i].name().replace("_", " "));
        }

        System.out.print("Escolha o número da categoria: "); // Imprime o prompt ANTES
        int escolhaCategoriaNum = InputHelper.lerInt(); // Chama lerInt sem argumentos



        if (escolhaCategoriaNum < 1 || escolhaCategoriaNum > categorias.length) {
            System.out.println("Número de categoria inválido.");
            System.out.print("Pressione Enter para continuar..."); // Imprime o prompt ANTES
            InputHelper.lerString(); // Chama lerString sem argumentos
            return;
        }

        CategoriaProduto categoriaSelecionada = categorias[escolhaCategoriaNum - 1];

        List<Produto> produtosEncontrados = controller.buscarPorCategoria(categoriaSelecionada);

        System.out.println("\n--- PRODUTOS NA CATEGORIA: " + categoriaSelecionada.name().replace("_", " ") + " ---");
        if (produtosEncontrados.isEmpty()) {
            System.out.println("Nenhum produto encontrado nesta categoria.");
        } else {
            int numeroItem = 1;
            for (Produto produto : produtosEncontrados) {
                System.out.println(numeroItem + ". " + produto.descricaoDetalhada());
                System.out.println("------------------------------------------");
                numeroItem++;
            }
        }
        System.out.println("\n------------------------------------------");
        System.out.print("Pressione Enter para continuar...");
        InputHelper.lerString();

    }
}