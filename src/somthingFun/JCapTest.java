package somthingFun;

import java.util.HashMap;
import java.util.Map;

public class JCapTest {

    public int b = 5;

    public JCapTest(){
        System.out.println("D");
    }

    public JCapTest(int b){
        // 1
        b = b;
//        System.out.println("b = " + b);

    }

    public void fn(){
        System.out.println("F");
        System.out.println("b = " + b);

    }

    ///////////////////////////////////////////

    public static void main(String[] args) {
        JCapTest j = new JCapTest(10);
        j.fn();


        String str = "a";
        str.length();

        int[] arr = new int[1];
        int[] arr2 = {7};










    }
}
