<%-- 
    Document   : create-group
    Created on : Feb 15, 2017, 10:05:05 AM
    Author     : Naveen
--%>

<!--########################## Main Header ###########################-->
<%@include file="template/main/header.jsp" %>

<!-- ############# PAGE TITLE ############# -->
<script>
    document.title = "The First Credit - Create Group Form";

</script>
<!-- ############# CONTENT ############# -->
<div class="content"> 
    <div class="row">
        <div class="col-sm-12">
            <h2 class="form-heading">Create Group</h2>
        </div>
    </div>

    <form class="form-horizontal form-custom" id="form-group" role="form" enctype="multipart/form-data">
        <div class="row">
            <div class="col-sm-6">
                <div class="form-section">
                    <h3 class="form-subheading">Group Details</h3>

                    <div class="form-group" hidden="true">
                        <div class="col-sm-10 col-md-9">
                            <input type="text" class="form-control other"
                                   id="group-id" name="group-id">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2 col-md-3 is-required" for="group">Name of the group</label>
                        <div class="col-sm-10 col-md-9">
                            <input type="text" class="form-control other"
                                   id="group-name" name="group-name" placeholder="Name of the group"
                                   maxlength="50">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2 col-md-3 is-required"
                               for="establishment">Date of establishment</label>
                        <div class="col-sm-10 col-md-9">
                            <div class="input-group date">
                                <input type="text" class="form-control dob-datepicker other" 
                                       id="establishment" name="establishment" data-date-format="mm/dd/yyyy"  /> <span
                                       class="input-group-addon"> <span
                                        class="glyphicon glyphicon-calendar"></span>
                                </span>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2 col-md-3 is-required" for="group">Group officer</label>
                        <div class="col-sm-10 col-md-9">
                            <input type="text" class="form-control other"
                                   id="group-officer" name="group-officer" placeholder="Group officer"
                                   maxlength="50">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2 col-md-3 is-required"
                               for="meeting-day">Meeting day</label>
                        <div class="col-sm-10 col-md-9">
                            <div class="input-group date">
                                <input type="text" class="form-control dob-datepicker other" 
                                       id="meeting-day" name="meeting-day" data-date-format="mm/dd/yyyy"  /> <span
                                       class="input-group-addon"> <span
                                        class="glyphicon glyphicon-calendar"></span>
                                </span>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2 col-md-3 is-required" for="group">Branch</label>
                        <div class="col-sm-10 col-md-9">
                            <input type="text" class="form-control other"
                                   id="group-Branch" name="group-Branch" placeholder="Branch"
                                   maxlength="50">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2 col-md-3 is-required" for="address">Address</label>
                        <div class="col-sm-10 col-md-9">
                            <input type="text" class="form-control other"
                                   id="group-address" name="group-address" placeholder="Address"
                                   maxlength="255">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2 col-md-3 is-required" for="group">Contact number</label>
                        <div class="col-sm-10 col-md-9">
                            <input type="text" class="form-control other"
                                   id="group-contact-number" name="group-contact-number" placeholder="Contact number"
                                   maxlength="50">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3 " for="details">Description</label>
                        <div class="col-sm-9">
                            <textarea class="form-control" rows="5" id="details" maxlength="250"
                                      placeholder="Description" style="resize:none"></textarea>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-3 " for="status">Status</label>
                        <div class="col-sm-9">
                            <select class="form-control" id="status">
                                <option>Active</option>
                                <option>Deactive</option>
                            </select>
                        </div>
                    </div>

                </div>

                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9 text-right">
                        <button id="clear" type="reset" class="btn-custom btn-cancel">Clear</button>
                        <button id="add" type="button" class="btn-custom btn-primary">Add</button>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="form-section">
                    <h3 class="form-subheading">Groups</h3>
                    <div class="form-group">           
                        <div class="col-sm-12">
                            <div class="wr-bootstrap-table activity-table">
                                <table id="group-table" class="form-table"></table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>


</div>
<!-- ############# /CONTENT ############# -->
<%@include file="template/main/footer.jsp" %>
<script src="${pageContext.servletContext.contextPath}/resources/js/init.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/common-functions.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/create-group.js"></script>

<script>
    $("#addmember").click(function () {
        window.location.href = '<%=request.getContextPath()%>/admin/create-member';
    });
</script>