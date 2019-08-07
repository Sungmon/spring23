package edu.bit.ex.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.ex.command.BCommand;
import edu.bit.ex.command.BContentCommand;
import edu.bit.ex.command.BListCommand;
import edu.bit.ex.command.BWriteCommand;

@Controller
public class BController {
	
	BCommand command = null;

	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()~~~~~~~~~~!!@@#!#$#@$@#$@#$");
		command = new BListCommand();
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		
		System.out.println("content_view");
		
		model.addAttribute("request", request);
		
		command = new BContentCommand(); //컨트롤러에서 커멘드객체 생성.
		command.execute(model); //model에 담아서 전달한다.
		
		return "content_view";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		
		System.out.println("write_view()");
		
		return "write_view";
	}
	
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		
		System.out.println("write()");
		
		model.addAttribute("request", request);
		
		command = new BWriteCommand(); 
		command.execute(model);
		
		return "redirect:list";
	}
}
