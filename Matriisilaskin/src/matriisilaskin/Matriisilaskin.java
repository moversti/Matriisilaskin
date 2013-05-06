package matriisilaskin;

import java.math.BigInteger;
import util.Matriisi;
import util.Murtoluku;

/**
 * Matriisilaskin joka osaa laskea (rationaaliluku) matriisejen yhteen-,
 * vähennys-, ja kertolaskun, kääntämisen, transpoosin ja determinantin.
 *
 * @author moversti
 */
public class Matriisilaskin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Matriisi m = new Matriisi(3, 4, new Murtoluku(1, 3));
        System.out.println(m);
    }
}
