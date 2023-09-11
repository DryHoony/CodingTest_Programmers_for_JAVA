package programmers.highScoreKit.GraphandDFSandBFS;

public class BinarySearchExample { // 이진탐색
    // 다양한 예시를 더 보자! 응용하기 어렵다!

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,20,30,40,50,60,70,80,90,100}; // 길이 19

//        int findIndex = searchByRecursion(arr,15);
//        System.out.println(findIndex);

        for (int i = 1; i <= 20; i++) {
//            System.out.println(i*5 + "의 인덱스 검색결과 = " + searchByRecursion(arr, i*5));
            System.out.println(i*5 + "의 인덱스 검색결과 = " + searchByLoop(arr, i*5));
        }

    }

    // 재귀함수 ver
    public static int searchByRecursion(int[] arr, int target){ // 위치하는 index 출력
        int l = 0;
        int r = arr.length;
        int m = r/2;

        // 재귀 - 왼쪽,오른쪽
        if(target < arr[m]) return searchByRecursionUtil(arr, target, l, m-1);
        else if (target > arr[m]) return searchByRecursionUtil(arr, target, m+1,r);
        else return m; // 같을 때
    }

    public static int searchByRecursionUtil(int[] arr, int target, int left, int right){

        if(left < right){
            int m = (left+right)/2;
            if(target < arr[m]) return searchByRecursionUtil(arr, target, left, m-1);
            else if (target > arr[m]) return searchByRecursionUtil(arr, target, m+1,right);
            else return m; // 같을 때
        }

        if(left == right){ // 종료조건 - 모든 분기를 먼저 쪼갠 후 와야한다.
            if(arr[left]==target) return left;
            else return -1;
        }

        // left < right 인 경우는??
        else{
//            System.out.println("left < right 인 경우 도달");
            return -1;
        }


    }

    // 반복문 ver
    public static int searchByLoop(int[] arr, int target){
        int l = 0;
        int r = arr.length;
        int m;

        while(l <= r){
            m = (l+r)/2;

            if(target == arr[m]) return m;
            else if(target < arr[m]) r = m-1;
            else l = m+1;
        }

        return -1; // 검색 실패
    }

}
