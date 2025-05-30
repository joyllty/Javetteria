package Utils;

import java.util.Scanner;

public class InputHelper {

    static Scanner input = new Scanner(System.in);

    public static int lerInt(String texto){
        System.out.print(texto);
        int num = Integer.parseInt(input.nextLine());
        return num;
    }
    public static String lerString (String texto){
        System.out.print(texto);
       String txt = input.nextLine();
       return txt;
    }
    public static double lerDouble(String texto){
        System.out.print(texto);
        double num = Double.parseDouble(input.nextLine().replace(",", "."));
        return num;
    }
}
