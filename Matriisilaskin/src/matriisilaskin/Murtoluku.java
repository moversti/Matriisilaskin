package matriisilaskin;

/**
 * Automaattisesti sievenevä murtoluku.
 *
 * @author Mikko Översti
 */
public class Murtoluku {

    /**
     *
     */
    private int osoittaja;
    /**
     *
     */
    private int nimittaja;

    /**
     *
     * @param osoittaja
     * @param nimittaja
     */
    public Murtoluku(int osoittaja, int nimittaja) {
        this.osoittaja = osoittaja;
        this.nimittaja = nimittaja;
        sievenna();
    }

    /**
     *
     * @param osoittaja
     */
    public Murtoluku(int osoittaja) {
        this(osoittaja, 1);
    }

    public boolean onNolla() {
        if (osoittaja == 0) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param m
     * @return
     */
    public Murtoluku add(Murtoluku m) {
        Murtoluku paluu = new Murtoluku(m.getNimittaja() * osoittaja + nimittaja * m.getOsoittaja(), nimittaja * m.getNimittaja());
        paluu.sievenna();
        return paluu;
    }

    /**
     *
     * @param m
     * @return
     */
    public Murtoluku sub(Murtoluku m) {
        return add(m.vasta());
    }

    /**
     *
     * @param m
     * @return
     */
    public Murtoluku mul(Murtoluku m) {
        Murtoluku paluu = new Murtoluku(m.getOsoittaja() * osoittaja, nimittaja * m.getNimittaja());
        paluu.sievenna();
        return paluu;
    }

    /**
     *
     * @param m
     * @return
     */
    public Murtoluku div(Murtoluku m) {
        return mul(m.kaanteis());
    }

    /**
     *
     * @return
     */
    public Murtoluku vasta() {
        return new Murtoluku(-osoittaja, nimittaja);
    }

    /**
     *
     * @return
     */
    public Murtoluku kaanteis() {
        if (osoittaja != 0) {
            Murtoluku murtoluku = new Murtoluku(nimittaja, osoittaja);
            return murtoluku;
        }
        return new Murtoluku(0);
    }

    /**
     *
     * @return
     */
    public int getOsoittaja() {
        return osoittaja;
    }

    /**
     *
     * @return
     */
    public int getNimittaja() {
        return nimittaja;
    }

    /**
     *
     * @return
     */
    public double toDouble() {
        return (double) osoittaja / (double) nimittaja;
    }

    @Override
    public String toString() {
        if (nimittaja != 1 && nimittaja != -1) {
            return String.format("[%s/%s]", osoittaja, nimittaja);
        }
        return String.format("[%s]", osoittaja);
    }

    /**
     *
     */
    private void sievenna() {
        int SYT = SYT(osoittaja, nimittaja);
        osoittaja /= SYT;
        nimittaja /= SYT;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    private int SYT(int a, int b) {
        int d = a;
        int e = b;
        while (e != 0) {
            int c = d;
            d = e;
            e = c % e;
        }
        return Math.abs(d);
    }
}
