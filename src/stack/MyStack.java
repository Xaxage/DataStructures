package stack;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyStack {
    int counter=0;
    LinkedList<Integer> list=new LinkedList<>();

    public void push(int elm){
        list.add(elm);
        counter++;
    }

    public int pop(){
        if(counter==0) throw new NoSuchElementException();
        var result=list.getLast();
        list.removeLast();
        counter--;
        return result;
    }

    public void peek(){
        System.out.println(list.getLast());
    }

    public void print(){
        for(int i : list)
            System.out.println(i);
    }

    public boolean isEmpty(){
        return counter<1;
    }

}
