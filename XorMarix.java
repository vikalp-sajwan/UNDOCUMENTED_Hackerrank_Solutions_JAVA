import java.io.IOException;
import java.util.Scanner;

public class XorMarix {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		int n;
		long m;
		int arr[][]= new int[100][10000];
		String str[] = new String[100];
		for(int i = 0 ;i<100; i++){
			str[i]=new String("");
		}
		
		n = sc.nextInt();
		m = sc.nextLong();
		
//
//		//$$$$$$$$$$$$$$$
//		if(m<=50){
//			for(int i = 0; i<n; i++){
//				arr[0][i] = sc.nextInt();
//				
//			}
//			int j=1;
//			while(j<m){
//				for(int i=0; i<n; i++){
//					if(i==n-1){
//						arr[j][i]=arr[j-1][i]^arr[j-1][0];
//						
//					}
//					else{
//						arr[j][i]=arr[j-1][i]^arr[j-1][i+1];
//						
//					}
//				}
//			j++;	
//			}
//			
//			for(int i = 0; i<n; i++){
//				System.out.print(arr[(int) (m-1)][i]+" ");
//				
//			}
//			return;
//		}
//		//$$$$$$$$$$$$$$$
		
		for(int i = 0; i<n; i++){
			arr[0][i] = sc.nextInt();
			str[0]=str[0].concat(""+arr[0][i]);
		}
		
		int firstOccur=-1, secondOccur=-1, factor=-1;
		int times = 100;
		int j=1,k=0;
		boolean flag = false;
		while((times--)>0 && flag==false){
			//phle nayi banayi
			for(int i=0; i<n; i++){
                if(i==n-1){
                    arr[j][i]=arr[j-1][i]^arr[j-1][0];
                    str[j]=str[j].concat(""+arr[j][i]);
                }
                else{
                    arr[j][i]=arr[j-1][i]^arr[j-1][i+1];
                    str[j]= str[j].concat(""+arr[j][i]);
                }
            }
			
			//shuru se us tak check karaya. ki kahin equal to nahi
			for( k=0; k<j; k++){
				factor= areRotations(str[j], str[k]);
				if(factor>=0){
					
					firstOccur = k;
					secondOccur = j;
					flag=true;
					break;
				}
			}
			
			j++;
		}
		if(factor == 0){
			m= m-(firstOccur+1);
			times = (int) (m%(secondOccur-firstOccur));
			
			for(int i = 0; i<n; i++){
				System.out.print(arr[(k+times)][i]+" ");
				
			}
			
			
		}
		else{
			m= m-(firstOccur+1);
			for(int i = 0; i<n ;i++){
				arr[0][i] = arr[firstOccur][i];
			}
			times = (int) (m%(secondOccur-firstOccur));
			int rotatetimes = (int)(m/(secondOccur-firstOccur))*factor;
			rotate(arr[0], rotatetimes,n);
			
			int i;
			times++;
			for( i = 1; i<times; i++){
				for( k = 0; k<n; k++){
					if(k==n-1){
						arr[i][k]=arr[i-1][k]^arr[i-1][0];
						
					}
					else{
						arr[i][k]=arr[i-1][k]^arr[i-1][k+1];
						
					}
				}
				
			}
			for( k = 0; k<n; k++){
				System.out.print(arr[(i-1)][k]+" ");
				
			}
		}
		
		
		
		sc.close();
		
	}
	
	public static void rotate(int[] arr, int order,int n) {	
		if (arr == null || n==0 || order < 0) {
			throw new IllegalArgumentException("Illegal argument!");
		}
	 
		if(order > n){
			order = order %n;
		}
	 
		//length of first part
		int a = n - order; 
	 
		reverse(arr, 0, a-1);
		reverse(arr, a, n-1);
		reverse(arr, 0, n-1);
	 
	}
	 
	public static void reverse(int[] arr, int left, int right){
		if(arr == null || arr.length == 1) 
			return;
	 
		while(left < right){
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}	
	}
	
	static int areRotations(String str1, String str2)
    {
        // There lengths must be same and str2 must be 
        // a substring of str1 concatenated with str1.  
		if(str1.length() == str2.length()){
			int factor = (str1 + str1).indexOf(str2);
			return factor;
		}
        return -1;
    
    }
}
