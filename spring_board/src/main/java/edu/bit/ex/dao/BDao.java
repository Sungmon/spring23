package edu.bit.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import edu.bit.ex.dto.BDto;

//Data access object 
public class BDao {

	DataSource dataSource; // 커넥션 풀. <- 서버에서 관리한다.언제나, 이객체자체가 의미한다 커넥션풀을.

	public BDao() {

		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			// TODO : handle exception
			e.printStackTrace();
		}
	}

	// 게시판 만드는 공식.
	public ArrayList<BDto> list() {

		ArrayList<BDto> dtos = new ArrayList<BDto>(); // 각각의 게시판이 dto

		// 3단콤보 셋트
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			connection = dataSource.getConnection();
			String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from mvc_board order by bGroup desc, bstep asc";
			// 문자가 부적합합니다.
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int bId = resultSet.getInt("bId");
				String bname = resultSet.getString("bname");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");

				BDto dto = new BDto(bId, bname, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				dtos.add(dto);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return dtos;
	}

	public BDto contentView(String bId) {
		// TODO Auto-generated method stub

		// upHit(bId); //조회수를 표현한다. <= upHit
		BDto dto = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try { // try catch문이 없으면 에러 발생! 이유는 나중에?

			connection = dataSource.getConnection();
			String query = "select * from mvc_board where bId = ?";
			// 문자가 부적합합니다.
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(bId)); // ? 에 대한 값을 받아온다.

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) { // next() => 가져왔느냐라는 의미

				int bid = resultSet.getInt("bId");
				String bname = resultSet.getString("bname");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");

				dto = new BDto(bid, bname, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return dto;
	}

	public void write(String bName, String bTitle, String bContent) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try { // try catch문이 없으면 에러 발생! 이유는 나중에?

			connection = dataSource.getConnection();
			String query = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values "
					+ "(mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0 )";
			// 문자가 부적합합니다.
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);

			// executeUadate 함수를 사용하는 방법
			// -> INSERT / DELETE / UPDATE 관련 구문에서는 반영된 레코드를 반환한다.

			int rn = preparedStatement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

	}

	public void delete(String bId) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try { // try catch문이 없으면 에러 발생! 이유는 나중에?

			connection = dataSource.getConnection();
			String query = "delete from mvc_board where bId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(bId)); // ? 에 대한 값을 받아온다.
			
			int rn = preparedStatement.executeUpdate();
			System.out.println("rn :" + rn);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

	public void modify(String bId, String bName, String bTitle, String bContent) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try { // try catch문이 없으면 에러 발생! 이유는 나중에?

			connection = dataSource.getConnection();
			String query = "update mvc_board set bName = ?, bTitle = ?, bContent = ? where bId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			preparedStatement.setInt(4, Integer.parseInt(bId)); // ? 에 대한 값을 받아온다. 4는 ?의 4번째숫자.
			
			int rn = preparedStatement.executeUpdate();
			System.out.println("rn :" + rn);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

	public BDto reply_view(String bId) {
		
		BDto dto = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try { // try catch문이 없으면 에러 발생! 이유는 나중에?

			connection = dataSource.getConnection();
			String query = "select * from mvc_board where bId = ?";
			// 문자가 부적합합니다.
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(bId)); // ? 에 대한 값을 받아온다.

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) { // next() => 가져왔느냐라는 의미

				int bid = resultSet.getInt("bId");
				String bname = resultSet.getString("bname");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");

				dto = new BDto(bid, bname, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return dto;
	}

	public void reply(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep,
			String bIndent) {

		replyShape(bGroup, bStep); 
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try { // try catch문이 없으면 에러 발생! 이유는 나중에?

			connection = dataSource.getConnection();
			// bStep = 답변글의 계층 
			// ㄴ
			//	ㄴ
			//	  ㄴ 이런식의 계층.
			String query = "insert into mvc_board (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)"; //nextval = 자동증가
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			preparedStatement.setInt(4, Integer.parseInt(bGroup));
			preparedStatement.setInt(5, Integer.parseInt(bStep));
			preparedStatement.setInt(6, Integer.parseInt(bIndent));
			
			int rn = preparedStatement.executeUpdate();
			System.out.println("rn :" + rn);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	private void replyShape(String bGroup, String bStep) {
		//db에 넣기 전에 처리해야됨 bGroup, bStep
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try { // try catch문이 없으면 에러 발생! 이유는 나중에?

			connection = dataSource.getConnection();
			// bStep = 답변글의 계층 
			// ㄴ
			//	ㄴ
			//	  ㄴ 이런식의 계층.
			String query = "update mvc_board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(bGroup)); // ? 에 대한 값을 받아온다.
			preparedStatement.setInt(2, Integer.parseInt(bStep)); // ? 에 대한 값을 받아온다.
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
}
