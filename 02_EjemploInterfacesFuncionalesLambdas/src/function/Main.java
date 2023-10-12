package function;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        //se usa para tomar un argumento de entrada y devolver un resultado
        //recibe un dato/objeto y devuelve un ato/objeto, no tiene porque ser el mismo tipo de dato
        Function<String, Integer> extractLength = title -> title.length();

        Integer titleLength = extractLength.apply("Hola mundo");
        System.out.println(titleLength);
    }
}
