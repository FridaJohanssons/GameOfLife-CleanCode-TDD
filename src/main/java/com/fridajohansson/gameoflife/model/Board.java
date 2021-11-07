package com.fridajohansson.gameoflife.model;

public interface Board {
    Board copy();

    CellState getState(int i, int j);

    void setState(int i, int j, CellState cellState);

    int getWidth();

    int getHeight();
}
