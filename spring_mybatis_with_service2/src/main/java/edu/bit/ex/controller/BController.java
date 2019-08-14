package edu.bit.ex.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.ex.service.BoardService;
import edu.bit.ex.vo.BoardVO;

@Controller
public class BController {

	@Inject
	BoardService boardService;

	@RequestMapping("/list")
	public String list(Model model) throws Exception {

		System.out.println("list()");

		model.addAttribute("list", boardService.selectBoardList());
		return "list";
	}

	@RequestMapping("/write")
	public String write(BoardVO boardVO, Model model) throws Exception {

		System.out.println("write");

		boardService.insertBoard(boardVO);

		return "redirect:list";
	}

	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) throws Exception {

		System.out.println("content_view()");

		String bId = request.getParameter("bId");

		model.addAttribute("content_view", boardService.selectBoardOne(bId));

		return "content_view";
	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) throws Exception {

		System.out.println("delete()");

		String bid = request.getParameter("bId");
		int bId = Integer.parseInt(bid);

		boardService.deleteBoard(bId);

		return "redirect:list";
	}

	@RequestMapping("/modify")
	public String modify(BoardVO boardVO, Model model) throws Exception {

		System.out.println("modify()");

		boardService.updateBoard(boardVO);

		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) throws Exception {
		
		System.out.println("reply_view()");
		
		String bId = request.getParameter("bId");

		model.addAttribute("reply_view", boardService.replyView(bId));
		
		return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(BoardVO boardVO, Model model) throws Exception {
		
		System.out.println("reply()");
		
		boardService.reply(boardVO);
		
		return "redirect:list";
	}
}