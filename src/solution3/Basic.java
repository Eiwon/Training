package solution3;
import java.util.*;

public class Basic {

	public static void main(String[] args) {
	}

	public static int[] solution1(int[] arr, int[][] queries) {
        int[] answer = arr;
        int temp = 0;
        for(int[] query : queries){
            temp = answer[query[0]];
            answer[query[0]] = answer[query[1]];
            answer[query[1]] = temp;
        }
        
        return answer;
    }
	
	public static int[] solution2(int[] arr, int[][] queries) {
        int[] answer = {};
        
        for(int[] query : queries){
            for(int i = query[0]; i <= query[1]; i++){
                if(i % query[2] == 0){
                    arr[i]++;
                }
            }
        }
        answer = arr;
        
        return answer;
    }
	
	public static int[] solution3(int start_num, int end_num) {
        int[] answer = new int[end_num - start_num + 1];
        int idx = 0;
        
        for(int i = start_num; i <= end_num; i++){
            answer[idx++] = i;
        }
        
        return answer;
    }
	
	public int[] solution(int n) {
        int[] answer = {};
        List<Integer> resList = new ArrayList<>();
        resList.add(n);
        
        while(n > 1){
            if(n % 2 == 0) {
                n /= 2;
            }else {
                n = 3 * n + 1;
            }
            resList.add(n);
        }
        
        answer = new int[resList.size()];
        
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = resList.get(i);
        }
        
        
        return answer;
    }
	
	public static String solution4(String my_string, int[] index_list) {
        String answer = "";
        
        for(int idx : index_list) {
        	answer += my_string.charAt(idx);
        }
        
        return answer;
    }
	
	public static int solution5(String number) {
        int answer = 0;
        
        for(int i = 0; i < number.length(); i++) {
        	answer += Integer.parseInt(String.valueOf(number.charAt(i)));
        }
        
        return answer % 9;
    }
	
	public static String solution6(String my_string, int[][] queries) {
        String answer = my_string;
        String head, body, foot, reverse;
        for(int[] query : queries) {
        	head = answer.substring(0, query[0]);
        	body = answer.substring(query[0], query[1] + 1);
        	foot = answer.substring(query[1] + 1, answer.length());
        	reverse = "";
        	
        	for(int i = body.length() - 1; i >= 0; i--) {
        		reverse = reverse.concat(String.valueOf(body.charAt(i)));
        	}
        	
        	answer = head + reverse + foot;
        }
        
        return answer;
    }
	
}
