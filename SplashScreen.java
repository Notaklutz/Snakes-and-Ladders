/*
Kevin Nguyen
December 16, 2018
Mr.Rosen
This class will animate and output the splash screen.
*/
// The "SplashScreen" class.
import java.awt.*;
import hsa.Console;

public class SplashScreen extends Thread
{
    private Console c;           // The output console

    /*
    This method will animate the snake and ladder, as well as output the name of the game, Snakes and Ladders.
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Local Variables: snakeGreen, tonguePink, backgroundOrange, ladderBrown, snakeX, snakeY, tonguex, tongueY, and x.
    Global Variables Used: None.
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    NAME                VARIABLE'S TYPE         DESCRIPTION
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    snakeGreen          Color                   This variable stores the green colour of the snake.
    tonguePink          Color                   This variable stores the pink colour of the snake's tongue.
    backgroundOrange    Color                   This variable stores the orange colour of the background.
    ladderBrown         Color                   This variable stores the brown colour of the ladder.
    snakeX              int []                  This variable stores an array of the snake's x coordinates.
    snakeY              int []                  This variable stores an array of the snake's y coordinates.
    tongueX             int []                  This variable stores an array of the snake's tongue's x coordinates.
    tongueY             int []                  This variable stores an array of the snake's tongue's y coordinates.
    x                   int                     This variable is used to animate the snake and ladder.
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    For loops are used to animate the snake and ladder.
    */
    public void animate ()
    {
	Color snakeGreen = new Color (0, 255, 0);
	Color tonguePink = new Color (255, 0, 255);
	Color backgroundOrange = new Color (255, 153, 0);
	Color ladderBrown = new Color (120, 63, 4);

	for (int x = 0 ; x < 501 ; x++)
	{
	    c.setColor (backgroundOrange);
	    c.drawRect (0, 0, 640, 0 + x);
	}

	for (int x = 0 ; x < 601 ; x++)
	{
	    c.setColor (backgroundOrange);
	    c.fillRect (-565 + x, 151, 558, 203);

	    c.setColor (snakeGreen);
	    int snakeX[] = { - 539 + x, -564 + x, -545 + x, -439 + x, -313 + x, -203 + x, -104 + x, -43 + x, -8 + x, -7 + x, -95 + x, -186 + x, -272 + x, -357 + x, -458 + x};
	    int snakeY[] = {331, 255, 212, 151, 205, 174, 232, 180, 168, 197, 290, 299, 263, 278, 247};
	    int tongueX[] = { - 539 + x, -557 + x, -539 + x, -519 + x};
	    int tongueY[] = {331, 354, 345, 354};

	    c.fillPolygon (snakeX, snakeY, 15);
	    c.setColor (tonguePink);
	    c.fillPolygon (tongueX, tongueY, 4);
	    c.setColor (Color.black);
	    c.fillOval (-535 + x, 235, 30, 30);

	    try
	    {
		Thread.sleep (5);
	    }
	    catch (Exception e)
	    {
	    }
	}

	for (int x = 0 ; x < 401 ; x++)
	{
	    c.setColor (backgroundOrange);
	    c.fillRect (211, -295 + x, 231, 290);

	    c.setColor (ladderBrown);
	    // left side
	    c.fillOval (211, -294 + x, 28, 28);
	    c.fillRect (211, -280 + x, 28, 259);
	    c.fillOval (211, -35 + x, 28, 28);

	    // right side
	    c.fillOval (414, -294 + x, 28, 28);
	    c.fillRect (414, -280 + x, 28, 259);
	    c.fillOval (414, -35 + x, 28, 28);

	    // top step
	    c.fillRect (239, -270 + x, 175, 26);

	    // middle-top step
	    c.fillRect (239, -200 + x, 175, 26);

	    // middle-bottom step
	    c.fillRect (239, -130 + x, 175, 26);

	    // bottom step
	    c.fillRect (239, -60 + x, 175, 26);

	    c.setColor (snakeGreen);
	    int snakeX[] = {61, 36, 55, 161, 287, 397, 496, 557, 592, 593, 505, 414, 328, 243, 142};
	    int snakeY[] = {331, 255, 212, 151, 205, 174, 232, 180, 168, 197, 290, 299, 263, 278, 247};
	    int tongueX[] = {61, 43, 61, 81};
	    int tongueY[] = {331, 354, 345, 354};

	    c.fillPolygon (snakeX, snakeY, 15);
	    c.setColor (tonguePink);
	    c.fillPolygon (tongueX, tongueY, 4);
	    c.setColor (Color.black);
	    c.fillOval (65, 235, 30, 30);

	    try
	    {
		Thread.sleep (5);
	    }


	    catch (Exception e)
	    {
	    }

	}

	c.setFont (new Font ("Lato", Font.BOLD, 20));
	c.drawString ("Snakes and Ladders", 230, 240);

	try
	{
	    Thread.sleep (4000);
	}


	catch (Exception e)
	{
	}
    }


    /*
    This method is used to assign the class constructor to the console.
    ----------------------------------------------------------------------
    Local Variables: None.
    Global Variables Used: c.
    ----------------------------------------------------------------------
    No input/logic/loop is used.
    */
    public SplashScreen (Console con)
    {
	c = con;
    }


    /*
    This method is used to run the animate method.
    ----------------------------------------------------------------------
    Local Variables: None.
    Global Variables Used: None.
    ----------------------------------------------------------------------
    No input/logic/loop is used.
    */
    public void run ()
    {
	animate ();
    }
}


