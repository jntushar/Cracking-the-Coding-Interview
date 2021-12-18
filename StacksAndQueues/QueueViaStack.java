package StacksAndQueues;

import java.util.Stack;

class MyQueue {
    private Stack<Integer> stackNewest, stackOldest;

    public MyQueue(){
        this.stackNewest = new Stack<>();
        this.stackOldest = new Stack<>();
    }

    public int size(){
        return stackNewest.size() + stackOldest.size();
    }

    public void add(int value){
        stackNewest.push(value);
    }

    private void shiftStack() {
        if(stackOldest.empty()){
            while(!stackNewest.isEmpty()){
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public int remove(){
        shiftStack();
        return stackOldest.pop();
    }

    public int peek(){
        shiftStack();
        return stackOldest.peek();
    }
}

public class QueueViaStack {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.remove());
        System.out.println(queue.remove());

    }
}
