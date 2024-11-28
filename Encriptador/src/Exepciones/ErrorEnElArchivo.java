package Exepciones;


public class ErrorEnElArchivo extends Throwable {
    public ErrorEnElArchivo() {
        throw new RuntimeException("Error al leer el archivo");
    }
}
