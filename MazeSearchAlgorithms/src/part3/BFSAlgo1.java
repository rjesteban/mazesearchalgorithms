package part3;


import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import utils.UninformedSearchAlgo;
import utils.Node;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rjesteban
 */
public final class BFSAlgo1 extends UninformedSearchAlgo{

    ArrayList<Point> endPoints;
    
    public BFSAlgo1(String file) throws IOException {
        super(file);
        endPoints = new ArrayList<Point>();
        reReadMaze();
    }
    
    public void reReadMaze(){
        for(int r=0;r<maze.length;r++){
            for(int c=0;c<maze[0].length;c++){
                if(maze[r][c] == 'P')
                    startPoint = new Point(c,r);
                if(maze[r][c]=='.')
                    endPoints.add(new Point(c,r));
            }
        }
    }

    @Override
    public void solve() {
        Node current = null;
        Queue<Node> q = new LinkedList<Node>();
        q.offer(new Node(startPoint,null,0));
        int iteration = 0;
        while(!q.isEmpty() || endPoints.size()>0){
            try{
                if(!current.pos.equals(endPoint)){
                    maze[current.pos.y][current.pos.x ] = 'V';
                    nodesExpanded++;
                }
            }catch(Exception e){}
            
            current = q.remove();
            maze[current.pos.y][current.pos.x ] = 'C';
            
            if(current.pos.equals(endPoint)){
                endVertex = current;
                break;
            }
            
            addNeigbor(current);
            
            for(Node _neighbor:current.neighbor){
                if(!q.contains(_neighbor)){
                    maze[_neighbor.pos.y][_neighbor.pos.x] = 'F';
                    q.offer(_neighbor);
                }
            }
            if(maxFrontierSize<q.size()){
                maxFrontierSize=q.size();
            }
            printForTinyMaze(current, (List<Node>) q,++iteration);
        }
        System.out.print("-------" + "BFS " + fileName.split("\\.")[0]+"-------");
        printSolution();
    }
    
    public static void main(String[] args) throws IOException {
        BFSAlgo1 bfs = new BFSAlgo1("tinyMaze.lay.txt");
        bfs.solve();
//        bfs = new BFSAlgo("smallMaze.lay.txt");
//        bfs.solve();
//        bfs = new BFSAlgo("mediumMaze.lay.txt");
//        bfs.solve();
//        bfs = new BFSAlgo("bigMaze.lay.txt");
//        bfs.solve();
//        BFSAlgo bfs = new BFSAlgo("openMaze.lay.txt");
//        bfs.solve();
    }
}
