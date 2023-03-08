package programmers.level1;

public class RoughlyMadeKeyboard { //대충만든자판

    public static int keymapCount(String[] keymap, String s){
        // keymap 의 각 원소의 길이는 1~100, 각 원소별 길이를 연산(안되면 101할당) 후 min 취함, 모두 안되면 -1
        int answer = 101;
        char c = s.charAt(0);

        for (String key:keymap){
            answer = Math.min(answer, keyCount(key,c));
        }

        return answer;
    }

    public static int keyCount(String key, char c){

//        char c = s.charAt(0);
        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i) == c){
                return i+1;
            }
        }

        return 101;
    }


    public static void main(String[] args) {
        String[] keymap = {"AA"};
        String[] targets = {"B"};

        int[] answer = new int[targets.length];

        // ver1 - target 의 알파벳이 key 를 (최소)몇번 눌러야 하는지 그때그때 연산
        // ver2 - 모든 알파벳을 대상으로 key 를 (최소) 몇번 눌러야하는지 Map 미리 연산
        // ver1 해보고 시간초과 나면 ver2 해보자


        int count;
        for (int i = 0; i < targets.length; i++) {
//            count = 0; // 초기화

            for(String c:targets[i].split("")){
                //keyboard 연산 - c가 keymap 의 버튼을 (최소)몇번 눌러야 나오는지 연산
                count = keymapCount(keymap, c);
                if(count == 101){
                    answer[i] = -1;
                    break; // 다음 target 으로
                }
                else{
                    answer[i] += count; //초기화 필요한가? - No! 0으로 자동 초기화
                }

            }

        }

        // 결과확인
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }


    }
}
