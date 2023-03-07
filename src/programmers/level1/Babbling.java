package programmers.level1;

public class Babbling { // 옹알이

    public static boolean speak(String str){
        // 연속해서 발음하면 false
        if(str.contains("ayaaya")||str.contains("yeye")||str.contains("woowoo")||str.contains("mama")) return false;

//        String[] can = {"aya", "ye", "woo", "ma"};
        str = str.replace("aya","0");
        str = str.replace("ye","0");
        str = str.replace("woo","0");
        str = str.replace("ma","0");

//        try{ // 숫자판별에서 가져옴
//            Integer.parseInt(str); // "-10" 음수도 인식가능
//            return true;
//        }catch (NumberFormatException e){
//            return false;
//        }
        str = str.replace("0","");

        if (str.equals("")) return true;
        else return false;
    }

    public static void main(String[] args) {
        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};

//        System.out.println(speak(babbling[3]));
//        System.out.println(babbling[2].contains("yeye"));


        int answer = 0;
        for (String str:babbling){
            if(speak(str)) answer++;
        }
        System.out.println(answer);
    }
}
