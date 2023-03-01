public class Cave extends BattleLocation{

    public Cave(Player player) {
        super(player, "Cave", new Bear(), Material.getMaterialById(3), 2);
    }
}
