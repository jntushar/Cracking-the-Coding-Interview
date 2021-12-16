package StacksAndQueues;

import java.util.Stack;

public class StackMin extends Stack<Integer> {
    Stack<Integer> minStack;

    public StackMin(){
        this.minStack = new Stack<Integer>();
    }

    public void push(int value){
        if(value <= min()){
            minStack.push(value);
        }
        super.push(value);
    }

    public Integer pop(){
        int value = super.pop();
        if(value == min()){
            minStack.pop();
        }
        return value;
    }

    public Integer peek(){
        return super.peek();
    }

    public Integer min(){
        if(minStack.isEmpty()){
            return Integer.MAX_VALUE;
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        StackMin stack = new StackMin();
        stack.push(4);
        stack.push(5);
        stack.push(1);
        stack.push(7);
        System.out.println(stack.min());
    }
}
