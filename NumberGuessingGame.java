import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        int rounds = 1;
        
        System.out.println("Welcome to the Guess the Number Game!");
        System.out.print("How many rounds would you like to play? ");
        int totalRounds = scanner.nextInt();

        while (rounds <= totalRounds) {
            System.out.println("\nRound " + rounds + " of " + totalRounds);
            int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
            int attempts = 0;
            int maxAttempts = 7;
            boolean hasWon = false;
            int roundScore = 0;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (1-100): ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                } else if (guess > numberToGuess) {
                    System.out.println("Your guess is too high.");
                } else {
                    hasWon = true;
                    roundScore = 10 - attempts; // Higher score for fewer attempts
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    break;
                }
            }

            if (!hasWon) {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The correct number was " + numberToGuess);
            }

            totalScore += roundScore;
            System.out.println("Score for this round: " + roundScore);
            System.out.println("Total score so far: " + totalScore);

            rounds++;
        }

        System.out.println("\nGame Over! Your total score is: " + totalScore);
        scanner.close();
    }
}

