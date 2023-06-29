package linked_list.single;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        sll.createSinglyLinkedList(1);
        sll.insert(2,0);
        sll.insert(3,0);
        sll.insert(4,0);
        sll.insert(5,0);
        sll.insert(6,6);

        System.out.println(sll.tail.value);
        sll.traversal();
        sll.delete(1);
        sll.delete(2);
        sll.delete(3);
        sll.delete(3);
        sll.delete(3);
        System.out.println();
        sll.traversal();
    }
}