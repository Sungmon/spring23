<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

	<form action = "/sub/scoreResult" method = "get">
		이름를 입력하세요. : <input type = "text" name = "namea" placeholder = "당신의 이름은?" autofocus><br>
		국어 점수를 입력하세요. : <input type = "text" name = "kua" placeholder = "당신의 국어 점수는?"><br>
		영어 점수를 입력하세요. : <input type = "text" name = "ena" placeholder = "당신의 영어 점수는?"><br>
		수학 점수를 입력하세요. : <input type = "text" name = "maa" placeholder = "당신의 수학 점수는?"><br>
		과학 점수를 입력하세요. : <input type = "text" name = "sca" placeholder = "당신의 과학 점수는?"><br>
		<input type = "submit" value = "전송">
	</form>

</body>
</html>