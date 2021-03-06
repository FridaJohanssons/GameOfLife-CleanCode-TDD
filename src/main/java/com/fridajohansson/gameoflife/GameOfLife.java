package com.fridajohansson.gameoflife;

public class GameOfLife {
    public static void main(String[] args) {
        GridBoard gridBoard = new GridBoard(8,4);

        gridBoard.setAlive(4,1);
        gridBoard.setAlive(3,2);
        gridBoard.setAlive(4,2);
        gridBoard.setAlive(5,2);

        gridBoard.printBoard();
        gridBoard.nextGen();
        gridBoard.printBoard();
        gridBoard.nextGen();
        gridBoard.printBoard();
        gridBoard.nextGen();
        gridBoard.printBoard();
        gridBoard.nextGen();
        gridBoard.printBoard();
        gridBoard.nextGen();
        gridBoard.printBoard();
        gridBoard.nextGen();
        gridBoard.printBoard();

        System.out.println(gridBoard.countNeighbours(1,1));
    }
}
