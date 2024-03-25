package level3;
/*앞뒤를 뒤집어도 똑같은 문자열을 팰린드롬(palindrome)이라고 합니다.
문자열 s가 주어질 때, s의 부분문자열(Substring)중 가장 긴 팰린드롬의 길이를 return 하는 solution 함수를 완성해 주세요.

예를들면, 문자열 s가 "abcdcba"이면 7을 return하고 "abacde"이면 3을 return합니다.

제한사항
문자열 s의 길이 : 2,500 이하의 자연수
문자열 s는 알파벳 소문자로만 구성*/
import java.util.*;
public class Palindrome {

	public static void main(String[] args) {
		solution("abcbaabcdcbaabcba");
	}
	// 0 1 
	// 0 1 02 13 024  15 046 357  2468	13579  02468,10
  	// a b  a  b  a    b   a   b     a     b    a
	// a b c b a a b c d c b a a b c b a
	public static int solution(String s)
    {
        int answer = 0;
        // 자신이 대칭중인 문자의 위치 기록
        // 모든 문자의 기본 대칭값은 자기 자신 위치
        // 1) 앞 문자와 같은지?
        // 2) 앞 문자를 사이에 두고 대칭인지 == 앞 문자의 대칭값들의 앞문자와 비교
        // 문자의 대칭 값들을 queue에 저장 후 다음 문자와 비교
        // q에 저장된 최대, 최소값 차이의 최대가 answer
        Queue<Integer> mirrorIdx = new LinkedList<>();
        char pick;
        // 비교해야할 값 = 자신 앞칸, 자신 앞칸의 큐
        for(int i = 0; i < s.length(); i++) {
        	pick = s.charAt(i);
        	mirrorIdx.add(i);
        	int min = mirrorIdx.peek();
        	int mirrorNum = mirrorIdx.size();
        	for(int j = 0; j < mirrorNum; j++) {
        		int p = mirrorIdx.poll();
        		if(p > 0 && pick == s.charAt(p-1)) {
        			mirrorIdx.add(p-1);
        		}
        	}
        	mirrorIdx.add(i);
        	answer = Math.max(answer, i + 2 - min);
        	System.out.println("idx : " + i + " Q : " + mirrorIdx.toString());
        	System.out.println(answer);
        }
        
        return answer;
    }
}
