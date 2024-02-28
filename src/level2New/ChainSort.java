package level2New;

import java.util.*;

public class ChainSort {
//[3, 30, 34, 5, 9]	"9534330"
	public static void main(String[] args) {
		solution(new int[] {100, 1001001001, });
	}
	public static String solution(int[] numbers) {
        String answer = "";
        //문자열로 바꿔서 비교
        
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String sum1 = o2.concat(o1);
				String sum2 = o1.concat(o2);
				int c = 0;
				for(int i = 0; i < sum1.length(); i++) {
					c = (sum1.charAt(i) - sum2.charAt(i));
					if(c != 0) {
						return c;
					}
				}
				
				return 0;
			}});
        
        for(int num : numbers) {
        	pq.add(String.valueOf(num));
        }
        
        while(!pq.isEmpty()) {
        	 answer = answer.concat(pq.poll());
             if(answer.equals("0"))
                 break;
        }
        System.out.println(answer);
        
        
        return answer;
    }
}
