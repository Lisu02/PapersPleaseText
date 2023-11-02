package org.example;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.graphics.TextImage;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.example.DaneGryDoGenerowania.Ksiazka;
import org.example.DokumentyPetenta.Paszport;

import java.io.IOException;
import java.util.Arrays;

import static java.util.Objects.isNull;

public class Menu {

    String[] obrazek =
            {       "██████╗  █████╗ ██████╗ ███████╗██████╗ ███████╗    ██████╗ ██╗     ███████╗ █████╗ ███████╗███████╗\n",
                    "██╔══██╗██╔══██╗██╔══██╗██╔════╝██╔══██╗██╔════╝    ██╔══██╗██║     ██╔════╝██╔══██╗██╔════╝██╔════╝\n",
                    "██████╔╝███████║██████╔╝█████╗  ██████╔╝███████╗    ██████╔╝██║     █████╗  ███████║███████╗█████╗  \n",
                    "██╔═══╝ ██╔══██║██╔═══╝ ██╔══╝  ██╔══██╗╚════██║    ██╔═══╝ ██║     ██╔══╝  ██╔══██║╚════██║██╔══╝  \n",
                    "██║     ██║  ██║██║     ███████╗██║  ██║███████║    ██║     ███████╗███████╗██║  ██║███████║███████╗\n",
                    "╚═╝     ╚═╝  ╚═╝╚═╝     ╚══════╝╚═╝  ╚═╝╚══════╝    ╚═╝     ╚══════╝╚══════╝╚═╝  ╚═╝╚══════╝╚══════╝"};


    private DefaultTerminalFactory defaultTerminalFactory;
    private  Terminal terminal;
    private TerminalSize terminalSize;
    private  TextGraphics textGraphics;

    private Handler handler;

    private String[] napisyMenu = {"NOWA GRA","OPCJE","WYJDZ Z GRY"};
    private String[] napisyOpcje = {"OPCJA 1","OPCJA 2","WRÓĆ"};
        private String[] napisyGra = {"ZATWIERDŹ WIZE", "ODRZUĆ WIZE","ZAWRÓĆ","PODSTAWOWE ZASADY","PAŃSTWA"};

    private String[] napisyStrona0 = {"PODSTAWOWE ZASADY","PAŃSTWA"};

    private String[] napisDowodOsobisty = {
                    "┳┓┏┓┓ ┏┏┓┳┓  ┏┓┏┓┏┓┳┓┳┏┓┏┳┓┓┏",
                    "┃┃┃┃┃┃┃┃┃┃┃  ┃┃┗┓┃┃┣┫┃┗┓ ┃ ┗┫",
                    "┻┛┗┛┗┻┛┗┛┻┛  ┗┛┗┛┗┛┻┛┻┗┛ ┻ ┗┛"};

    private String[] napisPaszport = {
                    "┏┓┏┓┏┓┏┓┏┓┏┓┳┓┏┳┓",
                    "┃┃┣┫┗┓┏┛┃┃┃┃┣┫ ┃ ",
                    "┣┛┛┗┗┛┗┛┣┛┗┛┛┗ ┻ "
};

    private  String[] napisPozwolenieNaWjazd = {
                    "┏┓┏┓┏┓┓ ┏┏┓┓ ┏┓┳┓┳┏┓  ┳┓┏┓  ┓ ┏┏┳┏┓┏┓┳┓",
                    "┃┃┃┃┏┛┃┃┃┃┃┃ ┣ ┃┃┃┣   ┃┃┣┫  ┃┃┃ ┃┣┫┏┛┃┃",
                    "┣┛┗┛┗┛┗┻┛┗┛┗┛┗┛┛┗┻┗┛  ┛┗┛┗  ┗┻┛┗┛┛┗┗┛┻┛"
    };

    private String[] paszportDane = {"IMIE i NAZWISKO: ","DATA URODZENIA: ","MIASTO WYDANIA: ","DATA WAŻNOŚCI: ","PAŃSTWO: ","KOD PASZPORTU: "};

    private  String[] pozwolenieNaWjazdDane = {"IMIE i NAZWISKO: ","KOD PASZPORTU: ","CEL PRZYJAZDU: ","CZAS PRZYJAZDU: ","DATA WAŻNOŚCI: "};

    private String[] dowodOsobistyDane = {"IMIE i NAZWISKO", "DYSTRYKT: ","DATA URODZENIA: ","WZROST: ","WAGA: "};
    private int selectedOptionX = 0;
    private int selectedOptionY = 0;
    private int opcjeMenu = napisyOpcje.length;
    private int opcjeGraX = napisyGra.length;
    private int opcjeGraY = 1;
    private String wybranaOpcja = "stronaWstepu";

