package solution3;
import java.util.*;

public class Basic5 {

	public static void main(String[] args) {

	}
	
	public String[] solution1(String[] strArr) {
        String[] answer = {};
        String target = "ad";
        Queue<String> temp = new LinkedList<>();
        
        for(String str : strArr){
            if(!str.contains(target)){
                temp.add(str);
            }
        }
        
        answer = new String[temp.size()];
        
        for(int i = 0; i < answer.length; i++){
            answer[i] = temp.poll();
        }
        
        return answer;
    }

	public String[] solution2(String my_string) {
        String[] answer = my_string.trim().split(" +");
        return answer;
    }
	public int[] solution3(String myString) {
        int[] answer = {};
        Queue<Integer> q = new LinkedList<>();
        char p;
        int subLen = 0;
        
        for(int i = 0; i < myString.length(); i++){
            p = myString.charAt(i);
            if(p == 'x'){
                q.add(subLen);
                subLen = 0;
            }else {
                subLen++;
            }
        }
        
        q.add(subLen);
        
        answer = new int[q.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = q.poll();
        }
        
        return answer;
    }
	public String[] solution4(String myString) {
        String[] answer = {};
        Queue<String> q = new PriorityQueue<>();
        String[] splited = myString.split("x");
        
        for(String str : splited) {
        	if(!str.isBlank()) {
        		q.add(str);
        	}
        }
        
        answer = new String[q.size()];
        
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = q.poll();
        }
        
        return answer;
    }
	public int solution5(String binomial) {
        int answer = 0;
        String[] bino = binomial.split(" ");
        int a = Integer.parseInt(bino[0]), b = Integer.parseInt(bino[2]);
        
        if(bino[1].equals("+")){
            answer = a + b;
        }else if(bino[1].equals("-")){
            answer = a - b;
        }else {
            answer = a * b;
        }
        
        return answer;
    }
	public int solution6(String myString, String pat) {
        String reverse = "";
        
        for(int i = 0; i < pat.length(); i++){
            reverse += (pat.charAt(i) == 'A') ? 'B' : 'A';
        }
        return myString.contains(reverse) ? 1 : 0;
    }
	public String solution7(String rny_string) {
        String answer = rny_string.replaceAll("m", "rn");
        return answer;
    }
	public String[] solution8(String myStr) {
		String[] answer = myStr.split("a|b|c");
        Queue<String> q = new LinkedList<>();
        for(String str : answer) {
        	if(!str.isBlank()) q.add(str);
        }
        if(q.size() == 0){
            return new String[]{"EMPTY"};
        }
        answer = new String[q.size()];
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = q.poll();
        }
        return answer;
    }
	public int[] solution9(int[] arr) {
        int[] answer = {};
        int xLen = 0;
        for(int a : arr){
            xLen += a;
        }
        
        answer = new int[xLen];
        int idx = 0;
        
        for(int a : arr){
            for(int i = 0; i < a; i++){
                answer[idx++] = a;
            }
        }
        return answer;
    }
	public int[] solution10(int[] arr, boolean[] flag) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < flag.length; i++) {
        	if(flag[i]) {
        		for(int x = 0; x < arr[i] * 2; x++) {
        			stack.add(arr[i]);
        		}
        	}else {
        		for(int x = 0; x < arr[i]; x++) {
        			stack.pop();
        		}
        	}
        }
        answer = new int[stack.size()];
        
        for(int i = answer.length - 1; i >= 0; i--) {
        	answer[i] = stack.pop();
        }
        
        return answer;
    }
}
