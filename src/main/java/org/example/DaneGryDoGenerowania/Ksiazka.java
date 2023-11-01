package org.example.DaneGryDoGenerowania;

public class Ksiazka {

    private static String[][] strony;

    static{
        String[] stronaWstepu = {
                "Zawróć",
                "PODSTAWOWE ZASADY",
                "MAPA PAŃSTW",

        };
        String[] stronaZasad = {
                "Zawróć",
                "Petenci muszą mieć paszport",
                "Obywatele muszą mieć dowód osobisty",
                "Cudzoziemcy muszą mieć zgode na wjazd",
                "Wszystkie dane między dokumentami muszą się zgadzać",
                "Miejsca wydania i dystrykty muszą być prawidłowe"

        };
        String[] stronaPanstw = {
                "Zawróć",
                "ARZTOCKA",
                "KOLECHIA",
                "ZJEDNOCZONA FEDERACJA"

        };
        String[] stronaPanstwWydanieArztocka = {
                "Zawróć",
                "Miasta wydające paszport",
                "Orvech Vonor",
                "Wsch.Grestin",
                "Paradizna",
                "Dystrykty",
                "Ałtan",
                "Vescillo",
                "Burnton",
                "Octovalis",
                "Gennistora",
                "Lendiforma",
                "Wozenfield",
                "Fardesto"
        };
        String[] stronaPanstwWydanieKolechia = {
                "Zawróć",
                "Miasta wydajace paszport",
                "Skal",
                "Lorndaz",
                "Mergerous"

        };
        String[] stronaPanstwWydanieZjednoczonaFederacja = {
                "Zawróć",
                "Miasta wydające paszport",
                "Great Rapid",
                "Shingleton",
                "KoristaCity"

        };
    }


    public static String[] getStrona(String nazwaStrony){
        switch (nazwaStrony){
            case "stronaWstepu":
                return strony[0];
            case "stronaZasad":
                return strony[1];
            case "stronaPanstw":
                return strony[2];
            case "stronaPanstwWydanieArztocka":
                return  strony[3];
            case "stronaPanstwWydanieKolechia":
                return strony[4];
            case "stronaPanstwWydanieZjednoczonaFederacja":
                return strony[5];
            case "Zawróć":
                return strony[0];
        }
        return null;
    }
}
