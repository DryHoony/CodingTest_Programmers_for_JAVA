package programmers.level1;

public class NewIdRecommendation { // 신규 아이디 추천

    // 숫자판별, 한 글자는 Character.isDigit()으로 대체
    public static boolean isNumber(String s){
        try{
            Integer.parseInt(s); // "-10" 음수도 인식가능
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }


    // 문자판별, Character.isAlphabetic()으로 대체
    public static boolean isString(String s){
        return true;
    }


    public static void main(String[] args) {
        String new_id = "=.=";

        //1단계
        String answer = new_id.toLowerCase();

        //2단계 - 소문자, 숫자, - _ . 만 출력, 나머지 제거
        String answer2 = "";
        for(String s:answer.split("")){
            if(Character.isDigit(s.charAt(0)) || Character.isAlphabetic(s.charAt(0))){
                answer2 += s;
            } else if (s.equals("-")||s.equals("_")||s.equals(".")) {
                answer2 += s;
            }
        }

        //3단계
        while (answer2.contains("..")){
            answer2 = answer2.replace("..",".");
        }

        //4단계
        if(answer2.charAt(0)=='.')
            answer2 = answer2.substring(1);

        if(answer2.length()>=2){
            if (answer2.charAt(answer2.length()-1)=='.')
                answer2 = answer2.substring(0,answer2.length()-1);
        }

        //5단계 - 빈문자열
        if(answer2.equals("")) System.out.println("빈문자열 check!, return aaa 할것");

        //6단계
        if (answer2.length()>=16){
            answer2 = answer2.substring(0,15);
        }
        if(answer2.length()>=2){
            if (answer2.charAt(answer2.length()-1)=='.')
                answer2 = answer2.substring(0,answer2.length()-1);
        }

        //7단계
        if(answer2.length()==1){
            answer2 = answer2.repeat(3);
        } else if (answer2.length()==2) {
            answer2 += answer2.substring(1,2);
        }

        System.out.println(answer2);
    }
}
