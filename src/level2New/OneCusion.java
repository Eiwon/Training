package level2New;
/*당구대의 가로 길이 m, 세로 길이 n과 머쓱이가 쳐야 하는 공이 놓인 위치 좌표를 나타내는 두 정수 startX, startY, 
 * 그리고 매 회마다 목표로 해야하는 공들의 위치 좌표를 나타내는 정수 쌍들이 들어있는 2차원 정수배열 balls가 주어집니다. 
 * "원쿠션" 연습을 위해 머쓱이가 공을 적어도 벽에 한 번은 맞춘 후 목표 공에 맞힌다고 할 때, 
 * 각 회마다 머쓱이가 친 공이 굴러간 거리의 최솟값의 제곱을 배열에 담아 return 하도록 solution 함수를 완성해 주세요.

단, 머쓱이가 친 공이 벽에 부딪힐 때 진행 방향은 항상 입사각과 반사각이 동일하며, 만약 꼭짓점에 부딪힐 경우 진입 방향의 반대방향으로 공이 진행됩니다. 
공의 크기는 무시하며, 두 공의 좌표가 정확히 일치하는 경우에만 두 공이 서로 맞았다고 판단합니다. 
공이 목표 공에 맞기 전에 멈추는 경우는 없으며, 목표 공에 맞으면 바로 멈춘다고 가정합니다.
 * */
//x = 0, y = 0, x = m, y = n에 대하여 대칭이동
// 같은 행 또는 열에 있으면 충돌하는 경우는 제외해야 함
// y축이 같고 x축이 원본보다 크면, m 대칭 안함
// y축이 같고 x축이 원본보다 작으면, 0 대칭 안함
// x축이 같고 y축이 원본보다 크면, n

public class OneCusion {

	public static void main(String[] args) {
		int m = 10, n = 10, startX = 3, startY = 7;
		int[][] balls = {{7, 7}, {2, 7}, {7, 3}};
		solution(m, n, startX, startY, balls);
	}
	
	public static int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        Ball origin = new Ball(startX, startY);
        
        for(int i = 0; i < balls.length; i++) {
        	answer[i] = new Ball(balls[i][0], balls[i][1]).getShortest(origin, m, n);
        }
        return answer;
    }
	

}
class Ball {
	int x, y;
	
	public Ball(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getShortest(Ball origin, int m, int n) {
		int min = m*m + n*n;
		int lenX, lenY;
		
		if(origin.y != y || origin.x > x) {
			lenX = 2 * m - (origin.x + x);
			lenY = origin.y - y;
			min = Math.min(min, lenX * lenX + lenY * lenY);
		}
		if(origin.y != y || origin.x < x) {
			lenX = origin.x + x;
			lenY = origin.y - y;
			min = Math.min(min, lenX * lenX + lenY * lenY);
		}
		if(origin.x != x || origin.y > y) {
			lenX = origin.x - x;
			lenY = 2 * n - (origin.y + y);
			min = Math.min(min, lenX * lenX + lenY * lenY);
		}
		if(origin.x != x || origin.y < y) {
			lenX = origin.x - x;
			lenY = origin.y + y;
			min = Math.min(min, lenX * lenX + lenY * lenY);
		}
		return min;
	}
	
}
