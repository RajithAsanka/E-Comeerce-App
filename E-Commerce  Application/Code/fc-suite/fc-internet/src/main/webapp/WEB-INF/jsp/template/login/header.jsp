<title>The First Credit - Login Form</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="${pageContext.servletContext.contextPath}/resources/images/faviconfc.jpg" type="image/x-icon">
<link rel="icon" href="${pageContext.servletContext.contextPath}/resources/images/faviconfc.jpg" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/libs/bootstrap/css/bootstrap.min.css">
<!--<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/libs/bootstrap/css/bootstrap.css">-->
<!--<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/libs/font-awesome/css/font-awesome.css">-->
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/libs/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/libs/bootstrap-dialog/css/bootstrap-dialog.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/libs/bootstrap-table/css/bootstrap-table.css">
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/libs/jPushMenu/css/jPushMenu.css">
<%--     <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/libs/bootstrap-datepicker/css/datepicker3.css"> --%>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/theme.css">

<!--<script src="${pageContext.servletContext.contextPath}/resources/libs/jquery/jquery-1.10.2.js"></script>-->
 <script src="${pageContext.servletContext.contextPath}/resources/libs/jquery/jquery-1.10.2-min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/libs/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/libs/jPushMenu/js/jPushMenu.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/libs/bootstrap-table/js/bootstrap-table.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/libs/bootstrap-dialog/js/bootstrap-dialog.min.js"></script>
<%--     <script src="${pageContext.servletContext.contextPath}/resources/libs/bootstrap-datepicker/js/bootstrap-datepicker.js"></script> --%>


<script src="${pageContext.servletContext.contextPath}/resources/libs/jquery-validation/js/jquery.validate.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/libs/jquery-validation/js/additional-methods.min.js"></script>

<style>
    body {
        border-top-width: 10px;
        background: #f7f7f7;
    }
</style>
<script>
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