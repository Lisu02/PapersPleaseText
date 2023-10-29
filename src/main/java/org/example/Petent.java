package org.example;

import org.example.DaneGryDoGenerowania.ImionaPetentow;
import org.example.DaneGryDoGenerowania.MiastaWydajaceDokument;
import org.example.DaneGryDoGenerowania.Panstwa;
import org.example.DokumentyPetenta.DowodOsobisty;
import org.example.DokumentyPetenta.Paszport;
import org.example.DokumentyPetenta.PozwolenieNaWjazd;

import java.util.Arrays;

public class Petent {




    private String imie;
    private String[]  dataUrodzin;
    private String miejsceWydaniaPaszportu;
    private String[] dataWygasnieciaPaszportu;
    private String krajPochodzenia;
    private String kodPaszportu;

    private int kodBledu;
    private Paszport paszport;
    private PozwolenieNaWjazd pozwolenieNaWjazd;
    private DowodOsobisty dowodOsobisty;

    //TODO:GENEROWANIE PETENTÓW AUTOMATYCZNIE (PRZYPADKOWE SCENARIUSZE)
    public Petent() {
        this.imie = ImionaPetentow.getImie();
        this.dataUrodzin = new String[]{"26", "8", "2002"};

        this.dataWygasnieciaPaszportu = new String[]{"14", "1", "2024"};
        this.krajPochodzenia = Panstwa.getPanstwo();
        this.miejsceWydaniaPaszportu = MiastaWydajaceDokument.getMiasto(this.krajPochodzenia,kodBledu);
        this.kodPaszportu = "ABCD-1234";
        this.kodBledu = 0;
        paszport = new Paszport();
        paszport.setDanePaszportu(ImionaPetentow.giveImie(this.imie,kodBledu),dataUrodzin,this.miejsceWydaniaPaszportu,dataWygasnieciaPaszportu,krajPochodzenia,kodPaszportu,this.kodBledu);
        if(krajPochodzenia.equals("ARZTOCKA")){dowodOsobisty = new DowodOsobisty(kodBledu);}
        else {pozwolenieNaWjazd = new PozwolenieNaWjazd();}

    }

    //TODO:GENEROWANIE PETENTÓW RĘCZNIE (WŁASNE SCENARIUSZE)
    public Petent(
            String imie,
            String[] dataUrodzin,
            String miejsceWydaniaPaszportu,
            String[] dataWygasnieciaPaszportu,
            String krajPochodzenia,
            String kodPaszportu,
            Integer kodBledu
    ) {
        this.imie = imie;
        this.dataUrodzin = dataUrodzin;
        this.miejsceWydaniaPaszportu = miejsceWydaniaPaszportu;
        this.dataWygasnieciaPaszportu = dataWygasnieciaPaszportu;
        this.krajPochodzenia = krajPochodzenia;
        this.kodPaszportu = kodPaszportu;
        paszport = new Paszport(imie,dataUrodzin,miejsceWydaniaPaszportu,dataWygasnieciaPaszportu,krajPochodzenia,kodPaszportu,kodBledu);
        if(krajPochodzenia.equals("ARZTOCKA")){dowodOsobisty = new DowodOsobisty(imie,dataUrodzin,kodBledu);}
        else {pozwolenieNaWjazd = new PozwolenieNaWjazd();}
    }

    @Override
    public String toString(){
        return imie + "/" + Arrays.toString(dataUrodzin) + "/" + miejsceWydaniaPaszportu + "/" + Arrays.toString(dataWygasnieciaPaszportu) + "/" + krajPochodzenia + "/" + kodPaszportu;
    }




}
