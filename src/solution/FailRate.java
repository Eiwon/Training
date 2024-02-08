package solution;

import java.util.*;
public class FailRate {
	 public int[] solution(int N, int[] stages) {
	        int[] answer = {};
	        int activeStageNum = 0;
	        // 실패율 = stages 값이 n인 사람 수 / n보다 크거나 같은 사람 수
	        // 실패율 먼저 구하기
	        // 실패율과 stageNum가 함께 적힌 배열을 만들어서 정렬
	        //[3,4,2,1,5]
	        int[][] maxStage = new int[2][stages.length];
	        Arrays.sort(stages);
	        int lastN = 0;
	        int count = 0;
	        for(int i=0; i<stages.length; i++) {
	        	if(stages[i] != lastN) {
	        		count = 1;
	        		lastN = stages[i];
	        	}
	        }
	        
	        for(int s : stages)
	        	System.out.print(s + " ");
	        
	        return answer;
	    }
}
