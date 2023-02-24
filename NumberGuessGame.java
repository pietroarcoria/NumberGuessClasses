import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {
    private Random rand;
    private int numberToGuess;
    private int maxRange;
    private int minRange;
    private ArrayList<Integer> guesses;

    public NumberGuessGame(int minRange, int maxRange) {
        this.minRange = minRange;
        this.maxRange = maxRange;
        rand = new Random();
        numberToGuess = rand.nextInt(maxRange - minRange + 1) + minRange;
        guesses = new ArrayList<>();
    }

    public void play() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Guess any number between " + minRange +" and " + maxRange + ": ");
            int guess = input.nextInt();

            if (guesses.contains(guess)) {
                System.out.println("You already guessed that number. Try again.");
            } else {
                guesses.add(guess);
            }

            if (guess == numberToGuess) {
                System.out.println("Correct, the number I chose was " + numberToGuess);
                System.out.print("Do you want to play again? (yes/no) ");
                String answer = input.next();
                if (answer.equals("no")) {
                    break;
                } else {
                    numberToGuess = rand.nextInt(maxRange - minRange + 1) + minRange;
                    guesses.clear();
                }
            } else if (guess < numberToGuess) {
                System.out.println("The number I chose is higher");
            } else if (guess > numberToGuess) {
                System.out.println("The number I chose is lower");
            }
        }

        input.close();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the minimum range of numbers: ");
            int minRange = input.nextInt();

            System.out.print("Enter the maximum range of numbers: ");
            int maxRange = input.nextInt();

            NumberGuessGame game = new NumberGuessGame(minRange, maxRange);
            game.play();

            System.out.print("Do you want to start a new game? (yes/no) ");
            String answer = input.next();
            if (answer.equals("no")) {
                break;
            }
        }

        input.close();
    }
}
