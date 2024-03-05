/*각 원소의 합이 S가 되는 수의 집합
위 조건을 만족하면서 각 원소의 곱 이 최대가 되는 집합
최고의 집합은 오름차순으로 정렬된 1차원 배열(list, vector) 로 return 해주세요.
만약 최고의 집합이 존재하지 않는 경우에 크기가 1인 1차원 배열(list, vector) 에 -1 을 채워서 return 해주세요.
자연수의 개수 n은 1 이상 10,000 이하의 자연수입니다.
모든 원소들의 합 s는 1 이상, 100,000,000 이하의 자연수입니다.
2	9	[4, 5]
2	1	[-1]
2	8	[4, 4]
*
*/

package level3;

public class BestSet {

	public static void main(String[] args) {
		
		solution(2, 8);
	}
	public static int[] solution(int n, int s) {
        int[] answer = new int[n];
        int at = s / n;
        int sum = n * at;
        for(int i = 0; i < n; i++) {
        	answer[i] = at;
        }
        if(n > s)
        	return new int[] {-1};
        int idx = n-1;
        while(sum < s) {
        	answer[idx--]++;
        	sum++;
        	if(idx < 0) idx = n-1;
        }
        
        
        return answer;
    }
}
