//
//4 ≤ numbers의 길이 ≤ 1,000,000
//1 ≤ numbers[i] ≤ 1,000,000

package level2;

import java.util.*;

public class BackBigNume {
	//[2, 3, 3, 5]	[3, 5, 5, -1]
	//		[9, 1, 5, 3, 6, 2]	[-1, 5, 6, 6, -1, -1]
	public static void main(String[] args) {
		solution(new int[] {9, 1, 5, 3, 6, 2});

	}
	
	public static int[] solution(int[] numbers) {
		int n = numbers.length, back = 0;
        int[] answer = new int[n];
        HashMap<Integer, Integer> shortBig = new HashMap<>();// <값, 가장 가까운 큰 수> 중복된 수는 최신값 1개만 있어도 됨
        // 바로 뒤 숫자와 비교 : 자신보다 큰 수면 그 수가 short big
        //                 ㄴ : 자신보다 작으면 그 수의 short big과 비교, ...
        answer[n-1] = -1;
        shortBig.put(numbers[n -1], -1);
        
        for(int i = n-2; i >=0; i--) {
        	back = numbers[i+1];
        	while(true) {
        		if(back == -1 || numbers[i] < back) {
        			answer[i] = back;
        			shortBig.put(numbers[i], back);
        			break;
        		}
        		back = shortBig.get(back);
        	}
        	
        }
        for(int i=0; i<answer.length; i++)
        	System.out.print(answer[i] + " ");
  
        return answer;
    }
}
