package programmers.level0;

import java.util.Arrays;

public class EmergencySetOrder { // 응급 순서 정하기

    public int[] setOrder(int[] emergency){
        int[] orderd = Arrays.copyOf(emergency,emergency.length); // 얕은복사로
        Arrays.sort(orderd);

        ReverseArray ra = new ReverseArray();
        orderd = ra.reberse(orderd);

        int[] answer = new int[emergency.length];

        for(int i=0; i<emergency.length; i++){
            for(int j=0; j<emergency.length; j++){
                if (emergency[i]==orderd[j]){
                    answer[i] = j+1;
                    break;
                }
            }
        }

        return answer;
    }

    // 주어진 숫자 범위가 100이하 임을 이용한 편법
    public int[] setOrder1(int[] emergency){
        int[] answer = new int[emergency.length];
        int a=1; // answer에 할당될 응급도 순서

        for(int i=100; i>0; i--){
            for (int j=0; j<emergency.length; j++){
                if(i==emergency[j]){
                    answer[j]=a;
                    a++;
                    break;
                }
            }
        }

        return answer;

    }


    public static void main(String[] args) {
        EmergencySetOrder so = new EmergencySetOrder();

        int[] emergency1 = {3,76,24};
        int[] emergency2 = {1,2,3,4,5,6,7};
        int[] emergency3 = {30,10,23,6,100};

        int[] result1 = so.setOrder(emergency1);
        int[] result2 = so.setOrder(emergency2);
        int[] result3 = so.setOrder(emergency3);

        for(int i:result3){
            System.out.println(i);
        }
    }


}
