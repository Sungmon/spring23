package edu.bit.subject;

import java.util.Random;

public class Hand {

	String[] ff = { "가위", "바위", "보" };
	String ff1;
	String ff2;
	String ff3;
	
	public void user(String[] ff) {
		
		this.ff1 = ff[0];
		this.ff2 = ff[1];
		this.ff3 = ff[2];
		
	}
	public String com() {
		Random ran = new Random();
		int a = 0;
		String qq = "";
		for (int i = 0; i < ff.length; i++) {
			i = (int) (Math.random() * 3);
			a = i + 1;
		}
		qq = ff[ran.nextInt(a)];
		return qq;
	}
//	ff1 = 가위	가위 > 보,  보 > 바위,  바위 > 가위 
//	ff2 = 바위 	
//	ff3 = 보
	public void result() {
		if(ff1.equals(ff2)) {
			System.out.println("비겼다.");
		} else if () {
			
		}
		
	}
}
