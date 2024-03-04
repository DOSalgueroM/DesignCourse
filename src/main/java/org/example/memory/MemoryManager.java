package org.example.memory;

import java.util.ArrayList;
import java.util.List;

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
