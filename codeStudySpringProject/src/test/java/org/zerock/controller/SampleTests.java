package org.zerock.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

// @RunWith = 현재 테스트 코드가 스프링을 실행하는 역할 이라고 선언!
// 테스트시 필요한 클래스를 지정. 스프링은 SpringJUnit4ClassRunner.class가 대상이 된다.
@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration = 어노테이션과 속성값인 문자열 설정. 지정된 클래스나 문자열을 이용해서 필요한 객체들을 스프링 내에 객체로 등록한다. 
//스프링이 실행되면서 어떤 설정 정보를 읽어 들여야 하는지를 명시한다.
//'classpath' 혹은 'file'을 경로지정할수 있다.
//이 에너테이션이 문제를 일으킬 시에는 spring-test를 pom.xml에 추가해주자.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") 
//로그를 기록하는 Logger를 변수로 생성한다. 객체의 선언없이 Log4j라이브러리와 설정이 존재한다면 바로 사용할 수 있다.
@Log4j 																	
public class SampleTests {												
	
	@Setter(onMethod_ = { @Autowired } ) //@Autowired는 해당 인스턴스 변수가 스프링으로부터 자동으로 주입해 달라는 표시
	private Restaurant restaurant;
	
	@Test
	//@Test = Junit에서 해당 메서드가 JUnit상에서 단위 테스트의 대상인지 알려준다.
	public void testExist() {
		//assertNotNull는 해당 변수가 null이 아니여야만 테스트를 성공시킨다.
		assertNotNull(restaurant);
		
		log.info(restaurant);
		log.info("-------------------------------");
		log.info(restaurant.getChef());
	}
}
