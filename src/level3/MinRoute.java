package level3;

import java.util.*;
public class MinRoute {

	public static void main(String[] args) {
		solution(new int[][] {
			{0,0,0,0,0,0},
			{0,1,1,1,1,0},
			{0,0,1,0,0,0},
			{1,0,0,1,0,1},
			{0,1,0,0,0,1},
			{0,0,0,0,0,0}
		});
	}
	//[[0,0,0,0,0,0],[0,1,1,1,1,0],[0,0,1,0,0,0],[1,0,0,1,0,1],[0,1,0,0,0,1],[0,0,0,0,0,0]]	3200
	public static int solution(int[][] board) {
	    int answer = 0;
	    int[][] dir = {{1,0}, {-1, 0}, {0,1}, {0,-1}};
	    // 직선 100원 곡선 500원
	    // direction 1 = 벽, 2 = 좌우, 3 = 상하
	    int side = board.length;
	    Road[][] roadMap = new Road[side][side];
	    Queue<Road> plan = new LinkedList<>();

	    for(int x = 0; x < side; x++) {
	    	for(int y = 0; y < side; y++) {
	    		roadMap[x][y] = new Road(x, y, board[x][y]);
	    	}
	    }
	    plan.add(roadMap[0][0]);
	    Road road, next;
	    while(plan.size() > 0) {
	    	road = plan.poll();
	    	// 4방향 확인, 벽이 아니고, minCost가 0이거나 자신보다 큰 경우
	    	for(int i=0; i<4; i++) {
	    		next = roadMap[road.x + dir[i][0]][road.y + dir[i][1]];
//	    		if(next.direction != 1 && (next.minCost == 0 || next.minCost > road.minCost){
//	    			
//	    		}
	    	}
	    	
	    }
	    
	    
	    // 각 칸의 도로형태가 다음 칸에 영향
	    // 기본은 직선도로로 생각하고 비용 설정, 
	    // x,y의 최소비용 = 인접 visited 칸의 최소비용 +100 (인접 칸의 도로 방향이 1이면 좌우의 칸에는 +400으로 비교, 0이면 상하 칸에는 +400으로 비교)
	    
	    // 각 칸을 선택해 상하좌우의 이동가능, 비용이 0이거나 부여할 값보다 큰 칸에 방향에 따라 다른 값 부여,
	    
	    return answer;
	}
	
}
class Road{
	int x;
	int y;
	int direction;
	int minCost;
	
	public Road(int x, int y, int direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
	public boolean compareToGo(Road next) {
		if(next.direction == 1) {
			return false;
		}else {
		}
		
		return false;
	}
}
