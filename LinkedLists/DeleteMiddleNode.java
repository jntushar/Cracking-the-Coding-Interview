package LinkedLists;

public class DeleteMiddleNode {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(5);
        linkedList.addFirst(7);
        linkedList.addLast(8);
        linkedList.addLast(9);
        linkedList.addLast(10);
        linkedList.addFirst(1);
        linkedList.display();

        deleteMiddleNode(linkedList.head().next.next.next);
        linkedList.display();
    }

    public static void deleteMiddleNode(Node node){
        if(node == null || node.next == null) return;
        Node next = node.next;
        node.data = next.data;
        node.next = next.next;

    }
}
