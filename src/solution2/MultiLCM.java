package solution2;

public class MultiLCM {

	public static void main(String[] args) {
		solution(new int[] {2,6,8,14});

	}

	public static int solution(int[] arr) {
        int answer = 0;
        // divide & conquer
        // 두 수의 최소공배수 구하는 함수
        System.out.println(divide(arr));
        
        return answer;
    }
	//{0 1 2 3 4 5 6 7} 크기 8 -> 0~3 + 4~7 4
	//{0 1 2 3 4 5 6} 크기 7 -> 0~3 + 4~6 4
	public static int divide(int[] arr) {
		int center = (arr.length+1) /2;
		if(arr.length == 1) {
			return arr[0];
		}else if(arr.length == 2) {
			return lcm(arr[0], arr[1]);
		}else {
			int[] arr1 = new int[center];
			int[] arr2 = new int[arr.length -center];
			for(int i=0; i<center; i++)
				arr1[i] = arr[i];
			for(int i=0; i<arr2.length; i++)
				arr2[i] = arr[i+center];
			return lcm(divide(arr1), divide(arr2));
		}
	}
	
	public static int lcm(int a, int b) {
		return a / gcl(a, b)* b ;
	}
	
	public static int gcl(int a, int b) {
		if(b == 0)
			return a;
		return gcl(b, a % b);
	}
	
}
