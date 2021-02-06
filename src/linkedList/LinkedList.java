package linkedList;

import array.Array;

//addFirst
//addLast +
//deleteFirst
//deleteLast
//contains
//indexOf
public class LinkedList {
    private int size=0;
    private Node first;//head
    private Node last;//tail

    private class Node{//We use it only here, so we don't need it outside.
        private int value;
        private Node next;//so we can keep the reference to the next node.
        //We use it like a third variable. c=a,a=b,b=c.

        public Node(int value) {//Constructor
            this.value = value;
        }
    }

    public void removeFirst(){
        if(first==null){
            throw new NullPointerException();
        }

        if(first==last){
            first=last=null;
            size--;
            return;
        }

        var second=first.next;//We do this, so Garbage collector
        first=null;  //will be able to delete unused memory with no reference.
        first=second;//
        size--;
    }

    public void removeLast(){


        if(first==null){
            throw new NullPointerException();
        }else{
            size--;

            var current=first;
            while(current!=null){
                if(current.next==last) break;
                current=current.next;
            }
        }
    }

    public void addFirst(int item){
        Node node=new Node(item);

        if(first==null){
            first=last=node;
        }else{
            node.next=first;
            first=node;
        }
        size++;
    }

    public void addLast(int item){

        Node node=new Node(item);//we can replace the first 'Node' into var,
        // cause we write 'Node again after the 'new'.

        if(first==null){
            first=last=node;
        }
        else{
            last.next=node;
            last=node;
        }
        size++;
    }

    public int indexOf(int item){
        int index=0;
        if(first==null){
            return -1;
        }

        while(first!=null){
            if(first.value!=item ){
                first=first.next;

            }else {
                return index;
            }
            index++;
        }
        return -1;
    }

    public boolean contains(int item){

        while(first!=null){
            if(first.value!=item){
                first=first.next;
            }else{
                return true;
            }
        }
        return false;
    }

    public int size(){
        return size;
    }

    public int[] toArray(){
        int[] array = new int[size];
        Node currentNode=first;
        var index=0;
        while(currentNode!=null){
            array[index++]=currentNode.value;//"++" will increment the index.It's SHORTER.
            currentNode=currentNode.next;
        }
        return array;
    }

    public void reverse(){

    }
}
