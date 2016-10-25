import java.util.HashMap;
import java.util.Scanner;

public class TimeInWords {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h= sc.nextInt();
        int m = sc.nextInt();
        
        HashMap<Integer, String> onesPlace = new HashMap<Integer, String>();
        HashMap<Integer, String> tensPlace = new HashMap<Integer, String>();
        HashMap<Integer, String> tento19 = new HashMap<Integer, String>();
        onesPlace.put(0, "");
        onesPlace.put(1, "one ");
        onesPlace.put(2, "two ");
        onesPlace.put(3, "three ");
        onesPlace.put(4, "four ");
        onesPlace.put(5, "five ");
        onesPlace.put(6, "six ");
        onesPlace.put(7, "seven ");
        onesPlace.put(8, "eight ");
        onesPlace.put(9, "nine ");
        
        tensPlace.put(0, "");
        tensPlace.put(2, "twenty ");
        tensPlace.put(3, "thirty ");
        tensPlace.put(4, "forty ");
        tensPlace.put(5, "fifty ");
        
        tento19.put(10, "ten ");
        tento19.put(11, "eleven ");
        tento19.put(12, "twelve ");
        tento19.put(13, "thirteen ");
        tento19.put(14, "fourteen ");
        //tento19.put(15, "");
        tento19.put(16, "sixteen ");
        tento19.put(17, "seventeen ");
        tento19.put(18, "eighteen ");
        tento19.put(19, "nineteen ");
        
        String hour, min, rel;
        
        // min
        if(m==0){
        	min = "";
        }
        else if(m==15 || m==45){
        	min = "quarter ";
        }
        else if(m==30){
        	min = "half ";
        }
        else{
        	int tempm=m;
        	if(m>=31 && m<=59)
        		tempm = 60 - m;
        	
        	if(tempm>=10 && tempm<=14)
        		min = tento19.get(tempm);
        	else{
        		min = tensPlace.get(tempm/10)+""+onesPlace.get(tempm%10);
        	}
        }
        // min complete
        	
        	
        ///hour
        if(m>=31){
        	if(h==12)
        		h=1;
        	else
        		h++;
        		
        }
        	
        if(h>=1 && h <=9)
           	hour=onesPlace.get(h);
        else
        	hour = tento19.get(h);
        ///hour complete
        
        
        
        if(m==0){
        	rel = "o' clock ";
        	System.out.println(hour+""+rel);
        }
        else if(m==15){
        	System.out.println("quarter past "+hour);
        }
        else if(m==30){
        	System.out.println("half past "+hour);
        }
        else if(m==45){
        	System.out.println("quarter to "+hour);
        }
        else if(m==1){
        	System.out.println("one minute past "+hour);
        }
        else if(m>=2 && m<=29){
        	System.out.println(min+"minutes past "+hour);
        }
        else{
        	System.out.println(min+"minutes to "+hour);
        }
        
    }
}
