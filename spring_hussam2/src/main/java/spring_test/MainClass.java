package spring_test;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainClass {
	public static void main(String[] args) {
		
//		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext(); //컨테이너를 가져온다.
//		ConfigurableEnvironment env = ctx.getEnvironment(); //컨테이너에 있는 Environment객체를 가져온다.
//		MutablePropertySources propertySources = env.getPropertySources(); // resource파일을 가져오는 방법.
		
//		try {
//			propertySources.addLast(new ResourcePropertySource("classpath:admin.properties"));
//			
//			System.out.println(env.getProperty("admin.id"));
//			System.out.println(env.getProperty("admin.pw"));
//			
//		} catch (IOException e) {}
		//adminproperties - EnvironmentAware(Environment env) - (Id, Pw, env)
//		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx;
//		gCtx.load("appCTX.xml");
//		gCtx.refresh();
//		
//		AdminConnection adminConnection = gCtx.getBean("adminConnection", AdminConnection.class);
//		System.out.println("admin ID :" + adminConnection.getAdminId());
//		System.out.println("admin PW :" + adminConnection.getAdminPw());
		
//		String config = null; //가비지 컬렉터한테 메모리를 회수해도 된다는 의미., 너는 null이라고 지시하다.
//		
//		Scanner scanner = new Scanner(System.in);
//		String str = scanner.next();
//		
//		if(str.equals("dev")) {
//			config = "dev";
//		} else { 
//			config = "run";
//		}
//		
//		scanner.close();
//		
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//		//Environment = 객체를 대신 불러와준다.
//		ctx.getEnvironment().setActiveProfiles(config); //setActiveProfiles = xml에 세팅된 profile "dev","run"파일을 실행시킨다.
//		ctx.load("appCTX_dev.xml", "appCTX_run.xml");
//		
//		ServerInfo serverInfo = ctx.getBean("serverInfo", ServerInfo.class);
//		
//		System.out.println("ip :" + serverInfo.getIpNum());
//		System.out.println("port :" + serverInfo.getPortNum());
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("appCTX.xml");
		subAdminConnection subadminConnection = ctx.getBean("subadminConnection", subAdminConnection.class);
		
		
		System.out.println("admin ID : " + subadminConnection.getAdminId());
		System.out.println("admin PW : " + subadminConnection.getAdminPw());
		System.out.println("admin ID : " + subadminConnection.getSub_AdminId());
		System.out.println("admin PW : " + subadminConnection.getSub_AdminPw());
		
	}
}
