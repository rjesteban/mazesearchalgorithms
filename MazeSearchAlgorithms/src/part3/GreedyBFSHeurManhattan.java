package part3;


import java.awt.Point;
import utils.InformedSearchAlgo;
import utils.Node;
import java.io.IOException;
import java.util.ArrayList;
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
public class GreedyBFSHeurManhattan extends InformedSearchAlgo{

    public ArrayList<Point> endPoints;
    
    public GreedyBFSHeurManhattan(String file) throws IOException {
        super(file);
        endPoints = new ArrayList<Point>();
        reReadMaze(endPoints);
        
    }

    @Override
    public void computeHeuristic(Node v) {
        v.setH( Math.abs(v.pos.x-endPoint.x)+
              Math.abs(v.pos.y-endPoint.y)
        );
    }
    
    @Override
    public void computeCost(Node v) {
        v.setG(0);
        v.setF(v.getH());
    }

    @Override
    public void solve() {
        ArrayList<Node> goals = new ArrayList<Node>();
        
        for(Point cur: endPoints){
            endPoint = cur;
        
            int iteration = 0;
            PriorityQueue<Node> q = new PriorityQueue<Node>(
                new Comparator<Node>(){
                    @Override
                    public int compare(Node o2, Node o1){
                        double _o1 = o1.getH();
                        double _o2 = o2.getH();
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
            computeHeuristic(start);
            q.offer(start);
            Node current = null;
            while(!q.isEmpty() && !endPoints.isEmpty()){

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
                    goals.add(current);
                    resetMaze();
                    break;
                }

                addNeigbor(current);

                for(Node _neighbor:current.neighbor){
                    if(!q.contains(_neighbor)){
                        maze[_neighbor.pos.y][_neighbor.pos.x] = 'F';
                        computeHeuristic(_neighbor);
                        computeCost(_neighbor);
                        q.offer(_neighbor);
                    }
                }
                if(maxFrontierSize<q.size()){
                    maxFrontierSize=q.size();
                }
                //System.out.println();
                //printMaze();
            //    printForTinyMaze(current, q, ++iteration);
            }
        }
        //printMaze();
        //System.out.println();
        System.out.print("-------" + "Greedy BFS Manhattan " + fileName.split("\\.")[0]+"-------");
        printSolution1(goals);
    }
    
    public static void main(String[] args) throws IOException {
        GreedyBFSHeurManhattan gbfs = new GreedyBFSHeurManhattan("trialtinynila");
        gbfs.solve();
    }
    
}
