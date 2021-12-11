package LinkedLists;

public class LoopDetection {
    public static void main(String[] args) {

    }

    public static Node findBeginning(Node head){
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) break;
        }
        if(fast == null || fast.next == null){
            return null;
        }
        slow = head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }
}
