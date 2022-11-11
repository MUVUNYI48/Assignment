/*
Done by:
  IKUNDABAYO Placide      221018236
  MUGABE Nshuti Ignace    221025276
  KANYAMAHANGA Desire     221025828 
  MUVUNYI Patrick         221009982
*/
import java.util.Currency;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class MyLinkedList {

    class Node {

        int data;
        Node next;

        public Node() {
            next = null;
        }

        public Node(int a) {
            data = a;
            next = null;
        }
    }
    Node head;
    Node tail;
    int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public MyLinkedList(int a) {
        Node newNode = new Node(a);
        head = newNode;
        tail = newNode;
        size = 1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;

    }

    public void insertAtfront(int a) {
        Node newNode = new Node(a);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;

        } else {
            newNode.next = head;
            head = newNode;

        }
        size++;
    }

    public void insertAtBack(int a) {
        Node newNode = new Node(a);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;

    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + ", ");
            current = current.next;
        }
        System.out.println(' ');

    }

    public   String toString(){ 
        String S =  new String("");
        if (!isEmpty()) {
            Node current = head;
            S += "[";
            while (current != null) {
                S += ","+current.data;
                current = current.next;
            }
            S += "]";
        }
        return  S;
    }
    
    public MyLinkedList concantenate(MyLinkedList  l) {
     if(l.head == null){
        return null;
     }
     else{
        Node current  =  l.head;
        while (current !=null) {
            insertAtBack(current.data);
            current =  current.next;
        }
     }
       return this;
    }

    public static boolean isSorted(MyLinkedList list) {
        boolean result = false;
        Node currentNode = list.head;
        while (currentNode.next != null) {
            if (currentNode.data > currentNode.next.data) {
                return result;
            }
            currentNode = currentNode.next;
        }
        result = true;
        return result;
    }

    public MyLinkedList mergeLinkedList(MyLinkedList list1) {
        
     if(isSorted(list1)== false || isSorted(this)== false){
        return null;
     }
     else{
        this.concantenate(list1);
        System.out.println(this.toString());
        Node current = this.head, index = null;  
        int temp;    
            while(current != null) {  
                index = current.next;  
                while(index != null) {  
                    if(current.data > index.data) {  
                        temp = current.data;  
                        current.data = index.data;  
                        index.data = temp;  
                    }  
                    index = index.next;  
                }  
                current = current.next;  
            }      
        }  

     return this;
    }

    public static void main(String args[]) {
        //create list1 and add element
        MyLinkedList list1 = new MyLinkedList();
        list1.insertAtfront(1);
        list1.insertAtBack(2);
        list1.insertAtBack(16);
        list1.insertAtBack(19);
        list1.insertAtfront(30);
        
      // create list2 add element into list2
        MyLinkedList list2 = new MyLinkedList();
        list2.insertAtfront(4);
        list2.insertAtBack(6);
        list2.insertAtBack(7);
        list2.insertAtBack(11);
        
          System.out.println("List one sorted:" + isSorted(list1));
        list1.print();
        
        System.out.println("List two sorted:" + isSorted(list2));
        list2.print();
    
        System.out.println("Concatened list.");
          String listConcat = list1.concantenate(list2).toString();
          System.out.println(listConcat);
        
        
        System.out.println("MergedList");
         MyLinkedList listMerged = list1.mergeLinkedList(list2);
         System.out.println(listMerged);
   
         
     
     
    }
}
