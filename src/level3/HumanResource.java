package level3;

public class HumanResource {

	public static void main(String[] args) {
		solution(new int[][] {{2,2},{1,4},{3,2},{3,2},{2,1}});
	}
	public static int solution(int[][] scores) {
        int answer = 1;
        int won = scores[0][0] + scores[0][1];
        int[] pick;
        for(int i = 1; i < scores.length; i++) {
        	pick = scores[i];
        	if(pick[0] > scores[0][0] && pick[1] > scores[0][0])
        		return -1;
        	if(won < pick[0] + pick[1]) answer++;
        }
        System.out.println(answer);
        return answer;
    }
//scores 원소 수에 따라 순위를 나타내는 dp 실행, scores[n]이 scores[0]보다 모두 크면 즉시 return -1, 
//총합이 scores[0]보다 크면 순위 +1;
}
