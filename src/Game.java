import java.util.Scanner;
import java.util.regex.Pattern;


public class Game {

    private int numGuess = 0;
    private int numLoops = 0;
    private Boolean alreadyGuessedThatLetter = false;


    public void Start(String chosenMovie) {
        String hidden = new String(new char[chosenMovie.length()]).replace('\0', '_');
        String lettersGuessed = "";
        String fixedMovie = chosenMovie;


        //Start the game
        System.out.println("I've chosen a movie for you to guess.");
        System.out.println("Can you do it?");



        //fix movie title to remove colons, spaces, etc...
        char[] unwantedCharacters = {':', ' '};
        fixedMovie = fixedMovie.replace(":", "_");
        fixedMovie = fixedMovie.replace(" ", "_");
        fixedMovie = fixedMovie.replace(", ", "_");

        Scanner scanner = new Scanner(System.in);

        //Initial game loop
        for (int i = 20; i > 0; i--) {
            System.out.println("You have " + i + " guess(es) left. Choose again: ");
            System.out.println("So far you have guessed: " + lettersGuessed);
            System.out.println("Current word " + hidden);

            //System.out.println(chosenMovie);
            //System.out.println("Fixed movie: " + fixedMovie);
            String guess = scanner.nextLine();
            char currentGuess = guess.charAt(0);

            if (Pattern.matches("[a-zA-Z]+", guess)) {
                //If this is not a letter that was already guessed
                //Check the logic to see where it is and reveal the letter in the word
                if (!alreadyGuessedThatLetter) {


                    for (int r = 0; r <= chosenMovie.length() - 1; r++) {
                        char current = chosenMovie.charAt(r);


                        //Convert answer to lowercase
                        currentGuess = Character.toLowerCase(currentGuess);
                        if (current == currentGuess) {
                            System.out.println("You guessed a correct letter");
                            char[] charHidden = hidden.toCharArray();
                            charHidden[r] = current;
                            hidden = String.valueOf(charHidden);

                        }

                        //Convert answer to uppercase
                        currentGuess = Character.toUpperCase(currentGuess);
                        if (current == currentGuess) {
                            System.out.println("You guessed a correct letter");
                            char[] charHidden = hidden.toCharArray();
                            charHidden[r] = current;
                            hidden = String.valueOf(charHidden);

                        }


                    }
                    lettersGuessed = lettersGuessed + currentGuess + ", ";
                    numGuess++;
                    numLoops++;
                }

                if (fixedMovie.equals(hidden)) {
                    System.out.println("YOU WIN!");
                    System.out.println("The movie was " + chosenMovie);
                    break;
                }
            } else {
                System.out.println("Please enter an alphabetical character.");
                i++;
            }



        }

        if (!fixedMovie.equals(hidden)) {
            System.out.println("You lose... :( ");

        }



    }
}