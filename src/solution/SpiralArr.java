//양의 정수 n이 매개변수로 주어집니다. n × n 배열에 1부터 n2 까지 정수를 인덱스 [0][0]부터 시계방향 나선형으로 배치한 이차원 배열을 return 하는 solution 함수를 작성해 주세요.
//
//제한사항
//1 ≤ n ≤ 30

package solution;

public class SpiralArr {
	public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int parity = 1;
        int curX = -1, curY = 0;
        int num = 1;
        // n, n-1, n-1, n-2, n-2, n-3, ... 1, 1
        // +x  +y  -x   -y   +x    +y ...
        while(n > 0) {
        	for(int x = 0; x < n; x++) {
        		curX += parity;
        		answer[curY][curX] = num++; 
        	} // x축 이동
        	n--;
        	for(int y = 0; y < n; y++) {
        		curY += parity;
        		answer[curY][curX] = num++; 
        	} // y축 이동
        	parity *= -1; // 방향 전환
        }
        return answer;
    }
}
