import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        //adaptar el codigo a los write with  resources

        if (args.length != 2) {
            System.err.println("Error de sintaxis. Se necesitan dos argumentos");
            return;
        }


        BufferedInputStream bin = null;
        BufferedOutputStream bout = null;

        final int TAM = 1024 * 16;

        try {
            //bin = new BufferedInputStream(new FileInputStream("openwebinars.jpg"));
            //bout = new BufferedOutputStream(new FileOutputStream("image_copy.jpg"));
            bin = new BufferedInputStream(new FileInputStream(args[0]));
            bout = new BufferedOutputStream(new FileOutputStream(args[1]));

            int cantidadBytes = 0;
            byte[] buffer = new byte[TAM];

            //si lo llamamos con argumentos devuelve la cantidad de archivos que a leido
            //el primer argumento recibe lo queva a compiar
            //segundo donde va a emprezar la compia
            //tercero es los bytes que espera
            //el metodo read dev
            while ((cantidadBytes = bin.read(buffer, 0, TAM)) != -1) {
                bout.write(buffer, 0, cantidadBytes);
            }

            System.out.println("El fichero se ha copiado correctamente");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bin != null)
                try {
                    bin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (bout != null)
                try {
                    bout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }




    }
}
