public class Shop extends BaseLocation {

    public Shop(Player player) {
        super(player, "Shop");
    }

    @Override
    public boolean onLocation() {
        System.out.println();
        System.out.println("Welcome to Shop!\nPlease pick a number below to make a process... ");
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
                buyWeapon();
                break;
            case 2:
                showArmors();
                buyArmor();
                break;
            case 3:
                System.out.println("See you again!");
                return true;
        }
        return true;
    }

    public void showWeapons() {
        System.out.println("----> Weapons <----");
        for (Weapon w : Weapon.weapons()) {
            System.out.println("Weapon: " + w.getType() +
                    " | Id: " + w.getId() +
                    " | Damage: " + w.getDamage() +
                    " | Price: " + w.getPrice());
        }
    }

    public void buyWeapon() {
        System.out.print("Please pick a weapon: ");
        int selectWeapon = scan.nextInt();
        while (selectWeapon < 1 || selectWeapon > Weapon.weapons().length) {
            System.out.print("Invalid number, please try again: ");
            selectWeapon = scan.nextInt();
        }

        Weapon pickedWeapon = Weapon.getWeaponById(selectWeapon);
        if (pickedWeapon != null) {
            if (pickedWeapon.getPrice() > this.getPlayer().getGold()) {
                System.out.println("You do not have enough gold to buy this weapon.");
            } else {
                int balance = this.getPlayer().getGold() - pickedWeapon.getPrice();
                this.getPlayer().setGold(balance);
                System.out.println("Weapon successfully purchased. Your remaining gold is: " + this.getPlayer().getGold());
                //System.out.println("Your previous weapon is: " + this.getPlayer().getInventory().getWeapon().getType());
                this.getPlayer().getInventory().setWeapon(pickedWeapon);
                //System.out.println("Your current weapon is: " + this.getPlayer().getInventory().getWeapon().getType());
            }
        }
    }

    public void showArmors() {
        System.out.println("----> Armors <----");
        for (Armor a : Armor.armors()) {
            System.out.println("Armor: " + a.getType() +
                    " | Id: " + a.getId() +
                    " | Block: " + a.getBlock() +
                    " | Price: " + a.getPrice());
        }
    }

    public void buyArmor() {
        System.out.print("Please pick a weapon: ");
        int selectArmor = scan.nextInt();
        while (selectArmor < 1 || selectArmor > Armor.armors().length) {
            System.out.print("Invalid number, please try again: ");
            selectArmor = scan.nextInt();
        }

        Armor pickedArmor = Armor.getArmorById(selectArmor);
        if (pickedArmor != null) {
            if (pickedArmor.getPrice() > this.getPlayer().getGold()) {
                System.out.println("You do not have enough gold to buy this armor.");
            } else {
                int balance = this.getPlayer().getGold() - pickedArmor.getPrice();
                this.getPlayer().setGold(balance);
                System.out.println("Armor successfully purchased. Your remaining gold is: " + this.getPlayer().getGold());
                //System.out.println("Your previous weapon is: " + this.getPlayer().getInventory().getWeapon().getType());
                this.getPlayer().getInventory().setArmor(pickedArmor);
                //System.out.println("Your current weapon is: " + this.getPlayer().getInventory().getWeapon().getType());
            }
        }
    }
}
