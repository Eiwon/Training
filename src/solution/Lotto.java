package solution;

public class Lotto {
	public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int matchNum = 0;
        int zeroNum = 0;
       
        for(int i=0; i<lottos.length; i++) {
        	if(lottos[i] == 0) {
        		zeroNum++;
        	}else {
        		for(int j=0; j<win_nums.length; j++) {
        			if(lottos[i] == win_nums[j]) {
        				matchNum++;
        			}
        		}
        	}
        }
        
        answer[0] = Math.min(6, 7 - matchNum - zeroNum);
        answer[1] = Math.min(6, 7 - matchNum);
        
        
        return answer;
    }
}
