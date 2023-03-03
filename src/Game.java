import java.util.Scanner;

public class Game {

    private final Scanner scan = new Scanner(System.in);
    private Player player;
    private Location location;

    public void start() {
        System.out.println("Welcome to Jumanji!");
        System.out.print("Please enter a name: ");
        String playerName = scan.nextLine();
        player = new Player(playerName);
        System.out.println("====================");
        System.out.println("Let's get started " + player.getPlayerName() + "!");
        System.out.println("====================");
        player.selectHero();

        location = null;

        while (true) {
            System.out.println();
            player.showInfo();
            game();

            if (location == null) {
                System.out.println("====================");
                System.out.println("See you again!");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("====================");
                System.out.println("GAME OVER!");
                break;
            }
        }
    }

    public void game(){
        System.out.println("====================");
        System.out.println("Areas:\n1- Safe House\n2- Shop\n3- Cave\n4- Forest\n5- Desert");
        System.out.print("Please pick one area you want to go to by typing its number: ");
        int pickedLocation = scan.nextInt();
        System.out.println("====================");
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
                game();
                break;
        }
    }
}
