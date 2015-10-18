
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rjesteban
 */
public class Test {
    public static void main(String[] args) throws IOException{
        
        printByMaze("tinyMaze.lay.txt");
        System.out.println("----------------------------------------");
        printByMaze("smallMaze.lay.txt");
        System.out.println("----------------------------------------");
        printByMaze("mediumMaze.lay.txt");
        System.out.println("----------------------------------------");
        printByMaze("bigMaze.lay.txt");
        System.out.println("----------------------------------------");
        printByMaze("openMaze.lay.txt");
        
    }
    
    public static void printByMaze(String maze) throws IOException{
        BFSAlgo algo = new BFSAlgo(maze);
        algo.solve();
        DFSAlgo algo1 = new DFSAlgo(maze);
        algo1.solve();
        GreedyBFSEuclidean algo2 = new GreedyBFSEuclidean(maze);
        algo2.solve();
        GreedyBFSManhattan algo3 = new GreedyBFSManhattan(maze);
        algo3.solve();
        AStarEuclidean algo4 = new AStarEuclidean(maze);
        algo4.solve();
        AStarManhattan algo5 = new AStarManhattan(maze);
        algo5.solve();
    
    }
}
