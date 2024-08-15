package solution3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Basic8 {
	public int solution1(int M, int N) {
		return M * N - 1;
    }
	public String[] solution2(String my_str, int n) {
        int len = my_str.length();
        String[] answer = new String[(len + n - 1) / n];
        int idx = 0;
        for(int i = 0; idx < answer.length; i += n) {
        	answer[idx++] = my_str.substring(i, Math.min(i + n, len));
        }
        
        return answer;
    }
	public int solution3(int[] array) {
        int answer = 0;
        
        for(int num : array) {
        	while(num > 0) {
        		if(num % 10 == 7) answer++;
        		num /= 10;
        	}
        }
        
        return answer;
    }
	public String solution4(String my_string) {
        char[] charArray = my_string.toLowerCase().toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray, 0, charArray.length);
    }
	public int solution5(int n) {
        for(int i = 1, squar = 0; squar < n; i++) {
        	squar = i * i;
        	if(squar == n) return 1;
        }
        
        return 2;
    }
	public int solution6(String str1, String str2) {
        return str1.contains(str2) ? 1 : 2;
    }
	public int solution7(int n) {
        int answer = 0;
        while(n > 0) {
        	answer += n % 10;
        	n /= 10;
        }
        return answer;
    }
	public int[] solution8(int n, int[] numlist) {
        int[] answer = new int[numlist.length];
        int len = 0;
        for(int num : numlist) {
        	if(num % n == 0) {
        		answer[len++] = num;
        	}
        }
        
        answer = Arrays.copyOfRange(answer, 0, len);
        return answer;
    }
	public int solution9(int num, int k) {
		int answer = String.valueOf(num).indexOf(String.valueOf(k));
        return answer > -1 ? answer + 1: answer;
    }
	public int solution10(String[] s1, String[] s2) {
        int answer = 0;
        Set<String> set = new HashSet<>();
        for(String str1 : s1) {
        	set.add(str1);
        }
        for(String str2 : s2) {
        	if(set.contains(str2)) answer++;
        }
        return answer;
    }
	public int[] solution11(int[] array) {
        int[] answer = {array[0], 0};
        for(int i = 0; i < array.length; i++) {
        	if(answer[0] < array[i]) {
        		answer[0] = array[i];
        		answer[1] = i;
        	}
        }
        
        return answer;
    }
}
                                       