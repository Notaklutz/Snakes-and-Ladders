/*
Kevin Nguyen
December 16, 2018
Mr.Rosen
This program will allow the user to play a two-player game of Snakes and Ladders.
    The splashScreen dsplays the title of the program in a large font along with a unique and colourful animation/design.
    The mainMenu screen gives the user 4 options to choose from. The first option is to play the game, the second option is to display the instructions of the game, and the third one is to display the top 10 scores. The last option is to exit the program.
    The instructions screen displays the rules of the Snakes and Ladders game.
    The goodbye screen displays a message that thanks the user for playing the game.

    NAME                VARIABLE'S TYPE         DESCRIPTION
    ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    option              static char             This variable stores the option that the user chooses in the main menu.
    currentTurn         int                     This variable determines who's turn it is. If the value is 1, it is player one's turn. If the value is 2, it is player two's turn.
    turnNum             int                     This variable stores the current turn number, to be used as the victor's score. It is also used to check if it is a new game or not.
    squareOne           int                     This variable stores the square number that player one is currently on.
    squareTwo           int                     This variable stores the square number that player two is currently on.
    ROW                 final int               This variable stores the number of rows in the highScores array.
    COL                 final int               This variable stores the number of columns in the highScores array.
    highScores          String [] []            This variable stores an array of high scores. Column one stores the name and column two stores the score.
    playerOne           String                  This variable stores the name of player one.
    playerTwo           String                  This variable stores the name of player two.
*/
// The "SnakesAndLadders" class.
import java.awt.*;
import hsa.Console;
import hsa.Message;
import java.io.*;

public class SnakesAndLadders
{
    Console c;           // The output console

    static char option = 0;
    int currentTurn = 1;
    int turnNum = 1;
    int squareOne = 0;
    int squareTwo = 0;
    final int ROW = 11;
    final int COL = 2;
    String[] [] highScores = new String [ROW] [COL];
    String playerOne;
    String playerTwo;

    /*
    This method is used to thread and run the splashScreen class.
    ----------------------------------------------------------------------
    Local Variables: s.
    Global Variables Used: None.
    ----------------------------------------------------------------------
    No input/logic/loop is used.
    */
    public void splashScreen ()
    {
	// creates the thread
	SplashScreen s = new SplashScreen (c);
	// starts the thread
	s.start ();
	// joins the thread
	try
	{
	    s.join ();
	}
	catch (Exception e)
	{
	}
    }


    /*
    This method clears the console and displays the title of the game, Snakes and Ladders, at the top of the console.
    -------------------------------------------------------------------------------------------------------------------
    Local Variables: None.
    Global Variables Used: None.
    -------------------------------------------------------------------------------------------------------------------
    No input/logic/loop is used.
    */
    public void title ()
    {
	c.clear ();
	c.setFont (new Font ("Lato", Font.BOLD, 15));
	c.print ("", 31);
	c.println ();
	c.println ();
	c.setColor (Color.blue);
	c.drawString ("Snakes and Ladders", 250, 20);
    }


    /*
    This method will pause the program until the user presses a key.
    -----------------------------------------------------------------------------------
    Local Variables: None.
    Global Variables Used: option.
    -----------------------------------------------------------------------------------
    A char input is used to pause the program until the user presses a key.
    */
    public void pauseProgram ()
    {
	c.println ();
	c.print ("", 24);
	c.println ("Please enter any key to continue.");
	option = c.getChar ();
    }


    /*
    This method gives the user four options to choose from depending on if they would like to play the game, see the instructions of the game, see the highscores, or exit the game.
    ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Local Variables: None.
    Global Variables Used: option.
    ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    The method will get a char input which will be used to determine what option the user has chosen in the main method.
    */
    public void mainMenu ()
    {
	title ();
	c.print ("", 33);
	c.println ("Press 1 to play.");
	c.print ("", 26);
	c.println ("Press 2 to see the instructions.");
	c.print ("", 26);
	c.println ("Press 3 to see the high scores.");
	c.print ("", 23);
	c.println ("Press any other key to exit the game.");
	option = c.getChar ();
    }


    /*
    This method displays information about the game and its specific rules.
    -----------------------------------------------------------------------------------------------
    Local Variables: None.
    Global Variables Used: None.
    -----------------------------------------------------------------------------------------------
    A char input is used in pauseProgram to allow the user to view the text output of the method.
    */
    public void instructions ()
    {
	title ();
	c.print ("", 10);
	c.println ("Players will take turns rolling the dice by pressing any key.");
	c.print ("", 2);
	c.println ("The amount of spaces they move will be determined by the value of their dice");
	c.print ("", 5);
	c.println ("roll. If a player gets a 6 on their dice roll, they will move 6 spaces");
	c.print ("", 10);
	c.println ("and get another dice roll on the same turn. If they land on a");
	c.print ("", 3);
	c.println ("ladder square, they will move up the board. If they land on a snake square,");
	c.print ("", 3);
	c.println ("they will move down the board. The first player to land on the 100th square");
	c.print ("", 33);
	c.println ("wins the game.");

	pauseProgram ();
    }


