package edu.bit.ex.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.bit.ex.command.BCommand;
import edu.bit.ex.command.BContentCommand;
import edu.bit.ex.command.BDeleteCommand;
import edu.bit.ex.command.BListCommand;
import edu.bit.ex.command.BLoginCommand;
import edu.bit.ex.command.BModifyCommand;
import edu.bit.ex.command.BReplyCommand;
import edu.bit.ex.command.BReplyViewCommand;
import edu.bit.ex.command.BWriteCommand;

@Controller
public class BController {
	
	BCommand command = null;

	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("야 이 xx야!!");
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
		
		System.out.println("WTF!!!!!");
		
		return "write_view";
	}
	
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		
		System.out.println("FFFFFFFFFFFFFFFFFFFFFFF");
		
		model.addAttribute("request", request);
		
		command = new BWriteCommand(); 
		command.execute(model);
		
		return "redirect:list";
	}
	
	//request 객체가 필요한 이유 ? bId 를 받아내기 위해서. (get/post인수전달.)
	//Model model ? Dao에 request 객체전달.
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		
		System.out.println("꺼쪄!!!!");
		
		model.addAttribute("request", request);
		
		command = new BDeleteCommand(); //컨트롤러에서 커멘드객체 생성.
		command.execute(model); //model에 담아서 전달한다.
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST) 
	public String modify(HttpServletRequest request, Model model) {
		
		System.out.println("싸우스캐슬한테 빠따좀 맞아야겠네");
		
		model.addAttribute("request", request);
		
		command = new BModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view") 
	public String refly_view(HttpServletRequest request, Model model) {
		
		System.out.println("내가 성만이다 ");
		
		model.addAttribute("request", request);
		
		command = new BReplyViewCommand();
		command.execute(model);
		
		return "reply_view";
	}
	
	@RequestMapping(value ="/reply") 
	public String refly(HttpServletRequest request, Model model) {
		
		System.out.println("내가 성만이다 ");
		
		model.addAttribute("request", request);
		
		command = new BReplyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
}	
