package LinkedLists;

class Result{
    Node tail;
    int size;

    Result(Node tail, int size){
        this.tail = tail;
        this.size = size;
    }
}

public class Intersection {
    public static void main(String[] args) {

    }

    public static Node findIntersection(Node l1, Node l2){
        Result result1 = getTailAndSize(l1);
        Result result2 = getTailAndSize(l2);

        if(result1.tail != result2.tail) return null;

        Node shorter = result1.size < result2.size? l1 : l2;
        Node longer = result1.size < result2.size? l2 : l1;

        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        while (longer!=shorter){
            shorter = shorter.next;
            longer = longer.next;
        }
        return longer;
    }

    public static Result getTailAndSize(Node head){
        if(head == null){
            return new Result(null, 0);
        }
        int size = 1;
        Node current = head;
        while(current!=null){
            current = current.next;
            size++;
        }
        return new Result(current, size);
    }

    public static Node getKthNode(Node head, int k){
        Node current = head;
        while (k > 0 && current!=null){
            current = current.next;
            k--;
        }
        return current;
    }
}
