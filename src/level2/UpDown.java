//초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
//
//제한사항
//prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
//prices의 길이는 2 이상 100,000 이하입니다.
//입출력 예
//prices	return
//[1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
package level2;
//1 2 3 4 5 4 3 2 3 4 5 6
//1110 5 3 1 1 1 4 3 2 1 0

import java.util.*;

public class UpDown {

	public static void main(String[] args) {
		solution(new int[] {1, 2, 3, 4, 5, 4, 3, 2, 3, 4, 5, 6});
	}
	
	public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        // for n-1~0 : if(stack.peek >= prices[i]) stack.add prices[i], answer[i] = second++;
        // if(stack.peek < prices[i]) second = 1, prices[i] = second++
        // 값이 작아지면 더 작은 값이 나올 때까지 stack pop, second++,
        // 값이 커지면 second 1로 초기화, stack에 add
        Stack<Integer> stack = new Stack<>();
        
        stack.add(prices[prices.length-1]);
        prices[prices.length-1] = 0;
        int num = 0, second = 0;
        // stack 
        // sec   1
        // ans   0 1
        for(int i = prices.length -2; i >= 0; i--) {
        	num = prices[i];
        	// 
        	if(stack.peek() > num) {
        		while(true) { //스택이 비었거나 다음 값이 더 작으면 종료
        			if(stack.size() ==0 || stack.peek() < num)
        				break;
        			stack.pop();
        			second++;
        		}
        		answer[i] = second;
        		stack.push(num);
        	}else {
        		second = 1;
        		answer[i] = second++;
        		stack.push(num);
        	}
        	
        }
        for(int i : answer)
        	System.out.print(i + " ");
        
        return answer;
        
    }
}
