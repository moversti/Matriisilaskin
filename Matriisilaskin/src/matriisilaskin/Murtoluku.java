package matriisilaskin;

/**
 * Automaattisesti sievenevä murtoluku.
 *
 * @author moversti
 */
public class Murtoluku {

    private int osoittaja;
    private int nimittaja;

    public Murtoluku(int osoittaja, int nimittaja) {
        this.osoittaja = osoittaja;
        this.nimittaja = nimittaja;
        sievenna();
    }

    public Murtoluku(int osoittaja) {
        this(osoittaja, 1);
    }

    public Murtoluku add(Murtoluku m) {
        Murtoluku paluu = new Murtoluku(m.getNimittaja() * osoittaja + nimittaja * m.getOsoittaja(), nimittaja * m.getNimittaja());
        paluu.sievenna();
        return paluu;
    }

    public Murtoluku sub(Murtoluku m) {
        return add(m.vasta());
    }

    public Murtoluku mul(Murtoluku m) {
        Murtoluku paluu = new Murtoluku(m.getOsoittaja() * osoittaja, nimittaja * m.getNimittaja());
        paluu.sievenna();
        return paluu;
    }

    public Murtoluku div(Murtoluku m) {
        return mul(m.kaanteis());
    }

    public Murtoluku vasta() {
        return new Murtoluku(-osoittaja, nimittaja);
    }

    public Murtoluku kaanteis() {
        if (osoittaja != 0) {
            Murtoluku murtoluku = new Murtoluku(nimittaja, osoittaja);
            return murtoluku;
        }
        return new Murtoluku(0);
    }

    public int getOsoittaja() {
        return osoittaja;
    }

    public void setOsoittaja(int osoittaja) {
        this.osoittaja = osoittaja;
        sievenna();
    }

    public int getNimittaja() {
        return nimittaja;
    }

    public boolean setNimittaja(int nimittaja) {
        if (nimittaja != 0) {
            this.nimittaja = nimittaja;
            sievenna();
            return true;
        }
        return false;
    }

    public double toDouble() {
        return (double) osoittaja / (double) nimittaja;
    }

    @Override
    public String toString() {
        return String.format("[%i/%i]", osoittaja, nimittaja);
    }

    private void sievenna() {
        int SYT = SYT(osoittaja, nimittaja);
        osoittaja = osoittaja / SYT;
        nimittaja = nimittaja / SYT;
    }

    private int SYT(int a, int b) {
        while (b != 0) {
            int c = a;
            a = b;
            b = c % b;
        }
        return Math.abs(a);
    }
}
