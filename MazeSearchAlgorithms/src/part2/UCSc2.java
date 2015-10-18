package part2;


import utils.UninformedSearchAlgo;
import utils.Node;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rjesteban
 */
public class UCSc2 extends UninformedSearchAlgo{

    public UCSc2(String file) throws IOException {
        super(file);
    }
    
    public void computeCost(Node n){
        try{
            n.setF(n.parent.getF() + Math.pow(2,n.pos.x));
        }catch(Exception e){
            n.setF(0);
        }
        
    }

    @Override
    public void solve() {
        int iteration = 0;
        PriorityQueue<Node> q = new PriorityQueue<Node>(
        new Comparator<Node>(){
                @Override
                public int compare(Node o2, Node o1){
                    double _o1 = o1.getF();
                    double _o2 = o2.getF();
                    if (_o1 > _o2) {
                        return -1;
                    } else if (_o1 < _o2) 
                        return 1;
                    else
                        return 0;
                }
            }
        );
        
        Node start = new Node(startPoint,null,0);
        computeCost(start);
        q.offer(start);
        Node current = null;
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
                    computeCost(_neighbor);
                    q.offer(_neighbor);
                }else{
                    double currentF = current.getF() + Math.pow(2,_neighbor.pos.x);
                    if(_neighbor.getF()>currentF){
                        _neighbor.setParent(current);
                        computeCost(_neighbor);
                    }
                }
            }
            if(maxFrontierSize<q.size()){
                maxFrontierSize=q.size();
            }
            //printForTinyMaze1(current, q, ++iteration);
        }
        System.out.print("-------" + "Uniform cost search c2 " + fileName.split("\\.")[0]+"-------");
        printSolution();
        
    }
    
    public void printForTinyMaze1(Node current, PriorityQueue<Node> q, int iteration){
        System.out.println("=================================");
        printMaze();
        System.out.println("ITERATION NUMBER " + iteration);
        if (current.neighbor != null) {
            System.out.println("Current Node being Expanded: " + current.pos.x + " " + current.pos.y);
            System.out.println("FRONTIER NODES");
            for (Node neighbor : q) {
                System.out.println("Node: " + neighbor.toString() + " F Value: " + neighbor.getF());
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        UCSc2 ucs = new UCSc2("tinyMaze.lay.txt");
        ucs.solve();
    }
   
}
