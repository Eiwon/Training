package level2New;

public class MusicBox {

	public static void main(String[] args) {
		solution("ABC", new String[] {
				"12:00,12:14,HELLO,C#DEFGAB", 
				"13:00,13:05,WORLD,ABCDEF"
		});
	}
	
	public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        Music[] musicSet = new Music[musicinfos.length];
        // 시간은 분 단위로 바꿔서 그 차이에 해당하는 멜로디 생성
        for(int i = 0; i < musicinfos.length; i++) {
        	musicSet[i] = new Music(musicinfos[i]);
        }
        int maxLen = 0;
        for(int i = 0; i < musicinfos.length; i++) {
        	if(musicSet[i].isContains(m)) {
        		if(musicSet[i].length > maxLen) {
        			maxLen = musicSet[i].length;
        			answer = musicSet[i].name;
        		}
        	}
        }
        
        return answer;
    }
}
class Music{
	String name = "";
	String melody = "";
	int length = 0;
	
	public Music(String musicInfo) {
		String[] mi = musicInfo.split(",");
		length = Integer.parseInt(mi[1].substring(0, 2))*60 + Integer.parseInt(mi[1].substring(3, 5));
		length -= Integer.parseInt(mi[0].substring(0, 2))*60 + Integer.parseInt(mi[0].substring(3, 5));
		name = mi[2];
		String res = removeShop(mi[3]);
		
		for(int i = 0; i < length; i++) {
			melody += res.charAt(i % res.length());
		}
		
	}
	
	public boolean isContains(String m) {
		return melody.contains(removeShop(m));
	}
	
	public String removeShop(String m) {
		String res = "";
		for(int i = 0; i < m.length(); i++) {
			if(m.charAt(i) != '#') {
				if(i+1 < m.length() && m.charAt(i+1) == '#') {
					res += Character.toLowerCase(m.charAt(i));
				}else res += m.charAt(i);
			}
		}
		return res;
	}
	
}
