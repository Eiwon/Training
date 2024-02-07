//마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
//
//제한사항
//마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
//completion의 길이는 participant의 길이보다 1 작습니다.
//참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
//참가자 중에는 동명이인이 있을 수 있습니다.
package solution;
import java.util.*;
// replace : 교체한 후 이전값 return, 존재하지 않는 키면 null return 
// put : 존재하지 않는 키면 null (무조건 바꿈)

public class FailedPlayer {
	public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> player = new HashMap<>();
        
        for(String pt : participant) {
        	int n = player.getOrDefault(pt, 0);
        	player.put(pt, n+1);
        }
        
        for(String cl : completion) {
        	int n = player.get(cl);
        	if(n == 1)
        		player.remove(cl);
        	else
        		player.replace(cl, n-1);
        }
        
        for(String pt : participant) {
        	if(player.containsKey(pt)) {
        		answer = pt;
        		break;
        	}
        }
        
        return answer;
    }
}
