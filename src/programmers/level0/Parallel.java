package programmers.level0;

import java.util.ArrayList;

public class Parallel { // 평행 - 미해결!!

//    public static double gradient(double[] dot1, double[] dot2){
//        if(dot1[0]==dot2[0]) return 0; // 수직선, 기울기가 존재하지 않음, 추후 예외처리 필요
//
//        return (dot1[1]-dot2[1]) / (dot1[0]-dot2[0]);
//    }

    public static double gradient(int[] dot1, int[] dot2){ //실수값 고려
        double x = dot1[0]-dot2[0];
        if(x==0) return 0; // 수직선, 기울기가 존재하지 않음, 추후 예외처리 필요
        double y = dot1[1]-dot2[1];

        return y/x;
    }

    public static java.util.List<Double> gradientSet(int[][] dots){
        java.util.List<Double> list = new ArrayList<>();

        for (int i = 0; i < dots.length-1; i++) {
            for (int j = i+1; j < dots.length; j++) {
                list.add(gradient(dots[i],dots[j]));
            }
        }
        return list;
    }

    public static void main(String[] args) {

        int[][] dots = {{1,4},{9,2},{3,8},{11,6}};
//        java.util.List<Double> glist = new ArrayList<>();

//        for (int i = 0; i < dots.length-1; i++) {
//            for (int j = i; j < dots.length; j++) {
////                System.out.println(gradient(dots[i],dots[j]));
//                glist.add(gradient(dots[i],dots[j]));
//            }
//        }

//        System.out.println(glist);
//        System.out.println(glist.get(0));
//        System.out.println(glist.get(4));
//        if(glist.get(0).equals(glist.get(4))) System.out.println("기울기 같다");

        java.util.List<Double> glist = gradientSet(dots);
        System.out.println(glist);

        for (int i = 0; i < glist.size()-1; i++) {
            for (int j = i+1; j < glist.size(); j++) {
                if(glist.get(i).equals(glist.get(j))) System.out.println("같다");
                else System.out.println("다르다");
            }
        }




    }
}
