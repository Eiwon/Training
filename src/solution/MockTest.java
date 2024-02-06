//1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
//2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
//3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
//
//1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
//
//제한 조건
//시험은 최대 10,000 문제로 구성되어있습니다.
//문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
//가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.

package solution;

public class MockTest {
	public int[] solution(int[] answers) {
        int[] answer;
        int[] set1 = {1,2,3,4,5}; // 
        int[] set2 = {2,1,2,3,2,4,2,5}; // 
        int[] set3 = {3,3,1,1,2,2,4,4,5,5};
        int[] score = new int[3];
        
        for(int i = 0; i < answers.length; i++) {
        	int a = answers[i];
        	if(a == set1[i%5])
        		score[0]++;
        	if(a == set2[i%8])
        		score[1]++;
        	if(a == set3[i%10])
        		score[2]++;
        } // 정답 확인
        
        int maxN = 0;
        int maxScore = 0;
        for(int i=0; i<score.length; i++) {
        	if(score[i] > maxScore) {
        		maxScore = score[i];
        		maxN = 1;
        	}else if(score[i] == maxScore)
        		maxN++;
        } // 최고점 계산, 최고점 인원 계산
        
        answer = new int[maxN];
        int idx = 0;
        for(int i=0; i<score.length; i++) {
        	if(score[i] == maxScore)
        		answer[idx++] = i+1;
        } // 배열 옮기기
        
        return answer;
    }
}
