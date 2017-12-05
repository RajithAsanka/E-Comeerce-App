<%-- 
    Document   : mainHeader
    Created on : Aug 29, 2014, 10:56:18 AM
    Author     : Amith Fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/security/tags"
          prefix="sec"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://www.springframework.org/security/tags"
          prefix="security"%>
<%@page session="true"%>
<c:url value="/j_spring_security_logout" var="logoutUrl" />


<html lang="en">
    <head>
        <meta charset="utf-8">
        <title></title>

        <link rel="shortcut icon" href="${pageContext.servletContext.contextPath}/resources/images/faviconfc.jpg" type="image/x-icon">
        <link rel="icon" href="${pageContext.servletContext.contextPath}/resources/images/faviconfc.jpg" type="image/x-icon">
        <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/libs/jquery/jquery-ui.css" type="image/x-icon">
        <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/libs/bootstrap/css/bootstrap.min.css">
<!--        <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/libs/bootstrap/css/bootstrap.css">-->
        <!--<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/libs/font-awesome/css/font-awesome.css">-->
        <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/libs/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/libs/bootstrap-dialog/css/bootstrap-dialog.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/libs/ootstrap-table/css/bootstrap-table.css">
        <!--<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/libs/bootstrap-table/css/bootstrap-table.min.css">-->
        <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/libs/jPushMenu/css/jPushMenu.css">
        <%--     <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/libs/bootstrap-datepicker/css/datepicker3.css"> --%>
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/main.css">
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/theme.css">

<!--        <script src="${pageContext.servletContext.contextPath}/resources/libs/jquery/jquery-1.10.2.js"></script>-->
        <script src="${pageContext.servletContext.contextPath}/resources/libs/jquery/jquery-1.10.2-min.js"></script>
