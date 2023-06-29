package linked_list.double_linked_list;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.createDLL(1);
        doublyLinkedList.insertDDL(2,0);
        doublyLinkedList.insertDDL(3,1);
        doublyLinkedList.insertDDL(4,2);
        doublyLinkedList.insertDDL(5,4);
        doublyLinkedList.insertDDL(6,2);

        doublyLinkedList.traversal();
        doublyLinkedList.delete(0);
        doublyLinkedList.delete(4);
        doublyLinkedList.delete(2);
        System.out.println();
        doublyLinkedList.traversal();
    }
}
