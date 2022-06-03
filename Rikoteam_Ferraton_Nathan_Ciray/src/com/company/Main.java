package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Main {

    private static MainBoard mainBoard;
    private static int curTimeInt = 0;
    private static int curTimeDig = 0;

    public static void main(String[] args) {
        mainBoard = new MainBoard();
        mainBoard.setUsedRobot(mainBoard.getRobots()[0]);
        mainBoard.setTimeInt(0,0);
        Pane dPanel = new Pane(mainBoard);  // window for drawing


        final JFrame app = new JFrame("RICOCHET ROBOTS by RikoTeam");
        final JPanel welcomeButtons = new JPanel();

        JButton play_game = new JButton ("Play Game");
        play_game.setBackground(Color.ORANGE);

        JButton instructions = new JButton ("Instructions");
        instructions.setBackground(Color.ORANGE);



        final JPanel instructionsButton = new JPanel();
        JButton back = new JButton ("Back");
        back.setBackground(Color.ORANGE);

        final JButton next = new JButton ("Next");
        next.setBackground(Color.ORANGE);

        welcomeButtons.add(play_game);
        welcomeButtons.add(instructions);
        instructionsButton.add(back);
        instructionsButton.add(next);

        final JButton nextRoundButton = new JButton("Next Round");
        nextRoundButton.setBackground(Color.ORANGE);

        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        mainPanel.add(dPanel);
        app.add(mainPanel);

        app.setSize(600, 600);
        app.addKeyListener(new Keys(mainBoard));
        app.setVisible(true);

        app.setLocation(app.getGraphicsConfiguration().getBounds().width/2-app.getWidth()/2,app.getGraphicsConfiguration().getBounds().height/2-app.getHeight()/2);

        int delay = 100;

        nextRoundButton.addActionListener(ae -> {
            mainBoard.orderOfPassage();
            curTimeInt = 0;
            curTimeDig = 0;
        });

        play_game.addActionListener(ae -> {
            mainPanel.remove(welcomeButtons);
            mainPanel.validate();
            mainBoard.status = 3;
        });

        instructions.addActionListener(ae -> {
            mainPanel.remove(welcomeButtons);
            mainPanel.validate();
            mainBoard.status = 1;
        });

        back.addActionListener(ae -> mainBoard.status--);

        next.addActionListener(ae -> mainBoard.status++);

        ActionListener al = ae -> {

            switch (mainBoard.status) {
                case 0 -> {
                    mainPanel.remove(instructionsButton);
                    mainPanel.add(welcomeButtons, BorderLayout.SOUTH);
                    mainPanel.validate();
                }
                case 1 -> {
                    mainPanel.add(instructionsButton, BorderLayout.SOUTH);
                    mainPanel.validate();
                }
                case 2 -> next.setText("Begin");
                case 3 -> {

                    mainPanel.remove(instructionsButton);
                    mainPanel.add(nextRoundButton, BorderLayout.SOUTH);
                    mainPanel.validate();
                    if (mainBoard.getCurPoint().getPosition() == mainBoard.getPointRobot().getLivePosition() ||
                            (mainBoard.getCurPoint().icon == Icon.BLACKHOLE && mainBoard.getCurPoint().getPosition().isTouching())) {
                        mainBoard.start = false;
                    }
                    if (mainBoard.start) {
                        nextRoundButton.setVisible(false);
                        clock();
                        mainBoard.setTimeInt(curTimeInt, curTimeDig);
                    } else {

                        nextRoundButton.setVisible(true);
                    }
                }
            }
            app.repaint();
        };

        Timer t = new Timer(delay, al);
        t.start();
        app.repaint();

    }

    public static void clock() {
        if (curTimeDig == 9)
        {
            curTimeDig = 0;
            curTimeInt++;
        }
        else curTimeDig++;
    }
}
