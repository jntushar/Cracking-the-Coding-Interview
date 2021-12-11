package LinkedLists;

public class Palindrome {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.addFirst(0);
        l1.addLast(1);
        l1.addLast(2);
        l1.addLast(1);
        l1.addLast(0);
        System.out.println(isPalindrome(l1.head()));
    }

    public static boolean isPalindrome(Node head){
        Node reversed = reverseAndClone(head);
        return isEqual(head, reversed);
    }

    public static Node reverseAndClone(Node node){
        Node head = null;
        while(node!=null){
            Node n = new Node(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    public static boolean isEqual(Node one, Node two){
        while(one!=null && two!=null){
            if(one.data != two.data) return false;
            one = one.next;
            two = two.next;
        }
        return one==null && two==null;
    }
}
