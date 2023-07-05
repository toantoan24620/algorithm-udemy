package linked_list.lru_cache;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    DoubleLinkedList list;
    Map<Integer, Node> map;
    Integer capacity;

    public LRUCache(int capacity) {
        list = new DoubleLinkedList();
        map = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node == null){
            return -1;
        }
        list.moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if(node != null){
            list.moveToHead(node);
            node.value = value;
        }else{
            Node newNode = new Node(key, value);
            if(map.size() == capacity){
                Node tail = list.getTail();
                map.remove(tail.key);
                list.removeTail();
            }
            map.put(key, newNode);
            list.addToHead(newNode);
        }
    }

    class DoubleLinkedList{
        Node dummyHead;
        Node dummyTail;

        DoubleLinkedList(){
            dummyHead = new Node(0,0);
            dummyTail = new Node(0,0);
            dummyHead.next = dummyTail;
            dummyTail.prev = dummyHead;
        }

        void moveToHead(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            addToHead(node);
        }

        void addToHead(Node node){
            Node temp = dummyHead.next;
            dummyHead.next = node;
            node.prev = dummyHead;
            node.next = temp;
            temp.prev = node;
        }

        void removeTail(){
            Node newTail = dummyTail.prev.prev;
            newTail.next = dummyTail;
            dummyTail.prev = newTail;
        }

        Node getTail(){
            return dummyTail.prev;
        }
    }

    class Node{
        int value;
        int key;
        Node prev;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}