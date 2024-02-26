package level2New;

public class Tiling {

	public static void main(String[] args) {

	}
	public int solution(int n) {
        int answer = 0;
        
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i < n+1; i++) {
        	dp[i] = (dp[i-1] + dp[i-2] + 2) % 1000000007;
        }
        
        answer = dp[n];
        
        return answer;
    }
}
