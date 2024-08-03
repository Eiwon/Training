package level2New;

public class RotateArray {

	public static void main(String[] args) {
		int rows = 6, columns = 6;
		int[][] queries = {
				{2, 2, 5, 4},
				{3, 3, 6, 6},
				{5, 1, 6, 3}
				};
		solution(rows, columns, queries);
	}

	public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows][columns];
        
        int idx = 1;
        for(int row = 0; row < rows; row++) {
        	for(int col = 0; col < columns; col++) {
        		map[row][col] = idx++;
        	}
        }
        
        idx = 0;
        for(int[] query : queries) {
        	answer[idx++] = rotate(query, map);
        	for(int row = 0; row < rows; row++) {
            	for(int col = 0; col < columns; col++) {
            		System.out.print(map[row][col] + "\t");
            	}
            	System.out.println();
            }
        	System.out.println(answer[idx -1]);
        }
        
        return answer;
    }
	
	public static int rotate(int[] query, int[][] map) {
		int startX = query[0] - 1, startY = query[1] - 1;
		int endX = query[2] - 1, endY = query[3] - 1;
		
		int cur, min = Integer.MAX_VALUE, prev = map[startX + 1][startY];
		for(int i = startY; i <= endY; i++) {
			cur = map[startX][i];
			map[startX][i] = prev;
			if(prev < min) min = prev;
			prev = cur;
		}
		for(int i = startX + 1; i <= endX; i++) {
			cur = map[i][endY];
			map[i][endY] = prev;
			if(prev < min) min = prev;
			prev = cur;
		}
		for(int i = endY - 1; i >= startY; i--) {
			cur = map[endX][i];
			map[endX][i] = prev;
			if(prev < min) min = prev;
			prev = cur;
		}
		for(int i = endX - 1; i > startX; i--) {
			cur = map[i][startY];
			map[i][startY] = prev;
			if(prev < min) min = prev;
			prev = cur;
		}
		
		return min;
	}
	
}
