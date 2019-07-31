package org.zerock.controller;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample")
@Log4j
public class SampleController {

	// 파라미터의 수집을 다른 용어로는 'binding'(바인딩)이라고 한다.
	// '2018-01-01'과 같은 문자열을 java.util.Date타입으로 변환하는 작업.
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
//	}

	@RequestMapping("")
	public void basic() {

		log.info("basic..............");
	}

	@RequestMapping(value = "/basic", method = { RequestMethod.GET, RequestMethod.POST })
	public void basicGet() {

		log.info("basic get.....................");
	}

	@GetMapping("/basicOnlyGet")
	public void basicGet2() {

		log.info("basic get only get................");
	}

	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {

		log.info("" + dto);

		return "ex01";
	}

	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {

		log.info("name: " + name);
		log.info("age: " + age);

		return "ex02";
	}

	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {

		log.info("ids: " + ids);

		return "ex02List";
	}

	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {

		log.info("list dtos: " + list);

		return "ex02Bean";
	}

	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {

		log.info("todo : " + todo);
		return "ex03";
	}

//	@GetMapping("/ex04")
//	public String ex04(SampleDTO dto, int page) {
//		log.info("dto: " + dto);
//		log.info("page: " +page);
//		
//		return "/sample/ex04
//	}

	// Controller의 메서드를 작성할 때는 Model이라는 타입을 파라미터로 지정할 수 있다.
	// Model 객체는 JSP에 컨트롤러에서 생성된 데이터를 담아서 전달하는 역할을 한다. -> view로 데이터를 담아서 보낸다.
	// @ModelAttribute는 강제로 전달받은 파라미터를 Model에 담아서 전달한다.(타입에 영향을 받지 않는다)
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {

		log.info("dto: " + dto);
		log.info("page: " + page);

		return "/sample/ex04";
	}

	@GetMapping("/ex05")
	public void ex05() {
		log.info("/ex05..............");
	}

	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06.............");

		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");

		return dto;
	}

	// MVC의 사상은 HttpServletRequest or HttpServletResponse를 직접 핸들링하지 않는다.
	// HTTP 프로토콜의 헤더를 다룰때 사용.
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {
		log.info("/ex07.............");

		// {"name" = "홍길동"}
		String msg = "{\"name\" : \"홍길동\"}";

		HttpHeaders header = new HttpHeaders();
		header.add("content-Type", "application/json; charset=UTF-8");

		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}

	@GetMapping("/exUpload")
	public void exUpload() {

		log.info("/exUpload.........");
	}

	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {

		files.forEach(file -> {
			log.info("-----------------------------------");
			log.info("name : " + file.getOriginalFilename());
			log.info("size : " + file.getSize());
		});
	}
}