    public int przerobieniPetenci = 0;
    public int poprawniPetenci = 0;


    public Petent petent;

    private TextColor bialy = TextColor.ANSI.WHITE;

    public Menu(DefaultTerminalFactory defaultTerminalFactory,Terminal terminal,TerminalSize terminalSize, TextGraphics textGraphics,Handler handler ,Petent petent)
    {
        this.defaultTerminalFactory = defaultTerminalFactory;
        this.terminal = terminal;
        this.terminalSize = terminalSize;
        this.textGraphics = textGraphics;
        this.handler = handler;
        this.petent = petent;// DO TESTÓW
    }

    public void printObrazek()throws  IOException{
        textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
        textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);

        textGraphics.putString(70,20,obrazek[0]);
        textGraphics.putString(70,21,obrazek[1]);
        textGraphics.putString(70,22,obrazek[2]);
        textGraphics.putString(70,23,obrazek[3]);
        textGraphics.putString(70,24,obrazek[4]);
        textGraphics.putString(70,25,obrazek[5]);
    }

    public void printMenu(int selectedOption) throws IOException {
        terminal.clearScreen();
        printObrazek();

        for (int i = 0; i < napisyMenu.length; i++) {
            if (i == selectedOption) {
                textGraphics.setForegroundColor(TextColor.ANSI.BLACK);
                textGraphics.setBackgroundColor(TextColor.ANSI.WHITE);
            } else {
                textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
                textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
            }

            textGraphics.putString(111, 30 + i, napisyMenu[i]);
        }
        terminal.flush();
    }
    public void printOpcje(int selectedOption)throws  IOException{
        terminal.clearScreen();
        printObrazek();

        for (int i = 0; i < napisyOpcje.length; i++) {
            if (i == selectedOption) {
                textGraphics.setForegroundColor(TextColor.ANSI.BLACK);
                textGraphics.setBackgroundColor(TextColor.ANSI.WHITE);
            } else {
                textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
                textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
            }

            textGraphics.putString(111, 30 + i, napisyOpcje[i]);
        }

        terminal.flush();

    }
    public void printGra(Petent petent) throws IOException{
        terminal.clearScreen();
        //RYSOWANIE OBWODÓW DOKUMENTÓW ORAZ KSIAZEK
        printGraObwody();

        //RYSOWANIE INFORMACJI O PETENTACH
        printGraPetent(petent);

        //RYSOWANIE OPCJI GRY ZATWIERDŹ I ODRZUĆ
        printGraPrzyciski();

        //System.out.println(Arrays.toString(imie));

        //RYSOWANIE KSIAZKI
        //printKsiazka(wybranaOpcja); //TODO ZMIENIC KODOWANIE
        terminal.flush();
    }



    public void printGra(int selectedOptionX,int selectedOptionY)throws  IOException{
       // printGraObwody();
       // printGraPetent(new Petent()); //TODO POWSTRZYMAC CALY CZAS GENEROWANIE NOWEGO PETENTA

        printGraPrzyciski();
        terminal.flush();

    }


    private void printGraObwody()throws  IOException{
        textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
        textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
        //PRINTOWANIE OBWÓDKI DO PASZPORTU
        textGraphics.fillRectangle(new TerminalPosition(0,0),terminalSize.withColumns(90).withRows(1),'X');
        textGraphics.fillRectangle(new TerminalPosition(0,26),terminalSize.withColumns(90).withRows(1),'X');
        textGraphics.fillRectangle(new TerminalPosition(0,0),terminalSize.withColumns(1).withRows(26),'X');
        textGraphics.fillRectangle(new TerminalPosition(89,0),terminalSize.withColumns(1).withRows(26),'X');
        //DODATKOWY DOKUMENT
        textGraphics.fillRectangle(new TerminalPosition(89,0),terminalSize.withColumns(55).withRows(1),'Y');
        textGraphics.fillRectangle(new TerminalPosition(89,26),terminalSize.withColumns(56).withRows(1),'Y');
        textGraphics.fillRectangle(new TerminalPosition(144,0),terminalSize.withColumns(1).withRows(26),'Y');
        //KSIAZKA
        textGraphics.fillRectangle(new TerminalPosition(160,35),terminalSize.withColumns(80).withRows(1),'K');
        textGraphics.fillRectangle(new TerminalPosition(160,35),terminalSize.withColumns(1).withRows(30),'K');
        textGraphics.setBackgroundColor(TextColor.ANSI.BLUE);
        textGraphics.putString(110,60,"Przerobieni petenci " + przerobieniPetenci);
        textGraphics.putString(110,62,"Poprawni petenci " + poprawniPetenci);
        textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);



    }
    private void printGraPetent(Petent petent){
        textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
        textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
        this.petent = petent;

        //DANE Z PASZPORTU
        if(!isNull(petent)){
            String[] imie = petent.getPaszport().toString().split("/");
            String[] twarz = petent.getPaszport().getTwarzPetenta();
            textGraphics.putString(new TerminalPosition(45,2),napisPaszport[0]);
            textGraphics.putString(new TerminalPosition(45,3),napisPaszport[1]);
            textGraphics.putString(new TerminalPosition(45,4),napisPaszport[2]);
            //TWARZ
            for(int i = 0 ; i < twarz.length ; i++){
                textGraphics.putString(new TerminalPosition(2,i+2),twarz[i]);
            }
            //DANE Z PASZPORTU
            int tmp = 0;
            for(int i = 2; i <= 12 ; i +=2)
            {
                textGraphics.putString(new TerminalPosition(45,i+4),paszportDane[tmp]);
                textGraphics.putString(new TerminalPosition(63,i+4),imie[tmp]);
                tmp += 1;
            }
        }else{
            textGraphics.putString(new TerminalPosition(2,2),"BRAK PASZPORTU PETENT == NULL");
        }


        //DANE Z DOWODU OSIBISTEGO
        if(!isNull(petent.getDowodOsobisty())){
            textGraphics.putString(new TerminalPosition(95,2),napisDowodOsobisty[0]);
            textGraphics.putString(new TerminalPosition(95,3),napisDowodOsobisty[1]);
            textGraphics.putString(new TerminalPosition(95,4),napisDowodOsobisty[2]);
            System.out.println(petent.getDowodOsobisty().toString());
            String[] obciete = petent.getDowodOsobisty().toString().split("/");
            int tmp = 0;
            for(int i = 2;i<12;i +=2){
                textGraphics.putString(new TerminalPosition(95,i+4),dowodOsobistyDane[tmp]);
                textGraphics.putString(new TerminalPosition(115,i+4),obciete[tmp]);
                tmp += 1;
            }
        }


        //DANE Z POZWOLENIA NA WJAZD
        if(!isNull(petent.getPozwolenieNaWjazd())){
            textGraphics.putString(new TerminalPosition(95,2),napisPozwolenieNaWjazd[0]);
            textGraphics.putString(new TerminalPosition(95,3),napisPozwolenieNaWjazd[1]);
            textGraphics.putString(new TerminalPosition(95,4),napisPozwolenieNaWjazd[2]);
            System.out.println(petent.getPozwolenieNaWjazd().toString());
            String[] obcietePozwolenie = petent.getPozwolenieNaWjazd().toString().split("/");
            int tmp = 0;
            for(int i = 2 ; i < 12 ; i+=2){
                textGraphics.putString(new TerminalPosition(95,i+4),pozwolenieNaWjazdDane[tmp]);
                textGraphics.putString(new TerminalPosition(115,i+4),obcietePozwolenie[tmp]);
                tmp +=1;
            }
        }



        String kod = String.valueOf(petent.getKodBledu());
        textGraphics.putString(45,22,kod);

    }


    private void printGraPetent(){}//TODO:OPTYMALIZACJA ZEBY NIE DRUKOWAC TEGO SAMEGO CO SIE NIE ZMIENILO PO STRZALCE NA PRZYKLAD CHOCIAZ JUZ ZROBNIONE JESTCHGYBA
    private void printGraPrzyciski(){
        for (int i = 0; i < napisyGra.length; i++) {
            if (i == selectedOptionX) {
                textGraphics.setForegroundColor(TextColor.ANSI.BLACK);
                textGraphics.setBackgroundColor(TextColor.ANSI.WHITE);
            } else {
                textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
                textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
            }
            if(i<2){textGraphics.putString(111 + (i*15),50, napisyGra[i]);}
            else {textGraphics.putString(220,i+36,napisyGra[i]);}

        }
    }



    public void printKsiazka(String wybranaOpcja) throws IOException {
        printGra(petent);
        String [] stronaDoRysowania = Ksiazka.getStrona(wybranaOpcja);
        this.wybranaOpcja = wybranaOpcja;
        //RYSOWANIE OBWODU KSIAZKI
        textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
        textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
        textGraphics.fillRectangle(new TerminalPosition(160,35),terminalSize.withColumns(80).withRows(1),'K');
        textGraphics.fillRectangle(new TerminalPosition(160,35),terminalSize.withColumns(1).withRows(30),'K');
        //RYSOWANIE DANYCH KSIAZKI
        for(int i = 0 ; i<stronaDoRysowania.length; i++){
            textGraphics.putString(162,38+i,stronaDoRysowania[i]);
        }
        terminal.flush();



        //RYSOWANIE OPCJI KSIĄŻKI
        //textGraphics.putString(new TerminalPosition(172,38),"ZAWRÓĆ");
//        for (int i = 0; i < stronaDoRysowania.length; i++) {
//            if (i == selectedOptionX) {
//                textGraphics.setForegroundColor(TextColor.ANSI.BLACK);
//                textGraphics.setBackgroundColor(TextColor.ANSI.WHITE);
//            } else {
//                textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
//                textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
//            }
//            textGraphics.putString(220,i+37, stronaDoRysowania[i]);
//        }
        //textGraphics.fillRectangle(new TerminalPosition(0,26),terminalSize.withColumns(90).withRows(1),'X');
        //textGraphics.fillRectangle(new TerminalPosition(0,0),terminalSize.withColumns(1).withRows(26),'X');
        //textGraphics.fillRectangle(new TerminalPosition(240,6),terminalSize.withColumns(1).withRows(26),'X');

        //RYSOWANIE ZAWARTOŚCI KSIAŻKI




    }


    public void klawiszeGra() throws IOException {

        boolean warunek = true;
        do{
            KeyStroke keyStroke = terminal.pollInput();
            if (keyStroke != null) {
                switch (keyStroke.getKeyType()) {
                    case ArrowLeft:
                        if(selectedOptionX == 0){}//selectedOptionX = 1;
                        else {selectedOptionX = (selectedOptionX - 1) % opcjeGraX;}
                        printGra(selectedOptionX,selectedOptionY);
                        break;
                    case ArrowRight:
                        selectedOptionX = (selectedOptionX + 1) % opcjeGraX;
                        printGra(selectedOptionX,selectedOptionY);
                        break;
                    case Enter:
                        warunek = handler.handleOptionSelection(napisyGra[selectedOptionX]);
                        break;
                    case Escape:
                        warunek = false;
                        terminal.bell();
                        terminal.close();
                        return;
                }
            }

        }while (warunek);
    }
    public void klawiszeMenu() throws IOException {

        selectedOptionY = 0;

        boolean warunek = true;
        do{
            KeyStroke keyStroke = terminal.pollInput();
            if (keyStroke != null) {
                switch (keyStroke.getKeyType()) {
                    case ArrowUp:
                        if(selectedOptionY == 0){
                            selectedOptionY = 2;}
                        else{
                            selectedOptionY = (selectedOptionY - 1) % opcjeMenu;}
                        printMenu(selectedOptionY);
                        break;
                    case ArrowDown:
                        selectedOptionY = (selectedOptionY + 1) % opcjeMenu;
                        printMenu(selectedOptionY);
                        break;
                    case Enter:
                        warunek = handler.handleOptionSelection(napisyMenu[selectedOptionY]);
                        break;
                    case Escape:
                        warunek = false;
                        terminal.bell();
                        terminal.close();
                        return;
                }
            }

        }while (warunek);
    }
    public void klawiszeOpcje() throws IOException {
        // Handler handler = new Handler(terminal);
        selectedOptionY = 0;
        boolean warunek = true;
        do{
            KeyStroke keyStroke = terminal.pollInput();
            if (keyStroke != null) {
                switch (keyStroke.getKeyType()) {
                    case ArrowUp:
                        if(selectedOptionY == 0){
                            selectedOptionY = 2;}
                        else{
                            selectedOptionY = (selectedOptionY - 1) % opcjeMenu;}
                        printOpcje(selectedOptionY);
                        break;
                    case ArrowDown:
                        selectedOptionY = (selectedOptionY + 1) % opcjeMenu;
                        printOpcje(selectedOptionY);
                        break;
                    case Enter:
                        warunek = handler.handleOptionSelection(napisyOpcje[selectedOptionY]);
                        break;
                    case Backspace:
                        warunek = false;
                        printMenu(selectedOptionY);
                        //klawiszeMenu();
                        break;
                    case Escape:
                        terminal.bell();
                        terminal.close();
                        break;
                }
            }

        }while(warunek);
    }

}
