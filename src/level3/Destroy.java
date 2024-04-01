package level3;

public class Destroy {

	public static void main(String[] args) {
		solution(new int[][] {
			{5,5,5,5,5},
			{5,5,5,5,5},
			{5,5,5,5,5},
			{5,5,5,5,5}
		}, new int[][] {
			{1,0,0,3,4,4},
			{1,2,0,2,3,2},
			{2,1,0,3,1,2},
			{1,0,1,3,3,1}
		});
	}
	//[[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5]]	
	//[[1,0,0,3,4,4],[1,2,0,2,3,2],[2,1,0,3,1,2],[1,0,1,3,3,1]]	
	public static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] sum = new int[board.length+1][board[0].length+1];
        for(int[] sk : skill) {
        	if(sk[0] == 1) {
        		sk[5] *= -1;
        	}	
        	sum[sk[1]][sk[2]] += sk[5];
        	sum[sk[3]+1][sk[4]+1] += sk[5];
        	sum[sk[1]][sk[4]+1] -= sk[5];
        	sum[sk[3]+1][sk[2]] -= sk[5];
        }
        for(int row=0 , rowSum =0; row < sum.length; rowSum = 0, row++) {
        	for(int col=0; col < sum[0].length; col++) {
        		rowSum += sum[row][col];
        		sum[row][col] = rowSum;
        	}
        }
        for(int col=0 , colSum =0; col < sum[0].length; colSum = 0, col++) {
        	for(int row=0; row < sum.length; row++) {
        		colSum += sum[row][col];
        		sum[row][col] = colSum;
        	}
        }
        for(int i =0; i<board.length; i++) {
        	for(int j=0; j<board[i].length; j++) {
        		if(board[i][j] + sum[i][j] > 0)
        			answer++;
        	}
        }
        System.out.println(answer);
        
        return answer;
    }
}
