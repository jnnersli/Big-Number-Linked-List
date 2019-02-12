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
    private final Node start, end;
    private MyIterator iterator;
    private int size;
    
    public LinkedList() {
        size = 0;
        iterator = new MyIterator();
        start = new Node();
        end = new Node();
        start.next = end;
        end.previous = start;
    }
    
    //getters
    public MyIterator getIterator() {return iterator;}
    public int size() {return size;}
    
    //add to end of list
    public void addAfter(int value) {
        Node n = new Node();
        n.value = value;
        iterator.add(n);
    }
    
    //add to beginning of list
    public void addBefore(int value) {
        Node n = new Node();
        n.value = value;
        iterator.addBefore(n);
    }
    
    //Node class
    class Node {
        private Node next;
        private Node previous;
        private int value;
        
        public Node() {
            next = null;
            previous = null;
            value = 0;
        }
        
        public void setNext(Node n) {next = n;}
        public void setPrevious(Node n) {previous = n;}
        public void setValue(int v) {value = v;}
        public Node getNext() {return next;}
        public Node getPrevious() {return previous;}
        public int getValue() {return value;}
    }
    
    //Iterator class
    class MyIterator {
        private Node current;
        
        //constructor
        public MyIterator() {
            current = start;
        }
        
        public Node current() {return current;}
        
        //adds at end of list
        public void add(Node n) {
            n.next = end;
            n.previous = end.previous;
            end.previous = n;
            n.previous.next = n;
            size++;
        }
        
        public void addBefore(Node n) {
            n.previous = start;
            n.next = start.next;
            start.next.previous = n;
            start.next = n;
            size++;
        }
        
        public void set(Node n) {current = n;}
        
        //sets iterator at beginning of list
        public void first() {current = start.next;}
        
        //sets iterator at last element
        public void last() {current = end.previous;}
        
        //removes current node
        public void remove() {
            if(current == start || current == end)
                return;
            
            current.previous.next = current.next;
            current.next.previous = current.previous;
            current.next = null;
            current.previous = null;
        }
        
        //moves down the list
        public Node next() {
            set(current.next);
            return current;
        }
        //moves up the list
        public Node previous() {
            set(current.previous);
            return current;
        }
        
        public boolean hasNext() {
            if(size <= 1)
                return false;
            else if(iterator.current.next == null)
                return false;
            else
                return true;
        }
        public boolean hasPrevious() {
            if(size <= 1)
                return false;
            else if(iterator.current.previous == null)
                return false;
            else
                return true;
        }
    }
}
