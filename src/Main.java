import customer.CustomerManager;
import customer.CustomerUI;
import warehouse.WarehouseManager;
import warehouse.WarehouseUI;
import equipment.EquipmentManager;
import equipment.EquipmentUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomerManager customerManager = new CustomerManager();
        WarehouseManager warehouseManager = new WarehouseManager();
        EquipmentManager equipmentManager = new EquipmentManager();
        Scanner scanner = new Scanner(System.in);

        CustomerUI customerUI = new CustomerUI(customerManager, scanner);
        WarehouseUI warehouseUI = new WarehouseUI(warehouseManager, scanner);
        EquipmentUI equipmentUI = new EquipmentUI(equipmentManager, scanner);

        while (true) {
            System.out.println("===== Warehouse Management System =====");
            System.out.println("1. Customer");
            System.out.println("2. Warehouse");
            System.out.println("3. Review (TODO)");
            System.out.println("4. Rental (TODO)");
            System.out.println("5. Storage (TODO)");
            System.out.println("6. Equipment");
            System.out.println("7. Drone (TODO)");
            System.out.println("8. Delivery Log (TODO)");
            System.out.println("9. Maintenance Record (TODO)");
            System.out.println("10. Order (TODO)");
            System.out.println("11. Inventory (TODO)");
            System.out.println("12. Exit");
            System.out.print("Please select an option for its sub menus (1-11): ");
            String input = scanner.nextLine();
            int entityChoice;
            try {
                entityChoice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                continue;
            }

            switch (entityChoice) {
                case 1:
                    customerUI.customerMenu();
                    break;
                case 2:
                    warehouseUI.warehouseMenu();
                    break;
                case 3:
                case 4:
                case 5:
                    System.out.println("Placeholder");
                    break;
                case 6:
                    equipmentUI.equipmentMenu();
                    break;
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                    System.out.println("Placeholder");
                    break;
                case 12:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
            System.out.println();
        }
    }
}
