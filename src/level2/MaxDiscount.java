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
		solution(new String[] {"banana", "apple", "rice", "pork", "pot"}, 
				new int[] {3, 2, 2, 2, 1}, 
				new String[] {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"});

	}

	public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> plan = new HashMap<>();
        String word = "";
        for(int i=0; i<discount.length-10; i++) {
        	word = discount[i];
        	if(plan.size() < 10) {
        		if(plan.containsKey(word)) {
        			plan.put(word, plan.get(word)+1);
        		}else {
        			plan.put(word, 1);
        		}
        	}else {
        		//check
        	}
        }
        
        
        return answer;
    }
}
