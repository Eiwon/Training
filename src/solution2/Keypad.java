//맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.
//
//엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
//왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
//오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
//가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
//4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
//순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때, 각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.
//
//[제한사항]
//numbers 배열의 크기는 1 이상 1,000 이하입니다.
//numbers 배열 원소의 값은 0 이상 9 이하인 정수입니다.
//hand는 "left" 또는 "right" 입니다.
//"left"는 왼손잡이, "right"는 오른손잡이를 의미합니다.
//왼손 엄지손가락을 사용한 경우는 L, 오른손 엄지손가락을 사용한 경우는 R을 순서대로 이어붙여 문자열 형태로 return 해주세요.


package solution2;
//[1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]	"right"	"LRLLLRLLRRL"
import java.util.*;
import java.lang.StringBuilder;
public class Keypad {
	public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder result = new StringBuilder();
        boolean isRight = hand.equals("right") ? true : false;
        int leftP = 10, rightP = 11;
        // 147은 왼손  369는 오른손
        // 각 손가락 위치 저장
        // 2580은 거리 계산 후 가까운쪽, 거리 같으면 isRight 따라
        
        for(int num : numbers) {
        	if(num == 1 || num == 4 || num == 7) {// 왼손
        		result.append('L');
        		leftP = num;
        	}else if(num == 3 || num == 6 || num == 9) {//오른손
        		result.append('R');
        		rightP = num;
        	}else {
        		int d = calcDistance(num, rightP, leftP);
        		if(d == 1 || (d == 0 && isRight)) {
        			result.append('R');
            		rightP = num;
        		}else {
        			result.append('L');
            		leftP = num;
        		}
        	}
        }
        answer = result.toString();
        System.out.println(answer);
        return answer;
    }

	private int calcDistance(int num, int rightP, int leftP) {
		// 오른손이 가까우면 1, 왼손이 가까우면 -1, 똑같으면 0 
		int[][] keypad = {{3,1}, {0,0}, {0,1}, {0,2}, {1,0},
				  {1,1}, {1,2}, {2,0}, {2,1}, {2,2}, {3,0}, {3,1}};
		int rd = Math.abs(keypad[num][0] - keypad[rightP][0])
				+ Math.abs(keypad[num][1] - keypad[rightP][1]);
		int ld = Math.abs(keypad[num][0] - keypad[leftP][0])
				+ Math.abs(keypad[num][1] - keypad[leftP][1]);
		if(rd < ld)
			return 1;
		else if(rd > ld)
			return -1;
		
		return 0;
	}
}
