//첫 번째 분수의 분자와 분모를 뜻하는 numer1, denom1, 두 번째 분수의 분자와 분모를 뜻하는 numer2, denom2가 매개변수로 주어집니다. 두 분수를 더한 값을 기약 분수로 나타냈을 때 분자와 분모를 순서대로 담은 배열을 return 하도록 solution 함수를 완성해보세요.
//
//제한사항
//0 <numer1, denom1, numer2, denom2 < 1,000

package solution;

public class CalcFraction {
	public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int d1 = denom1, d2 = denom2;
        int lcm = 1;
        //분모의 최소 공배수 구하기
        
        // 두 수를 2~n까지 나누었을때, 동시에 나머지가 0이면,
        // lcm *= 나눈 값, denom12 /= 나눈 값
        // 나눌 수 있는 값을 못 찾으면, lcm *= 남은 두 값 
        
        for(int n=2; n <= d1; n++) {
        	if(d1 % n == 0 && d2 % n == 0) {
        		lcm *= n;
        		d1 /= n;
        		d2 /= n;
        		n = 1;
        	}
        }
        lcm = lcm * d1 * d2;
        
        answer[0] = numer1 *(lcm / denom1) + numer2 *(lcm / denom2);
        answer[1] = lcm;
        
        return answer;
    }
}
