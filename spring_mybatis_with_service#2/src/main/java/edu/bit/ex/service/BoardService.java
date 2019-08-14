package edu.bit.ex.service;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import edu.bit.ex.vo.BoardVO;


@Service
public class BoardService {

	@Inject
	SqlSessionTemplate sessionTemplate;
	
	public List<BoardVO> selectBoardList() throws Exception{
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("board.selectBoardList");
		
	}
	
	public BoardVO selectBoardOne(String bId) throws Exception{
		
		return sessionTemplate.selectOne("board.selectBoardOne", bId);
		
	}

	public void insertBoard(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		sessionTemplate.insert("board.insertBoard",boardVO);
		
	}
	
	public void deleteBoard(int bId) throws Exception {
		
		sessionTemplate.delete("board.deleteBoard",bId);
	}

	public void updateBoard(BoardVO boardVO) throws Exception  {
		// TODO Auto-generated method stub
		sessionTemplate.update("board.updateBoard",boardVO);
	}
	
	public BoardVO replyView(String bId) throws Exception {
		
		return sessionTemplate.selectOne("board.replyView", bId);
	}
	
	public void reply(BoardVO boardVO) throws Exception {
		
		sessionTemplate.update("board.reply1", boardVO);
		sessionTemplate.insert("board.reply2", boardVO);
	}
}