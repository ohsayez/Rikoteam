package com.company;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class Pane extends JPanel {

    private final MainBoard mainBoard;
    private final int offset = 25;

    private BufferedImage bg;
    private BufferedImage bigBg;
    private BufferedImage board;
    private BufferedImage img2;
    private BufferedImage key;
    private BufferedImage R_key;
    private BufferedImage blueRobot;
    private BufferedImage redRobot;
    private BufferedImage grayRobot;

    private BufferedImage yellowRobot;
    private BufferedImage greenRobot;
    private BufferedImage board_left_bot;
    private BufferedImage board_righ_bot;
    private BufferedImage board_left_top;
    private BufferedImage board_right_top;


    private BufferedImage blackHole;
    private BufferedImage blueGear;
    private BufferedImage moon;
    private BufferedImage bluePlanet;
    private BufferedImage blueStar;
    private BufferedImage greenGear;
    private BufferedImage greenMoon;
    private BufferedImage greenPlanet;
    private BufferedImage greenStar;
    private BufferedImage redStar;
    private BufferedImage redGear;
    private BufferedImage redMoon;
    private BufferedImage redPlanet;
    private BufferedImage yellowMoon;
    private BufferedImage yellowPlanet;
    private BufferedImage yellowStar;
    private BufferedImage yellowGear;


    Clip clip;

    private final int xOff = 87;
    private final int yOff = 30;

    String text;

    Font fonttitle =new Font("Verdana", Font.ITALIC, 50) ;
    Font fonttext =new Font("Verdana", Font.PLAIN, 10) ;
    public Pane(MainBoard b)
    {
        super();
        setBackground(Color.WHITE);
        mainBoard = b;
        MouseListener mouseListener = new MouseListener() {
            public void mouseClicked(MouseEvent me) {
                if (mainBoard.status == 3) {
                    int clickX = me.getX();
                    int clickY = me.getY();
                    if (clickX > 20 && clickX < mainBoard.getWidth() * offset + xOff &&
                            clickY > 20 && clickY < mainBoard.getHeight() * offset + yOff) {
                        if (mainBoard.getPosition((clickX - xOff) / offset, (clickY - yOff) / offset).isTouching()) {
                            for (int i = 0; i < mainBoard.getRobots().length; i++) {
                                if (mainBoard.getRobots()[i].getLivePosition() ==
                                        mainBoard.getPosition((clickX - xOff) / offset, (clickY - yOff) / offset)) {
                                    mainBoard.setUsedRobot(mainBoard.getRobots()[i]);
                                    return;
                                }
                            }
                        }
                    }
                }
            }

            public void mouseEntered(MouseEvent arg0) {
            }

            public void mouseExited(MouseEvent arg0) {
            }

            public void mousePressed(MouseEvent arg0) {
            }

            public void mouseReleased(MouseEvent arg0) {
            }
        };
        addMouseListener(mouseListener);
        try
        {
            URL mURL = getClass().getResource("/com/ressources/cards/Moon.png");
            moon = ImageIO.read(mURL);
            URL blueGearURL = getClass().getResource("/com/ressources/cards/blueGear.png");
            blueGear = ImageIO.read(blueGearURL);
            URL bluePlanetURL = getClass().getResource("/com/ressources/cards/bluePlanet.png");
            bluePlanet = ImageIO.read(bluePlanetURL);
            URL blueStarURL = getClass().getResource("/com/ressources/cards/blueStar.png");
            blueStar = ImageIO.read(blueStarURL);

            URL greenMoonURL = getClass().getResource("/com/ressources/cards/greenMoon.png");
            greenMoon = ImageIO.read(greenMoonURL);
            URL greenGearURL = getClass().getResource("/com/ressources/cards/greenGear.png");
            greenGear = ImageIO.read(greenGearURL);
            URL greenPlanetURL = getClass().getResource("/com/ressources/cards/greenPlanet.png");
            greenPlanet = ImageIO.read(greenPlanetURL);
            URL greenStarURL = getClass().getResource("/com/ressources/cards/greenStar.png");
            greenStar = ImageIO.read(greenStarURL);

            URL redMoonURL = getClass().getResource("/com/ressources/cards/redMoon.png");
            redMoon = ImageIO.read(redMoonURL);
            URL redGearURL = getClass().getResource("/com/ressources/cards/redGear.png");
            redGear = ImageIO.read(redGearURL);
            URL redPlanetURL = getClass().getResource("/com/ressources/cards/redPlanet.png");
            redPlanet = ImageIO.read(redPlanetURL);
            URL redStarURL = getClass().getResource("/com/ressources/cards/redStar.png");
            redStar = ImageIO.read(redStarURL);

            URL yellowMoonURL = getClass().getResource("/com/ressources/cards/yellowMoon.png");
            yellowMoon = ImageIO.read(yellowMoonURL);
            URL yellowGearURL = getClass().getResource("/com/ressources/cards/yellowGear.png");
            yellowGear = ImageIO.read(yellowGearURL);
            URL yellowPlanetURL = getClass().getResource("/com/ressources/cards/yellowPlanet.png");
            yellowPlanet = ImageIO.read(yellowPlanetURL);
            URL yellowStarURL = getClass().getResource("/com/ressources/cards/yellowStar.png");
            yellowStar = ImageIO.read(yellowStarURL);

            URL blackHoleURL = getClass().getResource("/com/ressources/cards/blackHole.png");
            blackHole = ImageIO.read(blackHoleURL);



            URL img1URL = getClass().getResource("/com/ressources/ricochet-robots-robots-2417883460.jpg");
            bg = ImageIO.read(img1URL);
            URL bigBgURL = getClass().getResource("/com/ressources/lu5ggvf35jh31-1812017315.jpg");
            bigBg = ImageIO.read(bigBgURL);

            URL boardURL = getClass().getResource("/com/ressources/ricochet-robots-plateau-1138582899.jpg");
            board = ImageIO.read(boardURL);
            URL keyURL = getClass().getResource("/com/ressources/Deplacement.jpg");
            key = ImageIO.read(keyURL);
            URL R_keyURL = getClass().getResource("/com/ressources/R.jpg");
            R_key = ImageIO.read(R_keyURL);

            URL img2URL = getClass().getResource("/com/ressources/mediumBoardCase.png");
            img2 = ImageIO.read(img2URL);

            URL blueRobotURL = getClass().getResource("/com/ressources/blueRobot.png");
            blueRobot = ImageIO.read(blueRobotURL);
            URL redRobotURL = getClass().getResource("/com/ressources/redRobot.png");
            redRobot = ImageIO.read(redRobotURL);
            URL yellowRobotURL = getClass().getResource("/com/ressources/yellowRobot.png");
            yellowRobot = ImageIO.read(yellowRobotURL);
            URL greenRobotURL = getClass().getResource("/com/ressources/greenRobot.png");
            greenRobot = ImageIO.read(greenRobotURL);
            URL grayRobotURL = getClass().getResource("/com/ressources/grayRobot.png");
            grayRobot = ImageIO.read(grayRobotURL);
            URL board_left_botURL = getClass().getResource("/com/ressources/boardThreeFront.png");
            board_left_bot = ImageIO.read(board_left_botURL);
            URL board_righ_botURL = getClass().getResource("/com/ressources/boardFourFront.png");
            board_righ_bot = ImageIO.read(board_righ_botURL);
            URL board_right_topURL = getClass().getResource("/com/ressources/boardTwoFront.png");
            board_right_top = ImageIO.read(board_right_topURL);
            URL board_left_topURL = getClass().getResource("/com/ressources/boardOneFront.png");
            board_left_top = ImageIO.read(board_left_topURL);

            doPlay();

        }
        catch (IOException e)
        {System.out.println(e);}

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);            // call superclass to make panel display correctly

        g.setFont(new Font("Verdana", Font.PLAIN, 7));

        switch (mainBoard.status) {
            case 0 -> {

                text = "Ricochet Robots";
                FontMetrics metrics = g.getFontMetrics(fonttitle);
                // Determine the X coordinate for the text
                Rectangle rect = getBounds();
                int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
                // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
                //int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
                // Set the font


                g.setFont(fonttitle);
                g.drawString(text, x, 150);
                g.drawImage(bg, 150 ,190, 300, 250,this);

                metrics = g.getFontMetrics(fonttext);
                rect = getBounds();
                text = "Game Developped by RikoTeam Including Lilian, Kevin and Leopold";
                x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
                g.setFont(fonttext);
                g.drawString(text, x, 450);
            }
            case 1 -> {
                g.setFont(fonttext);

                g.drawImage(board, 150,50, 301, 301,this);
                g.drawString("Ricochet Robots est un jeu de plateau.", 100, 400);
                g.drawString("Il y a un plateau qui forme un carré avec des murs répartis autour.", 100, 412);
                g.drawString("Il y a également des cibles définies par couleur sur le plateau.", 100, 425);
                g.drawString("Cinq robots sont placés sur le plateau aléatoirement.", 100, 437);
                g.drawString("L'objectif pour chaque joueur est de trouver une suite avec le moins de coups possible.", 100, 450);
                g.drawString("pour atteindre la cible choisie au hasard", 100, 462);




            }
            case 2 -> {
                g.setFont(fonttext);
                g.drawString("Regles du jeu:", 250, 20);

                g.drawString("Pour déplacer un Robot:", 20, 50);
                g.drawString("- Cliquer d'abord sur le Robot.", 20, 67);
                g.drawString("- Appuyez ensuite sur les touches Z, Q, S ou D pour déplacer le robot en haut, à gauche, en bas ou à droite.", 20, 80);
                g.drawImage(key, 200,92, 155,130, this);

                g.drawString("Le Robot se déplacera dans la direction sélectionnée jusqu'à ce qu'il heurte un mur ou un autre Robot.", 20, 245);
                g.drawString("Il est aussi possible de réinitialiser la position du Robot en appuyant sur la touche", 20, 275);
                g.drawImage(R_key, 440,254,30,30, this);

                g.drawString("Ainsi le nombre de coups reviendra à zéro mais l'horloge continuera de tourner.", 20, 300);


                g.drawString("Le grand symbole au centre du plateau est l'objectif actuel. L'objectif du jeu est de déplacer ", 20, 325);
                g.drawString("le Robot dont la couleur correspond avec l'objectif actuel. Vous pouvez déplacer un Robot vers un symbole", 20, 337);
                g.drawString("seul, mais vous aurez probablement besoin d'utiliser les autres Robots pour y arriver.", 20, 350);


                g.drawString("Ceci est un trou noir: ", 20, 407);
                g.drawImage(blackHole, 200,375, 50, 50, this);
                g.drawString("Si un trou noir est l'objectif actuel, n'importe quel Robot peut s'y déplacer.", 20, 450);

            }
            case 3 -> {



                g.drawImage(bigBg, -300 ,-150,1200, 750,this);

                g.setColor(Color.BLACK);
                for (int i = 0; i < mainBoard.getWidth(); i++) {
                    for (int j = 0; j < mainBoard.getHeight(); j++) {
                        g.drawImage(img2, i * offset + xOff+1,j * offset + yOff +1, offset-2, offset-2, this);
                        int borderThickness = 3;
                        if (mainBoard.getPosition(i, j).detectWall(Direction.VT)) {
                            g.fillRect(i * offset + xOff, j * offset + yOff, offset, borderThickness);

                        }
                        if (mainBoard.getPosition(i, j).detectWall(Direction.HR)) {
                            g.fillRect((i + 1) * offset + xOff - borderThickness, j * offset + yOff, borderThickness, offset);
                        }
                        if (mainBoard.getPosition(i, j).detectWall(Direction.VB)) {
                            g.fillRect(i * offset + xOff, (j + 1) * offset + yOff - borderThickness, offset, borderThickness);
                        }
                        if (mainBoard.getPosition(i, j).detectWall(Direction.HL)) {
                            g.fillRect(i * offset + xOff, j * offset + yOff, borderThickness, offset);
                        }
                    }
                }

                for (int i = 0; i < mainBoard.getWidth(); i++) {
                    g.drawLine(i * offset + xOff, yOff, i * offset + xOff, mainBoard.getHeight() * offset + yOff);

                }
                for (int i = 0; i < mainBoard.getHeight(); i++) {
                    g.drawLine(xOff, i * offset + yOff, mainBoard.getWidth() * offset + xOff, i * offset + yOff);
                }
                for (int i = 0; i < mainBoard.getPoints().length; i++) {
                    g.setColor(mainBoard.getPoints()[i].color);
                    g.fillRect(mainBoard.getPoints()[i].getPosition().getX() * offset + 1 + xOff,
                            mainBoard.getPoints()[i].getPosition().getY() * offset + 1 + yOff,
                            offset - 1, offset - 1);
                    g.setColor(Color.BLACK);


                }

                g.drawImage(board_left_bot, mainBoard.getWidth() + xOff -15,mainBoard.getHeight()+yOff-15 +200,200,200, this);
                g.drawImage(board_righ_bot, mainBoard.getWidth() + xOff -15 + 200,mainBoard.getHeight()+yOff-15 +200,200,200, this);

                g.drawImage(board_right_top, mainBoard.getWidth() + xOff -15 + 200,mainBoard.getHeight()+yOff-15,200,200, this);
                g.drawImage(board_left_top, mainBoard.getWidth() + xOff -15,mainBoard.getHeight()+yOff-15,200,200, this);


                // choose middle Icon

                switch (mainBoard.getCurPoint().icon) {
                    case GEAR:
                        if (mainBoard.getCurPoint().color.equals(Color.BLUE)){
                            g.drawImage(blueGear, mainBoard.getWidth() * offset / 2 - offset + xOff, mainBoard.getHeight() * offset / 2 - offset + yOff, (offset - 1) * 2, (offset - 1) * 2, null);
                        }if (mainBoard.getCurPoint().color.equals(Color.GREEN)){
                        g.drawImage(greenGear, mainBoard.getWidth() * offset / 2 - offset + xOff, mainBoard.getHeight() * offset / 2 - offset + yOff, (offset - 1) * 2, (offset - 1) * 2, null);

                        }if (mainBoard.getCurPoint().color.equals(Color.RED)){
                        g.drawImage(redGear, mainBoard.getWidth() * offset / 2 - offset + xOff, mainBoard.getHeight() * offset / 2 - offset + yOff, (offset - 1) * 2, (offset - 1) * 2, null);

                        }if (mainBoard.getCurPoint().color.equals(Color.YELLOW)){
                        g.drawImage(yellowGear, mainBoard.getWidth() * offset / 2 - offset + xOff, mainBoard.getHeight() * offset / 2 - offset + yOff, (offset - 1) * 2, (offset - 1) * 2, null);

                        }

                        break;
                    case BLACKHOLE:
                        if (mainBoard.getCurPoint().color.equals(Color.BLUE)){
                            g.drawImage(blackHole, mainBoard.getWidth() * offset / 2 - offset + xOff, mainBoard.getHeight() * offset / 2 - offset + yOff, offset * 2, offset * 2, null);
                        }if (mainBoard.getCurPoint().color.equals(Color.GREEN)){
                        g.drawImage(blackHole, mainBoard.getWidth() * offset / 2 - offset + xOff, mainBoard.getHeight() * offset / 2 - offset + yOff, offset * 2, offset * 2, null);

                    }if (mainBoard.getCurPoint().color.equals(Color.RED)){
                        g.drawImage(blackHole, mainBoard.getWidth() * offset / 2 - offset + xOff, mainBoard.getHeight() * offset / 2 - offset + yOff, offset * 2, offset * 2, null);

                    }if (mainBoard.getCurPoint().color.equals(Color.YELLOW)){
                        g.drawImage(blackHole, mainBoard.getWidth() * offset / 2 - offset + xOff, mainBoard.getHeight() * offset / 2 - offset + yOff, offset * 2, offset * 2, null);

                    }


                        break;
                    case MOON:
                        if (mainBoard.getCurPoint().color.equals(Color.BLUE)){
                            g.drawImage(moon, mainBoard.getWidth() * offset / 2 - offset + xOff, mainBoard.getHeight() * offset / 2 - offset + yOff, (offset - 1) * 2, (offset - 1) * 2, null);

                        }if (mainBoard.getCurPoint().color.equals(Color.GREEN)){
                        g.drawImage(greenMoon, mainBoard.getWidth() * offset / 2 - offset + xOff, mainBoard.getHeight() * offset / 2 - offset + yOff, (offset - 1) * 2, (offset - 1) * 2, null);

                    }if (mainBoard.getCurPoint().color.equals(Color.RED)){
                        g.drawImage(redMoon, mainBoard.getWidth() * offset / 2 - offset + xOff, mainBoard.getHeight() * offset / 2 - offset + yOff, (offset - 1) * 2, (offset - 1) * 2, null);

                    }if (mainBoard.getCurPoint().color.equals(Color.YELLOW)){
                        g.drawImage(yellowMoon, mainBoard.getWidth() * offset / 2 - offset + xOff, mainBoard.getHeight() * offset / 2 - offset + yOff, (offset - 1) * 2, (offset - 1) * 2, null);

                    }
                        break;
                    case PLANET:
                        if (mainBoard.getCurPoint().color.equals(Color.BLUE)){
                            g.drawImage(bluePlanet, mainBoard.getWidth() * offset / 2 - offset + xOff, mainBoard.getHeight() * offset / 2 - offset + yOff, (offset - 1) * 2, (offset - 1) * 2, null);

                        }if (mainBoard.getCurPoint().color.equals(Color.GREEN)){
                        g.drawImage(greenPlanet, mainBoard.getWidth() * offset / 2 - offset + xOff, mainBoard.getHeight() * offset / 2 - offset + yOff, (offset - 1) * 2, (offset - 1) * 2, null);

                    }if (mainBoard.getCurPoint().color.equals(Color.RED)){
                        g.drawImage(redPlanet, mainBoard.getWidth() * offset / 2 - offset + xOff, mainBoard.getHeight() * offset / 2 - offset + yOff, (offset - 1) * 2, (offset - 1) * 2, null);

                    }if (mainBoard.getCurPoint().color.equals(Color.YELLOW)){
                        g.drawImage(yellowPlanet, mainBoard.getWidth() * offset / 2 - offset + xOff, mainBoard.getHeight() * offset / 2 - offset + yOff, (offset - 1) * 2, (offset - 1) * 2, null);

                    }
                        break;
                    case STAR:
                        if (mainBoard.getCurPoint().color.equals(Color.BLUE)){
                            g.drawImage(blueStar, mainBoard.getWidth() * offset / 2 - offset + xOff, mainBoard.getHeight() * offset / 2 - offset + yOff, (offset - 1) * 2, (offset - 1) * 2, null);

                        }if (mainBoard.getCurPoint().color.equals(Color.GREEN)){
                        g.drawImage(greenStar, mainBoard.getWidth() * offset / 2 - offset + xOff, mainBoard.getHeight() * offset / 2 - offset + yOff, (offset - 1) * 2, (offset - 1) * 2, null);

                    }if (mainBoard.getCurPoint().color.equals(Color.RED)){
                        g.drawImage(redStar, mainBoard.getWidth() * offset / 2 - offset + xOff, mainBoard.getHeight() * offset / 2 - offset + yOff, (offset - 1) * 2, (offset - 1) * 2, null);

                    }if (mainBoard.getCurPoint().color.equals(Color.YELLOW)){
                        g.drawImage(yellowStar, mainBoard.getWidth() * offset / 2 - offset + xOff, mainBoard.getHeight() * offset / 2 - offset + yOff, (offset - 1) * 2, (offset - 1) * 2, null);

                    }
                        break;
                    default:
                        break;
                }

                for (int i = 0; i < mainBoard.getRobots().length; i++) {
                    Robot tempRobo = mainBoard.getRobots()[i];
                    drawRobot(g, tempRobo.color, tempRobo.getLivePosition().getX() * offset + xOff, tempRobo.getLivePosition().getY() * offset + yOff);


                }

                g.setFont(fonttext);
                g.setColor(Color.BLACK);
                g.drawString("Total Moves: ", 115, 450);
                g.drawString(mainBoard.getMovesTotal() + "", 195, 450);

                g.drawString("Used Robot: ", 400, 450);
                drawRobot(g, mainBoard.getUsedRobot().color, 470, 450);

                g.drawString(mainBoard.getTimeString(), 100, 22);
                g.drawString("Moves: " + mainBoard.getMovesNumber(),400, 22);

            }
        }

    }

    public void drawRobot (Graphics g, Color c, int x, int y) {

        if (c.equals(Color.GRAY)){

            g.drawImage(grayRobot, x,y-7, 25, 30, this);

        }

        if (c.equals(Color.RED)){

            g.drawImage(redRobot, x,y-7, 25, 30, this);

        }
        if (c.equals(Color.BLUE)){

            g.drawImage(blueRobot, x,y-7, 25, 30, this);

        }if (c.equals(Color.GREEN)){

            g.drawImage(greenRobot, x,y-7, 25, 30, this);

        }if (c.equals(Color.YELLOW)){

            g.drawImage(yellowRobot, x,y-7, 25, 30, this);

        }
    }


    private void doPlay() {
        try {

            AudioInputStream inputStream = AudioSystem
                    .getAudioInputStream(Objects.requireNonNull(Main.class.getResourceAsStream("/com/ressources/The Best DnD AND Board Game Music.wav")));
            clip = AudioSystem.getClip();
            clip.open(inputStream);
            clip.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


}
