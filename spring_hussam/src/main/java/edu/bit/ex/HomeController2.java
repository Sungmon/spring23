package edu.bit.ex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping
public class HomeController2 {

	@RequestMapping("/board/view")
	public String view() {

		return "board/view";

	}
	
	@RequestMapping("/board/content")
	public String content(Model model) { 
		model.addAttribute("id",30);
		
		return "board/content";
	}
	
	@RequestMapping("/board/reply")
	public ModelAndView reply() {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("id",30);
		mv.setViewName("board/reply");
		
		return mv;

	}
	
	@RequestMapping("/board/confirm") 
	public String confirm(HttpServletRequest req, Model model) {
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		return "board/confirm";
	}
	
	@RequestMapping("/board/check")
	public String check(@RequestParam("id") String id,
						@RequestParam("pw") String pw, Model model) {
		
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);

		return "board/confirm";
	}
}