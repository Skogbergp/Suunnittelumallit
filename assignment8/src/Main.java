import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         FightGame game = new FightGame();
        Scanner input = new Scanner(System.in);
        int playerCount = 0;

        while (true) {
            System.out.print("How many players would you like to play? ");
            if (input.hasNextInt()) {
                playerCount = input.nextInt();
                game.play(playerCount);
                if (playerCount > 0) break;
                else System.out.println("Please enter a number greater than 0.");
            } else {
                System.out.println("That's not a number!");
                input.next(); // discard invalid input
            }
        }

    }
    
}
