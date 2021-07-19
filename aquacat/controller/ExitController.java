package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ExitController extends KeyAdapter{

    public ExitController() {
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
        
    }

}