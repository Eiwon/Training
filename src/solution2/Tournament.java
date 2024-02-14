//처음 라운드에서 A번을 가진 참가자는 경쟁자로 생각하는 B번 참가자와 몇 번째 라운드에서 만나는지 궁금해졌습니다. 게임 참가자 수 N, 참가자 번호 A, 경쟁자 번호 B가 함수 solution의 매개변수로 주어질 때, 처음 라운드에서 A번을 가진 참가자는 경쟁자로 생각하는 B번 참가자와 몇 번째 라운드에서 만나는지 return 하는 solution 함수를 완성해 주세요. 단, A번 참가자와 B번 참가자는 서로 붙게 되기 전까지 항상 이긴다고 가정합니다.
//
//제한사항
//N : 21 이상 220 이하인 자연수 (2의 지수 승으로 주어지므로 부전승은 발생하지 않습니다.)
//A, B : N 이하인 자연수 (단, A ≠ B 입니다.)

package solution2;

public class Tournament {

	public static void main(String[] args) {
		solution(8, 4, 7);
	}

	public static int solution(int n, int a, int b){
	    int answer = 0;
	    while(a != b) {
	    	a = (a +1) /2;
	    	b = (b +1) /2;
	    	answer++;
	    }
	    return answer;
	}
	
}
