import java.util.ArrayList;
import java.util.Scanner;

public class CutSticks {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> vec = new ArrayList<Integer>();
		for(int i = 0; i<n; i++){
			vec.add(new Integer(sc.nextInt()));
		}
		int min;
		while(!vec.isEmpty()){
			min = 1001;
			System.out.println(vec.size());
			for (Integer integer : vec) {
				if(integer.intValue()<min)
					min=integer.intValue();
			}
			while(vec.remove(new Integer(min)));
			if(!vec.isEmpty()){
				for(int i = 0; i<vec.size(); i++){
					vec.set(i, vec.get(i)-min);
				}
			}
			
		}
		sc.close();
	}
}
