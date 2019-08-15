package com.play.tank;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Tank {
    private int x, y;
    private Dir dir;
    private static final int SPEED = 5;
    private boolean bL, bU, bD, bR;
    private boolean moving;

    public Tank() {
    }

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
        move();
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
                bL = true;
                break;
            case KeyEvent.VK_UP:
                bU = true;
                break;
            case KeyEvent.VK_DOWN:
                bD = true;
                break;
            case KeyEvent.VK_RIGHT:
                bR = true;
                break;
        }
        setMainDir();
    }

    private void move() {
        if (!moving){
            return;
        }
        switch (dir) {
            case L:
                x -= SPEED;
                break;
            case U:
                y -= SPEED;
                break;
            case D:
                y += SPEED;
                break;
            case R:
                x += SPEED;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
                bL = false;
                break;
            case KeyEvent.VK_UP:
                bU = false;
                break;
            case KeyEvent.VK_DOWN:
                bD = false;
                break;
            case KeyEvent.VK_RIGHT:
                bR = false;
                break;
        }
        setMainDir();
    }

    private void setMainDir() {
        if (!bU && !bL && !bR && !bD) {
            moving = false;
        }else {
            moving =true;

            if (!bL && !bR && !bD && bU)
                dir = Dir.U;
            if (!bU && !bR && !bD && bL)
                dir = Dir.L;
            if (!bU && !bL && !bD && bR)
                dir = Dir.R;
            if (!bU && !bL && !bR && bD)
                dir = Dir.D;
        }
    }
}
