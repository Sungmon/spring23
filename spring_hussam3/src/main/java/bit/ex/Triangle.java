package bit.ex;

public class Triangle implements Area {

	private double a;
	private double b;
	
	public Triangle(double a, double b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	public double geta() {
		return a;
	}
	public void seta(double a) {
		this.a = a;
	}
	public double getb() {
		return b;
	}
	public void setb(double b) {
		this.b = b;
	}
	public double getArea(double a, double b) {
			
		return (a * b)/2;
	}
	
}
