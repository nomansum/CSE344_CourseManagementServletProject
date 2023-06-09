<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %> 
<%@page import="java.util.ArrayList"%>
<%@page import="cse.web.Student"%>
<%@page import="cse.web.Course"%>

<%ArrayList<Course> courseList=(ArrayList<Course>)request.getAttribute("courseList");%>
<%Student std = (Student)request.getAttribute("data");
%>
<!DOCTYPE html>
<html>
<head>
	<title>Online Course Registration</title>
	<link rel="stylesheet" type="text/css" href="./public/course.css">
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
			<h1>Available Courses</h1>
      <h1> <center>Online Course Registration</center></h1>
      
			<a href="logout">Logout</a>
		</nav>
	</header>

	<main>
		<form method='post' action='registerCourse'>
			<h2>Register For New Courses</h2>
			<table class="css-serial">
				<thead>
					<tr>
						<th>SL</th>
                       
						<th>Course ID</th>
						<th>Course Name</th>
						<th>Credit</th>
					</tr>
				</thead>
        
				<tbody>
				
				
							<%! int i=0; %>  
			     <%
			    for(int j=0; j<courseList.size(); j++){%>
			            <tr>
			              <td> </td>
			              <td><%=courseList.get(j).courseId %></td> 
						  <td><%=courseList.get(j).courseName %></td>            
			              <td><%=courseList.get(j).credit %></td> 
			              
			          			              
			            </tr>
			            
			
				<%}%>
          
<!--  					<tr>
                        <td> </td>
						<td><input type='checkbox'class='check-box'> </td>
						<td><input type="text" name="course-id"></td>
						<td><input type="text" name="course-name"></td>
						<td><input type="text" name="credit"></td>
					</tr> 	-->

					
            <select required name="courseId" id="language" style="width:200px; height:30px; font-size:17px;">
									  <option value="" disabled selected hidden>Choose a Course</option>
									  <% for(int l=0; l<courseList.size(); l++){ %>
									  	<option value=<%=courseList.get(l).courseId %>> <%=courseList.get(l).courseId %></option>
									  <%} %>
									</select>
									
									<button type="submit" name="submit-add" >ADD</button>
          
				</tbody>
			</table>
		</form>
	</main>
</body>
</html>