import java.util.*;

public class Test {


    public static void main(String[] args) {

        String s = "ZbcBdefAg";
        String[] list = s.split("");

        Arrays.sort(list); //대문자를 더 큰 것으로 간주
        // 역순정렬



        String answer = "";
        for(String c:list){
            answer+=c;
        }


        System.out.println(answer);



    }

    }

    



