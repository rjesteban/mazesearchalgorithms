
import java.io.IOException;
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
public abstract class InformedSearchAlgo extends UninformedSearchAlgo{

    public InformedSearchAlgo(String file) throws IOException {
        super(file);
    }
    public abstract void computeHeuristic(Node v);
    public abstract void computeCost(Node v);
    @Override
    public abstract void solve();
    
    
    public void printForTinyMaze(Node current, Queue<Node> frontier, int iter) {
        System.out.println("=================================");
        printMaze();
        System.out.println("ITERATION NUMBER " + iter);
        if (current.neighbor != null) {
            System.out.println("Current Node being Expanded: " + current.pos.x + " " + current.pos.y);
            System.out.println("FRONTIER NODES AND THEIR F VALUES");
            for (Node neighbor : frontier) {
                System.out.println("Node: (" + neighbor.pos.x + "," + neighbor.pos.y + ") F Value: " + neighbor.getF());
            }
        }

    }
}
