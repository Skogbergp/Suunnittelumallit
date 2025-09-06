package player;

public class Player {
    private final String name;
    private int maxHealth;
    private int currentHealth;
    private int level;
    private int experience;
    private State currentState;
    private int xpToNextLevel;
    private int attackPower;
    private int playersDefeated;

    public Player(String name) {
        this.name = name;
        this.maxHealth = 100;
        this.currentHealth = maxHealth;
        this.level = 1;
        this.experience = 0;
        this.xpToNextLevel = 100;
        this.currentState = new NormalState();
        this.attackPower = 10; // Initial attack power
    }

    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void addHealth(int amount) {
        int potentialHealth = currentHealth + amount;
        if (potentialHealth > maxHealth) {

            int overFlow = potentialHealth - maxHealth;
            System.out.println(name + " health overflowed by " + overFlow + " points! Increasing max health.");
            maxHealth += overFlow;
            currentHealth = maxHealth;
            System.out.println(name + " new max health: " + maxHealth);
        } else {
            currentHealth = potentialHealth;
            System.out.println(name + " restored health to " + currentHealth + "/" + maxHealth);
        }
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State state) {
        this.currentState = state;
    }

    public void checkLevelUp() {
        while (this.experience >= xpToNextLevel) {
            this.experience -= xpToNextLevel;
            level++;
            xpToNextLevel *= 1.1;
            attackPower += 5; // Increase attack power on level up
            System.out.println(name + " leveled up to level " + level + "!");
            System.out.println(name + "'s attack power increased to " + attackPower);
            System.out.println(name + "'s XP to next level: " + xpToNextLevel);
            System.out.println("---------------------------");
        }
    }

    public void gainExperience(int exp) {
        this.experience += exp;
        checkLevelUp();
    }

    public void train() {
        if (currentState != null) {
            currentState.train(this);
        }
    }

    public void meditate() {
        if (currentState != null) {
            currentState.meditate(this);
        }
    }

    public void fight(Player opponent) {
        if (currentState != null) {
            currentState.fight(this, opponent);
        }
    }

    public void takeDamage(int damage) {
        currentHealth -= damage;
        if (currentHealth < 0) {
            currentHealth = 0;
        }
    }

    public void printStatus() {
        System.out.println("Character: " + name);
        System.out.println("Level: " + level);
        System.out.println("Experience: " + experience + "/" + xpToNextLevel);
        System.out.println("Health: " + currentHealth + "/" + maxHealth);
        System.out.println("Attack Power: " + attackPower);
        if (currentState != null) {
            System.out.println("Current State: " + currentState.getClass().getSimpleName());
        } else {
            System.out.println("Current State: None");
        }
        System.out.println("Players Defeated: " + playersDefeated);
        System.out.println("---------------------------");
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void defend(int damage, Player enemyPlayer) {
        if (currentState != null) {
            currentState.defend(this, damage, enemyPlayer);
        }
    }

    public int getPlayersDefeated() {
        return playersDefeated;
    }

    public void incrementPlayersDefeated() {
        playersDefeated++;
    }
}
