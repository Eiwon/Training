//1 ≤ topping의 길이 ≤ 1,000,000
//1 ≤ topping의 원소 ≤ 10,000
//입출력 예
//topping	result
//[1, 2, 1, 3, 1, 4, 1, 2]	2
//[1, 2, 3, 1, 4]	0

package level2New;
import java.util.*;

public class CakeCut {

	public static void main(String[] args) {
		solution(new int[] {1, 2, 1, 3, 1, 4, 1, 2});
	}
	
	public static int solution(int[] topping) {
        int answer = 0, n = topping.length;
        HashSet<Integer> rightT = new HashSet<>();
        HashSet<Integer> leftT = new HashSet<>();
        int[] rightTypeNum = new int[n];

        if(topping.length == 1) return 0;
        for(int i = 0; i < n; i++) {
        	rightT.add(topping[i]);
        	rightTypeNum[i] = rightT.size();
        }
        for(int a : rightTypeNum)
        	System.out.print(a + " ");
        System.out.println();
        for(int i = n-1; i > 0; i--) {
        	leftT.add(topping[i]);
        	if(leftT.size() == rightTypeNum[i - 1]) {
        		System.out.println("0~" + (i-1) + " + " + i + "~ n-1");
        		answer++;
        	}
        }
        System.out.println(answer);
        
        return answer;
    }
}
