package org.example;

import java.util.Arrays;

public class Petent {

    private String imie;

    private String[]  dataUrodzin;

    private String miejsceWydaniaPaszportu;

    private String[] dataWygasnieciaPaszportu;

    private String krajPochodzenia;
    private String kodPaszportu;
    private Paszport paszport;

    public Petent() {
        this.imie = "TestImie TestNazwisko";
        this.dataUrodzin = new String[]{"26", "8", "2002"};
        this.miejsceWydaniaPaszportu = "Test";
        this.dataWygasnieciaPaszportu = new String[]{"14", "1", "2024"};
        this.krajPochodzenia = "ARZTOCKA";
        this.kodPaszportu = "ABCD-1234";
        paszport = new Paszport();
    }

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
    }

    @Override
    public String toString(){
        return imie + "/" + Arrays.toString(dataUrodzin) + "/" + miejsceWydaniaPaszportu + "/" + Arrays.toString(dataWygasnieciaPaszportu) + "/" + krajPochodzenia + "/" + kodPaszportu;
    }




}
