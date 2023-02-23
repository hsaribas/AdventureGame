public class Monster {

    private int id;
    private String name;
    private int damage;
    private int health;
    private int reward;

    public Monster(int id, String name, int damage, int health, int reward) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.reward = reward;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }
}
