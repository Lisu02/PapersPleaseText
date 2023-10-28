//package org.example;
//import com.googlecode.lanterna.TextColor;
//import com.googlecode.lanterna.graphics.TextGraphics;
//import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
//
//import com.googlecode.lanterna.screen.Screen;
//import com.googlecode.lanterna.terminal.TermianP;
//
//public class ChangeBackground {
//    public static void main(String[] args) throws Exception {
//        Screen screen = new DefaultTerminalFactory().createScreen();
//        TextGraphics textGraphics = screen.newTextGraphics();
//
//        // Ustaw kolor tła
//        textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
//
//        // Wypełnij ekran kolorem tła
//        textGraphics.fillRectangle(new TerminalPosition(0, 0), screen.getTerminalSize(), ' ');
//
//        // Odśwież ekran
//        screen.refresh();
//
//        // Poczekaj, aby użytkownik mógł zobaczyć zmiany
//        Thread.sleep(2000);
//
//        screen.close();
//    }
//}