<!--        <script src="${pageContext.servletContext.contextPath}/resources/libs/jquery/jquery-1.10.2.js"></script>-->
        <!--<script src="${pageContext.servletContext.contextPath}/resources/libs/jquery/jquery-1.10.2.js"></script>-->

        <!--<script src="${pageContext.servletContext.contextPath}/resources/libs/jquery/jquery-ui.js"></script>-->
        <script src="${pageContext.servletContext.contextPath}/resources/libs/bootstrap/js/bootstrap.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/libs/jquery/jquery-ui.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/libs/jquery/jquery.ui.widget.js"></script>

        <script src="${pageContext.servletContext.contextPath}/resources/libs/jquery/jquery.ui.widget.js"></script>

        <script src="${pageContext.servletContext.contextPath}/resources/libs/jPushMenu/js/jPushMenu.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/libs/bootstrap-table/js/bootstrap-table.js"></script>
        <!--<script src="${pageContext.servletContext.contextPath}/resources/libs/bootstrap-table/js/bootstrap-table.min.js"></script>-->
        <script src="${pageContext.servletContext.contextPath}/resources/libs/bootstrap-dialog/js/bootstrap-dialog.min.js"></script>
        <%--     <script src="${pageContext.servletContext.contextPath}/resources/libs/bootstrap-datepicker/js/bootstrap-datepicker.js"></script> --%>



        <script src="${pageContext.servletContext.contextPath}/resources/libs/jquery-validation/js/jquery.validate.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/libs/jquery-validation/js/additional-methods.min.js"></script>






    </head>
    <body><!-- SECURITY TOKEN ####### -->
        <input type="hidden" id="txtSecurityToken" name="${_csrf.parameterName}"
               value="${_csrf.token}" />
        <input type="hidden" id="txtUserName"
               value="<sec:authentication property="principal.userName" />" />
        <input type="hidden" id="txtUserType"
               value="<sec:authentication property="principal.userType" />" />
        <sec:authentication property="principal.userType" var="usertype" />
        <sec:authentication property="principal.lastLoginTime" var="lastLoginTime" />

        <% if (session.getAttribute("GREETING_MESSAGE") != null && session.getAttribute("GREETING_MESSAGE").equals("true")) { %>

        <div id="user-greeting" class="modal fade" tabindex="-1" role="dialog">
            <div class="modal-dialog modal-sm" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    </div>
                    <div class="modal-body">
                        <div class="gtng-user-pic">
                            <sec:authentication property="principal.imagePath" var="imagePath" />
                            <c:choose>
                                <c:when test="${imagePath != ''}">

                                    <img id="usernamePic" style="width: 43px;height: 43px;" src="${pageContext.servletContext.contextPath}${imagePath}" />
                                </c:when>
                                <c:when test="${imagePath == ''}">
                                    <img id="usernamePic" style="width: 43px;height: 43px;" src="${pageContext.servletContext.contextPath}/resources/images/profile_default.png" />
                                </c:when>

                            </c:choose>
                        </div>

                        <div class="gtng-msg">
                            <h3><a id="greetingType" href="#" class="user-link"></a>!
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
                                </c:choose></h3>
                            <p id="greetingMessage"></p>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <%session.removeAttribute("GREETING_MESSAGE");
            }%>


        <!-- ############# HEADER ############# -->
        <div class="container">
            <div class="row header">
                <!-- LEFT NAVIGATION TOGGLE (visible only in mobile) -->
                <div class="visible-xs col-xs-2">
                    <div class="navbar-default side-push-toggle" role="navigation">
                        <button type="button"
                                class="navbar-toggle toggle-menu menu-left push-body"
                                data-toggle="collapse" data-target=".sidebar-navbar-collapse">
                            <span class="sr-only">Toggle navigation</span> <span
                                class="icon-bar"></span> <span class="icon-bar"></span> <span
                                class="icon-bar"></span>
                        </button>
                    </div>
                </div>
                <!-- /LEFT NAVIGATION TOGGLE (visible only in mobile) -->

                <!-- LOGO -->
                <div class="col-xs-8 col-sm-2">
                    <div class="logo">
                        <img id="logoPic" src="${pageContext.servletContext.contextPath}/resources/images/logo-TFC-blue.PNG" />
                    </div>
                </div>
                <!-- /LOGO -->

                <div class="col-xs-2 col-sm-10 col-md-10">

                    <!-- USER FUNCTIONS -->
                    <div class="hidden-xs">
                        <div class="user-functions">

                            <!-- SETTINGS DROPDOWN MENU -->

                            <div class="hidden-xs dropdown pull-right">
                                <a role="button" class="btn-notifications dropdown-toggle"
                                   id="logout-menu" data-toggle="dropdown"
                                   aria-expanded="true"><span class="glyphicon glyphicon-off"
                                                           aria-hidden="true"></span></a>
                                <ul class="dropdown-menu dropdown-menu-right user-function-menu"
                                    role="menu" aria-labelledby="user-function-menu">
                                    <li role="presentation"><a role="menuitem" tabindex="-1"
                                                               href="../j_spring_security_logout">Log Out</a></li>
                                </ul>
                            </div>
                            <div class="hidden-xs dropdown pull-right">
                                <a role="button" class="btn-notifications dropdown-toggle"
                                   id="settings-menu" data-toggle="dropdown"
                                   aria-expanded="true"><span class="glyphicon glyphicon-cog"
                                                           aria-hidden="true"></span></a>

                                <ul class="dropdown-menu dropdown-menu-right notification-menu"
                                    role="menu" aria-labelledby="user-function-menu">
                                    <li role="presentation"><a role="menuitem" tabindex="-1"
                                                               href="${pageContext.request.contextPath}/admin/user-pass-change">Setting</a></li>

                                </ul>
                            </div>
                            <div class="hidden-xs dropdown pull-right">
                                <a role="button" class="btn-notifications dropdown-toggle"
                                   id="notification-menu" data-toggle="dropdown"
                                   aria-expanded="true"><span id="notification-menu-icon" class="glyphicon glyphicon-bell"
                                                           aria-hidden="true"></span></a>
                                <ul class="dropdown-menu dropdown-menu-right user-function-menu"
                                    role="menu" aria-labelledby="user-function-menu">
                                    <li role="presentation" id="user-nortification">

                                    </li>
                                </ul>
                            </div>
                            <!--                            <div class="searchbox input-group">
                                                            <input type="text" class="search form-control" placeholder="">
                                                            <span class="input-group-btn">
                                                                <button class="btn btn-default" type="button">
                                                                    <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                                                                </button>
                                                            </span>
                                                        </div>-->

                            <!-- /SETTINGS DROPDOWN MENU -->

                        </div>
                        <!-- /USER FUNCTIONS -->
                    </div>

                    <!-- RIGHT NAVIGATION TOGGLE (visible only in mobile) -->
                    <div class="visible-xs navbar-default side-push-toggle pull-right"
                         role="navigation">
                        <a role="button" class="navbar-toggle menu-right push-body"
                           data-toggle="collapse" data-target=".right-nav"> <span
                                class="sr-only">Toggle right navigation</span> <span
                                class="icon-dots"></span>
                        </a>
                    </div>
                    <!-- /RIGHT NAVIGATION TOGGLE -->

                    <!-- MOBILE RIGHT NAVIGATION (appears only in mobile) -->
                    <div class="visible-xs sidebar-nav rightnav">
                        <div
                            class=" navbar-collapse sidebar-navbar-collapse cbp-spmenu cbp-spmenu-vertical cbp-spmenu-right right-nav">
                            <div class="navbar">
                                <div class="user-login">
                                    <div>Welcome</div>
                                    <span class="user-name">
                                        Shehan



                                    </span> 


                                </div>
                                <ul class="nav navbar-nav">
                                    <li class=""><a href="#">Settings</a></li>
                                    <li><a 
                                            href="<c:url value="${logoutUrl}" />">Log Out</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <form action="${logoutUrl}" method="post" id="logoutForm"
                          style="display: none;">
                        <input type="hidden" name="${_csrf.parameterName}"
                               value="${_csrf.token}" />
                    </form>
                    <!-- /MOBILE RIGHT NAVIGATION -->

                </div>
            </div>

            <script>
                        $(document).ready(
                        function () {

                        $.ajax({
                        type: "GET",
                                url: '${pageContext.servletContext.contextPath}/admin/user-alert/findByUsername/json',
                                data: {
                                username:,
                                        userType:
                                },
                                dataType: "json",
                                context: this,
                                success: function (response) {
                                console.log(response);
                                        $("#user-nortification").empty();
                                        var studentTemp = "";
                                        for (var alerts = 0; alerts < response.length; alerts++) {
                                studentTemp += "<a role='menuitem' tabindex='-1' href='#'>" + response[alerts].massage + "</a>";
                                }
                                $("#user-nortification").append(studentTemp);
                                },
                                error: function (error) {
                                alert("Error");
                                }
                        });
                        });</script>
            <style>
                .user-function-menu .my-alert-class{

                }


            </style>
           <!-- <script src="${pageContext.servletContext.contextPath}/resources/js/my-alerts.js"></script>-->
            <script src="${pageContext.servletContext.contextPath}/resources/js/init.js"></script>

            <script src="${pageContext.servletContext.contextPath}/resources/libs/assets/timedout.js"></script>
            <script src="${pageContext.servletContext.contextPath}/resources/libs/assets/form.js"></script>
            <script type="text/javascript">
                        var dashboardHref = '';
                        function formSubmit() {
                        document.getElementById("logoutForm").submit();
                        }

                $(document).on('click', function (e) {
                if (e.which == 2) {
                e.preventDefault();
                }
                if (e.ctrlKey) {
                return false;
                }
                if (e.shiftKey) {
                return false;
                }
                });
                        /*Net Help*/
                                function newPopup(url) {
                                var width = 1200;
                                        var height = 600;
                                        var left = parseInt((screen.availWidth / 2) - (width / 2));
                                        var top = parseInt((screen.availHeight / 2) - (height / 2));
                                        var windowFeatures = "width=" + width + ",height=" + height + ",status,resizable,left=" + left + ",top=" + top + "screenX=" + left + ",screenY=" + top;
                                        myWindow = window.open(url, "subWind", windowFeatures);
                                        myWindow.focus();
                                }

                        $(document).ready(function () {

                        //checkForOnlineHelp();
//                            if (!(Modernizr.canvas)) {
//                            BrowserSupport('For the best experience please update your browser to the latest version');
//                            } else {
//                            //alert("HTML5 supported");
//                            }

                        //window.history.forward();
                        //DISABLE BACK BUTTOM IN BROWSER
                        if (window.history && window.history.pushState) {

                        $(window).on('popstate', function () {
                        var hashLocation = location.hash;
                                var hashSplit = hashLocation.split("#!/");
                                var hashName = hashSplit[1];
                                if (hashName !== '') {
                        var hash = window.location.hash;
                                if (hash === '') {
                        //alert('Back button was pressed.');
                        //window.history.pushState('forward', null, './#c2V5bGFuaW50ZXJuYWV0YmFua2lnbnRlc3RpbmdzZXlsYW5pbnRlcm5hZXRiYW5raWdudGVzdGluZw==');
                        }
                        }
                        });
                                // window.history.pushState('forward', null, './#c2V5bGFuaW50ZXJuYWV0YmFua2lnbnRlc3RpbmdzZXlsYW5pbnRlcm5hZXRiYW5raWdudGVzdGluZw==');
                        }
                        StartTimers();
                                //Call session time out Notification  - server side session ti   meout
                                var secondsBeforeExpire = ${pageContext.session.maxInactiveInterval};
                                var timeToDecide = 20; // in seconds
                                setInterval(
                                        function () {
                                        timeOutServer("${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}");
                                        }, (secondsBeforeExpire - timeToDecide) * 1000);
                                //Add class to current Navigation item
                                var url = window.location.pathname.split("/")[4];
                                $("nav ul li a").each(
                                function () {
                                var href = $(this).attr('href')
                                        .split("/")[2];
                                        if (url == href) {
                                $(this)
                                        .closest(
                                                'nav > ul > li')
                                        .addClass('current');
                                }
                                });
                                if (url == undefined) {
                        $('nav > ul > li').removeClass('current');
                        }

                        });</script>
            <!--Greetings message-->
            <script type="text/javascript">
                                $(document).ready(function () {



                        getSavedData();
                                function getSavedData() {
                                $.ajax({
                                type: "GET",
                                        url: "user-restriction/getLogInUserCourseList",
//                        data: {                        
//                            courseId: "02"
//                        },
                                        success: function (data) {
                                        console.log(data);
                                        },
                                        error: function (error) {

                                        console.log("error");
                                        }
                                });
                                }

                        var $userGreeting = $("#user-greeting");
                                var thehours = new Date().getHours();
                                if (thehours >= 0 && thehours < 12) {

                        setGreetingMessage("Good  morning", "Have a blessed day!");
                        } else if (thehours >= 12 && thehours < 17) {

                        setGreetingMessage("Good afternoon", "Have a pleasant moment!");
                        } else if (thehours >= 17 && thehours < 24) {

                        setGreetingMessage("Good evening", "Have a wonderful evening  and see you again!");
                        }

                        $userGreeting.modal("show");
                                setTimeout(function () {
                                $userGreeting.modal("hide");
                                }, 5000);
                        });
                                function setGreetingMessage(greetingType, msg) {

                                $("#greetingType").append(greetingType);
                                        $("#greetingMessage").append(msg);
                                }

                        //DISABLE BACK BUTTOM IN BROWSER
                        if (window.history && window.history.pushState) {

                        $(window).on('popstate', function () {
                        var hashLocation = location.hash;
                                var hashSplit = hashLocation.split("#!/");
                                var hashName = hashSplit[1];
                                if (hashName !== '') {
                        var hash = window.location.hash;
                                if (hash === '') {
                        //alert('Back button was pressed.');
                        window.history.pushState('forward', null, '');
                        }
                        }
                        });
                                window.history.pushState('forward', null, '');
                        }

            </script>

            <!-- ############# /HEADER ############# -->
    </body>
</html>