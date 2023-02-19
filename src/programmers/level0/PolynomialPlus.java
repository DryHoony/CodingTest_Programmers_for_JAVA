package programmers.level0;

public class PolynomialPlus { // 일차다항식 더하기

    public static boolean isNumber(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public String solution(String polynomial) {

        int[] answer = {0,0};

        for(String s:polynomial.split(" ")){
            // 상수
            if(isNumber(s)) answer[1]+=Integer.parseInt(s);
                // 덧셈기호
            else if (s.equals("+")) continue;
                // 일차항
            else if (s.equals("x")) answer[0]+=1;
            else {
                // ax다루기, a가 한자리가 아닐때 주의
                answer[0] += Integer.parseInt(s.substring(0,s.length()-1));
            }
        }

        // 답의 형태(ax + b)로 변환
        String strA = "";
        if(answer[0]==1){
            strA = "x";
        } else if (answer[0]>1) {
            strA += answer[0];
            strA += "x";
        }

        if(strA.equals("")){ // 일차항 없을때
            strA += answer[1];
        } else if(answer[1]>0) { // 일차항 있을때
            strA += " + ";
            strA += answer[1];
        }

        return strA;



    }




}
