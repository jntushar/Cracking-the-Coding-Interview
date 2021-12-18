package StacksAndQueues;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(1);
        stack.push(3);
        stack.push(4);
        stack.push(2);
        Stack<Integer> sorted = sort(stack);
        System.out.println(sorted);
    }

    public static Stack<Integer> sort(Stack<Integer> stack){
        Stack<Integer> newStack = new Stack<>();
        while(!stack.isEmpty()){
            int tmp = stack.pop();
            while(!newStack.isEmpty() && newStack.peek() > tmp){
                stack.push(newStack.pop());
            }
            newStack.push(tmp);
        }
        while(!newStack.isEmpty()) stack.push(newStack.pop());
        return stack;
    }
}
