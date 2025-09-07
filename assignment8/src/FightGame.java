import player.BerserkState;
import player.DefenseState;
import player.NormalState;
import player.Player;

import java.util.ArrayList;
import java.util.Scanner;


public class FightGame extends Game {
    Scanner sc = new Scanner(System.in);
    private ArrayList<Player> players = new ArrayList<>();

    @Override
    public void initializeGame(int numberOfPlayers) {

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Name your character player " + (i + 1) + ": ");
            players.add(new Player(sc.nextLine()));
        }
    }

    @Override
    public boolean endOfGame() {
        //player wins when all other players are defeated
        if (players.size() == 1) {
            System.out.println("The winner is " + players.get(0).getName() + "!");
            players.get(0).printStatus();
            return true;
        }
        return false;

    }

    @Override
    public void playSingleTurn(int player) {
        Player currentPlayer = players.get(player); // get current player
        boolean validAction = false;
        int actionPoints = 2;
        while (actionPoints > 0) {

            currentPlayer.printStatus();
            System.out.println(currentPlayer.getName() + "'s turn. Action points left: " + actionPoints);
            System.out.println("Choose an action: 1. Train 2. Meditate 3. Fight 4. Change Stance");
            System.out.println("Each action costs 1 action point.");
            System.out.println();
            if (sc.hasNextInt()) {
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        currentPlayer.train();
                        validAction = true;
                        break;
                    case 2:
                        currentPlayer.meditate();
                        validAction = true;
                        break;
                    case 3:
                        Player opponent = selectOpponent(player);
                        currentPlayer.fight(opponent);
                        if (opponent != null && opponent.getCurrentHealth() <= 0) {
                            System.out.println(opponent.getName() + " has been defeated!");
                            players.remove(opponent);
                            currentPlayer.incrementPlayersDefeated();
                        }
                        validAction = true;
                        break;
                    case 4:
                        validAction = changeStance(currentPlayer);
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                        break;

                }
                if (validAction) {
                    actionPoints--;
                    validAction = false;
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.next(); // clear the invalid input
            }
        }
    }

    @Override
    public void displayWinner() {
        players.get(0).printStatus();
    }

    public Player selectOpponent(int currentPlayerIndex) {

        ArrayList<Player> opponents = new ArrayList<>();

        for (int i = 0; i < players.size(); i++) {
            if (i != currentPlayerIndex) {
                opponents.add(players.get(i));
            }
        }
        while (true) {
            System.out.println("Select an opponent to fight:");
            for (int i = 0; i < opponents.size(); i++) {
                System.out.println((i + 1) + ". " + opponents.get(i).getName());
            }

            if (sc.hasNextInt()) {
                int selection = sc.nextInt() - 1;
                if (selection >= 0 && selection < opponents.size()) {
                    return opponents.get(selection);
                }else  {
                    System.out.println("Invalid selection. Try again.");
                }

            } else {
                System.out.println("Invalid input. Try again.");
                sc.next(); // clear the invalid input
            }

        }
    }

    public boolean changeStance(Player player) {
        while (true) {

            System.out.println("Choose a stance: 1. Normal 2. Defense 3. Berserk");
            if (sc.hasNextInt()) {
                int stanceChoice = sc.nextInt();
                switch (stanceChoice) {
                    case 1:
                        if (player.getCurrentState().getName().equals("Neutral Stance")) {
                            System.out.println("You are already in Neutral stance.");
                            return false;
                        }
                        player.setCurrentState(new NormalState());
                        System.out.println(player.getName() + " switched to Neutral stance.");
                        return true;
                    case 2:
                        if (player.getCurrentState().getName().equals("Defense Stance")) {
                            System.out.println("You are already in Defense stance.");
                            return false;
                        }
                        player.setCurrentState(new DefenseState());
                        System.out.println(player.getName() + " switched to Defense stance.");
                        return true;
                    case 3:
                        if (player.getCurrentState().getName().equals("Berserk Stance")) {
                            System.out.println("You are already in Berserk stance.");
                            return false;
                        }
                        player.setCurrentState(new BerserkState());
                        System.out.println(player.getName() + " switched to Berserk stance.");
                        return true;
                    default:
                        System.out.println("Invalid choice. Stance not changed.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.next(); // clear the invalid input
            }

        }
    }
}
