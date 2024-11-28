package EntradasSalidas;

public class Letras {
    //27 LETRAS
    public static final char[] LETRASESPAÑOL = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    //26 LETRAS
    public static final char[] LETRASINGLES = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private int desplazamiento;
    private char[] letrasConvertidas;

    public Letras() {
        this.desplazamiento = 0;
    }

    public void setDesplazamiento(int desplazamiento) {
        this.desplazamiento = desplazamiento+1; // Le sumo una constante de uno porque los arrays inician en 0, no en 1
    }

    public char[] getLetrasConvertidas() {
        // Esto lo usé para hacer pruebas y que el codificador funcinara, si lo necesitas revivelas
        //letrasConvertidas = new char[LETRASESPAÑOL.length];
        //moviemiento(LETRASESPAÑOL);
        return letrasConvertidas;
    }

    public void conversor(String selector) {
        String TEXTOERROR = "Lo ingresado no está en nuestro catálogo, por favor ingresa algo de nuestro sistema";
        if (selector.toLowerCase().contains("español") || selector.toLowerCase().contains("spanish")) {
            letrasConvertidas = new char[LETRASESPAÑOL.length];
            moviemiento(LETRASESPAÑOL);
        } else if (selector.toLowerCase().contains("english") || selector.toLowerCase().contains("ingles")) {
            letrasConvertidas = new char[LETRASINGLES.length];
            moviemiento(LETRASINGLES);
        } else System.out.println(TEXTOERROR);
    }

    // Movimiento del disco
    public void moviemiento(char[] lista){
        //char[] copia = lista; // no hace falta porque es redondante, la usaba la copia donde dice "lista[desplazamiento]"
        for (int i = 0; i < lista.length; i++) {
            if(desplazamiento==lista.length)
                desplazamiento=0;
            letrasConvertidas[i] = lista[desplazamiento];
            desplazamiento++;
        }
    }
}
