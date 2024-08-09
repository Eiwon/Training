package solution3;

import java.util.*;

public class Basic4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solution1(int[] num_list) {
        int odd = 0, even = 0;
        
        for(int i = 0; i < num_list.length; i++){
            if(i % 2 == 0){
                odd += num_list[i];
            }else{
                even += num_list[i];
            }
        }
        
        return (odd > even) ? odd : even;
    }
	
	public String[] solution2(String[] names) {
        String[] answer = new String[(names.length + 4) / 5];
        int idx = 0;
        for(int i = 0; i < names.length; i += 5){
            answer[idx++] = names[i];
        }
        
        return answer;
    }
	
	public String[] solution3(String[] todo_list, boolean[] finished) {
        String[] answer = {};
        Queue<String> temp = new LinkedList<>();
        
        for(int i = 0; i < todo_list.length; i++){
            if(!finished[i]){
                temp.add(todo_list[i]);
            }
        }
        answer = new String[temp.size()];
        int idx = 0;
        
        while(temp.size() > 0){
            answer[idx++] = temp.poll();
        }
        
        return answer;
    }
	public int solution4(int[] numbers, int n) {
        int answer = 0;
        
        for(int number : numbers){
            answer += number;
            if(answer > n){
                break;
            }
        }
        
        return answer;
    }
	public int[] solution5(int[] arr, int[][] queries) {
        int[] answer = {};
        
        for(int[] query : queries){
            for(int i = query[0]; i <= query[1]; i++){
                arr[i]++;
            }
        }
        answer = arr;
        return answer;
    }
	public int solution6(int[] arr) {
        int answer = 0, pick;
        int[] cur = arr;
        int[] prev = new int[arr.length];
        
        do{
            answer++;
            for(int i = 0; i < cur.length; i++){
                pick = cur[i];
                prev[i] = pick;
                if(pick >= 50 && pick % 2 == 0){
                    cur[i] /= 2;
                }else if(pick < 50 && pick % 2 == 1){
                    cur[i] = pick * 2 + 1;
                }
            }
        }while(!compareArr(cur, prev));
        
        return answer - 1;
    }
    
    public boolean compareArr(int[] arr1, int[] arr2){
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
    public int solution7(int[] num_list) {
        int answer = 0;
        
        for(int num : num_list){
            while(num > 1){
                num /= 2;
                answer++;
            }
        }
        
        return answer;
    }
    public int solution8(int[] num_list) {
        int answer = 0;
        
        if(num_list.length > 10){
            for(int num : num_list){
                answer += num;
            }
        }else{
            answer = 1;
            for(int num : num_list){
                answer *= num;
            }
        }
        
        return answer;
    }
    public int solution9(String myString, String pat) {
        myString = myString.toLowerCase();
        pat = pat.toLowerCase();
        return myString.contains(pat) ? 1 : 0;
    }
    public String[] solution10(String[] strArr) {
        String[] answer = new String[strArr.length];
        
        for(int i = 0; i < strArr.length; i++){
            if(i % 2 == 0)
                answer[i] = strArr[i].toLowerCase();
            else
                answer[i] = strArr[i].toUpperCase();
        }
        
        return answer;
    }
    public String solution11(String myString) {
        String answer = "";
        char pick;
        for(int i = 0; i < myString.length(); i++){
            pick = myString.charAt(i);
            if(pick == 'a'){
                pick = 'A';
            }else if(Character.isUpperCase(pick) && pick != 'A') {
            	pick = Character.toLowerCase(pick);
            }
            answer += pick;
        }
        
        return answer;
    }
    public String solution12(String my_string, String alp) {
        return my_string.replace(alp, alp.toUpperCase());
    }
    public String solution13(String myString, String pat) {
    	return myString.substring(0, myString.lastIndexOf(pat) + pat.length());
    }
    public int solution14(String myString, String pat) {
        int answer = 0, idx;
        while(true) {
        	idx = myString.indexOf(pat);
        	if(idx == -1)
        		break;
        	else {
        		answer++;
        		myString = myString.substring(idx + 1);
        	}
        }
        return answer;
    }
}
