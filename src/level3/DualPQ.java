package level3;
/*operations는 길이가 1 이상 1,000,000 이하인 문자열 배열입니다.
operations의 원소는 큐가 수행할 연산을 나타냅니다.
원소는 “명령어 데이터” 형식으로 주어집니다.- 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.
빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.
I 숫자	큐에 주어진 숫자를 삽입합니다.
D 1	큐에서 최댓값을 삭제합니다.
D -1	큐에서 최솟값을 삭제합니다.
operations	return
["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]	[0,0]
["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]	[333, -45]
 * */
import java.util.*;
public class DualPQ {
	private static PriorityQueue<Integer>[] pq = null;
	
	public static void main(String[] args) {
		solution(new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
	}
	public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        pq = new PriorityQueue[2];
        pq[0] = new PriorityQueue<>(); // 최소값
        pq[1] = new PriorityQueue<>((a, b) -> (b - a)); // 최대값
        
        for(String op : operations) {
        	String[] command = op.split(" ");
        	int num = Integer.parseInt(command[1]);
        	if(command[0].equals("I")) {
        			pq[0].add(num);
        	}else {
        		if(num < 0) {
        			getMin();
        		}else {
        			getMax();
        		}
        	}
        }
        answer[0] = getMax();
        answer[1] = getMin();
        System.out.println(answer[0] + ", " + answer[1]);
        
        return answer;
    }
	
	private static int getMax() {
		int res = 0;
		while(pq[0].size() != 0) {
			pq[1].add(pq[0].poll());
		}
		if(pq[1].size() > 0)
			res = pq[1].poll();
		return res;
	}
	
	private static int getMin() {
		int res = 0;
		while(pq[1].size() != 0) {
			pq[0].add(pq[1].poll());
		}
		if(pq[0].size() > 0)
			res = pq[0].poll();
		return res;
	}
}
