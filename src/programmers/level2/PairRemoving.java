package programmers.level2;

import java.util.Stack;

public class PairRemoving { // 짝지어 제거하기

    public static void main(String[] args) {
        String s = "cdcd";

        // 연산용 변수
        Stack<Character> stack = new Stack<>();
        char c;

        // 연산
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);

            if(!stack.empty() && stack.peek()==c){
                stack.pop();
            }
            else stack.add(c);
        }

        if(stack.empty()) System.out.println(1);
        else System.out.println(0);

//        System.out.println("답은");
    }
}
