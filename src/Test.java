import java.util.*;

public class Test {


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        //sublist실험
        System.out.println(list.subList(0,list.size()/2));
        System.out.println(list.subList(list.size()/2,list.size()));



    }

    }

    



