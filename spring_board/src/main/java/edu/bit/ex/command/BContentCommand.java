package edu.bit.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import edu.bit.ex.dao.BDao;
import edu.bit.ex.dto.BDto;

public class BContentCommand implements BCommand {

	@Override
	public void execute(Model model) { //model ==> view에 데이터 혹은 객체를 전달한다.
		// TODO Auto-generated method stub 
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String bId = request.getParameter("bId"); // 대소문자 틀리면 안된다.
		
		BDao dao = new BDao();
		BDto dto = dao.contentView(bId);
		
		model.addAttribute("content_view", dto);
		
	}

	
}
