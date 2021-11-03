package com.fridajohansson.gameoflife;

public class GridBoard {

    //J = height
    //i= with
    //the with and height is reversed

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

        for (int i = 0; i<width; i++){
            String cell = "";
            for (int j = 0; j<height; j++){
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

    public int setAlive(int i, int j){
        if(i < 0 || i >= width){
            return 0;
        }
        if(j < 0 || j >= height){
            return 0;
        }
        return gridBoardarray[i][j] =1;
    }
    public void setDead(int i, int j){
        this.gridBoardarray[i][j] =0;
    }

    public int countNeighbours(int i, int j){
        int count = 0;
        count += isAlive(i-1,j-1);
        count += isAlive(i,j-1);
        count += isAlive(i+1,j-1);

        count += isAlive(i-1,j);
        count += isAlive(i+1,j);

        count += isAlive(i-1,j+1);
        count += isAlive(i,j+1);
        count += isAlive(i+1,j+1);

        return count;
    }

    public int isAlive(int i, int j){
        if(i < 0 || i >= width){
            return 0;
        }
        if(j < 0 || j >= height){
            return 0;
        }
        return gridBoardarray[i][j];
    }

}
