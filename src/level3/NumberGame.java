package level3;
import java.util.*;
/*먼저 모든 사원이 무작위로 자연수를 하나씩 부여받습니다.
각 사원은 딱 한 번씩 경기를 합니다.
각 경기당 A팀에서 한 사원이, B팀에서 한 사원이 나와 서로의 수를 공개합니다. 그때 숫자가 큰 쪽이 승리하게 되고, 승리한 사원이 속한 팀은 승점을 1점 얻게 됩니다.
만약 숫자가 같다면 누구도 승점을 얻지 않습니다.*/
public class NumberGame {
//[5,1,3,7]	[2,2,6,8]	3
	public static void main(String[] args) {
		solution(new int[] {5,1,3,7}, new int[]{2,2,6,8});
	}

	public static int solution(int[] A, int[] B) {
        int answer = 0;
        LinkedList<Integer> cardList = new LinkedList<>();
        
        Arrays.sort(A);
        for(int b : B)
        	cardList.add(b);
        cardList.sort(null);
        
        for(int i = A.length -1; i >= 0; i--) {
        	if(cardList.getLast() > A[i]) {
        		cardList.removeLast();
        		answer++;
        	}else {
        		cardList.removeFirst();
        	}
        }
        
        return answer;
    }

	
}
