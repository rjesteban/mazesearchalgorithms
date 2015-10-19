package part3;


import java.awt.Point;
import utils.UninformedSearchAlgo;
import utils.Node;
import java.io.IOException;
import java.util.ArrayList;
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
public class DFSAlgo1 extends UninformedSearchAlgo {
    ArrayList<Point> endPoints;
    
    
    public DFSAlgo1(String file) throws IOException {
        super(file);
        endPoints = new ArrayList<Point>();
        reReadMaze(endPoints);
    }
    
    @Override
    public void solve() {
        ArrayList<Node> goals = new ArrayList<Node>();
        Node current = null;
        Stack<Node> stack = new Stack<Node>();
        stack.push(new Node(startPoint,null,0));
        int iteration = 0;
        while(!stack.isEmpty()){
            try{
                if(!current.pos.equals(endPoint)){
                    maze[current.pos.y][current.pos.x ] = 'V';
                    nodesExpanded++;
                }
            }catch(Exception e){}
            
            current = stack.pop();
            maze[current.pos.y][current.pos.x ] = 'C';
            
            if(endPoints.contains(current.pos)){
                endVertex = current;
                goals.add(current);
                endPoints.remove(current.pos);
            }
            
            addNeigbor(current);
            
            for(Node _neighbor:current.neighbor){
                if(!stack.contains(_neighbor)){
                    maze[_neighbor.pos.y][_neighbor.pos.x] = 'F';
                    stack.push(_neighbor);
                }
            }
            if(maxFrontierSize<stack.size()){
                maxFrontierSize=stack.size();
            }
            
            printForTinyMaze(current, stack, ++iteration);
        }
        System.out.print("-------" + "DFS " + fileName.split("\\.")[0]+"-------");
        printSolution1(goals);
    }
    
    
    
    public static void main(String[] args) throws IOException {
        DFSAlgo1 dfs = new DFSAlgo1("trialtinynila");
        //DFSAlgo1 dfs = new DFSAlgo1("tinyMaze.lay.txt");
        dfs.solve();
    }
    
}
