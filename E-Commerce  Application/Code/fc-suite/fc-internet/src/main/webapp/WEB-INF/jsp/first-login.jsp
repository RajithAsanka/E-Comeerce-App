<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<html data-ng-app="dashboard" >

    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <link rel="shortcut icon" href="${pageContext.servletContext.contextPath}/resources/images/faviconfc.jpg" type="image/x-icon">
        <link rel="icon" href="${pageContext.servletContext.contextPath}/resources/images/faviconfc.jpg" type="image/x-icon">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta name="apple-mobile-web-app-capable" content="yes" />
    <input type="hidden" id="txtUserName"
           value="<sec:authentication property="principal.userName" />" />

    <%
        String remoteip = request.getRemoteAddr();
    %>

    <%@include file="template/login/header.jsp"%>

    <style>
        .reset-wrapper {
            max-width: 400px;
            text-align: center;
        }
        .reset-wrapper h2 {
            margin-bottom: 10px;
            font-size: 22px;
            font-weight: bold;
        }
        .reset-wrapper p {
            margin-bottom: 40px;
            font-size: 14px;
            color: #DE4045;
        }
    </style>

</head>

<body>
    <!-- ############# HEADER ############# -->
    <div class="container logo-wrapper">
        <img src="${pageContext.servletContext.contextPath}/resources/images/logo-TFC.PNG" />
    </div>
    <div class="container reset-wrapper">
        <div class="row header"></div>
        <!-- ############# /HEADER ############# -->

        <div class="row">

            <div class="col-sm-12">
                <!-- ############# /LEFT NAVIGATION ############# -->

                <!-- ############# CONTENT ############# -->
                <div class="content">


                    <h2>Reset Password</h2>
                    <div id="loginbox">
                        <div class="alert hidden">
                            Please enter valid details.<br />

                        </div>
                        <form class="form-custom" id="fogot-password-form"  method="POST">
                            <div class="row">

                                <!-- fake fields are a workaround for chrome autofill getting the wrong fields -->
                                <!-- to prevent chrome autofill suggesions -->
                                <input style="display:none" type="text" name="fakeusernameremembered"/>
                                <input style="display:none" type="password" name="fakepasswordremembered"/>

                                <div class="col-sm-12 form-group">
                                    <label>New Password</label>
                                    <input type="password" class="form-control copyPaste" id="password" name="password" placeholder="New Password">
                                </div>

                            </div>
                            <div class="row">
                                <div class="col-sm-12 form-group">
                                    <label>ReType Password</label>
                                    <input type="password" class="form-control copyPaste" id="repassword" name="repassword" placeholder="Retype New Password">
                                </div>

                            </div>
                            <div class="row">
                                <div class="col-sm-6 text-left">
                                </div>
                                <div class="col-sm-6 text-right">
                                    <button type="button" class="btn-custom btn-primary" id="update" value="Submit">Submit</button>
                                </div>

                            </div>
                        </form>

                    </div>

                </div>

            </div>
        </div>
        <div class="footer">
             <p>&#169; 2017, The First Credit. All rights reserved.</p> 
        </div>
    </div>
    <!-- ############# FOOTER ############# -->

</body>




<script src="${pageContext.servletContext.contextPath}/resources/js/common-functions.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/common-dropdown.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/create-first-login.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/validation/common-validation.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/validation/create-first-login-validation.js"></script>

</html>






