public abstract class BaseLocation extends Location{

    public BaseLocation(Player player, String location) {
        super(player, location);
    }

    @Override
    public boolean onLocation() {
        return true;
    }
}
