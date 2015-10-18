
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void solve() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
