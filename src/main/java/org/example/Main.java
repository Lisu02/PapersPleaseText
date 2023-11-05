package org.example;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import java.awt.*;
import java.io.IOException;



public class Main {


    public static void main(String[] args) throws IOException {


        Font myFont = new Font("Monospaced",Font.BOLD,13);
        AWTTerminalFontConfiguration myFontConfiguration = AWTTerminalFontConfiguration.newInstance(myFont);
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
        defaultTerminalFactory.setForceAWTOverSwing(true);
        defaultTerminalFactory.setTerminalEmulatorFontConfiguration(myFontConfiguration);
        TerminalSize terminalSize = new TerminalSize(240,67);
         defaultTerminalFactory.setInitialTerminalSize(terminalSize); // Ustaw rozmiar terminala
        Terminal terminal = null;



        try {
            terminal = defaultTerminalFactory.createTerminal();
            terminal.enterPrivateMode();
            terminal.clearScreen();
            //terminal.setCursorVisible(false);
            final TextGraphics textGraphics = terminal.newTextGraphics();
            terminal.setCursorVisible(false);


            //WYWOŁANIE MENU
            Handler handler = new Handler(terminal);
            Petent petent = new Petent();
            Menu menu = new Menu(defaultTerminalFactory,terminal,terminalSize,textGraphics,handler,petent);
            handler.addMenu(menu);
            handler.addTextGraphics(textGraphics);



            //WYPISANIE MENU I OBSŁUGA KLAWISZY
            menu.printMenu(0);
            menu.klawiszeMenu();



            terminal.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//MAIN METHOD
}//MAIN


