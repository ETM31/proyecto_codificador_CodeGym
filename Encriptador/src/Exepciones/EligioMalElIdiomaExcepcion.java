package Exepciones;

public class EligioMalElIdiomaExcepcion extends Throwable {

    public EligioMalElIdiomaExcepcion(){
        super("The user didn't choose any of the languages supported");
    }
}
