package bit.life;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean, DisposableBean {

	private String name;
	private int age;

	public Student(String name, int age) {
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

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterPropertiesSet()");
	}

	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("destroy()");
	}

}
