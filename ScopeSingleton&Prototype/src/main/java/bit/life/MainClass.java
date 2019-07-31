package bit.life;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		String config = "classpath:appCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(config);	// 생성
		

		Student student1 = ctx.getBean("student",Student.class);
		System.out.println("이름 :" + student1.getName());
		System.out.println("나이 :" + student1.getAge());
		
		
		System.out.println("==========================");
		

		Student student2 = ctx.getBean("student", Student.class);
		student1.setName("홍길자");
		student1.setAge(100);
		
		System.out.println("이름 : " + student1.getName());
		System.out.println("나이 : " + student1.getAge());
		
		
		System.out.println("=========================");
		
		if(student1.equals(student2)) {
			System.out.println("student1 == student2");
		} else {
			System.out.println("student != student2");
		}
		ctx.close();
		
		
//		String a = "Z@S.ME";
//		String b = "Z@RN.E";
//		if (a.hashCode() == b.hashCode()) {
//			System.out.println("same hashcode");
//			System.out.println(a.hashCode());
//			System.out.println(b.hashCode());
//		} else {
//			System.out.println("different hashcode");
//			System.out.println(a.hashCode());
//			System.out.println(b.hashCode());
//		}
//		System.out.println("ctx.close() 전");
//		ctx.close();
//		System.out.println("ctx.close() 후");
		}
	}
	
	
