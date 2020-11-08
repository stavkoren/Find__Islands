package Map;

import Constants.MapConstants;

import java.util.*;

public class Map {
    private Cell[][] matrix; //matrix of the map
    private int n;
    private int m;

    public Map(int n, int m) {
        this.n=n;
        this.m=m;
        CreateMap();
    }

    private void CreateMap() {
        this.matrix = new Cell[n][m];
        for (int row=0;row<n;row++){
            for (int column=0;column<m;column++){
                int num=new Random().nextInt(MapConstants.twentyPrecentProb);
                if(num==0){
                    this.matrix[row][column]=new Cell(Mark.LAND);
                }else {
                    this.matrix[row][column] = new Cell(Mark.SEA);
                }
            }
        }
    }

    public Cell[][] getMatrix() {
        return this.matrix;
    }
    public int getRowsNumber() {
        return matrix.length;
    }

    public int getColumnsNumber() {
        return matrix[0].length;
    }
}
