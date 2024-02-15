//제한사항
//1 ≤ want의 길이 = number의 길이 ≤ 10
//1 ≤ number의 원소 ≤ 10
//number[i]는 want[i]의 수량을 의미하며, number의 원소의 합은 10입니다.
//10 ≤ discount의 길이 ≤ 100,000
//want와 discount의 원소들은 알파벳 소문자로 이루어진 문자열입니다.
//1 ≤ want의 원소의 길이, discount의 원소의 길이 ≤ 12
package level2;
import java.util.*;

public class MaxDiscount {

	public static void main(String[] args) {
		solution(new String[] {"apple"}, 
				new int[] {10}, 
				new String[] {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"});

	}
	//discount 순회
    // want에 없는 단어 나오면 초기화(replaceAll)
    // 있는 단어 나왔는데 number보다 커지면, 작아질 때까지 다음 단어 탐색
    // 초기화 상태면 다음 10개의 단어 저장
    // 
	public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> plan = new HashMap<>();
        int planNum = 0;
        String word = "";
        
        for(String w : want) {
        	plan.put(w, 0);
        }
        
        for(int i=0; i<discount.length; i++) {
        	word = discount[i];
        	
        	if(plan.containsKey(word)) {
        		if(planNum < 10) {
        			planNum++;
        		}else {
        			plan.put(discount[i-10], plan.get(discount[i-10]) -1);
        		}
        		plan.put(word, plan.get(word)+1);
        	}else {
        		planNum = 0;
        		plan.forEach((key, value) -> plan.put(key, 0));
        	}
        	if(planNum == 10 && check(want, number, plan)) {
        		answer++;
        	}
        	System.out.println(plan.toString());
        }
        
        return answer;
    }
	private static boolean check(String[] want, int[] number, HashMap<String, Integer> plan) {
		for(int i=0; i<want.length; i++) {
			if(plan.get(want[i]) != number[i])
				return false;
		}
		return true;
	}
}
