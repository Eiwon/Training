package level2New;

public class MaxPriority {
//"100-200*300-500+20"	60420
	public static void main(String[] args) {
		solution("100-200*300-500+20");
	}
	public static long solution(String expression) {
        long answer = 0;
        char[] priority = {'+', '-', '*'};
        // +-* -+* -*+ *-+ *+- +*-
        
        String[] num = expression.split("[+-\\*]");
        int[] numbers = new int[num.length];
        for(int i = 0; i < num.length; i++) {
        	System.out.println(num[i]);
        	//numbers[i] = Integer.parseInt(num[i]);
        	//System.out.println(numbers[i] + " ");
        }
        
        
        return answer;
    }
}
