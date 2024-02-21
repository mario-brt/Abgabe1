package edu.kit.informatik;

public class Memory {

    public final MemoryCell[] MEMORY_CELLS;
    private final int SIZE;

    public Memory(int memorySize) {

        this.MEMORY_CELLS = new MemoryCell[memorySize];
        this.SIZE = memorySize;
    }

    public int nextIndex(int currentIndex) {
        return (currentIndex + 1) % SIZE;
    }
}
