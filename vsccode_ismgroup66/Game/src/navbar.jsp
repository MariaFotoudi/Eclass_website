<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="ismgroup66_java.*,java.util.List" %>
<%@ page errorPage="error.jsp" %>

<%@ include file="checkauthentication.jsp" %>

<%

	User user = (User)session.getAttribute("authentication");

%>
            <nav>
                <div class="nav-left">
                    <img src="<%=request.getContextPath() %>/images/images-logo.jfif" alt="logo" class="logo">
                    <h4 style="color:whitesmoke" class="a">Supportly</h4>
                    <ul>
                        <li><a href="<%=request.getContextPath() %>/firstpages/index.jsp">Home</a></li>
                        <li><a href="<%=request.getContextPath() %>/firstpages/classes.jsp">Class</a></li>
                        <li> <a href="skype:cid.5728887e6ec8a357" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Skype</a> </li>
                    </ul>
                </div>
                
                <div class="nav-right">
                    <!--me epifilajh ti ulopoihsh tha exei apo pisw 18 lepta video-->
                    <div class="search-box">
                        <img src="<%=request.getContextPath() %>/images/search.png">
                        <input type="text" placeholder="Search">
                    </div>
                    <div class="nav-user-icon" onclick="settingsMenuToggle()">
                        <img src="<%=request.getContextPath() %>/images/profile-pic.png">

                    </div>
                </div>
                <div class="settings-menu">

                    <div class="settings-menu-inner">
                        <div class="user-profile">
                            <img src="<%=request.getContextPath() %>/images/profile-pic.png">
                            <div>
                                <p><%=user.getUsername() %></p>
                                <a href="<%=request.getContextPath() %>/firstpages/profile.jsp"> See your profile</a>
                                <!--<small>Public <i class="fas fa-caret-down"></i></small>-->
                            </div>
                        </div> 
                    </div>
                    
                    <hr>
                    <div class="settings-links">
                        <img src="<%=request.getContextPath() %>/images/setting.png" class="settings-icon">
                        <a href="<%=request.getContextPath() %>/firstpages/settingsprivacy.jsp">Setings & Privacy <img src="<%=request.getContextPath() %>/images/arrow.png"
                        width="10px"></a>
                    </div>
                    <div class="settings-links">
                        <img src="<%=request.getContextPath() %>/images/help.png" class="settings-icon">
                        <a href="<%=request.getContextPath() %>/firstpages/helpsupport.jsp">Help & Support <img src="<%=request.getContextPath() %>/images/arrow.png"
                        width="10px"></a>
                    </div>
                    <div class="settings-links">
                        <img src="<%=request.getContextPath() %>/images/logout.png" class="settings-icon">
                        <a href="<%=request.getContextPath() %>/firstpages/logout.jsp">Logout<img src="<%=request.getContextPath() %>/images/arrow.png"  width="10px"></a>
                    </div>
                    
                </div>
            </nav>

        <script src="<%=request.getContextPath() %>/js/script.js"></script>

