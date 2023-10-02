<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="ismgroup66_java.*,java.util.List" %>

<%@ include file="checkauthentication.jsp" %>

<!--User user = (User)session.getAttribute("authentication");/ String username = u.getUsername(); /String username = request.getParameter("username") /session.getAttribute("authentication", user )-->

<%

ClassesService classesService = new ClassesService();

List<Classes> classess = classesService.getClasses("user.getUsername()");

LessonService lessonService = new LessonService();

%>

<!DOCTYPE html>

<html lang="en">

    <head>

        <%@ include file="header.jsp"%>

        <title>Your Classes</title>

        <!-- Adding some custom style to page -->
        <style>
            h3.a {
            font-family: "Audiowide", sans-serif;
            
            text-shadow: 0 0 3px #592f81fa;
            }   
        </style>

        <!--<style type="text/css">
            form { max-width: 600px; }
            .main-label { font-size: 16px; }
        </style>-->

    </head>


    <body>

        <%@ include file="navbar.jsp"%>

<!--
        <style type="text/css">
            div.c {

            left: 150px;
            width: 200px;
            height: 120px;
            border: 3px solid green;
          }
        </style>
-->

    </head>

    <body>
        
<%
        for (Classes classes: classess) {

        List<Lesson> lessons = lessonService.getLessonNumByClassId("classes.getId()");
%>
        <div class="container theme-showcase" role="main">

			<div class="page-header table-responsive">
				<h1><%=classes.getId() %></h1>
			</div>

            <form class="form-horizontal">

                <!-- Table -->
                <table class="table table-striped table-bordered table-hover">
                    <tr>
                        <th>Lessons</th> 
                        <th>Theory</th>  
                        <th>Game</th> 
                    </tr> 

<% 
                    for (Lesson lesson: lessons) {
%>

                    <tr>
                        <td><%=lesson.getLessonNum() %></td>
                        <td><%=lesson.getTheory() %></td>
                        <td> <a href="/Lesson.pdf">Game link</a></td>
                    </tr>

<%
                    }
%>	

                </table>
             
            </form>

		</div>

<%
        }
%>

<script src="<%=request.getContextPath() %>/js/script.js"></script>
<!--<%@ include file="footer.jsp"%>-->

    </body>

</html>