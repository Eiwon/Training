package level3;

/*1	1	0	0
2	1	1	0
3	1	1	0
4	1	2	0
5	1	2	1
6	1	2+1	1

각 동전 종류에 대해,
1원만 사용해서 만드는 경우 = dp1[n-1]
2원도 사용해서 만드는 경우 = dp1[n-2] + dp2[n-2]
5원도 사용해서 만드는 경우 = dp1[n-5] + dp2[n-5] + dp3[n-5]
dp[0] = 1;
for(int i = 0; i < money.length; i++){
	int coin = money[i];
	for(int j = coin; j <= n; j++){
		dp[j] += dp[j - coin];
	}
}*/
public class DoubleDP {
	public static void main(String[] args) {
		solution(5, new int[] {1, 2, 5});
	}
	public static int solution(int n, int[] money) {
        int answer = 0;
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 0; i < money.length; i++) {
        	int coin = money[i];
        	for(int j = coin; j < n+1; j++) {
        		dp[j] += dp[j - coin];
        		System.out.println("coin : " + coin + ", row : " + j + ", dp : " + dp[j]);
        	}
        }
        answer = dp[n];
        
        
        return answer;
    }

}
