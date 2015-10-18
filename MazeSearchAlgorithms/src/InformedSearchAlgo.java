
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
public abstract class InformedSearchAlgo extends UninformedSearchAlgo{

    public InformedSearchAlgo(String file) throws IOException {
        super(file);
    }
    public abstract void computeHeuristic(Vertex v);
    public abstract void computeCost(Vertex v);
    @Override
    public abstract void solve();
}
