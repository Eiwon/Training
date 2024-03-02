package level2New;

public class Triangle {

	public static void main(String[] args) {
		solution(6);

	}
	
	public static int[] solution(int n) {
        int[] answer = new int[n*(n+1) /2];
        int[][] triangle = new int[n][n], direction = {{1, 0}, {0, 1}, {-1, -1}};
        int count = n, num = 1, dir = 0, x = -1, y = 0;
        // 아래로 n회, 오른쪽 n-1회, 대각선 위 n-2회
        while(count > 0) {
        	for(int i = 0; i < count; i++) {
        		x += direction[dir][0];
        		y += direction[dir][1];
        		triangle[x][y] = num++;
        	}
        	dir = (dir + 1 ) % 3;
        	count--;
        }
        num = 0;
        
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < i+1; j++) {
        		System.out.print(triangle[i][j] + " ");
        		answer[num++] = triangle[i][j];
        	}
        	System.out.println();
        }
        
        return answer;
    }
}
