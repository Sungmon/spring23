package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
// @Data = Lombok을 이용해서 getter/setter을 자동생성하고 'onMethod'속성을 이용해서 setter에 @autowired 추가.
//@ToString, @EqualsAndHashcode, @getter/setter, @RequiredArgsCosntructor 등이 @Data에너테이션에 포함되어있다.
@Data
public class Restaurant {

	@Setter(onMethod_ = @Autowired)
	private Chef chef;
}
