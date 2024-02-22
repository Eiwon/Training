package level2;

import java.util.*;

public class Scoville {
//[1, 2, 3, 9, 10, 12]	7	2
	public static void main(String[] args) {
		solution(new int[] {1, 2, 3, 9, 10, 12}, 7);

	}
	
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i< scoville.length; i++) {
        	pq.add(scoville[i]);
        }
        
        int pick = pq.poll();
        
        while(pick < K) {
        	pick = pick + pq.poll() *2;
        	answer++;
        	pq.add(pick);
        	pick = pq.poll();
        	if(pq.size() == 0 && pick < K) return -1; 
        	// K 이하로 만들 수 없을 때 == 하나 남은 원소가 K보다 작을때
        }
        
        return answer;
    }
}
