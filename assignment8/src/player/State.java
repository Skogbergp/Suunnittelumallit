package player;

public interface State {


    public void train(Player player);
    public void meditate(Player player);
    public void fight(Player player, Player enemyPlayer);
    public void defend (Player player,int damage, Player enemyPlayer);
    public String getName();
}
