package view;

import utils.Cores;
import utils.InputHelper;

public class MenuInterativo {

    public static void arteInicial(){
        System.out.print(Cores.LAVENDER + "================================================" + Cores.RESET);
        System.out.print(Cores.LAVENDER + "\n" +
                "     _                 _   _            _       \n" +
                "    | | __ ___   _____| |_| |_ ___ _ __(_) __ _ \n" +
                " _  | |/ _` \\ \\ / / _ \\ __| __/ _ \\ '__| |/ _` |\n" +
                "| |_| | (_| |\\ V /  __/ |_| ||  __/ |  | | (_| |\n" +
                " \\___/ \\__,_| \\_/ \\___|\\__|\\__\\___|_|  |_|\\__,_|\n" +
                "                                                \n" + Cores.RESET);
        System.out.println(Cores.LAVENDER + " \t\t\t\t   ((    ___    \n" +
                " \t\t\t\t    ))  \\___/_  \n" +
                " \t\t\t\t   |" + (Cores.BROWN + "~~" + Cores.RESET) + (Cores.LAVENDER + "| /" + Cores.RESET) +
                (Cores.BROWN + "~~~" + Cores.RESET) + (Cores.LAVENDER + "\\ \\" + Cores.RESET) + "\n" +
                "\t\t\t\t" + (Cores.LAVENDER + "  C|__| \\___/" + Cores.RESET));

        System.out.println(Cores.LAVENDER + "================================================" + Cores.RESET);
        System.out.println(Cores.LAVENDER + "\n\n    ✧˖°. Seja bem-vinde a Javetteria! ✧˖°." + Cores.RESET);
    }

    public static void menuPrincipal(){
        int opPrincipal;
        do{
            System.out.println(Cores.CREME + "\n ╔════════════════════════╗ ");
            System.out.println(" ║                        ║");
            System.out.println(" ║ [1] LOGIN              ║");
            System.out.println(" ║ [2] CADASTRO           ║");
            System.out.println(" ║ [0] SAIR               ║");
            System.out.println(" ║                        ║");
            System.out.println(" ╚════════════════════════╝ ");

            System.out.print("\n" + (Cores.LAVENDER + ">>" + Cores.RESET) + Cores.CREME + " Selecione uma opção: ");
            opPrincipal = InputHelper.lerInt();


            switch(opPrincipal) {
                case 1 -> Acessar.realizarLogin();
                case 2 -> menuCadastro();
                case 0 -> System.out.println(Cores.LAVENDER + "\nSaindo do programa..." + Cores.RESET);
                default -> System.out.print("\n" + (Cores.LAVENDER + ">>" + Cores.RESET) + Cores.CREME + " Opção inválida! ");
            }

        } while (opPrincipal != 0);
    }

    public static void menuCadastro() {
        int opCadastro;

            System.out.println(Cores.CREME + "\n ╔════════════════════════╗ ");
            System.out.println(" ║                        ║");
            System.out.println(" ║ [1] CLIENTE            ║");
            System.out.println(" ║ [2] FUNCIONÁRIO        ║");
            System.out.println(" ║ [3] GERENTE            ║");
            System.out.println(" ║ [0] SAIR               ║");
            System.out.println(" ║                        ║");
            System.out.println(" ╚════════════════════════╝ ");

            System.out.print("\n" + (Cores.LAVENDER + ">>" + Cores.RESET) + Cores.CREME + " Selecione quem deseja cadastrar: ");
            opCadastro = InputHelper.lerInt();

            if (opCadastro != 0) {
                Acessar.exibirCadastro(opCadastro);
                return;
            }

        }

}