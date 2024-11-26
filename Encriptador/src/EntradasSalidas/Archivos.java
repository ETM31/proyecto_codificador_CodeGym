package EntradasSalidas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
 // YA HACE LA CONVERSION, AHORA POR FAVOR HAZ QUE NO SIEMPRE ESTE ESCRIBIENDO O LEYENDO
// Debes ya de hacer que este busine trabaje como quieres, debes pasar lo que te da el StringBuilder a un .txt y ya tendrás el encriptador completo
// Te falta el desencriptador, pero ya mero we, ánimo, sí lo sacas
/*
Debes hallar la forma de que se conecte con letras y sus funciones, al ser una clase hija no deberías tener problemas
porque puedes acceder a las variables y métodos de la padre, solo debes llamarla en el lugar correcto y con los datos
correctos, si necesitas hacer pruebas edita el deplazamiento en Letras, modificas en el contructor
 */

public class Archivos extends Letras{
    StringBuilder stringBuilder = new StringBuilder();

     public StringBuilder trabajarArchivo() throws IOException {
        // Define la ruta del archivo
        Path path = Path.of("c:/Usuarios/77593/Documentos/readme.txt");

        // Crea los directorios si no existen
        if (!Files.exists(path.getParent())) {
            Files.createDirectories(path.getParent());
            System.out.println("Directorios creados: " + path.getParent());
        }

        // Crea el archivo si no existe
        if (!Files.exists(path)) {
            Files.createFile(path);
            System.out.println("Archivo creado: " + path);
        } else {
            System.out.println("El archivo ya existe: " + path);
        }
        /*

        // Escribe contenido en el archivo
        Files.writeString(path, "la prueba pasó, se escribió\n", StandardOpenOption.APPEND);
        System.out.println("Contenido escrito en el archivo.");
        */

        // Lee el contenido del archivo y lo muestra
        List<String> list = Files.readAllLines(path);
        for (String str : list) {
            for(int i=0 ; i<str.length() ; i++) {
                char letrita = str.charAt(i); // convierto el string a char
                // aquí haces la conversion si alguna de las letras coinside con el vocabulario que usamos
                for (int j = 0; j < LETRASESPAÑOL.length; j++) {
                    //aquí checa si la latra pertenece al abecedario, sino lo manda por un tubo
                    if (letrita == LETRASESPAÑOL[j]) {
                        char[] cambioChar = super.getLetrasConvertidas(); // Traigo el vocabulario con los desplazamientos
                        letrita = cambioChar[j];
                        break; // ESTE BREAK ES NECESARIO PORQUE CUANDO SE CUMPLE LA CONDICION YA NO SIGUE SOBREPENSANDO
                        // ASÍ PASA A LA SIGUIENTE LETRA
                    }
                }
                stringBuilder.append(letrita);
            }
        }
         return stringBuilder;
     }

     // ZONA DE PRUEBAS ***SE VA A ELIMINAR****
    public static void main(String[] args) throws IOException {
        Archivos archivos = new Archivos();
        //System.out.println(archivos.trabajarArchivo()); // Muestra el stringBuilder de la funcion (la encriptacion)
        //System.out.println(archivos.getLetrasConvertidas()); // me da el abecedario desplazado
        //System.out.println(LETRASESPAÑOL); // me da el abecedario real
    }
}
