package level2New;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*세로길이가 n 가로길이가 m인 격자 모양의 땅 속에서 석유가 발견되었습니다. 석유는 여러 덩어리로 나누어 묻혀있습니다. 
 * 당신이 시추관을 수직으로 단 하나만 뚫을 수 있을 때, 가장 많은 석유를 뽑을 수 있는 시추관의 위치를 찾으려고 합니다. 
 * 시추관은 열 하나를 관통하는 형태여야 하며, 열과 열 사이에 시추관을 뚫을 수 없습니다.
 * 석유가 묻힌 땅과 석유 덩어리를 나타내는 2차원 정수 배열 land가 매개변수로 주어집니다. 
 * 이때 시추관 하나를 설치해 뽑을 수 있는 가장 많은 석유량을 return 하도록 
 * solution 함수를 완성해 주세요.

제한사항
1 ≤ land의 길이 = 땅의 세로길이 = n ≤ 500
1 ≤ land[i]의 길이 = 땅의 가로길이 = m ≤ 500
land[i][j]는 i+1행 j+1열 땅의 정보를 나타냅니다.
land[i][j]는 0 또는 1입니다.
land[i][j]가 0이면 빈 땅을, 1이면 석유가 있는 땅을 의미합니다.
정확성 테스트 케이스 제한사항
1 ≤ land의 길이 = 땅의 세로길이 = n ≤ 100
1 ≤ land[i]의 길이 = 땅의 가로길이 = m ≤ 100
효율성 테스트 케이스 제한사항
주어진 조건 외 추가 제한사항 없습니다.*/
public class Democracy {
	
	public static void main(String[] args) {
		int[][] land = {
				{1, 0, 1, 0, 1, 1},
				{1, 0, 1, 0, 0, 0},
				{1, 0, 1, 0, 0, 1},
				{1, 0, 0, 1, 0, 0},
				{1, 0, 0, 1, 0, 1},
				{1, 0, 0, 0, 0, 0},
				{1, 1, 1, 1, 1, 1}
				};
		solution(land);
	}

	public static int solution(int[][] land) {
        int answer = 0;
        Land target = new Land(land);
        
        for(int col = 0; col < land[0].length; col++) {
        	answer = Math.max(answer, target.picking(col));
        }
        
        return answer;
    }
}

class Land {
	int[][] land;
	Map<Integer, Integer> massMap;
	int massCode = 1;
	
	public Land(int[][] land) {
		this.land = land;
		this.massMap = new HashMap<>();
		calcMass();
	}
	
	private void calcMass() {
		Queue<Block> bfsQ = new LinkedList<>();
		int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		int mass = 0;
		Block pick = null;
		
		for(int row = 0; row < land.length; row++) {
			for(int col = 0; col < land[0].length; col++) {
				if(land[row][col] == 1) {
					massCode++;
					bfsQ.add(new Block(row, col));
					land[row][col] = massCode;
					mass = 0;
					
					while(bfsQ.size() > 0) {
						pick = bfsQ.poll();
						mass++;
						
						for(int[] direct : direction) {
							try {
								if(land[pick.x + direct[0]][pick.y + direct[1]] == 1) {
									land[pick.x + direct[0]][pick.y + direct[1]] = massCode;
									bfsQ.add(new Block(pick.x + direct[0], pick.y + direct[1]));
								}
							}catch(ArrayIndexOutOfBoundsException e) {
							}
						}
					}
					massMap.put(massCode, mass);
				}
			}
		}
		
	}

	public int picking(int col) {
		Set<Integer> pickingCode = new HashSet<>();
		int sum = 0;
		
		for(int row = 0; row < land.length; row++) {
			if(land[row][col] != 0) {
				pickingCode.add(land[row][col]);
			}
		}
		
		for(int code : pickingCode) {
			sum += massMap.get(code);
		}
		
		return sum;
	}
}

class Block{
	int x, y;
	
	public Block(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

