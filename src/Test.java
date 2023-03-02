import java.util.*;

public class Test {

    // 이차원 배열 정렬 int
    public static int[][] arrange2Int(int[][] list){
        Arrays.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1]; // int형으로 return
                }else {
                    return o1[0] - o2[0];
                }
            }
        });

        return list;
    }

    // 이차원 배열 정렬 double
    public static double[][] arrange2Double(double[][] list){
        Arrays.sort(list, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if(o1[0] == o2[0]) {
                    if (o1[1] > o2[1]) return 1;
                    else if(o1[1] == o2[1]) return 0;
                    else return -1;
                }else if(o1[0] > o2[0]) return 1;
                else return -1;
            }
        });

        return list;
    }


    public static void main(String[] args) {
//        int[][] list = new int[6][];
        double[][] list = {{14.5,5},{19,1},{13.5,2},{14.5,3},{15,4},{17.5,6}};

        // 이차원정렬
        arrange2Double(list);

        for (double[] arr:list){
            System.out.println(arr[0] + "," + arr[1]);
        }



    }

    }

    



