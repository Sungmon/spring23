package edu.bit.ex;

import java.util.Arrays;

public class Lotto {

	private int[] lot = new int[6];
	private String str;
	
	public String random() {
		
		for (int i = 0; i < lot.length; i++) {
			lot[i] = (int) (Math.random() * 45) + 1;
			for (int j = 0; j < i; j++) {
				if (lot[i] == lot[j]) {
					i--;
					break;
				}
			}
		}
		Arrays.sort(lot);
		str = Arrays.toString(lot);
		return str;
	}
}


//HashSet<Interger> set;
//public HashSet<Integer> getSet() {
//	set = new HashSet<Integer>();
//	while (set.size() < 6) {
//		set.add((int) (Math.random() * 45) +1)
//	}
//	return set;
//}
//public void setSet(HashSet<Integer> set) {
//	this.set = set;
//}
//}
//}
