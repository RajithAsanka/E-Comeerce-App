<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html data-ng-app="dashboard" manifest="ib.mf">

    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta name="apple-mobile-web-app-capable" content="yes" />

        <%
            String remoteip = request.getRemoteAddr();
        %>

        <%@include file="template/login/header.jsp"%>
    </head>

    <body>
        <!-- ############# HEADER ############# -->
        <div class="container logo-wrapper">
            <a href="login">
                <img src="${pageContext.servletContext.contextPath}/resources/images/logo-TFC.PNG" />
            </a>
        </div>
        <div class="container login-wrapper">
            <div class="row header"></div>
            <!-- ############# /HEADER ############# -->

            <div class="row">

                <div class="col-sm-12">
                    <!-- ############# /LEFT NAVIGATION ############# -->

                    <!-- ############# CONTENT ############# -->
                    <div class="content">
                        <div class="row">

                            <div id="loginbox">
                                <div class="alert alert-danger hidden">
                                    Your login attempt was not successful, try again.<br />
                                    Caused :
                                </div>
                                <div class="clearfix"></div>
                                <c:if test="${not empty error}">
                                    <div style="color:red" class="error">
                                        ${error}
                                    </div>
                                </c:if>
                                <c:if test="${not empty msg}">
                                    <div class="msg">
                                        ${msg}
                                    </div>
                                </c:if>

                                <form class="form-custom" id="loginForm" action="<c:url value='/j_spring_security_check' />" method='POST'>
                                    <div class="row">
                                        <div class="col-sm-12 form-group">
                                            <input type="text" class="form-control copyPaste" id="username" name="j_username" placeholder="Username" required
                                                   autofocus>
                                        </div>
                                        <div class="col-sm-12 form-group">
                                            <input type="password" class="form-control copyPaste" id="inputPassword" name="j_password" placeholder="Password">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6 text-left">
                                            <a href="${pageContext.servletContext.contextPath}/forgot">Forgot Password?</a>
                                        </div>
                                        <div class="col-sm-6 text-right">
                                            <button type="submit" class="btn-custom btn-primary" value="Login">
                                                Login
                                            </button>
                                        </div>
                                        <input type="hidden" name="${_csrf.parameterName}"
                                               value="${_csrf.token}" />
                                    </div>
                                </form>
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

    <script type="text/javascript">
        $(document).ready(function () {

            //block pasting in password confirmation input field
            $('#inputPassword').bind("cut copy", function (e) {
                e.preventDefault();
            });
            //validate inputPassword
            var inputPassword = $("#inputPassword");
//            inputPassword.keypress(function (e) {
//                //alert(e.which);
//                if (document.getElementById('inputPassword').value.length < 20) {
//                    if (!(e.which >= 48 && e.which <= 57)//allow 0-9
//                            && e.which != 43// allow plus +
//                            && e.which != 13// allow enter
//                            && e.which != 8 && //allow backspace
//                            !(e.which >= 65 && e.which <= 90) && // allow A-Z
//                            !(e.which >= 97 && e.which <= 122)// allow a-z
//                            && e.which != 0) {//allow tab
//                        e.preventDefault();
//                    }
//                }
//            });

            // block pasting in email confirmation input field
            $(".copyPaste").bind("cut copy paste", function (e) {
                e.preventDefault();
            });

            loading();

        });

        $('#inputPassword').on({
            keydown: function (e) {
                if (e.which === 32)
                    return false;
            },
            change: function () {
                this.value = this.value.replace(/\s/g, "");
            }
        });

        function loading() {
            error = getUrlVars()["error"];

            if (error) {
                cause = "";
                if (error === "invalidUser") {
                    cause = "Invalid User";
                } else if (error === "badCredentials") {
                    cause = "Wrong Password";
                } else if (error === "userNotActive") {
                    cause = "User Not Active";
                } else if (error === "NotActive") {
                    cause = "User blocked";
                } else if (error === "InvalidToken") {
                    cause = "Invalid Token";
                }
                $(".alert").html(" Your login attempt was not successful, try again.<br /> Caused : " + cause);
                $(".alert").removeClass("hidden");
            } else {

            }
        }
    </script>
    <script
    src="${pageContext.servletContext.contextPath}/resources/js/common-functions.js"></script>
</html>