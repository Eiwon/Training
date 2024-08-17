package solution3;
import java.util.*;
public class Basic10 {
	public int solution1(int[] sides) {
        int answer = 0;
        int max = 0;
        for(int side : sides) {
        	max = Math.max(side, max);
        	answer += side;
        }
        
        return (answer - max > max) ? 1 : 2; 
    }
	
	public String solution2(String my_string) {
        String answer = "";
        Set<Character> set = new HashSet<>();
        char p;
        
        for(int i = 0; i < my_string.length(); i++) {
        	p = my_string.charAt(i);
        	if(!set.contains(p)) {
        		answer += p;
        		set.add(p);
        	}
        }
        
        return answer;
    }
	public int solution3(int i, int j, int k) {
        int answer = 0;
        int p;
        for(int num = i; num <= j; num++) {
        	p = num;
        	while(p > 0) {
        		if(p % 10 == k) {
        			answer++;
        		}
        		p /= 10;
        	}
        }
        
        return answer;
    }
	public int solution4(String before, String after) {
        int[] appear = new int[26];
        
        for(int i = 0; i < before.length(); i++) {
        	appear[before.charAt(i) - 'a']++;
        	appear[after.charAt(i) - 'a']--;
        }
        
        for(int appearNum : appear) {
        	if(appearNum != 0) return 0;
        }
        
        return 1;
    }
	public String solution5(String bin1, String bin2) {
        String answer = "";
        int len1 = bin1.length(), len2 = bin2.length(),
        	len = Math.max(len1, len2), up = 0;
        int p1, p2;
        for(int i = 1; i <= len; i++) {
        	p1 = (len1 - i >= 0) ? Character.getNumericValue(bin1.charAt(len1 - i)) : 0;
        	p2 = (len2 - i >= 0) ? Character.getNumericValue(bin2.charAt(len2 - i)) : 0;
        	answer = Integer.toString((p1 + p2 + up) % 2).concat(answer);
        	up = (p1 + p2 + up) / 2;
        }
        if(up > 0) {
        	answer = Integer.toString(up).concat(answer);
        }
        
        return answer;
    }
}
