
import java.awt.Point;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rjesteban
 */
public class Vertex {
    Point pos;
    Vertex parent;
    
    public double f;
    public double g;
    public double h;
    
    public Vertex(Point _pos, Vertex _parent){
        pos = _pos;
        parent = _parent;
    }
    
    
}
