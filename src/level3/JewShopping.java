package level3;
/*진열된 모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간을 찾아서 구매
 * 진열대 번호 순서대로 보석들의 이름이 저장된 배열 gems가 매개변수로 주어집니다. 이때 모든 보석을 하나 이상 포함하는 가장 짧은 구간을 찾아서 return 하도록 solution 함수를 완성해주세요.
가장 짧은 구간의 시작 진열대 번호와 끝 진열대 번호를 차례대로 배열에 담아서 return 하도록 하며, 만약 가장 짧은 구간이 여러 개라면 시작 진열대 번호가 가장 작은 구간을 return 합니다.

[제한사항]
gems 배열의 크기는 1 이상 100,000 이하입니다.
gems 배열의 각 원소는 진열대에 나열된 보석을 나타냅니다.
gems 배열에는 1번 진열대부터 진열대 번호 순서대로 보석이름이 차례대로 저장되어 있습니다.
gems 배열의 각 원소는 길이가 1 이상 10 이하인 알파벳 대문자로만 구성된 문자열입니다.*/
import java.util.*;

public class JewShopping {
//"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"
	public static void main(String[] args) {
		solution(new String[] {
				"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"
				});
	}

	public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        int typeNum = 0;
        int start = gems.length, end = 0;
        int minLen = gems.length +1;
        HashSet<String> gemType = new HashSet<>();
        for(String str : gems) {
        	gemType.add(str);
        }
        typeNum = gemType.size();
        HashMap<String, Integer> lastIdx = new HashMap<>();
        Queue<Gem> list = new LinkedList<>();
      
        for(int i = 0; i < gems.length; i++) {
        	lastIdx.put(gems[i], i);
        	list.add(new Gem(i, gems[i]));
        	while(lastIdx.get(list.peek().name) != list.peek().idx) {
        		list.poll();
        	}
        	for(Gem g : list) {
        		System.out.print(g.name.toString() + " ");
        	}
        	System.out.println();
        	if(lastIdx.size() == typeNum) {
        		start = list.peek().idx;
        		end = i;
        		if(minLen > end - start) {
        			minLen = end - start;
        			answer[0] = start +1;
        			answer[1] = end +1;
        		}
        	}
        }
        System.out.println(answer[0] + " " + answer[1]);
        
        // 해시맵에 각 보석과 인덱스 저장
        // 큐에 각 보석과 인덱스 저장
        // 큐의 peek의 인덱스가 해시맵의 인덱스와 다른 동안 계속 poll
        // 해시맵 크기가 typeNum이 되면, 큐의 처음과 끝의 .idx 가져와서 계산 
        
        
        return answer;
    }
	
	
}
class Gem {
	int idx;
	String name;
	
	public Gem(int idx, String name) {
		this.idx = idx;
		this.name = name;
	}
}
