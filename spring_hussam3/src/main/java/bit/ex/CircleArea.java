package bit.ex;

public class CircleArea {
	
	private double r;
	

	public void setR(double r) {
		this.r = r;
	}

	public double getR() {
		return r;
	}
	public double getArea(double r) {
		return r * r * Math.PI; //PI는 static이 생략되어있다.
	}
}