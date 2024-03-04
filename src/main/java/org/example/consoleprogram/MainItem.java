package org.example.consoleprogram;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ItemListManager itemListManager = new ItemListManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenuItems();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice.toLowerCase()) {
                case "1":
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();
                    itemListManager.addItem(itemName);
                    break;
                case "2":
                    System.out.print("Enter page size: ");
                    int pageSize = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    itemListManager.setPageSize(pageSize);
                    break;
                case "3":
                    itemListManager.displayPaginatedList();
                    break;
                case "4":
                    System.out.println("Pagination commands: first, last, next, prev, goto <page_number>, exit");
                    System.out.print("Enter pagination command: ");
                    String paginationCommand = scanner.nextLine();
                    itemListManager.handlePaginationCommand(paginationCommand);
                    break;
                case "5":
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }

    public static void printMenuItems() {
        System.out.println("--------------------------------");
        System.out.println("Choose an option");
        System.out.println("1. Add an item");
        System.out.println("2. Set page size");
        System.out.println("3. Display paginated list");
        System.out.println("4. Handle pagination command");
        System.out.println("5. Exit");
    }
}
