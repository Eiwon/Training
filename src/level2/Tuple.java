//s의 길이는 5 이상 1,000,000 이하입니다.
//s는 숫자와 '{', '}', ',' 로만 이루어져 있습니다.
//숫자가 0으로 시작하는 경우는 없습니다.
//s는 항상 중복되는 원소가 없는 튜플을 올바르게 표현하고 있습니다.
//s가 표현하는 튜플의 원소는 1 이상 100,000 이하인 자연수입니다.
//return 하는 배열의 길이가 1 이상 500 이하인 경우만 입력으로 주어집니다.
package level2;

import java.util.*;
import java.util.Map.Entry;

public class Tuple {
//"{{1,2,3},{2,1},{1,2,4,3},{2}}"	[2, 1, 3, 4]
	public static void main(String[] args) {
		solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
	}
	
	public static int[] solution(String s) {
        int[] answer = {};
        // {부터 } 까지의 길이 추출
        int length = 0;
        char c = 0;
        List<Map.Entry<Integer, Integer>> pq = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        	
        for(int i = 1; i < s.length()-1; i++) {
        	c = s.charAt(i);
        	if(c == '{') {
        		length = 0;
        	}else if(c == '}') {
        		pq.add(Map.entry(i - length, length));
        	}else {
        		length++;
        	}
        }
        
        Collections.sort(pq, new Comparator<Map.Entry<Integer, Integer>>(){

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				
				return o1.getValue() - o2.getValue();
			}
        });
        System.out.println(pq.toString());
        
        for(int i = 0; i < pq.size(); i++) {
        	int idx = pq.get(i).getKey();
        	for(int j = idx; j < s.length(); j++) {
        		
        	}
        }
        
        return answer;
    }
}
