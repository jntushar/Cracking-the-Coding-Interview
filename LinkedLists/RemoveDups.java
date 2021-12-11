package LinkedLists;

import java.util.HashMap;
import java.util.Map;

class Node {
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
    
    Node(){}
}

class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public int size(){
        return this.size;
    }

    public Node head(){
        return this.head;
    }

    public Node tail(){
        return this.tail;
    }

    public void addFirst(int val){
        Node temp = new Node(val);
        if(size() == 0){
            head = tail = temp;
        }else{
            temp.next = head;
            head = temp;
        }
        size++;
    }

    public void addLast(int val){
        Node temp = new Node(val);
        if(size() == 0){
            head = tail = temp;
        }else{
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    public void display(){
        if(size() == 0){
            System.out.println("List is empty!");
        }else{
            for(Node temp = head; temp!=null; temp = temp.next){
                System.out.print(temp.data + ", ");
            }
        }
    }
}

public class RemoveDups {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.display();
        linkedList.addFirst(3);
        linkedList.addLast(2);
        linkedList.addFirst(9);
        linkedList.addFirst(4);
        linkedList.addLast(4);
        linkedList.addLast(3);
        linkedList.addLast(5);
        linkedList.addFirst(9);
        linkedList.display();

        removeDuplicates(linkedList);
        System.out.print("\nRemoved Duplicates: ");
        linkedList.display();
    }

    public static void removeDuplicates(LinkedList linkedList){
        Map<Integer, Boolean> map = new HashMap<>();
        Node prev = linkedList.head();
        map.put(linkedList.head().data, true);
        for(Node temp = linkedList.head().next; temp!=null; temp = temp.next){
            if(map.containsKey(temp.data)){
                prev.next = temp.next;
            }else{
                map.put(temp.data, true);
                prev = temp;
            }
        }
    }
}
