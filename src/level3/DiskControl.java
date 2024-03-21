package level3;
/*각 작업에 대해 [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 배열 jobs가 매개변수로 주어질 때, 작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마가 되는지 return 하도록 solution 함수를 작성해주세요. (단, 소수점 이하의 수는 버립니다)

제한 사항
jobs의 길이는 1 이상 500 이하입니다.
jobs의 각 행은 하나의 작업에 대한 [작업이 요청되는 시점, 작업의 소요시간] 입니다.
각 작업에 대해 작업이 요청되는 시간은 0 이상 1,000 이하입니다.
각 작업에 대해 작업의 소요시간은 1 이상 1,000 이하입니다.
하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리합니다.*/
import java.util.*;

public class DiskControl {
//[[0, 3], [1, 9], [2, 6]]	9
	public static void main(String[] args) {
		solution(new int[][] {{0, 3}, {1, 9}, {2, 6}});

	}
	public static int solution(int[][] jobs) {
        int answer = 0;
        // 작업 중일 때 들어온 작업은 pq에 등록, pq는 (현재 작업 종료시간 + 소요시간 - 요청시점) 순으로 오름차순 정렬
        // 작업이 끝나면 pq에서 작업을 꺼내 실행
        PriorityQueue<Job> waitQ = new PriorityQueue<>((j1, j2) -> (j1.reqTime - j2.reqTime));
        PriorityQueue<Job> scheduler = new PriorityQueue<>((j1, j2) -> (j1.workTime - j2.workTime));
        //scheduler.add(new Job(jobs[0]));
        int second = 0;
        Job job;
        for(int i= 0; i < jobs.length; i++) {
        	waitQ.add(new Job(jobs[i]));
        }
        while(waitQ.size() > 0 && waitQ.peek().reqTime <= second) {
			scheduler.add(waitQ.poll());
		}
        while(waitQ.size() > 0 || scheduler.size() > 0) {
        	while(waitQ.size() > 0 && waitQ.peek().reqTime <= second) {
    			scheduler.add(waitQ.poll());
    		}
        	if(scheduler.size() > 0 && second >= scheduler.peek().reqTime) {
        		// 수행가능한 작업이 있으면 1개 꺼내서 처리
        		job = scheduler.poll();
        		answer += second + job.workTime - job.reqTime;
        		second += job.workTime;
        	}else {
        		second++;
        	} // 수행 가능한 작업이 없으면 시간 ++
        }
        System.out.println(answer / jobs.length);
        return answer;
    }
}
class Job{
	int reqTime;
	int workTime;
	public Job(int[] info) {
		this.reqTime = info[0];
		this.workTime = info[1];
	}
	public String toString() {
		return "[" + reqTime + ":" + workTime +"]"; 
	}
}
