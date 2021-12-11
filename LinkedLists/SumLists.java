package LinkedLists;

public class SumLists {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.addFirst(7);
        l1.addLast(1);
        l1.addLast(6);

        LinkedList l2 = new LinkedList();
        l2.addFirst(5);
        l2.addLast(9);
        l2.addLast(2);

        Node head = sum(l1.head(), l2.head());
        for(Node temp=head; temp!=null; temp=temp.next){
            System.out.print(temp.data);
        }
    }

    public static Node sum(Node l1, Node l2){
        return addLists(l1, l2, 0);
    }

    public static Node addLists(Node l1, Node l2, int carry){
        if(l1 == null && l2 == null && carry == 0){
            return null;
        }
        Node head = new Node();
        int value = carry;
        if(l1!=null) value += l1.data;
        if(l2!=null) value += l2.data;
        head.data = value % 10;

        if(l1 != null || l2 != null){
            Node next = addLists(l1 == null? null: l1.next, l2 == null? null: l2.next, value/10);
            head.next = next;
        }
        return head;
    }
}
