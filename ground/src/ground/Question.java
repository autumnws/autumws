package ground;

import java.util.ArrayList;
import java.util.Arrays;

public class Question {

	public static void main(String[] args) {
		
		int n = 100;
		
		//System.out.println(countCircularPrime(100));
		
		//System.out.println(classify(0));
		
		System.out.println(maxTickets(new int[] { 4,10,11}));
	}
	
	static int countCircularPrime(int n) {
		
		int count = 0;
		for(int i=2;i<n;i++) {
			
			//calculate circular numbers list
			String number = new Integer(i).toString();
			int numLen = number.length();	
			String[] numbers = new String[numLen];
			numbers[0] = number;
			
			for(int x=1;x<numLen;x++) {
				
				char num[] = number.toCharArray();
				
				char tmp = num[numLen-1];
				num[numLen-1] = num[0];
				for(int y=0;y<numLen-2;y++)
					num[y] = num[y+1];
				num[numLen-2] = tmp;
				
				number = new String(num);
				numbers[x] = number;
			}
			
			int j = 0;
			for(j=0;j<numbers.length;j++) {
				int no = new Integer(numbers[j]);
				int k = 2;
				for(k = 2; k<no;k++)
					if(no % k == 0)
						break;
				
				if(k<no)
					break;
			}
			if(j==numbers.length)
				count++;
		}
		
		return count;
	}
	
	static String[] getCircularNumbersList(String number)
	{
		int numLen = number.length();	
		String[] numbers = new String[numLen];
		numbers[0] = number;
		
		for(int i=1;i<numLen;i++) {
			
			char num[] = number.toCharArray();
			
			char tmp = num[numLen-1];
			num[numLen-1] = num[0];
			for(int j =0;j<numLen-2;j++)
				num[j] = num[j+1];
			num[numLen-2] = tmp;
			
			number = new String(num);
			numbers[i] = number;
		}
		
		return numbers;
	}
	
	static String classify(int number) {
		int sum = 0;
		
		for(int i=1;i<number; i++) 
			if(number%i == 0)
				sum+=i;
		
		return sum > number ? "Abundant" : sum == number ? "Perfect" : "Deficient";
	}
	
	public static int maxTickets(int tickets[]) {
		int max = 0;
		
		Arrays.sort(tickets);
		
		int size = 0;
		for(int i=0;i<tickets.length;i++) {
			int diff = i<tickets.length-1 ? tickets[i+1] - tickets[i] : 2;
			size++;
			
			if(diff>1) {
				if( size>= max) 
					max = size;
				size = 0;
			}
		}
		
		return max;
	}
}
