import java.math.BigInteger;
import java.util.Scanner;
public class FactorialBigInt {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		BigInteger bg = new BigInteger("1");
		while(n>0){
			bg= bg.multiply(new BigInteger(""+n));
			n--;
		}
		System.out.println(bg.toString());
		sc.close();
	}
	
}
