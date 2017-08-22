package view;

import java.awt.EventQueue;


/**
 * 
 * @author Allen Tran
 * @version 05-17-2017
 *
 */
                

public final class TetrisMain {


    
    /**
     * Make method for Tetris Main.
     */
    
    
    private TetrisMain() {
        
        throw new IllegalStateException();
        
        
    }
        
    
    /**
     * Tetros Main method.
     * @param theArgs theArgs
     */

    public static void main(final String[] theArgs) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TetrisGUI().start();
            }
        });

    }
    
    

}

