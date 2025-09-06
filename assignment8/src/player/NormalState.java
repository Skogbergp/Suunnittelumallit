package player;

public class NormalState implements State {

    @Override
    public void train(Player player) {
        System.out.println(player.getName() + " trains steadily, building strength and gaining 50 experience points.");
        player.gainExperience(50);
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
        System.out.println(player.getName() + " is in Normal Stance: Delivering a standard attack with power " + totalDamage + ".");
        enemy.defend(totalDamage,player);
        System.out.println(player.getName() + " gains 20 experience points for the effort.");
        player.gainExperience(40);
    }

    @Override
    public void defend(Player player, int damage , Player enemyPlayer) {
        System.out.println(player.getName() + " stands firm in Normal Stance, absorbing the full impact of " + damage + " damage.");
        player.takeDamage(damage);
    }
}
