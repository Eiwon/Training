//자연수 x를 y로 변환하려고 합니다. 사용할 수 있는 연산은 다음과 같습니다.
//
//x에 n을 더합니다
//x에 2를 곱합니다.
//x에 3을 곱합니다.
//자연수 x, y, n이 매개변수로 주어질 때, x를 y로 변환하기 위해 필요한 최소 연산 횟수를 return하도록 solution 함수를 완성해주세요. 이때 x를 y로 만들 수 없다면 -1을 return 해주세요.
//
//제한사항
//1 ≤ x ≤ y ≤ 1,000,000
//1 ≤ n < y

package level2New;
import java.util.*;

public class NumConv {

	private static int minDepth = Integer.MAX_VALUE;
	public static void main(String[] args) {
		solution(2, 5, 4);

	}
//너비우선탐색
	public static int solution(int x, int y, int n) {
        int answer = 0;
        
        Queue<Map.Entry<Integer, Integer>> wSearch = new LinkedList<>();
        
        wSearch.add(Map.entry(x, 0));
        Map.Entry<Integer, Integer> pick;
        
        while(true) {
        	pick = wSearch.poll();
        	if(pick.getKey() == y) {
        		answer = pick.getValue();
        		break;
        	}else if(pick.getKey() < y) {
        		wSearch.add(Map.entry(pick.getKey() * 3, pick.getValue() + 1));
        		wSearch.add(Map.entry(pick.getKey() * 2, pick.getValue() + 1));
        		wSearch.add(Map.entry(pick.getKey() + n, pick.getValue() + 1));
        	}
        	if(wSearch.size() == 0) {
        		answer = -1;
        		break;
        	}
        }
        System.out.println(answer);
        
        return answer;
    }
	
	
	
}
