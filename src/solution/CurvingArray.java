//정수 배열 arr와 query가 주어집니다.
//
//query를 순회하면서 다음 작업을 반복합니다.
//
//짝수 인덱스에서는 arr에서 query[i]번 인덱스를 제외하고 배열의 query[i]번 인덱스 뒷부분을 잘라서 버립니다.
//홀수 인덱스에서는 arr에서 query[i]번 인덱스는 제외하고 배열의 query[i]번 인덱스 앞부분을 잘라서 버립니다.
//위 작업을 마친 후 남은 arr의 부분 배열을 return 하는 solution 함수를 완성해 주세요.
//
//제한사항
//5 ≤ arr의 길이 ≤ 100,000
//0 ≤ arr의 원소 ≤ 100
//1 ≤ query의 길이 < min(50, arr의 길이 / 2)
//query의 각 원소는 0보다 크거나 같고 남아있는 arr의 길이 보다 작습니다.

package solution;

public class CurvingArray {

	public int[] solution(int[] arr, int[] query) {
		// ex) [0, 1, 2, 3, 4, 5]	[4, 1, 2]	[1, 2, 3]
        int[] answer = {};
        int fIdx = 0, bIdx = 0; // 자르는 기준점 설정용 변수
        // 실제로 자르지는 않고 잘라야 할 곳만 저장 후 마지막에 한번에 커팅
        
        // query의 각 원소 확인 후 다음 작업 진행
        for(int i=0; i < query.length; i++) {
        	if(i % 2 == 0) { // 짝수 인덱스일 때
        		//arr[query[i]]의 뒷부분 제거
        		bIdx = fIdx + query[i];
        	}else { // 홀수 인덱스일 때
        		//arr[fIdx +query[i]]의 앞부분 제거
        		fIdx += query[i];
        	}
        }
        
        answer = new int[bIdx - fIdx +1];
        for(int i = fIdx; i < bIdx+1; i++) 
        	answer[i-fIdx] = arr[i];
        
        return answer;
    }
}
