package level2New;

import java.util.*;

public class SubArr {
//[1, 1, 1, 2, 3, 4, 5]	5	[6, 6]
	public static void main(String[] args) {
		solution(new int[] {1, 1, 1, 2, 3, 4, 5}, 5);

	}
	public static int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        Queue<Integer> q = new LinkedList<>();
        int sum = 0, minLen = sequence.length+1;
        
        for(int i = 0; i < sequence.length; i++) {
        	q.add(sequence[i]);
        	sum += sequence[i];
        	while(sum > k) {
        		sum -= q.poll();
        	}
        	if(sum == k && q.size() < minLen) {
        		answer[1] = i;
        		answer[0] = i - q.size() +1; 
        		minLen = q.size();
        	}
        	
        	System.out.println(q.toString());
        }
        System.out.println(answer[0] + ", " + answer[1]);
        
        return answer;
    }
}
