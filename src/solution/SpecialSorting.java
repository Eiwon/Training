//정수 n을 기준으로 n과 가까운 수부터 정렬하려고 합니다. 이때 n으로부터의 거리가 같다면 더 큰 수를 앞에 오도록 배치합니다. 정수가 담긴 배열 numlist와 정수 n이 주어질 때 numlist의 원소를 n으로부터 가까운 순서대로 정렬한 배열을 return하도록 solution 함수를 완성해주세요.
//
//제한사항
//1 ≤ n ≤ 10,000
//1 ≤ numlist의 원소 ≤ 10,000
//1 ≤ numlist의 길이 ≤ 100
//numlist는 중복된 원소를 갖지 않습니다.

package solution;
import java.util.*;

public class SpecialSorting {
	public int[] solution(int[] numlist, int n) {
        int[] answer = {};
        //distance[] 에 각 숫자와 n의 차이 계산
        //distance을 보고 distance, numlist 동시 정렬
        // 값이 같다면 numlist 값이 더 큰 항을 앞으로
        int len = numlist.length;
        int[] distance = new int[len]; 
        for(int i=0; i<len; i++) {
        	int d = numlist[i] - n;
        	distance[i] = d >= 0 ? d : -d;
        }
        
       
        
            
        return answer;
    }
}
