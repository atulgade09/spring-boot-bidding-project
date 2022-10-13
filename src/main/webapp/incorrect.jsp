<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="newLoginPage.jsp">
    <jsp:param name="content" value="content_page_name"></jsp:param>
</jsp:include>
 <script type="text/javascript">
            alert('Please Enter a correct Email or Password');
        </script>
</body>
</html>