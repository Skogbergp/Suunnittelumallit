package map;
/*
import java.util.Scanner;

public class Game {
    private Map map;

    public void createMap(int choice){
        if (choice == 1) {
            System.out.println("Wilderness Map selected.");
            map = new WildernessMap();
        } else if (choice == 2) {
            System.out.println("City Map selected.");
            map = new CityMap();
        } else {
            System.out.println("Invalid choice. Please select 1 or 2.");
        }
    }
    public void start(){
        if (map == null) {
            System.out.println("Map not created. Please create a map first.");
            return;
        }
        map.createTile();
        map.display();

    }
public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        while (true){
            Game game = new Game();
            System.out.println("Choose map type:");
            System.out.println("1. Wilderness Map");
            System.out.println("2. City Map");
            System.out.print("Enter your choice (1 or 2): ");
            int choice = Integer.parseInt(sc.nextLine());
            game.createMap(choice);
            game.start();
        }

}
}
*/