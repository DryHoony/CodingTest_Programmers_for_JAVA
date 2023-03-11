import java.util.*;

public class Test {


    public static void main(String[] args) {
        String[] phone_book = {"1192456", "119"};
        Map<String, Boolean> prefix = new HashMap<>();
        prefix.put(phone_book[0],true);

        int i=1;
        while (i<=phone_book[1].length()){
            System.out.println(phone_book[1].substring(0,i));
            if(prefix.containsKey(phone_book[1].substring(0,i)))
                System.out.println("잡았다!!");
            i++;
        }




    }

    }





