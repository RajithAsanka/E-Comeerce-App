<%-- 
    Document   : create-item
    Created on : Dec 10, 2017, 9:19:58 PM
    Author     : Rajith
--%>
<!--########################## Main Header ###########################-->
<%@include file="template/main/header.jsp"%>
<!-- ############# PAGE TITLE ############# -->
<script>
    document.title = "The E-Commerce Application - Create Category Form";
</script>
<!-- ############ CONTENT ############# -->
<div class="content">

    <div class="row">
        <div class="col-sm-12">
            <h2 class="form-heading">Item Details</h2>
        </div>
    </div>
    <form class="form-horizontal form-custom" id="form-item-details"
          role="form" enctype="multipart/form-data">
        <div class="row">
            <div class="col-sm-6">
                <div class="form-section">
                    <h3 class="form-subheading">Item Category Details</h3>

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
                        <label class="control-label col-sm-3 " for="category">Sub Category</label>
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
                 
                </div>
                
                <div class="form-section">
                    <h3 class="form-subheading">Item Details</h3>

                    <div class="form-group">
                        <label class="control-label col-sm-2 col-md-3 is-required" for="item">Name of the item</label>
                        <div class="col-sm-10 col-md-9">
                            <input type="text" class="form-control other"
                                   id="item-name" name="item-name" placeholder="Name of the item"
                                   maxlength="50">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2 col-md-3"
                               for="last-name">Item Image</label>
                        <div class="col-sm-10 col-md-9">
                            <input id="input-id" type="file" name="files[]" class="file"
                                   data-preview-file-type="text" data-show-upload="false" data-show-remove="true">
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
            </div>
            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-9 ">
                    <button id="resetButton" type="reset"
                            class="btn-custom btn-cancel">Reset</button>
                    <button id="submit" type="button" class="btn-custom btn-primary">Submit</button>
                </div>
            </div>
        </div>
    </form>
</div>
<!-- ############# /CONTENT ############# -->
<%@include file="template/main/footer.jsp"%>

<script src="${pageContext.servletContext.contextPath}/resources/js/common-functions.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/common-dropdown.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/validation/common-validation.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/validation/employee-details-validation.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/employee-details-enrollment.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/init.js"></script>



