//선분 3개가 평행하게 놓여 있습니다. 세 선분의 시작과 끝 좌표가 [[start, end], [start, end], [start, end]] 형태로 들어있는 2차원 배열 lines가 매개변수로 주어질 때, 두 개 이상의 선분이 겹치는 부분의 길이를 return 하도록 solution 함수를 완성해보세요.
//
//lines가 [[0, 2], [-3, -1], [-2, 1]]일 때 그림으로 나타내면 다음과 같습니다.
//
//line_2.png
//
//선분이 두 개 이상 겹친 곳은 [-2, -1], [0, 1]로 길이 2만큼 겹쳐있습니다.
//
//제한사항
//lines의 길이 = 3
//lines의 원소의 길이 = 2
//모든 선분은 길이가 1 이상입니다.
//lines의 원소는 [a, b] 형태이며, a, b는 각각 선분의 양 끝점 입니다.
//-100 ≤ a < b ≤ 100

package solution;

public class Overline {
	public int solution(int[][] lines) {
		// 각 line 시작점의 최솟값을 start, 끝점의 최댓값을 end로 설정
		// end - start +1 크기의 boolean 배열 생성
		// 각 line에 해당하는 칸이 false면 true로 변경
		// 이미 true면 answer +1, false로 변경(3번째 라인으로 재계산 방지)
		int answer = 0;
        int start = 100, end = -100;
        
        for(int i=0; i<3; i++) {
            if(lines[i][0] < start)
                start = lines[i][0];
            if(lines[i][1] > end)
                end = lines[i][1];
        }
        int len = end - start;
        boolean[] overLine = new boolean[len];
        int s = 0, e = 0;
        
        for(int i = 0; i< 3; i++) {
        	s = lines[i][0];
        	e = lines[i][1];
        	//-3~-1 => 0~1, -2~1 => 1~3, 0~2 => 3~4
        	for(int x = s - start; x < e - start; x++) {
        		if(overLine[x] == false)
        			overLine[x] = true;
        		else	{
        			answer++;
        			overLine[x] = false;
        		}
        	}
        }
            
        return answer;
    }
}
