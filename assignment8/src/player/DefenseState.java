package player;

public class DefenseState implements State {

    private double counterChance = 0.20; // 20% chance to counterattack

    @Override
    public void train(Player player) {
        System.out.println(player.getName() + " sharpens their technique with disciplined training, gaining 50 experience points.");
        player.gainExperience(50);
    }

    @Override
    public void meditate(Player player) {
        int baseHeal = 65;
        int variation = (int)(Math.random() * 21) - 10; // Random variation between -10 and +10
        int totalHeal = baseHeal + variation;
        System.out.println(player.getName() + " enters a deep meditative state, restoring " + totalHeal + " health points with serene focus.");
        player.addHealth(totalHeal);
    }

    @Override
    public void fight(Player player, Player enemy) {
        int baseDamage = player.getAttackPower();
        int variation = (int)(Math.random() * 11) - 3; // Random variation between -3 and +3
        int totalDamage = baseDamage + variation;

        System.out.println(player.getName() + " engages " + enemy.getName() + " with measured strikes.");
        System.out.println(player.getName() + " is in Defense Stance: Delivering a controlled blow with half power (" + (totalDamage / 2) + ").");
        enemy.defend(totalDamage / 2,player);
        System.out.println(player.getName() + " gains 20 experience points for their tactical precision.");
        player.gainExperience(20);
    }

    @Override
    public void defend(Player player, int damage, Player attacker) {
        int reducedDamage = damage / 2; // Reduce damage by 50%
        int counterDamage = (int)(player.getAttackPower() / 1.5); // Counterattack damage is 66% of attack power
        System.out.println(player.getName() + " braces for impact in Defense Stance, reducing incoming damage from " + damage + " to " + reducedDamage + ".");
        if(Math.random() < counterChance) { // 20% chance to counterattack

            System.out.println(player.getName() + " executes a swift counterattack against " + attacker.getName() + "!");
            attacker.takeDamage(counterDamage);
            System.out.println(attacker.getName() + " takes " + counterDamage + " damage from the counterattack.");
            counterChance = 0.20; // Reset counter chance after a successful counter
            player.takeDamage(reducedDamage);
        }
        counterChance += 0.05; // Increase counter chance by 5% each time defending and not countering
        player.takeDamage(reducedDamage);
    }
}
