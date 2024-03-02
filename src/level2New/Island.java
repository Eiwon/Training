package level2New;

import java.util.Arrays;

public class Island {
//["X591X","X1X5X","X231X", "1XXX1"]	[1, 1, 27]
	public static void main(String[] args) {
		String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
		solution(maps);

	}
	// 각 섬의 foodsum 을 저장할 arrayList = islandInfo
	// 모든 X에 group[][] = -1 부여
	// maps의 각 칸에 대하여, group[][]이 정해지지 않았다면,
	// groupNum에 해당하는 그룹을 부여하고, groupNum++, 상하좌우의 x가 아닌 칸에 대하여 재귀 수행
	
	public static int[] solution(String[] maps) {
        int[] answer = {};
        int[][] group = new int[maps.length][maps[0].length()];
        int groupNum = 0;
        
        for(int i=0; i < maps.length; i++) {
        	for(int j=0; j < maps[i].length(); j++) {
        		if(maps[i].charAt(j) == 'X') {
        			group[i][j] = -1;
        		}
        	}
        }
        for(int i=0; i < maps.length; i++) {
        	for(int j=0; j < maps[i].length(); j++) {
        		if(group[i][j] == 0) {
        			groupNum++;
        			conquer(group, i, j, groupNum);
        		}
        	}
        }
        
        if(groupNum == 0) return new int[]{-1};
        answer = new int[groupNum];
        
        for(int i=0; i < maps.length; i++) {
        	for(int j=0; j < maps[i].length(); j++) {
        		if(group[i][j] > 0) {
        			answer[group[i][j]-1] += Character.getNumericValue(maps[i].charAt(j));
        		}
        	}
        }
        Arrays.sort(answer);
        
        return answer;
    }
	private static void conquer(int[][] group, int i, int j, int groupNum) {
		int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
		
		try {
			if(group[i][j] == 0) {
				group[i][j] = groupNum;
			}else {
				return;
			}
		}catch(Exception e) {
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			conquer(group, i + dir[d][0], j + dir[d][1], groupNum);
		}
		
		return;
	}
	
}

