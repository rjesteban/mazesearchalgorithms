
import java.awt.Point;
import java.util.ArrayList;

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
    ArrayList<Vertex> neighbor;
    Integer depth;
    
    public double f;
    public double g;
    public double h;
    
    public Vertex(Point _pos, Vertex _parent,int _depth){
        pos = _pos;
        parent = _parent;
        depth = _depth;
    }
    
    
    public double getH(){
        return h;
    }
    
    public void setH(double _h){
        h = _h;
    }
    
    
       @Override
    public boolean equals(Object o) {
        return o.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.pos.x;
        hash = 59 * hash + this.pos.y;
        return hash;
    }  
}
