<!-- ############# LEFT NAVIGATION ############# -->
<sec:authentication property="principal.userType" var="usertype" />
<div class="row">
    <div id="leftbar" class="col-sm-1 col-md-1 col-lg-2" style="background-color: #F7F7F7">

        <div class="row">
            <div class="col-sm-1 col-md-1 col-lg-2">
                <div class="wr-logo" style="text-align:center;padding-top: 5px;padding-left: 50px;">
                    <a href="${pageContext.request.contextPath}/admin/dashboard">
                        <img id="" src="${pageContext.servletContext.contextPath}/resources/images/logo_2.png" />
                    </a>
                </div>  
            </div>
        </div>

        <div class="row">
            <div class="col-sm-12">
                <div class="user-login">
                    <c:choose>
                        <c:when test="${usertype == 'Student'}">
                            <a href="${pageContext.request.contextPath}/admin/my-profilest">
                        </c:when>
                        <c:when test="${usertype == 'Employee'}">
                            <a href="${pageContext.request.contextPath}/admin/my-profileem">
                        </c:when>
                        <c:when test="${usertype == 'Parent'}">

                            <a href="${pageContext.request.contextPath}/admin/my-profilepr">

                        </c:when>
                    </c:choose>





                    <sec:authentication property="principal.imagePath" var="imagePath" />
                    <c:choose>
                        <c:when test="${imagePath != ''}">

                            <img id="usernamePic" style="width: 43px;height: 43px;" src="${pageContext.servletContext.contextPath}${imagePath}" />
                        </c:when>
                        <c:when test="${imagePath == ''}">
                            <img id="usernamePic" style="width: 43px;height: 43px;" src="${pageContext.servletContext.contextPath}/resources/images/profile_default.png" />
                        </c:when>

                    </c:choose>
                    </a>
                </div>  
            </div>
        </div> 
        <div class="row" id="welcome">
            <div class="col-sm-12"> 
                <p style="text-align:center;font-size: 14px;margin-top: 10px;margin-left: -8px;">Welcome  

                <c:choose>
                    <c:when test="${usertype == 'Student'}">
                        <sec:authentication
                            property="principal.studentId.firstName" />
                        <sec:authentication
                            property="principal.studentId.lastName" />
                    </c:when>
                    <c:when test="${usertype == 'Employee'}">
                        <sec:authentication
                            property="principal.employeeId.firstName" />
                        <sec:authentication
                            property="principal.employeeId.lastName" />
                    </c:when>
                    <c:when test="${usertype == 'Parent'}">
                        <sec:authentication
                            property="principal.parentGuardianId.name" />
                    </c:when>
                </c:choose>


                !</p>
            </div>
        </div>

        <div class="leftnav">
            <div class="sidebar-nav">
                <div class="navbar navbar-default" role="navigation">

                    <div class="navbar-collapse sidebar-navbar-collapse cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left">
                        <ul class="nav navbar-nav">
                            <li>
                                <a href="${pageContext.request.contextPath}/admin/dashboard">
                                    <span class="nav-icon"><i class="fa fa-dashboard"></i></span><span class="nav-text">Dashboard</span>
                                </a>
                            </li>
                            <li id="my-profile" class="side">
                            <c:choose>
                                <c:when test="${usertype == 'Student'}">
                                    <a href="${pageContext.request.contextPath}/admin/my-profilest">
                                </c:when>
                                <c:when test="${usertype == 'Employee'}">
                                    <a href="${pageContext.request.contextPath}/admin/my-profileem">
                                </c:when>
                                <c:when test="${usertype == 'Parent'}">

                                    <a href="${pageContext.request.contextPath}/admin/my-profilepr">

                                </c:when>
                            </c:choose>
                            <span class="nav-icon"><i class="fa fa-info"></i></span><span class="nav-text">My Profile</span>
                            </a>
                            </li>
                            <c:choose>

                                <c:when test="${usertype == 'Parent'}">
                                    <security:authorize access="hasRole('1152')">
                                        <li id="my-children-menu" class="side">
                                            <a href="#">
                                                <span class="nav-icon"><i class="fa fa-street-view"></i></span><span class="nav-text">My Children</span>
                                            </a>
                                            <ul>




                                                <sec:authentication property="principal.parentGuardianId.studentList" var="parentStudents" />
                                                <c:forEach items="${parentStudents}" var="parentStudent">

                                                    <li>
                                                        <a href="${pageContext.request.contextPath}/admin/my-childs?studentId=${parentStudent.studentId}">
                                                            ${fn:substring(parentStudent.studentId, 0, 6)}-Profile
                                                        </a>
                                                    </li>
                                                </c:forEach>






                                            </ul>
                                        </li>
                                    </security:authorize>
                                </c:when>

                            </c:choose>

                            <security:authorize access="hasRole('1150')"> 
                                <li id="my-event-menu" class="side">
                                    <a href="#">
                                        <span class="nav-icon"><i class="fa fa-calendar-check-o"></i></span><span class="nav-text">My Event Calendar</span>
                                    </a>
                                    <ul>
                                        <security:authorize ifAnyGranted="1150">
                                            <li><a href="${pageContext.request.contextPath}/admin/show-events">My Event Calendar</a></li>
                                        </security:authorize>

                                    </ul>
                                </li>
                            </security:authorize>
                            <security:authorize access="hasRole('1151')"> 
                                <li id="my-timetable-menu" class="side">
                                    <a href="#">
                                        <span class="nav-icon"><i class="fa fa-bell"></i></span><span class="nav-text">My Time Tables</span>
                                    </a>
                                    <ul>

                                        <c:choose>

                                            <c:when test="${usertype == 'Parent'}">


                                                <sec:authentication property="principal.parentGuardianId.studentList" var="parentStudents" />
                                                <c:forEach items="${parentStudents}" var="parentStudent">

                                                    <li>
                                                        <a href="${pageContext.request.contextPath}/admin/show-timetable?studentId=${parentStudent.studentId}">
                                                            ${fn:substring(parentStudent.studentId, 0, 6)}- Time Table
                                                        </a>
                                                    </li>
                                                </c:forEach>


                                            </c:when>
                                            <c:when test="${usertype != 'Parent'}">
                                                <li><a href="${pageContext.request.contextPath}/admin/show-timetable">My Time Table</a></li>
                                            </c:when>
                                        </c:choose>



                                    </ul>
                                </li>
                            </security:authorize>
                            <security:authorize access="hasRole('1163')"> 
                                <li id="my-exam-menu" class="side">
                                    <a href="#">
                                        <span class="nav-icon"><i class="fa fa-map-o"></i></span><span class="nav-text">My Exam</span>
                                    </a>
                                    <ul>

                                        <c:choose>

                                            <c:when test="${usertype == 'Parent'}">


                                                <sec:authentication property="principal.parentGuardianId.studentList" var="parentStudents" />
                                                <c:forEach items="${parentStudents}" var="parentStudent">

                                                    <li>
                                                        <a href="${pageContext.request.contextPath}/admin/my-exam?studentId=${parentStudent.studentId}">
                                                            ${fn:substring(parentStudent.studentId, 0, 6)}- Exam
                                                        </a>
                                                    </li>
                                                </c:forEach>


                                            </c:when>
                                            <c:when test="${usertype != 'Parent'}">
                                                <li><a href="${pageContext.request.contextPath}/admin/my-exam">My Exam</a></li>
                                            </c:when>
                                        </c:choose>



                                    </ul>
                                </li>
                            </security:authorize>
                            <security:authorize access="hasRole('1183')"> 
                                <li id="my-assignment-menu" class="side">
                                    <a href="#">
                                        <span class="nav-icon"><i class="fa fa-map"></i></span><span class="nav-text">My Homework/ Assignment</span>
                                    </a>
                                    <ul>

                                        <c:choose>

                                            <c:when test="${usertype == 'Parent'}">


                                                <sec:authentication property="principal.parentGuardianId.studentList" var="parentStudents" />
                                                <c:forEach items="${parentStudents}" var="parentStudent">

                                                    <li>
                                                        <a href="${pageContext.request.contextPath}/admin/my-assignment?studentId=${parentStudent.studentId}">
                                                            ${fn:substring(parentStudent.studentId, 0, 6)}- Homework/ Assignment
                                                        </a>
                                                    </li>
                                                </c:forEach>


                                            </c:when>
                                            <c:when test="${usertype != 'Parent'}">
                                                <li><a href="${pageContext.request.contextPath}/admin/my-assignment">My Homework/ Assignment</a></li>
                                            </c:when>
                                        </c:choose>



                                    </ul>
                                </li>
                            </security:authorize>                

                            <security:authorize access="hasRole('1173')"> 
                                <li id="my-exam-submission-menu" class="side">
                                    <a href="#">
                                        <span class="nav-icon"><i class="fa fa-map-o"></i></span><span class="nav-text">My Exam Submission</span>
                                    </a>
                                    <ul>

                                        <c:choose>

                                            <c:when test="${usertype == 'Parent'}">


                                                <sec:authentication property="principal.parentGuardianId.studentList" var="parentStudents" />
                                                <c:forEach items="${parentStudents}" var="parentStudent">

                                                    <li>
                                                        <a href="${pageContext.request.contextPath}/admin/my-exam-submission?studentId=${parentStudent.studentId}">
                                                            ${fn:substring(parentStudent.studentId, 0, 6)}- Exam Submission
                                                        </a>
                                                    </li>
                                                </c:forEach>


                                            </c:when>
                                            <c:when test="${usertype != 'Parent'}">
                                                <li><a href="${pageContext.request.contextPath}/admin/my-exam-submission">My Exam Submission</a></li>
                                            </c:when>
                                        </c:choose>



                                    </ul>
                                </li>
                            </security:authorize> 

                            <security:authorize access="hasRole('1187')"> 
                                <li id="my-assignment-submission-menu" class="side">
                                    <a href="#">
                                        <span class="nav-icon"><i class="fa fa-calendar-check-o"></i></span><span class="nav-text">My Home./ Assi. Submission</span>
                                    </a>
                                    <ul>

                                        <c:choose>

                                            <c:when test="${usertype == 'Parent'}">


                                                <sec:authentication property="principal.parentGuardianId.studentList" var="parentStudents" />
                                                <c:forEach items="${parentStudents}" var="parentStudent">

                                                    <li>
                                                        <a href="${pageContext.request.contextPath}/admin/my-assignment-submission?studentId=${parentStudent.studentId}">
                                                            ${fn:substring(parentStudent.studentId, 0, 6)}- Home./ Assi. Submission
                                                        </a>
                                                    </li>
                                                </c:forEach>


                                            </c:when>
                                            <c:when test="${usertype != 'Parent'}">
                                                <li><a href="${pageContext.request.contextPath}/admin/my-assignment-submission">My Home./ Assi. Submission</a></li>
                                            </c:when>
                                        </c:choose>



                                    </ul>
                                </li>
                            </security:authorize>                

                            <security:authorize access="hasRole('1169')"> 
                                <li id="my-discipline-menu" class="side">
                                    <a href="#">
                                        <span class="nav-icon"><i class="fa fa-exclamation-circle"></i></span><span class="nav-text">My Discipline</span>
                                    </a>
                                    <ul>

                                        <c:choose>

                                            <c:when test="${usertype == 'Parent'}">


                                                <sec:authentication property="principal.parentGuardianId.studentList" var="parentStudents" />
                                                <c:forEach items="${parentStudents}" var="parentStudent">

                                                    <li>
                                                        <a href="${pageContext.request.contextPath}/admin/my-dicipline-records?studentId=${parentStudent.studentId}">
                                                            ${fn:substring(parentStudent.studentId, 0, 6)}- Discipline
                                                        </a>
                                                    </li>
                                                </c:forEach>


                                            </c:when>
                                            <c:when test="${usertype != 'Parent'}">
                                                <li><a href="${pageContext.request.contextPath}/admin/my-dicipline-records">My Discipline</a></li>
                                            </c:when>
                                        </c:choose>



                                    </ul>
                                </li>
                            </security:authorize>


                            <security:authorize access="hasRole('1164')"> 
                                <li id="my-lesson-planner-menu" class="side">
                                    <a href="#">
                                        <span class="nav-icon"><i class="fa fa-pencil-square-o"></i></span><span class="nav-text">My Curriculum / Lesson Planner</span>
                                    </a>
                                    <ul>

                                        <c:choose>

                                            <c:when test="${usertype == 'Parent'}">
                                                <sec:authentication property="principal.parentGuardianId.studentList" var="parentStudents" />
                                                <c:forEach items="${parentStudents}" var="parentStudent">

                                                    <li>
                                                        <a href="${pageContext.request.contextPath}/admin/my-lesson-planner?studentId=${parentStudent.studentId}">
                                                            ${fn:substring(parentStudent.studentId, 0, 6)}- Lesson Planner
                                                        </a>
                                                    </li>
                                                </c:forEach>


                                            </c:when>
                                            <c:when test="${usertype != 'Parent'}">
                                                <li><a href="${pageContext.request.contextPath}/admin/my-lesson-planner">My Curriculum / Lesson Planner</a></li>
                                            </c:when>
                                        </c:choose>
                                    </ul>
                                </li>
                            </security:authorize>

                            <security:authorize access="hasRole('1178')"> 
                                <li id="my-attendence-menu" class="side">
                                    <a href="#">
                                        <span class="nav-icon"><i class="fa fa-check-square-o"></i></span><span class="nav-text">My Attendance</span>
                                    </a>
                                    <ul>

                                        <c:choose>

                                            <c:when test="${usertype == 'Parent'}">
                                                <sec:authentication property="principal.parentGuardianId.studentList" var="parentStudents" />
                                                <c:forEach items="${parentStudents}" var="parentStudent">

                                                    <li>
                                                        <a href="${pageContext.request.contextPath}/admin/my-attendance?studentId=${parentStudent.studentId}">
                                                            ${fn:substring(parentStudent.studentId, 0, 6)}- Attendance
                                                        </a>
                                                    </li>
                                                </c:forEach>


                                            </c:when>
                                            <c:when test="${usertype != 'Parent'}">
                                                <li><a href="${pageContext.request.contextPath}/admin/my-attendance">My Attendance</a></li>
                                            </c:when>
                                        </c:choose>
                                    </ul>
                                </li>
                            </security:authorize>                


                            <security:authorize access="hasRole('1000') or hasRole('1010')"> 
                                <li id="student-menu" class="side">
                                    <a href="#">
                                        <span class="nav-icon"><i class="fa fa-graduation-cap"></i></span><span class="nav-text">Student</span>
                                    </a>
                                    <ul>
                                        <security:authorize ifAnyGranted="1000">
                                            <li><a href="${pageContext.request.contextPath}/admin/student-details-enrollment">Add Student</a></li>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="1010">
                                            <li><a href="${pageContext.request.contextPath}/admin/student-details-search">Search Student</a></li>
                                        </security:authorize>
                                    </ul>
                                </li>
                            </security:authorize>
                           

                                <li id="employee-menu" class="side">
                                    <a href="#"> 
                                        <span class="nav-icon"><i class="fa fa-user"></i></span><span class="nav-text">Group</span>
                                    </a> 
                                    <ul>                           
                                            <li><a href="${pageContext.request.contextPath}/admin/create-group">Add Group</a></li>
                                                                        
                                            <li><a href="${pageContext.request.contextPath}/admin/search-group">Search Group</a></li>
                                        
                                    </ul> 
                                </li>
                            <security:authorize access="hasRole('1057') or hasRole('1061') or hasRole('1065') or hasRole('1069') or hasRole('1077') or hasRole('1079')">

                                <li id="program-menu" class="side">
                                    <a href="#">
                                        <span class="nav-icon"><i class="fa fa-pencil"></i></span><span class="nav-text">Curriculum</span>
                                    </a>
                                    <ul>
                                        <security:authorize ifAnyGranted="1057">
                                            <li><a href="${pageContext.request.contextPath}/admin/course-add">Add Curriculum</a></li>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="1061">
                                            <li><a href="${pageContext.request.contextPath}/admin/level-add">Add Level</a></li>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="1065">
                                            <li><a href="${pageContext.request.contextPath}/admin/term-add">Add Term</a></li>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="1069">
                                            <li><a href="${pageContext.request.contextPath}/admin/subject-add">Add Subject</a></li>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="1077">
                                            <li><a href="${pageContext.request.contextPath}/admin/batch-add">Add Batch</a></li>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="1079">
                                            <li><a href="${pageContext.request.contextPath}/admin/batch-details-search">Search Batch</a></li>
                                        </security:authorize>


                                    </ul>
                                </li>
                            </security:authorize>
                            <security:authorize access="hasRole('1081') or hasRole('1082') or hasRole('1085') or hasRole('1086') or hasRole('1087') or hasRole('1089') or hasRole('1088')">
                                <li id="class-menu" class="side"> 
                                    <a href="#">
                                        <span class="nav-icon"><i class="fa fa-book"></i></span><span class="nav-text">Class</span>
                                    </a>
                                    <ul>
                                        <security:authorize ifAnyGranted="1081">
                                            <li><a href="${pageContext.request.contextPath}/admin/student-class-enrollment">Create Class</a></li>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="1082">
                                            <li><a href="${pageContext.request.contextPath}/admin/class-details-search">Search Class</a></li>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="1085">
                                            <li><a href="${pageContext.request.contextPath}/admin/student-class-progression">Class Prog & Ref</a></li>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="1086">
                                            <li><a href="${pageContext.request.contextPath}/admin/student-class-transfer">Class Transfer</a></li>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="1087">
                                            <li><a href="${pageContext.request.contextPath}/admin/student-class-demote-transfer">Class Demote Transfer</a></li>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="1089">
                                            <li><a href="${pageContext.request.contextPath}/admin/student-course-transfer">Class Curriculum Transfer</a></li>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="1088">
                                            <li><a href="${pageContext.request.contextPath}/admin/new-student-class-enrollment">Class Enrollment</a></li>
                                        </security:authorize>
                                    </ul>
                                </li>
                            </security:authorize>
                            <security:authorize access="hasRole('1090') or hasRole('1091')">           
                                <li id="timetable-menu" class="side"> 
                                    <a href="#">
                                        <span class="nav-icon"><i class="fa fa-table"></i></span><span class="nav-text">Timetable</span>
                                    </a> 
                                    <ul>
                                        <security:authorize ifAnyGranted="1090">
                                            <li><a href="${pageContext.request.contextPath}/admin/create-timetable">Add Timetable</a></li>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="1091">
                                            <li><a href="${pageContext.request.contextPath}/admin/timetable-details-search">Search Timetable</a></li>
                                        </security:authorize>
                                    </ul>
                                </li>
                            </security:authorize>                            
                            <security:authorize access="hasRole('1110') or hasRole('1111')">
                                <li id="attendance-menu" class="side">
                                    <a href="#">
                                        <span class="nav-icon"><i class="fa fa-check-square-o"></i></span><span class="nav-text">Attendance</span>
                                    </a>
                                    <ul>
                                        <security:authorize ifAnyGranted="1110">
                                            <li><a href="${pageContext.request.contextPath}/admin/student-mark-attendance">Mark Attendance</a></li>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="1204">
                                            <li><a href="${pageContext.request.contextPath}/admin/student-view-edit-attendance">View/Edit Attendance</a></li>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="1111">
                                            <li><a href="${pageContext.request.contextPath}/admin/search-attendance">Search Attendance</a></li>
                                        </security:authorize>
                                    </ul>
                                </li>
                            </security:authorize>
                            <security:authorize access="hasRole('1134') or hasRole('1147') or hasRole('1148')">
                                <li id="calendar-menu" class="side">
                                    <a href="#">
                                        <span class="nav-icon"><i class="fa fa-calendar"></i></span><span class="nav-text">Calendar</span>

                                    </a>
                                    <ul><security:authorize ifAnyGranted="1134">
                                            <li><a href="${pageContext.request.contextPath}/admin/create-school-event">Create School Event</a></li>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="1147">
                                            <li><a href="${pageContext.request.contextPath}/admin/search-school-event">Search School Event</a></li>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="1148">
                                            <li><a href="${pageContext.request.contextPath}/admin/create-school-holidays">Define School Holidays</a></li>
                                        </security:authorize>
                                    </ul>
                                </li>             
                            </security:authorize>
                            <security:authorize access="hasRole('1153') or hasRole('1154')">
                                <li id="lesson-planner-menu" class="side">
                                    <a href="#">
                                        <span class="nav-icon"><i class="fa fa-pencil-square-o"></i></span><span class="nav-text">Curriculum / Lesson Planner</span>

                                    </a>
                                    <ul><security:authorize ifAnyGranted="1153">
                                            <li><a href="${pageContext.request.contextPath}/admin/create-weekly-lesson-planner">Create Curriculum / Lesson Planner</a></li>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="1154">
                                            <li><a href="${pageContext.request.contextPath}/admin/search-lesson-planner">Search Curriculum / Lesson Planner</a></li>
                                        </security:authorize>

                                    </ul>
                                </li>             
                            </security:authorize>
                            <security:authorize access="hasRole('1157') or hasRole('1158')">
                                <li id="exam-menu" class="side">
                                    <a href="#">
                                        <span class="nav-icon"><i class="fa fa-map-o"></i></span><span class="nav-text">Exam</span>

                                    </a>
                                    <ul><security:authorize ifAnyGranted="1157">
                                            <li><a href="${pageContext.request.contextPath}/admin/create-exam">Create Exam</a></li>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="1158">
                                            <li><a href="${pageContext.request.contextPath}/admin/search-exam">Search Exam</a></li>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="1170">
                                            <li><a href="${pageContext.request.contextPath}/admin/create-exam-submission">Create Exam Submission</a></li>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="1171">
                                            <li><a href="${pageContext.request.contextPath}/admin/search-exam-submission">Search Exam Submission</a></li>
                                        </security:authorize>

                                    </ul>
                                </li>             
                            </security:authorize>
                            <security:authorize access="hasRole('1179') or hasRole('1180') or hasRole('1184') or hasRole('1185')">
                                <li id="assignment-menu" class="side">
                                    <a href="#">
                                        <span class="nav-icon"><i class="fa fa-map"></i></span><span class="nav-text">Homework/ Assignment</span>

                                    </a>
                                    <ul><security:authorize ifAnyGranted="1179">
                                            <li><a href="${pageContext.request.contextPath}/admin/create-assignment">Create Homework/ Assignment</a></li>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="1180">
                                            <li><a href="${pageContext.request.contextPath}/admin/search-assignment">Search Homework/ Assignment</a></li>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="1184">
                                            <li><a href="${pageContext.request.contextPath}/admin/assignment-submission">Create Home./ Assi. Submission</a></li>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="1185">
                                            <li><a href="${pageContext.request.contextPath}/admin/assignment-submission-search">Search Home./ Assi. Submission</a></li>
                                        </security:authorize>

                                    </ul>
                                </li>             
                            </security:authorize>            
                            <security:authorize access="hasRole('1165') or hasRole('1166')">
                                <li id="discipline-menu" class="side">
                                    <a href="#">
                                        <span class="nav-icon"><i class="fa fa-exclamation-triangle"></i></span><span class="nav-text">Discipline</span>

                                    </a>
                                    <ul><security:authorize ifAnyGranted="1165">
                                            <li><a href="${pageContext.request.contextPath}/admin/create-discipline-records">Create Discipline</a></li>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="1166">
                                            <li><a href="${pageContext.request.contextPath}/admin/search-discipline-records">Search Discipline</a></li>
                                        </security:authorize>

                                    </ul>
                                </li>             
                            </security:authorize>

                            <security:authorize access="hasRole('1175') or hasRole('1176')">
                                <li id="enquiry-menu" class="side">
                                    <a href="#">
                                        <span class="nav-icon"><i class="fa fa-envelope"></i></span><span class="nav-text">Student Enquiry</span>

                                    </a>
                                    <ul><security:authorize ifAnyGranted="1175">
                                            <li><a href="${pageContext.request.contextPath}/admin/program-enquiries">Create Student Enquiry</a></li>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="1176">
                                            <li><a href="${pageContext.request.contextPath}/admin/program-enquiries-search">Search Student Enquiry</a></li>
                                        </security:authorize>

                                    </ul>
                                </li>             
                            </security:authorize> 

                            <security:authorize access="hasRole('1188')">
                                <li id="importexport-menu" class="side">
                                    <a href="#">
                                        <span class="nav-icon"><i class="fa fa-exchange"></i></span><span class="nav-text">Data Upload</span>
                                    </a>
                                    <ul>
                                        <security:authorize ifAnyGranted="1188">
                                            <li><a href="${pageContext.request.contextPath}/admin/import-export-student-records">Student Data Upload</a></li>
                                        </security:authorize>
                                        <!--<security:authorize ifAnyGranted="1188">-->
                                        <li><a href="${pageContext.request.contextPath}/admin/import-export-parent-records">Parent Data Upload</a></li>
                                        <!--</security:authorize>-->
                                        <!--<security:authorize ifAnyGranted="1188">-->
                                        <li><a href="${pageContext.request.contextPath}/admin/import-export-employee-records">Employee Data Upload</a></li>
                                        <!--</security:authorize>-->
                                    </ul>
                                </li>             
                            </security:authorize>   


                            <security:authorize access="hasRole('1193') or hasRole('1194')">
                                <li id="importexport-payment-menu" class="side">
                                    <a href="#">
                                        <span class="nav-icon"><i class="fa fa-money"></i></span><span class="nav-text">Payment</span>

                                    </a>
                                    <ul>
                                        <security:authorize ifAnyGranted="1193">
                                            <li><a href="${pageContext.request.contextPath}/admin/import-export-student-payment-records">Payment Data Upload</a></li>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="1194">
                                            <li><a href="${pageContext.request.contextPath}/admin/student-payment-search">Payment Search</a></li>
                                        </security:authorize>
                                    </ul>
                                </li>             
                            </security:authorize>   

                            <security:authorize access="hasRole('1190') or hasRole('1191')">
                                <li id="alert-menu" class="side">
                                    <a href="#">
                                        <span class="nav-icon"><i class="fa fa-lightbulb-o"></i></span><span class="nav-text">Alert Notification</span>

                                    </a>
                                    <ul>
                                        <security:authorize ifAnyGranted="1190">
                                            <li><a href="${pageContext.request.contextPath}/admin/create-alert">Create Alert</a></li>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="1191">
                                            <li><a href="${pageContext.request.contextPath}/admin/search-alert">Search Alert</a></li>
                                        </security:authorize>


                                    </ul>
                                </li>             
                            </security:authorize>             




                            <security:authorize access="hasRole('1135') or hasRole('1136') or hasRole('1137') or hasRole('1140')">       
                                <li id="user-menu" class="side">
                                    <a href="#" style="height: auto;">
                                        <span class="nav-icon"><i class="fa fa-user-plus"></i></span><span class="nav-text">User Management</span>
                                    </a>
                                    <ul>
                                        <security:authorize ifAnyGranted="1140">
                                            <li><a href="${pageContext.request.contextPath}/admin/search-registered-users">Manage Users</a></li>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="1135">
                                            <li><a href="${pageContext.request.contextPath}/admin/create-user-category">User Category</a></li>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="1136">
                                            <li><a href="${pageContext.request.contextPath}/admin/create-role">Add User Role</a></li>
                                        </security:authorize>
                                        <security:authorize ifAnyGranted="1137">
                                            <li><a href="${pageContext.request.contextPath}/admin/search-role">Search User Roles</a></li>
                                        </security:authorize>

                                    </ul>
                                </li>
                            </security:authorize> 
                            <security:authorize access="hasRole('1119') or hasRole('1121') or hasRole('1122') or hasRole('1123') or hasRole('1125') or hasRole('1124') or hasRole('1126') or hasRole('1120') or hasRole('1161') or hasRole('1162') or hasRole('1174')">
                                <li id="common-menu" class="side">
                                    <a href="#">
                                        <span class="nav-icon"><i class="fa fa-wrench"></i></span><span class="nav-text">Master Setup</span>
                                    </a>
                                    <ul>
                                        <security:authorize access="hasRole('1119') or hasRole('1121') or hasRole('1120')">
                                            <li><a href="${pageContext.request.contextPath}/admin/create-country">Region</a></li>
                                        </security:authorize>
                                        <security:authorize access="hasRole('1122') or hasRole('1123') or hasRole('1125') or hasRole('1124')">
                                            <li><a href="${pageContext.request.contextPath}/admin/create-institute">Education</a></li>
                                        </security:authorize>
                                        <security:authorize access="hasRole('1126')">
                                            <li><a href="${pageContext.request.contextPath}/admin/create-batch-category">Curriculum</a></li>
                                        </security:authorize>
                                        <security:authorize access="hasRole('1161')">
                                            <li><a href="${pageContext.request.contextPath}/admin/create-exam-type">Exam Type</a></li>
                                        </security:authorize>
                                        <security:authorize access="hasRole('1174')">
                                            <li><a href="${pageContext.request.contextPath}/admin/create-exam-mark-scale">Exam Mark Scale</a></li>
                                        </security:authorize>
                                        <security:authorize access="hasRole('1189')">
                                            <li><a href="${pageContext.request.contextPath}/admin/create-assignment-type">Assignment Type</a></li>
                                        </security:authorize>
                                        <security:authorize access="hasRole('1162')">
                                            <li><a href="${pageContext.request.contextPath}/admin/create-class-room">Class Room</a></li>
                                        </security:authorize>
                                    </ul>
                                </li>
                            </security:authorize>
                            <security:authorize access="hasRole('1197') or hasRole('1198') or hasRole('1199') or hasRole('1200') or hasRole('1201') or hasRole('1202')">
                                <li id="report-menu" class="side">
                                    <a href="#">
                                        <span class="nav-icon"><i class="fa fa-file"></i></span><span class="nav-text">Report</span>
                                    </a>
                                    <ul>
                                        <security:authorize access="hasRole('1197')">
                                            <li><a href="${pageContext.request.contextPath}/admin/reception-report">Reception Report</a></li>
                                        </security:authorize>
                                        <security:authorize access="hasRole('1198')">
                                            <li><a href="${pageContext.request.contextPath}/admin/nursery-final-report">Nursery Final Report</a></li>
                                        </security:authorize>
                                        <security:authorize access="hasRole('1199')">
                                            <li><a href="${pageContext.request.contextPath}/admin/year-final-report">Year 1 and 2 Report</a></li>
                                        </security:authorize>
                                        <security:authorize access="hasRole('1200')">
                                            <li><a href="${pageContext.request.contextPath}/admin/year-final-report-3-6">Year 3 to 6 Report</a></li>
                                        </security:authorize>
                                        <security:authorize access="hasRole('1201')">
                                            <li><a href="${pageContext.request.contextPath}/admin/eal-report-1-6">EAL Report 1 to 6 </a></li>
                                        </security:authorize>
                                        <security:authorize access="hasRole('1202')">
                                            <li><a href="${pageContext.request.contextPath}/admin/eal-report-7-13">EAL Report 7 to 13 </a></li>
                                        </security:authorize>
                                        <security:authorize access="hasRole('1203')">
                                            <li><a href="${pageContext.request.contextPath}/admin/secondary-report">Secondary Report</a></li>
                                        </security:authorize>
                                    </ul>
                                </li>
                            </security:authorize>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-sm-11 col-md-11 col-lg-10">
        <!-- ############# /LEFT NAVIGATION ############# -->