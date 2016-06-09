/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blocks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author aariasgonzalez
 */
public class Player extends Object implements KeyListener{
	
	int mDirection = 0;

    public Player(World world, int width, int height){
        super(world, width, height);
    }
    public void draw(Graphics g){
        setY(mWorld.getHeight() - 20);
    	
        g.setColor(Color.blue);
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    
        
        
        if(mDirection == 1){
            int playerX = getX();
            playerX +=5;
            if(playerX > (mWorld.getWidth() -getWidth())){
                playerX = (mWorld.getWidth() - getWidth());
            }
            setX(playerX);
        	
        }else if(mDirection == 2){
            int playerX = getX();
            playerX -=5;
            if(playerX < 0){
                playerX = 0;
            }
            setX(playerX);        	
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == '6'){
        	mDirection = 1;

        }
        else if(e.getKeyChar() == '4'){
        	mDirection = 2;

        }
        else if(e.getKeyChar() == ' '){
        	mWorld.add(new Projectile(mWorld, getCenterX(), getY()-10));

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == '6' && mDirection  == 1){
        	mDirection = 0;

        }
        else if(e.getKeyChar() == '4' && mDirection  == 2){
        	mDirection = 0;

        }
    }
    @Override
    public void collision(Object o) {
	//super.collision(o);
		
		
    }

}

