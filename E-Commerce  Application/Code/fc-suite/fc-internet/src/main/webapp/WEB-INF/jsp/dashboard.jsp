<!doctype html>

<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>The First Credit - Dashboard</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="${pageContext.servletContext.contextPath}/resources/images/faviconfc.jpg" type="image/x-icon">
        <link rel="icon" href="${pageContext.servletContext.contextPath}/resources/images/faviconfc.jpg" type="image/x-icon">

    </head>

    <body>
        <!--########################## Main Header ###########################-->

        <%@include file="template/dashboard/header.jsp"%>

        <!-- ############# LEFT NAVIGATION ############# -->
        <div class="row">

            <div class="col-sm-12">
                <!-- ############# /LEFT NAVIGATION ############# -->


                <!-- ############# CONTENT ############# -->
                <div class="content">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="col-sm-9">
                                <h2 class="form-heading">Dashboard</h2> 
                            </div>
                            <span class="indicator">Last login time : <span>${lastLoginTime}</span></span>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-7 col-sm-8">
                            <ul class="dashboard-nav clearfix">
                                <li class="active">
                                    <a href="${pageContext.request.contextPath}/admin/dashboard" class="dash-nav" id="submenu-dashboard">
                                        <i class="fa fa-dashboard"></i>
                                        <span class="nav-text">Dashboard</span>
                                    </a>
                                </li>
                                <li>
                                    <c:choose>
                                        <c:when test="${usertype == 'Student'}">
                                            <a href="${pageContext.request.contextPath}/admin/my-profilest" class="dash-nav" id="submenu-my-profile">
                                            </c:when>
                                            <c:when test="${usertype == 'Employee'}">
                                                <a href="${pageContext.request.contextPath}/admin/my-profileem" class="dash-nav" id="submenu-my-profile">
                                                </c:when>
                                                <c:when test="${usertype == 'Parent'}">

                                                    <a href="${pageContext.request.contextPath}/admin/my-profilepr" class="dash-nav" id="submenu-my-profile">

                                                    </c:when>
                                                </c:choose>

                                                <i class="fa fa-user"></i>
                                                <span class="nav-text">My Profile</span>
                                            </a>
                                            </li>
                                            <c:choose>

                                                <c:when test="${usertype == 'Parent'}">
                                                    <security:authorize access="hasRole('1152')">
                                                        <li>
                                                            <a href="#" class="dash-nav" id="submenu-my-children" style="height: 80px;">
                                                                <i class="fa fa-street-view"></i>
                                                                <span class="nav-text">My Children</span>
                                                            </a>
                                                        </li>
                                                    </security:authorize>
                                                </c:when>
                                            </c:choose>
                                            <security:authorize access="hasRole('1150')">
                                                <li>
                                                    <a href="#" class="dash-nav" id="submenu-my-event" style="height: 85px;">
                                                        <i class="fa fa-calendar-check-o"></i>
                                                        <span class="nav-text">My Event Calendar</span>
                                                    </a>
                                                </li>
                                            </security:authorize>
                                            <security:authorize access="hasRole('1151')">
                                                <li>
                                                    <a href="#" class="dash-nav" id="submenu-my-timetable" style="height: 85px;">
                                                        <i class="fa fa-bell"></i>
                                                        <span class="nav-text"  style="line-height:16px; ">My Time Table</span>
                                                    </a>
                                                </li>
                                            </security:authorize>
                                            <security:authorize access="hasRole('1163')">
                                                <li>
                                                    <a href="#" class="dash-nav" id="submenu-my-exam">
                                                        <i class="fa fa-map-o"></i>
                                                        <span class="nav-text"  style="line-height:16px; ">My Exam</span>
                                                    </a>
                                                </li>
                                            </security:authorize>

                                            <security:authorize access="hasRole('1183')">
                                                <li>
                                                    <a href="#" class="dash-nav" id="submenu-my-assignment" style="height: 100px;">
                                                        <i class="fa fa-map"></i>
                                                        <span class="nav-text"  style="line-height:16px;">My Homework/ Assignment</span>
                                                    </a>
                                                </li>
                                            </security:authorize>

                                            <security:authorize access="hasRole('1173')">
                                                <li>
                                                    <a href="#" class="dash-nav" id="submenu-my-exam-submission" style="height: 85px;" >
                                                        <i class="fa fa-map-o"></i>
                                                        <span class="nav-text"  style="line-height:16px; ">My Marking Submission</span>
                                                    </a>
                                                </li>
                                            </security:authorize>

                                            <security:authorize access="hasRole('1187')">
                                                <li>
                                                    <a href="#" class="dash-nav" id="submenu-my-assignment-submission" style="height: 100px;" >
                                                        <i class="fa fa-calendar-check-o"></i>
                                                        <span class="nav-text"  style="line-height:16px; ">My Home./ Assi. Submission</span>
                                                    </a>
                                                </li>
                                            </security:authorize>

                                            <security:authorize access="hasRole('1169')">
                                                <li>
                                                    <a href="#" class="dash-nav" id="submenu-my-discipline" style="height: 85px;">
                                                        <i class="fa fa-exclamation-circle"></i>
                                                        <span class="nav-text"  style="line-height:16px; ">My Discipline</span>
                                                    </a>
                                                </li>
                                            </security:authorize>
                                            <security:authorize access="hasRole('1164')"> 
                                                <li>
                                                    <a href="#" class="dash-nav" id="submenu-my-lesson-planner" style="height: 110px;">
                                                        <i class="fa fa-pencil-square-o"></i>
                                                        <span class="nav-text"  style="line-height:16px; ">My Curriculum / Lesson Planner</span>
                                                    </a>
                                                </li>
                                            </security:authorize> 


                                            <security:authorize access="hasRole('1178')">     
                                                <li>
                                                    <a href="#" class="dash-nav" id="submenu-my-attendance" style="height: 85px;">
                                                        <i class="fa fa-check-square-o"></i>
                                                        <span class="nav-text"  style="line-height:16px; ">My Attendance</span>
                                                    </a>
                                                </li>
                                            </security:authorize> 


                                            <security:authorize access="hasRole('1000') or hasRole('1010')">
                                                <li>
                                                    <a href="#" class="dash-nav" id="submenu-student">
                                                        <i class="fa fa-graduation-cap"></i>
                                                        <span class="nav-text">Student</span>
                                                    </a>
                                                </li>
                                            </security:authorize>
                                                <li>
                                                    <a href="#" class="dash-nav" id="submenu-group">                                          
                                                        <i class="fa fa-users"></i>
                                                        <span class="nav-text">Group</span>
                                                    </a> 
                                                </li>  
                                                
                                                <li>
                                                    <a href="#" class="dash-nav" id="submenu-product">                                          
                                                        <i class="fa fa-folder"></i>
                                                        <span class="nav-text">Product</span>
                                                    </a> 
                                                </li>  
                                                
                                                  <li>
                                                    <a href="#" class="dash-nav" id="submenu-product">                                          
                                                        <i class="fa fa-building"></i>
                                                        <span class="nav-text">Reports</span>
                                                    </a> 
                                                </li>  
                                            <security:authorize access="hasRole('1057') or hasRole('1061') or hasRole('1065') or hasRole('1069') or hasRole('1077') or hasRole('1079')">
                                                <li>
                                                    <a href="#"  class="dash-nav" id="submenu-courses">
                                                        <i class="fa fa-pencil"></i>
                                                        <span class="nav-text">Curriculum</span>
                                                    </a>
                                                </li>
                                            </security:authorize>
                                            <security:authorize access="hasRole('1081') or hasRole('1082') or hasRole('1085') or hasRole('1086') or hasRole('1087') or hasRole('1089') or hasRole('1088')">

                                                <li>
                                                    <a href="#" class="dash-nav" id="submenu-class">                                          
                                                        <i class="fa fa-book"></i>
                                                        <span class="nav-text">Class</span>
                                                    </a> 
                                                </li>
                                            </security:authorize>
                                            <security:authorize access="hasRole('1090') or hasRole('1091')">   
                                                <li>
                                                    <a href="#"  class="dash-nav" id="submenu-timetable">
                                                        <i class="fa fa-table"></i>
                                                        <span class="nav-text">Timetable</span>
                                                    </a>

                                                </li> 
                                            </security:authorize>  
                                            <security:authorize access="hasRole('1110') or hasRole('1111')">
                                                <li>
                                                    <a href="#" class="dash-nav" id="submenu-attendance">
                                                        <i class="fa fa-check-square-o"></i>
                                                        <span class="nav-text">Attendance</span>
                                                    </a>
                                                </li>
                                            </security:authorize>
                                            <security:authorize access="hasRole('1134') or hasRole('1147') or hasRole('1148')">
                                                <li>
                                                    <a href="#" class="dash-nav" id="submenu-calender">                                          
                                                        <i class="fa fa-calendar"></i> 
                                                        <span class="nav-text">Calender</span>
                                                    </a> 
                                                </li>
                                            </security:authorize>
                                            <security:authorize access="hasRole('1153') or hasRole('1154')">
                                                <li>
                                                    <a href="#" class="dash-nav" id="submenu-lesson-planner" style="height:85px;">                                          
                                                        <i class="fa fa-pencil-square-o"></i>
                                                        <span class="nav-text">Curriculum / Lesson Planner</span>
                                                    </a> 
                                                </li> 
                                            </security:authorize>
                                            <security:authorize access="hasRole('1157') or hasRole('1158') or hasRole('1170') or hasRole('1171')">
                                                <li>
                                                    <a href="#" class="dash-nav" id="submenu-exam">                                          
                                                        <i class="fa fa-map-o"></i>
                                                        <span class="nav-text">Exam</span>
                                                    </a> 
                                                </li> 
                                            </security:authorize>
                                            <security:authorize access="hasRole('1179') or hasRole('1180') or hasRole('1184') or hasRole('1185')">
                                                <li>
                                                    <a href="#" class="dash-nav" id="submenu-assignment" style="height: 85px;">                                          
                                                        <i class="fa fa-map"></i>
                                                        <span class="nav-text">Homework/ Assignment</span>
                                                    </a> 
                                                </li> 
                                            </security:authorize>
                                            <security:authorize access="hasRole('1165') or hasRole('1166')">
                                                <li>
                                                    <a href="#" class="dash-nav" id="submenu-discipline">                                          
                                                        <i class="fa fa-exclamation-triangle"></i>
                                                        <span class="nav-text">Discipline</span>
                                                    </a> 
                                                </li> 
                                            </security:authorize>
                                            <security:authorize access="hasRole('1175') or hasRole('1176')">
                                                <li>
                                                    <a href="#" class="dash-nav" id="submenu-program-enquiry" style="height: 85px;">                                          
                                                        <i class="fa fa-envelope"></i>
                                                        <span class="nav-text">Student Enquiry</span>
                                                    </a> 
                                                </li> 
                                            </security:authorize>
                                            <security:authorize access="hasRole('1188')">
                                                <li>
                                                    <a href="#" class="dash-nav" id="submenu-import-enquiry" style="height: 85px;">                                          
                                                        <i class="fa fa-exchange"></i>
                                                        <span class="nav-text">Data Upload</span>
                                                    </a> 
                                                </li> 
                                            </security:authorize>

                                            <security:authorize access="hasRole('1193') or hasRole('1194')">
                                                <li>
                                                    <a href="#" class="dash-nav" id="submenu-import-payment">                                          
                                                        <i class="fa fa-money"></i>
                                                        <span class="nav-text">Payment</span>
                                                    </a> 
                                                </li> 
                                            </security:authorize>

                                            <security:authorize access="hasRole('1190') or hasRole('1191')">
                                                <li>
                                                    <a href="#" class="dash-nav" id="submenu-alert-nortifiction" style="height: 85px;">                                          
                                                        <i class="fa fa-lightbulb-o"></i>
                                                        <span class="nav-text">Alert Notification</span>
                                                    </a> 
                                                </li> 
                                            </security:authorize>

                                            <security:authorize access="hasRole('1197') or hasRole('1198') or hasRole('1199') or hasRole('1200') or hasRole('1201') or hasRole('1202')">
                                                <li>
                                                    <a href="#" class="dash-nav" id="submenu-reports">                                          
                                                        <i class="fa fa-file"></i>
                                                        <span class="nav-text">Reports</span>
                                                    </a> 
                                                </li> 
                                            </security:authorize>

                                            <security:authorize access="hasRole('1135') or hasRole('1136') or hasRole('1137') or hasRole('1140')">
                                                <li>
                                                    <a href="#" class="dash-nav" id="submenu-user" style="height:85px;">                                          
                                                        <i class="fa fa-user-plus"></i>
                                                        <span class="nav-text">User Management</span>
                                                    </a> 
                                                </li> 
                                            </security:authorize>

                                            <security:authorize access="hasRole('1119') or hasRole('1121') or hasRole('1122') or hasRole('1123') or hasRole('1125') or hasRole('1124') or hasRole('1126') or hasRole('1120')">
                                                <li>
                                                    <a href="#" class="dash-nav" id="submenu-commomn" style="height:85px;">                                          

                                                        <i class="fa fa-wrench"></i>
                                                        <span class="nav-text">Master Setup</span>
                                                    </a> 
                                                </li>
                                            </security:authorize>

                                            </ul>
                                            </div>
                                            <div class="col-xs-5 col-sm-4">                                           
                                                <security:authorize access="hasRole('1150')">
                                                    <div class="submenu submenu-my-event clearfix" id="">
                                                        <h4>My Event Calendar</h4>
                                                        <ul class="submenu-nav">
                                                            <security:authorize ifAnyGranted="1150">
                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/show-events" class="">

                                                                        <i class="fa fa-calendar-check-o"></i>
                                                                        <span class="nav-text">My Event Calendar</span>
                                                                    </a>
                                                                </li>
                                                            </security:authorize>


                                                        </ul>
                                                    </div>
                                                </security:authorize>
                                                <security:authorize access="hasRole('1151')">
                                                    <div class="submenu submenu-my-timetable clearfix" id="">
                                                        <h4>My Time Table</h4>
                                                        <ul class="submenu-nav">



                                                            <security:authorize ifAnyGranted="1151">
                                                                <c:choose>

                                                                    <c:when test="${usertype == 'Parent'}">


                                                                        <sec:authentication property="principal.parentGuardianId.studentList" var="parentStudents" />
                                                                        <c:forEach items="${parentStudents}" var="parentStudent">
                                                                            <li>
                                                                                <a href="${pageContext.request.contextPath}/admin/show-timetable?studentId=${parentStudent.studentId}" class="">

                                                                                    <i class="fa fa-bell"></i>
                                                                                    <span class="nav-text">${fn:substring(parentStudent.studentId, 0, 5)} - Time Table</span>
                                                                                </a>
                                                                            </li>


                                                                        </c:forEach>

                                                                    </c:when>
                                                                    <c:when test="${usertype != 'Parent'}">
                                                                        <li>
                                                                            <a href="${pageContext.request.contextPath}/admin/show-timetable" class="">

                                                                                <i class="fa fa-bell"></i>
                                                                                <span class="nav-text">My Time Table</span>
                                                                            </a>
                                                                        </li>
                                                                    </c:when>
                                                                </c:choose>

                                                            </security:authorize>







                                                        </ul>
                                                    </div>
                                                </security:authorize>
                                                <security:authorize access="hasRole('1163')">
                                                    <div class="submenu submenu-my-exam clearfix" id="">
                                                        <h4>My Exam</h4>
                                                        <ul class="submenu-nav">



                                                            <security:authorize ifAnyGranted="1163">
                                                                <c:choose>

                                                                    <c:when test="${usertype == 'Parent'}">


                                                                        <sec:authentication property="principal.parentGuardianId.studentList" var="parentStudents" />
                                                                        <c:forEach items="${parentStudents}" var="parentStudent">
                                                                            <li>
                                                                                <a href="${pageContext.request.contextPath}/admin/my-exam?studentId=${parentStudent.studentId}" class="">

                                                                                    <i class="fa fa-map-o"></i>
                                                                                    <span class="nav-text">${fn:substring(parentStudent.studentId, 0, 5)} - Exam</span>
                                                                                </a>
                                                                            </li>


                                                                        </c:forEach>

                                                                    </c:when>
                                                                    <c:when test="${usertype != 'Parent'}">
                                                                        <li>
                                                                            <a href="${pageContext.request.contextPath}/admin/my-exam" class="">

                                                                                <i class="fa fa-map-o"></i>
                                                                                <span class="nav-text">My Exam</span>
                                                                            </a>
                                                                        </li>
                                                                    </c:when>
                                                                </c:choose>

                                                            </security:authorize>
                                                        </ul>
                                                    </div>
                                                </security:authorize>


                                                <security:authorize access="hasRole('1183')">
                                                    <div class="submenu submenu-my-assignment clearfix" id="">
                                                        <h4>My Homework/Assignment</h4>
                                                        <ul class="submenu-nav">



                                                            <security:authorize ifAnyGranted="1183">
                                                                <c:choose>

                                                                    <c:when test="${usertype == 'Parent'}">


                                                                        <sec:authentication property="principal.parentGuardianId.studentList" var="parentStudents" />
                                                                        <c:forEach items="${parentStudents}" var="parentStudent">
                                                                            <li>
                                                                                <a href="${pageContext.request.contextPath}/admin/my-assignment?studentId=${parentStudent.studentId}" class="">

                                                                                    <i class="fa fa-map"></i>
                                                                                    <span class="nav-text">${fn:substring(parentStudent.studentId, 0, 5)} - Homework/Assignment</span>
                                                                                </a>
                                                                            </li>


                                                                        </c:forEach>

                                                                    </c:when>
                                                                    <c:when test="${usertype != 'Parent'}">
                                                                        <li>
                                                                            <a href="${pageContext.request.contextPath}/admin/my-assignment" class="">

                                                                                <i class="fa fa-map"></i>
                                                                                <span class="nav-text">My Homework/Assignment</span>
                                                                            </a>
                                                                        </li>
                                                                    </c:when>
                                                                </c:choose>

                                                            </security:authorize>
                                                        </ul>
                                                    </div>
                                                </security:authorize>

                                                <security:authorize access="hasRole('1173')">
                                                    <div class="submenu submenu-my-exam-submission clearfix" id="">
                                                        <h4>My Exam Submission</h4>
                                                        <ul class="submenu-nav">



                                                            <security:authorize ifAnyGranted="1173">
                                                                <c:choose>

                                                                    <c:when test="${usertype == 'Parent'}">


                                                                        <sec:authentication property="principal.parentGuardianId.studentList" var="parentStudents" />
                                                                        <c:forEach items="${parentStudents}" var="parentStudent">
                                                                            <li>
                                                                                <a href="${pageContext.request.contextPath}/admin/my-exam-submission?studentId=${parentStudent.studentId}" class="">

                                                                                    <i class="fa fa-map-o"></i>
                                                                                    <span class="nav-text">${fn:substring(parentStudent.studentId, 0, 5)} - Exam Submission</span>
                                                                                </a>
                                                                            </li>


                                                                        </c:forEach>

                                                                    </c:when>
                                                                    <c:when test="${usertype != 'Parent'}">
                                                                        <li>
                                                                            <a href="${pageContext.request.contextPath}/admin/my-exam-submission" class="">

                                                                                <i class="fa fa-map-o"></i>
                                                                                <span class="nav-text">My Marking Submission</span>
                                                                            </a>
                                                                        </li>
                                                                    </c:when>
                                                                </c:choose>

                                                            </security:authorize>
                                                        </ul>
                                                    </div>
                                                </security:authorize>
                                                <security:authorize access="hasRole('1187')">
                                                    <div class="submenu submenu-my-assignment-submission clearfix" id="">
                                                        <h4>My Home./ Assi. Submission</h4>
                                                        <ul class="submenu-nav">



                                                            <security:authorize ifAnyGranted="1187">
                                                                <c:choose>

                                                                    <c:when test="${usertype == 'Parent'}">


                                                                        <sec:authentication property="principal.parentGuardianId.studentList" var="parentStudents" />
                                                                        <c:forEach items="${parentStudents}" var="parentStudent">
                                                                            <li>
                                                                                <a href="${pageContext.request.contextPath}/admin/my-assignment-submission?studentId=${parentStudent.studentId}" class="">

                                                                                    <i class="fa fa-calendar-check-o"></i>
                                                                                    <span class="nav-text">${fn:substring(parentStudent.studentId, 0, 5)} - Home./ Assi. Submission</span>
                                                                                </a>
                                                                            </li>


                                                                        </c:forEach>

                                                                    </c:when>
                                                                    <c:when test="${usertype != 'Parent'}">
                                                                        <li>
                                                                            <a href="${pageContext.request.contextPath}/admin/my-assignment-submission" class="">

                                                                                <i class="fa fa-calendar-check-o"></i>
                                                                                <span class="nav-text">My Home./ Assi. Submission</span>
                                                                            </a>
                                                                        </li>
                                                                    </c:when>
                                                                </c:choose>

                                                            </security:authorize>
                                                        </ul>
                                                    </div>
                                                </security:authorize>
                                                <security:authorize access="hasRole('1169')">
                                                    <div class="submenu submenu-my-discipline clearfix" id="">
                                                        <h4>My Discipline</h4>
                                                        <ul class="submenu-nav">



                                                            <security:authorize ifAnyGranted="1169">
                                                                <c:choose>

                                                                    <c:when test="${usertype == 'Parent'}">


                                                                        <sec:authentication property="principal.parentGuardianId.studentList" var="parentStudents" />
                                                                        <c:forEach items="${parentStudents}" var="parentStudent">
                                                                            <li>
                                                                                <a href="${pageContext.request.contextPath}/admin/my-dicipline-records?studentId=${parentStudent.studentId}" class="">

                                                                                    <i class="fa fa-exclamation-circle"></i>
                                                                                    <span class="nav-text">${fn:substring(parentStudent.studentId, 0, 5)} - Discipline</span>
                                                                                </a>
                                                                            </li>


                                                                        </c:forEach>

                                                                    </c:when>
                                                                    <c:when test="${usertype != 'Parent'}">
                                                                        <li>
                                                                            <a href="${pageContext.request.contextPath}/admin/my-dicipline-records" class="">

                                                                                <i class="fa fa-exclamation-circle"></i>
                                                                                <span class="nav-text">My Discipline</span>
                                                                            </a>
                                                                        </li>
                                                                    </c:when>
                                                                </c:choose>

                                                            </security:authorize>
                                                        </ul>
                                                    </div>
                                                </security:authorize>
                                                <security:authorize access="hasRole('1164')">
                                                    <div class="submenu submenu-my-lesson-planner clearfix" id="">
                                                        <h4>My Curriculum / Lesson Planner</h4>
                                                        <ul class="submenu-nav">



                                                            <security:authorize ifAnyGranted="1164">
                                                                <c:choose>

                                                                    <c:when test="${usertype == 'Parent'}">


                                                                        <sec:authentication property="principal.parentGuardianId.studentList" var="parentStudents" />
                                                                        <c:forEach items="${parentStudents}" var="parentStudent">
                                                                            <li>
                                                                                <a href="${pageContext.request.contextPath}/admin/my-lesson-planner?studentId=${parentStudent.studentId}" class="">

                                                                                    <i class="fa fa-pencil-square-o"></i>
                                                                                    <span class="nav-text">${fn:substring(parentStudent.studentId, 0, 5)} - Lesson Planner</span>
                                                                                </a>
                                                                            </li>


                                                                        </c:forEach>

                                                                    </c:when>
                                                                    <c:when test="${usertype != 'Parent'}">
                                                                        <li>
                                                                            <a href="${pageContext.request.contextPath}/admin/my-lesson-planner" class="">

                                                                                <i class="fa fa-pencil-square-o"></i>
                                                                                <span class="nav-text">My Curriculum / Lesson Planner</span>
                                                                            </a>
                                                                        </li>
                                                                    </c:when>
                                                                </c:choose>


                                                            </security:authorize>
                                                        </ul>
                                                    </div>
                                                </security:authorize> 
                                                <security:authorize access="hasRole('1178')">
                                                    <div class="submenu submenu-my-attendance clearfix" id="">
                                                        <h4>My Attendance</h4>
                                                        <ul class="submenu-nav">
                                                            <c:choose>

                                                                <c:when test="${usertype == 'Parent'}">


                                                                    <sec:authentication property="principal.parentGuardianId.studentList" var="parentStudents" />
                                                                    <c:forEach items="${parentStudents}" var="parentStudent">
                                                                        <li>
                                                                            <a href="${pageContext.request.contextPath}/admin/my-attendance?studentId=${parentStudent.studentId}" class="">

                                                                                <i class="fa fa-check-square-o"></i>
                                                                                <span class="nav-text">${fn:substring(parentStudent.studentId, 0, 5)} -  Attendance</span>
                                                                            </a>
                                                                        </li>


                                                                    </c:forEach>

                                                                </c:when>
                                                                <c:when test="${usertype != 'Parent'}">
                                                                    <li>
                                                                        <a href="${pageContext.request.contextPath}/admin/my-attendance" class="">

                                                                            <i class="fa fa-check-square-o"></i>
                                                                            <span class="nav-text">My Attendance</span>
                                                                        </a>
                                                                    </li>
                                                                </c:when>
                                                            </c:choose>


                                                        </ul>
                                                    </div>
                                                </security:authorize> 
                                                <c:choose>
                                                    <c:when test="${usertype == 'Parent'}">
                                                        <security:authorize access="hasRole('1152')">
                                                            <div class="submenu submenu-my-children clearfix" id="">
                                                                <h4>My Children</h4>
                                                                <ul class="submenu-nav">

                                                                    <sec:authentication property="principal.parentGuardianId.studentList" var="parentStudents" />
                                                                    <c:forEach items="${parentStudents}" var="parentStudent">
                                                                        <li>
                                                                            <a href="${pageContext.request.contextPath}/admin/my-childs?studentId=${parentStudent.studentId}" class="">

                                                                                <i class="fa fa-street-view"></i>
                                                                                <span class="nav-text">${fn:substring(parentStudent.studentId, 0, 5)} - Profile</span>
                                                                            </a>
                                                                        </li>
                                                                    </c:forEach>
                                                                </ul>
                                                            </div>
                                                        </security:authorize>
                                                    </c:when>

                                                </c:choose>

                                                <security:authorize access="hasRole('1000') or hasRole('1010')">
                                                    <div class="submenu submenu-student clearfix" id="">
                                                        <h4>Student</h4>
                                                        <ul class="submenu-nav">
                                                            <security:authorize ifAnyGranted="1000">
                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/student-details-enrollment" class="">

                                                                        <i class="fa fa-graduation-cap"></i>
                                                                        <span class="nav-text">Add Student</span>
                                                                    </a>
                                                                </li>
                                                            </security:authorize>
                                                            <security:authorize ifAnyGranted="1010">
                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/student-details-search">

                                                                        <i class="fa fa-graduation-cap"></i>
                                                                        <span class="nav-text">Search Student</span>
                                                                    </a>
                                                                </li>
                                                            </security:authorize>

                                                        </ul>
                                                    </div>
                                                </security:authorize>
                                                <security:authorize access="hasRole('1057') or hasRole('1061') or hasRole('1065') or hasRole('1069') or hasRole('1077') or hasRole('1079')">
                                                    <div class="submenu submenu-courses clearfix" id="">
                                                        <h4>Curriculum</h4>
                                                        <ul class="submenu-nav">
                                                            <security:authorize ifAnyGranted="1057">
                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/course-add" class="">
                                                                        <i class="fa fa-pencil"></i>
                                                                        <span class="nav-text">Add Curriculum</span>

                                                                    </a>
                                                                </li>
                                                            </security:authorize>
                                                            <security:authorize ifAnyGranted="1061">
                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/level-add" class="">
                                                                        <i class="fa fa-pencil"></i>
                                                                        <span class="nav-text">Add Level</span>
                                                                    </a>
                                                                </li>
                                                            </security:authorize>
                                                            <security:authorize ifAnyGranted="1065">
                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/term-add" class="">
                                                                        <i class="fa fa-pencil"></i>
                                                                        <span class="nav-text">Add Term</span>
                                                                    </a>
                                                                </li>
                                                            </security:authorize>
                                                            <security:authorize ifAnyGranted="1069">
                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/subject-add" class="">
                                                                        <i class="fa fa-pencil"></i>
                                                                        <span class="nav-text">Add Subject</span>
                                                                    </a>
                                                                </li>
                                                            </security:authorize>
                                                            <security:authorize ifAnyGranted="1077">
                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/batch-add" class="">
                                                                        <i class="fa fa-pencil"></i>
                                                                        <span class="nav-text">Add Batch</span>
                                                                    </a>
                                                                </li>
                                                            </security:authorize>
                                                            <security:authorize ifAnyGranted="1079">
                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/batch-details-search" class="">
                                                                        <i class="fa fa-pencil"></i>
                                                                        <span class="nav-text">Search Batch</span>
                                                                    </a>
                                                                </li>
                                                            </security:authorize>

                                                        </ul>
                                                    </div>
                                                </security:authorize>
                                                    <div class="submenu submenu-group clearfix" id=""> 
                                                        <h4>Group</h4> 
                                                        <ul class="submenu-nav">
                                                           
                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/create-group" class=""> 
                                                                        <i class="fa fa-users"></i>
                                                                        <span class="nav-text">Add Group</span>
                                                                    </a> 
                                                                </li>
                                                      
                                                            
                                                                <li> 
                                                                    <a href="${pageContext.request.contextPath}/admin/search-group">
                                                                        <i class="fa fa-users"></i> 
                                                                        <span class="nav-text">Search Group</span> 

                                                                    </a> 
                                                                </li>                                                                                                                
                                                        </ul>
                                                    </div>
                                                <security:authorize access="hasRole('1081') or hasRole('1082') or hasRole('1085') or hasRole('1086') or hasRole('1087') or hasRole('1089') or hasRole('1088')">
                                                    <div class="submenu submenu-class clearfix" id=""> 
                                                        <h4>Class</h4> 
                                                        <ul class="submenu-nav">
                                                            <security:authorize ifAnyGranted="1081">
                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/student-class-enrollment" > 
                                                                        <i class="fa fa-book"></i>
                                                                        <span class="nav-text">Add Class</span>
                                                                    </a> 
                                                                </li>
                                                            </security:authorize>
                                                            <security:authorize ifAnyGranted="1082">
                                                                <li> 
                                                                    <a href="${pageContext.request.contextPath}/admin/class-details-search">
                                                                        <i class="fa fa-book"></i>
                                                                        <span class="nav-text">Search Class</span> 
                                                                    </a> 
                                                                </li> 
                                                            </security:authorize>
                                                            <security:authorize ifAnyGranted="1085">
                                                                <li> 
                                                                    <a href="${pageContext.request.contextPath}/admin/student-class-progression">
                                                                        <i class="fa fa-book"></i>
                                                                        <span class="nav-text">Class Prog & Ref</span> 
                                                                    </a> 
                                                                </li> 
                                                            </security:authorize>
                                                            <security:authorize ifAnyGranted="1086">
                                                                <li> 
                                                                    <a href="${pageContext.request.contextPath}/admin/student-class-transfer">
                                                                        <i class="fa fa-book"></i>
                                                                        <span class="nav-text">Class Transfer</span> 
                                                                    </a> 
                                                                </li> 
                                                            </security:authorize>
                                                            <security:authorize ifAnyGranted="1087">
                                                                <li> 
                                                                    <a href="${pageContext.request.contextPath}/admin/student-class-demote-transfer">
                                                                        <i class="fa fa-book"></i>
                                                                        <span class="nav-text">Class Demote Transfer</span> 
                                                                    </a> 
                                                                </li> 
                                                            </security:authorize>
                                                            <security:authorize ifAnyGranted="1089">
                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/student-course-transfer">
                                                                        <i class="fa fa-book"></i> 
                                                                        <span class="nav-text">Class Curriculum Transfer</span>
                                                                    </a>
                                                                </li>
                                                            </security:authorize>
                                                            <security:authorize ifAnyGranted="1088">
                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/new-student-class-enrollment">
                                                                        <i class="fa fa-book"></i>
                                                                        <span class="nav-text">Class Enrollment</span> 
                                                                    </a> 
                                                                </li>
                                                            </security:authorize>
                                                        </ul>                               
                                                    </div> 
                                                </security:authorize>
                                                <security:authorize access="hasRole('1090') or hasRole('1091')">
                                                    <div class="submenu submenu-timetable clearfix" id="">
                                                        <h4>Timetable</h4> 
                                                        <ul class="submenu-nav">
                                                            <security:authorize ifAnyGranted="1090">
                                                                <li> 
                                                                    <a href="${pageContext.request.contextPath}/admin/create-timetable">
                                                                        <i class="fa fa-table"></i>
                                                                        <span class="nav-text">Add Timetable</span>
                                                                    </a>
                                                                </li>
                                                            </security:authorize>
                                                            <security:authorize ifAnyGranted="1091">
                                                                <li> 
                                                                    <a href="${pageContext.request.contextPath}/admin/timetable-details-search">
                                                                        <i class="fa fa-table"></i>
                                                                        <span class="nav-text">Search Timetable</span> 
                                                                    </a> 
                                                                </li> 
                                                            </security:authorize>
                                                        </ul>
                                                    </div>
                                                </security:authorize>
                                                <security:authorize access="hasRole('1110') or hasRole('1111') or hasRole('1204')">
                                                    <div class="submenu submenu-attendance clearfix" id="">
                                                        <h4>Attendance</h4>
                                                        <ul class="submenu-nav">
                                                            <security:authorize ifAnyGranted="1110">
                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/student-mark-attendance" class="">
                                                                        <i class="fa fa-check-square-o"></i>
                                                                        <span class="nav-text">Mark Attendance</span>
                                                                    </a>
                                                                </li>
                                                            </security:authorize>
                                                            <security:authorize ifAnyGranted="1204">
                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/student-view-edit-attendance" class="">
                                                                        <i class="fa fa-check-square-o"></i>
                                                                        <span class="nav-text">View/Edit Attendance</span>
                                                                    </a>
                                                                </li>
                                                            </security:authorize>
                                                            <security:authorize ifAnyGranted="1111">
                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/search-attendance" class="">
                                                                        <i class="fa fa-check-square-o"></i>
                                                                        <span class="nav-text">Search Attendance</span>
                                                                    </a>
                                                                </li>
                                                            </security:authorize>
                                                        </ul>

                                                    </div>
                                                </security:authorize>
                                                <security:authorize access="hasRole('1134') or hasRole('1147') or hasRole('1148')">
                                                    <div class="submenu submenu-calender clearfix" id=""> 
                                                        <h4>Calender Management</h4> 

                                                        <security:authorize ifAnyGranted="1134">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/create-school-event">
                                                                        <i class="fa fa-calendar"></i>
                                                                        <span class="nav-text">Create School Events</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>
                                                        <security:authorize ifAnyGranted="1147">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/search-school-event">
                                                                        <i class="fa fa-calendar"></i>
                                                                        <span class="nav-text">Search School Events</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>

                                                        <security:authorize ifAnyGranted="1148">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/create-school-holidays">
                                                                        <i class="fa fa-calendar"></i>
                                                                        <span class="nav-text">Define School Holidays</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>

                                                    </div> 
                                                </security:authorize>

                                                <security:authorize access="hasRole('1153') or hasRole('1154')">
                                                    <div class="submenu submenu-lesson-planner clearfix" id=""> 
                                                        <h4>Curriculum / Lesson Planner</h4> 

                                                        <security:authorize ifAnyGranted="1153">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/create-weekly-lesson-planner">
                                                                        <i class="fa fa-pencil-square-o"></i>
                                                                        <span class="nav-text">Create Curriculum / Lesson Planner</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>
                                                        <security:authorize ifAnyGranted="1154">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/search-lesson-planner">
                                                                        <i class="fa fa-pencil-square-o"></i>
                                                                        <span class="nav-text">Search Curriculum / Lesson Planner</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>



                                                    </div> 
                                                </security:authorize> 

                                                <security:authorize access="hasRole('1157') or hasRole('1158') or hasRole('1170') or hasRole('1171')">
                                                    <div class="submenu submenu-exam clearfix" id=""> 
                                                        <h4>Exam</h4> 

                                                        <security:authorize ifAnyGranted="1157">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/create-exam">
                                                                        <i class="fa fa-map-o"></i>
                                                                        <span class="nav-text">Create Exam</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>
                                                        <security:authorize ifAnyGranted="1158">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/search-exam">
                                                                        <i class="fa fa-map-o"></i>
                                                                        <span class="nav-text">Search Exam</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>
                                                        <security:authorize ifAnyGranted="1170">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/create-exam-submission">
                                                                        <i class="fa fa-map-o"></i>
                                                                        <span class="nav-text">Create Marking Submission</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>
                                                        <security:authorize ifAnyGranted="1171">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/search-exam-submission">
                                                                        <i class="fa fa-map-o"></i>
                                                                        <span class="nav-text">Search Marking Submission</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>



                                                    </div> 
                                                </security:authorize>

                                                <security:authorize access="hasRole('1179') or hasRole('1180') or hasRole('1184') or hasRole('1185')">
                                                    <div class="submenu submenu-assignment clearfix" id=""> 
                                                        <h4>Homework/Assignment</h4> 

                                                        <security:authorize ifAnyGranted="1179">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/create-assignment">
                                                                        <i class="fa fa-map"></i>
                                                                        <span class="nav-text">Create Homework/Assignment</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>
                                                        <security:authorize ifAnyGranted="1180">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/search-assignment">
                                                                        <i class="fa fa-map"></i>
                                                                        <span class="nav-text">Search Homework/Assignment</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>
                                                        <security:authorize ifAnyGranted="1184">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/assignment-submission">
                                                                        <i class="fa fa-map"></i>
                                                                        <span class="nav-text">Create Homework/Assignment Submission</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>
                                                        <security:authorize ifAnyGranted="1185">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/assignment-submission-search">
                                                                        <i class="fa fa-map"></i>
                                                                        <span class="nav-text">Search Homework/Assignment Submission</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>



                                                    </div> 
                                                </security:authorize>


                                                <security:authorize access="hasRole('1165') or hasRole('1166')">
                                                    <div class="submenu submenu-discipline clearfix" id=""> 
                                                        <h4>Discipline</h4> 

                                                        <security:authorize ifAnyGranted="1165">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/create-discipline-records">
                                                                        <i class="fa fa-exclamation-triangle"></i>
                                                                        <span class="nav-text">Create Discipline</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>
                                                        <security:authorize ifAnyGranted="1166">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/search-discipline-records">
                                                                        <i class="fa fa-exclamation-triangle"></i>
                                                                        <span class="nav-text">Search Discipline</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>



                                                    </div> 
                                                </security:authorize>


                                                <security:authorize access="hasRole('1175') or hasRole('1176')">
                                                    <div class="submenu submenu-program-enquiry clearfix" id=""> 
                                                        <h4>Student Enquiry</h4> 

                                                        <security:authorize ifAnyGranted="1175">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/program-enquiries">
                                                                        <i class="fa fa-envelope"></i>
                                                                        <span class="nav-text">Create Student Enquiry</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>
                                                        <security:authorize ifAnyGranted="1176">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/program-enquiries-search">
                                                                        <i class="fa fa-envelope"></i>
                                                                        <span class="nav-text">Search Student Enquiry</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>



                                                    </div> 
                                                </security:authorize>
                                                <security:authorize access="hasRole('1188')">
                                                    <div class="submenu submenu-import-enquiry clearfix" id=""> 
                                                        <h4>Data Upload</h4> 

                                                        <security:authorize ifAnyGranted="1188">
                                                            <ul class="submenu-nav">
                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/import-export-student-records">
                                                                        <i class="fa fa-exchange"></i>
                                                                        <span class="nav-text">Student Data Upload</span>
                                                                    </a>
                                                                </li>
                                                            </ul>
                                                        </security:authorize>

                                                        <!--<security:authorize ifAnyGranted="1188">-->
                                                            <ul class="submenu-nav">
                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/import-export-parent-records">
                                                                        <i class="fa fa-exchange"></i>
                                                                        <span class="nav-text">Parent Data Upload</span>
                                                                    </a>
                                                                </li>
                                                            </ul>
                                                            <!--</security:authorize>-->

                                                            <!-- <security:authorize ifAnyGranted="1188">-->
                                                            <ul class="submenu-nav">
                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/import-export-employee-records">
                                                                        <i class="fa fa-exchange"></i>
                                                                        <span class="nav-text">Employee Data Upload</span>
                                                                    </a>
                                                                </li>
                                                            </ul>
                                                            <!--</security:authorize>-->

                                                        </div> 
                                                </security:authorize>
                                                <security:authorize access="hasRole('1193') or hasRole('1194')">
                                                    <div class="submenu submenu-import-payment clearfix" id=""> 
                                                        <h4>Payment</h4> 

                                                        <security:authorize ifAnyGranted="1193">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/import-export-student-payment-records">
                                                                        <i class="fa fa-money"></i>
                                                                        <span class="nav-text">Payment Data Upload</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>
                                                        <security:authorize ifAnyGranted="1194">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/student-payment-search">
                                                                        <i class="fa fa-money"></i>
                                                                        <span class="nav-text">Payment Search</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>


                                                    </div> 
                                                </security:authorize>
                                                <security:authorize access="hasRole('1190') or hasRole('1191')">
                                                    <div class="submenu submenu-alert-nortifiction clearfix" id=""> 
                                                        <h4>Alert Notification</h4> 

                                                        <security:authorize ifAnyGranted="1190">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/create-alert">
                                                                        <i class="fa fa-lightbulb-o"></i>
                                                                        <span class="nav-text">Create Alert</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>
                                                        <security:authorize ifAnyGranted="1191">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/search-alert">
                                                                        <i class="fa fa-lightbulb-o"></i>
                                                                        <span class="nav-text">Search Alert</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>


                                                    </div> 
                                                </security:authorize>



                                                <security:authorize access="hasRole('1135') or hasRole('1136') or hasRole('1137') or hasRole('1140')">
                                                    <div class="submenu submenu-user clearfix" id=""> 
                                                        <h4>User Management</h4>

                                                        <security:authorize ifAnyGranted="1140">
                                                            <ul class="submenu-nav">
                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/search-registered-users">
                                                                        <i class="fa fa-user-plus"></i>
                                                                        <span class="nav-text">Manage Users</span>
                                                                    </a>
                                                                </li>
                                                            </ul>
                                                        </security:authorize>

                                                        <security:authorize ifAnyGranted="1135">
                                                            <ul class="submenu-nav">
                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/create-user-category">
                                                                        <i class="fa fa-user-plus"></i>
                                                                        <span class="nav-text">User Category</span>
                                                                    </a>
                                                                </li>
                                                            </ul>
                                                        </security:authorize>
                                                        <security:authorize ifAnyGranted="1136">
                                                            <ul class="submenu-nav">
                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/create-role">
                                                                        <i class="fa fa-user-plus"></i>
                                                                        <span class="nav-text">Add User Role</span>
                                                                    </a>
                                                                </li>
                                                            </ul>
                                                        </security:authorize>
                                                        <security:authorize ifAnyGranted="1137">
                                                            <ul class="submenu-nav">
                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/search-role">
                                                                        <i class="fa fa-user-plus"></i>
                                                                        <span class="nav-text">Search User Roles</span>
                                                                    </a>
                                                                </li>
                                                            </ul>
                                                        </security:authorize>


                                                    </div>
                                                </security:authorize>

                                                <security:authorize access="hasRole('1119') or hasRole('1121') or hasRole('1122') or hasRole('1123') or hasRole('1125') or hasRole('1124') or hasRole('1126') or hasRole('1120')  or hasRole('1161')  or hasRole('1162') or hasRole('1174') or hasRole('1189')">

                                                    <div class="submenu submenu-commomn clearfix" id=""> 
                                                        <h4>Common Master Setup</h4> 
                                                        <security:authorize access="hasRole('1119') or hasRole('1121') or hasRole('1120')">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/create-country">
                                                                        <i class="fa fa-wrench"></i>
                                                                        <span class="nav-text">Region</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>
                                                        <security:authorize access="hasRole('1122') or hasRole('1123') or hasRole('1125') or hasRole('1124')">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/create-institute">
                                                                        <i class="fa fa-wrench"></i>
                                                                        <span class="nav-text">Education</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>
                                                        <security:authorize access="hasRole('1126')">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/create-batch-category">
                                                                        <i class="fa fa-wrench"></i>
                                                                        <span class="nav-text">Curriculum</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>
                                                        <security:authorize access="hasRole('1161')">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/create-exam-type">
                                                                        <i class="fa fa-wrench"></i>
                                                                        <span class="nav-text">Exam Type</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>
                                                        <security:authorize access="hasRole('1174')">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/create-exam-mark-scale">
                                                                        <i class="fa fa-wrench"></i>
                                                                        <span class="nav-text">Exam Mark Scale</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>
                                                        <security:authorize access="hasRole('1189')">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/create-assignment-type">
                                                                        <i class="fa fa-wrench"></i>
                                                                        <span class="nav-text">Assignment Type</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>
                                                        <security:authorize access="hasRole('1162')">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/create-class-room">
                                                                        <i class="fa fa-wrench"></i>
                                                                        <span class="nav-text">Class Room</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>
                                                    </div>                

                                                </security:authorize>         
                                                <security:authorize access="hasRole('1197') or hasRole('1198') or hasRole('1199') or hasRole('1200') or hasRole('1201') or hasRole('1202')">

                                                    <div class="submenu submenu-reports clearfix" id=""> 
                                                        <h4>Reports</h4> 
                                                        <security:authorize access="hasRole('1197')">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/reception-report">
                                                                        <i class="fa fa-file"></i>
                                                                        <span class="nav-text">Reception Report</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>
                                                        <security:authorize access="hasRole('1198')">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/nursery-final-report">
                                                                        <i class="fa fa-file"></i>
                                                                        <span class="nav-text">Nursery Final Report</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>
                                                        <security:authorize access="hasRole('1199')">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/year-final-report">
                                                                        <i class="fa  fa-file"></i>
                                                                        <span class="nav-text">Year 1 to 2 Report</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>
                                                        <security:authorize access="hasRole('1200')">
                                                            <ul class="submenu-nav">

                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/year-final-report-3-6">
                                                                        <i class="fa fa-file"></i>
                                                                        <span class="nav-text">Year 3 to 6 Report</span>
                                                                    </a>
                                                                </li>

                                                            </ul>
                                                        </security:authorize>
                                                        <security:authorize access="hasRole('1201')">
                                                            <ul class="submenu-nav">
                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/eal-report-1-6">
                                                                        <i class="fa fa-file"></i>
                                                                        <span class="nav-text">EAL Report 1 to 6</span>
                                                                    </a>
                                                                </li>
                                                            </ul>
                                                        </security:authorize>
                                                        <security:authorize access="hasRole('1202')">
                                                            <ul class="submenu-nav">
                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/eal-report-7-13">
                                                                        <i class="fa fa-file"></i>
                                                                        <span class="nav-text">EAL Report 7 to 13</span>
                                                                    </a>
                                                                </li>
                                                            </ul>
                                                        </security:authorize>
                                                        <security:authorize access="hasRole('1203')">
                                                            <ul class="submenu-nav">
                                                                <li>
                                                                    <a href="${pageContext.request.contextPath}/admin/secondary-report">
                                                                        <i class="fa fa-file"></i>
                                                                        <span class="nav-text">Secondary Report</span>
                                                                    </a>
                                                                </li>
                                                            </ul>
                                                        </security:authorize>
                                                    </div>                

                                                </security:authorize>    
                                            </div>
                                            </div>


                                            </div>
                                            <!-- ############# /CONTENT ############# -->



                                            <!-- ############# FOOTER ############# -->
                                            </div>
                                            </div>
                                            <div class="footer">



                                                <p>&#169; 2017, The First Credit. All rights reserved.</p>  
                                            </div>
                                            </div>
                                            <!-- ############# FOOTER ############# -->

                                            </body>
                                            </html>
