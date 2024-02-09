package solution;

//정렬

import java.util.*;
public class FailRate {
	 public int[] solution(int N, int[] stages) {
	        int[] answer = {};
	        // 실패율 = stages 값이 n인 사람 수 / n보다 크거나 같은 사람 수
	        // 실패율 먼저 구하기
	        // 실패율과 stageNum가 함께 적힌 배열을 만들어서 정렬
	         int[] maxStage = new int[N];
	        int[] passStage = new int[N];
	        List<double[]> failRate = new ArrayList<>();
	         for(int i=0; i<stages.length; i++) {
	        	int s = stages[i] -1;
	        	if(s == N)
	        		s = N -1;
	        	else maxStage[s]++;// 각 stage에 전복된 인원
	        	
	        	for(int j=0; j<=s; j++) {
	        		passStage[j]++;
	        	}
	        } 
	        
	        // 각 스테이지별 실패율
	        for(int i=0; i<N; i++) {
	        	double[] fr = new double[2];
	        	fr[0] = i+1;
	        	if(passStage[i] == 0)
	        		fr[1] = 0;
	        	else
	        		fr[1] = (double) maxStage[i] / passStage[i];
	        	failRate.add(fr);
	        }
	        
	        Collections.sort(failRate, (o1, o2) -> 
	        o1[1] == o2[1] ? Double.compare(o1[0], o2[0]) : Double.compare(o2[1], o1[1]));
	        //Collections.sort(failRate, (o1, o2) -> Double.compare(o2[1], o1[1]));
	        answer = new int[N];
	        
	        for(int f = 0; f<N; f++) {
	        	double rank = failRate.get(f)[0];
	        	answer[f] = (int)rank;
	        	System.out.print(rank + " ");
	        }
	        return answer;
	    }
}
