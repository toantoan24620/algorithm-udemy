package linked_list.circular_single;

public class Main {
    public static void main(String[] args) {
        CircularSingleLinkedList circularSingleLinkedList = new CircularSingleLinkedList();
        circularSingleLinkedList.createCSLL(1);
        circularSingleLinkedList.insert(1,0);
        circularSingleLinkedList.insert(2,0);
        circularSingleLinkedList.insert(3,0);
        circularSingleLinkedList.insert(4,0);

        circularSingleLinkedList.traversal();
    }
}
