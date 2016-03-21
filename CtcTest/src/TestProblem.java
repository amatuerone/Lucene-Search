
import java.util.*;


class TestProblem {
    public static void main (String args[])
    {   
    	solution(435);
     }
    
    static void solution(int N) {
        // write your code in Java SE 8
         int length = (int) Math.log10(N) + 1;
         Integer[] arr= new Integer[length];
         int j = 0;
         int number = N;
         for(int i=1;i<length;i++){
        	 double divisor = 10;
        	 
        	 String element = (Double.toString(number/divisor));
        	 String Str = new String(element);
        	 String[] eleArray = Str.split("\\.");
        	 int x = eleArray.length;
        	 int ele = Integer.valueOf(eleArray[x-i]);
        	 number = Integer.valueOf(eleArray[0]);
        	 arr[j] = ele;
        	 j++;
         }
         if(number/10==0){arr[j] = number;}
         
         Arrays.sort(arr, Collections.reverseOrder());
         int result = 0;
         for (int i = 0; i < length; i++) {
        	 	result = result + (int) Math.pow(10, length-1-i) * arr[i];
        	    
        	    }
        	System.out.println(result);
    }
    static void ssolution() {
    	int[] arr= new int[]{-1,1,3, 3 ,3 ,2,1,0};
    	int i = 0, j=0, k=0;
    	int n = arr.length; 
    	int nnum = 0;
    	Arrays.sort(arr);
    	Integer[] arr1= new Integer[n-1];
    	
    	
    	for(i = 0;i<n-1; i++)
    	{
    		j = i+1;
    		int num = arr[j] - arr[i];
    		int count =0;
    		for(j=i+1;j<n;j++)
    		{
    			k = j+1;
    			if(k<=n-1 && arr[k] - arr[j] == num)
    			{
    				j = j+1;
    				count = count +1;
    				
    			}else{
    				break;
    			}
    		}
    		if(count>=2){
    			nnum = nnum+1;
    		}
    	}
    	System.out.println(nnum);
    }
}