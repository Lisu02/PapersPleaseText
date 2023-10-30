package org.example.DokumentyPetenta;

import org.example.DaneGryDoGenerowania.Dystrykty;

import java.util.Arrays;
import java.util.Random;

public class DowodOsobisty {



    private String imie;
    private String dystrykt;
    private String[] dataUrodzenia;
    private Integer wzrost;
    private Integer waga;
    Random generator = new Random();


    public DowodOsobisty(String imie, String[] dataUrodzenia,int kodBledu) {
        this.imie = imie;
        dystrykt = Dystrykty.getDystrykt(kodBledu);
        this.dataUrodzenia = dataUrodzenia;
        wzrost = generator.nextInt(35) + 160;
        waga = generator.nextInt(35) + 55;
    }
    public DowodOsobisty(int kodBledu){
        //TODO: DYSTRYKT ORAZ MIEJSCE WYDANIA PASZPORTU
        imie = "TestImie";
        dataUrodzenia = new String[]{"15", "2", "1999"};
        dystrykt=Dystrykty.getDystrykt(kodBledu);
        wzrost = generator.nextInt(35) + 160;
        waga = generator.nextInt(35) + 55;
    }

    @Override
    public String toString() {
        return imie + "/" + dystrykt + "/" + Arrays.toString(dataUrodzenia) + "/" + wzrost + "/" + waga;
    }//TODO: PRZYSTOSOWAĆ TOSTRING DO WYPISYWANIA KONSOLI

}
