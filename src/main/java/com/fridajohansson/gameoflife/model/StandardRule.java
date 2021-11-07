package com.fridajohansson.gameoflife.model;

public class StandardRule implements SimulationRule{

    @Override
    public CellState getNextState(int i, int j, Board board) {
        int aliveNeighbours = countNeighbours(i,j, board) ;

        if(board.getState(i,j) == CellState.ALIVE){
            if(aliveNeighbours < 2){
                return CellState.DEAD;
            } else if(aliveNeighbours == 2 || aliveNeighbours == 3){
                return CellState.ALIVE;
            }else if (aliveNeighbours > 3){
                return CellState.DEAD;
            }
        }else{
            if(aliveNeighbours == 3){
                return CellState.ALIVE;
            }
        }
        return CellState.DEAD;
    }

    public int countNeighbours(int i, int j, Board board){
        int count = 0;
        count += countCell(i-1,j-1, board);
        count += countCell(i,j-1, board);
        count += countCell(i+1,j-1, board);

        count += countCell(i-1,j, board);
        count += countCell(i+1,j, board);

        count += countCell(i-1,j+1, board);
        count += countCell(i,j+1, board);
        count += countCell(i+1,j+1, board);

        return count;
    }

    private int countCell(int i, int j, Board board){
        if (board.getState(i,j) == CellState.ALIVE){
            return 1;
        }else{
            return 0;
        }
    }
}
