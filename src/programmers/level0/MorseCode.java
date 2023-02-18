package programmers.level0;

import java.util.HashMap;
import java.util.Map;

public class MorseCode { // 모스부호(1)

    public Map<String, String> morseMapGenerate(){
        Map<String,String> morseMap = new HashMap<>();

        String[] morse =
                {".-", "-...", "-.-.", "-..", ".", "..-.", "--.","....","..",
                        ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
                        "...","-","..-","...-",".--","-..-","-.--","--.."};
        String[] alpha =
                {"a","b","c","d","e","f","g","h","i",
                        "j","k","l","m","n","o","p","q","r",
                        "s","t","u","v","w","x","y","z"};

        for (int i = 0; i < 26; i++) {
            morseMap.put(morse[i], alpha[i]);
        }

        return morseMap;
    }


    public String morseTranslate(String input){
        String answer = new String();
        Map<String, String> morseMap = this.morseMapGenerate();

        String[] inputArray = input.split(" ");
        for (int i = 0; i < inputArray.length; i++) {
            answer += morseMap.get(inputArray[i]);
        }

        return answer;
    }


    public static void main(String[] args) {
        MorseCode mc = new MorseCode();

                String input = ".... . .-.. .-.. ---"; //hello
//        String input = ".--. -.-- - .... --- -."; // python

        System.out.println(mc.morseTranslate(input));

    }

}
