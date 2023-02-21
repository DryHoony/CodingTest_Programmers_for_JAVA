package programmers.level0;

public class StringMoveRight { // 문자열 밀기

    public static String push(String str){ // 길이2이상의 str에 대해
        String result = str.substring(str.length()-1);
        result += str.substring(0,str.length()-1);

        return result;
    }

    public static void main(String[] args) {
        String str = "hello";
        str.length();

        System.out.println(push(str));
        System.out.println(push(push(push(str))));


    }
}
