package solution;

public class Solution {

	public static void main(String[] args) {
		SpiralArr sa = new SpiralArr();
		int n = 5;
		int[][] res = sa.solution(n);
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++)
				System.out.print(res[i][j] + " ");
			System.out.println();
		}
	}

}
