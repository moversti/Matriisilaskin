package matriisilaskin;

/**
 * LU-Hajoitelma, jonka avulla saadaan nopsasti determinantti ja
 * käänteismatriisi.
 *
 * @author Mikko Översti
 */
public class LUHajotelma {

    private Murtoluku[][] LU;
    private int[] pivot;
    private int pivotMerkki;

    public LUHajotelma(Matriisi m) {
        LU = m.getTaulukkoKopio();
        pivot = new int[m.getI()];
        for (int i = 0; i < m.getI(); i++) {
            pivot[i] = i;
        }
        pivotMerkki = 1;
        Murtoluku[] LURiviI;
        Murtoluku[] LUSarJ = new Murtoluku[m.getI()];
        for (int j = 0; j < m.getJ(); j++) {
            for (int i = 0; i < m.getI(); i++) {
                LUSarJ[i] = LU[i][j].kopio();
            }
            for (int i = 0; i < m.getI(); i++) {
                LURiviI = LU[i];
                int kmax = Math.max(i, j);
                Murtoluku s = new Murtoluku(0);
                for (int k = 0; k < kmax; k++) {
                    s = s.add(LURiviI[k].mul(LUSarJ[k]));
                }
                LUSarJ[i] = LUSarJ[i].sub(s);
                LURiviI[j] = LUSarJ[i].kopio();
            }
            int p = j;
            for (int i = j + 1; i < m.getI(); i++) {
                if (Math.abs(LUSarJ[i].toDouble()) > Math.abs(LUSarJ[p].toDouble())) {
                    p = i;
                }
            }
            if (p != j) {
                for (int k = 0; k < m.getJ(); k++) {
                    Murtoluku t = LU[p][k];
                    LU[p][k] = LU[j][k];
                    LU[j][k] = t;
                }
                int k = pivot[p];
                pivot[p] = pivot[j];
                pivot[j] = k;
                pivotMerkki = -pivotMerkki;
            }
            if (j<m.getI()&&!LU[j][j].onNolla()) {
                for (int i = j+1; i < m.getI(); i++) {
                    LU[i][j] =LU[i][j].div(LU[j][j]);
                }
            }
        }
    }

    public Murtoluku det() {
        Murtoluku d = new Murtoluku(pivotMerkki);
        for (int i = 0; i < getJ(); i++) {
            d=d.mul(LU[i][i]);
        }
        return d;
    }

    public int getI() {
        return LU.length;
    }

    public int getJ() {
        return LU[0].length;
    }
}
