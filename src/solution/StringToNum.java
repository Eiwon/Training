
//1478 → "one4seveneight"
//234567 → "23four5six7"
//10203 → "1zerotwozero3"
//이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다. s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.
//		1 ≤ s의 길이 ≤ 50
//		s가 "zero" 또는 "0"으로 시작하는 경우는 주어지지 않습니다.
//		return 값이 1 이상 2,000,000,000 이하의 정수가 되는 올바른 입력만 s로 주어집니다.

package solution;

public class StringToNum {
	public int solution(String s) {
        int answer = 0;
        String result = "";
        String[] numLet = {"zero", "one", "two", "three", "four", "five",
        		"six", "seven", "eight", "nine"};
        
        for(int i=0; i<s.length(); i++) {
        	char c = s.charAt(i);
        	if(c >= '0' && c <= '9') { // 숫자면 result에 추가
        		result += c;
        	}else { // 문자면 첫 두글자를 numLet의 두글자와 비교
        		char c2 = s.charAt(i+1);
        		for(int nli = 0; nli < numLet.length; nli++) {
        			if(c == numLet[nli].charAt(0) && c2 == numLet[nli].charAt(1)) {
        				result += Integer.toString(nli); // 같은 문자 찾으면 result에 추가
        				i += numLet[nli].length() -1; // 변환된 길이만큼 스킵
        			}
        		}
        	}
        }
        
        answer = Integer.parseInt(result);
        return answer;
    }
}
