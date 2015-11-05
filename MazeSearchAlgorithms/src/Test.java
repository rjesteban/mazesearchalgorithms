
import part1.BFSAlgo;
import part1.AStarEuclidean;
import part1.GreedyBFSEuclidean;
import part1.GreedyBFSManhattan;
import part1.DFSAlgo;
import part1.AStarManhattan;
import part2.UCSc2;
import part2.UCSc1;
import java.io.IOException;
import part3.*;

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
        
        printByMazePart1("tinyMaze.lay.txt");
//        printByMazePart2("tinyMaze.lay.txt");
        System.out.println("----------------------------------------");
        printByMazePart1("smallMaze.lay.txt");
//       printByMazePart2("smallMaze.lay.txt");
        System.out.println("----------------------------------------");
        printByMazePart1("mediumMaze.lay.txt");
//        printByMazePart2("mediumMaze.lay.txt");
        System.out.println("----------------------------------------");
        printByMazePart1("bigMaze.lay.txt");
//        printByMazePart2("bigMaze.lay.txt");
        System.out.println("----------------------------------------");
        printByMazePart1("openMaze.lay.txt");
        //printByMazePart2("openMaze.lay.txt");
                
        
        printByMazePart3("tinySearch.lay.txt");
        System.out.println("----------------------------------------");
        printByMazePart3("smallSearch.lay.txt");
        System.out.println("----------------------------------------");
        printByMazePart3("trickySearch.lay.txt");
        System.out.println("----------------------------------------");
        
        
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
    
    public static void printByMazePart3(String maze) throws IOException{
        BFSAlgo1 c1 = new BFSAlgo1(maze);
        c1.solve();
        DFSAlgo1 c2 = new DFSAlgo1(maze);
        c2.solve();
        GreedyBFSCustomHeur0 c3 = new GreedyBFSCustomHeur0(maze);
        c3.solve();
        GreedyBFSCustomHeur1 c4 = new GreedyBFSCustomHeur1(maze);
        c4.solve();
        GreedyBFSCustomHeurFoodOverNumberOfFood c5 = new GreedyBFSCustomHeurFoodOverNumberOfFood(maze);
        c5.solve();
        GreedyBFSHeurEuclidean c6 = new GreedyBFSHeurEuclidean(maze);
        c6.solve();
        GreedyBFSHeurManhattan c7 = new GreedyBFSHeurManhattan(maze);
        c7.solve();
        AStarCustomHeur0 a1 = new AStarCustomHeur0(maze);
        a1.solve();
        AStarCustomHeur1 a2 = new AStarCustomHeur1(maze);
        a2.solve();
        AStarCustomHeurFoodOverNumberOfFood a3 = new AStarCustomHeurFoodOverNumberOfFood(maze);
        a3.solve();
        AStarCustomHeurEuclidean a4 = new AStarCustomHeurEuclidean(maze);
        a4.solve();
        AStarCustomHeurManhattan a5 = new AStarCustomHeurManhattan(maze);
        a5.solve();
        
    }
    
    
}
