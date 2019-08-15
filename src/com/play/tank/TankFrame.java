package com.play.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TankFrame extends Frame {
    private Tank myTank;
    private Tank enemy;
    public TankFrame(){
        this.setTitle("TankWar");
        this.setLocation(300,100);
        this.setSize(800,600);
        this.addKeyListener(new TankKeyListener());
        myTank = new Tank(100,100, Dir.U);
        enemy = new Tank(400,200,Dir.D);
    }

    @Override
    public void paint(Graphics g) {
        myTank.paint(g);
        enemy.paint(g);
    }

    private class TankKeyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            myTank.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            myTank.keyReleased(e);
        }
    }
}
