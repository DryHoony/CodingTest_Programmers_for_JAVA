import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {

    // 문자열 사이에 문자 추가(모든 위치에)
    public static String[] insert(String n, String c){
        if(n.equals("")){ // 이때는 길이가 2인 array return
            return new String[]{"", c};
        }

        String[] answer = new String[n.length()+2]; // 길이가 l+2 return
        answer[0] = n;
        String newn;

        for (int i = 0; i < n.length(); i++) {
            newn = n.substring(0,i) + c + n.substring(i,n.length());
            answer[i+1] = newn;

        }
        answer[n.length()+1] = n.substring(0,n.length()) + c;

        return answer;
    }

    public static ArrayList<String> insertAll(ArrayList<String> list, String c){
        ArrayList<String> answer = new ArrayList<>();

        for(String str:list){
            answer.addAll(List.of(insert(str, c)));
        }

        return answer;
    }



    public static void main(String[] args) {
        // step2 - 5개의 원소 나열하는 모든 경우의 수
        String[] list = {"a","b","c","d","e"};

        ArrayList<String> mix = new ArrayList<>();
        mix.add("");

        mix = insertAll(mix, list[0]);
        System.out.println(mix);
        System.out.println(mix.size());
        mix = insertAll(mix, list[1]);
        System.out.println(mix);
        System.out.println(mix.size());
        mix = insertAll(mix, list[2]);
        System.out.println(mix);
        System.out.println(mix.size());
        mix = insertAll(mix, list[3]);
        System.out.println(mix);
        System.out.println(mix.size());
        mix = insertAll(mix, list[4]);
        System.out.println(mix);
        System.out.println(mix.size());

        System.out.println("확인");







    }



}









