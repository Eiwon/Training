//자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.
//
//조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
//조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
//조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
//예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.
//
//자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.
//
//제한 사항
//n은 1,000,000 이하의 자연수 입니다.

package solution2;
import java.lang.StringBuilder;
public class NextBig {
	public int solution(int n) {
        int answer = 0;
        //이진 변환후 뒤에서부터 체크
        // 처음으로 1다음에 0이 나오면 or 1다음에 문자열이 끝나면 두 수를 교환
        // 뒤의 1을 문자열 맨 끝으로 밀기
        String binaryN = Integer.toBinaryString(n);
        StringBuilder bigBinaryN = new StringBuilder();
        char c = 0;
        boolean changeP = false;
        int checkNum = 0;
        int oneNum = 0, bLen = binaryN.length();

        for(int i=bLen -1; i >= 0; i--) {
        	c = binaryN.charAt(i);
        	checkNum++;
        	if(c == '1') {
        		changeP = true;
        		oneNum++;
        	} else if(c == '0' && changeP) {
        		bigBinaryN.append(binaryN.substring(0, i));
        		checkNum--;
        		//앞부분 잘라 붙이기
        		break;
        	}
        }
        
        bigBinaryN.append("10"); //01을 10으로 변환
        oneNum--;
        checkNum--;
        for(int i=checkNum; i > 0; i--) { // 뒷부분 1을 전부 맨 뒤로 밀기
        	if(oneNum == i) {
        		bigBinaryN.append('1');
        		oneNum--;
        	}else {
        		bigBinaryN.append('0');
        	}
        }
        answer = toDec(bigBinaryN.toString());
        
        return answer;
    }
	
	private int toDec(String binary) {
		int c = 0, mul = 1, result = 0;
		for(int i=binary.length() -1; i >=0; i--) {
			c = Character.getNumericValue(binary.charAt(i));
			result += c*mul;
			mul *= 2;
		}
		
		return result;
	}
}
