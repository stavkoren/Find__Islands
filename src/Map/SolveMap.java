package Map;

import Constants.ConcurrencyConstants;
import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class SolveMap {
    public static int solve(Map map){
        boolean[][] visited= new boolean[map.getRowsNumber()][map.getColumnsNumber()];
        int counter=0;
        for (int row=0; row<map.getRowsNumber();row++){
            for(int col=0; col<map.getColumnsNumber();col++){
                if (!visited[row][col]&&map.getMatrix()[row][col].mark== Mark.LAND){
                    counter++;
                    Color c= Utils.getRandomColor();
                    BFS(map,visited, row,col,c);
                }
            }
        }
        return counter;
    }

    private static boolean isLegal(Map map, Point p, boolean visited[][]){
        if(p.getRow()<map.getRowsNumber()&& p.getCollumn()<map.getColumnsNumber()&&
                p.getRow()>=0&& p.getCollumn()>=0&&
                !visited[p.getRow()][p.getCollumn()]&& map.getMatrix()[p.getRow()][p.getCollumn()].getMark()==Mark.LAND)
            return true;
        return false;
    }

    private static Queue<Point> getNeighbors(Point p){
        Queue q= new LinkedList<Point>();
        q.add(new Point(p.getRow()+1,p.getCollumn()));
        q.add(new Point(p.getRow()-1,p.getCollumn()));
        q.add(new Point(p.getRow(),p.getCollumn()+1));
        q.add(new Point(p.getRow(),p.getCollumn()-1));
        return q;
    }

    private static void BFS(Map map, boolean visited[][], int row, int col,Color c){
        Queue<Point> q=new LinkedList<Point>();
        //Visit the start point and enqueue it
        visited[row][col]=true;
        Point p=new Point(row,col);
        q.add(p);

        while (!q.isEmpty()){
            Point current=q.remove();
            if(map.getMatrix()[current.getRow()][current.getCollumn()].getMark()
                    ==Mark.LAND){
                map.getMatrix()[current.getRow()][current.getCollumn()].setColor(c);
            }
            Queue<Point> neighbors=getNeighbors(current);
            while (!neighbors.isEmpty()){
                Point neighbor=neighbors.remove();
                if(isLegal(map,neighbor,visited)){
                    visited[neighbor.getRow()][neighbor.getCollumn()]=true;
                    q.add(neighbor);
                }
            }
        }
    }

}