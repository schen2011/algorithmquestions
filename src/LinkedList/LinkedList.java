package LinkedList;

/**
 * Created by stephen.chen on 3/8/2016.
 */


public class LinkedList{

    public class Node {
        private int data;
        private Node next;
        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    Node head;

    public ListedList(){
        head = new Node(0, null);
        listCount = 0;
    }

    public void addFirstNode(int data){
        head = new Node(data, head);
    }

    public void traversingList(){
        Node tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
        }
    }

    public void addLastNode(int data)
    {
        if (head == null)
        {
            addFirstNode(data);
        }
        else
        {
            Node tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new Node(data, null);
        }
    }

    public void insertAfter(int key, int toInsert)
    {
        Node tmp = head;
        while(tmp != null && tmp.data != key)
        {
            tmp = tmp.next;
        }
        if (tmp != null)
        {
            tmp.next = new Node(toInsert, tmp.next);
        }
    }

    public void insertBefore(int key, int toInsert)
    {
        if (head == null)
        {
            return;
        }
        if (head.data == key)
        {
            addFirstNode(toInsert);
            return;
        }

        Node prev = null;
        Node cur = head;

        //move till find cur, and prev
        while (cur != null && cur.data == key)
        {
            prev = cur;
            cur = cur.next;
        }
        //insert to prev next
        if (cur != null)
        {
            prev.next = new Node(toInsert, cur);
        }
    }

    public void removeNode(int key)
    {
        if (head == null)
            throw new RuntimeException("");
        if (head.data == key)
        {
            head = head.next;
            return;
        }
        Node cur = head;
        Node prev = null;
        while (cur != null && cur.data != key)
        {
            prev = cur;
            cur = cur.next;
        }
        if (cur == null)
            throw new RuntimeException("");
        prev.next = cur.next;
    }







}

