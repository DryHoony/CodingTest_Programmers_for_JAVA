package programmers.level0;

public class ReverseArray { //배열 뒤집기

    public static int[] reverse(int[] list){
        int len = list.length;
        int[] answer = new int[len];

        for(int i=0; i<len; i++){
            answer[i] = list[len-1-i];
        }

        return answer;
    }

//    public int[] reverse(int[] num_list) {
//        int len = num_list.length;
//        int[] answer = new int[len];
//
//        for(int i=0; i<len; i++){
//            answer[i] = num_list[len-1-i];
//        }
//
//        return answer;
//    }



}
