package org.example.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MemoryBlock {
    private int startAddress;
    private int size;
    private boolean occupied;

    public MemoryBlock(int startAddress, int size, boolean occupied) {
        this.startAddress = startAddress;
        this.size = size;
        this.occupied = occupied;
    }

    // Getters and setters

    public int getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(int startAddress) {
        this.startAddress = startAddress;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}

class MemoryManager {
    private List<MemoryBlock> memoryBlocks;

    public MemoryManager(int initialSize) {
        memoryBlocks = new ArrayList<>();
        memoryBlocks.add(new MemoryBlock(0, initialSize, false));
    }

    public void allocateMemory(int size, String algorithm) {
        // Implement the memory allocation algorithm based on the chosen algorithm parameter
        MemoryBlock allocatedBlock = null;

        if (algorithm.equalsIgnoreCase("first-fit")) {
            allocatedBlock = allocateFirstFit(size);
        } else if (algorithm.equalsIgnoreCase("best-fit")) {
            allocatedBlock = allocateBestFit(size);
        } else if (algorithm.equalsIgnoreCase("worst-fit")) {
            allocatedBlock = allocateWorstFit(size);
        } else {
            System.out.println("Invalid allocation algorithm. Please try again.");
            return;
        }

        if (allocatedBlock != null) {
            System.out.println("Memory allocated successfully. Start address: " + allocatedBlock.getStartAddress());
        } else {
            System.out.println("Memory allocation failed. Not enough free space available.");
        }
    }

    private MemoryBlock allocateFirstFit(int size) {
        for (MemoryBlock block : memoryBlocks) {
            if (!block.isOccupied() && block.getSize() >= size) {
                MemoryBlock allocatedBlock = new MemoryBlock(block.getStartAddress(), size, true);
                block.setStartAddress(block.getStartAddress() + size);
                block.setSize(block.getSize() - size);
                memoryBlocks.add(memoryBlocks.indexOf(block), allocatedBlock);
                return allocatedBlock;
            }
        }
        return null;
    }

    private MemoryBlock allocateBestFit(int size) {
        MemoryBlock bestFitBlock = null;

        for (MemoryBlock block : memoryBlocks) {
            if (!block.isOccupied() && block.getSize() >= size) {
                if (bestFitBlock == null || block.getSize() < bestFitBlock.getSize()) {
                    bestFitBlock = block;
                }
            }
        }

        if (bestFitBlock != null) {
            MemoryBlock allocatedBlock = new MemoryBlock(bestFitBlock.getStartAddress(), size, true);
            bestFitBlock.setStartAddress(bestFitBlock.getStartAddress() + size);
            bestFitBlock.setSize(bestFitBlock.getSize() - size);
            memoryBlocks.add(memoryBlocks.indexOf(bestFitBlock), allocatedBlock);
            return allocatedBlock;
        }

        return null;
    }

    private MemoryBlock allocateWorstFit(int size) {
        MemoryBlock worstFitBlock = null;

        for (MemoryBlock block : memoryBlocks) {
            if (!block.isOccupied() && block.getSize() >= size) {
                if (worstFitBlock == null || block.getSize() > worstFitBlock.getSize()) {
                    worstFitBlock = block;
                }
            }
        }

        if (worstFitBlock != null) {
            MemoryBlock allocatedBlock = new MemoryBlock(worstFitBlock.getStartAddress(), size, true);
            worstFitBlock.setStartAddress(worstFitBlock.getStartAddress() + size);
            worstFitBlock.setSize(worstFitBlock.getSize() - size);
            memoryBlocks.add(memoryBlocks.indexOf(worstFitBlock), allocatedBlock);
            return allocatedBlock;
        }

        return null;
    }

    public void deallocateMemory(int startAddress) {
        MemoryBlock deallocatedBlock = null;

        for (MemoryBlock block : memoryBlocks) {
            if (block.getStartAddress() == startAddress && block.isOccupied()) {
                deallocatedBlock = block;
                block.setOccupied(false);
                break;
            }
        }

        if (deallocatedBlock != null) {
            mergeAdjacentBlocks();
            System.out.println("Memory block at start address " + startAddress + " deallocated successfully.");
        } else {
            System.out.println("Memory deallocation failed. No occupied block found at start address " + startAddress);
        }
    }

    private void mergeAdjacentBlocks() {
        for (int i = 0; i < memoryBlocks.size() - 1; i++) {
            MemoryBlock currentBlock = memoryBlocks.get(i);
            MemoryBlock nextBlock = memoryBlocks.get(i + 1);

            if (!currentBlock.isOccupied() && !nextBlock.isOccupied()) {
                currentBlock.setSize(currentBlock.getSize() + nextBlock.getSize());
                memoryBlocks.remove(i + 1);
                i--;
            }
        }
    }

    public void displayMemoryStatus() {
        System.out.println("Memory Status:");
        System.out.println("--------------");

        for (MemoryBlock block : memoryBlocks) {
            System.out.println("Start Address: " + block.getStartAddress() + " | Size: " + block.getSize() + " | Occupied: " + block.isOccupied());
        }
    }
}

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
