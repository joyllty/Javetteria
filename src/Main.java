import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    //#---------------- CORES ----------------#
    public static final String LAVENDER = "\u001B[38;5;183m";
    public static final String AZUL = "\u001B[38;5;159m";
    public static final String CREME = "\u001B[38;5;229m";
    public static final String ROSA = "\u001B[38;5;218m";
    public static final String BROWN = "\u001B[38;5;130m";
    public static final String RESET = "\u001B[0m";

    //---------------------------#--------------------------//


    public static void main(String[] args) {

        model.Estoque.inicializarEstoque();
        view.MenuInterativo.arteInicial();

        view.MenuInterativo.menuPrincipal();


    }
}