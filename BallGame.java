/******************************************************************************
 *  Compilation:  javac BallGame.java
 *  Execution:    java BallGame n
 *  Dependencies: BasicBall.java StdDraw.java
 *
 *  Creates a BasicBall and animates it
 *
 *  Part of the animation code is adapted from Computer Science:   An Interdisciplinary Approach Book
 *  
 *  Run the skeleton code with arguments : 1  basic  0.08
 *******************************************************************************/



import java.awt.Color;
import java.awt.Font;
import java.util.*;


public class BallGame { 

    public static void main(String[] args) {
        ArrayList<BasicBall> balls = new ArrayList<BasicBall>();
        ArrayList<BasicBall> temp_balls = new ArrayList<BasicBall>();
    	// number of bouncing balls
    	int numBalls = Integer.parseInt(args[0]);
    	//ball types
    	String ballTypes[] = new String[numBalls];
    	//sizes of balls
    	double ballSizes[] = new double[numBalls];
    	
    	//retrieve ball types
    	int index =1;
    	for (int i=0; i<numBalls; i++) {
    		ballTypes[i] = args[index];
    		index = index+2;
    	}
    	//retrieve ball sizes
    	index = 2;
    	for (int i=0; i<numBalls; i++) {
    		ballSizes[i] = Double.parseDouble(args[index]);
    		index = index+2;
    	}
     
    	//TO DO: create a Player object and initialize the player game stats.  
    	Player player = new Player();
        //TO DO: create a BasicBall object and initialize the ball. 
        
        //TO DO: initialize the number of balls in the game.
    	
    	//number of active balls
    	int numBallsinGame = 0;
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(800, 800);
        // set boundary to box with coordinates between -1 and +1
        StdDraw.setXscale(-1.0, +1.0);
        StdDraw.setYscale(-1.0, +1.0);
        // create colored balls 
        //TO DO: Create "numBalls" balls (of types given in "ballTypes" with sizes given in "ballSizes") and store them in an Arraylist

        for (int i =0; i < numBalls; i++)
        {
            if (ballTypes[i].equals("basic"))
            {
                BasicBall ball = new BasicBall(ballSizes[i],Color.RED);
                balls.add(ball);
            }
            else if (ballTypes[i].equals("split"))
            {
                BasicBall ball = new Split(ballSizes[i],Color.BLUE);
                balls.add(ball);
            }
            else if (ballTypes[i].equals("shrink"))
            {
                BasicBall ball = new Shrink(ballSizes[i],Color.YELLOW);
                balls.add(ball);
            }
            else if (ballTypes[i].equals("bounce"))
            {
                BasicBall ball = new Bounce(ballSizes[i],Color.GREEN);
                balls.add(ball);
            }
        }


   		//TO DO: initialize the numBallsinGame

   		numBallsinGame = numBalls;
        // do the animation loop

        StdDraw.enableDoubleBuffering();
        while (numBallsinGame > 0) 
        {

        	// TODO: move all balls
            for(BasicBall ball : balls)
            {
                ball.move();
                ball.draw();
            }

            //Check if the mouse is clicked
            if (StdDraw.isMousePressed()) {
                double x = StdDraw.mouseX();
                double y = StdDraw.mouseY();
                //TODO: check whether a ball is hit. Check each ball.  
                for (BasicBall ball : balls) 
                {
                    if (ball.isHit(x, y)) 
                    {
                        if ("Split".equals(ball.getClass().getSimpleName()))
                        {
                            BasicBall temp1 = new Split(ball.getRadius(), Color.BLUE);
                            temp_balls.add(temp1);
                            player.hit_split();

                        }
                        else if ("Shrink".equals(ball.getClass().getSimpleName())) 
                        {
                            player.hit_shrink();
                        } 
                        else if ("Bounce".equals(ball.getClass().getSimpleName()))
                        {
                            player.hit_bounce();
                        } 
                        else 
                        {
                            player.hit_basic();
                        }
                        ball.reset();
                    }
                }
            }
            

            numBallsinGame = 0;
            // draw the n balls
            StdDraw.clear(StdDraw.GRAY);
            StdDraw.setPenColor(StdDraw.BLACK);
            
            //TO DO: check each ball and see if they are still visible. numBallsinGame should hold the number of visible balls in the game.  
            for (BasicBall ball : balls) 
            {
                if (ball.isOut == false) 
                { 
                    ball.draw();
                    numBallsinGame++;
                }
            }
            
            balls.addAll(temp_balls);  // Add new balls from temporary list to main list
            temp_balls.clear();

            //Print the game progress
            StdDraw.setPenColor(StdDraw.YELLOW);
            Font font = new Font("Arial", Font.BOLD, 20);

            StdDraw.setFont(font);
            StdDraw.text(-0.65, 0.90, "Number of balls in game: "+ String.valueOf(numBallsinGame));
            StdDraw.text(-0.65, 0.85, "Number of hits: "+ String.valueOf(player.getHits()));
            StdDraw.text(-0.65, 0.80, "Player Score: "+ String.valueOf(player.getScore()));
            

            StdDraw.show();
            StdDraw.pause(20);
        }

        

        while (true) {
            StdDraw.setPenColor(StdDraw.BLUE);
            Font font = new Font("Arial", Font.BOLD, 60);
            StdDraw.setFont(font);
            StdDraw.text(0, .5, "GAME OVER");

            StdDraw.setPenColor(StdDraw.YELLOW);
            Font font2 = new Font("Arial", Font.BOLD, 20);
            StdDraw.setFont(font2);
            StdDraw.text(0, .4, "score: "+ String.valueOf(player.getScore()));
            StdDraw.text(0, .35, "hits: "+ String.valueOf(player.getHits()));
            StdDraw.text(0, .30, "basic: "+ String.valueOf(player.getBasic()));
            StdDraw.text(0, .25, "shrink: "+ String.valueOf(player.getShrink()));
            StdDraw.text(0, .20, "bounce: "+ String.valueOf(player.getBounce())); 
            StdDraw.text(0, .15, "split: "+ String.valueOf(player.getSplit()));           

            //TO DO: print the rest of the player statistics
            StdDraw.show();
            StdDraw.pause(5);           
        }
        	
        
    }
}








