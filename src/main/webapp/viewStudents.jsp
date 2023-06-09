<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="cse.web.CourseReg"%>


<%ArrayList<CourseReg> regList=(ArrayList<CourseReg>)request.getAttribute("regList");
if(regList.isEmpty())System.out.println("This is Working!!");

%>
<% String courseName= (String)request.getAttribute("courseId"); %>
<!DOCTYPE html>
<html>
<head>
	<title>Online Course Registration</title>
	<link rel="stylesheet" type="text/css" href="./public/view.css">
</head>
<body>
<%-- <%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragme", "no-cache");
		response.setHeader("Expires", "0");
		if (session.getAttribute("name") == null) {
			response.sendRedirect("index.jsp");
		}
%> --%>

	<header>
		<nav>
			<h1>Subject</h1>
      <h1> <center>Online Course Registration</center></h1>
			<a href="logout">Logout</a>
		</nav>
	</header>

	<main>
		<form>
            <h1>Course : <%= courseName %></h1>
			<h2>Student List</h2>
			<table class="css-serial">
				<thead>
					<tr>
						<th>SL</th>
						<th>Registration no</th>
						<th>Student Name</th>
						
					</tr>
				</thead>
        
				<tbody>
          			<%
          			for(int k=0; k<regList.size(); k++){ %>
	                    <tr>
							<td> </td>
							<td><%= regList.get(k).studentReg %></td>
							<td><%= regList.get(k).studentName %></td>
							
						</tr>            
						
					<% }%>
					
				
				</tbody>
			</table>
			
		</form>
	</main>
</body>
</html>