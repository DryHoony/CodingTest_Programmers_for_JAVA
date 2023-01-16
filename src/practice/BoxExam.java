package practice;

public class BoxExam {
    public static void main(String[] args) {
//        Box box = new Box();
//        box.setObj(new Object());
//        Object obj = box.getObj();
//
//        box.setObj("box의 obj에 담긴 값");
//        String str = (String)box.getObj(); // Object타입이므로 String타입으로 형변환이 필요한것으로 보임
//        System.out.println(str);
//
//        box.setObj(1);
//        int value = (int)box.getObj();
//        System.out.println(value);
//
//        System.out.println("----- Generic을 이용해 수정한 version------");
//
//        Box<Object> box0 = new Box<>();
//        box.setObj(new Object());
//        Object obj0 = box.getObj();

//        Box<String> box2 = new Box<>();
//        box2.setObj("String 타입의 box에 저장된 값");
//        String str2 = box2.getObj();
        Box<String> box2 = new Box<>();
        box2.setObj("hello");
        String str = box2.getObj();
        System.out.println(str);

        Box<Integer> box3 = new Box<>();
        box3.setObj(1);
        int value = (int)box3.getObj();
        System.out.println(value);



    }
}
