package level3;
/*어떤 수열의 연속 부분 수열에 같은 길이의 펄스 수열을 각 원소끼리 곱하여 연속 펄스 부분 수열을 만들려 합니다. 펄스 수열이란 [1, -1, 1, -1 …] 또는 [-1, 1, -1, 1 …] 과 같이 1 또는 -1로 시작하면서 1과 -1이 번갈아 나오는 수열입니다.
예를 들어 수열 [2, 3, -6, 1, 3, -1, 2, 4]의 연속 부분 수열 [3, -6, 1]에 펄스 수열 [1, -1, 1]을 곱하면 연속 펄스 부분수열은 [3, 6, 1]이 됩니다. 또 다른 예시로 연속 부분 수열 [3, -1, 2, 4]에 펄스 수열 [-1, 1, -1, 1]을 곱하면 연속 펄스 부분수열은 [-3, -1, -2, 4]이 됩니다.
정수 수열 sequence가 매개변수로 주어질 때, 연속 펄스 부분 수열의 합 중 가장 큰 것을 return 하도록 solution 함수를 완성해주세요.

제한 사항
1 ≤ sequence의 길이 ≤ 500,000
-100,000 ≤ sequence의 원소 ≤ 100,000
sequence의 원소는 정수입니다.*/
public class PurseSequence {
//[2, 3, -6, 1, 3, -1, 2, 4]	10
	public static void main(String[] args) {
		solution(new int[] {2, 3, -6, 1, 3, -1, 2, 4});
	}
	public static long solution(int[] sequence) {
        long answer = 0;
        int n = sequence.length;
        int[] sequence1 = new int[n];
        int[] sequence2 = new int[n];
        
        for(int i = 0; i < n; i++) {
        	if(i %2 == 0) {
        		sequence1[i] = sequence[i] * -1;
        		sequence2[i] = sequence[i];
        	}else {
        		sequence1[i] = sequence[i];
        		sequence2[i] = sequence[i] * -1;
        	}
        }
        
        long[] dp1 = new long[n];
        long[] dp2 = new long[n];
        dp1[0] = sequence1[0];
        dp2[0] = sequence2[0];
        answer = Math.max(dp1[0], dp2[0]);
        for(int i = 1; i < n; i++) {
        	dp1[i] = Math.max(sequence1[i], dp1[i-1] + sequence1[i]);
        	dp2[i] = Math.max(sequence2[i], dp2[i-1] + sequence2[i]);
        	answer = Math.max(answer, dp1[i]);
        	answer = Math.max(answer, dp2[i]);
        }
        System.out.println(answer);
        return answer;
    }
}
