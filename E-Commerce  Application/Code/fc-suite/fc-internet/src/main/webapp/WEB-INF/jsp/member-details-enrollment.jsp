<%-- 
    Document   : member-details-enrollment
    Created on : Feb 20, 2017, 12:35:24 AM
    Author     : Naveen
--%>

<!--########################## Main Header ###########################-->
<%@include file="template/main/header.jsp"%>

<!-- ############# PAGE TITLE ############# -->
<script>
    document.title = "First Credit - Member Registration Form";
</script>

<!-- ############# CONTENT ############# -->
<div class="content">
<div class="row">
    <div class="col-sm-12">
        <h2 class="form-heading">Customer  Details</h2>
    </div>
</div>

<form class="form-horizontal form-custom" id="form-student-details"
      role="form" enctype="multipart/form-data">
    <div class="row">
        <div class="col-sm-6">
            <div class="form-section">
                <h3 class="form-subheading">Personal Details</h3>

                <div class="form-group">
                    <label class="control-label col-sm-2 col-md-3 is-required"
                           for="title">Title</label>
                    <div class="col-sm-4">
                        <select class="form-control other" id="title" name="title">
                            <option>Mr.</option>
                            <option>Ms.</option>
                            <option>Miss.</option>
                            <option>Mrs.</option>
                        </select>
                    </div>
                    <div class="col-sm-5 ">
                        <label class="control-label col-sm-8 col-md-8 checkbox"
                               for="is-active">Active</label>
                        <div class="col-xs-1 col-sm-3">
                            <input type="checkbox" class="other checkbox" id="is-active"
                                   name="is-active" checked="checked">
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2 col-md-3 is-required "
                           for="first-name">First Name</label>
                    <div class="col-sm-10 col-md-9">
                        <input type="text" class="form-control  other"
                               id="first-name" name="first-name" placeholder="First Name"
                               maxlength="30">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2 col-md-3" for="middle-name">Middle
                        Name</label>
                    <div class="col-sm-10 col-md-9">
                        <input type="text" class="form-control  other"
                               id="middle-name" placeholder="Middle Name" maxlength="30">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2 col-md-3 is-required"
                           for="last-name">Last Name</label>
                    <div class="col-sm-10 col-md-9">
                        <input type="text" class="form-control lastNameVal other"
                               id="last-name" name="last-name" placeholder="Last Name"
                               maxlength="30">
                    </div>
                </div>

                <div class="form-group">
                    <div class="radio col-sm-offset-2 col-md-offset-3">
                        <label class="control-label radio" for="male">Male</label>
                        <div class="col-xs-1 col-sm-1">
                            <input type="radio" class="other" name="gender" id="male"
                                   checked="checked">
                        </div>
                        <label class="control-label radio " for="female">Female</label>
                        <div class="col-xs-1 col-sm-1">
                            <input type="radio" class="other" name="gender" id="female">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2 col-md-3 is-required"
                           for="dob">DOB</label>
                    <div class="col-sm-10 col-md-9">
                        <div class="input-group date">
                            <input type="text" class="form-control dob-datepicker other"
                                   id="dob" name="dob" data-date-format="mm/dd/yyyy" /> <span
                                   class="input-group-addon"> <span
                                    class="glyphicon glyphicon-calendar"></span>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2 col-md-3"
                           for="age">Age</label>
                    <div class="col-sm-10 col-md-9">
                        <input type="text" disabled="disabled"
                               class="form-control numberValClass other" id="age" name="age" placeholder="Age"
                               maxlength="2">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2 col-md-3"
                           for="ref-no">Identification Number</label>
                    <div class="col-sm-4">
                        <select class="form-control other" id="id-type" name="id-type">
                            <option value="NIC">NIC</option>
                            <option value="Passport">Passport No.</option>
                            <option value="Driving Licence">Driving Licence</option>
                        </select>
                    </div>
                    <div class="col-sm-5 col-md-5">
                        <input type="text" class="form-control stringNumberValClass other"
                               id="idenfition-no" name="idenfition-no" maxlength="20"
                               placeholder="NIC/PP/DL">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2 col-md-3 is-required "
                           for="issued-country">Issued country</label>
                    <div class="col-sm-10 col-md-9">
                        <input type="text" class="form-control  other"
                               id="issued-country" name="issued-country" placeholder="Issued country"
                               maxlength="30">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2 col-md-3 is-required"
                           for="occupation">Occupation</label>
                    <div class="col-sm-10 col-md-9">
                        <input type="text" class="form-control lastNameVal other"
                               id="occupation" name="occupation" placeholder="Occupation"
                               maxlength="30">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2 col-md-3 is-required"
                           for="no-of-family-members">No of family members</label>
                    <div class="col-sm-10 col-md-9">
                        <input type="text" class="form-control lastNameVal other"
                               id="no-family" name="no-family" placeholder="No of family members"
                               maxlength="30">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2 col-md-3 is-required"
                           for="no-dependents">Number of dependents</label>
                    <div class="col-sm-10 col-md-9">
                        <input type="text" class="form-control lastNameVal other"
                               id="no-dependents" name="no-dependents" placeholder="Number of dependents"
                               maxlength="30">
                    </div>
                </div>
                
                 </div>
                
                <div class="form-section">
                <h3 class="form-subheading">Address Details</h3>
                <div class="form-group">
                    <label class="control-label col-sm-3 is-required" for="add1">Street
                        Address 1</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control other" id="personal-add1"
                               name="personal-add1" placeholder="Street Address 1" maxlength="250">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-3" for="add2">Street
                        Address 2</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control other" id="personal-add2"
                               placeholder="Street Address 2" maxlength="250">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-3 is-required"
                           for="personal-city">City</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control other" id="personal-city"
                               placeholder="City" maxlength="250">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-3"
                           for="personal-province">State</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control other" id="personal-province"
                               placeholder="State" maxlength="250">
                    </div>
                </div>
            </div>

              <div class="form-section">
                <h3 class="form-subheading">Contact Details</h3>
                <div class="form-group">
                    <label class="control-label col-sm-3 is-required"
                           for="phone-number">Mobile Number 1</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control  tpnumberValClass other" id="contact-1"
                               name="contact-1" placeholder="Mobile Number 1" maxlength="15">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-3 "
                           for="phone-number">Mobile Number 2</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control  tpnumberValClass other" id="contact-2"  name="contact-2"
                               placeholder="Mobile Number 2" maxlength="15">
                    </div>
                </div>




                <div class="form-group">
                    <label class="control-label col-sm-3 "
                           for="landLine-number">Land Line Number</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control  tpnumberValClass other" id="landline"
                               name="landline" placeholder="Land Line Number" maxlength="15">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-3 is-required"
                           for="email-personal">Personal Email</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control other" id="email-personal" maxlength="100"
                               name="email-personal" placeholder="Personal Email">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-3" for="email-college">Email</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control other" id="email" name="email" maxlength="100"
                               placeholder="Email">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-3" for="fax">Fax</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control tpnumberValClass other" id="fax" name="fax" maxlength="15"
                               placeholder="Fax Number">
                    </div>
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
        <div class="col-sm-6">
            <div class="form-section">
                    <h3 class="form-subheading">Members details</h3>
                    
                    <div class="form-group">           
                        <div class="col-sm-12">
                            <div class="wr-bootstrap-table activity-table">
                                <table id="member-table" class="form-table"></table>
                            </div>
                        </div>
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
<script src="${pageContext.servletContext.contextPath}/resources/js/init.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/member-details-enrollment.js"></script>



