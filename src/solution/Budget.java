//물품을 구매해 줄 때는 각 부서가 신청한 금액만큼을 모두 지원해 줘야 합니다. 예를 들어 1,000원을 신청한 부서에는 정확히 1,000원을 지원해야 하며, 1,000원보다 적은 금액을 지원해 줄 수는 없습니다.
//
//부서별로 신청한 금액이 들어있는 배열 d와 예산 budget이 매개변수로 주어질 때, 최대 몇 개의 부서에 물품을 지원할 수 있는지 return 하도록 solution 함수를 완성해주세요.
//
//제한사항
//d는 부서별로 신청한 금액이 들어있는 배열이며, 길이(전체 부서의 개수)는 1 이상 100 이하입니다.
//d의 각 원소는 부서별로 신청한 금액을 나타내며, 부서별 신청 금액은 1 이상 100,000 이하의 자연수입니다.
//budget은 예산을 나타내며, 1 이상 10,000,000 이하의 자연수입니다.

//sorting
package solution;
import java.util.*;

public class Budget {
	public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);

        for(int i=0; i<d.length; i++) {
        	budget -= d[i];
        	if(budget < 0)
        		break;
        	answer++;
        }
        
        return answer;
    }
}
