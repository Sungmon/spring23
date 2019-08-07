package edu.bit.ex.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import edu.bit.ex.dao.BDao;
import edu.bit.ex.dto.BDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) { //model ==> view에 데이터 혹은 객체를 전달한다.
		// TODO Auto-generated method stub 
		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list(); 
		//bdto에 게시판의 글들을 담아온다.
		model.addAttribute("list",dtos);
		
	}

	
}
