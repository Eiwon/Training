package level2New;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 1 x 1 크기의 칸들로 이루어진 직사각형 격자 형태의 미로에서 탈출하려고 합니다. 각 칸은 통로 또는 벽으로 구성되어 있으며, 벽으로 된 칸은 지나갈 수 없고 통로로 된 칸으로만 이동할 수 있습니다. 통로들 중 한 칸에는 미로를 빠져나가는 문이 있는데, 이 문은 레버를 당겨서만 열 수 있습니다. 레버 또한 통로들 중 한 칸에 있습니다. 따라서, 출발 지점에서 먼저 레버가 있는 칸으로 이동하여 레버를 당긴 후 미로를 빠져나가는 문이 있는 칸으로 이동하면 됩니다. 이때 아직 레버를 당기지 않았더라도 출구가 있는 칸을 지나갈 수 있습니다. 미로에서 한 칸을 이동하는데 1초가 걸린다고 할 때, 최대한 빠르게 미로를 빠져나가는데 걸리는 시간을 구하려 합니다.

미로를 나타낸 문자열 배열 maps가 매개변수로 주어질 때, 미로를 탈출하는데 필요한 최소 시간을 return 하는 solution 함수를 완성해주세요. 만약, 탈출할 수 없다면 -1을 return 해주세요.

제한사항
5 ≤ maps의 길이 ≤ 100
5 ≤ maps[i]의 길이 ≤ 100
maps[i]는 다음 5개의 문자들로만 이루어져 있습니다.
S : 시작 지점
E : 출구
L : 레버
O : 통로
X : 벽
시작 지점과 출구, 레버는 항상 다른 곳에 존재하며 한 개씩만 존재합니다.
출구는 레버가 당겨지지 않아도 지나갈 수 있으며, 모든 통로, 출구, 레버, 시작점은 여러 번 지나갈 수 있습니다.
*/
// 레버까지의 최단경로, 레버에서 출구까지의 최단 경로
// bfs로 레버에서부터 입구, 출구까지의 최단경로 찾
//
public class DoubleShortest {
	
	private static String[] maps = {
			"SOOOL",
			"XXXXO",
			"OOOOO",
			"OXXXX",
			"OOOOE"
	};
	private static String[] maps2 = {
			"LOOXS",
			"OOOOX",
			"OOOOO",
			"OOOOO",
			"EOOOO"
	};
	
	public static void main(String[] args) {
		solution(maps2);
	}
	
	private static int solution(String[] maps) {
		int answer = 0;
		int rowLen = maps.length, colLen = maps[0].length();
		int maxDistance = rowLen * colLen;
		int[][] map = new int[rowLen][colLen];
		Point start = null, end = null, lab = null;
		String word;
		char c;
		
		for(int row = 0; row < rowLen; row++) {
			word = maps[row];
			for(int col = 0; col < colLen; col++) {
				c = word.charAt(col);
				if(c == 'X') {
					map[row][col] = -1;
				}else {
					map[row][col] = maxDistance;
					if(c == 'S') {
						start = new Point(row, col);
					}else if(c == 'E'){
						end = new Point(row, col);
					}else if(c == 'L') {
						lab = new Point(row, col);
						map[row][col] = 0;
					}
				}
			}
		}
		
		Queue<Point> explode = new LinkedList<>();
		explode.add(lab);
		
		Point pick = null;
		int nextVal = 0;
		while(explode.size() > 0) {
			pick = explode.poll();
			nextVal = map[pick.x][pick.y] +1;
			// 상하좌우 검사
			if(pick.x > 0 && map[pick.x -1][pick.y] > nextVal) {
				map[pick.x -1][pick.y] = nextVal;
				explode.add(new Point(pick.x -1, pick.y));
			}
			if(pick.x < rowLen -1 && map[pick.x +1][pick.y] > nextVal) {
				map[pick.x +1][pick.y] = nextVal;
				explode.add(new Point(pick.x +1, pick.y));
			}
			if(pick.y > 0 && map[pick.x][pick.y -1] > nextVal) {
				map[pick.x][pick.y -1] = nextVal;
				explode.add(new Point(pick.x, pick.y -1));
			}
			if(pick.y < colLen -1 && map[pick.x][pick.y +1] > nextVal) {
				map[pick.x][pick.y +1] = nextVal;
				explode.add(new Point(pick.x, pick.y +1));
			}
		}
		

		for(int row = 0; row < rowLen; row++) {
			for(int col = 0; col < colLen; col++) {
				System.out.print(map[row][col] + "\t");
			}
			System.out.println();
		}
		
		int startDistance = map[start.x][start.y];
		int endDistance = map[end.x][end.y];
		
		answer = 
			(startDistance == maxDistance || endDistance == maxDistance) ?
					-1 : startDistance + endDistance;
				
		System.out.println(answer);
		return answer;
	}
	
}

class Point {
	int x, y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

