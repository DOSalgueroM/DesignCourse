package org.example.memoryallocation;

public class Main {
    public static void main(String[] args) {
        IMemoryAllocator allocator=new MemoryAllocator(1000,new FirstFitAlgorithm());

        allocator.Allocate("A",50);
        allocator.Allocate("B",150);
        allocator.Allocate("C",250);
        allocator.Allocate("D",350);

        allocator.ShowMemory();

        allocator.DeAllocate("C");
        allocator.Allocate("E",60);

        allocator.ShowMemory();

    }
}
