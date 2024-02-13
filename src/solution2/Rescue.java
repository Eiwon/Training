//무인도에 갇힌 사람은 1명 이상 50,000명 이하입니다.
//각 사람의 몸무게는 40kg 이상 240kg 이하입니다.
//구명보트의 무게 제한은 40kg 이상 240kg 이하입니다.
//구명보트의 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어지므로 사람들을 구출할 수 없는 경우는 없습니다.

package solution2;

import java.util.*;

public class Rescue {

	public static void main(String[] args) {
		solution(new int[]{70, 50, 80, 50},	100);
	}
	public static int solution(int[] people, int limit) {
        int answer = 0;
        // people 내림차순 정렬
        
        List<Integer> pp = new LinkedList<>();
        
        for(int i : people) {
        	pp.add(i);
        }
        pp.sort(null);
        
        int remains;
        while(pp.size() > 0) {
        	remains = limit - pp.get(0);
        	pp.remove(0);
        	answer++;
        	while(pp.size() > 0 && remains < pp.get(pp.size()-1)) {
        		pp.remove(pp.size()-1);
        		answer++;
        	}
        	//1. 더이상 원소가 없는 경우
        	//2. 2명이 탑승 가능한 경우를 찾은 경우
        	if(pp.size() == 0) {
        		break;
        	}else {
        		pp.remove(pp.size()-1);
        	}
        	
        }
        System.out.println(answer);
        return answer;
    }
}
