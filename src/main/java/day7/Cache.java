package day7;

import java.util.HashMap;

public class Cache {
    //Use double linked list
    Node head;
    Node tail;
    int capacity;
    HashMap<Integer, Node> nodeMap;

    public Cache(int capacity) {
        //to optimize get
        nodeMap = new HashMap<>();

        //build linkedlist
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;

        this.capacity = capacity;
    }

    public int get(int key) {
        if (nodeMap.containsKey(key)){
            //move to front
            Node curNode = nodeMap.get(key);
            moveToFront(curNode);

            return curNode.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        //if already exist
        if(nodeMap.containsKey(key)){
            Node curr = nodeMap.get(key);
            //update value and map
            curr.value = value;
            nodeMap.put(key,curr);
            //Move to front
            moveToFront(curr);
        }else{
            Node newNode = new Node();
            newNode.value = value;
            newNode.key = key;
            //Add newNode to the front
            addNode(newNode);
            nodeMap.put(key,newNode);
        }

        if (nodeMap.size() > this.capacity){
            Node delNode = tail.prev;
            //Get its key
            int delkey = delNode.key;
            //Remove the node from tail
            Node prevNode = delNode.prev;
            prevNode.next = tail;
            tail.prev = prevNode;
            //Remove the key from map
            nodeMap.remove(delkey);
        }
    }

    public void moveToFront(Node node){
        deleteNode(node);
        addNode(node);
    }

    public void addNode(Node node){
        Node nxtNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = nxtNode;
        nxtNode.prev = node;
    }

    public void deleteNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

}
class Node{
    Node prev = null;
    Node next = null;
    int value = -1;
    int key = 0;
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
