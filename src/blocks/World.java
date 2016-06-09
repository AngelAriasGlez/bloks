package blocks;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;




public class World {

	List<Object> mObjects;
	
	Surface mSurface;

    
	World(Surface surface){
		mSurface = surface;

		reset();
		
	}
	
	public void reset() {
                for(KeyListener k : mSurface.getKeyListeners()){
                    mSurface.removeKeyListener(k);
                }
            
		mObjects = new ArrayList<Object>();

                
		Player player = new Player(this, 105, 10);
                
                mSurface.removeKeyListener(player);

		mSurface.addKeyListener(player);
        add(player);
        
        

        for(int x=0;x<6;x++){
	        for(int i=0;i<10;i++){
                    Brick b = new Brick((i == 5)?1:0, this, 50, 25);
	            b.setX(100 + (60 * i));
	            b.setY(100 + (x * 30));
	            add(b);
	        }
        }
        
        Ball ball = new Ball(0, this, 0, 0, 20);
        add(ball);
		
	}
	
	
	public void draw(Graphics g){
        /*if(mLoose){
        g.setColor(Color.BLACK);
        g.drawString("YOU LOOSE!", 100, 100);
        return;
    }   */ 
    
    int size = mObjects.size();
		 for(int i=0; i<size; i++) {
                     try {
			Object a  = mObjects.get(i);
			if(a != null){
		        a.draw(g);
		        for(int c=0; c<size; c++) {
		        	try {
		        	Object b  =mObjects.get(c);
		        	if(b != null && a!=b){
		        		if(checkCollision(a,b)){
		        			a.collision(b);
		        			b.collision(a);
		        		}
		        	}
		        	} catch ( IndexOutOfBoundsException e ) {
		        	
		        	}
		        }
			}
                        
                        } catch ( IndexOutOfBoundsException e ) {
		        	
		        }
	        //if(mBall.isCollide(b))
	        	//mBricks.remove(b);
	    }
    

    

    
    



    

	}
	
	
	public void add(Object obj){
		mObjects.add(obj);
		
	}
	
	public boolean checkCollision(Object o1, Object o2){
        if(o1.getBounds().intersects(o2.getBounds())){
            return true;
        }
        return false;
	}
	public float getAngle(Point o1, Point o2) {
	    float angle = (float) Math.toDegrees(Math.atan2(o2.y - o1.y, o2.x - o1.x));



	    return angle + 180;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    public int getHeight(){
        return mSurface.getHeight();
    }
    public int getWidth(){
        return mSurface.getWidth();
    }
	public void remove(Object o) {
		mObjects.remove(o);
		
	}
	
	
	
	
	
	

	
	

}
