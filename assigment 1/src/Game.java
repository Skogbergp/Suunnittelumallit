import java.util.Scanner;

public class Game {
    private Map map;

    public void CreateWildernessMap(){
        map = new WildernessMap();
    }

    public void createCityMap(){
         map = new CityMap();
    }
    public void start(){
        map.createTile();
        map.display();

    }
public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("Choose map type:");
            System.out.println("1. Wilderness Map");
            System.out.println("2. City Map");
            System.out.print("Enter your choice (1 or 2): ");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                System.out.println("Wilderness Map selected.");
                Game game = new Game();
                game.CreateWildernessMap();
                game.start();

            } else if (choice.equals("2")) {
                System.out.println("City Map selected.");
                Game game = new Game();
                game.createCityMap();
                game.start();

            } else {
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        }

}
}
