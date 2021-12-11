package LinkedLists;

public class Partitions {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(3);
        linkedList.addLast(5);
        linkedList.addLast(8);
        linkedList.addLast(5);
        linkedList.addLast(10);
        linkedList.addLast(2);
        linkedList.addLast(1);
        linkedList.display();

        partition(linkedList.head(), 5);
    }

    public static void partition(Node head, int pivot){
        Node newHead = head;
        Node newTail = head;

        while(head != null){
            Node next = head.next;
            if(head.data < pivot){
                head.next = newHead;
                newHead = head;
            }else{
                newTail.next = head;
                newTail = head;
            }
            head = next;
        }
        newTail.next = null;
    }
}
