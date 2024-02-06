//문제 설명
//자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
//
//제한사항
//n은 1 이상 100,000,000 이하인 자연수입니다.

package solution;

public class Ternary {

    public int solution(int n) {
        int answer = 0;
        String reverse = "";
        
        while(n>0) {
        	reverse += n % 3;
        	n /= 3;
        }
        
        // 3 to 10
        int Ternary = 1;
        
        for(int i = reverse.length()-1; i >= 0; i--) {
        	char c = reverse.charAt(i);
        	answer += Character.getNumericValue(c) * Ternary;
        	Ternary *= 3;
        }
        
        
        return answer;
    }
}
