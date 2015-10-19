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
public class AStarCustomHeur1 extends InformedSearchAlgo{

    public ArrayList<Point> endPoints;
    
    public AStarCustomHeur1(String file) throws IOException {
        super(file);
        endPoints = new ArrayList<Point>();
        reReadMaze(endPoints);
    }

    @Override
    public void computeHeuristic(Node v) {
        v.setH(1);
    }

    @Override
    public void computeCost(Node v) {
        computeHeuristic(v);
        try{
            v.setG(v.getParent().getG() + 1);
        }
        catch(Exception e){
            v.setG(0);
        }
        v.setF(v.getG()+v.getH());
    }

    @Override
    public void solve() {
        ArrayList<Node> goals = new ArrayList<Node>();
        int iteration=0;
        PriorityQueue<Node> openList = new PriorityQueue<Node>(
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
        ArrayList<Node> closedList = new ArrayList<Node>();
        
        Node start = new Node(startPoint,null,0);
        
        computeHeuristic(start);
        computeCost(start);
        openList.offer(start);
        
        
        Node current = null;
        
        
        while(!openList.isEmpty() && !endPoints.isEmpty()){
            try{
                if(!current.pos.equals(endPoint)){
                    maze[current.pos.y][current.pos.x ] = 'V';
                    nodesExpanded++;
                }
            }catch(Exception e){}
            
            current = openList.remove();
            maze[current.pos.y][current.pos.x ] = 'C';
            
            closedList.add(current);
            
            if(endPoints.contains(current.pos)){
                endVertex = current;
                goals.add(current);
                endPoints.remove(current.pos);
            }
            
            addNeigbor(current);
            
            for(Node _neighbor:current.neighbor){
                if(!openList.contains(_neighbor)){
                    maze[_neighbor.pos.y][_neighbor.pos.x] = 'F';
                    computeHeuristic(_neighbor);
                    computeCost(_neighbor);
                    openList.offer(_neighbor);                
                }
                else{
                    if(_neighbor.getG()>current.getG()+1){
                        _neighbor.setParent(current);
                        computeHeuristic(_neighbor);
                        computeCost(_neighbor);
                    }
                }
            }
            
            if(maxFrontierSize<openList.size()){
                maxFrontierSize=openList.size();
            }
            //printMaze();
            //System.out.println();
            //printForTinyMaze(current, openList, ++iteration);
        }
        //printMaze();
        //System.out.println();
        System.out.print("-------" + "A* Search @ h(s) =1 " + fileName.split("\\.")[0]+"-------");
        printSolution1(goals);
    }
    
    public static void main(String[] args) throws IOException {
        AStarCustomHeur1 gbfs = new AStarCustomHeur1("trialtinynila");
        gbfs.solve();
//            GreedyBFSEuclidean gbfsm = new GreedyBFSEuclidean("soopen.in");
//            gbfsm.solve();
//        BFSAlgo gbfst = new BFSAlgo("soopen.in");
//        gbfst.solve();
    }
    
    
}
