//최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다. 정수 배열 array가 매개변수로 주어질 때, 최빈값을 return 하도록 solution 함수를 완성해보세요. 최빈값이 여러 개면 -1을 return 합니다.
//
//제한사항
//0 < array의 길이 < 100
//0 ≤ array의 원소 < 1000

package solution;

public class MaxFreq {
	public int solution(int[] array) {
        int answer = -1;
        // 크기 1000인 배열 freq 생성(등장횟수 저장용)
        // 횟수 저장하면서 최빈수 maxFreq 도 체크
        // 모두 저장 후 freq에서 값이 maxFreq인 칸 탐색, 2개 이상 발견시 return -1
        
        int[] freq = new int[1000];
        int maxFreq = 0;
        int pick = 0;
        
        for(int i=0; i<array.length; i++) {
        	pick = ++freq[array[i]];
        	if(maxFreq < pick)
        		maxFreq = pick;
        }
        
        for(int i=0; i<1000; i++) {
        	if(freq[i] == maxFreq) {
        		if(answer == -1) //첫 등장이면
        			answer = i;
        		else return -1;
        	}
        }
        
        return answer;
	}
}
