<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>  
<html>  
<head>  
<style>  
div.box{margin:2px;border:1px solid pink;padding:10px;background-color:#e3e3e3}  
</style>  
</head>  
<body>  
  
<%@ page import="java.sql.*" %>  
<%  
String noidung = request.getParameter("noidung");  
String email=request.getParameter("email");  
if(noidung==null||email==null||noidung.trim().equals("")||email.trim().equals("")){  
out.print("<p>Please write comment</p>");  
}else{  
  
try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  
PreparedStatement ps=con.prepareStatement("insert into usercomment(noidung,email) values(?,?)");  
ps.setString(1,noidung);  
ps.setString(2,email);  
int i=ps.executeUpdate();  
  
PreparedStatement ps2=con.prepareStatement("select * from usercomment order by id desc");  
ResultSet rs=ps2.executeQuery();  
  
out.print("<hr/><h2>Comments:</h2>");  
while(rs.next()){  
out.print("<div class='box'>");  
out.print("<p>"+rs.getString(2)+"</p>");  
out.print("<p><strong>By: "+rs.getString(3)+"</strong></p>");  
out.print("</div>");  
}  
  
con.close();  
}catch(Exception e){out.print(e);}  
  
}//end of else  
%>  
</body>  
</html>  
