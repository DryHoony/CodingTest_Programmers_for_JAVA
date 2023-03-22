package programmers.highScoreKit.stackQueue;

public class RightBracket { // 올바른 괄호

//    public static void main(String[] args) { // ver1 - Stack 이용 ver, Stack 에 "(" 만 담으므로 Queue 를 써도 상관X
//        String s = "(()(";
//
//        Stack<Character> stack = new Stack<>();
////        if(!stack.empty()) System.out.println(stack.pop());
//
//
//
////        for (String x:s.split("")){
////            if(x.equals("(")) stack.push("(");
////            else{ // ")" 일때
////                if(stack.empty()) System.out.println("return false");
////                else stack.pop();
////            }
////        }
//        // String.split("")연산이 너무 무거워서 실패한 듯 - 너무 무거워 보이진 않지만 일단 Character 이용으로 효율성 테스트 통과!
//        // 반복문으로 String.charAt(i) 연산으로 수정
//        for (int i = 0; i < s.length(); i++) {
//            if(s.charAt(i) == '(') stack.push('(');
//            else{
//                if(stack.empty()) System.out.println("return false");
//                else stack.pop();
//            }
//        }
//
//
//
//        // 반복문 끝났을 때, () 짝이 맞아 stack 이 empty 여야 true
//        if(stack.empty()) System.out.println("return true");
//        else System.out.println("return false");
//
//    }


    public static void main(String[] args) { // ver2 - 간단 ver, '('의 갯수만 잘 연산하면 ok , 훨씬 빠르다
        String s = ")()(";

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') count++;
            else{
                if(count == 0) System.out.println("return false");
                count --;
            }
        }

        // 반복문이 끝났을 때 () 짝이 맞아 count==0 이어야 완성
        if(count == 0 ) System.out.println("return true");
        else System.out.println("return false");



    }
}
