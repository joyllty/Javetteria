package controller;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import model.Estoque;
import model.Ingrediente;


public class EstoqueController {
    //#---------------- CORES ----------------#
    public static final String LAVENDER = "\u001B[38;5;183m";
    public static final String CREME = "\u001B[38;5;229m";
    public static final String BROWN = "\u001B[38;5;130m";
    public static final String RESET = "\u001B[0m";
    //---------------------------#--------------------------//

    public static List<Ingrediente> listarItens() {
        return Estoque.getIngredientes();
    }

    public static void adicionarItem(int id, String nome, int quantidade, String unidade) {
        Estoque.adicionar(new Ingrediente(id, nome, quantidade, unidade));
    }

    public static boolean removerItem(int id){
        return Estoque.remover(id);
    }

    public static void atualizarItem(int id, int quantidade){
        Estoque.atualizarQuantidade(id, quantidade);
    }

    public static void exportarEstoque() {
        List<Ingrediente> ingredientes = Estoque.getIngredientes();
        // otimizar a escrita em arquivos
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("data/estoque.txt"))){ // filewriter sobrescreve o arquivo
            escritor.write("========== ESTOQUE ==========\n");

            for (Ingrediente i : ingredientes) {
                escritor.write("→ ID: " + i.getId() + "\n");
                escritor.write("Nome: " + i.getNome() + "\n");
                escritor.write("Quantidade: " + i.getQuantidade() + "\n");
                escritor.write("Unidade: " + i.getUnidade() + "\n\n");

                escritor.write("==============================\n");
            }
            view.EstoqueView.mostrarMensagem((LAVENDER + "\n>>" + RESET) + CREME + " Estoque exportado com sucesso!");

        } catch (IOException e){
            // IOException -> erros de entrada e saida
            view.EstoqueView.mostrarMensagem((LAVENDER + "\n>>" + RESET) + CREME + " Erro ao exportar o estoque: " + e.getMessage());
            // getMessage -> mensagem descritiva do erro

        }
       // escritor.close(); -> o try ja fecha o escritor
    }

}
