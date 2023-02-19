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
        Location location = null;

        while (true) {
            System.out.println();
            player.showInfo();
            System.out.println("==========");
            System.out.println("Areas\n1- Safe House\n2- Shop");
            System.out.print("Please pick one area you want to go by typing it's number: ");
            int pickedLocation = scan.nextInt();
            switch (pickedLocation) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Shop(player);
                    break;
                default:
                    location = new SafeHouse(player);
                    break;
            }

            if (!location.onLocation()) {
                System.out.println("You Died\nGAME OVER!");
                break;
            }
        }
    }
}
