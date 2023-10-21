import java.util.ArrayList;
import java.util.List;

public class Test2 {

    static int classVar = 10;


    public static void main(String[] args) {
        int var = 10;

//        change(var);


        System.out.println("var = " + var);
        System.out.println("classVar = " + classVar);


    }

    public static void change(int var){
        classVar = 20; // 바뀐다
        var = 20; // 안바뀐다. >> 지역변수

    }

    public static int changeReturn(int var){
        classVar = 100;

        var = 100;
        return var;
    }

}
