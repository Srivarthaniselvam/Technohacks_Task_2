import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    public static void main(String[] args) {
        int random_number = generateRandomNumber();
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You have 10 attempts to guess the number between 1 and 100.");

        int attempts = 10;
        boolean correct = false;
        Scanner scanner = new Scanner(System.in);

        while (attempts > 0 && !correct) {
            int guess = guessTheNumber(scanner);
            correct = checkIfEqual(random_number, guess);

            attempts--;

            if (attempts > 0 && !correct) {
                System.out.println("You have " + attempts + " attempt(s) left.");
            }
        }

        if (!correct) {
            System.out.println("\nYou lose! The correct number was: " + random_number);
        } else {
            System.out.println("\nCongratulations! You guessed the correct number. You win!");
        }

        System.out.println("Thank you for playing the Number Guessing Game!");
        scanner.close();
    }

    private static int generateRandomNumber() {
        Random rand = new Random();
        return rand.nextInt((MAX_NUMBER - MIN_NUMBER) + 1) + MIN_NUMBER;
    }

    private static boolean checkIfEqual(int correctNumber, int guess) {
        boolean correct = false;

        if (guess == correctNumber) {
            correct = true;
        } else if (guess > correctNumber) {
            System.out.println("Too high! Try again.");
        } else if (guess < correctNumber) {
            System.out.println("Too low! Try again.");
        }

        return correct;
    }

    private static int guessTheNumber(Scanner scanner) {
        int guess = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("\nEnter your guess: ");
            if (scanner.hasNextInt()) {
                guess = scanner.nextInt();
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // clear the invalid input
            }
        }

        return guess;
    }
}
