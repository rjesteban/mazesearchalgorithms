
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
        
//        printByMazePart1("tinyMaze.lay.txt");
        printByMazePart2("tinyMaze.lay.txt");
        System.out.println("----------------------------------------");
//        printByMazePart1("smallMaze.lay.txt");
        printByMazePart2("smallMaze.lay.txt");
        System.out.println("----------------------------------------");
//        printByMazePart1("mediumMaze.lay.txt");
        printByMazePart2("mediumMaze.lay.txt");
        System.out.println("----------------------------------------");
//        printByMazePart1("bigMaze.lay.txt");
        printByMazePart2("bigMaze.lay.txt");
        System.out.println("----------------------------------------");
//        printByMazePart1("openMaze.lay.txt");
        printByMazePart2("openMaze.lay.txt");
        
    }
    
    public static void printByMazePart1(String maze) throws IOException{
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
    
    public static void printByMazePart2(String maze) throws IOException{
        UCSc1 c1 = new UCSc1(maze);
        c1.solve();
        UCSc2 c2 = new UCSc2(maze);
        c2.solve();
    }
}
