package programmers.level0;

import java.util.ArrayList;
import java.util.List;

public class StringOverlapRemove { //중복된 문자 제거


    public static void main(String[] args) {
        String my_string = "We are the world";
        String[] list = my_string.split("");
        List<String> rlist = new ArrayList<>();
        String result = "";

        for (String s:list){
            if(!rlist.contains(s)){
                rlist.add(s);
                result += s;
            }

        }

        System.out.println(result);




    }
}
