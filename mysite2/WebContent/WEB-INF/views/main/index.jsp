<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link
	href="${pageContext.servletContext.contextPath}/assets/css/main.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="wrapper">
			<div id="content">
				<div id="site-introduction">
					<img id="profile"
						src="${pageContext.servletContext.contextPath}/assets/images/myimage.jpg"
						height="150">
					<h2>안녕하세요. 최원진의 mysite에 오신 것을 환영합니다.</h2>
					<p>
						이 사이트는 jsp와 서블릿을 배우고 실습과제로 제출한 사이트입니다.<br>
						최근에 학교에서 아~~~주 맛없는 학식을 먹다가 더존비즈온에서 다와푸드를 식사로 제공해 줬는데 
						너무너무 만족하고 먹고있습니다. 요즘 가장 관심을 가지고 있는 부분은 리팩토링과 디자인 패턴 입니다.
					
						
						<br> <br> <a
							href="${pageContext.servletContext.contextPath}/guestbook">방명록</a>에
						글 남기기<br>
					</p>
				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp" >
		<c:param name="menu" value="main"></c:param>   
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp" /></div>

</body>
</html>