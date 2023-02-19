package programmers.level0;

public class SpellingCheck { // 외계어 사전


    public static void main(String[] args) {
        String[] spell = {"z", "d", "x"};
        String[] dic = {"def", "dww", "dzx", "loveaw"};

        boolean flag = false;
        for(String word:dic){
            // word가 spell로 이루어져있는지 확인
            if(spell.length==word.length()){
                for(String s:spell){
                    if (word.contains(s)) flag = true;
                    else{
                        flag = false;
                        break;
                    }
                }
                if(flag) System.out.println("found!!");
            }
        }
        System.out.println(dic[2].contains(spell[1]));

    }

}
