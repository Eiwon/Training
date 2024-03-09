package level3;
/*
 * 이때, 우리는 5g 기지국을 최소로 설치하면서 모든 아파트에 전파를 전달하려고 합니다. 위의 예시에선 최소 3개의 아파트 옥상에 기지국을 설치해야 모든 아파트에 전파를 전달할 수 있습니다.

아파트의 개수 N, 현재 기지국이 설치된 아파트의 번호가 담긴 1차원 배열 stations, 전파의 도달 거리 W가 매개변수로 주어질 때, 모든 아파트에 전파를 전달하기 위해 증설해야 할 기지국 개수의 최솟값을 리턴하는 solution 함수를 완성해주세요*/
public class SetStation {
//11	[4, 11]	1	3
//16	[9]	2	3
	public static void main(String[] args) {
		solution(11, new int[] {4, 11}, 1);
	}
	public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int curPoint = 1, stationNum = 0;
        
        while(curPoint <= n) {
        	if(stationNum < stations.length && curPoint >= stations[stationNum] - w) { // 남은 스테이션 있으면
        		curPoint = stations[stationNum++] + w +1;
        	}else {
        		curPoint += w * 2 +1;
            	answer++;
        	}
        }
        return answer;
    }
}
