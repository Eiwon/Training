package level3;
/*처음에 모든 심사대는 비어있습니다. 한 심사대에서는 동시에 한 명만 심사를 할 수 있습니다. 가장 앞에 서 있는 사람은 비어 있는 심사대로 가서 심사를 받을 수 있습니다. 하지만 더 빨리 끝나는 심사대가 있으면 기다렸다가 그곳으로 가서 심사를 받을 수도 있습니다.

모든 사람이 심사를 받는데 걸리는 시간을 최소로 하고 싶습니다.

입국심사를 기다리는 사람 수 n, 각 심사관이 한 명을 심사하는데 걸리는 시간이 담긴 배열 times가 매개변수로 주어질 때, 모든 사람이 심사를 받는데 걸리는 시간의 최솟값을 return 하도록 solution 함수를 작성해주세요.

제한사항
입국심사를 기다리는 사람은 1명 이상 1,000,000,000명 이하입니다.
각 심사관이 한 명을 심사하는데 걸리는 시간은 1분 이상 1,000,000,000분 이하입니다.
심사관은 1명 이상 100,000명 이하입니다.*/
import java.util.*;
public class CheckIn {
//6	[7, 10]	28
	public static void main(String[] args) {
		solution(6, new int[] {7, 10});
	}
	public static long solution(int n, int[] times) {
        long answer = 0;
        /* 7 10 14 20 21 28 30
         * 우선순위 큐로 times를 내림차순 정렬
         * 꺼낸 값은 다음 시간을 계산해서 다시 큐에 add
         * */
        int guestNum = 0;
        PriorityQueue<Counter> endTime = new PriorityQueue<>((c1, c2) -> ((c1.curEndTime - c2.curEndTime) > 0 ? 1 : -1));
        
        for(int t : times) {
        	endTime.add(new Counter(t));
        }
        while(guestNum < n) {
        	Counter pick = endTime.poll();
        	if(guestNum == n-1) {
        		return pick.curEndTime;
        	}
        	pick.curEndTime += pick.duration;
        	endTime.add(pick);
        	guestNum++;
        	
        }
        
        System.out.println(answer);
        return answer;
    }
}
class Counter{
	long curEndTime;
	int duration;
	
	public Counter(int duration) {
		this.duration = duration;
		curEndTime = duration;
	}
}
