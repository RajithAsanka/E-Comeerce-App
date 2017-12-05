<%-- 
    Document   : studentView
    Created on : Aug 29, 2014, 11:29:57 AM
    Author     : Mohamed Sayyaff
--%>

<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*,java.text.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<!-- header  import form main template -->
<%@include file="template/main/header.jsp"%>
<!-- header section form main template -->
<%@include file="template/main/header.jsp"%>




<!-- set page title -->
<script type="text/javascript">
	document.title = "Time Table :: Create";
</script>

<section class="section">
	<!-- main navigation -->
	<%@include file="template/main/left-navigation.jsp"%>
	<!-- main content start -->
	<div class="content">
		<div class="wrap">
			<div class="row">
				<div class="col-lg-12">
					<ol class="breadcrumb">
						<li><a href="#">Home</a></li>
						<li class="#">Time Table Create</li>
						<li class="active">Time Table Module Link</li>
					</ol>
				</div>

				<div class="clearfix"></div>

				<title>File Uploading Form</title>
				</head>
				<body>
					<h3>File Upload:</h3>
					Select a file to upload:
					<br />
					<form action="UploadServlet" method="post" id="imageUploadForm"
						enctype="multipart/form-data">

						 <input id="ImageBrowse" type="file" name="file" size="50" /> <br />
						 
						 <input type="hidden" id="txtToken" name="${_csrf.parameterName}"
							value="${_csrf.token}" /> 
							<input type="submit" value="Upload File" />
					</form>
			</div>
		</div>
	</div>

	<!-- main content end -->

</section>


<%@include file="template/main/footer.jsp"%>

<!-- System Js -->

<%@include file="js/common/common-dropdown.jsp"%>
<%@include file="js/common/common-functions.jsp"%>
<%@include file="js/validation/common-validation.jsp"%>
<%@include file="js/image/image-upload.jsp"%>










