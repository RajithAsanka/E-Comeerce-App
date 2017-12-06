<%-- 
    Document   : create-group
    Created on : Feb 15, 2017, 10:05:05 AM
    Author     : Rajith
--%>

<!--########################## Main Header ###########################-->
<%@include file="template/main/header.jsp" %>
<!-- ############# PAGE TITLE ############# -->
<script>
    document.title = "The E-Commerce Application - Create Category Form";
</script>
<!-- ############# CONTENT ############# -->
<div class="content"> 
    <div class="row">
        <div class="col-sm-12">
            <h2 class="form-heading">Create Category</h2>
        </div>
    </div>
    <form class="form-horizontal form-custom" id="form-group" role="form" enctype="multipart/form-data">
        <div class="row">
            <div class="col-sm-6">
                <div class="form-section">
                    <h3 class="form-subheading">Category Details</h3>
                    <div class="form-group" hidden="true">
                        <div class="col-sm-10 col-md-9">
                            <input type="text" class="form-control other"
                                   id="category-id" name="category-id">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2 col-md-3 is-required" for="category">Name of the category</label>
                        <div class="col-sm-10 col-md-9">
                            <input type="text" class="form-control other"
                                   id="category-name" name="category-name" placeholder="Name of the category"
                                   maxlength="50">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3 " for="category">Main Category</label>
                        <div class="col-sm-9">
                            <select class="form-control" id="mainCategory">
                                <option>Category-1</option>
                                <option>Category-2</option>
                                <option>Category-3</option>
                                <option>Category-4</option>
                                <option>Category-5</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3 " for="description">Description</label>
                        <div class="col-sm-9">
                            <textarea class="form-control" rows="5" id="description" maxlength="250"
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
                    <h3 class="form-subheading">Categories</h3>
                    <div class="form-group">           
                        <div class="col-sm-12">
                            <div class="wr-bootstrap-table activity-table">
                                <table id="category-table" class="form-table"></table>
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
<script src="${pageContext.servletContext.contextPath}/resources/js/create-category.js"></script>
