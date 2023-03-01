package programmers.level1;

public class GiveUpMath {

//    public static int count1(int[] answers){ // 1 2 3 4 5 반복
//        int count=0;
//        for (int i = 0; i < answers.length; i++) {
//            if(answers[i] == i%5+1) count++;
//        }
//        return count;
//    }

    public static int count(int[] answers, int[] quiz){
        int count=0;

        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == quiz[i%quiz.length])
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        // 1번 12345반복 , 2번 21232425 반복 , 3번 3311224455 반복
        int[] answers = {1,2,3,4,5};

        int a = count(answers, new int[]{1, 2, 3, 4, 5});
        int b = count(answers, new int[]{2,1,2,3,2,4,2,5});
        int c = count(answers, new int[]{3,3,1,1,2,2,4,4,5,5});

        // a,b,c 중 가장 높은점수받은 사람 도출
        // 중복 있다면 그대로 도출

        if(a>b){
            if(c>a) System.out.println("3");
            else if(c==a) System.out.println("13");
            else System.out.println("1");
        } else if (a==b) {
            if(c>a) System.out.println("3");
            else if(c==a) System.out.println("123");
            else System.out.println(12);
        } else {
            if(c>b) System.out.println(3);
            else if(c==b) System.out.println(23);
            else System.out.println(2);
        }


    }
}
