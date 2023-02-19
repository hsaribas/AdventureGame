public class Armor {

    private String type;
    private int id;
    private int block;
    private int price;

    public Armor(String type, int id, int block, int price) {
        this.type = type;
        this.id = id;
        this.block = block;
        this.price = price;
    }

    public static Armor[] armors(){
        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor("Light", 1, 1, 15);
        armorList[1] = new Armor("Medium", 2, 3, 25);
        armorList[2] = new Armor("Heavy", 3, 5, 40);

        return armorList;
    }

    public static Armor getArmorById(int id){
        for(Armor a : Armor.armors()){
            if(a.getId() == id){
                return a;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
