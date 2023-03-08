import java.util.*;

public class Test {


    public static void main(String[] args) {
        // cards1과 cards2를 순서대로(cards1, cards2 중 어디서 뽑을지 순서는 상관 X) 뽑아 goal만들기


        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        int i = 0;
        int I = cards1.length;;
        int j = 0;
        int J = cards2.length;
        int k =0;

        while(i<I && j<J){ // 둘 중 하나가 완료되면 종료
            if(cards1[i].equals(goal[k])){
                i++;
                k++;
            }
            else if(cards2[j].equals(goal[k])){
                j++;
                k++;
            }
            else System.out.println("No");
        }

        // i 끝나면 j 연산
        if (i==I){
            while (j<J){
                if(cards2[j].equals(goal[k])){
                    j++;
                    k++;
                }
                else System.out.println("No");
            }
        }

        // j 끝나면 i 연산
        if(j==J){
            while(i<I){
                if(cards1[i].equals(goal[k])){
                    i++;
                    k++;
                }
                else System.out.println("No");
            }
        }

        // 최종연산완료되면 return "Yes", 최종연산전에 끝나면 return "No"
        System.out.println("Yes");



    }

    }





