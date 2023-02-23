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
        String decision = scan.nextLine().toUpperCase();
        if (decision.equals("F")) {
            if (fight(count)) {
                System.out.println("You defeated all monsters!");
                return true;
            }
        }
        if(this.getPlayer().getHealth() < 0){
            System.out.println("You are dead!");
            return false;
        }
        return true;
    }

    public boolean fight(int count) {
        for (int i = 1; i <= count; i++) {
            System.out.println();
            playerStats();
            System.out.println();
            monsterStats();
            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
                System.out.print("Press F for Fight or press E for Escape: ");
                String choice = scan.nextLine().toUpperCase();
                if (choice.equals("F")) {
                    this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
                    System.out.println();
                    currentHealth();
                    if (this.getMonster().getHealth() > 0) {
                        System.out.println();
                        int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (monsterDamage < 0) {
                            monsterDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                        currentHealth();
                    }
                }
            }
        }
        return false;
    }

    public void currentHealth() {
        System.out.println("Your Health: " + this.getPlayer().getHealth());
        System.out.println(this.getMonster().getName() + "'s Health: " + this.getMonster().getHealth());
    }

    public void playerStats() {
        System.out.println("<< Player " + this.getPlayer().getPlayerName() + "'s Stats >>");
        System.out.println("Weapon: " + this.getPlayer().getInventory().getWeapon().getType() +
                " | Damage: " + this.getPlayer().getTotalDamage() +
                " | Armor: " + this.getPlayer().getInventory().getArmor().getType() +
                " | Block: " + this.getPlayer().getInventory().getArmor().getBlock() +
                " | Health: " + this.getPlayer().getHealth() +
                " | Gold: " + this.getPlayer().getGold());
    }

    public void monsterStats() {
        System.out.println("<< " + this.getMonster().getName() + "'s Stats >>");
        System.out.println("Damage: " + this.getMonster().getDamage() +
                " | Health: " + this.getMonster().getHealth() +
                " | Reward: " + this.getMonster().getReward());
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
