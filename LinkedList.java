/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question3;

import java.util.ListIterator;


/**
 *
 * @author jenny
 */
public class LinkedList {
    private Node start;
    private Node end;
    private MyIterator iterator;
    private int size;
    
    public LinkedList() {
        size = 0;
        iterator = new MyIterator();
    }
    
    public MyIterator getIterator() {return iterator;}
    public int size() {return size;}
    
    //adds to end of list
    public void add(int value) {
        if(size == 0) {
            Node n = new Node();
            n.value = value;
            start = n;
            n.next = null;
        }
        else if (size == 1) {
            Node n = new Node();
            start.next = n;
            n.value = value;
            end = n;
            n.next = null;
        }
        else{
            while(iterator.current.next != null) {
                iterator.next();
            }
            Node n = new Node();
            n.value = value;
            iterator.current.next = n;
            end = n;
        }
    }
    
    class Node {
        private Node next;
        private int value;
        
        public Node() {
            next = null;
            value = 0;
        }
        
        public void setNext(Node n) {next = n;}
        public void setValue(int v) {value = v;}
        public Node getNext() {return next;}
        public int getValue() {return value;}
    }
    
    class MyIterator implements ListIterator<Node>{
        private Node current;
        
        //constructor
        public MyIterator() {
            super();
        }
        
        public Node current() {return current;}
        
        //adds after current node
        @Override public void add(Node n) {
            n.setNext(current.getNext());
            current.next = n;
            size++;
        }
        
        @Override public void set(Node n) {current = n;}
        
        //removes next node
        @Override public void remove() {
            current.next = current.next.next;
            current.next.next = null;
            size--;
        }
        
        //moves down the list
        @Override public Node next() {
            set(current.next);
            return current;
        }
        //moves up the list
        @Override public Node previous() {
            return null;
        }
        
        @Override public boolean hasNext() {
            if(size <= 1)
                return false;
            else if(iterator.current.next == null)
                return false;
            else
                return true;
        }
        @Override public boolean hasPrevious() {return false;}
        
        //LinkedList is not indexed
        @Override public int nextIndex() {return -1;}
        @Override public int previousIndex() {return -1;}
        
    }
}
