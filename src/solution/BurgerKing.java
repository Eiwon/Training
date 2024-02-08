// 상수가 일하는 가게는 정해진 순서(아래서부터, 빵 – 야채 – 고기 - 빵)로 쌓인 햄버거만 포장을 합니다. 상수는 손이 굉장히 빠르기 때문에 상수가 포장하는 동안 속 재료가 추가적으로 들어오는 일은 없으며, 재료의 높이는 무시하여 재료가 높이 쌓여서 일이 힘들어지는 경우는 없습니다.
//
//예를 들어, 상수의 앞에 쌓이는 재료의 순서가 [야채, 빵, 빵, 야채, 고기, 빵, 야채, 고기, 빵]일 때, 상수는 여섯 번째 재료가 쌓였을 때, 세 번째 재료부터 여섯 번째 재료를 이용하여 햄버거를 포장하고, 아홉 번째 재료가 쌓였을 때, 두 번째 재료와 일곱 번째 재료부터 아홉 번째 재료를 이용하여 햄버거를 포장합니다. 즉, 2개의 햄버거를 포장하게 됩니다.
//
//상수에게 전해지는 재료의 정보를 나타내는 정수 배열 ingredient가 주어졌을 때, 상수가 포장하는 햄버거의 개수를 return 하도록 solution 함수를 완성하시오.
//
//제한사항
//1 ≤ ingredient의 길이 ≤ 1,000,000
//ingredient의 원소는 1, 2, 3 중 하나의 값이며, 순서대로 빵, 야채, 고기를 의미합니다.

package solution;
import java.util.*;

public class BurgerKing {
	public int solution(int[] ingredient) {
        int answer = 0;
        int[] set = new int[3];
        //stack
        //1231 쌓이면 제거
        Stack<Integer> stand = new Stack<>();
        for(int ig : ingredient) {
        	if(stand.size() > 2 && ig == 1) { // 재료가 3개 이상일때 빵이 오면
        		for(int i=0; i<set.length; i++) { // 재료 3개를 뽑아서 확인
        			set[i] = stand.pop();
        		}
        		if((set[0] == 3 & set[1] == 2 & set[2] == 1)){
        			answer++;
        			continue; // 뽑은거로 버거 만들 수 있으면 그대로 진행
        		}else {
        			for(int i=set.length-1; i>=0; i--) {//못 만들면 다시 스택에 넣음
        				stand.push(set[i]);
        			}
        		}
        	}
        	stand.push(ig);        			
        }
        
        return answer;
    }
}
