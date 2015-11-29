package Pojazdy.Powietrzne;

import Drogi.DrogaPowietrzna;
import Mapa.Swiat;
import Mapa.ZmianyKierunku.MiejsceZmianyKierunku;
import Mapa.ZmianyKierunku.Przystanki.LotniskoCywilne;
import Mapa.ZmianyKierunku.Przystanki.Miasto;
import Mapa.ZmianyKierunku.Przystanki.Przystanek;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lewin on 2015-10-18.
 */
public class SamolotPasazerski extends Samolot {
    private static List<Object> listaGdzieMozeLadowac = new ArrayList<Object>();
    public SamolotPasazerski(int dlugosc, int szerokosc, int maksymalnaPredkosc, int liczbaPersonelu, int maksymalnaIloscPaliwa, int aktualnaIloscPaliwa) {
        super( dlugosc, szerokosc, maksymalnaPredkosc, liczbaPersonelu, maksymalnaIloscPaliwa, aktualnaIloscPaliwa);
        if(SamolotPasazerski.getListaGdzieMozeLadowac().isEmpty()){
            SamolotPasazerski.addListaGdzieMozeLadowac(new Miasto());
            SamolotPasazerski.addListaGdzieMozeLadowac(new LotniskoCywilne());
        }
        LinkedList<Przystanek> listaMozliwychPrzystankow = new LinkedList<Przystanek>();
        listaMozliwychPrzystankow.addAll(Swiat.getInstance().getListaLotniskCywilnych());
        listaMozliwychPrzystankow.addAll(Swiat.getInstance().getListaMiast());
//        System.out.println("dlugosc listy przystankow " + listaMozliwychPrzystankow.size());
        okreslNowePolozenie(listaMozliwychPrzystankow);
        tworzenieTrasy(this.getPrzystanekPoczatkowy(),this.getPrzystanekDocelowy());
        wypisywanieTrasy(this.getTrasa());
        this.getObecnePolozenie().addPojazdOczekujacy(this);
//        LinkedList<MiejsceZmianyKierunku> testList = new LinkedList<MiejsceZmianyKierunku>();
//        for (int i = 0; i < Swiat.getInstance().getListaMiejscZmianyKierunku().size(); i++) {
//            testList.add(Swiat.getInstance().getListaMiejscZmianyKierunku().get(i));
//        }
//        this.setTrasa(testList);
    }
    public static List<Object> getListaGdzieMozeLadowac() {
        return listaGdzieMozeLadowac;
    }

    public static void setListaGdzieMozeLadowac(List<Object> listaLadowisk) {
        SamolotPasazerski.listaGdzieMozeLadowac = listaLadowisk;
    }

    public static void addListaGdzieMozeLadowac(Object listaLadowisk){
        SamolotPasazerski.listaGdzieMozeLadowac.add(listaLadowisk);
    }

    public static void removeListaGdzieMozeLadowac(Object listaLadowisk){
        SamolotPasazerski.listaGdzieMozeLadowac.remove(listaLadowisk);
    }

    @Override
    public Przystanek nastepneMozliweLadowanie(List<MiejsceZmianyKierunku> trasa, MiejsceZmianyKierunku obecnePolozenie) {
        return this.nastepnyPrzystanekZTrasy(trasa,obecnePolozenie, SamolotPasazerski.getListaGdzieMozeLadowac());
    }

    @Override
    public void tworzenieTrasy(MiejsceZmianyKierunku przystanekPoczatkowy, MiejsceZmianyKierunku przystanekDocelowy){
        this.poinformujORezygnacjiPrzyjazdu(this.getTrasa());
        this.getTrasa().clear();
        this.getPozostalaTrasa().clear();
        this.setTrasa(szukanieTrasy(przystanekPoczatkowy,przystanekDocelowy,new DrogaPowietrzna()));
        if (this.getTrasa()==null){
            return;
        }
        this.getPozostalaTrasa().addAll(this.getTrasa());
        this.poinformujOZamiarzePrzyjazdu(this.getTrasa());
        this.setNastepnyPrzystanek(this.nastepneMozliweLadowanie(this.getTrasa(),this.getObecnePolozenie()));
    }
}