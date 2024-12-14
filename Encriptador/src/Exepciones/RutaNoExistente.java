package Exepciones;

public class RutaNoExistente extends RuntimeException{
    public RutaNoExistente(){
        super("La ruta no existe, rectifiquela o creela en el menu");
    }
}
