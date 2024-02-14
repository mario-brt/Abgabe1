package edu.student.kit;

public class Memory {

    public final MemoryCell[] MEMORY_CELLS;

    public Memory(int memorySize) {
        this.MEMORY_CELLS = new MemoryCell[memorySize];
    }
}
