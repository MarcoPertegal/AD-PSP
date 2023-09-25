package supplier;

import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        //sirve para generar datos
        //no recibe nada y genera un resultdo
        //Crea nuevos datos a los que se les puede ascociar cierta informacion
        Supplier<Double> generator = () -> Math.random();
        System.out.println(generator.get());

        Supplier<Integer> generator2 = () -> new Random().nextInt(500 + 1);
        System.out.println(generator.get());

        //UUID genera ids aleatorios
        Supplier<String> uuidGenerator = () -> UUID.randomUUID().toString();
        System.out.println(uuidGenerator.get());

        //crea un objeto Persona
        Supplier<Person> personGenerator = () -> new Person();

    }
}
