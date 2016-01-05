import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.HashSet;
import java.util.Random;

/**
 * Class BallDemo - provides two short demonstrations showing how to use the 
 * Canvas class. 
 *
 * @author Mario Schuetz
 * @version 2015-12-20
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        myCanvas.setVisible(true);
    }
 
    /**
     * Demonstrate some of the drawing operations that are
     * available on a Canvas object.
     */
    public void drawDemo()
    {
        myCanvas.setFont(new Font("helvetica", Font.BOLD, 14));
        myCanvas.setForegroundColor(Color.red);

        myCanvas.drawString("We can draw text, ...", 20, 30);
        myCanvas.wait(1000);
        myCanvas.setForegroundColor(Color.yellow);
        myCanvas.drawString("... and some more yellow text...", 40, 50);
        myCanvas.wait(1000);

        myCanvas.setForegroundColor(Color.black);
        myCanvas.drawString("...draw lines...", 60, 60);
        myCanvas.wait(500);
        myCanvas.setForegroundColor(Color.gray);
        myCanvas.drawLine(200, 20, 300, 50);
        myCanvas.wait(500);
        myCanvas.setForegroundColor(Color.blue);
        myCanvas.drawLine(220, 100, 370, 40);
        myCanvas.wait(500);
        myCanvas.setForegroundColor(Color.green);
        myCanvas.drawLine(290, 10, 320, 120);
        myCanvas.wait(1000);
        
        myCanvas.setForegroundColor(Color.red);
        myCanvas.drawString("...draw red lines...", 90, 80);   //90 from left to right and 80 from top to bottom
        myCanvas.wait(500);
        myCanvas.drawLine(250, 20, 340, 100); // 250/20 first point, 340/100 second point
        myCanvas.wait(500);
        
        myCanvas.setForegroundColor(Color.gray);
        myCanvas.drawString("...and shapes!", 110, 90);

        myCanvas.setForegroundColor(Color.red);

        // the shape to draw and move
        int xPos = 10;
        Rectangle rect = new Rectangle(xPos, 150, 30, 20);

        // move the rectangle across the screen
        for(int i = 0; i < 200; i ++) {
            myCanvas.fill(rect);
            myCanvas.wait(10);
            myCanvas.erase(rect);
            xPos++;
            rect.setLocation(xPos, 150);
        }
        // at the end of the move, draw once more so that it remains visible
        myCanvas.fill(rect);
        
        
        myCanvas.setForegroundColor(Color.green);
        myCanvas.wait(500);
        
        int yPos = 30;
        Rectangle rect2 = new Rectangle(100, 10, yPos, 20);

        // move the rectangle across the screen
        for(int i = 0; i < 200; i ++) {
            myCanvas.fill(rect2);
            myCanvas.wait(10);
            myCanvas.erase(rect2);
            yPos++;
            rect2.setLocation(150, yPos);
        }
        // at the end of the move, draw once more so that it remains visible
        myCanvas.fill(rect2);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // create and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.blue, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.red, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 && ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
        ball.erase();
        ball2.erase();
    }
    
    /**
     * Simulate as many bouncing balls as you would like to
     * @param ballNum choose how many balls you would like to bounce
     */
    public void bounce2(int ballNum)
    {
        int ground = 400;   // position of the ground line
        Random random = new Random();
        myCanvas.setVisible(true);
        Dimension max = myCanvas.getSize();

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        
        // create HashSet, fill with balls and show them
        HashSet<BouncingBall> ballSet = new HashSet<BouncingBall>();
        for(int i = 0; i < ballNum; i++){
            BouncingBall ball = new BouncingBall(random.nextInt(max.width/2), random.nextInt(max.height/2), 10+2*i, Color.blue, ground, myCanvas);
            ballSet.add(ball);
            ball.draw();
        }
               
        myCanvas.wait(5000);
        
        // make them bounce        
        while(!ballSet.isEmpty()) {
            myCanvas.wait(50);           // small delay
            
            for(BouncingBall ball : ballSet){
                ball.move();
                
                // stop once ball has travelled a certain distance on x axis
                if(ball.getXPosition() >= max.width - 20) {
                    ball.erase();
//                  ballSet.remove(ball);
                }
            }
        }        
    }
    
    public void drawFrame(){
       
        Dimension max = myCanvas.getSize();        
        
        myCanvas.setForegroundColor(Color.green);
        Rectangle frame1 = new Rectangle(0, 0, max.width, max.height);
        myCanvas.fill(frame1);
        
        myCanvas.setForegroundColor(Color.white);
        Rectangle frame2 = new Rectangle(20, 20, max.width - 40, max.height - 40);
        myCanvas.fill(frame2);
    }
}
