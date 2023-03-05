import java.util.Scanner;

public class Game {

    private Player player;
    private Location location;
    private final Scanner scan = new Scanner(System.in);

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
                System.out.println();
                System.out.println("See you again!");
                break;
            }
            if (!location.onLocation()) {
                System.out.println();
                System.out.println("GAME OVER!");
                break;
            }
        }
    }

    public void game(){
        System.out.println("====================");
        System.out.println("Areas:\n1- Safe House\n2- Shop\n3- Cave\n4- Forest\n5- Desert\n6- Swamp");
        System.out.print("Please pick one area you want to go to by typing its number: ");
        int pickedLocation = scan.nextInt();
        System.out.println("====================");
        switch (pickedLocation) {
            case 0:
                location = null;
                break;
            case 1:
                location = new SafeHouse(player);
                if (this.player.getInventory().getMaterialList().contains("Food") &&
                        this.player.getInventory().getMaterialList().contains("Wood") &&
                        this.player.getInventory().getMaterialList().contains("Water")) {
                    System.out.println("You collected all the materials.\n\n* * * Congratulations! * * *\n* * * You Won the Game * * *");
                }
                break;
            case 2:
                location = new Shop(player);
                break;
            case 3:
                if(this.player.getInventory().getMaterialList().contains("Food")){
                    System.out.println("You have already crossed this area and captured the material. You cannot re-enter the zone.");
                    game();
                }else{
                    location = new Cave(player);
                }
                break;
            case 4:
                if(this.player.getInventory().getMaterialList().contains("Wood")){
                    System.out.println("You have already crossed this area and captured the material. You cannot re-enter the zone.");
                    game();
                }else{
                    location = new Forest(player);
                }
                break;
            case 5:
                if(this.player.getInventory().getMaterialList().contains("Water")){
                    System.out.println("You have already crossed this area and captured the material. You cannot re-enter the zone.");
                    game();
                }else{
                    location = new Desert(player);
                }
                break;
            case 6:
                location = new Swamp(player);
                break;
            default:
                System.out.println("Please enter a valid number!");
                game();
                break;
        }
    }
}
