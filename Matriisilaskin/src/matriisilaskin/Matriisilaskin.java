package matriisilaskin;

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
        Murtoluku[][] a = {{new Murtoluku(3, 5), new Murtoluku(1, 2)}, {new Murtoluku(4, 9), new Murtoluku(3, 2)}};
        Murtoluku[][] b = {{new Murtoluku(1), new Murtoluku(0)}, {new Murtoluku(0), new Murtoluku(1)}};
        Matriisi m = new Matriisi(a);
        Matriisi n = new Matriisi(b);
        System.out.println(m);
        System.out.println("");
        System.out.println(n);
        System.out.println("");
        System.out.println(m.mul(n));
        System.out.println("");
        System.out.println(m.add(n));
        System.out.println("");
        System.out.println(m.sub(n));
    }
}
