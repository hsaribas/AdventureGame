import java.util.Scanner;

public class Player {

    private String hero;
    private int damage;
    private int health;
    private int gold;
    private String playerName;
    private Inventory inventory;

    private final Scanner scan = new Scanner(System.in);

    public Player(String playerName) {
        this.playerName = playerName;
        this.inventory = new Inventory();
    }

    public void selectHero() {
        Hero[] heroList = {new Fighter(), new Archer(), new Knight()};
        for (Hero h : heroList) {
            System.out.println("Id: " + h.getId() +
                    " | Hero: " + h.getHero() +
                    " | Damage: " + h.getDamage() +
                    " | Health: " + h.getHealth() +
                    " | Gold: " + h.getGold());
        }
        System.out.println("==========");

        System.out.print("Please enter the id of the hero you want to pick: ");
        int pickedHero = scan.nextInt();
        switch (pickedHero) {
            case 1:
                heroProps(new Fighter());
                break;
            case 2:
                heroProps(new Archer());
                break;
            case 3:
                heroProps(new Knight());
                break;
            default:
                System.out.println("Please enter a valid number!");
                selectHero();
                break;
        }
        System.out.println("==========");
        System.out.println("You have picked => " + this.getHero());
    }

    public void heroProps(Hero hero) {
        this.setHero(hero.getHero());
        this.setDamage(hero.getDamage());
        this.setHealth(hero.getHealth());
        this.setGold(hero.getGold());
    }

    public void showInfo() {
        System.out.println("Weapon: " + this.getInventory().getWeapon().getType() +
                " | Armor: " + this.getInventory().getArmor().getType() +
                " | Block: " + this.getInventory().getArmor().getBlock() +
                " | Damage: " + this.getTotalDamage() +
                " | Health: " + this.getHealth() +
                " | Gold: " + this.getGold());
    }

    public int getTotalDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
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

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public String getHero() {
        return hero;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
