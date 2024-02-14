//대괄호, 중괄호, 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어집니다. 이 s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때 s가 올바른 괄호 문자열이 되게 하는 x의 개수를 return 하도록 solution 함수를 완성해주세요.
//
//제한사항
//s의 길이는 1 이상 1,000 이하입니다.
package level2;
import java.util.*;

public class BracketRotate {
//"[](){}"	3
	public static void main(String[] args) {
		solution("[](){}");
	}
	
	public static int solution(String s) {
        int answer = 0;
		char c = 0;
		Stack<Character> stack = new Stack<>();
		for(int cycle = 0; cycle < s.length(); cycle++) {
			stack.clear();
			// 비어있을때 닫는 괄호 -> break
			// 안비었을때 닫는 괄호 -> pop 불가능하면 break
			// 열린괄호 -> push
			for(int i = 0; i < s.length(); i++) {
				c = s.charAt((i+cycle)%s.length());
				if(c == ']' || c == '}' || c == ')') {
					if(stack.size() == 0) {
						stack.push(c);
						break;
					}else if(stack.peek() -c < 3) { //괄호쌍 간의 ascii 값 1~2차이
							stack.pop();
							}
				}else {
					stack.push(c);
				}			
			}
			if(stack.size() == 0)
				answer++;
		}
		
        return answer;
    }
}
