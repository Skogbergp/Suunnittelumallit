import java.util.ArrayList;
import java.util.Scanner;


public class TestGame extends Game {
    Scanner sc = new Scanner(System.in);
    private ArrayList<Character> players = new ArrayList<>();

    @Override
    public void initializeGame(int numberOfPlayers) {

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Name your character player " + (i + 1) + ": ");
            players.add(new Character(sc.nextLine()));
        }
    }

    @Override
    public boolean endOfGame() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void playSingleTurn(int player) {
        Character currentPlayer = players.get(player);
            System.out.println("Choose an action: 1. Train 2. Meditate 3. Fight");
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    currentPlayer.train();
                    break;
                case 2:
                    currentPlayer.meditate();
                    break;
                case 3:
                    currentPlayer.fight();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");

        }
    }

    @Override
    public void displayWinner() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
