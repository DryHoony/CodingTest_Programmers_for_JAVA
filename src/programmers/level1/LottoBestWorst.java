package programmers.level1;

public class LottoBestWorst { // 로또의 최고 순위와 최저 순위

    public static int countToRank(int n){
        if (n<2) return 6;
        else return 7-n;
    }


    public static void main(String[] args) {
        int[] lottos = {44,1,0,0,31,25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        int win = 0;
        int count0 = 0;

        // 맞춘숫자 win 연산
        for(int l:lottos){
            if (l==0){
                count0++;
                continue;
            }
            for (int w:win_nums){
                if(l==w) win++;
            }
        }

        System.out.println(win);
        System.out.println(countToRank(win+count0));
        System.out.println(countToRank(win));



    }
}
