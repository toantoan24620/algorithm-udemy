package linked_list.single;

public class SingleLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node createSinglyLinkedList(int value){
        Node node = new Node();
        node.value = value;
        node.next = null;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insert(int nodeValue, int location){
        Node node = new Node();
        node.value = nodeValue;
        if(head == null){
            createSinglyLinkedList(nodeValue);
            return;
        }else if(location == 0){
            node.next = head;
            head = node;
        } else if (location >= size) {
            node.next = null;
            tail.next = node;
            tail = node;
        } else {
            Node tempNode = head;
            int index = 0;
            while(index < location - 1){
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;
        }
        size++;
    }

    public void traversal(){
        if(head == null) {
            System.out.println("Single linked list not exist");
        }else{
            Node tempNode = head;
            for(int i = 0; i < size; i++){
                System.out.print(tempNode.value + " ");
                tempNode = tempNode.next;
            }
        }
    }

    public void delete(int location){
        if(head == null){
            System.out.println("The ssl does not exist");
            return ;
        }else if(location == 0){
            head = head.next;
            size --;
            if(size == 0) tail = null;
        }else if(location >= size - 1){
            Node tempNode = head;
            if(size == 1){
                tail = head = null;
                size --;
                return;
            }
            for(int i = 0; i < size - 1; i++){
                tempNode = tempNode.next;
            }
            tempNode.next = null;
            tail = tempNode;
            size --;
        }else{
            Node tempNode = head;
            for(int i = 0; i < location - 1; i++){
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size --;
        }
    }

    public void deleteEntire(){
        head = null;
        tail = null;
    }
}
