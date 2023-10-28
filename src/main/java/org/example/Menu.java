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

import java.io.IOException;
import java.util.Arrays;

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
    private String[] napisyGra = {"ZATWIERDŹ WIZE", "ODRZUĆ WIZE"};


    private int selectedOptionX = 0;
    private int selectedOptionY = 0;
    private int opcjeMenu = 3;
    private int opcjeGraX = 2;
    private int opcjeGraY = 1;

    private Petent petent;

    private TextColor bialy = TextColor.ANSI.WHITE;

    public Menu(DefaultTerminalFactory defaultTerminalFactory,Terminal terminal,TerminalSize terminalSize, TextGraphics textGraphics ,Handler handler,Petent petent)
    {
        this.defaultTerminalFactory = defaultTerminalFactory;
        this.terminal = terminal;
        this.terminalSize = terminalSize;
        this.textGraphics = textGraphics;
        this.handler = handler;
        this.petent = petent;// DO TESTÓW
    }
    public void printMenu(int selectedOption) throws IOException {
        terminal.clearScreen();
        //terminal.flush(); NIE DAWAĆ FLUSHA BO BŁĘDY GRAFICZNE
        textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
        textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
        textGraphics.putString(70,20,obrazek[0]);
        textGraphics.putString(70,21,obrazek[1]);
        textGraphics.putString(70,22,obrazek[2]);
        textGraphics.putString(70,23,obrazek[3]);
        textGraphics.putString(70,24,obrazek[4]);
        textGraphics.putString(70,25,obrazek[5]);

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
        //terminal.flush();
//        textGraphics.setBackgroundColor(TextColor.ANSI.CYAN_BRIGHT);
//        textGraphics.fillRectangle(new TerminalPosition(0,0),terminalSize,' ');
        textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
        textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);

        textGraphics.putString(70,20,obrazek[0]);
        textGraphics.putString(70,21,obrazek[1]);
        textGraphics.putString(70,22,obrazek[2]);
        textGraphics.putString(70,23,obrazek[3]);
        textGraphics.putString(70,24,obrazek[4]);
        textGraphics.putString(70,25,obrazek[5]);

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

    public void printGra(int selectedOptionX,int selectedOptionY) throws IOException{
        terminal.clearScreen();
        //RYSOWANIE OBWODÓW DOKUMENTÓW ORAZ KSIAZEK
        textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
        textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
        textGraphics.fillRectangle(new TerminalPosition(0,0),terminalSize.withColumns(40).withRows(1),'X');
        textGraphics.fillRectangle(new TerminalPosition(0,25),terminalSize.withColumns(40).withRows(1),'X');
        textGraphics.fillRectangle(new TerminalPosition(0,0),terminalSize.withColumns(1).withRows(25),'X');
        textGraphics.fillRectangle(new TerminalPosition(40,0),terminalSize.withColumns(1).withRows(26),'X');

        //RYSOWANIE INFORMACJI O PETENTACH
        String[] imie = petent.toString().split("/");
        int tmp = 0;
        for(int i = 2; i <= 12 ; i +=2)
        {
            textGraphics.putString(new TerminalPosition(2,i),imie[tmp]);
            tmp += 1;
        }

        //RYSOWANIE OPCJI GRY ZATWIERDŹ I ODRZUĆ
        for (int i = 0; i < napisyGra.length; i++) {
            if (i == selectedOptionX) {
                textGraphics.setForegroundColor(TextColor.ANSI.BLACK);
                textGraphics.setBackgroundColor(TextColor.ANSI.WHITE);
            } else {
                textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
                textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
            }
            textGraphics.putString(111 + (i*15),50, napisyGra[i]);
        }
        //System.out.println(Arrays.toString(imie));
        terminal.flush();
    }

    public void klawiszeGra() throws IOException {



        while(true){
            KeyStroke keyStroke = terminal.pollInput();
            if (keyStroke != null) {
                switch (keyStroke.getKeyType()) {
                    case ArrowLeft:
                        if(selectedOptionX == 0){selectedOptionX = 1;}
                        else {selectedOptionX = (selectedOptionX - 1) % opcjeGraX;}
                        printGra(selectedOptionX,selectedOptionY);
                        break;
                    case ArrowRight:
                        selectedOptionX = (selectedOptionX + 1) % opcjeGraX;
                        printGra(selectedOptionX,selectedOptionY);
                        break;
                    case Enter:
                        handler.handleOptionSelection(napisyGra[selectedOptionX]);
                        break;
                    case Escape:
                        terminal.bell();
                        terminal.close();
                        return;
                }
            }

        }
    }

    public void klawiszeMenu() throws IOException {
       // Handler handler = new Handler(terminal);
        selectedOptionY = 0;
        while(true){
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
                        handler.handleOptionSelection(napisyMenu[selectedOptionY]);
                        break;
                    case Escape:
                        terminal.bell();
                        terminal.close();
                        return;
                }
            }

        }
    }


    public void klawiszeOpcje() throws IOException {
        // Handler handler = new Handler(terminal);
        selectedOptionY = 0;
        while(true){
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
                        handler.handleOptionSelection(napisyOpcje[selectedOptionY]);
                        break;
                    case Escape:
                        terminal.bell();
                        terminal.close();
                        return;
                }
            }

        }
    }
}
