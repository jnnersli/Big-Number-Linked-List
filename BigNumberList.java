/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question3;

import java.math.BigInteger;

/**
 *
 * @author jenny
 */
public class BigNumberList {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.add(300);
        list1.add(188);
        list1.add(4);
        
        LinkedList list2 = new LinkedList();
        list2.add(1);
        list2.add(19);
        list2.add(0);
        list2.add(44);
        
        System.out.println(parse(list1).toString());
        System.out.println(parse(list2).toString());
        System.out.println(add(list1, list2).toString());
        System.out.println(subtract(list2, list1).toString());
        
    }
    
    public static BigInteger parse(LinkedList l) {
        String number = "";
        while(l.getIterator().hasNext()) { 
            l.getIterator().next();
            number = String.format("%s%03d", number, l.getIterator().current().getValue());
        }
        return new BigInteger(number);
    }
    
    public static BigInteger add(LinkedList l1, LinkedList l2) {
        BigInteger num1 = parse(l1);
        BigInteger num2 = parse(l2);
        return num1.add(num2);
    }
    
    public static BigInteger subtract(LinkedList l1, LinkedList l2) {
        BigInteger num1 = parse(l1);
        BigInteger num2 = parse(l2);
        return num1.subtract(num2);
    }
    
}
