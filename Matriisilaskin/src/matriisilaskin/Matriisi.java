package matriisilaskin;

import java.util.Arrays;

/**
 * Matriisi jossa murtolukuja.
 * 
 * @author moversti
 */
public class Matriisi {

    private final Murtoluku[][] taulukko;

    public Matriisi(Murtoluku[][] taulukko) {
        this.taulukko = taulukko;
    }

    public Matriisi(int i, int j) {
        this(i, j, new Murtoluku(0));
    }

    public Matriisi(int i) {
        this(i, i);
    }

    public Matriisi(int i, int j, Murtoluku m) {
        taulukko = new Murtoluku[i][j];
        for (int k = 0; k < i; k++) {
            for (int l = 0; l < j; l++) {
                taulukko[k][l] = new Murtoluku(m.getOsoittaja(), m.getNimittaja());
            }
        }
    }

    public Murtoluku[][] getTaulukko() {
        return taulukko;
    }

    public Matriisi(int i, Murtoluku m) {
        this(i, i, m);
    }

    public Matriisi add(Matriisi m) {
        Murtoluku[][] summa = new Murtoluku[taulukko.length][taulukko[0].length];
        Murtoluku[][] toinenTaulukko = m.getTaulukko();
        for (int i = 0; i < summa.length; i++) {
            for (int j = 0; j < summa[0].length; j++) {
                summa[i][j] = taulukko[i][j].add(toinenTaulukko[i][j]);
            }
        }
        return new Matriisi(summa);
    }

    public Matriisi sub(Matriisi m) {
        Murtoluku[][] erotus = new Murtoluku[taulukko.length][taulukko[0].length];
        Murtoluku[][] toinenTaulukko = m.getTaulukko();
        for (int i = 0; i < erotus.length; i++) {
            for (int j = 0; j < erotus[0].length; j++) {
                erotus[i][j] = taulukko[i][j].sub(toinenTaulukko[i][j]);
            }
        }
        return new Matriisi(erotus);
    }

    public int getI() {
        return taulukko.length;
    }

    public int getJ() {
        return taulukko[0].length;
    }

    public Matriisi mul(Matriisi m) {
        if (getJ() != m.getI()) {
            throw new IllegalArgumentException();
        }
        Murtoluku[][] tulo = new Murtoluku[getI()][m.getJ()];
        Murtoluku[][] toinenTaulukko = m.getTaulukko();
        for (int i = 0; i < tulo.length; i++) {
            for (int j = 0; j < tulo[0].length; j++) {
                Murtoluku summa = new Murtoluku(0);
                for (int k = 0; k < getI(); k++) {
                    summa = summa.add(taulukko[i][k].mul(toinenTaulukko[k][j]));
                }
                tulo[i][j]=summa;
            }
        }
        return new Matriisi(tulo);
    }
    
    public Matriisi mul(Murtoluku m) {
        Murtoluku[][] asd = new Murtoluku[getI()][getJ()];
        for (int i = 0; i < getI(); i++) {
            for (int j = 0; j < getJ(); j++) {
                asd[i][j]=getCell(i, j).mul(m);
            }
        }
        return new Matriisi(asd);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getI(); i++) {
            for (int j = 0; j < getJ(); j++) {
                sb.append(String.format("%6.3f ", taulukko[i][j].toDouble()));
            }
            if (i!=getI()-1) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }
    
    public Murtoluku getCell(int i, int j){
        return taulukko[i][j];
    }
    
    public Murtoluku determinantti(){
        throw new UnsupportedOperationException();
    }
    
    public Matriisi inverse(){
        throw new UnsupportedOperationException();
    }
    
    public Matriisi transpoosi(){
        Murtoluku[][] asd = new Murtoluku[getI()][getJ()];
        for (int i = 0; i < getI(); i++) {
            for (int j = 0; j < getJ(); j++) {
                asd[i][j]=getCell(j, i);
            }
        }
        return new Matriisi(asd);
    }
}
