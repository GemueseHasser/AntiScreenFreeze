package de.jonas.amf;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Task {

    public static boolean isRunning = false;

    private boolean left = true, right = false;

    private Timer timer;

    private int leftCount = 0, rightCount = 0;

    public Task() throws AWTException {
        JFrame frame = new JFrame("Anti-Screen-Freeze - Drücke F12");
        frame.setBounds(0, 0, 300, 0);
        frame.setResizable(false);
        frame.addKeyListener(new KeyHandler());
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.requestFocus();
        frame.setVisible(true);

        Robot robot = new Robot();
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!isRunning) {
                    return;
                }
                if (left) {
                    robot.mouseMove(MouseX() - 3, MouseY());
                    leftCount++;
                    if(leftCount >= 3) {
                        left = false;
                        right = true;
                        leftCount = 0;
                    }
                } else if (right) {
                    robot.mouseMove(MouseX() + 3, MouseY());
                    rightCount++;
                    if(rightCount >= 3) {
                        right = false;
                        left = true;
                        rightCount = 0;
                    }
                }
            }
        }, 0, 100);
    }

    private static int MouseX() {
        PointerInfo pi = MouseInfo.getPointerInfo();
        Point p = pi.getLocation();
        int x = (int) p.getX();
        return x;
    }

    private static int MouseY() {
        PointerInfo pi = MouseInfo.getPointerInfo();
        Point p = pi.getLocation();
        int y = (int) p.getY();
        return y;
    }

}
