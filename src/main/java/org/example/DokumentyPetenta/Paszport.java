package org.example.DokumentyPetenta;

import org.example.DaneGryDoGenerowania.ZbiorTwarzy;

import java.util.Arrays;

public class Paszport {

    private String[] twarzPetenta;
    private String imie;
    private String[]  dataUrodzin ;
    private String miejsceWydaniaPaszportu ;
    private String[] dataWygasnieciaPaszportu ;
    private String krajPochodzenia;
    private String kodPaszportu;

    protected Integer kodBledu = 0;

    public Paszport() {
        this.twarzPetenta = ZbiorTwarzy.getTwarz();
        this.imie = "TestImie TestNazwisko";
        this.dataUrodzin = new String[]{"26", "8", "2002"};
        this.miejsceWydaniaPaszportu = "Test";
        this.dataWygasnieciaPaszportu = new String[]{"14", "1", "2024"};
        this.krajPochodzenia = "ARZTOCKA";
        this.kodPaszportu = "ABCD-1234";
        this.kodBledu = 0;
    }

    public Paszport(
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
        this.kodBledu = kodBledu;
    }





    //GETTER I SETTER OGOLNY RAZEM Z TOSTRING

    public void setDanePaszportu(
            String imie,
            String[] dataUrodzin,
            String miejsceWydaniaPaszportu,
            String[] dataWygasnieciaPaszportu,
            String krajPochodzenia,
            String kodPaszportu,
            int kodBledu
    ){
        this.imie = imie;
        this.dataUrodzin = dataUrodzin;
        this.miejsceWydaniaPaszportu = miejsceWydaniaPaszportu;
        this.dataWygasnieciaPaszportu = dataWygasnieciaPaszportu;
        this.krajPochodzenia = krajPochodzenia;
        this.kodPaszportu = kodPaszportu;
        this.kodBledu = 0;
    };

    @Override
    public String toString() {
        return imie + "/" + Arrays.toString(dataUrodzin) + "/" + miejsceWydaniaPaszportu + "/" + Arrays.toString(dataWygasnieciaPaszportu) + "/" + krajPochodzenia + "/" + kodPaszportu;
    }//TODO: PRZYSTOSOWAĆ TOSTRING DO WYPISYWANIA KONSOLI
    public String[] getTwarzPetenta(){ //WYPISYWANIE TWARZa
        return twarzPetenta;
    }


    //GETTERY I SETTERY



    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }
    public String[] getDataUrodzin() {
        return dataUrodzin;
    }

    public void setDataUrodzin(String[] dataUrodzin) {
        this.dataUrodzin = dataUrodzin;
    }

    public String getMiejsceWydaniaPaszportu() {
        return miejsceWydaniaPaszportu;
    }

    public void setMiejsceWydaniaPaszportu(String miejsceWydaniaPaszportu) {
        this.miejsceWydaniaPaszportu = miejsceWydaniaPaszportu;
    }

    public String[] getDataWygasnieciaPaszportu() {
        return dataWygasnieciaPaszportu;
    }

    public void setDataWygasnieciaPaszportu(String[] dataWygasnieciaPaszportu) {
        this.dataWygasnieciaPaszportu = dataWygasnieciaPaszportu;
    }

    public String getKrajPochodzenia() {
        return krajPochodzenia;
    }

    public void setKrajPochodzenia(String krajPochodzenia) {
        this.krajPochodzenia = krajPochodzenia;
    }

    public String getKodPaszportu() {
        return kodPaszportu;
    }

    public void setKodPaszportu(String kodPaszportu) {
        this.kodPaszportu = kodPaszportu;
    }
}
