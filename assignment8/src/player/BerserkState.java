package player;

public class BerserkState implements State {

    @Override
    public void train(Player player) {
        System.out.println(player.getName() + " is training and gain 50 experience points.");

        player.gainExperience(50);
        
    }

    @Override
    public void meditate(Player player) {
        if (Math.random() < 0.15) { // 15% chance to fail
            System.out.println(player.getName() + " tries to meditate but is too enraged to focus. No healing.");
            return;
        }

        int baseHeal = 30;
        int variation = (int)(Math.random() * 21) - 6; // Random variation between -10 and +10
        int totalHeal = baseHeal + variation;
        System.out.println(player.getName() + " is meditating and restores "+ totalHeal +" health points.");
        player.addHealth(totalHeal);
    }

    @Override
    public void fight(Player player, Player enemyPlayer) {
        int baseExperience = 60;
        int levelDifference = player.getLevel() - enemyPlayer.getLevel();
        int experienceGain;

        if (levelDifference >= 5) {
            experienceGain = baseExperience + 10;
        } else if (levelDifference <= -5) {
            experienceGain = baseExperience + 20;
        } else {
            experienceGain = baseExperience;
        }

        System.out.println(player.getName() + " charges at " + enemyPlayer.getName() + " with unrelenting fury!");
        System.out.println(player.getName() + " is in Berserk Stance: Swinging with savage force (" + player.getAttackPower() * 2 + " attack power).");

        if (Math.random() < 0.15) { // 15% chance to fail
            System.out.println(player.getName() + " loses control mid-swing and wildly misses the attack!");
            return;
        }

        enemyPlayer.defend(player.getAttackPower() * 2,player); // Deal double damage

        if (levelDifference >= 5) {
            System.out.println(player.getName() + " towers over " + enemyPlayer.getName() + ", crushing them with ease.");
            System.out.println(player.getName() + " gains " + experienceGain + " experience points for the dominant strike.");
        } else if (levelDifference <= -5) {
            System.out.println(player.getName() + " defies the odds, striking a stronger foe with reckless abandon!");
            System.out.println(player.getName() + " gains " + experienceGain + " experience points for the daring assault.");
        } else {
            System.out.println(player.getName() + " lands a brutal blow and gains " + experienceGain + " experience points.");
        }

        player.gainExperience(experienceGain);
    }

    @Override
    public void defend(Player player, int damage, Player enemyPlayer) {
        // In BerserkState, take 2x damage
        int increasedDamage = (int)(damage * 2);
        System.out.println (player.getName() +" Is in Berserk Stance and takes double the damage: " + increasedDamage);
        player.takeDamage(increasedDamage);

    }

    @Override
    public String getName() {
        return "Berserker Stance";
    }


}