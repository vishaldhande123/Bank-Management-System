<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="bank.*"%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String msg =(String) request.getAttribute("msg");
out.print(msg);


out.println("....."+"<br><br>");


RegisterBean rd=(RegisterBean)request.getAttribute("rb");
//out.println(rd.getAmt());
//out.println(rd);

out.println("User Account Balance"+"<br>");
out.println("Amount is "+rd.getAmt()+"<br>");

%>
</body>
</html>