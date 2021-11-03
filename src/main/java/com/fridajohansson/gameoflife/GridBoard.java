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
        String result = "";
        for (int i = 0; i<height; i++){
            String cell = "";
            for (int j = 0; j<width; j++){
                if(this.gridBoardarray[j][i]==0){
                    cell +=".";
                    result+=".";

                }else{
                    cell +="*";
                    result+="*";
                }
            }
            System.out.println(cell);
        }

        return result;
    }

    public void setAlive(int i, int j){
        this.gridBoardarray[i][j] =1;
    }
    public void setDead(int i, int j){
        this.gridBoardarray[i][j] =0;
    }

    public int countNeighbours(int x, int y){
        int count = 0;
        count += this.gridBoardarray[x-1][y-1];
        count += this.gridBoardarray[x][y-1];
        count += this.gridBoardarray[x+1][y-1];

        count += this.gridBoardarray[x-1][y];
        count += this.gridBoardarray[x+1][y];

        count += this.gridBoardarray[x-1][y+1];
        count += this.gridBoardarray[x][y+1];
        count += this.gridBoardarray[x+1][y+1];

        return count;
    }

}
