/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rjesteban
 */
public abstract class MazeAlgorithm {
    public char[][] maze;
    
    public abstract void solve();
    
    public void printMaze(){
        for(int r=0; r<maze.length; r++){
            for(int c=0; c<maze[0].length; c++){
                System.out.print(maze[r][c]);
            }
            System.out.println();
        }
    }
    
    
    
}
