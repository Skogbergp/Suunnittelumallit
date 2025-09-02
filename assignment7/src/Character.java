
public class Character {
    private String name;
    private int maxHealth;
    private int currentHealth;
    private int level;
    private int experience;
    private State currentState;
    private int xpToNextLevel;

    public Character(String name) {
        this.name = name;
        this.maxHealth = 100;
        this.currentHealth = maxHealth;
        this.level = 1;
        this.experience = 0;
        this.xpToNextLevel = 100;
        this.currentState = new NoviceState();
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
    public int addHealth(int amount) {
        int potentialHealth = currentHealth + amount;
        if (potentialHealth > maxHealth) {
            int overFlow = potentialHealth - maxHealth;
            maxHealth += overFlow;
            currentHealth = maxHealth;
        } else {
            currentHealth = potentialHealth;
        }
        return currentHealth;
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
    public void checkLevelUp() {
        while (this.experience >= xpToNextLevel) {
            this.experience -= xpToNextLevel;
            level++;
            xpToNextLevel *= 1.1;
            System.out.println(name + " leveled up to level " + level + "!");
            this.currentState.advanceState(this);

        }
    }
    public void gainExperience(int exp) {
        this.experience += exp;
        checkLevelUp();
    }
    public void setCurrentState(State state) {
        this.currentState = state;
    }
    public void train() {
        if (currentState != null) {
            currentState.train(this);
        }
    }
    public void meditate(){
        if (currentState != null) {
            currentState.meditate(this);
        }
    }
    public void fight(){
        if (currentState != null) {
            currentState.fight(this);
        }
    }
    public void advanceState(){
        if (currentState != null) {
            currentState.advanceState(this);
        }    
    }
    public void printStatus() {
        System.out.println("Character: " + name);
        System.out.println("Level: " + level);
        System.out.println("Experience: " + experience + "/" + xpToNextLevel);
        System.out.println("Health: " + currentHealth + "/" + maxHealth);
        if (currentState != null) {
            System.out.println("Current State: " + currentState.getClass().getSimpleName());
        } else {
            System.out.println("Current State: None");
        }
        System.out.println("---------------------------");
    }

}
