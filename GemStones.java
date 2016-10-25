import java.util.ArrayList;
import java.util.Scanner;

public class GemStones {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        String str = new String(sc.nextLine());
        n--;
        ArrayList<Character> chars = new ArrayList<Character>();
        char ch='a';
        for(int i=0; i<26; i++,ch++){
        	if(str.indexOf(ch)!=-1)
        		chars.add(ch);
        }
        
        while(n>0){
        	str = sc.nextLine();
        	for(int i=0; i<chars.size(); i++){
        		if(str.indexOf(chars.get(i))==-1){
        			chars.remove(i);
        			i--;
        		}
        	}
        	
        	
        	
        	n--;
        }
        System.out.println(chars.size());
        
    }
}