package defaultPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test {

	
	public static void main(String[] args) {
		ArrayList<int[]> testList = new ArrayList<>();
		int[] changeArr = new int[5];
		for (int i = 0; i < changeArr.length; i++) {
			changeArr[i]=i;
		}

		testList.add(changeArr);
		// 할당이후 changeArr 수정

		System.out.println("덧셈연산");
		for (int i = 0; i < changeArr.length; i++) {
			changeArr[i]++;
			changeArr[i]++;
		}

		for (int i:testList.get(0)){
			System.out.print(i + "  ");
		}
		System.out.println();

		System.out.println("두배연산");
		for (int i = 0; i < changeArr.length; i++) {
			changeArr[i]*=2;
		}

		for (int i:testList.get(0)){
			System.out.print(i + "  ");
		}
		System.out.println();



	}
	

}
