package level2New;
/*
 * 
2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다. 
3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
  3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다. 
4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다. 
  4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
  4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
  4-3. ')'를 다시 붙입니다. 
  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
  4-5. 생성된 문자열을 반환합니다.
 * */
public class CorrectAndBlanced {
//"()))((()"	"()(())()"
	public static void main(String[] args) {
		solution("()))((()");
	}
	
	public static String solution(String p) {
        String answer = strDiv(p);
        System.out.println(answer);
        return answer;
    }
	
	public static String strDiv(String str) {
		if(str.length() == 0) // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다. 
			return str;
		//2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 
		//단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다. 
		char c = str.charAt(0);
		int idx = 1;
		String u = "" + c, v = "";
		String res = "";
		for(int i = 1; i < str.length(); i++) {
			u += str.charAt(i);
			if(str.charAt(i) == c) idx++;
			else idx--;
			
			if(idx == 0) {
				v = str.substring(i+1, str.length());
				break;
			}
		}
		if(isCorrect(u)) {
			res = u + strDiv(v);
		}else {
			res = "(" + strDiv(v) + ")" + curve(u);
		}
		
		return res;
	}


	private static boolean isCorrect(String u) {
		int stack = 0;
		for(int i = 0; i < u.length(); i++) {
			if(u.charAt(i) == '(')
				stack++;
			else stack--;
			if(stack < 0)
				return false;
		}
		return true;
	}
	private static String curve(String u) {
		// 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
		String res = "";
		for(int i = 1; i < u.length() -1; i++) {
			if(u.charAt(i) == '(')
				res += ')';
			else res += '(';
		}
		return res;
	}
	
	
}
