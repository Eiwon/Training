package solution2;

import java.util.*;

public class CharPang {

	public static void main(String[] args) {
		solution("baabaa");
	}
	
	public static int solution(String s)
    {
        int answer = -1;
        Stack<Character> stack = new Stack<>();
        char c = 0;
        for(int i=0; i<s.length(); i++) {
        	c = s.charAt(i);
        	if(stack.isEmpty() == false && stack.peek() == c) {
        		stack.pop();
        	}else stack.push(c);
        }
        if(stack.isEmpty())
        	answer = 1;
        else answer = 0;
        
        return answer;
    }
}
