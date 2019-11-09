package ohtu.verkkokauppa;

public class Kauppa {

    private VarastoRajapinta vr;
    private PankkiRajapinta pr;
    private Ostoskori ostoskori;
    private ViitegeneraattoriRajapinta vgr;
    private String kaupanTili;

    public Kauppa(PankkiRajapinta pr,VarastoRajapinta vr,ViitegeneraattoriRajapinta vgr) {
        this.vr = vr;
        this.pr = pr;
        this.vgr = vgr;
        kaupanTili = "33333-44455";
    }

    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    public void poistaKorista(int id) {
        Tuote t = vr.haeTuote(id); 
        vr.palautaVarastoon(t);
    }

    public void lisaaKoriin(int id) {
        if (vr.saldo(id)>0) {
            Tuote t = vr.haeTuote(id);             
            ostoskori.lisaa(t);
            vr.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = vgr.uusi();
        int summa = ostoskori.hinta();
        
        return pr.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}
