
package org.example.memory;

import java.util.Scanner;

public class MemoryAllocationSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the initial size of memory: ");
        int initialSize = scanner.nextInt();

        MemoryManager memoryManager = new MemoryManager(initialSize);

        while (true) {
            System.out.println("\n--- Memory Allocation Simulation ---");
            System.out.println("1. Allocate memory");
            System.out.println("2. Deallocate memory");
            System.out.println("3. Display memory status");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the size of memory to allocate: ");
                    int size = scanner.nextInt();
                    System.out.print("Enter the allocation algorithm (first-fit, best-fit, worst-fit): ");
                    String algorithm = scanner.next();
                    memoryManager.allocateMemory(size, algorithm);
                    break;
                case 2:
                    System.out.print("Enter the start address of the memory to deallocate: ");
                    int startAddress = scanner.nextInt();
                    memoryManager.deallocateMemory(startAddress);
                    break;
                case 3:
                    memoryManager.displayMemoryStatus();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

