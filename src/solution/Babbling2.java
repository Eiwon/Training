//조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음과 네 가지 발음을 조합해서 만들 수 있는 발음밖에 하지 못하고 연속해서 같은 발음을 하는 것을 어려워합니다. 문자열 배열 babbling이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
//
//제한사항
//1 ≤ babbling의 길이 ≤ 100
//1 ≤ babbling[i]의 길이 ≤ 30
//문자열은 알파벳 소문자로만 이루어져 있습니다.


package solution;

public class Babbling2 {
	public int solution(String[] babbling) {
        int answer = 0;
        String[] able = {"aya", "ye", "woo", "ma"};
        String[] multi = {"ayaa", "yey", "woow", "mam"};
        for(int i=0; i<babbling.length; i++) {
        	String word = babbling[i];
        	boolean isAble = true;
        	for(String m : multi) {
        		if(word.contains(m)) {
        			isAble = false;
        		}
        	}
        	if(isAble) {
        		for(String a : able) {
        			word = word.replace(a, "1");
        		}
        		if(word.matches("[1]*$")) {
        			System.out.println(word);
        			answer++;
        		}
        	}
        }
        
        return answer;
    }
}
