package solution3;

public class Basic3 {

	public static void main(String[] args) {
	}
	
	public int[] solution1(int[] arr) {
        int[] answer = {};
        int start = -1, last = -1;
        
        for(int i = 0; i < arr.length; i++) {
        	if(arr[i] == 2) {
        		start = i;
        		break;
        	}
        }
        for(int i = arr.length - 1; i > 0; i--) {
        	if(arr[i] == 2) {
        		last = i;
        		break;
        	}
        }
        if(start == -1) {
        	answer = new int[] {-1};
        }else {
        	answer = new int[last - start + 1];
        	int idx = 0;
        	for(int i = start; i <= last; i++) {
        		answer[idx++] = arr[i];
        	}
        }
        
        return answer;
    }
	
	public int[] solution2(int[] num_list, int n) {
        int[] answer = new int[num_list.length - n + 1];
        int idx = 0;
        for(int i = n - 1; i < num_list.length; i++){
            answer[idx++] = num_list[i];
        }
        
        return answer;
    }
	
	public int[] solution3(int[] num_list, int n) {
        int[] answer = new int[num_list.length];
        
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = num_list[(n++ % num_list.length)];
        }
        
        return answer;
    }

	public String[] solution4(String[] str_list) {
        String[] answer = {};
        int idx = 0, len = str_list.length;
        
        for(int i = 0; i < len; i++) {
        	if(str_list[i].equals("l")) {
        		answer = new String[i];
        		for(int x = 0; x < i; x++) {
        			answer[idx++] = str_list[x]; 
        		}
        		return answer;
        	}else if(str_list[i].equals("r") && (i + 1) < len) {
        		answer = new String[len - (i + 1)];
        		for(int x = i + 1; x < len; x++) {
        			answer[idx++] = str_list[x];
        		}
        		return answer;
        	}
        }
        
        return answer;
    }
	
	public int[] solution(int[] num_list, int n) {
        int[] answer = new int[(num_list.length + (n - 1)) / n];
        int idx = 0;
        
        for(int i = 0; i < num_list.length; i += n){
           answer[idx++] = num_list[i]; 
        }
        
        return answer;
    }
}
