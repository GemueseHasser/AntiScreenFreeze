package de.jonas.amf;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Task.isRunning = !Task.isRunning;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
