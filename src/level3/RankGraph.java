package level3;
import java.util.*;
public class RankGraph {

	public static void main(String[] args) {
		solution(5, new int[][] {{4,3}, {4,2}, {3,2}, {1,2}, {2,5}});
//5	[[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]	2
	}
	public static int solution(int n, int[][] results) {
        int answer = 0;
        // 어떤 노드를 탐색할 수 있는 노드의 수
        // 모든 노드에 대하여, 모든 하위 노드를 방문, 첫 방문시 visited++
        // 5 - 2 - 3- 4
        // 	   ㄴ  1
        int[] win = new int[n+1];
        Record[] records = new Record[n+1];
        for(int i = 0; i < n+1; i++) {
        	records[i] = new Record(i);
        }
        
        for(int[] result : results) {
        	records[result[0]].losers.add(records[result[1]]);
        }
        
        for(int i = 1; i < n+1; i++) {
        	records[i].explore(new boolean[n+1]);
        }
        
        Arrays.sort(records, (r1, r2) -> (r2.visited - r1.visited));
        
        
        int num = n;
        for(int i = 0; i < n; i++) {
        	System.out.println(i + " : " + records[i].visited);
        	if(records[i].visited == n--) {
        		answer++;
        	}else break;
        }
        System.out.println(answer);
        
        return answer;
    }
}

class Record{
	int num;
	int visited;
	List<Record> losers;
	
	public Record(int num) {
		this.num = num;
		visited = 0;
		losers = new ArrayList<>();
	}
	
	public void explore(boolean[] explored) {
		if(explored[num] == true) return;
		else visited++;
		explored[num] = true;
		for(Record record : losers) {
			if(explored[record.num] == false) {
				record.explore(explored);
			}
		}
	}
}


