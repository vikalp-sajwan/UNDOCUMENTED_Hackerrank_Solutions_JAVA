import java.math.BigInteger;
import java.util.Scanner;

public class ModifiedFibonacci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t1 = sc.nextInt();
		int t2 = sc.nextInt();
		int n = sc.nextInt();
		
		BigInteger bt1 = new BigInteger(""+t1);
		BigInteger bt2 = new BigInteger(""+t2);
		BigInteger bt3 = new BigInteger("0");
		
		for(int i = 0; i<n-2; i++){
			bt3 = bt1.add(bt2.multiply(bt2));
			bt1 = bt2;
			bt2 = bt3;
			
		}
		System.out.println(bt3.toString());
		
		
		
		
		
		
		
		sc.close();
	}
}
