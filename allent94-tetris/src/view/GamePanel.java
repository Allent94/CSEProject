package view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Block;
import model.Board;
import model.Point;


/**
 * 
 * @author allen tran
 *@version 05-10-2017
 *
 */

public class GamePanel extends JPanel implements Observer , KeyListener {
    
    /**
     * 
     */
    private static final long serialVersionUID = -6177531643252345126L;
    
    
    /**
     * Make variable for BLOCKSIZE.
     */
    
    private static final int BLOCKSIZE = 25;
    
    /**
     * Make variable for XSIZE.
     */
    
    private static final int XSIZE = 250;
    
    
    /**
     * Make variable for YSIZE.
     */
    
    private static final int YSIZE = 500;
    
    /**
     * Make RGB number.
     */
    
    private static final int RGBNUMBER = 256;
    
    /**
     * make Variable for myBoard.
     */
    private Board myBoard;

    
    /**
     * Make variable for myBlock.
     */
    
    private List<Block[]> myBlocks;
    

    /**
     * Make variable for gridmode.
     */
    
    private boolean myGridMode;
    
    /**
     * Make variable for crazymode.
     */
    
    private boolean myCrazyMode;
    
    /**
     * Make variable for pause.
     */
    
    private boolean myPauseSwitch;

    /**
     * Make variable for mySB.
     */
    
    private ScoreBoard mySB = new ScoreBoard();
    
    
    


    /**
     * Make variable for gamePanel.
     * @param theBoard board
     * 
     */
    
    
   
    
    public GamePanel(final Board theBoard) {

        
        myBoard = theBoard;
        
        setMinimumSize(new Dimension(XSIZE , YSIZE));

     
        
    }
    
    /**aaa
     * Make method for update.
     */
    

    @SuppressWarnings("unchecked")
    @Override
    public void update(final Observable theO, final Object theArg) {


        if (theO instanceof Board) {
            
                       
            if (theArg instanceof List<?>) {
                
                myBlocks = (List<Block[]>) theArg;

                
  
            }

        }
        
        if (theArg instanceof Boolean) {
            
            Sound.BOO.play();
            TetrisGUI.turnOffButton();
            mySB.clearScore();
            Sound.init();
            JOptionPane.showMessageDialog(null, "YOU DIED");
   
        }
        

        repaint();
    }
    
    
    @Override
    public void paintComponent(final Graphics theGraphics) {
     
        final int red = (int) (Math.random() * RGBNUMBER);
        final int green = (int) (Math.random() * RGBNUMBER);  
        final int blue = (int) (Math.random() * RGBNUMBER);
        final Color color = new Color(red , green , blue);

        super.paintComponent(theGraphics);

        final Graphics2D g2d = (Graphics2D) theGraphics;
        
        if (myGridMode) {
            
            int i;
            final int width = myBoard.getWidth() * BLOCKSIZE;
            
            final int height = myBoard.getHeight() * BLOCKSIZE;
            
            for (i = 1; i <= myBoard.getHeight(); i++) {
                
              
                g2d.drawLine(0 , i * BLOCKSIZE , width , i * BLOCKSIZE);
                
                g2d.setBackground(Color.green);
                
            }
            
            for (i = 0; i <= myBoard.getWidth(); i++) {

                g2d.drawLine(i * BLOCKSIZE , 0 , i * BLOCKSIZE,  height);
                
                g2d.setBackground(Color.green);
                
            }
          
        } 
        
        final int yPoint = 18;
  
        if (myBlocks != null) { 
            
            for (int i = myBlocks.size() - 1; i >= 0; i--) { // y

                final Block[] cur = myBlocks.get(i);
                
                for (int j = 0; j <=  cur.length - 1; j++) { // x 
        
                    if (cur[j] != null) {        
                        
                        if (cur[j] == Block.O) { 
                            
                            g2d.setColor(Color.BLUE);
                            
                        }
                        
                        if (cur[j] == Block.I) { 
                            
                            g2d.setColor(Color.RED);
                            
                        }
                        
                        if (cur[j] == Block.J) { 
                            
                            g2d.setColor(Color.ORANGE);
                            
                        }
                        
                        if (cur[j] == Block.L) { 
                            
                            g2d.setColor(Color.PINK);
                            
                        }
                        
                        if (cur[j] == Block.S) { 
                            
                            g2d.setColor(Color.GRAY);
                            
                        }
                        
                        if (cur[j] == Block.O) { 
                            
                            g2d.setColor(Color.magenta);
                            
                        }
                        
                        if (cur[j] == Block.T) { 
                            
                            g2d.setColor(Color.GREEN);
                            
                        }
                        
                        if (cur[j] == Block.Z) { 
                            
                            g2d.setColor(Color.BLUE);
                            
                        }
                        
                        if (myCrazyMode) {
                            
                            g2d.setColor(color);
                            
                            repaint();
                            
                            repaint();
                            
                            repaint();
                         
                        }
                     
                        final Point point = new Point(j * BLOCKSIZE , (yPoint
                                        
                                        - i) * BLOCKSIZE);
                        
                        g2d.fillRect(point.x() , point.y() 
                                   , BLOCKSIZE , BLOCKSIZE);
                        
                        repaint();
                  
                    }
                }
            }   
        }

        if (myGridMode) {
            
            int i;
            final int width = myBoard.getWidth() * BLOCKSIZE;
            
            final int height = myBoard.getHeight() * BLOCKSIZE;
            
            for (i = 1; i <= myBoard.getHeight(); i++) {
                
              
                g2d.drawLine(0 , i * BLOCKSIZE , width , i * BLOCKSIZE);
                
            }
            
            for (i = 0; i <= myBoard.getWidth(); i++) {

                g2d.drawLine(i * BLOCKSIZE , 0 , i * BLOCKSIZE,  height);
                
            }
        }         
    }
    
