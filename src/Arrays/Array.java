package Arrays;

public class Array {
    private int[] items;
    private int count=0;

    public Array(int size) {
        items=new int[size];
    }

    public void insert(int element){
        if(count< items.length){
            items[count]=element;
            count++;
        }
        else if(count>= items.length){
            int[] extItems= new int[items.length*2];//Creating a new array that 2x bigger.
            for(int i=0,j=0;i< items.length;i++,j++){//Initializing the elements
                extItems[j]=items[i];
            }
            items=extItems;
            items[count]=element;
            count++;
        }
    }

    public int indexOf(int number){
        for(int i=0;i<items.length;i++){
          if(items[i]==number){
              return i;
          }
        }
        return -1;
    }

    public void removeAt(int index) {
        //10,20,30,40,50
        //indexAt(2) => 10,20,40,50

            if(index<count && count>0){
                for (int i = 0; i < items.length - index - 1; i++) {
                items[index + i] = items[index + i + 1];
                }
                count--;
            }else{
                throw new IllegalArgumentException();
            }
    }

    public void insertAt(int item, int index){


    }

    public int maxElem(){
        int max=0;
        for(int i=0;i< items.length;i++){
            if(max<items[i]){
                max=items[i];
            }
        }
        return max;
    }

    public void reverseArray(){
        for(int i=0;i<=count/2;i++){
            int m=items[i];
            items[i]=items[count-1-i];
            items[count-1-i]=m;
        }
    }

    public void print(){
        for(int i=0;i<count;i++){
            System.out.println(items[i]);
        }
    }
}
