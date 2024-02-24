//record	result
//["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234",
//"Enter uid1234 Prodo","Change uid4567 Ryan"]	
//["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", 
//"Prodo님이 들어왔습니다."]

package level2New;
import java.util.*;

public class ChatRoom {

	public static void main(String[] args) {
		solution(new String[] {
				"Enter uid1234 Muzi", 
				"Enter uid4567 Prodo",
				"Leave uid1234",
				"Enter uid1234 Prodo",
				"Change uid4567 Ryan"
		});
	}
	
	public static String[] solution(String[] record) {
        String[] answer = {};
        // uid와 이름을 등록할 hashMap
        // uid와 in/out 타임라인을 관리할 리스트
        
        HashMap<String, String> nameMap = new HashMap<>();
        List<Map.Entry<String, Boolean>> timeLine = new ArrayList<>();
        
        String[] command;
        for(String rec : record) {
        	command = rec.split(" ");
        	
        	if(command[0].equals("Enter")) {
        		timeLine.add(Map.entry(command[1], true));
        		nameMap.put(command[1], command[2]);
        	}else if(command[0].equals("Leave")) {
        		timeLine.add(Map.entry(command[1], false));
        	}else {
        		nameMap.put(command[1], command[2]);
        	}
        }
        
        answer = new String[timeLine.size()];
        for(int i = 0; i < timeLine.size(); i++) {
        	if(timeLine.get(i).getValue() == true) {
        		answer[i] = nameMap.get(timeLine.get(i).getKey()) + "님이 들어왔습니다.";
        	}else {
        		answer[i] = nameMap.get(timeLine.get(i).getKey()) + "님이 나갔습니다.";
        	}
        }
        
        for(String rec : answer)
        	System.out.println(rec);
        
        return answer;
    }
}
