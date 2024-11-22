package Texto;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Letras {
    //27 LETRAS
    private final List<Character> LETRASESPAÑOL = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
    //26 LETRAS
    private final List<Character> LETRASINGLES = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
    private final String TEXTOERROR = "Lo ingresado no está en nuestro catálogo, por favor ingresa algo de nuestro sistema";
    private int desplazamiento;
    private List<Character> letrasConvertidas = new ArrayList<>();

    public Letras() {
        this.desplazamiento = 0;
    }


    public void setDesplazamiento(int desplazamiento) {
        this.desplazamiento = desplazamiento+1; // Le sumo una constante de uno porque los arrays inician en 0, no en 1
    }
    
    public void conversor(String selector) {
        if (selector.toLowerCase().contains("español") || selector.toLowerCase().contains("spanish")) {
            moviemiento(LETRASESPAÑOL);
        } else if (selector.toLowerCase().contains("english") || selector.toLowerCase().contains("ingles")) {
            moviemiento(LETRASINGLES);
        } else System.out.println(TEXTOERROR);
    }

    // Movimiento del disco
    public void moviemiento(List<Character> lista){
        List<Character> copia = new ArrayList<>(lista);
        for (int i = 0; i < lista.size(); i++) {
            if(desplazamiento==lista.size())
                desplazamiento=0;
            letrasConvertidas.add(i, copia.get(desplazamiento));
            desplazamiento++;
        }
        System.out.println(letrasConvertidas);// Para comprobar si hace los corrimientos o no
    }
}
