package solution3;

import java.util.Arrays;

public class Basic2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String solution1(String[] my_strings, int[][] parts) {
        String answer = "";
        
        for(int i = 0; i < my_strings.length; i++){
            answer += my_strings[i].substring(parts[i][0], parts[i][1] + 1);
        }
        
        return answer;
    }
	
	public String[] solution2(String my_string) {
		int len = my_string.length();
        String[] answer = new String[len];
        
        for(int i = 0; i < len; i++) {
        	answer[i] = my_string.substring(i, len);
        }
        
        Arrays.sort(answer, (a, b) -> {return a.compareTo(b);});
        
        return answer;
    }
	
	public int solution3(String my_string, String is_suffix) {

        if(my_string.length() < is_suffix.length()) 
        	return 0;
        
        String suffix = my_string.substring(my_string.length() - is_suffix.length(), my_string.length());
        
        return (suffix.compareTo(is_suffix) == 0) ? 1 : 0;
    }
	
	public int solution4(String my_string, String is_prefix) {
        
		if(my_string.length() < is_prefix.length()) {
			return 0;
		}
		
		String prefix = my_string.substring(0, is_prefix.length());
		
		return (prefix.compareTo(is_prefix) == 0) ? 1 : 0;
    }
	
	public String solution5(String my_string, int s, int e) {
		String answer = my_string;
        String head, body, foot, reverse;
        	
        head = answer.substring(0, s);
        body = answer.substring(s, e + 1);
		foot = answer.substring(e + 1, answer.length());
		reverse = "";

		for (int i = body.length() - 1; i >= 0; i--) {
			reverse = reverse.concat(String.valueOf(body.charAt(i)));
		}

		answer = head + reverse + foot;
        return answer;
    }
	
	public String solution6(String my_string, int m, int c) {
        String answer = "";
        int idx = c - 1;
        
        while(idx < my_string.length()) {
        	answer += my_string.charAt(idx);
        	idx += m;
        }
        
        return answer;
    }
	
	public int[] solution7(String my_string) {
        int[] answer = new int[52];
        char pick;
        
        for(int i = 0; i < my_string.length(); i++) {
        	pick = my_string.charAt(i);
        	if(Character.isUpperCase(pick)) {
        		answer[pick - 'A']++;
        	}else {
        		answer[pick - 'a' + 26]++;
        	}
        }
        
        return answer;
    }
	
	public String solution8(String my_string, int[] indices) {
        String answer = "";
        Arrays.sort(indices);
        int idx = 0;
        
        for(int i = 0; i < my_string.length(); i++) {
        	if(idx == indices.length) {
        		answer = answer.concat(my_string.substring(i));
        		break;
        	}
        	
        	if(i != indices[idx]) {
        		answer += my_string.charAt(i);
        	}else {
        		idx++;
        	}
        }
        
        return answer;
    }
	
	public int[] solution9(int n, int[] slicer, int[] num_list) {
        int[] answer = {};
        
        switch (n) {
		case 1:
			answer = new int[slicer[1] + 1];
			for(int i = 0; i < answer.length; i++) {
				answer[i] = num_list[i];
			}
			break;
		case 2:
			answer = new int[num_list.length - slicer[0]];
			for(int i = 0; i < answer.length; i++) {
				answer[i] = num_list[i + slicer[0]];
			}
			break;
		case 3:
			answer = new int[slicer[1] - slicer[0] + 1];
			for(int i = 0; i < answer.length; i++) {
				answer[i] = num_list[i + slicer[0]];
			}
			break;
		case 4:
			answer = new int[(slicer[1] - slicer[0]) / slicer[2] + 1];
			for(int i = 0, idx = slicer[0]; i < answer.length; i++) {
				answer[i] = num_list[idx];
				idx += slicer[2];
			}
			break;
		default:
			break;
		}
        
        return answer;
    }
}
