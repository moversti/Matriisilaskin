package matriisilaskin;

/**
 * Matriisi jossa murtolukuja. Osaa laskea kaikkea kivaa.
 *
 * @author Mikko Översti.
 */
public class Matriisi {
    
    /**
     *
     * @param koko
     * @return
     */
    public static Matriisi yksikkoMatriisi(int koko) {
        Murtoluku[][] asd = new Murtoluku[koko][koko];
        for (int i = 0; i < koko; i++) {
            for (int j = 0; j < koko; j++) {
                Murtoluku m;
                if (i == j) {
                    m = new Murtoluku(1);
                } else {
                    m = new Murtoluku(0);
                }
                asd[i][j] = m;
            }
        }
        return new Matriisi(asd);
    }

    /**
     *
     */
    private final Murtoluku[][] taulukko;

    /**
     *
     * @param taulukko
     */
    public Matriisi(Murtoluku[][] taulukko) {
        this.taulukko = taulukko;
    }

    /**
     *
     * @param i
     * @param j
     */
    public Matriisi(int i, int j) {
        this(i, j, new Murtoluku(0));
    }

    /**
     *
     * @param i
     */
    public Matriisi(int i) {
        this(i, i);
    }

    /**
     *
     * @param i
     * @param j
     * @param m
     */
    public Matriisi(int i, int j, Murtoluku m) {
        taulukko = new Murtoluku[i][j];
        for (int k = 0; k < i; k++) {
            for (int l = 0; l < j; l++) {
                taulukko[k][l] = m.kopio();
            }
        }
    }

    /**
     *
     * @param i
     * @param m
     */
    public Matriisi(int i, Murtoluku m) {
        this(i, i, m);
    }

    /**
     *
     * @return
     */
    public Murtoluku[][] getTaulukkoKopio() {
        Murtoluku[][] paluu = new Murtoluku[getI()][getJ()];
        for (int i = 0; i < getI(); i++) {
            for (int j = 0; j < getJ(); j++) {
                paluu[i][j] = taulukko[i][j];
            }
        }
        return paluu;
    }

    /**
     *
     * @param m
     * @return
     */
    public Matriisi add(Matriisi m) {
        Murtoluku[][] summa = new Murtoluku[taulukko.length][taulukko[0].length];
        Murtoluku[][] toinenTaulukko = m.getTaulukkoKopio();
        for (int i = 0; i < summa.length; i++) {
            for (int j = 0; j < summa[0].length; j++) {
                summa[i][j] = taulukko[i][j].add(toinenTaulukko[i][j]);
            }
        }
        return new Matriisi(summa);
    }

    /**
     *
     * @param m
     * @return
     */
    public Matriisi sub(Matriisi m) {
        Murtoluku[][] erotus = new Murtoluku[taulukko.length][taulukko[0].length];
        Murtoluku[][] toinenTaulukko = m.getTaulukkoKopio();
        for (int i = 0; i < erotus.length; i++) {
            for (int j = 0; j < erotus[0].length; j++) {
                erotus[i][j] = taulukko[i][j].sub(toinenTaulukko[i][j]);
            }
        }
        return new Matriisi(erotus);
    }

    /**
     *
     * @return
     */
    public int getI() {
        return taulukko.length;
    }

    /**
     *
     * @return
     */
    public int getJ() {
        return taulukko[0].length;
    }

    /**
     *
     * @param m
     * @return
     */
    public Matriisi mul(Matriisi m) {
        if (getJ() != m.getI()) {
            throw new IllegalArgumentException();
        }
        Murtoluku[][] tulo = new Murtoluku[getI()][m.getJ()];
        Murtoluku[][] toinenTaulukko = m.getTaulukkoKopio();
        for (int i = 0; i < tulo.length; i++) {
            for (int j = 0; j < tulo[0].length; j++) {
                Murtoluku summa = new Murtoluku(0);
                for (int k = 0; k < getI(); k++) {
                    summa = summa.add(taulukko[i][k].mul(toinenTaulukko[k][j]));
                }
                tulo[i][j] = summa;
            }
        }
        return new Matriisi(tulo);
    }

    /**
     *
     * @param m
     * @return
     */
    public Matriisi mul(Murtoluku m) {
        Murtoluku[][] kerrottu = new Murtoluku[getI()][getJ()];
        for (int i = 0; i < getI(); i++) {
            for (int j = 0; j < getJ(); j++) {
                kerrottu[i][j] = getCell(i, j).mul(m);
            }
        }
        return new Matriisi(kerrottu);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getI(); i++) {
            for (int j = 0; j < getJ(); j++) {
//                sb.append(String.format("%6.3f ", taulukko[i][j].toDouble()));
                sb.append(taulukko[i][j].toString());
            }
            if (i != getI() - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /**
     *
     * @param i
     * @param j
     * @return
     */
    public Murtoluku getCell(int i, int j) {
        return taulukko[i][j];
    }

    /**
     *
     * @return
     */
    public Murtoluku determinantti() {
        return new LUHajotelma(this).det();
    }

    /**
     *
     * @return
     */
    public Matriisi kaanna() {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @return
     */
    public Matriisi transpoosi() {
        Murtoluku[][] asd = new Murtoluku[getI()][getJ()];
        for (int i = 0; i < getI(); i++) {
            for (int j = 0; j < getJ(); j++) {
                asd[i][j] = getCell(j, i);
            }
        }
        return new Matriisi(asd);
    }
}
