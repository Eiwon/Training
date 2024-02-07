package solution;

import java.util.*;
public class PickGame_stack {
	public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        //뽑을 인형 담을 바구니
        Stack<Integer> basket = new Stack<>();
        
        //인형뽑기 기계의 각 열을 담을 스택 생성
       	Stack[] machine = new Stack[n];
       	
       	//스택에 인형 담기
       	for(int i=0; i<n; i++) {
       		machine[i] = new Stack<Integer>();
       		for(int j=n-1; j >=0; j--) {
       			if(board[j][i] > 0) {
       				machine[i].add(board[j][i]);
       			}
       		}
       	}
       	
       	//인형 뽑기
       	for(int i=0; i<moves.length; i++) {
       		int pickCol = moves[i]-1;
       		if(machine[pickCol].isEmpty() == false) { //해당 라인에 뽑을 인형이 있으면
       			int doll = (int)machine[pickCol].pop();
       			
       			// 인형 뽑아서 바구니 최상단과 비교
       			if(basket.isEmpty() == false && (int)basket.peek() == doll) {
       				basket.pop();
       				answer += 2;
       			}else {
       				basket.add(doll);
       			}
       			// 바구니가 비었으면 인형 추가
       			// 안비었으면 최상단 인형과 비교
       			// ㄴ 같으면 바구니의 최상단 인형 제거
       			// ㄴ 다르면 바구니에 인형 추가
       		}
       	}
        
        return answer;
    }
}
