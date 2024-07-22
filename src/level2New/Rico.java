package level2New;

import java.util.LinkedList;
import java.util.Queue;

// 상하좌우로 각각 장애물(max+1의 값) 또는 벽이 나올 때까지 이동
// 멈춘 지점의 값이 현재 레벨보다 낮다면 해당 루트 탐색 종료
// BFS
// 멈춘 지점의 값이 max +2면 탐색 종료

public class Rico {
	
	public static void main(String[] args) {
		
		String[] board = {
				"...D..R",
				".D.G...",
				"....D.D",
				"D....D.",
				"..D...."
		};
		
		solution(board);
	}
	
	public static int solution(String[] board) {
		
		int row = board.length, col = board[0].length();
		int max = row * col;
		int[][] solBoard = new int[row][col];
		int[][] direction = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
		int sRow = 0, sCol = 0;
		
		String rowStr;
		char colStr;
		for(int i = 0; i < row; i++) {
			rowStr = board[i];
			for(int j = 0; j < col; j++) {
				colStr = rowStr.charAt(j);
				if(colStr == '.') {
					solBoard[i][j] = max;
				}else if(colStr == 'D') {
					solBoard[i][j] = max + 1;
				}else if(colStr == 'R') {
					solBoard[i][j] = 0;
					sRow = i;
					sCol = j;
				}else if(colStr == 'G') {
					solBoard[i][j] = max + 2;
				}
			}
		}
		
		Queue<RecoPoint> bfsQ = new LinkedList<>();
		bfsQ.add(new RecoPoint(sRow, sCol));
		
		RecoPoint target;
		int move = 0, val = 0, tRow = 0, tCol = 0;
		while(bfsQ.size() > 0) {
			target = bfsQ.poll();
			val = solBoard[target.x][target.y];
			
			for(int[] dir : direction) {
				move = 1;
				
				try {
					while(solBoard[target.x + dir[0] * move][target.y + dir[1] * move] != max +1) {
						move++;
					}
				}catch (IndexOutOfBoundsException e) {
					
				}
				move--;
				tRow = target.x + dir[0] * move;
				tCol = target.y + dir[1] * move;
				
				if(solBoard[tRow][tCol] == max +2) {
					return val +1;
				}else if(solBoard[tRow][tCol] > val + 1) {
					solBoard[tRow][tCol] = val + 1;
					bfsQ.add(new RecoPoint(tRow, tCol));
				}
				}
			}
		
		return -1;
	}
	
}

class RecoPoint{
	int x, y;
	
	RecoPoint(int x, int y){
		this.x = x;
		this.y = y;
	}
}


