package bit.ex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	//@Bean = xml의 빈태그.
	@Bean	//Student = <Bean class=" "> student1 = <Bean id>
	public Student student1() {
		
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("수영");
		hobbys.add("요리");
		
		Student student = new Student("홍길동", 20, hobbys);
		student.setHeight(180);
		student.setWeight(80);
		return student;
	}
	@Bean
	public Student student2() {
		
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("독서");
		hobbys.add("음악감상");
		
		Student student = new Student("홍길순", 10, hobbys);
		student.setHeight(170);
		student.setWeight(55);
		return student;
	}
	@Bean
	public Triangle trianglearea() {
		
		Triangle triangle = new Triangle(0,0);
		return triangle;
	}
	@Bean
	public Rectangle rectanglearea() {
		
		Rectangle rectangle = new Rectangle(0,0);
		return rectangle;
	}
	@Bean
	public Area area() {
		
		Area area = new Rectangle(0,0);
		return area;
	}
	@Bean
	public CircleArea circlearea() {
		
		CircleArea circlearea = new CircleArea();
		return circlearea;
	}
	@Bean
	public Pencil pencil() {
		
		Pencil pencil = new Pencil6BwithEraser();
		return pencil;
	}
}
