public class Shop extends BaseLocation {

    public Shop(Player player) {
        super(player, "Shop");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to Shop!\nPlease pick a number below to make a process");
        System.out.println("1- Weapons\n2- Armors\n3- Exit");
        System.out.print("Your choice: ");
        int choice = scan.nextInt();

        while (choice < 1 || choice > 3) {
            System.out.print("Invalid number, please try again: ");
            choice = scan.nextInt();
        }
        switch (choice) {
            case 1:
                showWeapons();
                break;
            case 2:
                showArmors();
                break;
            case 3:
                System.out.println("See you again!");
                return true;
        }
        return true;
    }

    public void showWeapons() {
        System.out.println("----> Weapons <----");
        for (Weapons w : Weapons.weapons()) {
            System.out.println("Weapon: " + w.getType() +
                    " | Id: " + w.getId() +
                    " | Damage: " + w.getDamage() +
                    " | Price: " + w.getPrice());
        }

        System.out.print("Please pick a weapon");
        int selectWeapon = scan.nextInt();
        while (selectWeapon < 1 || selectWeapon > Weapons.weapons().length) {
            System.out.print("Invalid number, please try again: ");
            selectWeapon = scan.nextInt();
        }

        Weapons pickWeapon = Weapons.getWeaponById(selectWeapon);
    }

    public void showArmors() {
        System.out.println("----> Armors <----");

    }
}
