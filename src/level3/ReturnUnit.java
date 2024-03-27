package level3;
/*강철부대가 위치한 지역을 포함한 총지역의 수 n, 두 지역을 왕복할 수 있는 길 정보를 담은 2차원 정수 배열 roads, 각 부대원이 위치한 서로 다른 지역들을 나타내는 정수 배열 sources, 강철부대의 지역 destination이 주어졌을 때, 주어진 sources의 원소 순서대로 강철부대로 복귀할 수 있는 최단시간을 담은 배열을 return하는 solution 함수를 완성해주세요. 복귀가 불가능한 경우 해당 부대원의 최단시간은 -1입니다.

제한사항
3 ≤ n ≤ 100,000
각 지역은 정수 1부터 n까지의 번호로 구분됩니다.
2 ≤ roads의 길이 ≤ 500,000
roads의 원소의 길이 = 2
roads의 원소는 [a, b] 형태로 두 지역 a, b가 서로 왕복할 수 있음을 의미합니다.(1 ≤ a, b ≤ n, a ≠ b)
동일한 정보가 중복해서 주어지지 않습니다.
동일한 [a, b]가 중복해서 주어지지 않습니다.
[a, b]가 있다면 [b, a]는 주어지지 않습니다.
1 ≤ sources의 길이 ≤ 500
1 ≤ sources[i] ≤ n
1 ≤ destination ≤ n*/
import java.util.*;

public class ReturnUnit {
//5	[[1, 2], [1, 4], [2, 4], [2, 5], [4, 5]]	[1, 3, 5]	5	[2, -1, 0]
	public static void main(String[] args) {
		solution(5, new int[][] {{1,2}, {1,4}, {2,4}, {2,5}, {4,5}}, new int[] {1, 3, 5}
		, 5);
	}
	public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        // n+1 크기의 배열 생성, 배열에는 각 지역 번호에 해당하는 노드 추가
        // 노드에는 최단거리(디폴트 -1), 연결된 노드 번호 리스트
        //destination에서 시작, destination으로 가는 최단거리 탐색(BFS)
        Area[] areaList = new Area[n+1];
        for(int i = 1; i < areaList.length; i++) {
        	areaList[i] = new Area();
        }
        for(int[] road : roads) {
        	areaList[road[0]].adj.add(road[1]);
        	areaList[road[1]].adj.add(road[0]);
        }
        
        Queue<Integer> nextExplode = new LinkedList<>();
        
        areaList[destination].distance = 0;
        nextExplode.add(destination);
        Area pick;
        List<Integer> adj; 
        while(nextExplode.size() > 0) {
        	pick = areaList[nextExplode.poll()];
        	adj = pick.adj;
        	for(int i=0; i< adj.size(); i++) {
        		if(areaList[adj.get(i)].distance == -1) {
        			areaList[adj.get(i)].distance = pick.distance +1; 
        			nextExplode.add(adj.get(i));
        		}
        	}
        }
        
        for(int i = 0; i < sources.length; i++) {
        	answer[i] = areaList[sources[i]].distance;
        }
        
        return answer;
    }
}
class Area{
	public int distance;
	public List<Integer> adj;
	
	public Area() {
		this.distance = -1;
		this.adj = new ArrayList<>();
	}
}






