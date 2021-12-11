package LinkedLists;


public class ReturnKthToLast {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(3);
        linkedList.addLast(10);
        linkedList.addLast(9);
        linkedList.addLast(4);
        linkedList.addLast(7);
        linkedList.addLast(6);
        linkedList.addLast(1);
        linkedList.display();
        System.out.println("\nKthToLast: " + KthToLast(linkedList.head(), 6));
        printKthToLast(linkedList.head(), 4);
    }

    public static int KthToLast(Node head, int k) {
        if(head == null) return 0;
        int size = 0;
        for(Node temp = head; temp!=null; temp = temp.next){
            size++;
        }
        Node temp = head;
        for(int i=0; i<size-k; i++){
            temp = temp.next;
        }
        return temp.data;
    }

    //recursive
    public static int printKthToLast(Node head, int k){
        if(head == null) return 0;
        int index = printKthToLast(head.next, k) + 1;
        if(index == k){
            System.out.println(k + "th to last node is " + head.data);
        }
        return index;
    }
}
