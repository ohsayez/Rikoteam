package com.company;

import java.awt.*;
import java.util.Random;

public class MainBoard {
    private final Position[][] board;
    private final Position[] firstPositions;
    private final int width = 16;
    private final int height = 16;

    private Robot[] robots;
    private Robot pointRobot = new Robot(new Position());

    private final int allRobots = 5;
    private Robot usedRobot;

    private int timeInt;
    private int displayedTime;
    private int movesNumber;
    private int movesTotal;
    private int totalTimeInt;
    private int timePassed;

    private Point[] points;
    private Point curPoint;
    private final int numberPoints = 17;

    private final Color red = new Color(255, 0, 0);
    private final Color green = new Color(0, 255, 0);
    private final Color yellow = new Color(255, 255, 0);
    private final Color blue = new Color(0, 0, 255);

    public Boolean start;
    public int status;

    public MainBoard() {
        board = new Position[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                board[i][j] = new Position(i, j);

            }

        }
        createFirstWalls();
        createIconChooser();
        createBoard(0);
        createRobots();
        setPoint();

        firstPositions = new Position[allRobots];
        setFirstPositions();
        movesNumber = 0;
        status = 0;
        start = true;
    }

    public void createFirstWalls() {
        for (int i = 0; i < width; i++) {
            board[i][0].createWall(Direction.VT);
        }
        for (int i = 0; i < width; i++) {
            board[i][height - 1].createWall(Direction.VB);
        }
        for (int i = 0; i < board[board.length - 1].length; i++) {
            board[width - 1][i].createWall(Direction.HR);
        }
        for (int i = 0; i < height; i++) {
            board[0][i].createWall(Direction.HL);
        }
    }

    private void createWalls(Direction Dir, int i, int i1) {

        switch (Dir) {
            case VT -> {
                board[i][i1].createWall(Dir);
                board[i][i1 - 1].createWall(Direction.VB);
            }
            case HR -> {
                board[i][i1].createWall(Dir);
                board[i + 1][i1].createWall(Direction.HL);
            }
            case VB -> {
                board[i][i1].createWall(Dir);
                board[i][i1 + 1].createWall(Direction.VT);
            }
            case HL -> {
                board[i][i1].createWall(Dir);
                board[i - 1][i1].createWall(Direction.HR);
            }
        }

    }

    public void createBoard(int x) {
        if (x == 0) {


            createWalls(Direction.HR, 12, 7);
            createWalls(Direction.VB, 13, 7);
            createWalls(Direction.VT, 3, 9);
            createWalls(Direction.HR, 3, 9);
            createWalls(Direction.HL, 12, 9);
            createWalls(Direction.VT, 12, 9);
            createWalls(Direction.VB, 15, 9);
            createWalls(Direction.HR, 5, 0);
            createWalls(Direction.VB, 3, 1);
            createWalls(Direction.HR, 2, 2);
            createWalls(Direction.VB, 0, 3);
            createWalls(Direction.VB, 2, 3);
            createWalls(Direction.HR, 4, 3);
            createWalls(Direction.VB, 5, 3);
            createWalls(Direction.HR, 2, 4);
            createWalls(Direction.HR, 4, 5);
            createWalls(Direction.VB, 4, 5);
            createWalls(Direction.HR, 11, 0);
            createWalls(Direction.VB, 9, 1);
            createWalls(Direction.HR, 10, 10);
            createWalls(Direction.VB, 10, 10);
            createWalls(Direction.HL, 6, 11);
            createWalls(Direction.VT, 6, 11);
            createWalls(Direction.HL, 1, 12);
            createWalls(Direction.VB, 1, 12);
            createWalls(Direction.VT, 14, 12);
            createWalls(Direction.HR, 14, 12);
            createWalls(Direction.VB, 0, 13);
            createWalls(Direction.HR, 9, 1);
            createWalls(Direction.VB, 15, 2);
            createWalls(Direction.HR, 10, 3);
            createWalls(Direction.VB, 11, 3);
            createWalls(Direction.VB, 14, 4);
            createWalls(Direction.VB, 10, 5);
            createWalls(Direction.HR, 13, 5);
            createWalls(Direction.HR, 10, 6);
            createWalls(Direction.HR, 4, 14);
            createWalls(Direction.VB, 4, 14);
            createWalls(Direction.HL, 11, 14);
            createWalls(Direction.VB, 11, 14);
            createWalls(Direction.HR, 6, 15);
            createWalls(Direction.HR, 13, 15);

            points = new Point[numberPoints];


            points[0] = new Point(yellow, Icon.MOON, board[3][2]);
            points[1] = new Point(red, Icon.PLANET, board[2][4]);
            points[2] = new Point(blue, Icon.GEAR, board[5][3]);
            points[3] = new Point(green, Icon.STAR, board[4][5]);
            points[4] = new Point(yellow, Icon.GEAR, board[9][1]);
            points[5] = new Point(red, Icon.STAR, board[11][3]);
            points[6] = new Point(green, Icon.PLANET, board[10][6]);
            points[7] = new Point(blue, Icon.MOON, board[14][5]);
            points[8] = new Point(yellow, Icon.STAR, board[3][9]);
            points[9] = new Point(blue, Icon.STAR, board[12][9]);
            points[10] = new Point(yellow, Icon.PLANET, board[10][10]);
            points[11] = new Point(blue, Icon.PLANET, board[6][11]);
            points[12] = new Point(green, Icon.GEAR, board[1][12]);
            points[13] = new Point(red, Icon.GEAR, board[14][12]);
            points[14] = new Point(red, Icon.MOON, board[4][14]);
            points[15] = new Point(green, Icon.MOON, board[11][14]);
            points[16] = new Point(Color.WHITE, Icon.BLACKHOLE, board[13][7]);
        }
    }

    public void createIconChooser() {
        board[width / 2][height / 2].createWall(Direction.HR);
        board[width / 2][height / 2].createWall(Direction.VB);
        board[width / 2][height / 2].touching();
        board[width / 2 + 1][height / 2].createWall(Direction.HL);
        board[width / 2][height / 2 + 1].createWall(Direction.VT);

        board[width / 2 - 1][height / 2].createWall(Direction.VB);
        board[width / 2 - 1][height / 2].createWall(Direction.HL);
        board[width / 2 - 1][height / 2].touching();
        board[width / 2 - 1][height / 2 + 1].createWall(Direction.VT);
        board[width / 2 - 2][height / 2].createWall(Direction.HR);

        board[width / 2][height / 2 - 1].createWall(Direction.VT);
        board[width / 2][height / 2 - 1].createWall(Direction.HR);
        board[width / 2][height / 2 - 1].touching();
        board[width / 2][height / 2 - 2].createWall(Direction.VB);
        board[width / 2 + 1][height / 2 - 1].createWall(Direction.HL);

        board[width / 2 - 1][height / 2 - 1].createWall(Direction.VT);
        board[width / 2 - 1][height / 2 - 1].createWall(Direction.HL);
        board[width / 2 - 1][height / 2 - 1].touching();
        board[width / 2 - 2][height / 2 - 1].createWall(Direction.HR);
        board[width / 2 - 1][height / 2 - 2].createWall(Direction.VB);
    }

    public void createRobots() {
        robots = new Robot[allRobots];

        Random random = new Random();

        for (int i = 0; i < allRobots; i++) {

            int tempx = random.nextInt(width);
            int tempy = random.nextInt(height);
            if (board[tempx][tempy].isTouching()) {
                i--;
            } else {
                switch (i) {
                    case 0 -> robots[i] = new Robot(red, board[tempx][tempy]);
                    case 1 -> robots[i] = new Robot(blue, board[tempx][tempy]);
                    case 2 -> robots[i] = new Robot(green, board[tempx][tempy]);
                    case 3 -> robots[i] = new Robot(yellow, board[tempx][tempy]);
                    case 4 -> robots[i] = new Robot(Color.GRAY, board[tempx][tempy]);
                    default -> robots[i] = new Robot(board[tempx][tempy]);
                }
            }


        }
    }

    public void setPoint() {
        Point[] completedPoints = new Point[numberPoints];
        Random rand = new Random();
        int temp = rand.nextInt(numberPoints);
        boolean madeGoal = false;
        boolean conflict = false;
        while (!madeGoal) {
            for (int i = 0; i < numberPoints; i++) {
                if (points[temp] == completedPoints[i]) {
                    conflict = true;
                    break;
                }
            }
            if (conflict) {
                temp = rand.nextInt(numberPoints);
            } else {
                curPoint = points[temp];
                for (int i = 0; i < robots.length; i++) {
                    if (curPoint.color == robots[i].color) {
                        pointRobot = robots[i];
                    }
                }
                madeGoal = true;
            }
        }


    }

    public void setFirstPositions() {
        for (int i = 0; i < robots.length; i++) {
            firstPositions[i] = robots[i].getLivePosition();
        }
    }


    public Point getCurPoint() {
        return curPoint;
    }

    public Position getPosition(int x, int y) {
        return board[x][y];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Robot[] getRobots() {
        return robots;
    }

    public void setUsedRobot(Robot usedRobot) {
        this.usedRobot = usedRobot;
    }

    public Robot getUsedRobot() {
        return usedRobot;
    }

    public void setTimeInt(int timeInt, int timeDigit) {
        this.timeInt = timeInt;
        this.displayedTime = timeDigit;

    }

    public void orderOfPassage() {
        movesTotal += movesNumber;
        timePassed += displayedTime;
        if (timePassed > 9) {
            timePassed -= 10;
            totalTimeInt += 1;
        }

        totalTimeInt += timeInt;

        setPoint();
        start = true;
        movesNumber = 0;
        setFirstPositions();
    }

    public String getTimeString() {
        return "Time: " + timeInt + "." + displayedTime;
    }
    public int getMovesNumber() {
        return movesNumber;
    }
    public int getMovesTotal() {
        return movesTotal;
    }

    public void reset() {
        for (int i = 0; i < firstPositions.length; i++) {
            robots[i].getLivePosition().notTouching();
            robots[i].setLivePosition(firstPositions[i]);
            robots[i].getLivePosition().touching();
            movesNumber = 0;
        }
    }

    public Robot getPointRobot() {
        return pointRobot;
    }

    public void moveRobot(Robot robot, Direction dir) {
        switch (dir) {
            case VT -> {
                robot.getLivePosition().notTouching();
                while (!(robot.getLivePosition().detectWall(dir) || board[robot.getLivePosition().getX()][robot.getLivePosition().getY() - 1].isTouching())) {
                    robot.setLivePosition(board[robot.getLivePosition().getX()][robot.getLivePosition().getY() - 1]);
                }
                robot.getLivePosition().touching();
            }
            case HR -> {
                robot.getLivePosition().notTouching();
                while (!(robot.getLivePosition().detectWall(dir) || board[robot.getLivePosition().getX() + 1][robot.getLivePosition().getY()].isTouching())) {
                    robot.setLivePosition(board[robot.getLivePosition().getX() + 1][robot.getLivePosition().getY()]);
                }
                robot.getLivePosition().touching();
            }
            case VB -> {
                robot.getLivePosition().notTouching();
                while (!(robot.getLivePosition().detectWall(dir) || board[robot.getLivePosition().getX()][robot.getLivePosition().getY() + 1].isTouching())) {
                    robot.setLivePosition(board[robot.getLivePosition().getX()][robot.getLivePosition().getY() + 1]);
                }
                robot.getLivePosition().touching();
            }
            case HL -> {
                robot.getLivePosition().notTouching();
                while (!(robot.getLivePosition().detectWall(dir) || board[robot.getLivePosition().getX() - 1][robot.getLivePosition().getY()].isTouching())) {
                    robot.setLivePosition(board[robot.getLivePosition().getX() - 1][robot.getLivePosition().getY()]);
                }
                robot.getLivePosition().touching();
            }
        }
    }

    public void addMoves() {
        movesNumber += 1;
    }

    public Point[] getPoints() {
        return points;
    }

    public String toString() {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < width; i++) {
            StringBuilder inner = new StringBuilder();
            for (int j = 0; j < height; j++) {
                inner.append(board[j][i].toString());
            }
            temp.append(inner).append("\n");
        }
        return temp.toString();
    }


}
