package ohtu.verkkokauppa;

public class Pankki implements PankkiRajapinta {

    private KirjanpitoRajapinta kr;

    public Pankki(KirjanpitoRajapinta kr) {
        this.kr = kr;
    }

    @Override
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kr.lisaaTapahtuma("tilisiirto: tililtä " + tilille + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}
