package level3;
/*앞뒤를 뒤집어도 똑같은 문자열을 팰린드롬(palindrome)이라고 합니다.
문자열 s가 주어질 때, s의 부분문자열(Substring)중 가장 긴 팰린드롬의 길이를 return 하는 solution 함수를 완성해 주세요.

예를들면, 문자열 s가 "abcdcba"이면 7을 return하고 "abacde"이면 3을 return합니다.

제한사항
문자열 s의 길이 : 2,500 이하의 자연수
문자열 s는 알파벳 소문자로만 구성*/
public class Palindrome {

	public static void main(String[] args) {
		solution("abcdcba");
	}
	// a b c d c b a a b c d c b a b c
	public static int solution(String s)
    {
        int answer = 0;
        // 자신이 대칭중인 문자의 위치 기록
        // 모든 문자의 기본 대칭값은 자기 자신 위치
        // 1) 자신 앞 문자의 대칭값에 해당하는 위치 -1 위치의 문자와 비교
        // 같다면, 해당 문자의 위치를 자신의 대칭값으로 설정
        // 다르다면,  
        
        return answer;
    }
}
