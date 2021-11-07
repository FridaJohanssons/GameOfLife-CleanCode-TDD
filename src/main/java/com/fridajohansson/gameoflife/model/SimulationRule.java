package com.fridajohansson.gameoflife.model;

public interface SimulationRule {
    CellState getNextState(int i, int j, Board board);
}
