package org.example;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class GraMenu extends Menu{
    public GraMenu(DefaultTerminalFactory defaultTerminalFactory, Terminal terminal, TerminalSize terminalSize, TextGraphics textGraphics, Handler handler,Petent petent) {
        super(defaultTerminalFactory, terminal, terminalSize, textGraphics, handler,petent);
    }
}
