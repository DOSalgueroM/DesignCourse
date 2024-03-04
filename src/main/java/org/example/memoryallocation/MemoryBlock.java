package org.example.memoryallocation;

public class MemoryBlock {
    private int size;
    private String object;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }
    public boolean isFree() {
        return object == null;
    }
}
