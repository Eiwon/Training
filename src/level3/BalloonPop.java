package level3;

import java.util.*;

public class BalloonPop {
//[-16,27,65,-2,58,-92,-71,-68,-61,-33]	6
	public static void main(String[] args) {
		solution(new int[] {-16,27,65,-2,58,-92,-71,-68,-61,-33});

	}
	public static int solution(int[] a) {
        int answer = 0;
        int len = a.length;
        // noChance[n] = noChance[n-1]에서 a[n]보다 큰값 전부 pop, pop을 1회라도 했다면 add a[n]
        // chance[n] = 위 결과의 pop을 전부 add, noChance에 남은 값이 있다면 add a[n]
        // 			+  chance[n-1]에서 a[n]보다 큰 값 전부 pop, pop을 1회라도 했다면 add a[n]
        PriorityQueue<Integer> noChance = new PriorityQueue<>((i1, i2) -> (i2 - i1));
        PriorityQueue<Integer> chance = new PriorityQueue<>((i1, i2) -> (i2 - i1));
        noChance.add(Math.min(a[0], a[1]));
        chance.add(Math.max(a[0], a[1]));
        boolean chancePoll = false, noChancePoll = false;
        for(int n = 2; n < len; n++) {
        	while(chance.size() > 0 && chance.peek() > a[n]) {
        		chance.poll();
        		chancePoll = true;
        	}
        	while(noChance.size() > 0 && noChance.peek() > a[n]) {
        		chance.add(noChance.poll());
        	}
        	if(chancePoll) {
        		chance.add(a[n]);
        		chancePoll = false;
        	}
        	if(noChance.size() > 0 && noChance.peek() < a[n]) {
        		noChance.add(a[n]);
        	}
        	System.out.println("------n = " + n + "--------");
        	System.out.println(chance.toString());
        	System.out.println(noChance.toString());
        }
        
        return answer;
    }
}
