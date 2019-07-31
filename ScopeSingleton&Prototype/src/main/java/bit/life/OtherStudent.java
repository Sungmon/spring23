package bit.life;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class OtherStudent  {

	private String name;
	private int age;

	public OtherStudent(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("Student (String name,int age)");
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}
	@PostConstruct// 빈이 생성될때 호출한다.
	public void initMethod() {
		System.out.println("initMethod() 호출");
	}
	
	@PreDestroy//빈이 삭제되기 전에 호출시킨다.
	public void destroyMethod() {
		System.out.println("destroyMethod() 호출");
	}
}