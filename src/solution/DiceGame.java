//1부터 6까지 숫자가 적힌 주사위가 네 개 있습니다. 네 주사위를 굴렸을 때 나온 숫자에 따라 다음과 같은 점수를 얻습니다.
//
//네 주사위에서 나온 숫자가 모두 p로 같다면 1111 × p점을 얻습니다.
//세 주사위에서 나온 숫자가 p로 같고 나머지 다른 주사위에서 나온 숫자가 q(p ≠ q)라면 (10 × p + q)2 점을 얻습니다.
//주사위가 두 개씩 같은 값이 나오고, 나온 숫자를 각각 p, q(p ≠ q)라고 한다면 (p + q) × |p - q|점을 얻습니다.
//어느 두 주사위에서 나온 숫자가 p로 같고 나머지 두 주사위에서 나온 숫자가 각각 p와 다른 q, r(q ≠ r)이라면 q × r점을 얻습니다.
//네 주사위에 적힌 숫자가 모두 다르다면 나온 숫자 중 가장 작은 숫자 만큼의 점수를 얻습니다.
//네 주사위를 굴렸을 때 나온 숫자가 정수 매개변수 a, b, c, d로 주어질 때, 얻는 점수를 return 하는 solution 함수를 작성해 주세요.
//
//제한사항
//a, b, c, d는 1 이상 6 이하의 정수입니다.

package solution;

public class DiceGame {
	public int solution(int a, int b, int c, int d) {
        int answer = 0;
        // 4회, 3회, 2회, 2회+2회, 1회
        // 4회 = 1111*p
        // 3회 = (10*p +q)^2
        // 2+2회 = (p+q) * |p-q|
        // 2+1+1회 = q*r
        // 1회 = minVal
        // p : 최다등장값, q : 최다등장이 아닌 값1, r : q가 0이 아닐때 넣을 공간
        
        int[] dice = {0, 0, 0, 0, 0, 0, 0};
        int maxAppear = 0;
        int p = 0, q = 0, r = 0;
        
        dice[a]++;
        dice[b]++;
        dice[c]++;
        dice[d]++;
        
        for(int i=1; i<7; i++){
            maxAppear = maxAppear < dice[i] ? dice[i] : maxAppear;
        }
        for(int i=1; i<7; i++)
        	System.out.print(dice[i] + " ");
        System.out.println("     " + maxAppear);
        
        for(int i=1; i<7; i++) {
        	if(dice[i] == maxAppear) {
        		if(p == 0)
        			p = i;
        		else q = i;
        	}
        	else if(dice[i] == 1) {
        		if(q == 0)
        			q = i;
        		else r = i;
        	} // q : maxApp랑 같고 p가 0이 아닐때 or q가 0이고 dice[i]가 1일때
        }
        System.out.println("p : " + p + "q : " + q + "r : " + r);
        if(maxAppear == 4) {
        	answer = 1111*p;
        }else if(maxAppear == 3) {
        	answer = (10*p +q) *(10*p +q);
        }else if(maxAppear == 1) {
        	for(int i=1; i<7; i++) {
        		if(dice[i] == maxAppear) {
        			answer = i;
        			break;
        		}
        	}
        }else { //2+1+1인 경우 or 2+2인 경우
        	if(r != 0)// 2+1+1
        		answer = q * r;
        	else {	// 2+2
        		answer = p > q ? (p-q) *(p+q) : (q-p) * (p+q);
        	}
        }
        
        return answer;
    }
}
