package level2;

import java.util.*;

public class PhoneBook {
//"119", "97674223", "1195524421"]	false
	public static void main(String[] args) {
		solution(new String[] {"119", "97674223", "1195524421"});
	}
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        for(int i=0; i<phone_book.length; i++) {
        	phone_book[i] = phone_book[i].strip();
        }
        
        Arrays.sort(phone_book, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
        	
        });
        
        HashSet<String> hSet = new HashSet<>();
        int minLen = phone_book[0].length();
        int maxLen = phone_book[0].length();
        for(String s : phone_book) {
        	for(int len = minLen; len < maxLen+1; len++) {
        		if(hSet.contains(s.substring(0, len))) {
        			System.out.println(hSet.toString() + " " + s);
        			return false;
        		}
        	}
        	hSet.add(s);
        	maxLen = s.length();
        }
        
        System.out.println(answer);
        return answer;
    }
}
