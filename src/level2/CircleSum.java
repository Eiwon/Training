//3 ≤ elements의 길이 ≤ 1,000
//1 ≤ elements의 원소 ≤ 1,000


package level2;
import java.util.*;
public class CircleSum {

	public static void main(String[] args) {
		solution(new int[] {7,9,1,1,4});
	}
	
	public static int solution(int[] elements) {
        int answer = 0;
        HashMap<Integer, Boolean> ls = new HashMap<>();
        int n = elements.length;
        int sum = 0;
        
        for(int j=0; j < n; j++) {
        	sum = 0;
        	for(int i=0; i<n; i++) {
        		sum += elements[(i+j)%n];
        		if(!ls.containsKey(sum)) {
        			ls.put(sum, false);
        		}
        	}
        }
        return answer;
    }
}
