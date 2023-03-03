import java.util.HashSet;
import java.util.Set;

public class Inventory {

    private Weapon weapon;
    private Armor armor;
    private final Set<String> materialList = new HashSet<>();

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

    public Set<String> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(String material) {
        this.materialList.add(material);
    }
}
