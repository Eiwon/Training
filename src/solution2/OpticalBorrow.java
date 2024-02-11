//. 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다
//전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
//
//제한사항
//전체 학생의 수는 2명 이상 30명 이하입니다.
//체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
//여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
//여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
//여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
package solution2;
//5	[2, 4]	[1, 3, 5]	5
import java.util.*;
public class OpticalBorrow {
	public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        boolean[] isLost = new boolean[n];
        
        for(int i=0; i<lost.length; i++) {
        	isLost[lost[i] -1] = true;
        }
        
        for(int i=0; i<reserve.length; i++) {
        	int rs = reserve[i] -1;
        	
        	if(isLost[rs]) {
        		isLost[rs] = false;
        		reserve[i] = 0;
        	}
        }
        Arrays.sort(reserve);
        
        for(int i : reserve) {
        	if(i > 0) {
        		int reserver = i-1;
        		if(reserver > 0 && isLost[reserver -1] == true) {
        			isLost[reserver -1] = false;
        		}else if(reserver +1 < n && isLost[reserver +1] == true){
        			isLost[reserver +1] = false;
        		}
        	}
        }
        
        for(boolean i : isLost) {
        	if(i == false) answer++;
        	System.out.print(i + " ");        	
        }
        System.out.println(answer);
        return answer;
    }
}
