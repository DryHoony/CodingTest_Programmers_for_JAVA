package defaultPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test {

	
	public static void main(String[] args) {
		Map<Integer,Integer> testMap = new HashMap<>();


		testMap.put(1,1);
		System.out.println(testMap.get(1));
		System.out.println(testMap.get(2));
//		int tryNull = testMap.get(2);
	}
	

}
