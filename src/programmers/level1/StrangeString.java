package programmers.level1;

public class StrangeString { // 이상한 문자 만들기

    //단어를 대소대소 형태로 만들기
    public static String word(String str){
        String answer = "";
        int i = 1;
        for(String c:str.split("")){
            if(i==1){ //대문자로
                answer += c.toUpperCase();
            }else{ //소문자로
                answer += c.toLowerCase();
            }
            i *= -1;
        }

        return answer;
    }

    public static String sentence(String str){
        String answer = "";
        int i = 1;
        for(String c:str.split("")){
            if(c.equals(" ")){ //공백이면
                answer += " ";
                i = 1; //초기화
            }else{
                if(i==1) answer += c.toUpperCase();
                else answer += c.toLowerCase();
                i *= -1;
            }
        }

        return answer;
    }



    public static void main(String[] args) {
        String s = "try hello world";
        String answer = "";

        for(String str:s.split(" ")){
            answer += word(str) + " ";
        }

        answer = answer.trim();

        System.out.println(answer);

    }
}
