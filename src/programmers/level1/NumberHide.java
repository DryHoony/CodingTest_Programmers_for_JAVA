package programmers.level1;

public class NumberHide { // 핸드폰 번호 가리기

    // 뒷자리4자리 빼고 가리기
    public static String hide(String str){ // 테스트 9 실패한다,,
        int l = str.length();
        String answer = "*".repeat(Math.max(0,l-4));

        answer += str.substring(l-4);

        return answer;
    }

    public static void main(String[] args) {
        String phone_number = "008444";
        System.out.println(hide(phone_number));
        String answer = "";



//        char[] ch = phone_number.toCharArray();
//        for(int i = 0; i < ch.length - 4; i ++){
//            ch[i] = '*';
//        }
//        System.out.println(String.valueOf(ch));

//        System.out.println(phone_number.replaceAll(".(?=.{4})","*"));




    }
}
