package programmers.level1;

public class TernaryScale { // 3진법 뒤집기

    // 10진법 >> 3진법 변환
    public static String toTernary(int n){
        String answer="";
        while(n>0){
            answer = String.valueOf(n%3) + answer;
            n /= 3;
        }

        return answer;
    }

    // 3진법 수 뒤집고 >> 10진법 변환
    public static int toNumber(String str){ // 런타임 에러
        // 뒤집기
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.reverse();
        str = sb.toString();

        // 앞자리 0제거
        int n = Integer.parseInt(str);
        int answer=0;
        int i =0;
        while(n>0){
            answer += Math.pow(3,i) * (n%10);
            n /= 10;
            i++;
        }

        return answer;
    }

    public static int toNumber2(String str){
        int answer = 0;
        int i = 0;
        for (String s:str.split("")){
            if(s.equals("1")){
                answer += Math.pow(3,i);
            } else if (s.equals("2")) {
                answer += Math.pow(3,i) * 2;
            }
            i++;
        }

        return answer;
    }


    public static void main(String[] args) {
        int n = 45;

        System.out.println(toTernary(n));
        System.out.println(toNumber2(toTernary(n)));

    }
}
