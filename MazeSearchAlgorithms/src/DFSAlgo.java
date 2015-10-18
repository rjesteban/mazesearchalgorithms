
import java.io.IOException;
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
public class DFSAlgo extends UninformedSearchAlgo {

    public DFSAlgo(String file) throws IOException {
        super(file);
    }
@Override
    public void solve() {
        Vertex current = null;
        Stack<Vertex> stack = new Stack<Vertex>();
        stack.push(new Vertex(startPoint,null,0));
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
            
            if(current.pos.equals(endPoint)){
                endVertex = current;
                break;
            }
            
            addNeigbor(current);
            
            for(Vertex _neighbor:current.neighbor){
                maze[_neighbor.pos.y][_neighbor.pos.x] = 'F';
                stack.push(_neighbor);
            }
            if(maxFrontierSize<stack.size()){
                maxFrontierSize=stack.size();
            }
            printMaze();
        }
        printMaze();
        printSolution();
    }
    
    public static void main(String[] args) throws IOException {
        DFSAlgo dfs = new DFSAlgo("sss.txt");
        dfs.solve();
    }
    
}
