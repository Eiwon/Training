//지뢰가 있는 지역과 지뢰에 인접한 위, 아래, 좌, 우 대각선 칸을 모두 위험지역으로 분류합니다.
//지뢰는 2차원 배열 board에 1로 표시되어 있고 board에는 지뢰가 매설 된 지역 1과, 지뢰가 없는 지역 0만 존재합니다.
//지뢰가 매설된 지역의 지도 board가 매개변수로 주어질 때, 안전한 지역의 칸 수를 return하도록 solution 함수를 완성해주세요.
//
//제한사항
//board는 n * n 배열입니다.
//1 ≤ n ≤ 100
//지뢰는 1로 표시되어 있습니다.
//board에는 지뢰가 있는 지역 1과 지뢰가 없는 지역 0만 존재합니다.

package solution;

public class SafetyZone {
	public int solution(int[][] board) {
        int answer = 0;
        //위험지역 표시용 boolean 배열 생성
        // board 순회, 1이면 주위 8칸을 true로 변경 => 8칸의 out of boundary 체크필요
        int n = board.length;
        boolean[][] dangerZone = new boolean[n+2][n+2];
        
        for(int y=0; y<n; y++) {
        	for(int x=0; x<n; x++) {
        		if(board[x][y] == 1) {
        			//dangerZone[x+1 -1][y+1 -1]~ [x+1 +1][y+1 +1]
        			for(int j=y; j<y+3; j++)
        				for(int i=x; i<x+3; i++)
        					dangerZone[i][j] = true;
        		}
        	}
        }
        
        for(int y=1; y<n+1; y++) {
        	for(int x=1; x<n+1; x++) {
        		if(dangerZone[x][y] == false)
        			answer++;
        	}
        }
        
        return answer;
    }
}
