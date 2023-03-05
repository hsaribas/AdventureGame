import java.util.Random;

public class Monster {

    private int id;
    private String monster;
    private int damage;
    private int health;
    private int reward;
    private int defaultHealth;

    public Monster(int id, String monster, int damage, int health, int reward) {
        this.id = id;
        this.monster = monster;
        this.damage = damage;
        this.health = health;
        this.reward = reward;
        this.defaultHealth = health;
    }

    public int random(){
        Random r = new Random();
        return r.nextInt(this.getDamage()) + 1;
    }

    public int randomDamage(){
        int ranDam = random();
        if(ranDam < 3){
            ranDam = 3;
        }else if(ranDam > 6){
            ranDam = 6;
        }
        return ranDam;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMonster() {
        return monster;
    }

    public void setMonster(String monster) {
        this.monster = monster;
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
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }
}
