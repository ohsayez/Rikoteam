package com.company;

public class Position {

    private final int X;
    private final int Y;

    private boolean topWall;
    private boolean botWall;
    private boolean leftWall;
    private boolean rightWall;

    private boolean isTouching;


    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void notTouching(){
        isTouching = false;
    }

    public void touching(){
        isTouching = true;
    }

    public boolean isTouching(){
        return isTouching;
    }

    public boolean detectWall(Direction Dir){
        return switch (Dir) {
            case VT -> topWall;
            case HL -> leftWall;
            case VB -> botWall;
            case HR -> rightWall;
        };
    }


    public void createWall(Direction Dir){

        switch (Dir) {
            case VT -> topWall = true;
            case HL -> leftWall = true;
            case VB -> botWall = true;
            case HR -> rightWall = true;
        }
    }


    public Position(int x, int y){
        X = x;
        Y = y;

        isTouching = false;

        topWall = false;
        botWall = false;
        leftWall = false;
        rightWall = false;


    }

    public Position(){
        X = 0;
        Y = 0;

        isTouching = false;

        topWall = false;
        botWall = false;
        leftWall = false;
        rightWall = false;


    }




}
