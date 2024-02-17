//1. 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
//2. 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
//3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
//  3.1 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료됩니다.
//  현재 실행 대기 큐(Queue)에 있는 프로세스의 중요도가 순서대로 담긴 배열 priorities와, 몇 번째로 실행되는지 알고싶은 프로세스의 위치를 알려주는 location이 매개변수로 주어질 때, 해당 프로세스가 몇 번째로 실행되는지 return 하도록 solution 함수를 작성해주세요.
//
//제한사항
//priorities의 길이는 1 이상 100 이하입니다.
//priorities의 원소는 1 이상 9 이하의 정수입니다.
//priorities의 원소는 우선순위를 나타내며 숫자가 클 수록 우선순위가 높습니다.
//location은 0 이상 (대기 큐에 있는 프로세스 수 - 1) 이하의 값을 가집니다.
//priorities의 가장 앞에 있으면 0, 두 번째에 있으면 1 … 과 같이 표현합니다.

package level2;
import java.util.*;
// Map.Entry<,> 를 활용한 q
public class ProcessSch {
//[1, 1, 9, 1, 1, 1]	0
	public static void main(String[] args) {
		solution(new int[] {1, 1, 9, 1, 1, 1}, 0);

	}
	public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Map.Entry<Integer, Integer>> q = new LinkedList();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        
        for(int i = 0; i < priorities.length; i++) {
        	pq.add(priorities[i]);
        	q.add(Map.entry(i, priorities[i]));
        }
        while(!q.isEmpty()){
        	Map.Entry<Integer, Integer> pick = q.poll();
        	System.out.println("pq : " + pq.toString());
        	if(pick.getValue() == pq.peek()) {
        		answer++;
        		if(pick.getKey() == location) {
        			break;
        		}
        		pq.poll();
        	}else {
        		q.add(pick);
        	}
        }
        
        System.out.println(answer);
        
        return answer;
    }
}
