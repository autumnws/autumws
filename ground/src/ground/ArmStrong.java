package ground;

public class ArmStrong {

	public static void main(String[] args) {
		int number = 371;
		
		int temp = number;
		int sum = 0;
		
		while(temp>0) {
			int d = temp%10;
			sum += d*d*d;
			temp /= 10;
		}
		
		System.out.printf("%d %s Armstrong number", number, number == sum? "is": "is not");
	}
}
