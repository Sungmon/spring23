package org.zerock.persistence;

// *spring이 인터페이스를 이용해서 객체를 생성했다*
// MyBatis-Spring의 경우 Mapper인터페이스와 XML을 동시에 이용할수 있다.
// MyBatis는 내부적으로 JDBC의 PreparedStatement를 이용해서 SQL을 처리한다.
// PreparedStatement의 값이 ?으로 나오는데 이를 해결하기 위해 log4jdbc-log4j2 라이브러리를 사용한다.
// 라이브러리를 추가한 후에는 1. 로그 설정 파일을 추가하는 작업 과 2. JDBC의 연결 정보를 수정해야 한다.

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.TimeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") 
@Log4j
public class TimeMapperTests {

	
	@Setter(onMethod_ = @Autowired)
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTime() {
		log.info(timeMapper.getClass().getName());
		log.info(timeMapper.getTime());
	}
	
	@Test
	public void getTime2() {
		log.info("getTime2");
		log.info(timeMapper.getTime2());
	}
}
