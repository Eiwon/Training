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
				// 첫 문자부터 비교, 길이가 다르고 나머지 문자가 같으면 
				// 길이가 더 긴 쪽의 다음 문자와 짧은 쪽의 첫 문자 비교
				int idx = 0, com = 0;
				while(idx < o1.length() && idx < o2.length()) {
					com = o2.charAt(idx) - o1.charAt(idx);
					if(com != 0)
						return com;
					idx++;
				}
				
				if(o2.length() > o1.length()) {
					for(int i = idx; i < o2.length(); i++) {
						com = o2.charAt(i) - o1.charAt(i%o1.length());
						if(com != 0)
							return com;
					}
				}else if(o2.length() < o1.length()) {
					for(int i = idx; i < o1.length(); i++) {
						com = o2.charAt(i%o2.length()) - o1.charAt(i);
						if(com != 0)
							return com;
					}
				}
				
				return 0;
			}});
        
        for(int num : numbers) {
        	pq.add(String.valueOf(num));
        }
        
        while(!pq.isEmpty()) {
        	answer = answer.concat(pq.poll());
        }
        System.out.println(answer);
        
        
        return answer;
    }
}
