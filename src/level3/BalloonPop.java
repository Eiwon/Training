package level3;

import java.util.*;

public class BalloonPop {
//[-16,27,65,-2,58,-92,-71,-68,-61,-33]	6
	public static void main(String[] args) {
		solution(new int[] {-16,27,65,-2,58,-92,-71,-68,-61,-33});

	}
	public static int solution(int[] a) {
        int answer = 0;
        int n = a.length;
        int[] nonChanced = new int[n];
        int[] chanced = new int[n];
        int nonChancedMin = a[0];
        
        for(int i = 1; i < a.length; i++) {
        	System.out.print(a[i] + ", " + nonChancedMin);
        	if(a[i] < nonChancedMin) {
        		nonChanced[i] = nonChanced[i-1] +1;
        		System.out.println(" " + nonChanced[i]);
        		chanced[i] = chanced[i-1] +1;
        		nonChancedMin = Math.min(nonChancedMin, a[i]);
        	}else {
        		nonChanced[i] = nonChanced[i-1];
        		System.out.println(" " + nonChanced[i]);
        		chanced[i] = 1;
        	}
        }
        System.out.println(nonChanced[n-1] + " " + chanced[n-1]);
        
        // dp[n] = dp[n-1] + a[n]이 dp[n-1]의 최소값보다 작은 경우 추가
        // dp'[n] = dp[n-1] + a[n]이 dp[n-1]의 최소값보다 큰 경우 추가
        //	or = dp'[n-1] +  a[n]이 dp[n-1]의 최소값보다 작은 경우 추가
        
        //-16,27,65,-2,58,-92,-71,-68,-61,-33
        //0  	1			2			3			4
       //-16 	-16			-16			-16			-16
       //-16	-16,27		-16,65		-16, -2		-16,58
        //	5
        //-16,-92
        //-16,58,-92
        return answer;
    }
}
