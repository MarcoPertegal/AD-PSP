package consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main1 {

    public static void main(String[] args) {
        //los consumer son inferfaces funcionales que sirven para realizar una operacion
        //con un objeto en especifico sin devolver nada
        //Un BiConsumer es lo mismo pero para trabajar con lista Clave Valor como los map
        Consumer<String> printer = new Consumer<String>() {
            @Override
            public void accept(String message) {
                System.out.println(message);
            }
        };

        printer.accept("Hola");

        //Lambdas, las inerfaces funcionales tienen que tener un solo metodo para que así la
        //lambda sepa a que metodo atacar se usa para crear clases con inferfaces funcionales
        //que solo van a usarse una vez
        //Parece que el sentido de la interfaz funcional(en este caso consumer) es permitir el
        // uso de una lambda para poder acortar el código lo máximo posible ya que realmente
        //la interfaz funcional consumer tiene un metodo abstracto muy simple
        Consumer <String> printer2 = message -> System.out.println(message);
        printer2.accept("Hola mundo desde lambda");

        List<String> names = new ArrayList<>();
        names.add("name1");
        names.add("name2");
        names.add("name3");


        for (String name : names) {
            System.out.println(name);
        }
        //esto imprime todos los nombres de la list es lo mismo que arriba con menos código
        //Si el cuerpo de la lambda tiene mas de una linea se usan llavesdentro de los parentesis
        names.forEach(name -> System.out.println(name));


    }
}