    /*
    This method prompts the players to enter their names and facilitates all Snakes and Ladders gameplay.
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Local Variables: playerRoll, spaceNum, squareXOne, squareYOne, squareXTwo, squareYTwo, strSquareXOne, strSquareYOne, strSquareXTwo, strSquareYTwo, spaces, spaceUp, xDone, victory, playerTwoOrange, x, and y.
    Global Variables Used: currentTurn, turnNum, squareOne, squareTwo, playerOne, and playerTwo.
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    NAME               VARIABLE'S TYPE         DESCRIPTION
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    playerRoll         int                     This variable stores the player's roll.
    spaceNum           int                     This variable stores the number of the element where the coordinates of the top-left corner of square (spaceNum + 1) are being assigned.
    squareXOne         int                     This variable stores the x coordinate of the square where player one is.
    squareYOne         int                     This variable stores the y coordinate of the square where player one is.
    squareXTwo         int                     This variable stores the x coordinate of the square where player two is.
    squareYTwo         int                     This variable stores the y coordinate of the square where player two is.
    strSquareXOne      String                  This variable stores the x coordinate of the square where player one is as a string.
    strSquareYOne      String                  This variable stores the y coordinate of the square where player one is as a string.
    strSquareXTwo      String                  This variable stores the x coordinate of the square where player two is as a string.
    strSquareYTwo      String                  This variable stores the y coordinate of the square where player two is as a string.
    spaces             String []               This variable stores an array of the coordinates of the top-left corner of all the squares on the board.
    spaceUp            boolean                 This variable stores whether or not the value of spaceNum should increase or decrease. It depends on whether the numbers move from left to right or right to left in a specific row.
    xDone              boolean                 This variable stores whether or not the x coordinates of a specific square have been assigned to strSquareXOne/Two.
    victory            boolean                 This variable stores whether or not a player has won, or is about to win.
    savedScore         boolean                 This variable stores whether or not the player's score has been saved.
    playerTwoOrange    Color                   This variable stores the orange colour of player two's playing piece.
    x                  int                     This variable is used multiple times to do repetitive actions.
    y                  int                     This variable is used multiple times to do repetitive actions.
    ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    For loops and if statements are used to initialize the coordinates of the top-left corner of each square.
    While loops and if statements are used to continuously ask for player names if users have entered invalid or matching player names.
    Most of the game is played in a while loop that will exit when victory == true. Inside the while loop, if statements are used for a variety of functions, such as to determine who's turn it is, whether or not it is the first turn, etc.
    A final if statement determines whether it was player one or two who won the game.
    */
    public void playGame ()
    {
	int playerRoll = 0;
	int spaceNum = 99;
	int squareXOne = 0;
	int squareYOne = 0;
	int squareXTwo = 0;
	int squareYTwo = 0;
	String strSquareXOne = "";
	String strSquareYOne = "";
	String strSquareXTwo = "";
	String strSquareYTwo = "";
	String[] spaces = new String [100];
	boolean spaceUp = false;
	boolean xDone = false;
	boolean victory = false;
	boolean savedScore = false;
	Color playerTwoOrange = new Color (255, 161, 0);

	for (int y = 46 ; y < 425 ; y = y + 42)
	{
	    for (int x = 114 ; x < 502 ; x = x + 43)
	    {
		spaces [spaceNum] = "";
		spaces [spaceNum] += Integer.toString (x) + '.' + Integer.toString (y);
		if (x != 501)
		{
		    if (spaceUp == false)
		    {
			spaceNum--;
		    }
		    else
		    {
			spaceNum++;
		    }
		}
	    }
	    spaceNum = spaceNum - 10;
	    if (spaceUp == false)
	    {
		spaceUp = true;
	    }
	    else
	    {
		spaceUp = false;
	    }
	}

	title ();
	c.setColor (Color.red);
	c.drawString ("PLEASE NOTE: Player names cannot be the same, empty, or longer than 5 characters.", 5, 120);
	c.print ("", 20);
	c.print ("Please enter the name of Player 1: ");
	while (true)
	{
	    c.setCursor (3, 56);
	    playerOne = c.readLine ();
	    if (playerOne.length () == 0 || playerOne.length () > 5)
	    {
		new Message ("Player names cannot be empty or over 5 characters. Please enter a valid player name.");
		c.setCursor (3, 56);
		for (int x = playerOne.length () ; x > 0 ; x--)
		{
		    c.print ("\b");
		}
	    }
	    else
	    {
		break;
	    }
	}
	c.print ("", 20);
	c.print ("Please enter the name of Player 2: ");
	while (true)
	{
	    c.setCursor (4, 56);
	    playerTwo = c.readLine ();
	    if (playerTwo.length () == 0 || playerTwo.length () > 5)
	    {
		new Message ("Player names cannot be empty or over 5 characters. Please enter a valid player name.");
		c.setCursor (4, 56);
		for (int x = playerTwo.length () ; x > 0 ; x--)
		{
		    c.print ("\b");
		}
	    }
	    else if (playerTwo.equals (playerOne))
	    {
		new Message ("Player names cannot be the same. Please choose a different player name.");
		c.setCursor (4, 56);
		for (int x = playerOne.length () ; x > 0 ; x--)
		{
		    c.print ("\b");
		}
	    }
	    else
	    {
		break;
	    }
	}
	title ();
	board ();
	c.setFont (new Font ("PT Serif", 1, 17));
	c.setColor (Color.blue);
	c.fillStar (80, 430, 12, 12);
	c.setColor (playerTwoOrange);
	c.fillStar (80, 450, 12, 12);
	c.setColor (Color.black);

	c.drawString (playerOne + " is blue. " + playerTwo + " is orange.", 210, 490);

	try
	{
	    Thread.sleep (4000);
	}
	catch (Exception e)
	{

	}
	c.setColor (Color.white);
	c.drawString (playerOne + " is blue. " + playerTwo + " is orange.", 210, 490);
	while (victory == false)
	{
	    c.setColor (Color.black);
	    if (currentTurn == 1)
	    {
		c.drawString (playerOne + ": Press any key to roll the dice.", 190, 490);

		c.getChar ();

		c.setColor (Color.white);
		c.drawString (playerOne + ": Press any key to roll the dice.", 190, 490);
	    }
	    else
	    {
		c.drawString (playerTwo + ": Press any key to roll the dice.", 190, 490);

		c.getChar ();

		c.setColor (Color.white);
		c.drawString (playerTwo + ": Press any key to roll the dice.", 190, 490);
	    }
	    playerRoll = diceRoll ();
	    if (currentTurn == 1)
	    {
		c.setColor (Color.black);
		c.drawString (playerOne + ": You rolled a " + playerRoll + "!", 220, 490);
		if (squareOne + playerRoll < 101)
		{
		    if (squareOne + playerRoll == 100)
		    {
			victory = true;
		    }
		    c.setColor (Color.black);
		    c.drawString (playerOne + ": You rolled a " + playerRoll + "!", 220, 490);
		    if (turnNum == 1)
		    {
			c.setColor (Color.white);
			c.fillStar (80, 430, 12, 12);
			try
			{
			    Thread.sleep (1000);
			}
			catch (Exception e)
			{
			}
		    }
		    for (int z = squareOne ; z <= squareOne - 1 + playerRoll ; z++)
		    {
			for (int y = 0 ; y < spaces [z].length () ; y++)
			{
			    if (xDone == false)
			    {
				if (spaces [z].charAt (y) != '.')
				{
				    strSquareXOne += spaces [z].charAt (y);
				}
				else
				{
				    xDone = true;
				}
			    }
			    else
			    {
				strSquareYOne += spaces [z].charAt (y);
			    }
			}
			try
			{
			    squareXOne = Integer.parseInt (strSquareXOne);
			    squareYOne = Integer.parseInt (strSquareYOne);
			}
			catch (NumberFormatException e)
			{
			}
			board ();
			c.setColor (Color.blue);
			c.fillStar (squareXOne + 17, squareYOne + 6, 12, 12);
			if (turnNum != 1)
			{
			    c.setColor (playerTwoOrange);
			    for (int y = 0 ; y < spaces [squareTwo - 1].length () ; y++)
			    {
				if (xDone == false)
				{
				    if (spaces [squareTwo - 1].charAt (y) != '.')
				    {
					strSquareXTwo += spaces [squareTwo - 1].charAt (y);
				    }
				    else
				    {
					xDone = true;
				    }
				}
				else
				{
				    strSquareYTwo += spaces [squareTwo - 1].charAt (y);
				}
			    }
			    c.fillStar (squareXTwo + 17, squareYTwo + 26, 12, 12);
			    strSquareXTwo = "";
			    strSquareYTwo = "";
			}
			try
			{
			    Thread.sleep (1000);
			}
			catch (Exception e)
			{
			}
			strSquareXOne = "";
			strSquareYOne = "";
			xDone = false;
		    }
		    c.setColor (Color.white);
		    c.setFont (new Font ("PT Serif", 1, 17));
		    c.drawString (playerOne + ": You rolled a " + playerRoll + "!", 220, 490);
		    squareOne = squareOne + playerRoll;
		    if (squareOne == 5 || squareOne == 17 || squareOne == 21 || squareOne == 28 || squareOne == 74 || squareOne == 93 || squareOne == 99)
		    {
			if (squareOne == 5 || squareOne == 21 || squareOne == 28)
			{
			    c.setColor (Color.black);
			    c.drawString (playerOne + ": Going up!", 250, 490);
			}
			else
			{
			    c.setColor (Color.black);
			    c.drawString (playerOne + ": Going down!", 250, 490);
			}
			board ();
			c.setColor (playerTwoOrange);
			if (turnNum != 1)
			{
			    for (int y = 0 ; y < spaces [squareTwo - 1].length () ; y++)
			    {
				if (xDone == false)
				{
				    if (spaces [squareTwo - 1].charAt (y) != '.')
				    {
					strSquareXTwo += spaces [squareTwo - 1].charAt (y);
				    }
				    else
				    {
					xDone = true;
				    }
				}
				else
				{
				    strSquareYTwo += spaces [squareTwo - 1].charAt (y);
				}
			    }
			    c.fillStar (squareXTwo + 17, squareYTwo + 26, 12, 12);
			    strSquareXTwo = "";
			    strSquareYTwo = "";
			    xDone = false;
			}
			try
			{
			    Thread.sleep (1000);
			}
			catch (Exception e)
			{
			}
			if (squareOne == 5)
			{
			    squareOne = 14;
			}
			else if (squareOne == 17)
			{
			    squareOne = 7;
			}
			else if (squareOne == 21)
			{
			    squareOne = 42;
			}
			else if (squareOne == 28)
			{
			    squareOne = 84;
			}
			else if (squareOne == 74)
			{
			    squareOne = 36;
			}
			else if (squareOne == 93)
			{
			    squareOne = 72;
			}
			else
			{
			    squareOne = 77;
			}
			c.setColor (Color.blue);
			for (int y = 0 ; y < spaces [squareOne - 1].length () ; y++)
			{
			    if (xDone == false)
			    {
				if (spaces [squareOne - 1].charAt (y) != '.')
				{
				    strSquareXOne += spaces [squareOne - 1].charAt (y);
				}
				else
				{
				    xDone = true;
				}
			    }
			    else
			    {
				strSquareYOne += spaces [squareOne - 1].charAt (y);
			    }
			}
			try
			{
			    squareXOne = Integer.parseInt (strSquareXOne);
			    squareYOne = Integer.parseInt (strSquareYOne);
			}
			catch (NumberFormatException e)
			{
			}
			c.fillStar (squareXOne + 17, squareYOne + 6, 12, 12);
			try
			{
			    Thread.sleep (1000);
			}
			catch (Exception e)
			{
			}
			strSquareXOne = "";
			strSquareYOne = "";
			c.setFont (new Font ("PT Serif", 1, 17));
			c.setColor (Color.white);
			c.drawString (playerOne + ": Going up!", 250, 490);
			c.setColor (Color.white);
			c.drawString (playerOne + ": Going down!", 250, 490);
		    }
		    if (playerRoll != 6 && victory == false)
		    {
			currentTurn = 2;
		    }
		    else if (playerRoll == 6 && victory == false)
		    {
			c.setColor (Color.black);
			c.drawString (playerOne + ": You rolled a 6, so you get an extra roll!", 160, 490);

			try
			{
			    Thread.sleep (2000);
			}
			catch (Exception e)
			{
			}

			c.setColor (Color.white);
			c.drawString (playerOne + ": You rolled a 6, so you get an extra roll!", 160, 490);
		    }
		}
		else
		{
		    try
		    {
			Thread.sleep (2000);
		    }
		    catch (Exception e)
		    {
		    }
		    c.setColor (Color.white);
		    c.drawString (playerOne + ": You rolled a " + playerRoll + "!", 220, 490);
		    c.setColor (Color.black);
		    c.drawString (playerOne + ": So close! You must roll a " + (100 - squareOne) + " to land directly on the 100th square and win.", 5, 490);
		    try
		    {
			Thread.sleep (3000);
		    }
		    catch (Exception e)
		    {
		    }
		    c.setColor (Color.white);
		    c.drawString (playerOne + ": So close! You must roll a " + (100 - squareOne) + " to land directly on the 100th square and win.", 5, 490);
		    currentTurn = 2;
		}
	    }
	    else
	    {
		c.setColor (Color.black);
		c.drawString (playerTwo + ": You rolled a " + playerRoll + "!", 220, 490);
		if (turnNum == 1)
		{
		    c.setColor (Color.white);
		    c.fillStar (80, 450, 12, 12);
		    c.setColor (Color.white);
		    c.fillStar (17, 26, 12, 12);
		    try
		    {
			Thread.sleep (1000);
		    }
		    catch (Exception e)
		    {
		    }
		}
		if (squareTwo + playerRoll < 101)
		{
		    if (squareTwo + playerRoll == 100)
		    {
			victory = true;
		    }
		    c.setColor (Color.white);
		    c.fillStar (17, 26, 12, 12);
		    for (int z = squareTwo ; z <= squareTwo - 1 + playerRoll ; z++)
		    {
			for (int y = 0 ; y < spaces [z].length () ; y++)
			{
			    if (xDone == false)
			    {
				if (spaces [z].charAt (y) != '.')
				{
				    strSquareXTwo += spaces [z].charAt (y);
				}
				else
				{
				    xDone = true;
				}
			    }
			    else
			    {
				strSquareYTwo += spaces [z].charAt (y);
			    }
			}
			try
			{
			    squareXTwo = Integer.parseInt (strSquareXTwo);
			    squareYTwo = Integer.parseInt (strSquareYTwo);
			}
			catch (NumberFormatException e)
			{
			}
			board ();
			c.setColor (playerTwoOrange);
			c.fillStar (squareXTwo + 17, squareYTwo + 26, 12, 12);
			c.setColor (Color.blue);
			for (int y = 0 ; y < spaces [squareOne - 1].length () ; y++)
			{
			    if (xDone == false)
			    {
				if (spaces [squareOne - 1].charAt (y) != '.')
				{
				    strSquareXOne += spaces [squareOne - 1].charAt (y);
				}
				else
				{
				    xDone = true;
				}
			    }
			    else
			    {
				strSquareYOne += spaces [squareOne - 1].charAt (y);
			    }
			}
			c.fillStar (squareXOne + 17, squareYOne + 6, 12, 12);
			try
			{
			    Thread.sleep (1000);
			}
			catch (Exception e)
			{
			}
			strSquareXOne = "";
			strSquareYOne = "";
			strSquareXTwo = "";
			strSquareYTwo = "";
			xDone = false;
		    }
		    c.setColor (Color.white);
		    c.setFont (new Font ("PT Serif", 1, 17));
		    c.drawString (playerTwo + ": You rolled a " + playerRoll + "!", 220, 490);
		    squareTwo = squareTwo + playerRoll;
		    if (squareTwo == 5 || squareTwo == 17 || squareTwo == 21 || squareTwo == 28 || squareTwo == 74 || squareTwo == 93 || squareTwo == 99)
		    {
			if (squareTwo == 5 || squareTwo == 21 || squareTwo == 28)
			{
			    c.setColor (Color.black);
			    c.drawString (playerTwo + ": Going up!", 250, 490);
			}
			else
			{
			    c.setColor (Color.black);
			    c.drawString (playerTwo + ": Going down!", 250, 490);
			}
			board ();
			c.setColor (Color.blue);
			for (int y = 0 ; y < spaces [squareOne - 1].length () ; y++)
			{
			    if (xDone == false)
			    {
				if (spaces [squareOne - 1].charAt (y) != '.')
				{
				    strSquareXOne += spaces [squareOne - 1].charAt (y);
				}
				else
				{
				    xDone = true;
				}
			    }
			    else
			    {
				strSquareYOne += spaces [squareOne - 1].charAt (y);
			    }
			}
			c.fillStar (squareXOne + 17, squareYOne + 6, 12, 12);
			try
			{
			    Thread.sleep (1000);
			}
			catch (Exception e)
			{
			}
			strSquareXOne = "";
			strSquareYOne = "";
			xDone = false;
			if (squareTwo == 5)
			{
			    squareTwo = 14;
			}
			else if (squareTwo == 17)
			{
			    squareTwo = 7;
			}
			else if (squareTwo == 21)
			{
			    squareTwo = 42;
			}
			else if (squareTwo == 28)
			{
			    squareTwo = 84;
			}
			else if (squareTwo == 74)
			{
			    squareTwo = 36;
			}
			else if (squareTwo == 93)
			{
			    squareTwo = 72;
			}
			else
			{
			    squareTwo = 77;
			}
			c.setColor (Color.orange);
			for (int y = 0 ; y < spaces [squareTwo - 1].length () ; y++)
			{
			    if (xDone == false)
			    {
				if (spaces [squareTwo - 1].charAt (y) != '.')
				{
				    strSquareXTwo += spaces [squareTwo - 1].charAt (y);
				}
				else
				{
				    xDone = true;
				}
			    }
			    else
			    {
				strSquareYTwo += spaces [squareTwo - 1].charAt (y);
			    }
			}
			try
			{
			    squareXTwo = Integer.parseInt (strSquareXTwo);
			    squareYTwo = Integer.parseInt (strSquareYTwo);
			}
			catch (NumberFormatException e)
			{
			}
			c.fillStar (squareXTwo + 17, squareYTwo + 26, 12, 12);
			try
			{
			    Thread.sleep (1000);
			}
			catch (Exception e)
			{
			}
			strSquareXTwo = "";
			strSquareYTwo = "";
			c.setFont (new Font ("PT Serif", 1, 17));
			c.setColor (Color.white);
			c.drawString (playerTwo + ": Going up!", 250, 490);
			c.setColor (Color.white);
			c.drawString (playerTwo + ": Going down!", 250, 490);
		    }
		    if (playerRoll != 6 && victory == false)
		    {
			currentTurn = 1;
			turnNum++;
		    }
		    else if (playerRoll == 6 && victory == false)
		    {
			c.setColor (Color.black);
			c.drawString (playerTwo + ": You rolled a 6, so you get an extra roll!", 160, 490);

			try
			{
			    Thread.sleep (2000);
			}
			catch (Exception e)
			{
			}

			c.setColor (Color.white);
			c.drawString (playerTwo + ": You rolled a 6, so you get an extra roll!", 160, 490);
		    }
		}
		else
		{
		    try
		    {
			Thread.sleep (2000);
		    }
		    catch (Exception e)
		    {
		    }
		    c.setColor (Color.white);
		    c.drawString (playerTwo + ": You rolled a " + playerRoll + "!", 220, 490);
		    c.setColor (Color.black);
		    c.drawString (playerTwo + ": So close! You must roll a " + (100 - squareTwo) + " to land directly on the 100th square and win.", 5, 490);
		    try
		    {
			Thread.sleep (3000);
		    }
		    catch (Exception e)
		    {
		    }
		    c.setColor (Color.white);
		    c.drawString (playerTwo + ": So close! You must roll a " + (100 - squareTwo) + " to land directly on the 100th square and win.", 5, 490);
		    currentTurn = 1;
		    turnNum++;
		}
	    }

	    try
	    {
		Thread.sleep (1000);
	    }
	    catch (Exception e)
	    {
	    }
	}
	title ();
	if (currentTurn == 1)
	{
	    c.print ("", 20);
	    c.println ("Congratulations " + playerOne + "! You won in " + turnNum + " turns.");
	    while (savedScore == false)
	    {
		int x = 0;
		if (highScores [x] [0] == "NJLIO")
		{
		    highScores [x] [0] = playerOne;
		    highScores [x] [1] = Integer.toString (turnNum);
		    savedScore = true;
		}
		x++;
	    }
	}
	else
	{
	    c.print ("", 20);
	    c.println ("Congratulations " + playerTwo + "! You won in " + turnNum + " turns.");
	    while (savedScore == false)
	    {
		int x = 0;
		if (highScores [x] [0] == "NJLIO")
		{
		    highScores [x] [0] = playerTwo;
		    highScores [x] [1] = Integer.toString (turnNum);
		    savedScore = true;
		}
		x++;
	    }
	}
	fileIO ();
	pauseProgram ();
	turnNum = 1;
	currentTurn = 1;
	squareOne = 0;
	squareTwo = 0;
    }


