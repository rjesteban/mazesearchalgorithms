package utils;


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
public class Node {
    public Point pos;
    public Node parent;
    public ArrayList<Node> neighbor;
    public Integer depth;
    
    public double f;
    public double g;
    public double h;
    
    public Node(Point _pos, Node _parent,int _depth){
        pos = _pos;
        parent = _parent;
        depth = _depth;
    }
    
    public int getDepth(){
        return depth;
    }
    
    
    public double getH(){
        return h;
    }
    
    public double getF(){
        return f;
    }
    
    public double getG(){
        return g;
    }
    
    public Node getParent(){
        return parent;
    }
    
    public void setParent(Node _parent){
        parent = _parent;
    }
    
    public void setH(double _h){
        h = _h;
    }
    
    public void setF(double _f){
        f = _f;
    }
    
    public void setG(double _g){
        g = _g;
    }
    
       @Override
    public boolean equals(Object o) {
        return o.hashCode() == this.hashCode();
    }
    
    @Override
    public String toString(){
        return "(" +pos.x + "," + pos.y + ")";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.pos.x;
        hash = 59 * hash + this.pos.y;
        return hash;
    }  
}
