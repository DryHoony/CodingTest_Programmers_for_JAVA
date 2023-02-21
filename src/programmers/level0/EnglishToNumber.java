package programmers.level0;

public class EnglishToNumber {

    public static void main(String[] args) {

        String numbers = "onetwothreefourfivesixseveneightnine";

        // String numbers를 replace해서 숫자로 바꿈
        numbers = numbers.replace("zero","0");
        numbers = numbers.replace("one","1");
        numbers = numbers.replace("two","2");
        numbers = numbers.replace("three","3");
        numbers = numbers.replace("four","4");
        numbers = numbers.replace("five","5");
        numbers = numbers.replace("six","6");
        numbers = numbers.replace("seven","7");
        numbers = numbers.replace("eight","8");
        numbers = numbers.replace("nine","9");
//        System.out.println(numbers);

        // String타입인 numbers를 long타입으로 변경
        long answer = Long.parseLong(numbers);
        System.out.println(answer);
        System.out.println(answer+1);

    }
}
