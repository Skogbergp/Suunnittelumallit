import java.util.ArrayList;
public abstract class Map {
    ArrayList<Tile> tiles = new ArrayList<>();

    public abstract void createTile();

    public void display(){
        int i=0;
        for (Tile tile : tiles) {
            System.out.print(tile.getCharacter());
            i++;
            if(i%3==0){
                System.out.println();
        }
            }
    }

}
