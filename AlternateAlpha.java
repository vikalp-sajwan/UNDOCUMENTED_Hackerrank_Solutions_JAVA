import java.util.Scanner;

public class AlternateAlpha {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        boolean chars[] = new boolean[26];
        char c = 'a';
        for(int i = 0; i<26; i++){
        	if(s.indexOf(c+i)!=-1)
        		chars[i]= true;
        }
        int maxlen=0;
        for(int i = 0; i<25; i++){
        	if(chars[i]==false)
        		continue;
        	for(int j= i+1; j<26; j++){
        		if(chars[j]==false)
        			continue;
        		String copy = new String("");
        		for (char ch : s.toCharArray()) {
					if(ch == (c+i) || ch == (c+j)){
						copy = copy.concat(""+ch);
					}
				}
        		boolean flag = true;
        		if(!copy.isEmpty() && copy.charAt(0)==c+i){
        			for (int z = 0; z < copy.toCharArray().length; z++) {
						if(z%2==0){
							if(copy.charAt(z)!=c+i){
								flag = false;
								break;
							}
						}else{
							if(copy.charAt(z)!=c+j){
								flag = false;
								break;
							}
						}
					}
        		}
        		else{
        			for (int z = 0; z < copy.toCharArray().length; z++) {
						if(z%2==0){
							if(copy.charAt(z)!=c+j){
								flag = false;
								break;
							}
						}else{
							if(copy.charAt(z)!=c+i){
								flag = false;
								break;
							}
						}
					}
        		}
        		if(flag){
        			if(copy.length()>maxlen)
        				maxlen = copy.length();
        		}
        		
        	}
        }
        System.out.println(maxlen);
    }
}
