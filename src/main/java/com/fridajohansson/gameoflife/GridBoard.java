package com.fridajohansson.gameoflife;

public class GridBoard {

    int width;

    int height;
    int [][] gridBoardarray;

    public GridBoard(int width, int height) {
        this.width = width;
        this.height = height;

        this.gridBoardarray = new int[width][height];
    }

}
