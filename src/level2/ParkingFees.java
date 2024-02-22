package level2;

import java.util.*;
import java.util.Map.Entry;

public class ParkingFees {
//[180, 5000, 10, 600]	
//["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT",
//"07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]	
//[14600, 34400, 5000]
	public static void main(String[] args) {
		solution(new int[] {180, 5000, 10, 600}, new String[] {
				"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT",
				"07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", 
				"23:00 5961 OUT"});
		
	}
	public static int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        // 각 records 값 읽어와서 시간은 분 단위로 변경
        // 입차면 번호, 24:00까지 남은 시간 +
        // 출차면 번호 검색하여 24:00까지 남은시간 -
        // 번호와 요금은 priority q에 추가(번호 오름차순 정렬)
        // records 순회 종료 후 hash맵에 남아있는 값에 24시 출차 기준으로 정산
        HashMap<Integer, Integer> remainTime = new HashMap<>(); // 번호 - 24시까지 남은 시간
        String[] r = new String[4];
        int id, remains;
        
        for(String record : records) {
        	r = record.split(" |:");
        	id = Integer.parseInt(r[2]);
        	remains = (24 * 60 -1) - Integer.parseInt(r[0]) *60 - Integer.parseInt(r[1]);
        	if(r[3].equals("IN")) {
        		if(remainTime.containsKey(id)) {
        			remainTime.put(id, remainTime.get(id) + remains);
        		}else {
        			remainTime.put(id, remains);
        		}
        	}else {
        		remainTime.put(id, remainTime.get(id) - remains);
        	}
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pay 
        = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>(){

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o1.getKey() - o2.getKey();
			}
        });
        
        pay.addAll(remainTime.entrySet());
        answer = new int[pay.size()];
        
        for(int i = 0; i< answer.length; i++) {
        	answer[i] = calcFee(fees, pay.poll().getValue());
        }
        
        return answer;
    }
	
	
	private static int calcFee(int[] fees, int time) {
		double overTime = (double)time - fees[0];
		int result = fees[1];
		if(overTime > 0) {
			result += fees[3] * (int)Math.ceil(overTime / fees[2]);
		}
		return result;
	}
}
