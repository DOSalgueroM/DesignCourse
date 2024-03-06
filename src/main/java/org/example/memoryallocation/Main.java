package org.example.memoryallocation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuAllocation menuAllocation = new MenuAllocation();
        IMemoryAllocator allocator = null; // Declare the variable outside the switch statement

        System.out.println("Choose the total memory size: ");
        int totalMemorySize = scanner.nextInt();
        menuAllocation.printAlgorithms();

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                allocator = new MemoryAllocator(totalMemorySize, new FirstFitAlgorithm());
                break;
            case 2:
                allocator = new MemoryAllocator(totalMemorySize, new BestFitAlgorithm());
                break;
            case 3:
                allocator = new MemoryAllocator(totalMemorySize, new WorstFitAlgorithm());
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                System.exit(0);
        }

        while (true) {
            menuAllocation.printMenu();
            int choice2 = scanner.nextInt();
            switch (choice2) {
                case 1:
                    System.out.print("Enter the size of memory to allocate: ");
                    int size = scanner.nextInt();
                    System.out.print("Enter the process name: ");
                    String processName = scanner.next();
                    allocator.Allocate(processName, size);
                    break;
                case 2:
                    System.out.print("Enter the process name: ");
                    String processName2 = scanner.next();
                    allocator.DeAllocate(processName2);
                    break;
                case 3:
                    allocator.ShowMemory();
                    break;
                case 4:
                    System.exit(0); // Exit the program
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        // Add a semicolon to the end of the do-while loop

    }

}


