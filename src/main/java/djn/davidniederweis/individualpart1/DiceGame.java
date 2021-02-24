package djn.davidniederweis.individualpart1;

// import Scanner to get user input
import java.util.Scanner;

// class holds methods for DiceGame
public class DiceGame {
	// prints greeting and rules
	public static void printGreeting() {
		System.out.println("*".repeat(42));
		System.out.println(

				"* Welcome to the Dice Game.\t\t *\n* The rules are as follows:\t\t *\n*\tTwo dice will be rolled.\t *\n*\tIf both dice are equal, you win. *\n*\tElse, you loose.\t\t *");
		System.out.println("*".repeat(42));
		System.out.println("Do you want to play?(y/no):");
	}

	// prints game statistics
	// int gamesPlayed: stores number of games played, used to calculate winning
	// percentage
	// int gamesLost: stores number of games won, displayed to user
	// int gamesWon: stores number of games played, used to calculate winning
	// percentage
	public static void printStats(int gamesPlayed, int gamesLost, int gamesWon) {
		System.out.println("\n" + "=".repeat(42));
		System.out.println(" Games Played\t\t\t\t" + gamesPlayed);
		System.out.println(" Games Lost\t\t\t\t" + gamesLost);
		System.out.println(" Games Won\t\t\t\t" + gamesWon);
		System.out.println(" Win Percentage\t\t\t     " + String.format("%.2f", ((float) gamesWon / gamesPlayed)));
		System.out.println("=".repeat(42));
	}

	// runs game
	public static void main(String[] args) {

		// creates scanner for input
		Scanner sc = new Scanner(System.in);

		// print greeting
		printGreeting();

		// get user input
		String input = sc.next();

		// initialize number of games played, won, and lost
		int gamesPlayed = 0;
		int gamesWon = 0;
		int gamesLost = 0;

		// loop for game
		while (!input.equals("no")) {

			// switch on user input
			switch (input) {

				// user wants to continue
				// increment number of games played
				// generate two dice scores
				// if equal, user won, increment games won
				// else user lost, increment games lost
				case "y":
					gamesPlayed++;
					int die1 = (int) (Math.random() * 6) + 1;
					int die2 = (int) (Math.random() * 6) + 1;
					System.out.println("\n\nDie one: " + die1 + "\nDie two: " + die2);
					if (die1 == die2) {
						System.out.println("Congratulations! You won!");
						gamesWon++;
					} else {
						System.out.println("Sorry, you lost!");
						gamesLost++;
					}
					break;

				// user wants to quit
				// break loop
				case "no":
					break;

				// user entered invalid input
				default:
					System.out.println("Invalid input.");
					break;
			}

			// print stats, ask user whether they want to play again and get user input
			printStats(gamesPlayed, gamesLost, gamesWon);
			System.out.println("\n\nDo you want to play again?(y/no)");
			input = sc.next();
		}

		// user wants to exit, print exiting message
		System.out.println("-".repeat(42));
		System.out.println("Exiting...");
		sc.close();
	}
}
