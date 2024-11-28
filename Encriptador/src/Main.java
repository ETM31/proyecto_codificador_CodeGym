import EntradasSalidas.Archivos;
import Exepciones.EligioMalElIdiomaExcepcion;
import EntradasSalidas.Letras;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Letras letras = new Letras();
        Archivos archivos = new Archivos();
        String seleccionIdioma;

        System.out.println("Tenemos a su disponibilidad dos idiomas para la encriptacion: Español e ingles.\nCuál prefiere?");
        System.out.println("We have 2 lenguages available to encode: spanish and english. \nWhich one do you prefer?");
        String idiomaElegido = scanner.nextLine();

        try {
            if (idiomaElegido.toLowerCase().contains("español") || idiomaElegido.toLowerCase().contains("spanish") || idiomaElegido.toLowerCase().contains("english") || idiomaElegido.toLowerCase().contains("ingles")){
                seleccionIdioma = idiomaElegido;
            }else {
                throw new EligioMalElIdiomaExcepcion();
            }
        } catch (EligioMalElIdiomaExcepcion e) {
            throw new RuntimeException("No ha elegido ningún idioma, favor de intentar de nuevo" + e);
        }

        //decido si decodifico o codifico
        if (idiomaElegido.toLowerCase().contains("español") || idiomaElegido.toLowerCase().contains("spanish")){
            System.out.println("¿Qué prefieres? codificar o decodificar archivo");
        }else if(idiomaElegido.toLowerCase().contains("english") || idiomaElegido.toLowerCase().contains("ingles")){
            System.out.println("What do you prefer? to encode or to decode a file");
        }
        String decoOEnco = scanner.nextLine();

        // mando si codifico o decodifico
        // está en construccion la decodificacion***
        if(decoOEnco.toLowerCase().contains("encode")){
            System.out.println("What diceplacement do you want?");
            int desplazamiento = scanner.nextInt();
            letras.setDesplazamiento(desplazamiento);
        } else if(decoOEnco.toLowerCase().contains("codificar")){
            System.out.println("¿Qué desplazamiento prefieres?");
            int desplazamiento = scanner.nextInt();
            scanner.nextLine();// se agrega esta linea debido al enter que le doy para enviar el archivo
            // cuando le doy enter el teclado lo lee, pero la entrada .nextInt() no lo lee y lo envía a mi siguiente
            // entrada (crearOUsar)

            //**letras.setDesplazamiento(desplazamiento);
            System.out.println("Desea usar una direccion ya existente o prefiere crearla? \nEscriba \"existente\" o \"Crear\"");
            String crearOUsar = scanner.nextLine();

            if(crearOUsar.toLowerCase().contains("existente")){
                System.out.println("Escriba la dirección a la que desea acceder para cambiar el texto");
                String direccion = scanner.nextLine();
                archivos.cambiadorTexto(direccion,desplazamiento,seleccionIdioma);
            }else if(crearOUsar.toLowerCase().contains("crear")){
                System.out.println("Escriba la dirección junto con el nombre del archivo que desea crear");
                String direccion = scanner.nextLine();//*********
                archivos.crearDirectorio(direccion);
            }
        } /*else if(decoOEnco.toLowerCase().contains("decode")){

        }else if(decoOEnco.toLowerCase().contains("decodificar")) {

        }*/

    }
}
