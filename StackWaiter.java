import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class StackWaiter {
	public static void main(String[] args) {
		
		int tempArr[] = new int[5000];
		tempArr[0] = 2;
		tempArr[1] = 3;
		tempArr[2] = 5;
		int tempSize = 3;
		
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		// 1200th prime number is 9733
		for(int i=7; i<9735; i++){
			if(i%2==0 || i%3==0 || i%5==0)
				continue;
			tempArr[tempSize++]= i;
		}
		
		for (int i = 0; i < tempSize; i++) {
			if(tempArr[i]==0)
				continue;
			for(int j = i+1; j<tempSize; j++){
				if(tempArr[j]%tempArr[i]==0){
					tempArr[j]=0;
				}
			}
			if(tempArr[i]!=0)
				primes.add(tempArr[i]);
		}
		
		///*********************************
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		
		//only two stacks can also be used instead of array of stacks for stackA
		ArrayList<Stack<Integer>> stackA = new ArrayList<Stack<Integer>>(1205);
		ArrayList<Stack<Integer>> stackB = new ArrayList<Stack<Integer>>(1205);

		// object creation of stacks
		for(int i=0; i<1205; i++){
			stackA.add(new Stack<Integer>());
			stackB.add(new Stack<Integer>());
		}
		
		//pushing data in first stack
		for(int i= 0; i<n; i++){
			stackA.get(0).push(sc.nextInt());
		}
		
		// performs function for q iterations
		for(int i =1; i<=q; i++){
			while(!stackA.get(i-1).isEmpty()){
				int num = stackA.get(i-1).pop();
				if(num % primes.get(i-1) == 0){
					stackB.get(i).push(num);
				}
				else{
					stackA.get(i).push(num);
				}
				
			}
		}
		
		//print all stackB stacks
		for(int i=0;  i<1205; i++){
			while(!stackB.get(i).isEmpty()){
				System.out.println(stackB.get(i).pop());
			}
		}
		
		//print stackA qth stack
		while(!stackA.get(q).isEmpty()){
			System.out.println(stackA.get(q).pop());
		}
		
		
		sc.close();
	}
}