package solution3;
import java.util.*;
import java.lang.StringBuilder;
public class Basic7 {

	public int[] solution(int[] arr, int[] delete_list) {
        int[] answer = new int[arr.length];
        Set<Integer> set = new HashSet<>();
        int lenAns = 0;
        for(int num : delete_list) {
        	set.add(num);
        }
        
        for(int i = 0; i < arr.length; i++) {
        	if(!set.contains(arr[i])) {
        		answer[lenAns++] = arr[i];
        	}
        }
        
        answer = Arrays.copyOf(answer, lenAns);
        
        return answer;
    }
	public int solution2(String my_string, String target) {
        return my_string.contains(target) ? 1 : 0;
    }
	public String solution3(String[] str_list, String ex) {
        String answer = "";
        for(String str : str_list) {
        	if(!str.contains(ex)) {
        		answer = answer.concat(str);
        	}
        }
        
        return answer;
    }
	public int solution4(int[] date1, int[] date2) {
        int year = date1[0] - date2[0], 
        	month = date1[1] - date2[1],
        	day	= date1[2] - date2[2];;
        if(year != 0) {
        	return (year < 0) ? 1 : 0;
        }
        if(month != 0) {
        	return (month < 0) ? 1 : 0;
        }
        return (day < 0) ? 1 : 0;
    }
	public int solution5(String[] order) {
        int answer = 0;
        
        for(String menu : order) {
        	answer += menu.contains("cafelatte") ? 5000 : 4500;
        }
        
        return answer;
    }
	public String[] solution6(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        StringBuilder newLine;
        char p;
        int idx = 0;
        for(String line : picture) {
        	newLine = new StringBuilder();
        	for(int i = 0; i < line.length(); i++) {
        		p = line.charAt(i);
        		for(int iter = 0; iter < k; iter++) {
        			newLine.append(p);
        		}
        	}
        	for(int i = 0; i < k; i++) {
        		answer[idx++] = newLine.toString();
        	}
        }
        
        return answer;
    }
	public int[] solution7(int[] arr, int k) {
        if(k % 2 == 1) {
        	for(int i = 0; i < arr.length; i++) {
        		arr[i] *= k;
        	}
        }else {
        	for(int i = 0; i < arr.length; i++) {
        		arr[i] += k;
        	}
        }
        return arr;
    }
	
	public String solution8(String myString) {
        String answer = "";
        
        for(int i = 0; i < myString.length(); i++) {
        	char p = myString.charAt(i);
        	answer += (p < 'l') ? 'l' : p; 
        }
        
        return answer;
    }
	public int[][] solution9(int n) {
        int[][] answer = new int[n][n];
        for(int row = 0; row < n; row++)
        	for(int col = 0; col < n; col++)
        		answer[row][col] = (row == col) ? 1 : 0;
        	
        return answer;
    }
	public int solution10(int[][] arr) {
        int n = arr.length;
        for(int row = 0; row < n; row++) 
        	for(int col = row; col < n; col++) 
        		if(arr[row][col] != arr[col][row])
        			return 0;
        return 1;
    }
	public int[][] solution11(int[][] arr) {
        int rowArr = arr.length, colArr = arr[0].length,
        	lenAns = Math.max(rowArr, colArr);
        int[][] answer = new int[lenAns][lenAns];
        
        for(int row = 0; row < lenAns; row++)
        	for(int col = 0; col < lenAns; col++)
        		answer[row][col] = (row < rowArr && col < colArr) ? arr[row][col] : 0;
        	
        return answer;
    }
}
