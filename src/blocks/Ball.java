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
public class Ball extends Object{
    int mDiameter = 0;
    boolean mInitialized = false;
    int mType = 0;
    public Ball(int type, World world, int x, int y, int diameter){
    	super(world, x, y, diameter, diameter);
        mDiameter = diameter;
        

        mVelocity.x = 0.25f;
        mVelocity.y = -0.25f; 
       
        mType = type;
        
    }

    public int getDiameter(){
        return mDiameter;
    }



    public void draw(Graphics g){
    	super.draw(g);
    	/*if(!mInitialized){
    		setX(mWorld.getWidth() / 2);
    		setY(mWorld.getWidth() - 100);
    		
    		mInitialized = true;
    	}*/
         
        
        if(mVelocity.x > 0)
            mVelocity.x += ((float)Math.random() / 10000.0f); 
        else
            mVelocity.x -= ((float)Math.random() / 10000.0f); 
        if(mVelocity.y > 0)
            mVelocity.y += ((float)Math.random() / 10000.0f); 
        else
            mVelocity.y -= ((float)Math.random() / 10000.0f);
    	
        g.setColor(Color.green);
        g.fillOval(getX(), getY(), mDiameter, mDiameter);
        
        
        
        
        if(getLeft() <= 0){
            mVelocity.x *= -1;
            setX(1);	
        }else if(getRight() >= mWorld.getWidth()){
            mVelocity.x *= -1;
            setX(mWorld.getWidth() - (getWidth() + 1));
        }
        
        
        /*if(ballY > (size.height - mBall.getDiameter())){
            mLoose = true;
        }*/
        if(getTop() <= 0){
        	setY(1);
            mVelocity.y *= -1;
        }else if(getBottom() >= mWorld.getHeight()){
            //mVelocity.y *= -1;
            //setY(mWorld.getHeight() - (getHeight() + 1));
            /*for(Object b : mWorld.mObjects){
             if(b instanceof Ball){
                 count
             }
            }*/
            if(mType == 0)
                mWorld.reset();

        }



    }    
	public void collision(Object o) {
            if(o instanceof Projectile){
                return;
            }
		super.collision(o);
		
		
	}
    
}
