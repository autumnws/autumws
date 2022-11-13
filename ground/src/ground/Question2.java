package ground;

public class Question2 {

	public static void main(String[] args) {
	
		System.out.println(MSkills(10, 1, 5));
	}
	
	static int MSkills(int N, int A, int B) {
		
		for(int i=N;i>0;i--) {
			int req = B * i;
			int fund = A*(N-i);
			if(fund>req) {
				return i;
			}
		}
		
		return 0;
	}
}
