import DecoEnco.Encriptar;
import Exepciones.EligioMalElIdiomaExcepcion;
import Texto.Letras;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Letras letras = new Letras();
        Encriptar encriptar = new Encriptar();

        System.out.println("Tenemos a su disponibilidad dos idiomas para la encriptacion: Español e ingles.\nCuál prefiere?");
        System.out.println("We have 2 lenguages available to encode: spanish and english. \nWhich one do you prefer?");
        String idiomaElegido = scanner.nextLine();

        try {
            if (idiomaElegido.toLowerCase().contains("español") || idiomaElegido.toLowerCase().contains("spanish") || idiomaElegido.toLowerCase().contains("english") || idiomaElegido.toLowerCase().contains("ingles")){
                letras.conversor(idiomaElegido);
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
        // está en construccion la decodificacion
        if(decoOEnco.toLowerCase().contains("encode")){
            System.out.println("What diceplacement do you want?");
            int desplazamiento = scanner.nextInt();
            letras.setDesplazamiento(desplazamiento);
            //encriptar.encriptacion();
        } else if(decoOEnco.toLowerCase().contains("codificar")){
            System.out.println("¿Qué desplazamiento prefieres?");
            int desplazamiento = scanner.nextInt();
            letras.setDesplazamiento(desplazamiento);
            //encriptar.encriptacion();
        } else if(decoOEnco.toLowerCase().contains("decode")){

        }else if(decoOEnco.toLowerCase().contains("decodificar")) {

        }



        // quiero hacer que si contiene español o ingles el idioma elegido pase la informacion a letras.conversor
        // Te falta el apartado para leer archivos, de mostrarlo, excepciones y saber qpd con los docs
        // con saber a qpd con los docs es que no sabes qué´corriemiento tienen. encriptarlos no es difícil
    }
}
