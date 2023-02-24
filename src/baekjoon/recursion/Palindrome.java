package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome { //팰린드롬, 회문

    // 팰린드롬 여부(1,0), recursion 호출횟수 를 return
    public static int[] palindrome(String str){
//        int[] answer = {1,0};
        return palindromeTail(str, new int[]{1, 0});
    }

    public static int[] palindromeTail(String str, int[] list){
        // 종료조건
        if (str.equals("") || list[0]==0){
            list[1]++;
            return list;
        }

        // 남은길이 1 연산
        if(str.length()==1){
            list[1]++;
            return list;
        }

        // 남은 길이 2이상 일반연산
        if(str.charAt(0)==str.charAt(str.length()-1)){ // 같을때
            list[1]++;
//            str.substring(1,str.length()-1) // 앞뒤자름
            return palindromeTail(str.substring(1,str.length()-1),list);
        }else { // 다를때 - 종료조건으로
            list[0] = 0;
            list[1]++;
            return list;
        }

    }




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();
//        int n = Integer.parseInt(br.readLine());

//        int[] answer = palindrome(str);
//        System.out.print(answer[0]);
//        System.out.println(answer[1]);

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int[] answer = palindrome(str);
            System.out.println(answer[0]+ " "+ answer[1]);
        }

    }
}
