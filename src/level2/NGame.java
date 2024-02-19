//진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p 가 주어진다.
//
//2 ≦ n ≦ 16
//0 ＜ t ≦ 1000
//2 ≦ m ≦ 100
//1 ≦ p ≦ m
//출력 형식
//튜브가 말해야 하는 숫자 t개를 공백 없이 차례대로 나타낸 문자열. 단, 10~15는 각각 대문자 A~F로 출력한다.

package level2;

import java.lang.StringBuilder;

public class NGame {
//16	16	2	2	"13579BDF01234567"
	public static void main(String[] args) {
		solution(2, 4, 2, 1);
	}
	public static String solution(int n, int t, int m, int p) {
        String answer = "";
        // 말해야 하는 수를 저장
        // 저장한 수를 n진수로 변환
        // 턴마다 1자리씩 떼와서 쓰고, 더이상 떼올 수가 없으면 말해야하는 수 +1
        int talkNum = 0;
        int turn = 1, searchNum = 0, userTurn = p % m;
        String talkNumCon = "0";
        int talkNumConIdx = 1;
        while(searchNum < t) {
        	if(talkNumCon.length() == talkNumConIdx) {
        		talkNumCon = conv(talkNum++, n);
        		talkNumConIdx = 0;
        	}// 말할 수가 없으면 새 숫자 가져옴
        	if(turn % m == userTurn) {
        		answer += talkNumCon.charAt(talkNumConIdx);
        		System.out.println(answer);
        		searchNum++;
        	}
        	talkNumConIdx++;
        	turn++;
        	// 한글자를 떼와서(talkNumCon.charAt(talkNumConIdx++)) p 차례면 (turn %m == userTurn) searchNum++,  
        }
        
        return answer;
    }
	private static String conv(int talkNum, int n) {
		// talkNum을 n진수로 변환
		StringBuilder sb = new StringBuilder();
		int num = 0;
		if(talkNum == 0) return "0";
		while(talkNum > 0) {
			num = talkNum % n;
			if(num < 10) {
				sb.append(Integer.toString(num));
			}else {
				sb.append((char)((num-10) +'A'));
			}
			
			talkNum /= n;
		}
		sb.reverse();
		return sb.toString();
	}
}
