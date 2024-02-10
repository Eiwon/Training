//이 프로그램에서는 매일 "명예의 전당"의 최하위 점수를 발표합니다. 
//예를 들어, k = 3이고, 7일 동안 진행된 가수의 점수가 [10, 100, 20, 150, 1, 100, 200]
//이라면, 명예의 전당에서 발표된 점수는 아래의 그림과 같이 [10, 10, 10, 20, 20, 100, 100]입니다.
//
//명예의 전당 목록의 점수의 개수 k, 1일부터 마지막 날까지 출연한 가수들의 점수인 score가 주어졌을 때, 매일 발표된 명예의 전당의 최하위 점수를 return하는 solution 함수를 완성해주세요.
//
//제한사항
//3 ≤ k ≤ 100
//7 ≤ score의 길이 ≤ 1,000
//0 ≤ score[i] ≤ 2,000

package solution;
import java.util.*;
public class StageOfHonor {
	public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> rank = new ArrayList<>();
        int todayScore = 0;
        // 각 score에 대하여, 
        // if rank.element == k 이면  rank[0]과 비교 후 높은 값으로 변경
        // ㄴ 아니면 rank에 score 추가
        // rank 오름차순 정렬
        // rank[0] 값을 answer에 추가
        for(int day = 0; day < score.length; day++) {
        	todayScore = score[day];
        	if(rank.size() < k) {
        		rank.add(todayScore);
        	}else {
        		rank.set(0, Math.max(rank.get(0), todayScore));
        	}
        	rank.sort(null);
        	answer[day] = rank.get(0);
        }
        
        
        return answer;
    }
}
