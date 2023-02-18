import java.util.Scanner;

public abstract class Location {

    private Player player;
    private String location;

    public static Scanner scan = new Scanner(System.in);

    public Location(Player player, String location){
        this.player = player;
        this.location = location;
    }

    public abstract boolean onLocation();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
