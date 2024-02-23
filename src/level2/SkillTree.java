package level2;

import java.util.*;

public class SkillTree {
//"CBD"	["BACDE", "CBADF", "AECB", "BDA"]	2
	public static void main(String[] args) {
		
		solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});

	}
	public static int solution(String skill, String[] skill_trees) {
	     int answer = skill_trees.length;
	     HashMap<Character, Integer> map = new HashMap<>();
	     int lastNum = 0;
	     char c = 0;
	     for(int i = 0; i < skill.length(); i++) {
	    	 map.put(skill.charAt(i), i);
	     }
	     
	     for(String tree : skill_trees) {
	    	 lastNum = 0;
	    	 
	     }
	     System.out.println(answer);
	     
	     
	     
	     return answer;
	}
	
	public boolean check(String tree, ) {
		for(int i = 0; i < tree.length(); i++) {
   		 c = tree.charAt(i);
   		 if(map.containsKey(c)) {
   			 if(map.get(c) < lastNum) {
   				 answer--;
   				 break;
   			 }else {
   				 lastNum = map.get(c);
   			 }
   		 }
   	 }
	}
}
