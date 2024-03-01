package level2New;

import java.util.*;
//1 ≤ queue1의 길이 = queue2의 길이 ≤ 300,000
//1 ≤ queue1의 원소, queue2의 원소 ≤ 109
//주의: 언어에 따라 합 계산 과정 중 산술 오버플로우 발생 가능성이 있으므로 long type 고려가 필요합니다.

public class HalfQ {

	public static void main(String[] args) {
		//[3, 2, 7, 2]	[4, 6, 5, 1]	2
		//[1, 2, 1, 2]	[1, 10, 1, 2]	7
		int res = solution(new int[] {1, 1}, new int[] {1, 5});
		System.out.println(res);
	}
	public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sumQ1 = 0, sumQ2 = 0, half = 0;
        
        int n = queue1.length + queue2.length;
        if(n%2 == 1) return -1;
        
        
        for(int i = 0; i < queue1.length; i++) {
        	q1.add(queue1[i]);
        	q2.add(queue2[i]);
        	sumQ1 += queue1[i];
        	sumQ2 += queue2[i];
        }
        half = (sumQ1 + sumQ2) / 2;
        int pick = 0;
        while(answer <= n) {
        	if(sumQ1 == sumQ2) {
        		return answer;
        	}
        	answer++;
        	if(sumQ1 > sumQ2) {
        		pick = q1.poll();
        		sumQ1 -= pick;
        		q2.add(pick);
        		sumQ2 += pick;
        	}else {
        		pick = q2.poll();
        		sumQ1 += pick;
        		q1.add(pick);
        		sumQ2 -= pick;
        	}
        }
        
        return -1;
    }
}
