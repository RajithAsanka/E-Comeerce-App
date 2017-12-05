
<!--########################## Main Header ###########################-->
<%@include file="template/main/header.jsp"%>

<!-- ############# PAGE TITLE ############# -->
<script>
    document.title = "First Credit  - Group Details Search Form";
</script>


<c:set var="authData" value=""></c:set>
<security:authorize access="hasRole('1030')">

    <c:set var="authData" value="edit"></c:set>
</security:authorize>

<security:authorize access="hasRole('1020')">
    <c:set var="authData" value="view"></c:set>
</security:authorize>


<security:authorize access="hasRole('1030') and hasRole('1020')">
    <c:set var="authData" value="all"></c:set>
</security:authorize>


<script>

    var operators = "";

    <c:choose>
        <c:when test="${authData == 'edit'}">
    operators = "edit";
        </c:when>
        <c:when test="${authData == 'view'}">

    operators = "view";
        </c:when>
        <c:when test="${authData == 'all'}">

    operators = "all";


        </c:when>
    </c:choose>
</script>

<!-- Dialog Menu -->
<div id="edit-options" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Edit Options</h4>
            </div>
            <div class="modal-body clearfix">
                <ul id="section-options">
                    <security:authorize ifAnyGranted="1030">
                        <li><a id="student-details-enrollment"  href="">Details</a></li>
                        </security:authorize>
                        <security:authorize ifAnyGranted="1001">
                        <li><a id="student-qualification-enrollment" href="">Education Qualifications</a></li>
                        </security:authorize>
                        <security:authorize ifAnyGranted="1002">
                        <li><a id="student-activity-enrollment" href="">Activities</a></li>
                        </security:authorize>
                        <security:authorize ifAnyGranted="1003">
                        <li><a id="student-achivement-enrollment" href="">Achievements</a></li>
                        </security:authorize>
                    <!--                    <li><a id="student-scholarship-enrollment" href="">Scholarship</a></li>-->
                    <security:authorize ifAnyGranted="1005">
                        <li><a id="student-sibiling-enrollment" href="">Siblings</a></li>
                        </security:authorize>
                        <security:authorize ifAnyGranted="1006">
                        <li><a id="parent-details-enrollment" href="">Parents</a></li>
                        </security:authorize>
                        <security:authorize ifAnyGranted="1007">
                        <li><a id="student-documents-loader" href="">Attachments</a></li>   
                        </security:authorize>
                </ul>
            </div>
        </div>
    </div>
</div> 
<!-- Dialog Menu -->

<!-- ############# CONTENT ############# -->
<div class="content">
    <div class="row">
        <div class="col-sm-12">
            <h2 class="form-heading">Search</h2>
        </div>
    </div>
    <form class="form-custom" id="form-group-search" role="form">
        <div class="row">
            <div class="col-sm-5">
                <div class="form-group">
                    <input type="text" class="form-control"
                           placeholder="Search by Group Name" name="" id="search-name">
                </div>
            </div>
            <div class="col-sm-5">
                <div class="form-group">
                    <input type="text" class="form-control" autocomplete="off"
                           placeholder="Search by Memeber Name" name="" id="search-ref-id">
                </div>
            </div>
   
    </form>

    <div class="row">
        <div class="col-sm-offset-5 col-sm-5 text-right">
            <div class="form-group">
                <div class="">
                    <button id="resetButton" type="button"
                            class="btn-custom btn-cancel">Reset</button>
                    <button id="submit" type="button" class="btn-custom btn-primary">Search</button><br/>
                    <button id="generate-excel" type="button" class="btn-custom btn-primary" style="display:none;float:right;margin:4px 0 0 0;">Generate Excel</button>
                    <button id="generate-pdf" type="button" class="btn-custom btn-primary" style="display:none;float:right;margin:4px 4px  0 0;">Generate PDF</button>
                </div>
            </div>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label" for="search-results">Search
            Results</label>
        <div class="wr-bootstrap-table search-table">
            <table id="search-results" class="form-table"></table>
        </div>
        <!--</div>-->
    </div>
    <!-- ############# /CONTENT ############# -->

    <%@include file="template/main/footer.jsp"%>
    <!-- ############# CUSTOM SCRIPTS ############# -->    
    <script src="${pageContext.servletContext.contextPath}/resources/libs/bootstrap-typeahead/bootstrap3-typeahead.min.js"></script>
    <script
    src="${pageContext.servletContext.contextPath}/resources/js/common-functions.js"></script>
    <script
    src="${pageContext.servletContext.contextPath}/resources/js/validation/student-search-validation.js"></script>
    <script
    src="${pageContext.servletContext.contextPath}/resources/js/validation/common-validation.js"></script>
    <script
    src="${pageContext.servletContext.contextPath}/resources/js/common-dropdown.js"></script>
    <script
    src="${pageContext.servletContext.contextPath}/resources/js/student-enrollment-init.js"></script>
    <script
    src="${pageContext.servletContext.contextPath}/resources/js/student-details-search.js"></script>
    <script
    src="${pageContext.servletContext.contextPath}/resources/js/init.js"></script>





</html>