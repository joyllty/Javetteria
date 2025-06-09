package view;

import utils.InputHelper;

// junção de todos os menus
public class MenuInterativo {
    //#---------------- CORES ----------------#
    public static final String LAVENDER = "\u001B[38;5;183m";
    public static final String CREME = "\u001B[38;5;229m";
    public static final String BROWN = "\u001B[38;5;130m";
    public static final String RESET = "\u001B[0m";
    //---------------------------#--------------------------//

    // arte inicial do programa
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
        System.out.println(LAVENDER + "\n\n    ✧˖°. Seja bem-vinde a Javetteria! ✧˖°." + RESET);
    }

    // view menu principal
    public static void menuPrincipal(){
        int opPrincipal;
        do{

            System.out.println(CREME + "\n ╔═══════════════════════╗ ");
            System.out.println(" ║                       ║");
            System.out.println(" ║ [1] LOGIN             ║");
            System.out.println(" ║ [2] CADASTRO          ║");
            System.out.println(" ║ [3] SAIR              ║");
            System.out.println(" ║                       ║");
            System.out.println(" ╚═══════════════════════╝ ");

            System.out.print("\n" + (LAVENDER + ">>" + RESET) + CREME + " Selecione uma opção: ");
            opPrincipal = InputHelper.lerInt();


            switch(opPrincipal) {
                case 1 -> menuLogin(); // chama as opções de login
                    //ADICIONAR SLEEP
                case 2 -> System.out.println("Cadastrando cliente");
                    //ADICIONAR SLEEP
                case 3 -> System.out.println(LAVENDER + "\nSaindo do programa..." + RESET);
                    //ADICIONAR SLEEP
                default -> System.out.print("\n" + (LAVENDER + ">>" + RESET) + CREME + " Opção inválida! ");
            }

        } while (opPrincipal != 3);
    }

    // view menu login
    public static void menuLogin() {
        int opLogin;
        do {
            System.out.println(CREME + "\n ╔═══════════════════════╗ ");
            System.out.println(" ║                       ║");
            System.out.println(" ║ [1] CLIENTE           ║");
            System.out.println(" ║ [2] FUNCIONÁRIO       ║");
            System.out.println(" ║ [3] VOLTAR            ║");
            System.out.println(" ║                       ║");
            System.out.println(" ╚═══════════════════════╝ ");

            System.out.print("\n" + (LAVENDER + ">>" + RESET) + CREME + " Selecione como deseja logar: ");
            opLogin = InputHelper.lerInt();

            switch (opLogin) {
                case 1 -> new MenuCliente().executar();
                case 2 -> menuFuncionario();
                case 3 -> System.out.println("\nVoltando...");
                default -> System.out.print("\n" + (LAVENDER + ">>" + RESET) + CREME + " Opção inválida! ");
            }

        } while (opLogin != 3);
    }

    // view menu funcionário
    public static void menuFuncionario(){
        int op;

        do{
            System.out.println(CREME + "\n ╔═══════════════════════╗ ");
            System.out.println(" ║                       ║");
            System.out.println(" ║ [1] FUNCIONÁRIO       ║");
            System.out.println(" ║ [2] GERÊNCIA          ║");
            System.out.println(" ║ [3] VOLTAR            ║");
            System.out.println(" ║                       ║");
            System.out.println(" ╚═══════════════════════╝ ");

            System.out.print("\n" + (LAVENDER + ">>" + RESET) + CREME + " Selecione como deseja logar: ");
            op = InputHelper.lerInt();

            switch (op){
                case 1 -> new MenuFuncionario().executar();
                case 2 -> new MenuGerente().executar();
                case 3 -> System.out.println("\nVoltando...");
                default -> System.out.println("\n" + (LAVENDER + ">>" + RESET) + CREME + " Opção inválida!");
            }

        } while(op != 3);

    }
}
