import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String [] args) throws Exception {
        File file = new File("movieslist.txt");
        Scanner scanner = new Scanner(file);
        String titles = "";
        String chosenMovie ="";
        int numberOfMovies = 0;
        int randomMovie = 0;

        //Count number of movies
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            titles += (line + "\n");
            numberOfMovies++;

        }
        //System.out.println(titles);
        //System.out.println(numberOfMovies);

        //Get a random movie
        randomMovie = (int) (Math.random() * numberOfMovies);
        //System.out.println(randomMovie);

        //Get title of a choosen movie
        File file2 = new File("movieslist.txt");
        Scanner scanner2 = new Scanner(file2);
        int i=0;
        while(i <= randomMovie){
            chosenMovie = scanner2.nextLine();
            i++;
        }
        //System.out.println(chosenMovie);

        Game game = new Game();
        game.Start(chosenMovie);
    }
}
