package com.fridajohansson.gameoflife.model;

import com.fridajohansson.gameoflife.GridBoard;

public class BoundedBoard implements Board {

    private int width;
    private int height;
    private CellState [][] gridBoardarray;

    public BoundedBoard(int width, int height) {
        this.width = width;
        this.height = height;
        this.gridBoardarray = new CellState[width][height];

        for(int j = 0; j< this.height; j++) {
            for (int i = 0; i < this.width; i++) {
                setState(i,j, CellState.DEAD);
            }
        }
    }

    @Override
    public BoundedBoard copy() {
        BoundedBoard copy = new BoundedBoard(this.width, this.height);

        for(int j = 0; j< this.height; j++){
            for(int i = 0; i < this.width; i++){
                copy.setState(i,j, this.getState(i,j));
            }
        }
        return copy;
    }

    @Override
    public CellState getState(int i, int j) {
        return null;
    }

    @Override
    public void setState(int i, int j, CellState cellState) {

    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }
}
