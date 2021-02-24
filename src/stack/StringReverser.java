package stack;
import java.util.Stack;

public class StringReverser {
    private final Stack<Character> stack=new Stack<>();

    public String reverse(String str){
        if(str.isEmpty())
            throw new IllegalArgumentException();

        StringBuilder result=new StringBuilder();//So after concatenation we have less garbage.

        for(char i : str.toCharArray()){//for each loop doesn't work with Strings, so we convert them into charArray
            stack.push(i);
        }

        while(!stack.isEmpty()){
            result.append(stack.pop());
        }

        return result.toString();
    }
}
