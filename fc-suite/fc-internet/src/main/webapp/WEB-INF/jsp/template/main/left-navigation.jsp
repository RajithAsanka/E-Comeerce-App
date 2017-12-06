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
                          
                                <li id="category-menu" class="side">
                                    <a href="#"> 
                                        <span class="nav-icon"><i class="fa fa-tags"></i></span><span class="nav-text">Category</span>
                                    </a> 
                                    <ul>                           
                                            <li><a href="${pageContext.request.contextPath}/admin/create-category">Add Category</a></li>
                                    </ul> 
                                </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-sm-11 col-md-11 col-lg-10">
        <!-- ############# /LEFT NAVIGATION ############# -->