package org.example.memoryallocation;

public class MenuAllocation {
    public MenuAllocation() {
    }
    public void printAlgorithms() {
        System.out.println("Choose the allocation algorithm:");
        System.out.println("1. First Fit");
        System.out.println("2. Best Fit");
        System.out.println("3. Worst Fit");
    }
    public void printMenu() {
        System.out.println("\n--- Memory Allocation Simulation ---");
        System.out.println("1. Allocate memory");
        System.out.println("2. Deallocate memory");
        System.out.println("3. Display memory status");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
}
