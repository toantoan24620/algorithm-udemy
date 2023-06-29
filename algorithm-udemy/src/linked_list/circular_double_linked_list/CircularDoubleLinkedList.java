package linked_list.circular_double_linked_list;

public class CircularDoubleLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node createCircularDoubleLinkedList(int value){
        Node node = new Node();
        node.value = value;
        head = node;
        tail = node;
        node.next = node;
        node.prev = node;
        size = 1;
        return head;
    }

    public void insert(int value, int location){
        if(head == null){
            createCircularDoubleLinkedList(value);
            return ;
        }
        Node node = new Node();
        node.value = value;
        if(location == 0){
            node.prev = tail;
            node.next = head;
            head.prev = node;
            tail.next = node;
            head = node;
        }else if(location >= size){
            node.prev = tail;
            node.next = head;
            tail.next = node;
            head.prev = node;
            tail = node;
        }else{
            Node tempNode = new Node();
            for(int i = 0 ; i < location - 1; i++){
                tempNode = tempNode.next;
            }

            node.next = tempNode.next;
            node.prev = tempNode;
            tempNode.next = node;
            node.next.prev = node;
        }
        size++;
    }

    public void traversal(){
        if(head == null) {
            System.out.println("Circular double linked list not exist");
            return ;
        }
        Node tempNode = head;
        for(int i = 0; i < size; i++){
            System.out.print(tempNode.value + " ");
            tempNode = tempNode.next;
        }
    }

    public void delete(int location){
        if(head == null){
            System.out.println("Circular double linked list not exist");
            return ;
        }
        if(location == 0){
            if(size == 1){
                head = null;
                tail = null;
            }else{
                head = head.next;
                head.prev = tail;
                tail.next = head;
            }
        }else if(location >= size - 1){
            if(size == 1){
                head = tail = null;
            }else{
                tail = tail.prev;
                tail.next = head;
                head.prev = tail;
            }
        }else {
            Node tempNode = head;
            for(int i = 0;i < location - 1;i++){
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            tempNode.next.prev = tempNode;
        }
        size--;
    }
}
