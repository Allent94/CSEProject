package view;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Board;
import model.TetrisPiece;

/**
 * 
 * @author allen tran
 *@version 06-01-2017
 */

public class ScoreBoard extends JPanel implements Observer {
    
    /**
     * 
     */
    private static final long serialVersionUID = -7625074211257517895L;

    /**
     * Make variable 1st line.
     */
    
    private static final int ONE_LINE = 1;
    
    /**
     * Make variable for 2nd line.
     */
    
    private static final int TWO_LINE = 2;
    
    /**
     * Make variable for 3rd line.
     */
    
    private static final int THREE_LINE = 3;
    
    /**
     * Make variable for 4th line.
     */
    
    private static final int FOUR_LINE = 4;
    
    /**
     * Make variable for -4.
     */
    
    private static final int MYNEGFOUR = -4;
    
    /**
     * Make variable for 1st line point.
     */
      
    private static final int ONE_LINE_POINT = 40;
    
    /**
     * Make variable for 2nd line point.
     */
    
    private static final int TWO_LINE_POINT = 100;
    
    /**
     * Make variable for 3rd line point.
     */
    
    private static final int THREE_LINE_POINT = 300;
    
    /**
     * Make variable for 4th line point.
     */
    
    private static final int FOUR_LINE_POINT = 1200;
    
    /**
     * make variable for 5 line.
     */
    
    private static final int FIVE = 5;
    
    /**
     * Make variable for nextLevelLine = 5.
     */
    
    private int myNextLineLevel = FIVE;
    
    /**
     * Make variable for myScore.
     */
    
    
    private int myScore;
    
    /**
     * Make variable for myLevel.
     */
    private int myLevel = 1;
    
    /**
     * Make variable for line.
     */
    
    private int myLine;
    
    /**
     * Make variable for lineLabel.
     */
    
    private JLabel myLineLabel;
    
    /**
     * Make variable for levelLevel.
     */
    
    private JLabel myLevelLabel;
    
    /**
     * 
     * Make variable for scoreLabel.
     */
    
    private JLabel myScoreLabel;
    
//    /**
//     * Make method for tetrisGUI.
//     */
//
//    private TetrisGUI myGUI;
//    
  
    /**
     * Make method for scoreBoard.
     */

    public ScoreBoard() {
        
        super();
        
        updateScoreBoard();
        
        myScore = MYNEGFOUR;
        
        myLine = myNextLineLevel;

        
    }

    
    /**
     * Make method for updateScoreBoard.
     */
    
    
    public void updateScoreBoard() {
        

        this.setBackground(Color.yellow);
        
        myLineLabel = new JLabel("Line: " +  myLine);

        myLevelLabel = new JLabel("Level: " +  myLevel);
        
        myScoreLabel = new JLabel("Score: " +  myScore);
        
        this.add(myLineLabel);
        
        this.add(myLevelLabel);
        
        this.add(myScoreLabel);
        
        

        
    }
    
    /**
     * Make Variable for update.
     */
    

    @Override
    public void update(final Observable theO, final Object theArg) {
  
        if (theO instanceof Board) { 
            
            myLineLabel.setText("line: " + myLine);
            
            if (theArg instanceof Integer[]) {
         
   
                
                final int lineCleared = ((Integer[]) theArg).length;


                point(lineCleared);
                
                myLevelLabel.setText("level:  " + myLevel);
                
                myScoreLabel.setText("Score:  " + myScore);
                
    
                
            } else if (theArg instanceof TetrisPiece) {
                
                
                myScore = myScore + FOUR_LINE;
                
                myScoreLabel.setText("" + myScore);

            }
    
            
        }
        

        
        
    }
    
    /**
     * Make method for point.
     * @param theN n
     */
    
    public void point(final int theN) {

        if (myLine <= 1) {
            
            
            myLevel += 1;
           
            Sound.CHEER.play();
            
            TetrisGUI.nextLevel();
            
            myLine = myNextLineLevel;

            myNextLineLevel = myNextLineLevel + 2;


            
        }

        
        if (theN == ONE_LINE) {
            
            myScore = myScore  + (ONE_LINE_POINT * myLevel);

            myLine = myLine - ONE_LINE;
            
            Sound.EXPLODE.play();
  
            
        }
        
        if (theN == TWO_LINE) {
            
            myScore = myScore  + (TWO_LINE_POINT * myLevel);
            
            myLine = myLine - TWO_LINE;
            
            Sound.EXPLODE.play();
  
            
        }
        
        if (theN == THREE_LINE) { 
            
            myScore = myScore  + (THREE_LINE_POINT * myLevel);

            myLine = myLine - THREE_LINE;
            
            Sound.EXPLODE.play();
  
            
        }
        
        if (theN == FOUR_LINE) {
            
            myScore = myScore  + (FOUR_LINE_POINT * myLevel);
           
            myLine = myLine - FOUR_LINE;
            
            Sound.EXPLODE.play();
  
            
        }
        

        
    }
    
    /**
     * Make method for clearscore.
     */

    
    public void clearScore() {
        
        myLine = FIVE;
        myScore = 0;
        myLevel = 0;
        
        
        
        
    }
    
    

}
