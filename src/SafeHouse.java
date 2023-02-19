public class SafeHouse extends BaseLocation{

    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println();
        System.out.println("Welcome to Safe House!\nYour health is renewed...");
        return true;
    }
}
