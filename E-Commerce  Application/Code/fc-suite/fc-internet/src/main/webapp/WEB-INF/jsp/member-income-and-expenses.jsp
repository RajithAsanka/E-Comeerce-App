<%-- 
    Document   : member-details-enrollment
    Created on : Feb 20, 2017, 12:35:24 AM
    Author     : Naveen
--%>

<!--########################## Main Header ###########################-->
<%@include file="template/main/header.jsp"%>

<!-- ############# PAGE TITLE ############# -->
<script>
    document.title = "First Credit - Income and Expences Form";
</script>

<!-- ############# CONTENT ############# -->
<div class="content">
    <div id="modal" class="row" </div>
    <div class="col-sm-12">
        <ul id="section-nav">

            <li class="current" ><a id="details-enrollment" href="#">Details</a></li>
            <li><a id="bussiness-details" href="#">Business Details</a></li>
            <li><a id="income-and-expenses" href="#">Income and Expenses</a></li>
            <li><a id="guarantor-profile" href="#">
                    Guarantor Profile</a></li>              
        </ul>
    </div>
</div>

<div class="row">
    <div class="col-sm-12">
        <h2 class="form-heading">Income and Expenses</h2>
    </div>
</div>

<form class="form-horizontal form-custom" id="form-member-income-expense-details"
      role="form" enctype="multipart/form-data">
    <div class="row">
        <div class="col-sm-6">
            <div class="form-section">
                <!--                    <h3 class="form-subheading">Personal Details</h3>-->

                <div class="form-group">
                    <label class="control-label col-sm-2 col-md-3 is-required "
                           for="first-name">Ownership Type</label>
                    <div class="radio col-sm-offset-2 col-md-offset-3">
                        <label class="control-label radio" for="partnership">Partnership</label>
                        <div class="col-xs-1 col-sm-1">
                            <input type="radio" class="other" name="ownership" id="partnership"
                                   checked="checked">
                        </div>
                        <label class="control-label radio " for="single">Single</label>
                        <div class="col-xs-1 col-sm-1">
                            <input type="radio" class="other" name="ownership" id="single">
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2 col-md-3 is-required "
                           for="first-name">Registration Number</label>
                    <div class="col-sm-10 col-md-9">
                        <input type="text" class="form-control  other"
                               id="reg-num" name="reg-num" placeholder="Registration Number"
                               maxlength="30">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-3 " for="details">Business Description</label>
                    <div class="col-sm-9">
                        <textarea class="form-control" rows="5" id="details" maxlength="250"
                                  placeholder="Description" style="resize:none"></textarea>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2 col-md-3 is-required "
                           for="first-name">Type of business place</label>
                    <div class="radio col-sm-offset-2 col-md-offset-3">
                        <label class="control-label radio" for="partnership">Own</label>
                        <div class="col-xs-1 col-sm-1">
                            <input type="radio" class="other" name="ownership" id="partnership"
                                   checked="checked">
                        </div>
                        <label class="control-label radio " for="single">Rented</label>
                        <div class="col-xs-1 col-sm-1">
                            <input type="radio" class="other" name="ownership" id="single">
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2 col-md-3 is-required "
                           for="first-name">Duration of Business</label>
                    <div class="col-sm-10 col-md-9">
                        <input type="text" class="form-control  other"
                               id="reg-num" name="reg-num" placeholder="Years/Months/Days or Not started yet"
                               maxlength="30">
                    </div>
                </div>


                <div class="form-group">
                    <label class="control-label col-sm-2 col-md-3 is-required "
                           for="first-name">Handles by</label>
                    <div class="radio col-sm-offset-2 col-md-offset-3">
                        <label class="control-label checkbox" for="partnership">Owned</label>
                        <div class="col-xs-1 col-sm-1">
                            <input type="checkbox" class="other checkbox" id="email-checkbox"
                                   name="alert" checked="checked">
                        </div>
                        <label class="control-label radio " for="single">Son</label>
                        <div class="col-xs-1 col-sm-1">
                            <input type="checkbox" class="other checkbox" id="email-checkbox"
                                   name="alert" checked="checked">
                        </div>
                    </div>
                    <div class="radio col-sm-offset-2 col-md-offset-3">
                        <label class="control-label checkbox" for="partnership">Father</label>
                        <div class="col-xs-1 col-sm-1">
                            <input type="checkbox" class="other checkbox" id="email-checkbox"
                                   name="alert" checked="checked">
                        </div>
                        <label class="control-label radio " for="single">Brother</label>
                        <div class="col-xs-1 col-sm-1">
                            <input type="checkbox" class="other checkbox" id="email-checkbox"
                                   name="alert" checked="checked">
                        </div>
                    </div>
                    <div class="radio col-sm-offset-2 col-md-offset-3">
                        <label class="control-label checkbox" for="partnership">Spouse</label>
                        <div class="col-xs-1 col-sm-1">
                            <input type="checkbox" class="other checkbox" id="email-checkbox"
                                   name="alert" checked="checked">
                        </div>
                        <label class="control-label radio " for="single">Daughter</label>
                        <div class="col-xs-1 col-sm-1">
                            <input type="checkbox" class="other checkbox" id="email-checkbox"
                                   name="alert" checked="checked">
                        </div>
                    </div>
                    <div class="radio col-sm-offset-2 col-md-offset-3">
                        <label class="control-label checkbox" for="partnership">Mother</label>
                        <div class="col-xs-1 col-sm-1">
                            <input type="checkbox" class="other checkbox" id="email-checkbox"
                                   name="alert" checked="checked">
                        </div>
                        <label class="control-label radio " for="single">Sister</label>
                        <div class="col-xs-1 col-sm-1">
                            <input type="checkbox" class="other checkbox" id="email-checkbox"
                                   name="alert" checked="checked">
                        </div>
                    </div>
                    <div class="radio col-sm-offset-2 col-md-offset-3">
                        <label class="control-label checkbox" for="partnership">Other</label>
                        <div class="col-xs-1 col-sm-1">
                            <input type="checkbox" class="other checkbox" id="email-checkbox"
                                   name="alert" checked="checked">
                        </div>
                    </div>
                </div>




                <div class="form-group">
                    <label class="control-label col-sm-2 col-md-3 is-required"
                           for="no-of-family-members">No of employees</label>
                    <div class="col-sm-10 col-md-9">
                        <input type="text" class="form-control lastNameVal other"
                               id="no-family" name="no-family" placeholder="No of employees"
                               maxlength="30">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2 col-md-3 is-required "
                           for="first-name">Business Reputation</label>
                    <div class="radio col-sm-offset-2 col-md-offset-3">
                        <label class="control-label radio" for="partnership">Satisfied</label>
                        <div class="col-xs-1 col-sm-1">
                            <input type="radio" class="other" name="ownership" id="partnership"
                                   checked="checked">
                        </div>
                        <label class="control-label radio " for="single">Average</label>
                        <div class="col-xs-1 col-sm-1">
                            <input type="radio" class="other" name="ownership" id="single">
                        </div>
                        <label class="control-label radio " for="single">UnSatisfied</label>
                        <div class="col-xs-1 col-sm-1">
                            <input type="radio" class="other" name="ownership" id="single">
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <div class="col-sm-6">
            <div class="form-section">
                <h3 class="form-subheading">Business Sector</h3>
                <div class="form-group">
                    <label class="control-label col-sm-3 is-required" for="add1">Business 01</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control other" id="personal-add1"
                               name="personal-add1" placeholder="Business 01" maxlength="250">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-3 is-required" for="add1">Business 02</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control other" id="personal-add1"
                               name="personal-add1" placeholder="Business 02" maxlength="250">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-3 is-required" for="add1">Business 03</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control other" id="personal-add1"
                               name="personal-add1" placeholder="Business 03" maxlength="250">
                    </div>
                </div>
                <h3 class="form-subheading">Business Sub Sector</h3>
                <div class="form-group">
                    <label class="control-label col-sm-3 is-required" for="add1">Business 01</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control other" id="personal-add1"
                               name="personal-add1" placeholder="Business 01" maxlength="250">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-3 is-required" for="add1">Business 02</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control other" id="personal-add1"
                               name="personal-add1" placeholder="Business 02" maxlength="250">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-3 is-required" for="add1">Business 03</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control other" id="personal-add1"
                               name="personal-add1" placeholder="Business 03" maxlength="250">
                    </div>
                </div>

                <h3 class="form-subheading">Address Details</h3>
                <div class="form-group">
                    <label class="control-label col-sm-3 is-required" for="add1">Business Place address</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control other" id="personal-add1"
                               name="personal-add1" placeholder="Business Place address" maxlength="250">
                    </div>

                </div>



                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9 text-right">
                        <button id="resetButton" type="button"
                                class="btn-custom btn-cancel">Reset</button>
                        <button id="submit" type="button" class="btn-custom btn-primary">Submit</button>
                    </div>
                </div>
            </div>
            </form>


        </div>
        <!-- ############# /CONTENT ############# -->
        <style>
            .activeClass{
                background: #00ff00; 
            }
        </style>
        <%@include file="template/main/footer.jsp"%>
        <script src="${pageContext.servletContext.contextPath}/resources/js/common-functions.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/js/common-dropdown.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/js/member-details-enrollment.js"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/js/init.js"></script>


