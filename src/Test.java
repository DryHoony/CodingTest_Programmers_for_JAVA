import java.util.*;

public class Test {


    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        System.out.println(stack);

        System.out.println("pop연산 " + stack.pop() + stack);;
        System.out.println("peek연산 " + stack.peek() + stack);;
        System.out.println();

        System.out.println(stack + "에서 없는값 검색 결과 "+ stack.search("k"));
        System.out.println("search(a) 결과 " + stack.search("a"));
        System.out.println("search(b) 결과 " + stack.search("b"));
        System.out.println("search(c) 결과 " + stack.search("c"));

        System.out.println("get(0) 결과 " + stack.get(0));
        System.out.println("get(2) 결과 " + stack.get(2));
        System.out.println("get(3) 결과는 ArrayIndexOutOfBoundsException ");

        System.out.println();
        System.out.println(stack + "비어있나? " + stack.empty());
        stack.clear();
        System.out.println("clear 후에는 비어있나? " + stack.empty());


    }


}









