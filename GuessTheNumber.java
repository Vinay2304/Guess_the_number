import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxNumber = 10;  // to adjust the guessing range
        int attempts = 2;     // to adjust the number of attempts
        int totalRounds = 3;   // to adjust the number of rounds
        int score = 0;

        for (int round = 1; round <= totalRounds; round++) {
            int randomNumber = random.nextInt(maxNumber) + 1; // Generate random number

            System.out.println("Round " + round + ": Guess the number between 1 and " + maxNumber);

            int guessCount = 0;
            boolean guessedCorrect = false;

            while (guessCount < attempts && !guessedCorrect) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();

                guessCount++;

                if (guess == randomNumber) {
                    guessedCorrect = true;
                    System.out.println("Congratulations! You guessed the number in " + guessCount + " attempts.");

                    // Calculate points based on attempts (higher attempts, lower points)
                    int points = attempts - guessCount;
                    score += points;
                    System.out.println("You scored " + points + " points this round!");
                } else if (guess > randomNumber) {
                    System.out.println("Your guess is too high. Try again.");
                } else {
                    System.out.println("Your guess is too low. Try again.");
                }
            }

            if (!guessedCorrect) {
                System.out.println("You ran out of attempts. The number was " + randomNumber);
            }
        }

        System.out.println("Total Score: " + score);
        scanner.close();
    }
}
