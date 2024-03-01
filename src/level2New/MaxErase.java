//문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다.
//number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 
//문자열 형태로 return 하도록 solution 함수를 완성하세요.
//
//제한 조건
//number는 2자리 이상, 1,000,000자리 이하인 숫자입니다.
//k는 1 이상 number의 자릿수 미만인 자연수입니다.

package level2New;

import java.lang.StringBuilder;
public class MaxErase {
//"4177252841"	4	"775841"
//"1231234"	3	"3234"
	public static void main(String[] args) {
		solution("987654321", 3);

	}
	public static String solution(String number, int k) {
        String answer = "";
        
        // i=0~number.length() 다음 숫자가 현 숫자보다 크면, 현 숫자를 제거
        StringBuilder sb = new StringBuilder(number);
        int remain = k, idx = 0;
        char pick = 0;
        while(remain > 0 && idx + 1 < sb.length()) {
        	pick = sb.charAt(idx);
        	if(pick < sb.charAt(idx + 1)) {
        		System.out.println("remove : " + sb.deleteCharAt(idx)); 
        		System.out.println(remain -1);
        		remain--;
        		idx = Math.max(0, idx-1);
        	}else {
        		idx++;
        	}
        }
        
        if(remain > 0) {
        	answer = sb.substring(0, sb.length() - remain);
        }else {
        	answer = sb.toString();
        }
        
        return answer;
    }
}
