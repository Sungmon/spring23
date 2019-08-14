package edu.bit.ex.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import edu.bit.ex.dto.BDto;

public interface IBDao {

	public abstract ArrayList<BDto> listDao();
	public BDto ContentDao(String bId);
	public void deleteDao(int bId);
	public void writeDao(String bName, String bTitle, String bContent);
	public void reply_view(String bGroup, String bStep);
//	public void modifyDao(@Param("bId") int bId,
//			@Param("bName")String bName,
//			@Param("bTitle")String bTitle,
//			@Param("bContent")String bContent);
	
	public void updateDao(BDto bDto);
}
