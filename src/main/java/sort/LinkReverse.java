package sort;

import lombok.Data;

public class LinkReverse {
    public static void main(String[] args) {
        Node head = new Node();
        head.setValue(-1);
        head.setNext(null);

        Node p = head;

        for (int i = 1; i < 10; i++) {
            Node tmp = new Node();
            tmp.setValue(i);
            p.setNext(tmp);
            p = tmp;
        }

//        print(head);

        Node print = reverse(head);

        print(print);

    }

    private static Node reverse(Node head) {
        if (head.getNext() == null || head.getNext().getNext() == null){
            return head;
        }


        //取前两个节点
        Node p = head.getNext();
        Node q = head.getNext().getNext();
        Node tmp = null;
        while (q != null){
            tmp = q.getNext();

            q.setNext(p);
            p = q;
            q = tmp;
        }

        head.getNext().setNext(null);
        head.setNext(p);
        return head;
    }

    private static void print(Node first) {
        Node next = first;

        do {
            System.out.println(next.value);
            next = next.next;
        } while (next != null);
    }


}


@Data
class Node {
    int value;
    Node next;
}