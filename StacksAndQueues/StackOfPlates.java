package StacksAndQueues;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

class SetOfStacks {
    private final int maxCapacity;
    private ArrayList<Stack<Integer>> stacks;

    SetOfStacks(int maxCapacity){
        this.maxCapacity = maxCapacity;
        this.stacks = new ArrayList<>();
    }

    public void push(int value) {
        Stack<Integer> stack = getLastStack() ;
        if(stack != null && stack.size() < maxCapacity){
            stack.push(value);
        }else{
            Stack<Integer> newStack = new Stack<>();
            newStack.push(value);
            stacks.add(newStack);
        }
    }

    public int pop() {
        Stack<Integer> stack = getLastStack();
        if(stack == null){
            throw new EmptyStackException();
        }else {
            int value = stack.pop();
            if(stack.isEmpty()){
                stacks.remove(stacks.size() - 1);
            }
            return value;
        }
    }

    public Stack<Integer> getLastStack(){
        if(stacks.size() == 0) return null;
        return stacks.get(stacks.size() - 1);
    }
}

public class StackOfPlates {
    public static void main(String[] args) {
        SetOfStacks stack = new SetOfStacks(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
    }
}
