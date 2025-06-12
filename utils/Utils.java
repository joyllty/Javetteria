package utils;

import java.text.Normalizer;

public class Utils {
    /**
     * Normaliza um texto removendo acentos e convertendo para minúsculas
     * @param texto O texto a ser normalizado
     * @return O texto normalizado (sem acentos e em minúsculas)
     */
    public static String normalizarTexto(String texto) {
        return Normalizer.normalize(texto.toLowerCase(), Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
    }

    /**
     * Verifica se dois textos são iguais ignorando acentos e case
     * @param texto1 Primeiro texto
     * @param texto2 Segundo texto
     * @return true se os textos forem iguais ignorando acentos e case
     */
    public static boolean textosIguais(String texto1, String texto2) {
        return normalizarTexto(texto1).equals(normalizarTexto(texto2));
    }
} 