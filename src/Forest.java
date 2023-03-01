public class Forest extends BattleLocation{

    public Forest(Player player) {
        super(player, "Forest", new Zombie(), Material.getMaterialById(1), 4);
    }
}
