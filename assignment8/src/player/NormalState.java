package player;

public class NormalState implements State {

    @Override
    public void train(Player player) {
        System.out.println(player.getName() + " trains steadily, building strength and gaining 80 experience points.");
        player.gainExperience(80);
    }

    @Override
    public void meditate(Player player) {
        int baseHeal = 50;
        int variation = (int)(Math.random() * 21) - 10; // Random variation between -10 and +10
        int totalHeal = baseHeal + variation;
        System.out.println(player.getName() + " takes a moment to breathe and refocus, restoring " + totalHeal + " health points.");
        player.addHealth(totalHeal);
    }

    @Override
    public void fight(Player player, Player enemy) {
        int baseDamage = player.getAttackPower();
        int variation = (int)(Math.random() * 11) - 5; // Random variation between -5 and +5
        int totalDamage = baseDamage + variation;

        System.out.println(player.getName() + " engages " + enemy.getName() + " in combat with balanced force.");
        System.out.println(player.getName() + " is in Neutral Stance: Delivering a standard attack with power " + totalDamage + ".");
        enemy.defend(totalDamage,player);
        System.out.println(player.getName() + " gains 20 experience points for the effort.");
        player.gainExperience(40);
    }

    @Override
    public void defend(Player player, int damage , Player enemyPlayer) {
        int reducedDamage = (int) (damage *0.8); //reduced damage taken by 20%
        System.out.println(player.getName() + " stands firm in Neutral Stance, absorbing the full impact of " + reducedDamage + " damage.");
        player.takeDamage(reducedDamage);
    }
    public String getName(){
        return "Neutral Stance";
    }
}
