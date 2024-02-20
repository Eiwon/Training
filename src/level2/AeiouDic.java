//사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는, 길이 5 이하의 모든 단어가 수록되어 있습니다. 사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA"이며, 마지막 단어는 "UUUUU"입니다.
//
//단어 하나 word가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지 return 하도록 solution 함수를 완성해주세요.
//
//제한사항
//word의 길이는 1 이상 5 이하입니다.
//word는 알파벳 대문자 'A', 'E', 'I', 'O', 'U'로만 이루어져 있습니다.
//"AAAAE"	6
package level2;

public class AeiouDic {

	private static int count = 0; 
	
	public static void main(String[] args) {
		solution("EIO");

	}
	
	public static int solution(String word) {
        int answer = 0;
        String maked = "";
        // 재귀함수로 a~u 탐색
        answer = search(word, maked);
        System.out.println(count);
        
        return answer;
    }
	
	public static int search(String word, String maked) {
		char[] set = {'A', 'E', 'I', 'O', 'U'};
		String mk = maked;
		int result = 0;
		System.out.println(maked + " " + count);
		
		if(word.equals(maked)) {//종료 조건
			return 1;
		}
		count++;
		if(maked.length() == 5)
			return 0;

		// 반복
		
		for(int i = 0; i < set.length; i++) {
			
			result = search(word, mk +set[i]);
			if(result != 0) {
				return result;
			}
		}
		
		return 0;
	}
	
}
