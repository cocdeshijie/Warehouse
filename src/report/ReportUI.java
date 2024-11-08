package report;

import java.util.Scanner;

public class ReportUI {
    private ReportManager reportManager;
    private Scanner scanner;

    public ReportUI(ReportManager reportManager, Scanner scanner) {
        this.reportManager = reportManager;
        this.scanner = scanner;
    }

    public void reportMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("===== Reports Menu =====");
            System.out.println("1. Renting Checkouts");
            System.out.println("2. Popular Item");
            System.out.println("3. Popular Manufacturer");
            System.out.println("4. Popular Drone");
            System.out.println("5. Member with Most Items Checked Out");
            System.out.println("6. Equipment by Type Released Before Year");
            System.out.println("7. Back to Main Menu");
            System.out.print("Please choose an option: ");
            String input = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                continue;
            }

            switch (choice) {
                case 1:
                    rentalCheckoutsReport();
                    break;
                case 2:
                    popularItemReport();
                    break;
                case 3:
                    popularManufacturerReport();
                    break;
                case 4:
                    popularDroneReport();
                    break;
                case 5:
                    memberWithMostItemsReport();
                    break;
                case 6:
                    equipmentByTypeBeforeYearReport();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
            System.out.println();
        }
    }

    private void rentalCheckoutsReport() {
        System.out.print("Enter Member ID: ");
        String memberId = scanner.nextLine();
        reportManager.getTotalRentalsByMember(memberId);
    }

    private void popularItemReport() {
        reportManager.getMostPopularItem();
    }

    private void popularManufacturerReport() {
        reportManager.getMostFrequentManufacturer();
    }

    private void popularDroneReport() {
        reportManager.getMostUsedDrone();
    }

    private void memberWithMostItemsReport() {
        reportManager.getMemberWithMostRentals();
    }

    private void equipmentByTypeBeforeYearReport() {
        System.out.print("Enter Equipment Type: ");
        String type = scanner.nextLine();
        System.out.print("Enter Year: ");
        int year;
        try {
            year = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid year.");
            return;
        }
        reportManager.getEquipmentByTypeBeforeYear(type, year);
    }
}