    /*
    This method will return a random integer from 1-6 to be used as the player's dice roll.
    -----------------------------------------------------------------------------------------
    Local Variables: None.
    Global Variables: None.
    -----------------------------------------------------------------------------------------
    No input/logic/loop is used.
    */
    private int diceRoll ()
    {
	return (int) (Math.random () * 6 + 1);
    }


    /*
    This method draws the Snakes and Ladders board.
    ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Local Variables: ladderY, numSquare, strNumSquare, boardGrey, snakeGreen, ladderBrown, snakeLeftX, snakeLeftY, snakeRightX, snakeRightY,snakeCentreX, snakeCentreY, snakeBottomX, snakeBottomY, x, x2, and y.
    Global Variables Used: None.
    ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    NAME            VARIABLE'S TYPE         DESCRIPTION
    ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    ladderY         int                     This variable stores the y coordinates of the rungs of the ladders.
    numSquare       int                     This variable stores the number of a square as an integer.
    strNumSquare    string                  This variable stores the number of a square as a string.
    boardGrey       color                   This variable stores the grey colour of the board.
    snakeGreen      color                   This variable stores the green colour of the snake.
    ladderBrown     color                   This variable stores the brown colour of the ladder.
    snakeLeftX      int                     This array stores the x coordinates of the leftmost snake.
    snakeLeftY      int                     This array stores the y coordinates of the leftmost snake.
    snakeRightX     int                     This array stores the x coordinates of the rightmost snake.
    snakeRightY     int                     This array stores the y coordinates of the rightmost snake.
    snakeCentreX    int                     This array stores the x coordinates of the centre snake.
    snakeCentreY    int                     This array stores the y coordinates of the centre snake.
    snakeBottomX    int                     This array stores the x coordinates of the bottommost snake.
    snakeBottomY    int                     This array stores the y coordinates of the bottommost snake.
    x               int                     This variable is used in a loop to draw multiple parts of the board.
    x2              int                     This variable is used in a loop to draw multiple parts of the board.
    y               int                     This variable is used in a loop to draw multiple parts of the board.
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    The method uses multiple loops to draw the board and its ladders.
    */
    public void board ()
    {
	int ladderY = 0;
	int numSquare = 100;
	String strNumSquare;
	Color boardGrey = new Color (105, 105, 105);
	Color snakeGreen = new Color (0, 255, 0);
	Color ladderBrown = new Color (120, 63, 4);

	int snakeLeftX[] = {171, 175, 186, 207, 213, 236, 242, 255, 262, 258, 236, 220, 213, 200, 194};
	int snakeLeftY[] = {71, 55, 54, 65, 93, 107, 130, 135, 142, 145, 143, 128, 107, 93, 73};
	int snakeRightX[] = {422, 428, 433, 448, 450, 464, 465, 475, 477, 475, 456, 448, 447, 437, 435};
	int snakeRightY[] = {69, 59, 59, 73, 97, 110, 130, 136, 142, 145, 136, 122, 104, 93, 74};
	int snakeCentreX[] = {380, 397, 399, 388, 352, 335, 308, 304, 300, 293, 296, 315, 338, 352, 378};
	int snakeCentreY[] = {148, 158, 179, 236, 266, 312, 330, 330, 330, 330, 319, 285, 266, 224, 200, 180};
	int snakeBottomX[] = {247, 266, 277, 308, 323, 350, 361, 380, 388, 386, 353, 334, 323, 300, 287};
	int snakeBottomY[] = {417, 401, 398, 401, 421, 430, 448, 448, 450, 453, 459, 450, 434, 427, 412};

	c.setColor (boardGrey);
	c.fillRect (114, 46, 430, 420);
	c.setColor (Color.red);
	for (int y = 46 ; y < 425 ; y = y + 42)
	{
	    for (int x = 114 ; x < 459 ; x = x + 86)
	    {
		c.fillRect (x, y, 43, 42);
	    }
	    y = y + 42;
	    for (int x2 = 157 ; x2 < 502 ; x2 = x2 + 86)
	    {
		c.fillRect (x2, y, 43, 42);
	    }
	}


	c.setColor (snakeGreen);
	c.fillPolygon (snakeLeftX, snakeLeftY, 15);
	c.fillPolygon (snakeRightX, snakeRightY, 15);
	c.fillPolygon (snakeCentreX, snakeCentreY, 15);
	c.fillPolygon (snakeBottomX, snakeBottomY, 15);
	c.setColor (Color.black);
	c.fillOval (177, 59, 6, 6);
	c.fillOval (430, 64, 5, 5);
	c.fillOval (385, 160, 8, 8);
	c.fillOval (265, 405, 7, 7);

	c.setColor (ladderBrown);
	// Centre ladder
	for (int x = 0 ; x < 3 ; x++)
	{
	    c.drawLine (250 + x, 101, 430 + x, 370);
	    c.drawLine (270 + x, 101, 450 + x, 370);
	}


	for (int x = 0 ; x < 181 ; x = x + 10)
	{
	    while (ladderY < 262)
	    {
		c.drawLine (260 + x, 111 + ladderY, 278 + x, 111 + ladderY);
		ladderY = ladderY + 15;
		break;
	    }
	}


	ladderY = 0;
	// Left ladder
	for (int x = 0 ; x < 3 ; x++)
	{
	    c.drawLine (170 + x, 270, 120 + x, 360);
	    c.drawLine (190 + x, 270, 140 + x, 360);
	}


	for (int x = 0 ; x < 181 ; x = x + 9)
	{
	    while (ladderY < 61)
	    {
		c.drawLine (165 - x, 285 + ladderY, 183 - x, 285 + ladderY);
		ladderY = ladderY + 15;
		break;
	    }
	}


	ladderY = 0;
	// Bottom ladder
	for (int x = 0 ; x < 3 ; x++)
	{
	    c.drawLine (392, 393 + x, 300, 435 + x);
	    c.drawLine (392, 413 + x, 300, 455 + x);
	}


	for (int x = 0 ; x < 61 ; x = x + 15)
	{
	    while (ladderY < 61)
	    {
		c.drawLine (377 - x, 400 + ladderY, 377 - x, 420 + ladderY);
		ladderY = ladderY + 7;
		break;
	    }
	}


	for (int y = 56 ; y < 477 ; y = y + 84)
	{
	    for (int x = 134 ; x < 522 ; x = x + 43)
	    {
		strNumSquare = "";
		strNumSquare = "" + numSquare;
		numSquare--;

		c.setColor (Color.white);
		c.setFont (new Font ("PT Serif", 0, 10));
		c.drawString (strNumSquare, x, y);
	    }
	    numSquare = numSquare - 10;
	}


	numSquare = 81;
	for (int y = 98 ; y < 477 ; y = y + 84)
	{
	    for (int x = 134 ; x < 522 ; x = x + 43)
	    {
		strNumSquare = "";
		strNumSquare = "" + numSquare;
		numSquare++;

		c.setColor (Color.white);
		c.drawString (strNumSquare, x, y);
	    }
	    numSquare = numSquare - 30;
	}
    }


