package View;

import java.util.Scanner;

public class MenuInterativo {
    public static final String LAVENDER = "\u001B[38;5;183m";
    public static final String CREME = "\u001B[38;5;229m";
    public static final String BROWN = "\u001B[38;5;130m";
    public static final String RESET = "\u001B[0m";

    public static Scanner input = new Scanner(System.in);
    //---------------------------#--------------------------//

    public static void arteInicial(){
        System.out.print(LAVENDER + "================================================" + RESET);
        System.out.print(LAVENDER + "\n" +
                "     _                 _   _            _       \n" +
                "    | | __ ___   _____| |_| |_ ___ _ __(_) __ _ \n" +
                " _  | |/ _` \\ \\ / / _ \\ __| __/ _ \\ '__| |/ _` |\n" +
                "| |_| | (_| |\\ V /  __/ |_| ||  __/ |  | | (_| |\n" +
                " \\___/ \\__,_| \\_/ \\___|\\__|\\__\\___|_|  |_|\\__,_|\n" +
                "                                                \n" + RESET);
        System.out.println(LAVENDER + " \t\t\t\t   ((    ___    \n" +
                " \t\t\t\t    ))  \\___/_  \n" +
                " \t\t\t\t   |" + (BROWN + "~~" + RESET) + (LAVENDER + "| /" + RESET) +
                (BROWN + "~~~" + RESET) + (LAVENDER + "\\ \\" + RESET) + "\n" +
                "\t\t\t\t" + (LAVENDER + "  C|__| \\___/" + RESET));

        System.out.println(LAVENDER + "================================================" + RESET);
        System.out.println(LAVENDER + "\n\n    ✧˖°. Seja bem-vinde a Javetteria! ✧˖°.\n" + RESET);
    }

    public static void menuPrincipal(){
        int opPrincipal;
        do{

            System.out.println(CREME + "  _______________________ ");
            System.out.println(" |                       |");
            System.out.println(" | [1] LOGIN             |");
            System.out.println(" | [2] CADASTRO          |");
            System.out.println(" | [3] SAIR              |");
            System.out.println(" |                       |");
            System.out.println(" |_______________________| ");

            System.out.print("\n" + (LAVENDER + ">>" + RESET) + CREME + " Selecione uma opção: ");
            opPrincipal = input.nextInt();


            switch(opPrincipal) {
                case 1:
                    menuLogin();

                    //ADICIONAR SLEEP
                    break;
                case 2:
                    System.out.println("Cadastrando cliente");

                    //ADICIONAR SLEEP
                    break;
                case 3:
                    System.out.println(LAVENDER + "\nSaindo do programa..." + RESET);

                    //ADICIONAR SLEEP
                    break;

            }

        } while (opPrincipal != 3);
    }


    public static void menuLogin() {
        int opLogin;
        do {
            System.out.println(CREME + "  _______________________ ");
            System.out.println(" |                       |");
            System.out.println(" | [1] CLIENTE           |");
            System.out.println(" | [2] FUNCIONÁRIO       |");
            System.out.println(" | [3] VOLTAR            |");
            System.out.println(" |                       |");
            System.out.println(" |_______________________| ");

            System.out.print("\n" + (LAVENDER + ">>" + RESET) + CREME + " Selecione como deseja logar: ");
            opLogin = input.nextInt();

            switch (opLogin) {
                case 1:
                    int opCliente = 0;
                    System.out.println("logou como cliente");

                    MenuCliente.menuCliente(opCliente);
                    break;
                case 2:
                    System.out.println("logou como funcionario");

                    menuFuncionario();

                    break;
                case 3:
                    break;

                default:
                    System.out.print("\n" + (LAVENDER + ">>" + RESET) + CREME + "Opção inválida! Digite novamente: ");
                    opLogin = input.nextInt();
                    break;
            }

        } while (opLogin != 3);
    }

    public static void menuFuncionario(){
        int op;

        do{
            System.out.println(CREME + "  _______________________ ");
            System.out.println(" |                       |");
            System.out.println(" | [1] FUNCIONÁRIO       |");
            System.out.println(" | [2] GERÊNCIA          |");
            System.out.println(" | [3] VOLTAR            |");
            System.out.println(" |                       |");
            System.out.println(" |_______________________| ");

            System.out.print("\n" + (LAVENDER + ">>" + RESET) + CREME + " Selecione como deseja logar: ");
            op = input.nextInt();

            if(op == 1){
                MenuFuncionario.menuFuncionario();
            }
            if(op == 2){
                MenuGerente.menuGerente();
            }

        } while(op != 3);

    }
}
