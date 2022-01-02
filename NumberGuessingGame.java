// Programer: Jasen Ratnam
// Date: 2016-10-17
// Assignment 3_B
/* Purpose: Write a guessing game program in wich the computer generates
            a random integer number between 1 and 100.*/

import java.util.Random;
import java.util.Scanner;
public class  NumberGuessingGame
{
	public static int readNextInt(Scanner input) // create method to make sure an input is a int
	{
		while (!input.hasNextInt()) //if input is not a int
		{
			String badInput = input.next(); //consume the bad input
			System.out.print("Bad input '" + badInput +
							"'. Please enter an integer.");
		}
		return input.nextInt(); //return for new int
	}

	public static void main(String[] args)
	{


		// display game rules
		System.out.println("Welcome to my Number Guessing Game!");
		System.out.println();
		System.out.println("Rules:");
		System.out.println("1. We will play as many rounds as you wish.");
		System.out.println("2. Each round you will guess the number I've picked.");
		System.out.println("3. if youguess the correct value in 7 or fewer tries\n" +
		                   "   then you score a point, otherwise I score a point.");
		System.out.println("4. Whoever has the most point after all rounds wins.");
		System.out.println();
		System.out.println();

		// pre initalize values
		int x = 0;                          //save random number
		int numberOfTries;                  //save number of tries
		int guess = 0;                      //save guess of user
		int you = 0;                        //save user's score
		int me = 0;                         //save my score
		char ans;                           //save answer for nest round or not
		int roundNum = 0;                   //save roundnumber
		boolean play = true;                //save play or not
		final int MAX_TRIES = 7;            //save max tries
		final int MAX_TRIES_BEFORE_LAST= 6; //save max tries - 1
		final int MAX_RANGE = 100;          //save max range
		final int MIN_RANGE = 1;            //save min range

		//start game loop
		while (play = true)
		{
			roundNum ++;                                    //count number of rounds
			numberOfTries = 0;                              //initialize number of tries to 0 each time loop starts

			System.out.println("\n\nRound " + roundNum);    //declare number of round
			System.out.println("-------");                  //print divider

			Random rand = new Random();                     //create random number to guess
			Scanner input = new Scanner(System.in);
			//save random number
			x = rand.nextInt(MAX_RANGE) + MIN_RANGE;                      //range is 1<= x <= 100

			//ask user to guess a number
			System.out.println("I've picked an integer from 1 to 100.");
			System.out.print("Guess it:");

			//make sure guess number is a int and save
			guess = readNextInt(input);

			if (guess < MIN_RANGE || guess > MAX_RANGE)//make sure guess number is in range
			{
			  System.out.print("Your guess is out of range- guess again: ");
			  guess = readNextInt(input);
			  numberOfTries++;
			}
			else
			{
				numberOfTries++;  //count number of tries
			}

			while (numberOfTries < MAX_TRIES_BEFORE_LAST && !(guess == x)) //loop for max amount of tries until correct value is guesses
			{

				if (guess < MIN_RANGE || guess > MAX_RANGE) //if guess is out of range
				{
				  System.out.print("Your guess is out of range- guess again: ");
				  //guess = readNextInt(input);

				}
				else if ( guess < x) //if guess is smaller than x
				{
					//count number of tries
					System.out.print("Guess higer: ");
					//guess = readNextInt(input);
					numberOfTries++;
				}
				else if ( guess > x) //if guess is bigger than x
				{
					//count number of tries
					System.out.print("Guess lower: ");
					//guess = readNextInt(input);
					numberOfTries++;
				}
				guess = readNextInt(input);
			}

			if ((guess != x)) //last round if guess is still wrong
			{
				while (numberOfTries < MAX_TRIES && !(guess == x)) //lopp for last round
				{
					if (guess < MIN_RANGE || guess > MAX_RANGE) //if out of range
					{
					  System.out.print("Your guess is out of range- guess again: ");
					  guess = readNextInt(input);
					}
					else if ( guess < x) //if smaller
					{
						//count number of tries
						System.out.print("Guess higher: Last chance! ");
						guess = readNextInt(input);
						while (guess < MIN_RANGE || guess > MAX_RANGE)//if out of range
						{
							System.out.print("Your guess is out of range- guess again: ");
							guess = readNextInt(input);
						}
						numberOfTries++;
					}
					else if ( guess > x) //if bigger
					{
						//count number of tries
						System.out.print("Guess lower: Last chance! ");
						guess = readNextInt(input);
						while (guess < MIN_RANGE || guess > MAX_RANGE)//if out of range
						{
							System.out.print("Your guess is out of range- guess again: Last chance! ");
							guess = readNextInt(input);
						}
						numberOfTries++;

					}
				}
				if (!(guess == x)) //if guess is still not right
				{
					System.out.print("You lose this round! I was thinking of the number " + x);
					me++; //point for me
				}
				else //if guess is right
				{
					System.out.print("You win this round! You got it right in " +
									  numberOfTries + "  guess. ");
					you++; //point for you
				}


			}
			else //if guess was right
			{
				System.out.print("You win this round! You got it right in " +
									numberOfTries + "  guess. ");
				you++; //point for you
			}

			do
			{
				System.out.println();
				System.out.print("\nAnother round (y/n)? "); //ask user for another round
				ans = input.next().toLowerCase().charAt(0);//save first character inputed in lowercase

				if (ans == 'y') // if yes than continu
				{
					play = true;
				}
				else if (ans == 'n') //if no than stop and display results
				{
					play = false;
					System.out.println("Scores:");
					System.out.println("------");
					System.out.println("  You: " + you);
					System.out.println("  Me : " + me);
					System.out.println();

					if (you == me)//if score is same
					{
						System.out.println("*** We tied ***");
					}
					else if (you < me)//if my score is bigger
					{
						System.out.println("*** I win! ***");
					}
					else //if your score is bigger
					{
						System.out.println("*** You win! ***");
					}
					System.out.println("Thanks for playing my Number Guessing Game!");
					return;
				}
				else //if wrong input
				{
					System.out.println("Error: Invalid answer.");
					//System.out.println("Error: Please try again later.");
					//System.out.println("Bye!");
					//System.exit (1);
				}
			}while((ans != 'n') && (ans != 'y')); // do
		}
	}
}









