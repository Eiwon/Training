package solution;

public class Solution {
//[0,0,0,0,0]
//[0,0,1,0,3]
//[0,2,5,0,1] 
//[4,2,4,4,2]
//[3,5,1,3,1]]	[1,5,3,5,1,2,1,4] 
	public static void main(String[] args) {
		int[][] board = {
				{0, 0, 0, 0, 0},
				{0, 0, 1, 0, 3},
				{0, 2, 5, 0, 1},
				{4, 2, 4, 4, 2},
				{3, 5, 1, 3, 1}
		};
		int[] move = {1, 5, 3, 5, 1, 2, 1, 4};
		PickGame_stack ps = new PickGame_stack();
		ps.solution(board, move);
		
        
        return;
	}

}
