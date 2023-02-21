package programmers.level0;

public class OXquiz { //OX퀴즈

    public static String quiz(String str){

        int n = 0; //연산값
        boolean flag = true; // 덧셈 뺄셈 구분
        String[] list = str.split(" ");

        for (String s:list){
            if(s.equals("=")) break;
            else if(s.equals("+")) flag = true;
            else if(s.equals("-")) flag = false;
            else{
                if(flag) n+= Integer.parseInt(s);
                else n-= Integer.parseInt(s);
            }
        }

        if(n==Integer.parseInt(list[list.length-1])) return "O";
        else return "X";
    }

    public static void main(String[] args) {
        System.out.println(quiz("3 - 4 = -3"));
        System.out.println(quiz("5 + 6 = 11"));
    }

}
