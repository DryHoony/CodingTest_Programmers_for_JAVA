package programmers.level0;

public class Babbling { // 옹알이
    // "aya", "ye", "woo", "ma" 로 표현할수 있는 단어 만들기

    public static boolean speak(String str){ // 시간초과,,왜?

        while(str.length()>=2){ // 길이 2이상만 받음
            if(str.substring(0,2).equals("ye") || str.substring(0,2).equals("ma")){
                if(str.length()>2) str = str.substring(2); // 남은길이 확인하고
                else return true; // 마지막 매칭이면 return
            }
            else if (str.length()>=3) { // 길이 3이상
                if(str.substring(0,3).equals("aya") || str.substring(0,3).equals("woo")){
                    if(str.length()>3) str = str.substring(3); // 남은길이 확인하고
                    else return true; // 마지막 매칭이면 return
                }
                else return false;
            }
        }

        return false;
    }


    public static boolean speak2(String str){

        while(str.length()>1){

            if(str.substring(0,2).equals("ye") || str.substring(0,2).equals("ma")){
                // 2 매칭될때
                if(str.length()>2){
                    str = str.substring(2); // 단어가 남았으면
                }else return true; // 마지막 매칭

            } else if (str.length()>=3) {
                //3 매칭확인
                if(str.substring(0,3).equals("aya") || str.substring(0,3).equals("woo")){
                    // 3 매칭될때
                    if(str.length()>3){
                        str = str.substring(3); // 단어가 남았으면
                    }else return true; // 마지막 매칭

                }else return false; // 2,3 둘다 매칭안됨 - 나가리
            }else return false; // 2매칭안되고 길이 3안됨 - 나가리

        }

        return false;
    }

    public static void main(String[] args) {
        String[] babbling = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};

        for(String s:babbling){
            System.out.println(speak2(s));
        }


    }
}
