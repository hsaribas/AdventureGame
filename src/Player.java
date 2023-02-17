import java.util.Scanner;

public class Player {

    private int damage;
    private int health;
    private int gold;
    private String hero;
    private String playerName;

    private final Scanner scan = new Scanner(System.in);

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public void selectHero() {
        Heroes[] heroList = {new Fighter(), new Archer(), new Knight()};
        for (Heroes h : heroList) {
            System.out.println("Hero: " + h.getHero() +
                    " | Id: " + h.getId() +
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
        System.out.println("You have picked " + this.getHero());
    }

    public void heroProps(Heroes heroes) {
        this.setDamage(heroes.getDamage());
        this.setHealth(heroes.getHealth());
        this.setGold(heroes.getGold());
        this.setHero(heroes.getHero());
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
}
