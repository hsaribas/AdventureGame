import java.util.Locale;
import java.util.Random;

public abstract class BattleLocation extends Location {

    private Monster monster;
    private String reward;
    private int numMons;

    public BattleLocation(Player player, String location, Monster monster, String reward, int numMons) {
        super(player, location);
        this.monster = monster;
        this.reward = reward;
        this.numMons = numMons;
    }

    @Override
    public boolean onLocation() {
        int count = randomMonsters();
        System.out.println("Now you are in the " + this.getLocation());
        System.out.println("Hey! Are you ready to face to " + count + " of " + this.getMonster().getName());
        System.out.print("If you want to fight type F or if you want to escape type E -> ");
        String decision = scan.nextLine();
        decision = decision.toUpperCase();
        if(decision.equals("S")){
            System.out.println("War begins");
        }
        return true;
    }

    public int randomMonsters() {
        Random r = new Random();
        return r.nextInt(this.getNumMons()) + 1;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public int getNumMons() {
        return numMons;
    }

    public void setNumMons(int numMons) {
        this.numMons = numMons;
    }
}