    /**
     * Make method to turn on/off Grid mode.
     * @param theN n
     */
    
    
    public void gridBoolean(final boolean theN) {
        
        
        myGridMode = theN;
 
        
    }
    
    /**
     * Make method to turn on/off crazy mode.
     * @param theN n
     */
    
    public void crazyBoolean(final boolean theN) {
        
        
        myCrazyMode = theN;
 
        
    }


    @Override
    public void keyTyped(final KeyEvent theE) {
        // TODO Auto-generated method stub

    }

    

    @Override
    public void keyPressed(final KeyEvent theE) {
        
        if (true) {
            
            if (theE.getKeyCode() == KeyEvent.VK_A || theE.getKeyCode() == KeyEvent.VK_LEFT) {

                myBoard.left();           
            }
             
            if (theE.getKeyCode() == KeyEvent.VK_D || theE.getKeyCode() == KeyEvent.VK_RIGHT) {

                myBoard.right();
            }
            
            if (theE.getKeyCode() == KeyEvent.VK_SPACE) {
                
                myBoard.drop();
           
            }
            
            if (theE.getKeyCode() == KeyEvent.VK_S || theE.getKeyCode() == KeyEvent.VK_DOWN) {
                
                myBoard.down();
              
               
            }
      
            if (theE.getKeyCode() == KeyEvent.VK_W || theE.getKeyCode() == KeyEvent.VK_UP) {
                
                myBoard.rotateCCW();
              
               
            }
            
            if (theE.getKeyCode() == KeyEvent.VK_P) {
                
                pauseSwitch();
     
            }
   
        }

        
    }
    
    /**
     * Make method for pauseSwitch.
     */
    
    public void pauseSwitch() {
        
        myPauseSwitch = !myPauseSwitch;
        
        TetrisGUI.pauseBoolean(myPauseSwitch);
        
        
    }
    
    /**
     * Make method for keySwitch.
     */
    
    public void keySwitch() {
        
        
        
    }

    

    @Override
    public void keyReleased(final KeyEvent theE) {
        // TODO Auto-generated method stub
        
    }

}
