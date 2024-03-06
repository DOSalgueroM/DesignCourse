package org.example.memoryallocation;

import java.util.List;

public class WorstFitAlgorithm implements IAllocationAlgorithm {
    @Override
    public MemoryBlock getMemoryBlock(List<MemoryBlock> blocks, int size) {
        MemoryBlock worstFitBlock = null;

        for (MemoryBlock block : blocks) {
            if (block.isFree() && block.getSize() >= size) {
                if (worstFitBlock == null || block.getSize() > worstFitBlock.getSize()) {
                    worstFitBlock = block;
                }
            }
        }

        return worstFitBlock;
    }
}
