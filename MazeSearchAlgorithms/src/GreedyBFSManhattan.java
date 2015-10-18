
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
public class GreedyBFSManhattan extends InformedSearchAlgo{

    public GreedyBFSManhattan(String file) throws IOException {
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
        v.f = v.g = 0;
    }

    @Override
    public void solve() {
        PriorityQueue<Vertex> q = new PriorityQueue<Vertex>(
            new Comparator<Vertex>(){
                @Override
                public int compare(Vertex o2, Vertex o1){
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
        Vertex start = new Vertex(startPoint,null,0);
        computeHeuristic(start);
        q.offer(start);
        Vertex current = null;
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
            
            for(Vertex _neighbor:current.neighbor){
                maze[_neighbor.pos.y][_neighbor.pos.x] = 'F';
                computeHeuristic(_neighbor);
                q.offer(_neighbor);
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
        GreedyBFSManhattan gbfs = new GreedyBFSManhattan("sss.txt");
        gbfs.solve();
    }
    
}