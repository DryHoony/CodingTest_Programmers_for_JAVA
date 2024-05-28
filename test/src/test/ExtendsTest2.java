package test;

public class ExtendsTest2 {
	public static void main(String[] args) {
		Child0403 pa = new Child0403(5);
	}
	

}

class Parent040300{
	int a = 10;
	public Parent040300() {
		// TODO Auto-generated constructor stub
		System.out.println(a);
	}
}

class Parent0403 extends Parent040300{
	int a=0;
	Parent0403(){
		a++;
		System.out.println(a);
	}
}

class Child0403 extends Parent0403{
	int b=0;
	Child0403(int a){
		this.b = a;
		System.out.println(a++);
	}
}
