//LZW 압축은 다음 과정을 거친다.
//
//길이가 1인 모든 단어를 포함하도록 사전을 초기화한다.
//사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다.
//w에 해당하는 사전의 색인 번호를 출력하고, 입력에서 w를 제거한다.
//입력에서 처리되지 않은 다음 글자가 남아있다면(c), w+c에 해당하는 단어를 사전에 등록한다.
//단계 2로 돌아간다.
package level2;

import java.util.*;

public class Compression {
//TOBEORNOTTOBEORTOBEORNOT	
//[20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]

	public static void main(String[] args) {
		solution("TOBEORNOTTOBEORTOBEORNOT");

	}
	public static int[] solution(String msg) {
        int[] answer = {};
        //사전 초기화, 사전에 등록된 가장 긴 단어 길이(maxLen) 저장
        // 길이 maxLen부터 1까지 문자열 자르면서 사전 검색
        // ㄴ 사전에 있으면 list에 인덱스 추가, 다음 글자까지 사전에 등록
        // ㄴ 위의 '다음 글자'부터 다음 탐색 진행
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> ls = new ArrayList<>();
        int maxLen = 1, idx = 27;
        String subStr = "";
        for(int i = 0; i < 26; i++) {
        	char c = (char) ('A' +i);
        	map.put(Character.toString(c), i+1);
        } // 사전에 a-z 등록
        for(int w = 0; w < msg.length(); w++) {
        	// msg의 각 문자 탐색
        	for(int i = maxLen; i >= 1; i--) {
        		int end = Math.min(w+i, msg.length()); 
        		subStr = msg.substring(w, end);
        		if(map.containsKey(subStr)) { // 있는 단어이면
        			ls.add(map.get(subStr));
        			if(w+i < msg.length()) { // 다음 문자가 있을때
        				map.put(subStr.concat(Character.toString(msg.charAt(w+i))) , idx++);
        				w = w+i-1;
        				maxLen = Math.max(maxLen, i+1);
        			}else { // 다음 문자가 없을때
        				w = w+i;
        			}
        			break;
        		}
        	}
        }
        System.out.println(map.toString());
        System.out.println(ls.toString());
        
        answer = new int[ls.size()];
        for(int i=0; i<answer.length; i++) {
        	answer[i] = ls.get(i);
        }
        
        return answer;
    }
}
