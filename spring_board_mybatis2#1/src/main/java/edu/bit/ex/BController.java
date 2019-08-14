package edu.bit.ex;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.bit.ex.dao.IBDao;
import edu.bit.ex.dto.BDto;


@Controller
public class BController {
	

	@Inject
	private SqlSession sqlSession;

	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("야 이 xx야!!");
	
		IBDao dao = sqlSession.getMapper(IBDao.class);
		model.addAttribute("list", dao.listDao());
		
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		
		System.out.println("WTF!!!!!");
		
		return "write_view";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		
		System.out.println("content_view");

		String bid = request.getParameter("bId");
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		model.addAttribute("list", dao.ContentDao(bid));
		
		return "content_view";
	}
	
	//request 객체가 필요한 이유 ? bId 를 받아내기 위해서. (get/post인수전달.)
	//Model model ? Dao에 request 객체전달.
	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request ,Model model) {
		
		System.out.println("delete()");
		
		String bid = request.getParameter("bId");
		int num = Integer.parseInt(bid);
	
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		dao.deleteDao(num);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST) 
	public String modify(BDto bDto, Model model) {
		
		System.out.println("싸우스캐슬한테 빠따좀 맞아야겠네");
		
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		dao.updateDao(bDto);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/write", method = {RequestMethod.GET, RequestMethod.POST})
	public String write(HttpServletRequest request, Model model) {
		
		System.out.println("write()");
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		dao.writeDao(request.getParameter("bName"),
				request.getParameter("bTitle"),
				request.getParameter("bContent"));
		
		return "redirect:list";
	}
//	
//	
//	
	@RequestMapping("/reply_view") 
	public String refly_view(HttpServletRequest request, Model model) {
		
		System.out.println("내가 성만이다 ");
		
		
		return "reply_view";
	}
//	
	@RequestMapping(value ="/reply") 
	public String refly(HttpServletRequest request, Model model) {
		
		System.out.println("내가 성만이다 ");
		
		
		return "redirect:list";
	}
	
}	
