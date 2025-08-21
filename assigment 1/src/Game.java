public class Game {
    private Map map;

    public void createMap(){
         map = new CityMap();
    }
    public void start(){
        map.display();
    }
public static void main(String[] args) {

    Game game = new Game();
    game.createMap();
    game.start();

}
}
