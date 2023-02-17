import java.util.Scanner;

public class Game {

    private final Scanner scan = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to Jumanji!");
        System.out.print("Please enter a name: ");
        String playerName = scan.nextLine();
        Player player = new Player(playerName);
        System.out.println("==========");
        System.out.println("Let's get started " + player.getPlayerName() + "!");
        System.out.println("==========");
        player.selectHero();
    }
}
