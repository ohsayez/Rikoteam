package com.company;

import java.awt.*;

public class Point {
    public Color color;
    public Icon icon;
    private final Position position;

    public Point (Color cl, Icon ic, Position pos){
        color = cl;
        position = pos;
        icon = ic;

    }

    public Point(Position pos){
        position = pos;
        color = Color.RED;
        icon = Icon.GEAR;

    }

    public Position getPosition() {
        return position;
    }
}