    /*
    This method will retrieve the top 10 high scores from the HighScores.sal file and output them in a table to the user.
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Local Variables: fileExist, input, fileName, x, and y.
    Global Variables Used: highScores.
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    NAME        VARIABLE'S TYPE         DESCRIPTION
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    fileExist   boolean                 This variable stores whether or not the file HighScores.sal exists. If the user has not played a game yet or has cleared the high scores, it will not exist.
    input       BufferedReader          This variable allows a file's contents to be read.
    fileName    String                  This variable stores the name of the file, HighScores.sal.
    x           int                     This variable is used multiple times to do repetitive actions.
    y           int                     This variable stores the current column of the element being changed.
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    For loops are used to check multiple numbers and swap, store, or output them.
    */
    public void highScore ()
    {
	boolean fileExist = false;
	BufferedReader input;
	PrintWriter output;
	String fileName = "HighScores.sal";

	title ();

	try
	{
	    input = new BufferedReader (new FileReader (fileName));
	    for (int x = 0 ; x < ROW - 1 ; x++)
	    {
		for (int y = 0 ; y < COL ; y++)
		{
		    try
		    {
			highScores [x] [y] = input.readLine ();
		    }
		    catch (Exception e)
		    {
		    }
		}
	    }
	    fileExist = true;
	    input.close ();
	}
	catch (IOException e)
	{
	    c.print (' ', 20);
	    c.println ("There are no high scores yet! Play a game to add your high score.");
	    pauseProgram ();
	}

	if (fileExist = true)
	{
	    c.setCursor (3, 20);
	    c.print ("Rank");
	    c.setCursor (3, 40);
	    c.print ("Name");
	    c.setCursor (3, 60);
	    c.print ("Turns Won In");
	    for (int x = 1 ; x <= 10 ; x++)
	    {
		c.setCursor (3 + x, 20);
		c.print (x);
		if (highScores [x - 1] [0] != null)
		{
		    c.setCursor (3 + x, 40);
		    c.print (highScores [x - 1] [0]);
		    c.setCursor (3 + x, 60);
		    c.print (highScores [x - 1] [1]);
		}
		else
		{
		    c.setCursor (3 + x, 40);
		    c.print ("N/A");
		    c.setCursor (3 + x, 60);
		    c.print ("N/A");
		}
	    }
	    c.println ("");
	    c.println ("");
	    c.print ("", 24);
	    c.println ("Press 1 to clear the high scores.");
	    pauseProgram ();
	    if (option == '1')
	    {
		try
		{
		    output = new PrintWriter (new FileWriter ("HighScores.sal"));
		    output.close ();
		}
		catch (IOException e)
		{
		}
		for (int x = 0 ; x < ROW ; x++)
		{
		    highScores [x] [0] = null;
		    highScores [x] [1] = null;
		}
		title ();
		c.print ("", 24);
		c.println ("The scoreboard has been cleared.");
		pauseProgram ();
	    }
	}
    }


