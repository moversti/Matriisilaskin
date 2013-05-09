package matriisilaskin;

/**
 * Matriisilaskin joka osaa laskea (rationaaliluku) matriisejen yhteen-,
 * vähennys-, ja kertolaskun, kääntämisen, transpoosin ja determinantin.
 *
 * @author Mikko Översti
 */
public class Matriisilaskin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Murtoluku[][] a = {{new Murtoluku(2), new Murtoluku(5)}, {new Murtoluku(3), new Murtoluku(6)}};
        System.out.println(new Matriisi(a).determinantti());
//        Murtoluku[][] b = {{new Murtoluku(1), new Murtoluku(0)}, {new Murtoluku(0), new Murtoluku(1)}};
//        Matriisi m = new Matriisi(a);
//        Matriisi n = new Matriisi(b);
//        System.out.println(m);
//        System.out.println("");
//        System.out.println(n);
//        System.out.println("");
//        System.out.println(m.mul(n));
//        System.out.println("");
//        System.out.println(m.add(n));
//        System.out.println("");
//        System.out.println(m.sub(n));

    }
}
