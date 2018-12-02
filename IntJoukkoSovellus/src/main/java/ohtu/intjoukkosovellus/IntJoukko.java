
package ohtu.intjoukkosovellus;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class IntJoukko {
    private HashSet<Integer> luvut; 


    public IntJoukko(){
        luvut = new HashSet<Integer>();
    }

    public boolean lisaa(int luku) {
        if (luvut.contains(luku)){
            return false;
        }
        luvut.add(luku);
        return true;
    }


    public boolean poista(int luku) {
        if (!luvut.contains(luku)){
            return false;
        }
        luvut.remove(luku);
        return true;
    }

    public boolean kuuluu(int luku){
        return luvut.contains(luku);
    }

    public int mahtavuus() {
        return luvut.size();
    }


    @Override
    public String toString() {
        String tuotos = "{";
        int [] luvut = toSortedIntArray();
        for (int i=0; i<luvut.length; ++i){
            if (i>0) tuotos+=", ";
            tuotos+=luvut[i];
        }
        tuotos += "}";
        return tuotos;
    }

    public Set<Integer> getLuvut(){
        return luvut;
    }

    public int[] toIntArray(){
        int[] luvut = new int[mahtavuus()];
        int i = 0;
        for (int luku : getLuvut()){
            luvut[i++]=luku;
        }
        return luvut;
    }

    public int[] toSortedIntArray(){
        int[] luvut = toIntArray();
        Arrays.sort(luvut);
        return luvut;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        for (int luku : a.getLuvut()){
            x.lisaa(luku);
        }
        for (int luku : b.getLuvut()){
            x.lisaa(luku);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        for (int luku : a.getLuvut()){
            if (b.kuuluu(luku)){
                x.lisaa(luku);
            }
        }
        return x;
    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        for (int luku : a.getLuvut()){
            if (!b.kuuluu(luku)){
                x.lisaa(luku);
            }
        }
        return x;
    }
        
}