package programmers.level0;

public class TallerPeople { // 머쓱이보다 키 큰 사람

    public static int tallrank(int[] array, int height){
        int rank = 0;
        for(int i:array){
            if(i>height){
                rank+=1;
            }
        }
        return rank;
    }


    public static void main(String[] args){

        int[] array1 = new int[] {149,180,192,170};
        int[] array2 = {180,120,140};

        int height1 = 167;
        int height2 = 190;

        int result1 = 3;
        int result2 = 0;

        System.out.println("Tall문제");

        boolean flag = true;
        if(tallrank(array1, height1) != result1){
            flag = false;
        }
        if (tallrank(array2, height2) != result2){
            flag = false;
        }

        if (flag){
            System.out.println("이게 되네!!");
        }else {
            System.out.println("뭐가 문제야,,say,,");
        }

    }


}
