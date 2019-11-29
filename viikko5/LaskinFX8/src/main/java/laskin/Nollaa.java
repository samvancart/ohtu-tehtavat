package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento {

    private TextField tuloskentta;
    private TextField syotekentta;
    private Button nollaa;
    private Button undo;
    private Sovelluslogiikka sovellus;

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }

    @Override
    void suorita() {
        sovellus.nollaa();
        int laskunTulos = sovellus.tulos();

        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
        nollaa.disableProperty().set(true);

    }

    @Override
    void peru() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
