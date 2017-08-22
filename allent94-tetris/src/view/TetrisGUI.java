package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import model.Board;


/**
 *
 * @author Allen Tran
 *@version 5-17-2017
 *
 */

public class TetrisGUI extends JFrame {

    /**
     * Make variable for 1 ms.
     */
    
    private static final int MS = 1000;
    
       /** The default delay (in milliseconds) for the move timer. */
    
    private static int move_delay;
    

    /**
     * Make Variable for Start Button.
     */
    
    private static JButton mySpeedButton = new JButton("Increase Speed");
    
    /**
     * Make Variable for Start Button.
     */
    
    private static JButton myStartGameButton = new JButton("New Game");
    
    /**
     * Make Variable for Start Button.
     */
    
    private static JButton myGirdModeButton = new JButton("Grid Mode");
    
    /**
     * Make Variable for Start Button.
     */
    
    private static JButton myCrazyModeButton = new JButton("Crazy Mode");
    
    /**
     * Make Variable for Start Button.
     */
    
    private static JButton myEndGameButton = new JButton("End Game");
    
    /**
     * serial Version UID.
     */
    private static final long serialVersionUID = 3565967896122405751L;
    
    /**
     * Make variable for size.
     */
    
    private static final int SIZE250 = 250;
    
    /**
     * Make variable for size.
     */
    
    private static final int SIZE25 = 25;
    
    /**
     * Make variable for myTimer.
     */

    private static Timer myTimer = new Timer(move_delay, null);


    
    /**
     * Make variable for row.
     */
    
    private final int myRow = 13;
    
    /**
     * Make variable for col.
     */
    
    private final int myCol = 1;

    
    /**
     * Make variable for JPanel.
     */
    
    private JPanel myEastJPanel = new JPanel();
    
    /**
     * Make variable for JPanel.
     */
    
    private JPanel myNorthJPanel = new JPanel();
    
    /**
     * Make variable for JPanel.
     */
    
    private JPanel mySouthJPanel = new JPanel();
    
    /**
     * Make variable for JPanel Grid.
     */
    
    private JPanel myCenterJPanel = new JPanel();
    
    /**
     * Make variable for mySouthGrid.
     */
    
    private JPanel mySouthGrid = new JPanel(new GridLayout(myRow, myCol));

    /**
     * Make variable for score board.
     */
    
    private ScoreBoard mySB = new ScoreBoard();

    
    /**
     * Make variable grid switch.
     */

    private boolean myGridswitch;
    
    /**
     * Make variable for crazy switch.
     */
    
    private boolean myCrazySwitch;
    
    /**
     * Make variable for board..
     */
    
    
    private Board myBoard;
    
    /** The timer that controls the movement of the shape. */
    
    private GamePanel myGP;
    
    /**
     * Make varaible for next shape.
     */

    private NextShape myNS;

  
    
    /**
     * 
     * Make method for start.
     * 
     */

