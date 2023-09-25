package predicate;

import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        //Se usan para Filtrar datos devuelve verdadero o falso
        //nombre mayor de 5 y menor que 15
        Predicate<String> validateName = name -> name.length() > 5 && name.length() < 15;
        System.out.println(validateName.test("Marco"));

        //filatrado de nombre listOf es un metodo que se usa para crear y devolver un
        //lista inmutable
        List <String> names = List.of("Marco", "Fernado", "Laura");

        //For each con lamda que filtra verdadero y falso según la condición de la interfaz
        names.forEach(name -> {
            if (validateName.test(name))
                System.out.println(name);
        });

        //Lo suyo es usar la api stream que es la que nos proporciona filtros
        //el metodo filter acepta condiciones booleanas o interfaces predicate por lo que
        //esto seria lo mismo que lo de arriba con menos código
        names.stream()
                .filter(validateName)
                .forEach(name -> System.out.println(name));


    }

}
