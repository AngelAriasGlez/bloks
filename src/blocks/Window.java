/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blocks;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author aariasgonzalez
 */
public class Window extends JFrame{
    public Window(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Surface surface = new Surface();
        add(surface);
        
        setPreferredSize(new Dimension(800, 800));
        pack();
        setVisible(true);
    }
}
