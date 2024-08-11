package solution3;
import java.util.*;
public class Basic6 {

	public int[] solution1(int[] arr, int k) {
		int[] answer = new int[k];
        int idx = 0;
        Set<Integer> dup = new HashSet<>();
        
        for(int i = 0; i < k; i++) {
        	answer[i] = -1;
        }
        
        for(int a : arr){
            if(!dup.contains(a)){
                dup.add(a);
                if(idx == k) {
                	break;
                }
                answer[idx++] = a;
            }
        }
        
        return answer;
    }
	public int[] solution2(int[] arr) {
        int[] answer = {};
        int len = arr.length;
        
        int pow = 0, remains = 0;
        
        while(len > 1) {
        	remains += len % 2;
        	len /= 2;
        	pow++;
        }
        if(remains > 0) pow++;
        
        len = 1;
        for(int i = 0; i < pow; i++) {
        	len *= 2;
        }
        answer = new int[len];
        
        for(int i = 0; i < arr.length; i++) {
        	answer[i] = arr[i];
        }
        
        return answer;
    }
	public int solution3(int[] arr1, int[] arr2) {
        int len1 = arr1.length, len2 = arr2.length;
        int sum = 0;
        
        if(len2 > len1) return -1;
        if(len2 < len1) return 1;
        
        for(int i = 0; i < len1; i++) {
        	sum += arr1[i] - arr2[i];
        }
        if(sum > 0) return 1;
        else if(sum < 0) return -1;
        else return 0;
        
    }
	public int solution4(String[] strArr) {
        int answer = 0, len;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(String str : strArr) {
        	len = str.length();
        	if(map.containsKey(len)) {
        		map.put(len, map.get(len) + 1);
        	}else {
        		map.put(len, 1);
        	}
        }
        
        for(int key : map.keySet()) {
        	answer = Math.max(answer, map.get(key));
        }
        
        return answer;
    }
	public int[] solution5(int[] arr, int n) {
        int[] answer = arr;
        int len = arr.length;
        
        for(int i = (len + 1) % 2; i < len; i += 2) {
        	answer[i] += n;
        }
        
        return answer;
    }
	public int[] solution6(int[] num_list) {
        Arrays.sort(num_list);
        return Arrays.copyOf(num_list, 5);
    }
	public int[] solution7(int[] num_list) {
        Arrays.sort(num_list);
        return Arrays.copyOfRange(num_list, 5, num_list.length);
    }
	public int solution8(int[] rank, boolean[] attendance) {
        int num1 = 0, num2 = 0, num3 = 0;
        int rank1 = Integer.MAX_VALUE, rank2 = Integer.MAX_VALUE, rank3 = Integer.MAX_VALUE;
        
        for(int i = 0; i < rank.length; i++) {
        	if(attendance[i]) {
        		if(rank[i] < rank1) {
        			rank3 = rank2;
        			num3 = num2;
        			rank2 = rank1;
        			num2 = num1;
        			rank1 = rank[i];
        			num1 = i;
        		}else if(rank[i] < rank2) {
        			rank3 = rank2;
        			num3 = num2;
        			rank2 = rank[i];
        			num2 = i;
        		}else if(rank[i] < rank3) {
        			rank3 = rank[i];
        			num3 = i;
        		}
        	}
        }
        return 10000 * num1 + 100 * num2 + num3;
        
    }
	
	public int solution9(String num_str) {
        int answer = 0;
        for(int i = 0; i < num_str.length(); i++) {
        	answer += Character.getNumericValue(num_str.charAt(i));
        }
        return answer;
    }
	public int solution10(String n_str) {
        int answer = 0, exp = 1;
        
        for(int i = n_str.length() - 1; i >= 0; i--) {
        	answer += Character.getNumericValue(n_str.charAt(i)) * exp;
        	exp *= 10;
        }
        
        return answer;
    }
	public String solution11(String n_str) {
		String answer = "";
        for(int i = 0; i < n_str.length(); i++) {
        	if(n_str.charAt(i) != '0') {
        		answer = n_str.substring(i);
        		break;
        	}
        }
        return answer;
    }
	public String solution(String a, String b) {
        String answer = "";
        int len = Math.max(a.length(), b.length());
        
        int up = 0, p1, p2, lenA = a.length(), lenB = b.length();
        for(int i = 0; i < len; i++) {
        	p1 = (lenA - i - 1 >= 0) ? 
        			Character.getNumericValue(a.charAt(lenA - i - 1)) : 0;
        	p2 = (lenB - i - 1 >= 0) ?
        			Character.getNumericValue(b.charAt(lenB - i - 1)) : 0;
        	answer = String.valueOf((p1 + p2 + up) % 10).concat(answer);
        	up = (p1 + p2 + up) / 10;
        }
        if(up > 0)
        	answer = String.valueOf(up).concat(answer);
        
        return answer;
    }
}
