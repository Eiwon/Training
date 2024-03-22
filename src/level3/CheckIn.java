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
		solution(6, new int[] {7, 10, 15, 20});
	}
	public static long solution(int n, int[] times) {
        long answer = 0;
        // 7 10 14 20 21 28 30 35 40 42
        // n이 정답이 될 수 있는 시간인지 확인하는 법 =
        // = times[i]의 원소 중 나누어떨어지는 값이 있어야함+
        // 각 원소로 나눈 몫의 합이 n보다 큰 수 중 최솟값
        // 26 27 28
        Arrays.sort(times);
        long curMinTime = (long)times[0] *n;
        long minTime = 0;
        long center = 0;
        long expected;
        while(true) {
        	System.out.println("-------------");
        	center = (curMinTime + minTime) /2;
        	System.out.println("center : " + center);
        	expected = 0;
        	for(int t : times) {
        		expected += center / t;
        	}
        	System.out.println("expected : " + expected);
        	if(expected < n) {
        		minTime = center +1;
        	}else {
        		curMinTime = center;
        	}
        	System.out.println(minTime + " ~ " + curMinTime);
        	if(curMinTime == minTime) {
        		answer = curMinTime;
        		break;
        	}
        }
        
        System.out.println(answer);
        return answer;
    }
}

