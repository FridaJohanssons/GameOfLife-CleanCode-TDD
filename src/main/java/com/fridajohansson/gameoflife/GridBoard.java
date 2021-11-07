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

    public String printBoard(){
        System.out.println("----");
        String result = "";

        for (int j = 0; j<height; j++){
            String cell = "";
            for (int i = 0; i<width; i++){
                if(this.gridBoardarray[i][j]==0){
                    cell +=".";
                    result+=".";

                }else{
                    cell +="*";
                    result+="*";
                }
            }
            System.out.println(cell);
        }
        System.out.println("----\n");
        System.out.println("\n");
        return result;
    }


    public void setAlive(int i, int j){
        this.setState(i,j,1);}
    public void setDead(int i, int j){
        this.setState(i,j,0);
    }

    public void setState(int i, int j, int state){
        if(i < 0 || i >= width){
            return;
        }
        if(j < 0 || j >= height){
            return;
        }
        this.gridBoardarray[i][j] = state;
    }

    public int countNeighbours(int i, int j){
        int count = 0;
        count += getState(i-1,j-1);
        count += getState(i,j-1);
        count += getState(i+1,j-1);

        count += getState(i-1,j);
        count += getState(i+1,j);

        count += getState(i-1,j+1);
        count += getState(i,j+1);
        count += getState(i+1,j+1);

        return count;
    }

    public void nextGen(){
        int [][] newBoard = new int[width][height];
        for(int j = 0; j < height; j++){
            for(int i = 0; i < width; i++){
                int aliveNeighbours = countNeighbours(i,j);

                if(getState(i,j) == 1){
                    if(aliveNeighbours < 2){
                        newBoard[i][j] = 0;
                    } else if(aliveNeighbours == 2 || aliveNeighbours == 3){
                        newBoard[i][j] =1;
                    }else if (aliveNeighbours > 3){
                        newBoard[i][j] = 0;
                    }
                }else{
                    if(aliveNeighbours == 3){
                        newBoard[i][j] = 1;
                    }
                }
            }
        }
        this.gridBoardarray = newBoard;

    }

    public int getState(int i, int j){
        if(i < 0 || i >= width){
            return 0;
        }
        if(j < 0 || j >= height){
            return 0;
        }
        return gridBoardarray[i][j];
    }

}
