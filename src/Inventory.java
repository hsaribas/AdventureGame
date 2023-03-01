import java.util.List;

public class Inventory {

    private Weapon weapon;
    private Armor armor;
    private List<Material> materialList;

    public Inventory() {
        this.weapon = new Weapon("Punch", -1, 0, 0);
        this.armor = new Armor("Unarmored", -1, 0, 0);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public List<Material> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(Material material) {
        this.materialList.add(material);
    }
}
