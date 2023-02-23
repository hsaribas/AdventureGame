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
            System.out.println("Areas\n1- Safe House\n2- Shop\n3- Cave\n4- Forest\n5- Desert\n0- Exit");
            System.out.print("Please pick one area you want to go to by typing it's number: ");
            int pickedLocation = scan.nextInt();
            switch (pickedLocation) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Shop(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new Desert(player);
                    break;
                default:
                    System.out.println("Please enter a valid number!");
                    break;
            }

            if (location == null) {
                System.out.println("See you again!");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("You Died\nGAME OVER!");
                break;
            }
        }
    }
}
