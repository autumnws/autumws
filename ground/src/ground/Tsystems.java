package ground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tsystems {

	public static void main(String[] args) {
		/*
		 * int nums[] = new int[] {0,1,0,3,12};
		 * 
		 * for(int j=0;j<nums.length;j++) for(int i=0;i<nums.length-1;i++) { if(nums[i]
		 * == 0) { int temp = nums[i+1]; nums[i+1] = nums[i]; nums[i] = temp; } }
		 * for(int j=0;j<nums.length;j++) System.out.println(nums[j]);
		 */
		
		 List<Integer> list = Arrays.asList(5,-5, 6,-11, 12, 8,-3,-6,15, 9, -9,10,-16);
		 
		 list.sort((num1, num2) -> {
			 return num1-num2;
		 });
		 
		 list.sort((num1, num2) -> {
			 if(num1>0 && num2>0)
			 return num2-num1;
			 else 
				 return 0;
		 });
		 
		 
		 System.out.println(list);
	}
	
	
}

class class1 {
	public static void m1() {
		
	}
}

class class2 extends class1 {
	public static void m1() {
		
	}
}
