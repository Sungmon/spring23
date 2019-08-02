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

	너의 이름은 : ${name}<br>
	너의 국어 점수는 : ${ku}<br>
	너의 영어 점수는 : ${en}<br>
	너의 수학 점수는 : ${ma}<br>
	너의 과학 점수는 : ${sc}<br>
	너의 총점은 : ${totalsum}<br>
	너의 평균은 : ${avgscore}

</body>
</html>