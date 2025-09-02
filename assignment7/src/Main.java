import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name your character: ");

        Character hero = new Character(scanner.nextLine());

        System.out.println("Welcome, " + hero.getName() + "! Your journey begins now.");
        
        // Initial state: Novice
        while (true) { 
            hero.printStatus();
            System.out.println("Choose an action: 1. Train 2. Meditate 3. Fight  5. Exit");
            int choice = scanner.nextInt();
            
            switch(choice) {
                case 1:
                    hero.train();
                    break;
                case 2:
                    hero.meditate();
                    break;
                case 3:
                    hero.fight();
                    break;
                case 5:
                    System.out.println("Exiting the game. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
}
}