    /*
    This method will order the top 10 high scores and save them to a file (HighScores.sal, sal standing for snakes and ladders) after each finished game.
    ------------------------------------------------------------------------------------------------------------------------------------------------------------------
    Local Variables: output, swapNum, scores, fileName, x, and y.
    Global Variables Used: highScores.
    ------------------------------------------------------------------------------------------------------------------------------------------------------------------

    NAME        VARIABLE'S TYPE         DESCRIPTION
    ------------------------------------------------------------------------------------------------------------------------------------------------------------------
    output      PrintWriter             This variable allows a file's contents to be altered.
    swapNum     int                     This variable stores a temporary integer that will be swapped with a lower score.
    scores      int []                  This variable stores an array of the top 10 players' scores as integers.
    fileName    String                  This variable stores the name of the file, HighScores.sal.
    x           int                     This variable is used multiple times to do repetitive actions.
    y           int                     This variable is used to store the value of the column of the scores array which is being output to the HighScores.sal file.
    ------------------------------------------------------------------------------------------------------------------------------------------------------------------

    For loops are used to check multiple numbers and swap, store, or output them.
    */
    private void fileIO ()
    {
	PrintWriter output;
	int swapNum;
	int[] scores = new int [ROW];
	String fileName = "HighScores.sal";
	for (int x = 0 ; x < ROW ; x++)
	{
	    if (highScores [x] [1] != null)
	    {
		scores [x] = Integer.parseInt (highScores [x] [1]);
	    }
	}

	for (int x = 0 ; x < ROW - 1 ; x++)
	{
	    if (scores [x] < scores [x + 1])
	    {
		swapNum = scores [x];
		scores [x] = scores [x + 1];
		scores [x + 1] = swapNum;
	    }
	}
	for (int x = 0 ; x < ROW - 1 ; x++)
	{
	    highScores [x] [1] = Integer.toString (scores [x]);
	}

	try
	{
	    output = new PrintWriter (new FileWriter (fileName));
	    for (int x = 0 ; x < ROW - 1 ; x++)
	    {
		output.println (highScores [x] [0]);
		output.println (highScores [x] [1]);
	    }
	    output.close ();
	}
	catch (IOException e)
	{
	}
	for (int x = 0 ; x < 2 ; x++)
	{
	    highScores [10] [x] = "NJLIO";
	}

    }


