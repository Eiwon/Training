//괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다
//'(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
//
//제한사항
//문자열 s의 길이 : 100,000 이하의 자연수
//문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.
package level2;
import java.util.*;

public class BracketCk {
	boolean solution(String s) {
        boolean answer = true;
        Stack<Character> check = new Stack<>();
        char c = 0;
        for(int i=0; i<s.length(); i++) {
        	c = s.charAt(i);
        	if(c == '(')
        		check.push(c);
        	else if(c == ')') {
        		if(check.isEmpty())
        			return false;
        		else check.pop();
        	}
        }
        if(check.isEmpty())
        	answer = true;
        else answer = false;

        return answer;
    }
}
