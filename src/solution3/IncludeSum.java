package solution3;

public class IncludeSum {

	public static void main(String[] args) {
		
	}
	
	public static int solution(int a, int d, boolean[] included) {
		int answer = 0;
		int p = a - d;
		for(boolean include : included) {
			p += d;
			if(include) {
				answer += p;
			}
		}
		return answer;
	}
	
	public static int solution2(int[] num_list) {
        int answer = 0;
        int sum = 0, product = 1;
        
        for(int num : num_list) {
        	sum += num;
        	product *= num;
        }
        
        if(product < sum * sum) {
        	answer = 1;
        }
        
        return answer;
    }

	public static int solution3(int[] num_list) {
	        int answer = 0;
	        String odd = "", even = "";
	        
	        for(int num : num_list) {
	        	if(num % 2 == 1) {
	        		odd = odd.concat(Integer.toString(num));
	        	}else {
	        		even = even.concat(Integer.toString(num));
	        	}
	        }
	        
	        answer = Integer.parseInt(odd) + Integer.parseInt(even);
	        
	        return answer;
	}
	
	public static int[] solution4(int[] num_list) {
		int len = num_list.length;
        int[] answer = new int[len + 1];
        
        for(int i = 0; i < len; i++) {
        	answer[i] = num_list[i];
        }
        
        if(num_list[len - 1] > num_list[len - 2]) {
        	answer[len] = num_list[len - 1] - num_list[len - 2];
        }else {
        	answer[len] = num_list[len - 1] * 2;
        }
        
        return answer;
    }
	public static int solution5(int n, String control) {
        int answer = n;
        
        for(int i = 0; i < control.length(); i++) {
        	if(control.charAt(i) == 'w') {
        		answer++;
        	}else if(control.charAt(i) == 's') {
        		answer--;
        	}else if(control.charAt(i) == 'd') {
        		answer += 10;
        	}else {
        		answer -= 10;
        	}
        }
        
        return answer;
    }
	
	public String solution(int[] numLog) {
        String answer = "";
        int gap = 0;
        
        for(int i = 0; i < numLog.length - 1; i++) {
        	gap = numLog[i + 1] - numLog[i];
        	if(gap == -1) {
        		answer = answer.concat("s");
        	}else if(gap == 1) {
        		answer = answer.concat("w");
        	}else if(gap == -10) {
        		answer = answer.concat("a");
        	}else {
        		answer = answer.concat("d");
        	}
        }
        
        return answer;
    }
	
	public static int[] solution6(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int min, idx = 0;
        
        for(int[] query : queries) {
        	min = Integer.MAX_VALUE;
        	for(int i = query[0]; i <= query[1]; i++) {
        		if(arr[i] > query[2] && arr[i] < min) {
        			min = arr[i];
        		}
        	}
        	
        	answer[idx++] = (min == Integer.MAX_VALUE) ? -1 : min;
        }
        
        
        return answer;
    }
	
}
