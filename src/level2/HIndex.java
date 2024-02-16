//어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
//
//어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.
//
//제한사항
//과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
//논문별 인용 횟수는 0회 이상 10,000회 이하입니다.
package level2;
import java.util.*;
public class HIndex {

	public static void main(String[] args) {
		solution(new int[] {1, 2, 2, 7, 7, 7, 7, 15, 18});
	}// 1 2 2 9 10 10 10 10 15 18 -> 7
	
	public static int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        
        Arrays.sort(citations);
        
        for(int i=0; i<n; i++) {
        	if(citations[n-i-1] <= answer) {
        		System.out.println(answer);
        		break;
        	}
        	answer = i+1;
        }
        
        return answer;
    }
}
