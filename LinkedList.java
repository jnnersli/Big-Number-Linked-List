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
    
    //calls iterator add
    public void add(int value) {
        Node n = new Node();
        n.value = value;
        iterator.add(n);
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
    class MyIterator implements ListIterator<Node>{
        private Node current;
        
        //constructor
        public MyIterator() {
            super();
            current = start;
        }
        
        public Node current() {return current;}
        
        //adds at end of list
        @Override public void add(Node n) {
            n.next = end;
            n.previous = end.previous;
            end.previous = n;
            n.previous.next = n;
            size++;
        }
        
        @Override public void set(Node n) {current = n;}
        
        //removes current node
        @Override public void remove() {
            if(current == start || current == end)
                return;
            
            current.previous.next = current.next;
            current.next.previous = current.previous;
            current.next = null;
            current.previous = null;
        }
        
        //moves down the list
        @Override public Node next() {
            set(current.next);
            return current;
        }
        //moves up the list
        @Override public Node previous() {
            set(current.previous);
            return current;
        }
        
        @Override public boolean hasNext() {
            if(size <= 1)
                return false;
            else if(iterator.current.next == null)
                return false;
            else
                return true;
        }
        @Override public boolean hasPrevious() {
            if(size <= 1)
                return false;
            else if(iterator.current.previous == null)
                return false;
            else
                return true;
        }
        
        //LinkedList is not indexed
        @Override public int nextIndex() {return -1;}
        @Override public int previousIndex() {return -1;}
        
    }
}
