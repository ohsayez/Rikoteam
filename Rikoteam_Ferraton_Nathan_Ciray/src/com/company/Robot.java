package com.company;

import java.awt.*;

public class Robot {

    private Position livePosition;
    public Color color;



    public Robot(Color actcolor, Position position){
        position.touching();
        color = actcolor;
        livePosition = position;

    }

    public Robot(Position position){
        color = Color.BLACK;
        livePosition = position;
        position.touching();

    }

    public Position getLivePosition() {
        return livePosition;
    }

    public void setLivePosition(Position livePosition) {
        this.livePosition = livePosition;
    }
}
