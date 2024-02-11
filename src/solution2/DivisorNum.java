//두 정수 left와 right가 매개변수로 주어집니다. left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.
//
//제한사항
//1 ≤ left ≤ right ≤ 1,000
package solution2;

public class DivisorNum {
	public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i <= right; i++) {
        	answer += isEvenDv(i) ? i : -i;
        }
        return answer;
    }

	private boolean isEvenDv(int num) { // 약수 수가 짝수면 true
		int dvNum = 0;
		if(num == 1) return false;
		
		for(int i = 2; i*i <= num; i++) {
			if(num %i == 0) {
				if(i*i == num)
					return false;
			}
		}
		return true;
	}
	
}
