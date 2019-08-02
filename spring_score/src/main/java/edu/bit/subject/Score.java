package edu.bit.subject;

public class Score {

	private int ku;
	private int en;
	private int ma;
	private int sc;
	private int sum;
	private int avg;
	



	public int getKu() {
		return ku;
	}

	public void setKu(int ku) {
		this.ku = ku;
	}

	public int getEn() {
		return en;
	}

	public void setEn(int en) {
		this.en = en;
	}

	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

	public int getSc() {
		return sc;
	}

	public void setSc(int sc) {
		this.sc = sc;
	}
	//총점과 평균
	
	
	public int totalScore(int ku, int en, int ma, int sc) {
		sum = ku + en + ma + sc;
		return sum;
	}
	

	public int avgScore(int sum) {
		int avg = sum/4;
		return avg;
	}
}
