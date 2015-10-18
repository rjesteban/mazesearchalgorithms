import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
public abstract class UninformedSearchAlgo {
    public char[][] maze;
    public Point startPoint;
    public Point endPoint;
    public int maxDepth;
    public int maxFrontierSize;
    public int nodesExpanded;
    public int visited;
    public Node endVertex;
    public String fileName;
    public abstract void solve();
    
    
    public UninformedSearchAlgo(String file) throws IOException{
        BufferedReader sc = new BufferedReader(new FileReader(new File(file)));
        nodesExpanded = maxFrontierSize = maxDepth = visited = 0;
        
        fileName = file;
        
        ArrayList<String> rows = new ArrayList<String>();
        String s = sc.readLine();
        while(s !=null){
            rows.add(s);
            s = sc.readLine();
        }
        
        maze = new char[rows.size()][rows.get(0).length()];
        
        for(int r=0;r<rows.size();r++){
            for(int c=0;c<rows.get(0).length();c++){
                maze[r][c] = rows.get(r).charAt(c);
                if(maze[r][c] == 'P'){
                    startPoint = new Point(c,r);
                }
                if(maze[r][c]=='.')
                    endPoint = new Point(c,r);
            }
        }
    }
    
    public void printMaze(){
        for(int r=0; r<maze.length; r++){
            for(int c=0; c<maze[0].length; c++){
                System.out.print(maze[r][c]);
            }
            System.out.println();
        }
    }
    
    public void addNeigbor(Node v){
        ArrayList<Node> neighbors = new ArrayList<Node>();
        
        Point up = new Point(v.pos.x,v.pos.y-1);
        Point right = new Point(v.pos.x+1,v.pos.y);
        Point down = new Point(v.pos.x,v.pos.y+1);
        Point left = new Point(v.pos.x-1,v.pos.y);
        
        //================================================
        if(isWalkable(left)){
            neighbors.add(new Node(left,v,v.depth+1));
            if(maxDepth<v.depth+1){
                maxDepth = v.depth+1;
            }
        }
        
        if(isWalkable(right)){
            neighbors.add(new Node(right,v,v.depth+1));
            if(maxDepth<v.depth+1){
                maxDepth = v.depth+1;
            }
        }
        
            if(isWalkable(down)){
            neighbors.add(new Node(down,v,v.depth+1));
            if(maxDepth<v.depth+1){
                maxDepth = v.depth+1;
            }
        }
            
        if(isWalkable(up)){
            neighbors.add(new Node(up,v,v.depth+1));
            if(maxDepth<v.depth+1){
                maxDepth = v.depth+1;
            }
        }
        
        v.neighbor = neighbors;
    }
    
    public boolean isWalkable(Point p){
        if(maze[p.y][p.x] =='%' || maze[p.y][p.x] == 'C' ||
                /*maze[p.y][p.x] == 'F' ||*/ maze[p.y][p.x]=='V')
            return false;
        return true;
    }
    
    public int getDepth(Node v){
        int depth = 0 ;
        while(v.parent!=null){
            depth++;
            v = v.parent;
        }
        return depth;
    }
    
    public void printSolution(){
        Node w = endVertex;
        int dep = getDepth(w);
        Stack<Node> trace = new Stack<Node>();
        
        while(w!=null){
            maze[w.pos.y][w.pos.x] = '.';
            trace.push(w);
            w = w.parent;
        }
        //printMaze();
        System.out.println();
        System.out.print("Path: ");
        while(!trace.isEmpty()){
            System.out.print(trace.pop().toString());
        }
        System.out.println();
        
        System.out.println("Path Cost:"+dep);
        System.out.println("#Nodes Expanded:"+nodesExpanded);
        System.out.println("Maximum Depth Reached:"+maxDepth);
        System.out.println("Maximum Size Frontier:"+maxFrontierSize);
    }
}
