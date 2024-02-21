//maps는 n x m 크기의 게임 맵의 상태가 들어있는 2차원 배열로, n과 m은 각각 1 이상 100 이하의 자연수입니다.
//n과 m은 서로 같을 수도, 다를 수도 있지만, n과 m이 모두 1인 경우는 입력으로 주어지지 않습니다.
//maps는 0과 1로만 이루어져 있으며, 0은 벽이 있는 자리, 1은 벽이 없는 자리를 나타냅니다.
//처음에 캐릭터는 게임 맵의 좌측 상단인 (1, 1) 위치에 있으며, 상대방 진영은 게임 맵의 우측 하단인 (n, m) 위치에 있습니다.
//너비 우선 탐색
package level2;

import java.util.*;

public class ShortestPath {
//[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]	11
	
	
	public static void main(String[] args) {
		int[][] maps = {
				{1,0,1,1,1},
				{1,0,1,0,1}, 
				{1,0,1,1,1},
				{1,1,1,0,1}, 
				{0,0,0,0,1}};
		solution(maps);
	}
	
	public static int solution(int[][] maps) {
        int answer = 0;
        // distance[0][0]을 q에 넣음
        // q의 값을 하나씩 제거하면서, 그 인접 칸 (이동 가능칸) 탐사
        // distance가 0이거나 현 최단거리+1보다 크면 현재 칸 distance+1 넣고 큐에 add
        // add할 칸이 마지막 칸이면 종료, 더이상 0인 칸을 못찾아도 종료
        int n = maps.length, m = maps[0].length;
        int[][] sDistance = new int[n][m];
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<Map.Entry<Integer, Integer>> exploded = new LinkedList<>();
        Map.Entry<Integer, Integer> current;
        int nextX, nextY;
        
        sDistance[0][0] = 1;
        exploded.add(Map.entry(0, 0));
        while(exploded.size() != 0) {
        	current = exploded.poll();
        	for(int i=0; i<direction.length; i++) {
        		nextX = current.getKey() + direction[i][0];
        		nextY = current.getValue() + direction[i][1];
        		try {
        			if(maps[nextX][nextY] != 0 && sDistance[nextX][nextY] == 0) {
        				sDistance[nextX][nextY] = sDistance[current.getKey()][current.getValue()] +1;
        				exploded.add(Map.entry(nextX, nextY));
        			}
        		} catch(ArrayIndexOutOfBoundsException e) {
        			continue;
        		}
        	}
        }
        
        answer  = sDistance[n-1][m -1];
        if(answer == 0)	answer = -1;
        
        return answer;
    }
	
	
}
