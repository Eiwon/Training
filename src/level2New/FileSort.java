package level2New;
//
//입력: ["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"]
//출력: ["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]
import java.util.*;

public class FileSort {

	public static void main(String[] args) {
		solution(new String[] {"img12.png", "img10.png", "img02.png", 
				"img1.png", "IMG01.GIF", "img2.JPG", "img12"});
	}
	public static String[] solution(String[] files) {
        String[] answer = {};
        // HEAD, NUMBER 구분
        // 대소문자 구분 없이 HEAD 문자열 비교
        // NUMBER를 int로 변환하여 비교
        PriorityQueue<FileName> pq = new PriorityQueue<>();
        
        for(int i = 0; i < files.length; i++) {
        	
        	FileName f = new FileName(files[i], i);
        	pq.add(f);
        }
        answer = new String[pq.size()];
        
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = pq.poll().toString();
        	System.out.println(answer[i]);
        }
        
        return answer;
    }
}
class FileName implements Comparable{
	String head;
	String number;
	String tail;
	int id;
	
	FileName(String str, int id){
		str = str.concat("a");
		this.id = id;
		int idx = 0;
		for(int i=0; i<str.length(); i++) {
			if(head == null && Character.isDigit(str.charAt(i))) {
				head = str.substring(0, i);
				idx = i;
			}
			if(head != null && !Character.isDigit(str.charAt(i))) {
				number = str.substring(idx, i);
				tail = str.substring(i, str.length() -1);
				break;
			}
		}
	}
	
	@Override
	public String toString() {
		return head + number + tail;
	}

	@Override
	public int compareTo(Object o) {
		FileName other = (FileName)o;
		int hCmp = head.compareToIgnoreCase(other.head);
		
		if(hCmp == 0) {
			int nCmp = Integer.parseInt(number) - Integer.parseInt(other.number);
			if(nCmp == 0) {
				return id - other.id;
			}else return nCmp;
			
		}else return hCmp;
	}
	
}

