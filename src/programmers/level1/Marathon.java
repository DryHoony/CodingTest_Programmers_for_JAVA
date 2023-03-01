package programmers.level1;

import java.util.Arrays;

public class Marathon {


    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
            if(!participant[i].equals(completion[i]))
                System.out.println(participant[i]);
        }

        // participant가 하나 많으므로 for문에서 출력안되면
        System.out.println(participant[participant.length-1]);;


    }
}
