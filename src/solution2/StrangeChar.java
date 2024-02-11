//문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
//
//제한 사항
//문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
//첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.
package solution2;

import java.lang.StringBuilder;
public class StrangeChar {
	public String solution(String s) {
        String answer = "";
        //각 단어의 짝수번째 대문자 홀수번째 소문자
        StringBuilder result = new StringBuilder("");
        char pick = 0;
        for(int strStart=0, wordStart = 0; result.length() < s.length(); strStart++, wordStart++) {
        	pick = s.charAt(strStart);
        	if(pick == ' ') {
        		wordStart = -1;
        	}else if(wordStart %2 == 0 && Character.isLowerCase(pick)) {
        		pick = Character.toUpperCase(pick);
        	}else if(wordStart %2 == 1 && Character.isUpperCase(pick)) {
        		pick = Character.toLowerCase(pick);
        	}
        	result.append(pick);
        }
        answer = result.toString();
       
        
        
        return answer;
    }
}
