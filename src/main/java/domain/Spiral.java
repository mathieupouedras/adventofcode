package domain;

class Spiral {

    private int[][] squares;
    private final int dimension;
    private Dimension lastMove;
    int currentX;
    int currentY;

    Spiral(int dimension) {
        this.dimension = dimension;
        this.currentX = dimension / 2;
        this.currentY = dimension / 2;
        squares = new int[dimension][dimension];
        squares[currentY][currentX] = 1;
    }

    void grow(int location) {
        for (int i = 2; i <= location; i++) {
            move(i);
            squares[currentY][currentX] = location;
        }
    }

    void growPart2(int location) {
        int i = 2;
        while (squares[currentY][currentX] <= location) {
            move(i);
            squares[currentY][currentX] =
                    squares[currentY + 1][currentX]
                            + squares[currentY + 1][currentX + 1]
                            + squares[currentY + 1][currentX - 1]
                            + squares[currentY][currentX + 1]
                            + squares[currentY][currentX - 1]
                            + squares[currentY - 1][currentX]
                            + squares[currentY - 1][currentX + 1]
                            + squares[currentY - 1][currentX - 1];


        }
        i++;
    }


    void move(int location) {
        if (Dimension.RIGHT.equals(lastMove)) {
            if (isSquareAvailable(currentX, currentY -1)) {
                moveUp();
            }
            else {
                moveRight();
            }
        }
        else if (Dimension.UP.equals(lastMove)) {
            if (isSquareAvailable(currentX - 1, currentY)) {
                moveLeft();
            }
            else {
                moveUp();
            }
        }
        else if (Dimension.LEFT.equals(lastMove)) {
            if (isSquareAvailable(currentX, currentY + 1)) {
                moveDown();
            }
            else {
                moveLeft();
            }
        }
        else if (Dimension.DOWN.equals(lastMove)) {
            if (isSquareAvailable(currentX + 1, currentY)) {
                moveRight();
            }
            else {
                moveDown();
            }
        }
        else {
            moveRight();
        }
    }

    private void moveRight() {
        currentX++;
        lastMove = Dimension.RIGHT;
    }

    private void moveDown() {
        currentY++;
        lastMove = Dimension.DOWN;
    }

    private void moveLeft() {
        currentX--;
        lastMove = Dimension.LEFT;
    }

    private void moveUp() {
        currentY--;
        lastMove = Dimension.UP;
    }

    boolean isSquareAvailable(int x, int y) {
        return squares[y][x] == 0;
    }


    enum Dimension {
        RIGHT,
        UP,
        LEFT,
        DOWN
    }

    void print() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(squares[i][j] + " ");
            }
            System.out.println();
        }
    }

    int getSteps() {
        return Math.abs(dimension / 2 - currentX) + Math.abs(dimension / 2 - currentY);
    }

    int getFirstLargerVayleThanInput() {
        return squares[currentY][currentX];
    }
}
