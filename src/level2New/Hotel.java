package level2New;
import java.util.*;
public class Hotel {
//	[["15:00", "17:00"], ["16:40", "18:20"], ["14:20", "15:20"], 
//	 ["14:10", "19:20"], ["18:20", "21:20"]]	3
	public static void main(String[] args) {
		solution(new String[][] {{"15:00", "17:00"}, {"16:40", "18:20"}, 
			{"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}});

	}
	public static int solution(String[][] book_time) {
        int answer = 0;
        //입장시간 기준 정렬
        ArrayList<Integer> hotel = new ArrayList<>(); 
        PriorityQueue<BookTime> pq = new PriorityQueue<>(new Comparator<BookTime>() {

			@Override
			public int compare(BookTime o1, BookTime o2) {
				
				return o1.checkIn - o2.checkIn;
			}});
        
        for(String[] bt : book_time) {
        	pq.add(new BookTime(bt));
        }
        
        while(pq.size() > 0) {
        	BookTime pick = pq.poll();
        	answer += hotelIn(hotel, pick);
        }
        System.out.println(answer);
        
        return answer;
    }
	
	public static int hotelIn(ArrayList<Integer> hotel, BookTime guest) {
		
		for(int i = 0; i < hotel.size(); i++) {
			if(hotel.get(i) <= guest.checkIn) {
				hotel.set(i, guest.checkOut);
				System.out.println("room " + i + " : " + guest.checkIn + " ~ " + 
				guest.checkOut);
				return 0;
			}
		}
		hotel.add(guest.checkOut);
		System.out.println("new room " + (hotel.size()-1) + " : " + guest.checkIn + " ~ " + 
				guest.checkOut);
		return 1;
	}
	
}
class BookTime{
	public int checkIn;
	public int checkOut;
	
	public BookTime(String[] book_time) {
		checkIn = Integer.parseInt(book_time[0].substring(0, 2)) *60 +
		Integer.parseInt(book_time[0].substring(3, 5));
		checkOut = Integer.parseInt(book_time[1].substring(0, 2)) *60 +
				Integer.parseInt(book_time[1].substring(3, 5)) +10;
	}
}

