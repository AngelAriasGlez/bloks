/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocks;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 *
 * @author aariasgonzalez
 * 
 * 
 * 
 */

public class Object{
    protected World mWorld = null;

    protected FPoint mVelocity = new FPoint(0, 0);
    protected FPoint mAcceleration = new FPoint(0, 0);
    private long mPrevTime = System.currentTimeMillis();
    private float mRestitution =  1f;
    
    //protected int mType = 1;
    
    FPoint mLocation;
    FPoint mDimension;
    
    Rectangle r = new Rectangle();
    
    public Object(){
    
    }
    public Object(World world, int width, int height){
    	mWorld = world;
    	mLocation = new FPoint(0, 0);
    	mDimension = new FPoint(width, height);
    }
    public Object(World world, int x, int y, int width, int height){
    	mWorld = world;
    	
    	mLocation = new FPoint(x, y);
    	mDimension = new FPoint(width, height);
    }

    public int getY(){
        return (int)mLocation.y;
    }
    public int getX(){
        return (int)mLocation.x;
    }
    public void setY(int y){
    	mLocation.y = y;
    }
    public void setX(int x){
    	mLocation.x = x;
    }
    public float getRestitution(){
    	return mRestitution;
    }
    
    public int getCenterY(){
        return (int)(mLocation.y+getHalfHeight());
    }
    public int getCenterX(){
        return (int)(mLocation.x+getHalfWidth());
    }
    
    
    public int getTop(){
   	 return (int)mLocation.y;
   }
   public int getLeft(){
  	 	return (int)mLocation.x;
   }     
    
    public int getRight(){
    	 return (int) (mLocation.x+mDimension.x);
    }
    public int getBottom(){
   	 	return (int) (mLocation.y+mDimension.y);
    }  
    
    public int getHeight(){
        return (int)mDimension.y;
    }
    public int getWidth(){
        return (int)mDimension.x;
    }
    public int getHalfHeight(){
        return (int)mDimension.y/2;
    }
    public int getHalfWidth(){
        return (int)mDimension.x/2;
    }

    public Rectangle getBounds(){
    	return  new Rectangle((int)mLocation.x, (int)mLocation.y, (int)mDimension.x, (int)mDimension.y);
    }
    public Point getCenter(){
    	return new Point((int)(mLocation.x+(mDimension.x/2)), (int)(mLocation.y+(mDimension.y/2)));
    }
    
	public void draw(Graphics g) {
		long ms = System.currentTimeMillis() - mPrevTime;
		mVelocity.x += mAcceleration.x * ms;
		mVelocity.y += mAcceleration.y * ms;
		

		mLocation.x += mVelocity.x * (float)ms;
		mLocation.y += mVelocity.y * (float)ms;
		
		
		mPrevTime = System.currentTimeMillis();
		
	}
	public void collision(Object o) {
		/*if (mType == 1){
			return ;
		}*/


		float angle = calculateAngle((int)getCenterX(), (int)getCenterY(), o);

		//System.out.println(this.toString());
		
		float topangle = calculateAngle(o.getRight(), o.getY(), o);
		float sideangle = (360 - (topangle*2)) / 2;
		
		if(angle > 0 && angle < topangle){
			mVelocity.y *= -1;
			setY(o.getY() - (getHeight()+1));
		}else if(angle > topangle+sideangle && angle < (topangle*2)+sideangle){
			mVelocity.y *= -1;
			setY(o.getBottom()+1);		
		}
		
		if(angle > topangle && angle < topangle+sideangle){
			mVelocity.x *= -1;
			setX(o.getRight()+1);
		}else if(angle > (topangle*2)+sideangle || angle < 0){
			mVelocity.x *= -1;
			setX(o.getX() - (getWidth()+1));		
		}		
		
	}
	public float calculateAngle(int x, int y, Object o){
		return (float) Math.toDegrees(Math.atan2(y- o.getCenterY(),  x - o.getCenterX())
				- Math.atan2(o.getY() - o.getCenterY(), o.getX()- o.getCenterX()));
	}
}
