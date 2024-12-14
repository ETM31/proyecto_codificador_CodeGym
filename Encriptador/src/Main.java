import EntradasSalidas.Archivos;
import EntradasSalidas.Letras;

import java.nio.file.Path;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Archivos archivos = new Archivos();
        String desplazamiento;

        System.out.println("Tenemos a su disponibilidad dos idiomas para la encriptacion: Español e ingles.\nCuál prefiere?");
        String idiomaElegido = scanner.nextLine();

        //decido si decodifico o codifico
        System.out.println("¿Qué prefieres? codificar o decodificar archivo");
        String decoOEnco = scanner.nextLine();

        // mando si codifico o decodifico
        // está en construccion la decodificacion***
       if(decoOEnco.toLowerCase().contains("codificar")){
            System.out.println("¿Qué desplazamiento prefieres?");
            desplazamiento = scanner.nextLine();

            System.out.println("Desea usar una direccion ya existente o prefiere crearla? \nEscriba \"existente\" o \"Crear\"");
            String crearOUsar = scanner.nextLine();

            if(crearOUsar.toLowerCase().contains("existente")){
                System.out.println("Escriba la dirección a la que desea acceder para cambiar el texto");
                System.out.println("ejemplo: c:/Usuarios/77593/Documentos/readme.txt");
                String direccion = scanner.nextLine();
                archivos.cambiadorTexto(direccion,desplazamiento,idiomaElegido);
            }else if(crearOUsar.toLowerCase().contains("crear")){
                System.out.println("Escriba la dirección junto con el nombre del archivo que desea crear");
                System.out.println("ejemplo: c:/Usuarios/77593/Documentos/readme.txt");
                String direccion = scanner.nextLine();
                archivos.crearDirectorio(direccion);
                System.out.println("Escribe el texto que te gustaría que contenga el archivo a codificar"); // enviar texto al archivo
                String textoArchivoCreado = scanner.nextLine();
                Path archivoCreado = Path.of(direccion);
                archivos.escribirArchivo(textoArchivoCreado, archivoCreado);//*********** Envio la direccion y el texto
                archivos.cambiadorTexto(direccion, desplazamiento, idiomaElegido);
            }
        } /*else if(decoOEnco.toLowerCase().contains("decodificar")) {

        } else {
            throw new RunTimeExcepcion("asegurese que haya elegido alguna ocion de nuestro menu");
        }
        */

    }
}
