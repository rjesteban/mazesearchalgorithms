
import java.awt.Point;
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
public class AStarManhattan extends InformedSearchAlgo{

    public AStarManhattan(String file) throws IOException {
        super(file);
    }

    @Override
    public void computeHeuristic(Vertex v) {
        v.setH( Math.abs(v.pos.x-endPoint.x)+
              Math.abs(v.pos.y-endPoint.y)
        );
    }

    @Override
    public void computeCost(Vertex v) {
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
        PriorityQueue<Vertex> openList = new PriorityQueue<Vertex>(
            new Comparator<Vertex>(){
                @Override
                public int compare(Vertex o2, Vertex o1){
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
        ArrayList<Vertex> closedList = new ArrayList<Vertex>();
        
        Vertex start = new Vertex(startPoint,null,0);
        
        computeHeuristic(start);
        computeCost(start);
        openList.offer(start);
        
        
        Vertex current = null;
        
        while(!openList.isEmpty()){
            try{
                if(!current.pos.equals(endPoint)){
                    maze[current.pos.y][current.pos.x ] = 'V';
                    nodesExpanded++;
                }
            }catch(Exception e){}
            
            current = openList.remove();
            maze[current.pos.y][current.pos.x ] = 'C';
            
            closedList.add(current);
            
            if(current.pos.equals(endPoint)){
                endVertex = current;
                break;
            }
            
            addNeigbor(current);
            
            for(Vertex _neighbor:current.neighbor){
                if(!openList.contains(_neighbor)){
                    maze[_neighbor.pos.y][_neighbor.pos.x] = 'F';
                    computeHeuristic(_neighbor);
                    computeCost(_neighbor);
                    openList.offer(_neighbor);                
                }
                else{
                    if(_neighbor.getG()>current.getG()+1){
                        System.out.println("kldjasdklasjdklasjdlkasjaskldasdasdklsadsaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                    }
                }
            }
            
//            Vertex left = new Vertex(new Point(current.pos.x-1,current.pos.y),current,current.getDepth()+1);
//            Vertex up = new Vertex(new Point(current.pos.x,current.pos.y-1),current,current.getDepth()+1);
//            Vertex right = new Vertex(new Point(current.pos.x+1,current.pos.y),current,current.getDepth()+1);
//            Vertex down = new Vertex(new Point(current.pos.x,current.pos.y+1),current,current.getDepth()+1);
//            
//            
//            ArrayList<Vertex> neighbors = new ArrayList<Vertex>();
//            
//            neighbors.add(left);
//            neighbors.add(up);
//            neighbors.add(right);
//            neighbors.add(down);
//            
//            for(Vertex _n: neighbors){
//                if()
//            }
            
            
            if(maxFrontierSize<openList.size()){
                maxFrontierSize=openList.size();
            }
            printMaze();
        }
        printMaze();
        printSolution();
    }
    
    public static void main(String[] args) throws IOException {
        AStarManhattan gbfs = new AStarManhattan("sss.txt");
        gbfs.solve();
//            GreedyBFSEuclidean gbfsm = new GreedyBFSEuclidean("soopen.in");
//            gbfsm.solve();
//        BFSAlgo gbfst = new BFSAlgo("soopen.in");
//        gbfst.solve();
    }
    
    
}
