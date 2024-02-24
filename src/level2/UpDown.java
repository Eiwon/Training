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
	}					  //11 10  5  3  1  1  1  4  3  2  1  0
	
	public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        // 값이 작아지면 더 작은 값이 나올 때까지 stack pop, (자신 값+1+pop 횟수) 부여
        // 값이 커지면 second 1로 초기화, stack에 push
        Stack<Map.Entry<Integer, Integer>> stack = new Stack<>();
        stack.push(Map.entry(prices[prices.length-1], prices.length-1));
        answer[prices.length -1] = 0;
        int pick = 0;
        
        for(int i = prices.length -2; i >= 0; i--) {
        	pick = prices[i];
        	
        	if(prices[i+1] >= pick) {
        		while(true) {
        			if(stack.size() == 0) {
        				answer[i] = prices.length -1 - i;
        				break;
        			}
        			if(stack.peek().getKey() < pick) {
        				answer[i] = stack.peek().getValue() -i;
        				break;
        			}
        			stack.pop();
        			answer[i]++;
        		}
        	}else {
        		answer[i] = 1;
        	}
        	stack.push(Map.entry(pick, i));
        	
        }
       
        for(int i : answer)
        	System.out.print(i + " ");
        
        return answer;
        
    }
}
