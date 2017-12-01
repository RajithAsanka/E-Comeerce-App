<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html data-ng-app="dashboard" >

    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta name="apple-mobile-web-app-capable" content="yes" />

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

            #loading { width: 100%;
                       height: 100%;
                       top: 0px;
                       left: 0px;
                       position: fixed;
                       display: block;
                       opacity: 0.8;
                       background-color: #fff;
                       z-index: 99;
                       text-align: center;
            }

            #loading img{ 
                margin-top: 10%;
            }
        </style>

    </head>

    <body>
        <!-- ############# HEADER ############# -->
        <div class="container logo-wrapper">
            <a href="login">
                <img src="${pageContext.servletContext.contextPath}/resources/images/logo-TFC.PNG" />
            </a>
        </div>
        <div id="loading" style="display: none">

            <img src="${pageContext.servletContext.contextPath}/resources/images/loading.gif" />
        </div>


        <div class="container reset-wrapper">
            <div class="row header"></div>
            <!-- ############# /HEADER ############# -->

            <div class="row">

                <div class="col-sm-12">
                    <!-- ############# /LEFT NAVIGATION ############# -->

                    <!-- ############# CONTENT ############# -->
                    <div class="content">
                        <!--                        <div class="row">
                                                    <img src="${pageContext.servletContext.contextPath}/resources/images/logo-TFC.PNG" />
                        
                        
                        
                                                </div>-->

                        <h2>Forgot Password</h2>
                        <div id="loginbox">
                            <div class="alert hidden">
                                Please enter valid details.<br />

                            </div>
                            <form class="form-custom" id="fogot-password-form"  method="POST">
                                <div class="row">
                                    <div class="col-sm-12 form-group">
                                        <label>Username</label>
                                        <input type="text" class="form-control copyPaste" id="username" name="username" placeholder="Username">
                                    </div>

                                </div>
                                <div class="row">
                                    <div class="col-sm-6 text-left">
                                    </div>
                                    <div class="col-sm-6 text-right">
                                        <button type="button" class="btn-custom btn-primary" id="forgot" value="Submit">Submit</button>
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
    <script src="${pageContext.servletContext.contextPath}/resources/js/create-forgot-password.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/validation/create-forgot-password-validation.js"></script>

</html>






