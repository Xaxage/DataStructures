package stack;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String a="{([)]}";
//        StringReverser reverser=new StringReverser();
//        System.out.println(reverser.reverse(a));
        System.out.println(ifBalanced1(a));
        System.out.println(ifBalanced2(a));
        }
        static boolean ifBalanced2(String input){
            char top='1';
            Stack<Character> stack=new Stack<>();

        for(char ch: input.toCharArray()){

            if(ch=='(' || ch=='{' || ch=='[' || ch=='<')
                stack.push(ch);

            if(ch==')' || ch=='}' || ch==']' || ch=='>')
                top=stack.pop();
                if(     (ch==')' && top!='(')||
                        (ch==']' && top!='[')||
                        (ch=='}' && top!='{')||
                        (ch=='>' && top!='<')) return false;
        }

        return stack.empty();
        }
        static boolean ifBalanced1(String str){
        int open=0;
        int close=0;
        Stack<Character> stack=new Stack<>();
        for(char ch : str.toCharArray()){
            if(ch=='(' || ch=='{' ||ch=='<' || ch=='['){
                stack.push(ch);
                open++;
            }

            if(ch==')'){
                if(stack.isEmpty())
                    return false;
                if(stack.peek()!='(')
                    return false;
                close++;
            }

            if(ch=='}'){
                if(stack.isEmpty())
                    return false;
                if(stack.peek()!='{')
                    return false;
                close++;
            }

            if(ch==']'){
                if(stack.isEmpty())
                    return false;
                if(stack.peek()!='[')
                    return false;
                close++;
            }

            if(ch=='>'){
                if(stack.isEmpty())
                    return false;
                if(stack.peek()!='<')
                    return false;
                close++;
            }
        }

            return close == open;
        } // My version
}
