public class Material {

    private String type;
    private int id;

    public Material(String type, int id) {
        this.type = type;
        this.id = id;
    }

    public static Material[] materials(){
        Material[] matList = new Material[3];
        matList[0] = new Material("Wood", 1);
        matList[1] = new Material("Water", 2);
        matList[2] = new Material("Food", 3);

        return matList;
    }

    public static Material getMaterialById(int id){
        for(Material n : Material.materials()){
            if(n.getId() == id){
                return n;
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
}
