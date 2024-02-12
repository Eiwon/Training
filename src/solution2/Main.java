package solution2;

import java.util.*;
public class Main {

	public static void main(String[] args) {
		Expiration e = new Expiration();
		e.solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}
		, new String[] {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});
	}

}
