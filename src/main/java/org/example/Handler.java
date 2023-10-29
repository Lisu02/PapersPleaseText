package org.example;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Handler {
    //KLASA DO OBSŁUGI WYBORU OPCJI
    //

    private Gra gra;
    private Terminal terminal;
    private Menu menu;
    private TextGraphics textGraphics;

    public Handler(Terminal terminal){
        this.terminal = terminal;
    }
    public void addMenu(Menu menu){this.menu = menu;}
    public void addTextGraphics(TextGraphics textGraphics){this.textGraphics = textGraphics;}

    protected boolean handleOptionSelection(String opcja) throws IOException {

        switch(opcja){
            case "WYJDZ Z GRY":
                System.out.println("WYJDZ Z GRY");
                terminal.bell();
                terminal.close();
                break;
            case "OPCJE":
                System.out.println("OPCJE");
                menu.printOpcje(0);
                menu.klawiszeOpcje();
                break;
            case "NOWA GRA":
                System.out.println("NOWA GRA");
                //Inicjalizacja gry oraz dodanie do menu obiektów
                menu.printGra(new Petent());
                menu.klawiszeGra();
                break;
            case "OPCJA 1":
                terminal.bell();
                textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
                System.out.println("OPCJE -> OPCJA 1");
                break;
            case "OPCJA 2":
                terminal.bell();
                terminal.setBackgroundColor(new TextColor.RGB(90,255,90));
                System.out.println("OPCJE -> OPCJA 2");
                break;
            case "WRÓĆ":
                System.out.println("WRÓĆ");
                menu.printMenu(2); //TODO BLAD Z WYJSCIA MENU
                return false;
            //klawiszeMenu();
            //break;
            case "ZATWIERDŹ WIZE":
                terminal.bell();
                System.out.println("ZATWIERDŹ WIZE");
                menu.printGra(new Petent());
                //menu.zmienPetent();
                break;
            case "ODRZUĆ WIZE":
                terminal.bell();
                System.out.println("ODRZUĆ WIZE");
                menu.printGra(new Petent());
                //menu.zmienPetent();
                break;
            case "PODSTAWOWE ZASADY":
                System.out.println("PODSTAWOWE ZASADY");
                break;
            case "REGIONY":
                System.out.println("REGIONY");
                break;
        }
        return true;
    }
}
