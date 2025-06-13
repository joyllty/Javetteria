package utils;

import java.text.Normalizer;

public class Utils {

    public static String normalizarTexto(String texto) {
        return Normalizer.normalize(texto.toLowerCase(), Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
    }

}