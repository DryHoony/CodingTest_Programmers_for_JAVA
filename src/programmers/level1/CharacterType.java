package programmers.level1;

public class CharacterType { // 성격 유형 검사, 카카오 기출


    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        int[] count = {0,0,0,0};
        String answer = "";

        for (int i = 0; i < survey.length; i++) {
            if(survey[i].equals("RT")) count[0] += 4-choices[i];
            else if(survey[i].equals("TR")) count[0] -= 4-choices[i];
            else if(survey[i].equals("CF")) count[1] += 4-choices[i];
            else if(survey[i].equals("FC")) count[1] -= 4-choices[i];
            else if(survey[i].equals("JM")) count[2] += 4-choices[i];
            else if(survey[i].equals("MJ")) count[2] -= 4-choices[i];
            else if(survey[i].equals("AN")) count[3] += 4-choices[i];
            else if(survey[i].equals("NA")) count[3] -= 4-choices[i];
        }

        if (count[0]>=0) answer+="R";
        else answer += "T";

        if (count[1]>=0) answer+="C";
        else answer += "F";

        if (count[2]>=0) answer+="J";
        else answer += "M";

        if (count[3]>=0) answer+="A";
        else answer += "N";

        System.out.println(answer);



    }

}
