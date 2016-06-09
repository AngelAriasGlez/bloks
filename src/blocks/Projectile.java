/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocks;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author aariasgonzalez
 */
public class Projectile extends Object{
    
    public Projectile(World world, int x, int y){
        super(world, x, y, 5, 10);
        mVelocity.y = -0.25f; 
    }
    public void draw(Graphics g){
    	super.draw(g);
        g.setColor(Color.blue);
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }
    
    public void collision(Object o) {
        
    }
}
