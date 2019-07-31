package bit.ex;
//삼각형과 사각형 객체를 configration로 객체를 생성해서 넓이를 구하시오,
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Triangle trianglearea = ctx.getBean("trianglearea", Triangle.class);
		Rectangle rectanglearea = ctx.getBean("rectanglearea",Rectangle.class);
		Area area = ctx.getBean("area",Area.class);
		CircleArea circlearea = ctx.getBean("circlearea", CircleArea.class); 
		Pencil pencil = ctx.getBean("pencil",Pencil.class);
		
		double result = circlearea.getArea(5);
		
		System.out.println(pencil.use(""));
		System.out.println(result);
		System.out.println(area.getArea(7, 7));
		System.out.println(trianglearea.getArea(5, 5));
		System.out.println(rectanglearea.getArea(10, 10));
	
		
//		AnnotationConfigApplicationContext ctx =
//				//AnnotationConfigApplicationContext = java IOC컨테이너
//				new AnnotationConfigApplicationContext(ApplicationConfig.class);
//		
//		Student student1 = ctx.getBean("student1",Student.class);
//		System.out.println("이름 : " + student1.getName());
//		System.out.println("나이 : " + student1.getAge());
//		System.out.println("취미 : " + student1.getHobby());
//		System.out.println("신장 : " + student1.getHeight());
//		System.out.println("몸무게 : " + student1.getWeight());
//		
//		Student student2 = ctx.getBean("student2",Student.class);
//		System.out.println("이름 : " + student2.getName());
//		System.out.println("나이 : " + student2.getAge());
//		System.out.println("취미 : " + student2.getHobby());
//		System.out.println("신장 : " + student2.getHeight());
//		System.out.println("몸무게 : " + student2.getWeight());
		
//		String config3 = "classpath: applicationCTX.xml";
//		AbstractApplicationContext ctx2 = new GenericXmlApplicationContext(config3);
//		MyInfo myInfo = ctx2.getBean("myInfo", MyInfo.class);
//		myInfo.getInfo();
//		ctx2.close();
//		String config = "classpath:applicationCTX.xml";
		// AbstractApplicationContext = BeanFactory가 제공하는 <bean> 객체관리 기능
		// GenericXmlApplicationContext=
		// 파일 시스템이나 클래스 경로에 있는 XML 설정 파일을 로딩하여 구동하는 컨테이너 = IOC 컨테이너
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext(config);
//		
//		MyInfo myInfo = ctx.getBean("myInfo", MyInfo.class);
//		myInfo.getInfo();
//		ctx.close();
//		CircleArea circle = ctx.getBean("circleArea", CircleArea.class);
//		System.out.println("원의 반지름이 10일때:" + circle.getArea());
//		
//		
//		circle.setR(20);
//		System.out.println("원의 반지름이 20일때:" +circle.getArea());
//		ctx.close();

//		Triangle triangle = ctx.getBean("triangleArea", Triangle.class);
//		System.out.println("가로세로 : 5,3 =" + triangle.getArea());
//		ctx.close();

//		Area area = ctx.getBean("area", Area.class);
//		System.out.println("삼각형 혹은 사각형의 넓이는 =" + area.getArea(10, 20.5));
//		ctx.close();
//		
//		Pencil pencil = ctx.getBean("pencil",Pencil.class);
//		pencil.use();
//		ctx.close();
//		String config = "classpath:appCTX.xml";
//		String config2 = "classpath:appCTX2.xml";
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext(config,config2);
//		StudentInfo studentInfo= ctx.getBean("studentinfo1", StudentInfo.class);
//		Student student2 = studentInfo.getStudent();
//		
//		System.out.println(student2.getName());
//		System.out.println(student2.getHobby());
//		
		
//		Student student1= ctx.getBean("student1", Student.class);
//		
//		System.out.println(student1.getName());
//		System.out.println(student1.getHobby());
		
//		Family family = ctx.getBean("family", Family.class);
//		
//		System.out.println(family.getPapaName());
//		System.out.println(family.getMamName());
//		System.out.println(family.getSisterName());
//		System.out.println(family.getBrotherName());
		
	}
}
