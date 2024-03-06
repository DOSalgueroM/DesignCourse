package org.example.memoryallocation;

import java.util.List;

public class BestFitAlgorithm implements IAllocationAlgorithm {

    @Override
    public MemoryBlock getMemoryBlock(List<MemoryBlock> blocks, int size) {
        MemoryBlock bestFitBlock = null;

        for (MemoryBlock block : blocks) {
            if (block.isFree() && block.getSize() >= size) {
                if (bestFitBlock == null || block.getSize() < bestFitBlock.getSize()) {
                    bestFitBlock = block;
                }
            }
        }

        return bestFitBlock;
    }
}


