public class Weapons {

    private String type;
    private int id;
    private int damage;
    private int price;

    public Weapons(String type, int id, int damage, int price){
        this.type = type;
        this.id = id;
        this.damage = damage;
        this.price = price;
    }

    public static Weapons[] weapons(){
        Weapons[] weaponList = new Weapons[3];
        weaponList[0] = new Weapons("Spear", 1, 2, 25);
        weaponList[1] = new Weapons("Arrow", 2, 3, 35);
        weaponList[2] = new Weapons("Sword", 3, 7, 45);

        return weaponList;
    }

    public static Weapons getWeaponById(int id){
        for(Weapons w : Weapons.weapons()){
            if(w.getId() == id){
                return w;
            }
        }
        return null;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
