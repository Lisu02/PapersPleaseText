package org.example;

import com.googlecode.lanterna.SGR;
//import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalResizeListener;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;

import java.awt.*;
import java.awt.font.ShapeGraphicAttribute;
import java.io.IOException;
import java.security.Key;

import static com.googlecode.lanterna.input.KeyType.*;


public class Main {

    //public Terminal terminal;
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
    private static void handleOptionSelection(String option) {
        // Implement your menu option handling here
        // You can add logic to execute different actions based on the selected option.
    }



}//MAIN


