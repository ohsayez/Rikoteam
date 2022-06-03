package com.company;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public record Keys(MainBoard mainBoard) implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'q' -> {
                this.mainBoard.moveRobot(this.mainBoard.getUsedRobot(), Direction.HL);
                this.mainBoard.addMoves();
            }
            case 'z' -> {
                this.mainBoard.moveRobot(this.mainBoard.getUsedRobot(), Direction.VT);
                this.mainBoard.addMoves();
            }
            case 's' -> {
                this.mainBoard.moveRobot(this.mainBoard.getUsedRobot(), Direction.VB);
                this.mainBoard.addMoves();
            }
            case 'd' -> {
                this.mainBoard.moveRobot(this.mainBoard.getUsedRobot(), Direction.HR);
                this.mainBoard.addMoves();
            }
            case 'r' -> {
                this.mainBoard.reset();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("You released key char: " + e.getKeyChar());
        System.out.println("You released key code: " + e.getKeyCode());
    }
}
