//maps는 n x m 크기의 게임 맵의 상태가 들어있는 2차원 배열로, n과 m은 각각 1 이상 100 이하의 자연수입니다.
//n과 m은 서로 같을 수도, 다를 수도 있지만, n과 m이 모두 1인 경우는 입력으로 주어지지 않습니다.
//maps는 0과 1로만 이루어져 있으며, 0은 벽이 있는 자리, 1은 벽이 없는 자리를 나타냅니다.
//처음에 캐릭터는 게임 맵의 좌측 상단인 (1, 1) 위치에 있으며, 상대방 진영은 게임 맵의 우측 하단인 (n, m) 위치에 있습니다.

package level2;

public class ShortestPath {
//[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]	11
	
	
	public static void main(String[] args) {
		solution(new int[][] {
			{1,0,1,1,1}, 
			{1,0,1,0,1}, 
			{1,0,1,1,1}, 
			{1,1,1,0,1}, 
			{0,0,0,0,1}
			});
	}
	
	public static int solution(int[][] maps) {
        int answer = 0;
        //dp
        // n,n 최단 거리 = 상하좌우 칸의 최단거리 +1
        // 0,0에서 시작. 
        // 상하좌우 확인, (그 중 0이 아닌 최소값 +1)로 값 변경, 벽이 아닌 칸으로 이동.
        // 주위가 벽이거나 최단거리 값이 더 큰 칸이 없으면 return
        int n = maps.length, m = maps[0].length;
        int[][] sDistance = new int[n][m];
        
        sDistance[0][0] = 1;
        explore(0, 0, sDistance, maps);
        answer  = sDistance[n-1][m -1];
        if(answer == 0)	answer = -1;
//        
//        for(int i = 0; i < n; i++) {
//        	for(int j = 0; j < m; j++) {
//        		System.out.print(sDistance[i][j] + "  ");
//        	}
//        	System.out.println();
//        }
//        
        return answer;
    }
	// 상하좌우 확인, 주위에 최단거리가 현재 칸+1보다 더 큰 값이 있다면 변경, 해당 칸에 다음 재귀 실행
	//    ㄴ  0인 칸이 있다면 현재 칸+1로 변경하고 해당 칸에 다음 재귀 실행
	//    ㄴ 주위가 벽이거나 최단거리가 현재 칸+1보다 작거나 같다면 재귀 종료
	public static void explore(int x, int y, int[][] sDistance, int[][] maps) {
		int[][] direction = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};// 우하상좌
		int check, nextX, nextY;
		for(int i = 0; i < 4; i++) {
			nextX = x + direction[i][0];
			nextY = y + direction[i][1];
			if(nextX >= 0 && nextX < sDistance.length && nextY >= 0 && nextY < sDistance[0].length) {
				check = sDistance[nextX][nextY];
				if(maps[x][y] == 1 && (check == 0 || check > sDistance[x][y]+1)) {
					sDistance[nextX][nextY] = sDistance[x][y] +1;
					
					explore(nextX, nextY, sDistance, maps);
				}
			}
		}
		return;
	}
	
}
