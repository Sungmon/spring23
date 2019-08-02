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
		이름를 입력하세요. : <input type = "text" name = "namea"><br>
		국어 점수를 입력하세요. : <input type = "text" name = "kua"><br>
		영어 점수를 입력하세요. : <input type = "text" name = "ena"><br>
		수학 점수를 입력하세요. : <input type = "text" name = "maa"><br>
		과학 점수를 입력하세요. : <input type = "text" name = "sca"><br>
		<input type = "submit" value = "전송">
	</form>

</body>
</html>