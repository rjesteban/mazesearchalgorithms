
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
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
public class BFSAlgo extends UninformedSearchAlgo{

    public BFSAlgo(String file) throws IOException {
        super(file);
    }

    @Override
    public void solve() {
        Node current = null;
        Queue<Node> q = new LinkedList<Node>();
        q.offer(new Node(startPoint,null,0));
        int iteration = 0;
        while(!q.isEmpty()){
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
            printMaze();
        }
        printMaze();
        printSolution();
    }
    
    public static void main(String[] args) throws IOException {
        BFSAlgo bfs = new BFSAlgo("sss.txt");
        bfs.solve();
    }
}
