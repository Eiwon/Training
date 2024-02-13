package solution2;
import java.util.*;

public class WordChain {

	public static void main(String[] args) {
		solution(2, new String[] {
				"hello", "one", "even", "never", "now", "world", "draw"
				});
	}
	
	public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        // 첫글자가 이전 단어 마지막 글자와 안맞으면 탈락1
        // 이전에 나왔던 단어 말하면 탈락2
        // words 끝까지 다 돌면 성공
        HashMap<String, Boolean> record = new HashMap<>();
        char lastCha = 0;
        String word = "";
        for(int turn = 0; turn < words.length; turn++) {
        	word = words[turn];
        	if(((lastCha != 0 && word.charAt(0) != lastCha))// 탈락1
        			|| record.containsKey(word)) { // 탈락2
        		answer[0] = turn % n +1;
        		answer[1] = turn / n +1;
        		break;
        	}else {
        		record.put(word, false);
        	}
        	lastCha = word.charAt(word.length()-1);
        }
        System.out.println(answer[0] + " " + answer[1]);
        
        return answer;
    }
}
