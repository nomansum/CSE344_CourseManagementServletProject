<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %> 
<%@page import="java.util.ArrayList"%>
<%@page import="cse.web.Student"%>
<%Student std = (Student)request.getAttribute("data"); %>
<%@page import="cse.web.Course"%>

<%ArrayList<Course> courseList=(ArrayList<Course>)request.getAttribute("courseList");%>
<!DOCTYPE html>
<html>
<head>
	<title>Online Course Registration</title>
	<link rel="stylesheet" type="text/css" href="./public/teacher.css">
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
			<h1>Teacher</h1>
      <h1> <center>Online Course Registration</center></h1>
			<a href="logout">Logout</a>
		</nav>
	</header>

	<main>
		<form method="post" action="viewStudents">
            
			<h2>Your Courses</h2>
			<table class="css-serial">
				<thead>
					<tr>
						<th>SL</th>
						<th>Course ID</th>
						<th>Course Name</th>
						<th>Credit</th>
						<th>Student List</th>
					</tr>
				</thead>
        
				<tbody>
          
					
				
				<%for(int j=0; j<courseList.size(); j++){%>
			  
			            <tr>
			              <td> </td>
			              <td><%= courseList.get(j).courseId %></td> 
						  <td><%= courseList.get(j).getCourseName() %></td>  
						  <td><%= courseList.get(j).getCredit() %></td>           
			              <td><button type="submit" name="courseId" value=<%=courseList.get(j).courseId %> > View </button></td>  <!--type="button"  -->
			            </tr>
			       
			
				<%}%>
				 			
				</tbody>
			</table>
			
		</form>
	</main>
</body>
</html>