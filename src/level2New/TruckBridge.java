package level2New;

import java.util.*;

public class TruckBridge {
//2	10	[7,4,5,6]	8
	public static void main(String[] args) {
		solution(2, 10, new int[] {7,4,5,6});
		
	}
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int remainW = weight, passed = 0, idx = 0;
        Queue<Truck> bridge = new LinkedList<>();
        // q에 트럭(무게, 진입시간) 추가
        // q의 맨 앞의 t - 진입시간 == bridge_length면 q에서 제거, passed++
        
        while(passed < truck_weights.length) {
        	answer++;
        	if(bridge.size() > 0 && answer - bridge.peek().inTime == bridge_length) {
        		remainW += bridge.poll().weight;
        		passed++;
        	} // 트럭 통과
        	if(idx < truck_weights.length && remainW >= truck_weights[idx]) {
        		bridge.add(new Truck(truck_weights[idx], answer));
        		remainW -= truck_weights[idx];
        		idx++;
        	} // 트럭 진입
        	System.out.println(answer + " : " + bridge.toString());
        }
        System.out.println(answer);
        
        return answer;
    }
}

class Truck {
	public int weight;
	public int inTime;
	
	public Truck(int weight, int inTime) {
		this.weight = weight;
		this.inTime = inTime;
	}
}
