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
    private int m ,n;

    public LUHajotelma(Matriisi mat) {
        LU = mat.getTaulukkoKopio();
        m = mat.getI();
        n = mat.getJ();
        pivot = new int[m];
        for (int i = 0; i < m; i++) {
            pivot[i] = i;
        }
        pivotMerkki = 1;
        Murtoluku[] LURiviI;
        Murtoluku[] LUSarJ = new Murtoluku[m];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                LUSarJ[i] = LU[i][j];
            }
            for (int i = 0; i < m; i++) {
                LURiviI = LU[i];
                int kmax = Math.min(i, j);
                Murtoluku s = new Murtoluku(0);
                for (int k = 0; k < kmax; k++) {
                    s = s.add(LURiviI[k].mul(LUSarJ[k]));
                }
                LUSarJ[i] = LUSarJ[i].sub(s);
                LURiviI[j] = LUSarJ[i];
            }
            int p = j;
            for (int i = j + 1; i < m; i++) {
                if (Math.abs(LUSarJ[i].toDouble()) > Math.abs(LUSarJ[p].toDouble())) {
                    p = i;
                }
            }
            if (p != j) {
                for (int k = 0; k < n; k++) {
                    Murtoluku t = LU[p][k];
                    LU[p][k] = LU[j][k];
                    LU[j][k] = t;
                }
                int k = pivot[p];
                pivot[p] = pivot[j];
                pivot[j] = k;
                pivotMerkki = -pivotMerkki;
            }
            if (j < m & !LU[j][j].onNolla()) {
                for (int i = j + 1; i < m; i++) {
                    LU[i][j] = LU[i][j].div(LU[j][j]);
                }
            }
        }
    }

    public Murtoluku det() {
        Murtoluku d = new Murtoluku(pivotMerkki);
        for (int i = 0; i < n; i++) {
            d = d.mul(LU[i][i]);
        }
        return d;
    }

    public int getI() {
        return m;
    }

    public int getJ() {
        return n;
    }
}
