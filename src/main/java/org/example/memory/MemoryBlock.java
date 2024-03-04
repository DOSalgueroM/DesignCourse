package org.example.memory;

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
