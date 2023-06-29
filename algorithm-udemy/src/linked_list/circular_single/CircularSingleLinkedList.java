package linked_list.circular_single;

public class CircularSingleLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node createCSLL(int nodeValue) {
        Node node = new Node();
        node.value = nodeValue;
        node.next = node;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insert(int value, int location){
        Node node = new Node();
        node.value = value;

        if(head == null){
            createCSLL(value);
            return ;
        }else if(location == 0){
            node.next = head;
            head = node;
            tail.next = head;
        }else if(location >= size){
            tail.next = node;
            node.next = head;
            tail = node;
        }else{
            Node tempNode = new Node();
            for(int i = 0; i < location - 1; i++){
                tempNode = tempNode.next;
            }
            node.next = tempNode.next;
            tempNode.next = node;
        }
        size ++;
    }

    public void traversal(){
        if(head == null) {
            System.out.println("Circular single linked list not exist");
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
            System.out.println("Circular single linked list not exist");
            return ;
        }
        if(location == 0){
            head = head.next;
            tail.next = head;
            size --;
            if(size == 0){
                tail = null;
                head.next = null;
                head = null;
            }
        }else if(location >= size){
            Node tempNode = head;
            if(size == 1){
                head.next = null;
                tail = head = null;
                size --;
                return;
            }
            for(int i = 0; i < size - 1; i++){
                tempNode = tempNode.next;
            }
            tempNode.next = head;
            tail = tempNode;
            size --;
        }else {
            Node tempNode = head;
            for(int i = 0; i < size - 1; i++){
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size --;
        }
    }
}
