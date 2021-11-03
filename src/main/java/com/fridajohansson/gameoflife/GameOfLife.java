package com.fridajohansson.gameoflife;

public class GameOfLife {
    public static void main(String[] args) {
        GridBoard gridBoard = new GridBoard(8,4);

        gridBoard.setAlive(2,2);
        gridBoard.setAlive(3,2);
        gridBoard.setAlive(4,2);

        gridBoard.printBoard();

        System.out.println(gridBoard.countNeighbours(3,2));
    }

}
