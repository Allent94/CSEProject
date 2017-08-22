package view;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import model.Board;
import model.TetrisPiece;

/**
 * 
 * @author Allen Tran
 * @version 06-01-2017
 *
 */


public class NextShape extends JPanel implements Observer {
    
    /**
     * 
     */
    private static final long serialVersionUID = 8670669475681197541L;

    /**
     * Make variable for block size.
     */
    

    private static final int BLOCKSIZE = 25;
    
    /**
     * Make variable for TetrisPiece.
     */
    
    private TetrisPiece myTetrisPiece;
    
    /**
     * Make method for NextShape.
     */
    
    public NextShape() {
        
        super();
        
        
        
        setBackground(Color.CYAN);
    

    }
    
    @Override
    public void paintComponent(final Graphics theGraphics) {
        
        

        super.paintComponent(theGraphics);
        
        

        final Graphics2D g2d = (Graphics2D) theGraphics;
        
        
        final Insets o = this.getInsets();
        
        final int w = (this.getWidth() * o.left) + 75;
        
        final int h = this.getHeight() * o.top;
        if (myTetrisPiece != null) {
            for (model.Point point : myTetrisPiece.getPoints()) { 
            
                g2d.fillRect((point.x() * BLOCKSIZE) + w
                             , (point.y() * BLOCKSIZE) + h
                             , BLOCKSIZE , BLOCKSIZE);
             

            }
        }

    
    
    
    }

    @Override
    public void update(final Observable theO, final Object theArg) {
        // TODO Auto-generated method stub
        
        if (theO instanceof Board) {
 
            if (theArg instanceof TetrisPiece) {
                
                myTetrisPiece = (TetrisPiece) theArg;

            }
            
        } 
        
        repaint();
    }
    
   
    

}
