package ohtu.intjoukkosovellus;


public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] taulukko;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        taulukko = new int[KAPASITEETTI];
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        taulukko = new int[kapasiteetti];
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;

    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        taulukko = new int[kapasiteetti];
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (this.kuuluu(luku)) {
            return false;
        }
        taulukko[alkioidenLkm] = luku;
        alkioidenLkm++;
        if (alkioidenLkm == taulukko.length) {
            int[] apu = taulukko.clone();
            taulukko = new int[alkioidenLkm + kasvatuskoko];
            kopioiTaulukko(apu, taulukko);
            return true;
        }
        return true;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < taulukko.length; i++) {
            if (taulukko[i] == luku) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        int[] apu = new int[taulukko.length];
        int laskuri = 0;
        for (int i = 0; i < taulukko.length; i++) {
            if (taulukko[i] != luku) {
                apu[laskuri] = taulukko[i];
                laskuri++;
            }
        }
        if (laskuri == taulukko.length) {
            return false;
        } else {
            taulukko = apu.clone();
            alkioidenLkm--;
        }
        return true;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        String tuloste = "{}";
        if (alkioidenLkm == 0) {
            return tuloste;
        }
        tuloste = String.valueOf(taulukko[0]);
        for (int i = 1; i < alkioidenLkm; i++) {
            tuloste += ", " + String.valueOf(taulukko[i]);
        }
        return "{" + tuloste + "}";
    }
    

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = taulukko[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdiste = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            yhdiste.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            yhdiste.lisaa(bTaulu[i]);
        }
        return yhdiste;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkaus = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    leikkaus.lisaa(bTaulu[j]);
                }
            }
        }
        return leikkaus;

    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko erotus = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            erotus.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            erotus.poista(bTaulu[i]);
        }
        return erotus;
    }

}