    /*
    This method will display a message thanking the user for using the program.
    --------------------------------------------------------------------------------
    LocalVariables: None.
    GlobalVariables: None.
    --------------------------------------------------------------------------------
    No input/logic/loop is used.
    */
    public void goodbye ()
    {
	title ();
	c.print ("", 20);
	c.println ("Thank you for playing Snakes and Ladders.");
	c.print ("", 29);
	c.println ("Programmer: Kevin Nguyen");
	try
	{
	    Thread.sleep (2000);
	}


	catch (Exception e)
	{

	}


	c.close ();
    }



    /*
    This method is used to assign the class constructor to a variable.
    ----------------------------------------------------------------------
    Local Variables: None.
    Global Variables Used: c.
    ----------------------------------------------------------------------
    No input/logic/loop is used.
    */
    public SnakesAndLadders ()
    {
	c = new Console ("Snakes and Ladders");
    }


    /*
    This method will run the other methods in the program.
    -------------------------------------------------------------------------------------------------------------------
    Local Variables: s.
    Global Variables Used: option.
    -------------------------------------------------------------------------------------------------------------------

    NAME        VARIABLE'S TYPE         DESCRIPTION
    -------------------------------------------------------------------------------------------------------------------
    s           reference               This variable is the reference variable for the SnakesAndLadders class.
    -------------------------------------------------------------------------------------------------------------------

    A while loop is used to determine whether or not the user wanted to exit the program in the mainMenu screen.
    */
    public static void main (String[] args)
    {
	SnakesAndLadders s = new SnakesAndLadders ();
	s.splashScreen ();
	while (true)
	{
	    s.mainMenu ();
	    if (option == '1')
	    {
		s.playGame ();
	    }
	    else if (option == '2')
	    {
		s.instructions ();
	    }
	    else if (option == '3')
	    {
		s.highScore ();
	    }
	    else
	    {
		break;
	    }
	}

	s.goodbye ();

    } // main method
} // SnakesAndLadders class


