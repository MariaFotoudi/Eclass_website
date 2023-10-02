<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import= "java.util.List,ismgroup66_java.*" %>
<jsp:include page = "checkauthentication.jsp"/>

<%

if (session.getAttribute("points") == null) {
    Integer x = 0;
    session.setAttribute("points",x);
}
String ans = (String) request.getParameter("ans");
if (ans.equals("exit")) {
    session.invalidate(); %>
    <jsp:forward page="index.jsp" /> <%
}
String qu =(String) session.getAttribute("qu");
String ret = " ";
Game gm = (Game) session.getAttribute("gm");
List<String> listOfWords = (List<String>) session.getAttribute("listOfWords");

ret = gm.checkWord(qu,ans,listOfWords);
Integer points = (Integer) session.getAttribute("points");
if(ret.equals("Your anwser is correct")){
    points = points +2;
    
} else {
    points = points - 1;
    
}
session.setAttribute("points",points);
session.setAttribute("ret",ret);


if (!(listOfWords.isEmpty()))  {%>
<jsp:forward page="newgame.jsp" />
<% }else { 
    User user = (User) session.getAttribute("authentication");

    String username = user.getUsername();
    Gamesession gamesession = new Gamesession(username,points);

    GameDao gamedao = new GameDao();
    session.removeAttribute("ret");
    session.removeAttribute("listOfWords");
    session.removeAttribute("gm");
    session.removeAttribute("qu");
    session.removeAttribute("ans");
    gamedao.saveStudent(gamesession);

    %>

    <jsp:forward page="answers.jsp" /> <%

} %>

