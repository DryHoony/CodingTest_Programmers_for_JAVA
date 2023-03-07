package programmers.level1;

public class StringDivide { // 문자열 나누기


    public static void main(String[] args) {
        String s = "abracadabra";

        int count=0;
        String x = null;
        int a = 0;
        int b = 0;
        boolean flag = true;


        for(String c:s.split("")){

            if(flag){
                //초기화
                x = c;
                a=1;
                b=0;

                flag = false;

            }else{
                if (x.equals(c)) a++;
                else b++;

                if (a==b){
                    count++;
                    flag = true;
                }
            }
        }

        // 횟수가 다른 상태에서 더 읽을 글자 없이 종료됬을 때
        if(!flag) count++;

        System.out.println(count);




    }
}
