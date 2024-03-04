package org.example.memoryallocation;

import java.util.List;

public class FirstFitAlgorithm implements IAllocationAlgorithm{
    @Override
    public MemoryBlock getMemoryBlock(List<MemoryBlock> blocks, int size) {
        //MemoryBlock result = null;
        for (MemoryBlock block : blocks) {
            if (block.isFree() && block.getSize() >= size) {
                return block;
            }
        }

        return null;
    }
}
