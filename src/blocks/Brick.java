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
public class Brick extends Object{
    public int mHits = 0;
    public int mType = 0;
    public Brick(int type, World world, int width, int height){
        super(world, width, height);
        mType = type;
    }
    
    public void draw(Graphics g){
        
        g.setColor(Color.getHSBColor((0.1f * mHits) + (0.4f * mType), 0.8f, 0.8f));
        g.fillRect(getX(), getY(), getWidth(), getHeight());


        g.setColor(Color.black);
        int m=0;
        //g.fillRect(getX()+m, getY()-1, getWidth()-m*2, 1);
        //g.fillRect(getX()+m, getY()+getHeight(), getWidth()-m*2, 1);
        //g.fillRect(getX()-1, getY()+m, 1, getHeight()-m*2);
        g.fillRect(getX()+getWidth(), getY()+m, 1, getHeight()-m*2);
    }
    
    
	public void collision(Object o) {
		if(o instanceof Ball){
                        mHits++;
                        if(mHits > 2){
                            mWorld.remove(this);
                        }
                        if(mHits == 1 && mType == 1){
                            mWorld.add(new Ball(1, mWorld, o.getX(), o.getY(), 15));
                        }
		}
                if(o instanceof Projectile){
                    mWorld.remove(this);
                    mWorld.remove(o);
                }
	}
}
