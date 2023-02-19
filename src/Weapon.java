public class Weapon {

    private String type;
    private int id;
    private int damage;
    private int price;

    public Weapon(String type, int id, int damage, int price){
        this.type = type;
        this.id = id;
        this.damage = damage;
        this.price = price;
    }

    public static Weapon[] weapons(){
        Weapon[] weaponList = new Weapon[3];
        weaponList[0] = new Weapon("Spear", 1, 4, 15);
        weaponList[1] = new Weapon("Arrow", 2, 3, 10);
        weaponList[2] = new Weapon("Sword", 3, 7, 25);

        return weaponList;
    }

    public static Weapon getWeaponById(int id){
        for(Weapon w : Weapon.weapons()){
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
