package level2New;
import java.util.*;

public class PrimePaper {
//"17"	3
//"011"	2
	public static HashMap<Integer, Boolean> isPrime;
	
	public static void main(String[] args) {
		
		solution("011");
	}

    public static int solution(String numbers) {
        int answer = 0;
        ArrayList<Card> cardPack = new ArrayList<>();
        isPrime = new HashMap<>();// 만든 숫자 - 소수 여부
        // numbers를 char로 변환 -> 해당 문자와 사용 여부를 배열에 저장
        // 완전탐색 : 사용되지 않은 카드 1개를 선택하여 연결
        // 해당 카드가 hashMap에 없다면 소수인지 확인 후 등록 or 있는데 false라면 무시  
        // 모든 카드가 사용된 상태면 종료
        for(int i = 0; i < numbers.length(); i++) {
        	cardPack.add(new Card(numbers.charAt(i)));
        }
        cardJoin(cardPack, "");
        
        System.out.println(isPrime.toString());
        
        for(Boolean b : isPrime.values()) {
        	if(b)
        		answer++;
        }
        System.out.println(answer);
        
        return answer;
    }
    
    public static void cardJoin(ArrayList<Card> cardPack, String result) {
    	Card card;
    	
    	if(result.length() > 0) {
    	int make = Integer.parseInt(result);
    	//이미 등록된 문자인지 확인
    	//등록 안됐다면 소수인지 확인
    	if(!isPrime.containsKey(make)) {
    			isPrime.put(make, isPrime(make));
    	}
    	if(result.length() == cardPack.size())
    		return;
    	// result 길이가 cardPack 길이와 같으면 종료
    	}
    	for(int i = 0; i < cardPack.size(); i++) {
    		card = cardPack.get(i);
    		if(card.isUsed == false) {
    			card.isUsed = true;
    			cardJoin(cardPack, result.concat(Character.toString(card.value)));
    			card.isUsed = false;
    		}
    	}
    	return;
    }

	private static Boolean isPrime(int make) {
		System.out.println(make);
		if(make < 2)
			return false;
		
		for(int i = 2; i * i <= make; i++) {
			if(make % i == 0)
				return false;
		}
		return true;
	}
    
    
}
class Card{
	public char value;
	public boolean isUsed;
	
	public Card(char value) {
		this.value = value;
		this.isUsed = false;
	}
}
