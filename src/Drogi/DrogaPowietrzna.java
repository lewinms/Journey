package Drogi;

import Mapa.ZmianyKierunku.MiejsceZmianyKierunku;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/** Klasa drogi powietrznej, ktora implementuje obiekt droga powietrzna.
 * Created by Lewin on 2015-10-18.
 */
public class DrogaPowietrzna extends Droga {
    /**
     * Konstruktor klasy droga powietrzna, ktory wykorzystuje konstruktor z odziedziczonej klasy.
     * @param poczatek poczatek drogi.
     * @param koniec koniec drogi.
     */
    public DrogaPowietrzna(MiejsceZmianyKierunku poczatek, MiejsceZmianyKierunku koniec,int poprawkaX, int poprawkaY) {
        super(poczatek, koniec,poprawkaX,poprawkaY);
    }
    public DrogaPowietrzna(){

    }
    @Override
    public void rysuj(Pane panel) {
        super.rysuj(panel);
        this.getImageNode().setStroke(Color.ORANGE);
        panel.getChildren().add(this.getImageNode());
    }
}
