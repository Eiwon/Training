/*회사원 Demi는 가끔은 야근을 하는데요, 야근을 하면 야근 피로도가 쌓입니다. 
 * 야근 피로도는 야근을 시작한 시점에서 남은 일의 작업량을 제곱하여 더한 값입니다. 
 * Demi는 N시간 동안 야근 피로도를 최소화하도록 일할 겁니다.Demi가 1시간 동안 작업량 1만큼을 처리할 수 있다고 할 때,
 *  퇴근까지 남은 N 시간과 각 일에 대한 작업량 works에 대해 야근 피로도를 최소화한 값을 
 *  리턴하는 함수 solution을 완성해주세요.

제한 사항
works는 길이 1 이상, 20,000 이하인 배열입니다.
works의 원소는 50000 이하인 자연수입니다.
n은 1,000,000 이하인 자연수입니다.
입출력 예
works	n	result
[4, 3, 3]	4	12
[2, 1, 2]	1	6
[1,1]	3	0*/

package level3;
import java.util.*;
public class TiredScore {

	public static void main(String[] args) {
		solution(3, new int[] {1, 1});
	}
	public static long solution(int n, int[] works) {
        long answer = 0;
        int pick = 0;
        int reduce = 0;
        PriorityQueue<Integer> remains = new PriorityQueue<>((a, b) -> (b - a));
        for(int w : works) {
        	remains.add(w);
        }
        
        while(n > 0) {
        	if(remains.size() == 0) // 큐가 비었으면 종료
        		break;
        	pick = remains.poll(); // 최대값 선택
  
        	if(remains.size() == 0) {// 다음 값이 없으면 n만큼 감소시키고 다시 add
        		reduce = n;
        	}else {// 다음 값이 있으면 (자신과 다음값의 차이 +1)과 n 중 더 작은 값만큼 n과 자신 감소, 다시 add
        		reduce = Math.min(((pick - remains.peek()) +1), n);
        	}
        	n -= reduce;
        	pick -= reduce;
        	if(pick > 0)
        		remains.add(pick);
        }
        
        while(remains.size() > 0) {
        	pick = remains.poll();
        	answer += pick * pick;
        }
        System.out.println(answer);
        
        return answer;
    }
}
