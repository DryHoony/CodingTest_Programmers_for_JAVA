package programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class CardDeck { // 카드뭉치


//    public static void main(String[] args) { // 런타임 에러(왜지? 주어진 조건내에서 ver3와 차이가 큰가?)
//        // cards1과 cards2를 순서대로(cards1, cards2 중 어디서 뽑을지 순서는 상관 X) 뽑아 goal만들기
//
//
//        String[] cards1 = {"i", "drink", "water"};
//        String[] cards2 = {"want", "to"};
//        String[] goal = {"i", "want", "to", "drink", "water"};
//
//        int i = 0;
//        int I = cards1.length;;
//        int j = 0;
//        int J = cards2.length;
//        int k =0;
//
//        while(i<I && j<J){ // 둘 중 하나가 완료되면 종료
//            if(cards1[i].equals(goal[k])){
//                i++;
//                k++;
//            }
//            else if(cards2[j].equals(goal[k])){
//                j++;
//                k++;
//            }
//            else System.out.println("No");
//        }
//
//        // i 끝나면 j 연산
//        if (i==I){
//            while (j<J){
//                if(cards2[j].equals(goal[k])){
//                    j++;
//                    k++;
//                }
//                else System.out.println("No");
//            }
//        }
//
//        // j 끝나면 i 연산
//        if(j==J){
//            while(i<I){
//                if(cards1[i].equals(goal[k])){
//                    i++;
//                    k++;
//                }
//                else System.out.println("No");
//            }
//        }
//
//        // 최종연산완료되면 return "Yes", 최종연산전에 끝나면 return "No"
//        System.out.println("Yes");
//    }

    public static ArrayList<String> intConvert2(String[] list){
        ArrayList<String> answer = new ArrayList<>();
        for (String i:list){
            answer.add(i);
        }
        return answer;
    }


//    public static void main(String[] args) { // ver2 - ArrayList 를 이용해서 비교해보자, 실패(ver1의 런테임 에러만 실패했다, cards1,2를 모두 사용하지 않아도 되나?)
//        String[] cards1 = {"i", "water", "drink"};
//        String[] cards2 = {"want", "to"};
//        String[] goal = {"i", "want", "to", "drink", "water"};
//
//        List<String> cards1L = intConvert2(cards1);
//        List<String> cards2L = intConvert2(cards2);
//
//        List<String> goalL = new ArrayList<>();
//
//        goalL = intConvert2(goal);
//        goalL.removeAll(cards1L);
//        if(!goalL.equals(cards2L)) System.out.println("No");
//
//        goalL = intConvert2(goal);
//        goalL.removeAll(cards2L);
//        if(!goalL.equals(cards1L)) System.out.println("No");
//
//        System.out.println("앞서 No가 없을때만 Yes");
//
//
//
//
//
//
//
//
//
//
//    }

    public static void main(String[] args) { // ver3 - goal기준으로 반복문 연산
        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        int i = 0;
        int j = 0;


//        for (String s:goal){
//            if (s.equals(cards1[i])) i++;
//            else if (s.equals(cards2[j])) j++;
//            else{
//                System.out.println("No");
//                break;
//            }
//        }

        // IndexOutOfBoundsException 개선 ver
        for (String s:goal){
            if (i< cards1.length && j< cards2.length){
                if (s.equals(cards1[i])) i++;
                else if (s.equals(cards2[j])) j++;
                else{
                    System.out.println("No");
                    break;
                }
            } else if (i< cards1.length) { // i만 연산
                if (s.equals(cards1[i])) i++;
                else{
                    System.out.println("No");
                    break;
                }
            } else if (j< cards2.length) { // j만 연산
                if (s.equals(cards2[j])) j++;
                else{
                    System.out.println("No");
                    break;
                }
            }else{
                System.out.println("No");
                break;
            }
        }

        System.out.println("앞서 No가 없으면 Yes");



    }

}
