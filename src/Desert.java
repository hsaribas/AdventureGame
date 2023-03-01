public class Desert extends BattleLocation{

    public Desert(Player player) {
        super(player, "Desert", new Spider(), Material.getMaterialById(2), 3);
    }
}
