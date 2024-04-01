package level3;
/*지점갯수 n은 3 이상 200 이하인 자연수입니다.
지점 s, a, b는 1 이상 n 이하인 자연수이며, 각기 서로 다른 값입니다.
즉, 출발지점, A의 도착지점, B의 도착지점은 서로 겹치지 않습니다.
fares는 2차원 정수 배열입니다.
fares 배열의 크기는 2 이상 n x (n-1) / 2 이하입니다.
예를들어, n = 6이라면 fares 배열의 크기는 2 이상 15 이하입니다. (6 x 5 / 2 = 15)
fares 배열의 각 행은 [c, d, f] 형태입니다.
c지점과 d지점 사이의 예상 택시요금이 f원이라는 뜻입니다.
지점 c, d는 1 이상 n 이하인 자연수이며, 각기 서로 다른 값입니다.
요금 f는 1 이상 100,000 이하인 자연수입니다.
fares 배열에 두 지점 간 예상 택시요금은 1개만 주어집니다. 즉, [c, d, f]가 있다면 [d, c, f]는 주어지지 않습니다.
출발지점 s에서 도착지점 a와 b로 가는 경로가 존재하는 경우만 입력으로 주어집니다.*/
import java.util.*;

public class ShareFares {

	public static void main(String[] args) {
		solution(6, 4, 6, 2, new int[][] {
			{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50},
			{2, 4, 66}, {2, 3, 22}, {1, 6, 25}});
	}
	//6	4	6	2	
	//[[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66],
	//[2, 3, 22], [1, 6, 25]]	82
	public static int solution(int n, int s, int a, int b, int[][] fares) {
        // s에서 ? 지점까지의 최소비용 + ?에서 a까지, ?에서 b까지의 최소비용 합
		// 모든 노드에 대해, 각 노드에 대한 최소비용 계산	(다익스트라)
		int answer = 0;
		int[][] map = new int[n+1][n+1];
		Road[] roads = new Road[fares.length];
		for(int i=0; i < fares.length; i++) {
			roads[i] = new Road(fares[i][0], fares[i][1], fares[i][2]);
		}
//        Arrays.sort(roads, (r1, r2) -> (r1.expense - r2.expense));
//        
//        int minDis;
//        for(Road road : roads) {
//        	minDis = Math.min(map[road.start][road.end], road.expense);
//        	map[road.start][road.end] = minDis;
//        	map[road.end][road.start] = minDis;
//        }
		
        return answer;
    }
}
//class Road {
//	int start;
//	int end;
//	int expense;
//	
//	public Road(int start, int end, int expense) {
//		this.start = start;
//		this.end = end;
//		this.expense = expense;
//	}
//}



