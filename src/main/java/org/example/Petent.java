package org.example;

import org.example.DaneGryDoGenerowania.*;
import org.example.DokumentyPetenta.DowodOsobisty;
import org.example.DokumentyPetenta.Paszport;
import org.example.DokumentyPetenta.PozwolenieNaWjazd;

import javax.xml.crypto.Data;
import java.util.Arrays;

public class Petent {




    private String imie;
    private String[]  dataUrodzin;
    private String miejsceWydaniaPaszportu;
    private String[] dataWygasnieciaPaszportu;
    private String krajPochodzenia;
    private String kodPaszportu;

    private int kodBledu; //Petent
    private Paszport paszport;
    private PozwolenieNaWjazd pozwolenieNaWjazd;
    private DowodOsobisty dowodOsobisty;

    //TODO:GENEROWANIE PETENTÓW AUTOMATYCZNIE (PRZYPADKOWE SCENARIUSZE)
    public Petent() {
        this.krajPochodzenia = Panstwa.getPanstwo();
        this.kodBledu = KodyBledowe.wygenerujKodBledu(krajPochodzenia);
        this.imie = ImionaPetentow.getImie();
        this.dataUrodzin = RandomDataUrodzenia.getDataUrodzenia();
        this.dataWygasnieciaPaszportu = DataWaznosci.generateRandomDataWaznosciString().split("/");


        this.kodPaszportu = KodPaszportu.getKodPaszportu();

        this.miejsceWydaniaPaszportu = MiastaWydajaceDokument.getMiasto(this.krajPochodzenia,kodBledu);
        paszport = new Paszport();
        paszport.setDanePaszportu(ImionaPetentow.giveImie(this.imie,kodBledu),dataUrodzin,MiastaWydajaceDokument.getMiasto(krajPochodzenia,kodBledu),dataWygasnieciaPaszportu,krajPochodzenia,kodPaszportu,this.kodBledu);
        if(krajPochodzenia.equals("ARZTOCKA")){dowodOsobisty = new DowodOsobisty(imie,dataUrodzin,kodBledu);}
        else {pozwolenieNaWjazd = new PozwolenieNaWjazd(imie,KodPaszportu.giveKodPaszportu(kodPaszportu,kodBledu),kodBledu);}

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
        else {pozwolenieNaWjazd = new PozwolenieNaWjazd(imie,kodPaszportu,kodBledu);}
    }

    @Override
    public String toString(){
        return imie + "/" + Arrays.toString(dataUrodzin) + "/" + miejsceWydaniaPaszportu + "/" + Arrays.toString(dataWygasnieciaPaszportu) + "/" + krajPochodzenia + "/" + kodPaszportu;
    }

    public int getKodBledu(){
        return kodBledu;
    }
    public Paszport getPaszport(){
        return paszport;
    }
    public DowodOsobisty getDowodOsobisty(){
        return dowodOsobisty;
    }
    public PozwolenieNaWjazd getPozwolenieNaWjazd(){
        return pozwolenieNaWjazd;
    }


}
