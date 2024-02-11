//숫자로 이루어진 문자열 t와 p가 주어질 때, t에서 p와 길이가 같은 부분문자열 중에서, 이 부분문자열이 나타내는 수가 p가 나타내는 수보다 작거나 같은 것이 나오는 횟수를 return하는 함수 solution을 완성하세요.
//
//예를 들어, t="3141592"이고 p="271" 인 경우, t의 길이가 3인 부분 문자열은 314, 141, 415, 159, 592입니다. 이 문자열이 나타내는 수 중 271보다 작거나 같은 수는 141, 159 2개 입니다.
//
//제한사항
//1 ≤ p의 길이 ≤ 18
//p의 길이 ≤ t의 길이 ≤ 10,000
//t와 p는 숫자로만 이루어진 문자열이며, 0으로 시작하지 않습니다.

package solution2;

public class SubStrCmp {
	public int solution(String t, String p) {
        int answer = 0;
        int tn = t.length(), pn = p.length();
        String str = "";
        // 숫자로 변환 x (길이 10000) 1글자씩 따와서 비교
        
        for(int i=0; i < tn -pn +1; i++) {
        	str = t.substring(i, i+pn);
        	if(compare(str, p)) {
        		answer++;
        		System.out.print(str + " ");
        	}
        	
        }
        
        return answer;
    }

	private boolean compare(String str, String p) {
		// str <= p 이면 true
		// 각 위치 비교 : p가 더 크면 true, 같으면 다음 문자 비교, 작으면 false 
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) < p.charAt(i))
				return true;
			else if(str.charAt(i) > p.charAt(i))
				return false;
		}
		
		return true;
	}
}
