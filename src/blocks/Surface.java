/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blocks;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author aariasgonzalez
 */
public class Surface extends JPanel implements ActionListener{
	Timer mTimer = null;
	
	World mWorld = null;

    
    
    boolean mBallDirUp = false;
    boolean mBallDirLeft = false;
    
    boolean mLoose = false;
    
    
    public Surface() {
        setFocusable(true);
        
        
        mWorld = new World(this);
        
        mTimer = new Timer(1, this);
        mTimer.start();

    }
    @Override
    public void paint(Graphics g) {
    	
        super.paint(g);
        
        mWorld.draw(g);
        
        
        
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		 repaint();
		
	}
    
}
