package linkedList;


public class LinkedList {
    private int size=0;
    private Node head;//head
    private Node tail;//tail

    private class Node{//We use it only here, so we don't need it outside.
        private int value;
        private Node next;//so we can keep the reference to the next node.
        //We use it like a third variable. c=a,a=b,b=c.

        public Node(int value) {//Constructor
            this.value = value;
        }

        public Node(){}//Default constructor
    }

    public void removeFirst(){
        if(head ==null){
            throw new NullPointerException();
        }

        if(head == tail){
            head = tail =null;
            size--;
            return;
        }

        var second= head.next;//We do this, so Garbage collector
        head =null;  //will be able to delete unused memory with no reference.
        head =second;//
        size--;
    }

    public void removeLast(){


        if(head ==null){
            throw new NullPointerException();
        }else{
            size--;

            var current= head;
            while(current!=null){
                if(current.next== tail) break;
                current=current.next;
            }
        }
    }

    public void addFirst(int item){
        Node node=new Node(item);

        if(head ==null){
            head = tail =node;
        }else{
            node.next= head;
            head =node;
        }
        size++;
    }

    public void addLast(int item){

        Node node=new Node(item);//we can replace the first 'Node' into var,
        // cause we write 'Node again after the 'new'.

        if(head ==null){
            head = tail =node;
        }
        else{
            tail.next=node;
            tail =node;
        }
        size++;
    }

    public int indexOf(int item){
        int index=0;
        if(head ==null){
            return -1;
        }

        while(head !=null){
            if(head.value!=item ){
                head = head.next;

            }else {
                return index;
            }
            index++;
        }
        return -1;
    }

    public boolean contains(int item){

        while(head !=null){
            if(head.value!=item){
                head = head.next;
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
        Node currentNode= head;
        var index=0;
        while(currentNode!=null){
            array[index++]=currentNode.value;//"++" will increment the index.It's SHORTER.
            currentNode=currentNode.next;
        }
        return array;
    }

    public void reverse(){
        var previous= head;
        var current= head.next;
        // 1 -> 2 -> 3 -> 4
        // p    c    n
        // 1 -> 2 <- 3    4
        while(current!=null){

            var next=current.next;//so after the next line we can contact to the next node.
            current.next=previous;//1

            previous=current;//moving forward
            current=next;//moving forward
        }
        tail = head;
        tail.next=null;//So we have no FLOATING reference (->)
        head =previous;
    }

    public int getKthFromTheEnd(int k){
        var first1=head;
        var first2=head;
        var last= new Node();
        //var tmp=new Node();
        int i=0;

        while(i!=k) {
            last = first1;
            first1 = first1.next;
            i++;
            //10 20 30 40 50  k=3
            // x    x
        }

        while(last!=tail){
            first2=first2.next;
            last=last.next;
        }

        return first2.value;
    }
}
