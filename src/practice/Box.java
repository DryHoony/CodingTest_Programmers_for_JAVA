package practice;

public class Box<E> { // <E> 제너릭(Generic) 적용
    private E obj;

//    public void setObj(Object obj){
//        this.obj = obj;
//    }
//
//    public Object getObj(){
//        return obj;
//    }

// setter 및 getter 생성으로 가능
    public E getObj() {
        return obj;
    }

    public void setObj(E obj) {
        this.obj = obj;
    }
}
