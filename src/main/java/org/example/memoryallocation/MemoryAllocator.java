package org.example.memoryallocation;


import java.util.ArrayList;
import java.util.List;

public class MemoryAllocator implements IMemoryAllocator {
    private int totalSize;
    private IAllocationAlgorithm algorithm;
    private List<MemoryBlock> blocks;

    public MemoryAllocator(int totalSize, IAllocationAlgorithm algorithm) {
        this.totalSize = totalSize;
        this.algorithm = algorithm;
        this.blocks = new ArrayList<MemoryBlock>();

        MemoryBlock block = new MemoryBlock();
        block.setSize(totalSize);
        blocks.add(block);
    }

    @Override
    public boolean Allocate(String objectName, int size) {
        MemoryBlock block = algorithm.getMemoryBlock(blocks, size);

        if (block == null) {
            return false;
        }

        MemoryBlock newBlock = new MemoryBlock();
        newBlock.setSize(size);
        newBlock.setObject(objectName);
        int idxBlock = blocks.indexOf(block);
        blocks.add(idxBlock, newBlock);

        block.setSize(block.getSize() - size);
        if (block.getSize() == 0) {
            blocks.remove(block);
        }
        return true;
    }

    @Override
    public boolean DeAllocate(String objectName) {
        /*for (MemoryBlock block : blocks) {
            if(block.getObject().equals(objectName)) {
                block.setObject(null);
                return true;
            }
        }
        return false;*/
        MemoryBlock block = SearchByName(objectName);
        if (block == null) {
            return false;
        }
        block.setObject(null);
        return true;


    }

    private MemoryBlock SearchByName(String objectName) {
        for (MemoryBlock block : blocks) {
            if (objectName.equals(block.getObject())) {
                return block;
            }
        }
        return null;
    }

    @Override
    public boolean IsEmpty() {
        return false;
    }

    @Override
    public boolean IsFull() {
        return false;
    }

    @Override
    public void ShowMemory() {
        for (MemoryBlock block : blocks) {
            System.out.println(block.getObject() + " " + block.getSize());
        }
    }
}
