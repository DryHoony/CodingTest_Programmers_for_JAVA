package programmers.highScoreKit.exhaustiveSearch;

public class MockTest { // 모의고사

    public static void main(String[] args) {


    }

    public static void main2(String[] args) {
        int[] answers = {1,3,2,4,2};

        int[] x = {1, 2, 3, 4, 5};
        int[] y = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] z = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int xn = 0;
        int yn = 0;
        int zn = 0;

        for (int i = 0; i < answers.length; i++) {
            if(x[i%5]==answers[i]) xn++;
            if(y[i%8]==answers[i]) yn++;
            if(z[i%10]==answers[i]) zn++;
        }

        // 1등뽑기
        int top = Math.max(Math.max(xn, yn), zn);
        if(top == xn){
            if(top == yn){
                if(top == zn){
                    System.out.println("123");
                }else System.out.println("12");
            }else{
                if(top == zn){
                    System.out.println("13");
                }else System.out.println("1");
            }
        }

        else {
            if(top == yn){
                if(top == zn){
                    System.out.println("23");
                }else System.out.println("2");
            }else System.out.println("3");
        }

    }


}
