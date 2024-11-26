package Exepciones;

import java.io.IOException;

public class ErrorEnElArchivo extends Throwable {
    public ErrorEnElArchivo(IOException e) {
        super(e);
    }
}
