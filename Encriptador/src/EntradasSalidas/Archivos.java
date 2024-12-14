package EntradasSalidas;

import Exepciones.RutaNoExistente;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
// Te falta el desencriptador, pero ya mero we, ánimo, sí lo sacas
/*
Ya quedó el codificador, ya incluso crea archivos con el texto codificado. Te falta el deco que npi de cómo hacerlo
y te falta tmb manejo de excepciones en algunos lugares, ya haz hecho gran parte de eso, pero aún así, ya sabes que al
final harás ll tu código para que te haga todos los errores que pueda para optimizar el código
 */

public class Archivos extends Letras{
    StringBuilder stringBuilder = new StringBuilder();
    Path path;
    String camino = null;


    public Archivos() {
    }

    public void crearDirectorio(String direccion) {
        this.camino = direccion;
        path = Path.of(camino);// pongo el camino que nos interesa usar
        // Crea los directorios si no existen
        if (!Files.exists(path.getParent())) {
            try {
                Files.createDirectories(path.getParent());
            } catch (IOException e) {
                throw new RuntimeException("Error al generar el directorio del archivo"+e);
            }
            System.out.println("Directorios creados: " + path.getParent());
        } else {
            System.out.println("El archivo ya existe");
        }

        crearArchivo(path);

    }

    public void crearArchivo(Path path){
        // Crea el archivo si no existe
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new RuntimeException("Error al crear el archivo"+e);
            }
            System.out.println("Archivo creado: " + path);
        } else {
            System.out.println("El archivo ya existe: " + path);
        }
    }

    public Path crearDireccionEncriptado(/*Path direccion*/){
        Path padreDirectorio = path.getParent();
        Path nombreArchivo = path.getFileName();
        String nombreArchivoString = nombreArchivo.toString(); // para poder manipular el nombre
        int indexTipoArchivo = nombreArchivoString.lastIndexOf("."); // identifico el tipo de archivo
        String nombreArchivoSinTipoDoc = nombreArchivoString.substring(0,indexTipoArchivo); // nombre solo de archivo
        String tipoArchivo = nombreArchivoString.substring(indexTipoArchivo); // me da el tipo de archivo
        String nuevoNombre = nombreArchivoSinTipoDoc + "Encriptado" + tipoArchivo; // le doy un nuevo nombre al archivo

        Path nuevoPath = padreDirectorio.resolve(nuevoNombre); // creo el nuevo directorio adicionano el nuevo nombre del nuevo archivo
        crearArchivo(nuevoPath); //** la comento porque ahorita no quiero que me cree ningún documento
        return nuevoPath;
    }

    //FALTA SER MÁS DETALLADO EN LAS EXCEPCIONES ACÁ
    public void escribirArchivo(String texto, Path direccion){
        // Escribe contenido en el archivo
        try {
            Files.writeString(direccion, texto, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Hubo un error al escribir en el archivo"+e);
        }
        System.out.println("Contenido escrito en el archivo.");
    }

     public void cambiadorTexto(String camino, String desplazamiento, String idioma) {
         //hago una conversion en la que me permite pasar lo que no sea un número con un string en blanco, esto me
         // permite que escriba lo que escriba el usuario siempre tenga algún desplazamiento, el problema es que si
         // ponen varios números se hará el desplazamiento de todos los números que pongan
         String desplazar = desplazamiento.replaceAll("\\D", "");
         int desplazarInt = Integer.parseInt(desplazar);

         super.setDesplazamiento(desplazarInt);
         super.conversor(idioma);

         this.camino=camino;
         this.path = Path.of(camino);// pongo el camino que nos interesa usar
         if(!Files.exists(path))
             throw new RuntimeException("La ruta no existe, rectifica la ruta o creala en el menu");

         char [] idiomaLista;
         if(idioma.toLowerCase().contains("español")){
             idiomaLista = LETRASESPAÑOL;
         } else if(idioma.toLowerCase().contains("ingles")){
             idiomaLista = LETRASINGLES;
         } else {
             throw new RutaNoExistente();
         }

        // Lee el contenido del archivo y lo muestra
         List<String> list;
         try {
             list = Files.readAllLines(path);
         } catch (IOException e) {
             throw new RuntimeException("Error al leer el archivo"+e);
         }

         for (String str : list) {
            for(int i=0 ; i<str.length() ; i++) {
                char letrita = str.charAt(i); // convierto el string a char
                // aquí haces la conversion si alguna de las letras coinside con el vocabulario que usamos
                for (int j = 0; j < idiomaLista.length; j++) {
                    //aquí checa si la latra pertenece al abecedario, sino lo manda por un tubo
                    if (letrita == idiomaLista[j]) {
                        char[] cambioChar = super.getLetrasConvertidas(); // Traigo el vocabulario con los desplazamientos
                        letrita = cambioChar[j];
                        break; // ESTE BREAK ES NECESARIO PORQUE CUANDO SE CUMPLE LA CONDICION YA NO SIGUE SOBREPENSANDO
                        // ASÍ PASA A LA SIGUIENTE LETRA
                    }
                }
                stringBuilder.append(letrita);
            }
        }
         //convierto el StringBuilder a String para que escribir archivo cree otro documento
         String nuevoDoc = stringBuilder.toString();
         // saco la direccion del archivo encriptado para enviarla a "escribirArchivo"
         Path direccion = crearDireccionEncriptado();
         escribirArchivo(nuevoDoc, direccion);
     }
}
