package linked_list.question;

public class LinkedList {
    public Node head;
    public Node tail;
    public int size;

    public void createLL(int nodeValue){
        Node newNode = new Node();
        newNode.value = nodeValue;
        newNode.next = null;
        head = newNode;
        tail = newNode;
        size = 1;
    }

    public void insertNode(int value){
        Node node = new Node();
        node.value = value;
        node.next = null;
        tail.next = node;
        tail = node;
        size++;
    }

    public void delete(int location){
        if(head == null){
            return ;
        }
        if(size == 1){
            head = tail = null;
            size = 0;
            return ;
        }
        if(location == 0){
            tail.next = head.next;
            head = head.next;
        }else if(location >= size - 1){
            Node node = head;
            for(int i = 0; i < size - 1; i++){
                node = node.next;
            }
            node.next = null;
            tail = node;
        }else{
            Node node = head;
            for(int i = 0; i < location - 1; i++){
                node = node.next;
            }
            node.next = node.next.next;
        }
        size--;
    }

    public void traversal(){
        Node tempNode = head;
        for(int i = 0; i < size - 1; i++){
            System.out.print(tempNode.value + "->");
            tempNode = tempNode.next;
        }
        System.out.print(tempNode.value);
    }
}
