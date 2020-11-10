package Map;

import Constants.MapConstants;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Map {
    private Cell[][] matrix; //matrix of the map
    private int n;
    private int m;
    private ExecutorService executorService;

    public Map(int n, int m,ExecutorService es) {
        this.n=n;
        this.m=m;
        executorService = es;
        CreateMap();
    }

    private void CreateMap() {
        this.matrix = new Cell[n][m];
        for (int row=0;row<n;row++){
            int finalRow = row;
           executorService.execute(() ->{
            for (int column=0;column<m;column++){
                int num=new Random().nextInt(MapConstants.twentyPrecentProb);
                if(num==0){
                    this.matrix[finalRow][column]=new Cell(Mark.LAND);
                }else {
                    this.matrix[finalRow][column] = new Cell(Mark.SEA);
                }
            }
            /*return null;*/});
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
    public Cell getCell(int r, int c){
        return this.matrix[r][c];
    }
}
