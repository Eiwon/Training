//입력으로는 str1과 str2의 두 문자열이 들어온다. 각 문자열의 길이는 2 이상, 1,000 이하이다.
//입력으로 들어온 문자열은 두 글자씩 끊어서 다중집합의 원소로 만든다. 이때 영문자로 된 글자 쌍만 유효하고, 기타 공백이나 숫자, 특수 문자가 들어있는 경우는 그 글자 쌍을 버린다. 예를 들어 "ab+"가 입력으로 들어오면, "ab"만 다중집합의 원소로 삼고, "b+"는 버린다.
//다중집합 원소 사이를 비교할 때, 대문자와 소문자의 차이는 무시한다. "AB"와 "Ab", "ab"는 같은 원소로 취급한다.
//입력으로 들어온 두 문자열의 자카드 유사도를 출력한다. 유사도 값은 0에서 1 사이의 실수이므로, 이를 다루기 쉽도록 65536을 곱한 후에 소수점 아래를 버리고 정수부만 출력한다.
package level2;

import java.util.*;

public class Zakad {

	public static void main(String[] args) {
		//FRANCE	french	16384
		solution("E=M*C^2", "e=m*c^2");

	}
	
	public static int solution(String str1, String str2) {
        int answer = 0;
        HashMap<String, Integer> map1 = new HashMap<>();
        int mulNum = 0;
        int sumNum = 0;
        // 알파벳만 골라내서 소문자로 변환 후 2글자씩 해시맵에 추가
        String word = "";
        char c = 0;
        
        for(int i = 0; i < str1.length(); i++) {
        	c = str1.charAt(i);
        	if(Character.isAlphabetic(c)) {
        		word += Character.toLowerCase(c);
        		if(word.length() == 2) {
        			//해시맵에 추가
        			if(map1.containsKey(word)) {
        				map1.put(word, map1.get(word)+1);
        			}else {
        				map1.put(word, 1);
        			}
        			sumNum++;
        			word = "" + Character.toLowerCase(c);
        		}
        	}else {
        		word = "";
        	}
        }
        
        word = "";
        for(int i = 0; i < str2.length(); i++) {
        	c = str2.charAt(i);
        	if(Character.isAlphabetic(c)) {
        		word += Character.toLowerCase(c);
        		if(word.length() == 2) {
        			//해시맵 비교
        			// 해시맵에 있는 단어면, 해당 단어 count -1, 1이라면 해시맵에서 제거, 교집합 +1 
        			// 없는 단어면 합집합 +1
        			if(map1.containsKey(word)) {
        				if(map1.get(word) == 1) {
        					map1.remove(word);
        				}else {
        					map1.put(word, map1.get(word) -1);
        				}
        				mulNum++;
        			}else {
        				sumNum++;
        			}
        			
        			word = "" + Character.toLowerCase(c);
        		}
        	}else {
        		word = "";
        	}
        }
        if(sumNum == 0) return 65536;
        double rate = (double)mulNum / sumNum;
        answer = (int)(rate * 65536);
        
        return answer;
    }
}
