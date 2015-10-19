package part3;


import java.awt.Point;
import utils.UninformedSearchAlgo;
import utils.Node;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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
        reReadMaze(endPoints);
    }
    


    @Override
    public void solve() {
        ArrayList<Node> goals = new ArrayList<Node>();
        Node current = null;
        Queue<Node> q = new LinkedList<Node>();
        q.offer(new Node(startPoint,null,0));
        int iteration = 0;
        while(!q.isEmpty() && !endPoints.isEmpty()){
            try{
                if(!endPoints.contains(current.pos)){
                    maze[current.pos.y][current.pos.x ] = 'V';
                    nodesExpanded++;
                }
            }catch(Exception e){}
            
            current = q.remove();
            maze[current.pos.y][current.pos.x ] = 'C';
            
            //if(current.pos.equals(endPoint)){
            if(endPoints.contains(current.pos)){
                endVertex = current;
                goals.add(current);
                endPoints.remove(current.pos);
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
           // printForTinyMaze(current, (List<Node>) q,++iteration);
        }
        System.out.print("-------" + "BFS " + fileName.split("\\.")[0]+"-------");
        printSolution1(goals);
    }
    
    public static void main(String[] args) throws IOException {
        //BFSAlgo1 bfs = new BFSAlgo1("tinySearch.lay.txt");
        BFSAlgo1 bfs = new BFSAlgo1("trialtinynila");
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

