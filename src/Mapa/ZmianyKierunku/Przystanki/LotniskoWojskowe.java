package Mapa.ZmianyKierunku.Przystanki;

import Gui.MainPanel;
import Mapa.Swiat;
import Pojazdy.TworzeniePojazdu;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


/**
 * Created by Lewin on 2015-10-18.
 */
public class LotniskoWojskowe extends Lotnisko implements TworzeniePojazdu {
    public LotniskoWojskowe(String nazwa, double dlugosc, double szerokosc, double polozenieX, double polozenieY, boolean zajetaPrzestrzen, double maksymalnaPojemnosc) {
        super(nazwa,dlugosc, szerokosc, polozenieX, polozenieY, zajetaPrzestrzen, maksymalnaPojemnosc);
        this.setColor(Color.RED);
        this.rysuj(MainPanel.getGrupaMiejscZmianyKierunku());
        Swiat.getInstance().addLotniskoWojskowe(this);
    }
    public LotniskoWojskowe(){

    }

    @Override
    public void stworz() {

    }

//    @Override
//    public void rysuj(Group group) {
//        super.rysuj(group);
//        this.getImageNode().setStroke(Color.RED);
//        this.getImageNode().setFill(Color.RED);
////        group.getChildren().add(this.getImageNode());
//        this.getOutRing().setStroke(Color.RED);
//        this.getOutRing().setFill(Color.TRANSPARENT);
//        this.getOutRing().setStrokeWidth(this.getPromien()/2);
//        group.getChildren().add(this.getImageNode());
//        group.getChildren().add(this.getOutRing());
//
////        this.getImageNode().
//    }
}
