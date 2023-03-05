import java.util.Random;

public abstract class BattleLocation extends Location {

    private Monster monster;
    private String material;
    private int numMons;

    public BattleLocation(Player player, String location, Monster monster, String material, int numMons) {
        super(player, location);
        this.monster = monster;
        this.material = material;
        this.numMons = numMons;
    }

    @Override
    public boolean onLocation() {
        int count = randomMonsters();
        System.out.println("Now you are in " + this.getLocation() + ".");
        System.out.println("Hey! Are you ready to face to " + count + " of " + this.getMonster().getMonster() + "?");

        if (fight(count)) {
            System.out.println("You defeated all monsters!");
            return true;
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println();
            System.out.println("You are died...");
            return false;
        }
        return true;
    }

    public boolean fight(int count) {
        int num = count;
        for (int i = 1; i <= count; i++) {
            this.getMonster().setHealth(this.getMonster().getDefaultHealth());
            System.out.println("====================");

            if (this.getMonster().getMonster().equals("Crocodile")) {
                this.getMonster().setDamage(this.getMonster().randomDamage());
            }

            playerStats();
            System.out.println();
            monsterStats(i);
            System.out.println();

            int attack = firstAttack();
            if (attack == 1) {
                System.out.println("You will attack first!");
            } else {
                System.out.println(this.getMonster().getMonster() + " will attack first!");
            }

            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
                System.out.println("====================");
                System.out.print("Press 'F' to fight or press 'E' to escape: ");
                String choice = scan.nextLine().toUpperCase();
                if (choice.equals("F")) {
                    if (attack == 1) {
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
                    } else {
                        System.out.println();
                        int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (monsterDamage < 0) {
                            monsterDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                        currentHealth();
                        if (this.getPlayer().getHealth() > 0) {
                            this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
                            System.out.println();
                            currentHealth();
                        }
                    }
                } else {
                    return false;
                }
            }
            if (this.getMonster().getHealth() < this.getPlayer().getHealth()) {
                System.out.println();
                System.out.println("Great fight!");
                System.out.println(this.getMonster().getReward() + " gold earned.");
                this.getPlayer().setGold(this.getPlayer().getGold() + this.getMonster().getReward());
                num--;
                if (num == 0 && !this.getMonster().getMonster().equals("Crocodile")) {
                    System.out.println();
                    System.out.println("New material obtained! => " + this.getMaterial());
                    this.getPlayer().getInventory().setMaterialList(this.getMaterial());
                } else if (num == 0 && this.getMonster().getMonster().equals("Crocodile")) {
                    System.out.println();
                    randomReward();
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public void currentHealth() {
        System.out.println("Your health: " + this.getPlayer().getHealth());
        System.out.println(this.getMonster().getMonster() + "'s health: " + this.getMonster().getHealth());
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

    public void monsterStats(int i) {
        System.out.println("<< " + i + ". " + this.getMonster().getMonster() + "'s Stats >>");
        System.out.println("Damage: " + this.getMonster().getDamage() +
                " | Health: " + this.getMonster().getHealth() +
                " | Reward: " + this.getMonster().getReward());
    }

    public int randomMonsters() {
        Random r = new Random();
        return r.nextInt(this.getNumMons()) + 1;
    }

    public int firstAttack() {
        Random r = new Random();
        return r.nextInt(3);
    }

    public int randomNumber() {
        Random r = new Random();
        return r.nextInt(101);
    }

    public void randomReward() {
        int r = (int) (Math.random() * 100) + 1;
        int n = randomNumber();
        Weapon randomWeapon;
        Armor randomArmor;

        if (r > 0 && r <= 15) {
            if (n > 0 && n <= 20) {
                randomWeapon = Weapon.getWeaponById(3);
                if (this.getPlayer().getInventory().getWeapon().getDamage() < randomWeapon.getDamage()) {
                    this.getPlayer().getInventory().setWeapon(randomWeapon);
                    System.out.println("You earned a 'sword' for killing the creature.");
                }
            } else if (n > 20 && n <= 50) {
                randomWeapon = Weapon.getWeaponById(2);
                if (this.getPlayer().getInventory().getWeapon().getDamage() < randomWeapon.getDamage()) {
                    this.getPlayer().getInventory().setWeapon(randomWeapon);
                    System.out.println("You earned a 'arrow' for killing the creature.");
                }
            } else {
                randomWeapon = Weapon.getWeaponById(1);
                if (this.getPlayer().getInventory().getWeapon().getDamage() < randomWeapon.getDamage()) {
                    this.getPlayer().getInventory().setWeapon(randomWeapon);
                    System.out.println("You earned a 'spear' for killing the creature.");
                }
            }
        } else if (r > 15 && r <= 30) {
            if (n > 0 && n <= 20) {
                randomArmor = Armor.getArmorById(3);
                if (this.getPlayer().getInventory().getArmor().getBlock() < randomArmor.getBlock()) {
                    this.getPlayer().getInventory().setArmor(randomArmor);
                    System.out.println("You earned 'heavy armor' for killing the creature.");
                }
            } else if (n > 20 && n <= 50) {
                randomArmor = Armor.getArmorById(2);
                if (this.getPlayer().getInventory().getArmor().getBlock() < randomArmor.getBlock()) {
                    this.getPlayer().getInventory().setArmor(randomArmor);
                    System.out.println("You earned 'medium armor' for killing the creature.");
                }
            } else {
                randomArmor = Armor.getArmorById(1);
                if (this.getPlayer().getInventory().getArmor().getBlock() < randomArmor.getBlock()) {
                    this.getPlayer().getInventory().setArmor(randomArmor);
                    System.out.println("You earned 'light armor' for killing the creature.");
                }
            }
        } else if (r > 30 && r <= 55) {
            if (n > 0 && n <= 20) {
                this.getPlayer().setGold(this.getPlayer().getGold() + 10);
                System.out.println("You earned '10 gold' for killing the creature");
            } else if (n > 20 && n <= 50) {
                this.getPlayer().setGold(this.getPlayer().getGold() + 5);
                System.out.println("You earned '5 gold' for killing the creature");
            } else {
                this.getPlayer().setGold(this.getPlayer().getGold() + 1);
                System.out.println("You earned '1 gold' for killing the creature");
            }
        } else {
            System.out.println("Misfortune!\nYou failed to obtain item or gold.");
        }
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getNumMons() {
        return numMons;
    }

    public void setNumMons(int numMons) {
        this.numMons = numMons;
    }
}