    public void start() {
        
      //  Sound.init();
       // Sound.volume = Sound.Volume.HIGH;
        

        myBoard = new Board();
        myGP = new GamePanel(myBoard);        
        setTitle("Tetris v.1.0");
        
        westJPanel();
        myNS = new NextShape();
        eastJPanel();
        
       // setMinimumSize(new Dimension(mySize , mySize));
        
      //  this.getMinimumSize().getSize();
        
        this.setMinimumSize(getSize());
        
        this.addKeyListener(myGP);
        
        pack();

        this.setFocusable(true);
        
        myCrazyModeButton.setFocusable(false);
        
        myGirdModeButton.setFocusable(false);
        
        mySpeedButton.setFocusable(false);
        
        myStartGameButton.setFocusable(false);
        
        myEndGameButton.setFocusable(false);
        
        mySpeedButton.setEnabled(false);
        
        myGirdModeButton.setEnabled(false);
        
        myCrazyModeButton.setEnabled(false);
        
        myEndGameButton.setEnabled(false);
        
        this.setVisible(true);
        
        this.setResizable(false);
 
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    
    /**
     * Make method for West JPanel.
     */
    
    public void westJPanel() {
  
        this.add(myGP , BorderLayout.CENTER);
        
        myGP.setPreferredSize(new Dimension(SIZE250, (SIZE250 * 2) - SIZE25));
        
        myGP.setBackground(Color.BLACK);
        
        myBoard.addObserver(myGP);
        
        pack();
        
        
    
    }
    
    /**
     * Make method for East JPanel.
     */

    public void eastJPanel() {
        
        
        
        myNorthJPanel.setBackground(Color.GRAY);
        
        mySouthJPanel.setBackground(Color.ORANGE);
        
        myEastJPanel.setBackground(Color.YELLOW);

        myCenterJPanel.setBackground(Color.BLACK);
        
        myEastJPanel.setLayout(new BorderLayout()); 
        
        myBoard.addObserver(myNS);
        
        myBoard.addObserver(mySB);
        
        myEastJPanel.add(myNS , BorderLayout.CENTER);
        
        myEastJPanel.add(mySouthJPanel , BorderLayout.SOUTH);
        
        myEastJPanel.setPreferredSize(new Dimension(SIZE250, SIZE250));
        
        

        scoreBoard();
        
        controlButtons();
        
        

        this.add(myEastJPanel , BorderLayout.EAST);
       
    }
    
    
    
    
    
    /**
     * Make score board for East JGrid - East JGrid.
     */
    
    public void scoreBoard() {

        
        
        
    }
    
    /**
     * Make buttons for East JGrid - South JPanel.
     */
    
    public void controlButtons() {
        
        final JLabel up = new JLabel(" UP and W = ROTATE PIECE");
        final JLabel down = new JLabel(" DOWN and S = MOVE DOWN");       
        final JLabel left = new JLabel(" LEFT and A = TO MOVE LEFT");       
        final JLabel right = new JLabel(" RIGHT and D = TO MOVE RIGHT");       
        final JLabel space = new JLabel(" HOLD SPACE = DROP DOWN");
        final JLabel pause = new JLabel(" P WILL PAUSE/RESUME GAME ");
        
        mySouthGrid.add(mySB);
        mySouthGrid.add(up);
        mySouthGrid.add(down);
        mySouthGrid.add(left);
        mySouthGrid.add(right);
        mySouthGrid.add(down);
        mySouthGrid.add(space);  
        mySouthGrid.add(down);
        mySouthGrid.add(pause);
        mySouthGrid.add(myStartGameButton);               
        mySouthGrid.add(mySpeedButton);       
        mySouthGrid.add(myGirdModeButton);
        mySouthGrid.add(myCrazyModeButton);
        mySouthGrid.add(myEndGameButton);
        
        myEndGameButton.addActionListener(new ActionListener() {
            
            @Override
          public void actionPerformed(final java.awt.event.ActionEvent theEvent) {
           
                myTimer.stop();
                Sound.BOO.play();
                JOptionPane.showMessageDialog(null, "YOU DIED");
                myStartGameButton.setEnabled(true);
                mySpeedButton.setEnabled(false);           
                myGirdModeButton.setEnabled(false);               
                myCrazyModeButton.setEnabled(false);               
                myEndGameButton.setEnabled(false);    
            }            
        }); 
       
        myCrazyModeButton.addActionListener(new ActionListener() {
            
            @Override
          public void actionPerformed(final java.awt.event.ActionEvent theEvent) {
           
                myCrazySwitch = !myCrazySwitch;      
                myGP.crazyBoolean(myCrazySwitch);
                Sound.TECHNO.play();
            }
              
        });    
        myGirdModeButton.addActionListener(new ActionListener() {
            
            @Override
          public void actionPerformed(final java.awt.event.ActionEvent theEvent) {
           
                myGridswitch = !myGridswitch;    
                myGP.gridBoolean(myGridswitch);
            }
    
        });
        myStartGameButton.addActionListener(new ActionListener() {
            
            @Override
          public void actionPerformed(final java.awt.event.ActionEvent theEvent) {
      
                newGame();
                
                //Sound.TECHNO2.play();
                
                myStartGameButton.setEnabled(false);
                
                mySpeedButton.setEnabled(true);
                
                myGirdModeButton.setEnabled(true);
                
                myCrazyModeButton.setEnabled(true);
                
                myEndGameButton.setEnabled(true);
            }       
        });
        
        mySpeedButton.addActionListener(new ActionListener() {
            
            @Override
          public void actionPerformed(final java.awt.event.ActionEvent theEvent) {
                
                nextLevel();

            }

            
        });
            
        mySouthGrid.setBackground(Color.ORANGE);
        
        mySouthJPanel.add(mySouthGrid  , BorderLayout.EAST);

        
    }

    /**
     * Make method for new game.
     */


    public void newGame() {
      
        myBoard.newGame();
        
        move_delay = MS;

        myTimer = new Timer(move_delay , new ActionListener() {

            
            @Override
            public void actionPerformed(final ActionEvent theE) {
                
                myBoard.step();
                
            }
            
        });
        
        myTimer.start();
        
        
    }
    
    /**
     * make method for pause.
     * @param theN n
     */
    
    public static void pauseBoolean(final boolean theN) {
        
        
        if (theN) {
            
            myTimer.stop();
            
        } else {  
            
            myTimer.start();
            
        }
        
        
        
        
    }
    
    /**
     * Make method for nextLevel.
     */
    
    public static void nextLevel() {
  
        if (myTimer.getDelay() >= 0) {
            
            myTimer.setDelay(myTimer.getDelay() - SIZE250);
            
        }
        
    }
    
    /**
     * Make variable for turnOffButton.
     */
    
    public static void turnOffButton() {
        
        myStartGameButton.setEnabled(true);
        mySpeedButton.setEnabled(false);           
        myGirdModeButton.setEnabled(false);               
        myCrazyModeButton.setEnabled(false);               
        myEndGameButton.setEnabled(false);
        
        
        
    }
    


}
