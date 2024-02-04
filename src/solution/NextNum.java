//등차수열 혹은 등비수열 common이 매개변수로 주어질 때, 마지막 원소 다음으로 올 숫자를 return 하도록 solution 함수를 완성해보세요.
//
//제한사항
//2 < common의 길이 < 1,000
//-1,000 < common의 원소 < 2,000
//common의 원소는 모두 정수입니다.
//등차수열 혹은 등비수열이 아닌 경우는 없습니다.
//등비수열인 경우 공비는 0이 아닌 정수입니다.

package solution;

public class NextNum {
	public int solution(int[] common) {
        int answer = 0;
        int d = 0;
        int last = common.length - 1;
        // 등차 등비 체크
        // 첫항과 2항, 마지막항과 마지막-1항으로 각각 체크
        // 등비 : 2항 - 1항 == 마지막항 - (마지막-1항)
        // 등차 : / == /
        
        d = common[1] - common[0];
        if(d == (common[last] - common[last-1])) {
        	answer = common[last] + d;
        }else {
        	d = common[1] / common[0];
        	answer = common[last] * d;
        }
        return answer;
    }
}
