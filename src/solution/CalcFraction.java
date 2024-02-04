//첫 번째 분수의 분자와 분모를 뜻하는 numer1, denom1, 두 번째 분수의 분자와 분모를 뜻하는 numer2, denom2가 매개변수로 주어집니다. 두 분수를 더한 값을 기약 분수로 나타냈을 때 분자와 분모를 순서대로 담은 배열을 return 하도록 solution 함수를 완성해보세요.
//
//제한사항
//0 <numer1, denom1, numer2, denom2 < 1,000

package solution;

public class CalcFraction {
	public int[] solution(int numer1, int denom1, int numer2, int denom2) {
		int[] answer = new int[2];
        int numer3 = numer1*denom2 + numer2*denom1;
        int denom3 = denom1*denom2;
        
        for(int n=2; n <= denom3; n++) {
        	if((denom3 % n == 0) && (numer3 % n == 0)) {
        		denom3 /= n;
        		numer3 /= n;
        		n = 1;
        	}
        }
        
        answer[0] = numer3;
        answer[1] = denom3;
        return answer;
    }
}
