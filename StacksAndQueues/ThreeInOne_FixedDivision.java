package StacksAndQueues;

import java.util.EmptyStackException;

class FixedMultiStack {
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public FixedMultiStack(int stackCapacity) {
        this.stackCapacity = stackCapacity;
        this.values = new int[numberOfStacks * stackCapacity];
        this.sizes = new int[numberOfStacks];
    }

    public void push(int stackNum, int value) throws StackOverflowError {
        if(isFull(stackNum)){
            throw new StackOverflowError();
        }
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    public int pop(int stackNum) {
        if(isEmpty(stackNum)){
            throw new EmptyStackException();
        }
        int value = values[indexOfTop(stackNum)];
        sizes[stackNum]--;
        return value;
    }

    public int peek(int stackNum) {
        if(isEmpty(stackNum)){
            throw new EmptyStackException();
        }
        return values[indexOfTop(stackNum)];
    }

    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    public boolean isFull(int stackNum) {
       return sizes[stackNum] == stackCapacity;
    }

    public int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }
}

public class ThreeInOne_FixedDivision {
    public static void main(String[] args) {
        FixedMultiStack multiStack = new FixedMultiStack(3);
        multiStack.push(0, 1);
        multiStack.push(0, 2);
        System.out.println(multiStack.peek(0));

        multiStack.push(2, 10);
        multiStack.push(2, 9);
        multiStack.push(2, 8);
        System.out.println(multiStack.pop(2));
    }
}
