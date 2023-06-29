package linked_list.double_linked_list;

public class DoublyLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public  Node createDLL(int nodeValue){
        Node node = new Node();
        node.value = nodeValue;
        node.next = null;
        node.prev = null;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insertDDL(int value, int location){
        Node node = new Node();
        node.value = value;
        if(head == null){
            createDLL(value);
            return ;
        }
        if(location == 0){
            node.next = head;
            node.prev = null;
            head.prev = node;
            head = node;
        } else if(location >= size){
            node.next = null;
            tail.next = node;
            node.prev = tail;
            tail = node;
        } else{
            Node tempNode = head;
            for(int i = 0;i < location - 1;i++){
                tempNode = tempNode.next;
            }
            node.prev = tempNode;
            node.next = tempNode.next;
            tempNode.next = node;
            node.next.prev = node;
        }
        size++;
    }

    public void traversal(){
        if(head == null){
            System.out.println("NULL");
            return;
        }
        Node tempNode = head;
        for(int i = 0; i < size; i++){
            System.out.print(tempNode.value + " ");
            tempNode = tempNode.next;
        }
    }

    public void delete(int location){
        if(head == null){
            System.out.println("Double linked list does not exist!");
            return ;
        }
        if(location == 0){
            if(size == 1){
                head = tail = null;
            }else{
                head = head.next;
                head.prev = null;
            }
            size --;
        }else if(location >= size - 1){
            if(size == 1){
                head = null;
                tail = null;
            }else {
                tail = tail.prev;
                tail.next = null;
            }
            size--;
        }else{
            Node tempNode = head;
            for(int i = 0;i < location - 1;i++){
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            tempNode.next.prev = tempNode;
            size--;
        }
    }
}
