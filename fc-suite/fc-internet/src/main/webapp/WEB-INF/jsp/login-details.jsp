<%-- 
    Document   : login-details.jsp
    Created on : Aug 3, 2015, 5:13:27 PM
    Author     : Naveendra
--%>

<!--########################## Main Header ###########################-->
<%@include file="template/main/header.jsp"%>

<!-- ############# PAGE TITLE ############# -->
<script>
    document.title = "The First Credit - Student Login Details Form";
</script>


<!-- ############# CONTENT ############# -->
<div class="content">
    <div id="modal" class="row" hidden="true">
        <div class="col-sm-12">
            <ul id="section-nav">
                <li><a class="current" id="student-details-enrollment" href="#">Details</a></li>
                <li><a id="student-qualification-enrollment" href="#">Education
                        Qualifications</a></li>
                <li><a id="student-activity-enrollment" href="#">Activities</a></li>
                <li><a id="student-achivement-enrollment"
                       href="student-achivement-enrollment">Achievements</a></li>
                <li><a id="student-scholarship-enrollment"
                       href="student-scholarship-enrollment">Scholarship</a></li>
                <li><a id="student-sibling-enrollment"
                       href="student-sibling-enrollment">Sibling</a></li>
                <li><a id="parent-details-enrollment"
                       href="student-sibling-enrollment">Parent</a></li>
                 <li><a id="login-details"
                       href="login-details">Login Details</a></li>
            </ul>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-12">
            <h2 class="form-heading">Login Details</h2>
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
                               for="ref-no">Reference Number</label>
                        <div class="col-sm-10 col-md-9">
                            <input type="text"  class="form-control other" maxlength="20"
                                   id="ref-no" name="ref-no" placeholder="Student Reference Number">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2 col-md-3 is-required"
                               for="ref-no">Nothumbria Univ. Number</label>
                        <div class="col-sm-10 col-md-9">
                            <input type="text" class="form-control other" maxlength="9"
                                   id="uni-ref-no" name="uni-ref-no"
                                   placeholder="Nothumbria University Number">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2 col-md-3 is-required"
                               for="ref-no">Identification Number</label>
                        <div class="col-sm-4">
                            <select class="form-control other" id="id-type" name="id-type">
                                <option value="NIC">NIC</option>
                                <option value="Passport">Passport No.</option>
                                <option value="Driving Licence">Driving Licence</option>
                            </select>
                        </div>
                        <div class="col-sm-5 col-md-5">
                            <input type="text" class="form-control other"
                                   id="idenfition-no" name="idenfition-no" maxlength="10"
                                   placeholder="NIC/PP/DL">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2 col-md-3 is-required"
                               for="title">Title</label>
                        <div class="col-sm-4">
                            <select class="form-control other" id="title" name="title">
                                <option>Mr</option>
                                <option>Miss</option>
                                <option>Mrs.</option>
                            </select>
                        </div>
                        <div class="col-sm-5 ">
                            <label class="control-label col-sm-8 col-md-8 checkbox"
                                   for="is-enrolled">Is Enrolled</label>
                            <div class="col-xs-1 col-sm-3">
                                <input type="checkbox" class="other checkbox" id="is-enrolled"
                                       name="is-enrolled" checked="checked">
                            </div>
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
                            <input type="text" class="form-control stringValClass other"
                                   id="first-name" name="first-name" placeholder="First Name"
                                   maxlength="20">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2 col-md-3" for="middle-name">Middle
                            Name</label>
                        <div class="col-sm-10 col-md-9">
                            <input type="text" class="form-control stringValClass other"
                                   id="middle-name" placeholder="Middle Name" maxlength="20">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2 col-md-3 is-required"
                               for="last-name">Last Name</label>
                        <div class="col-sm-10 col-md-9">
                            <input type="text" class="form-control lastNameVal other"
                                   id="last-name" name="last-name" placeholder="Last Name"
                                   maxlength="20">
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
                        <div class=" col-md-9">
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
                        <div class="date col-md-9">
                            <input type="text" disabled="disabled"
                                   class="form-control numberValClass other" id="age" name="age"
                                   maxlength="2">
                        </div>
                    </div>
                    <div class="form-group">
                        <div
                            class="inner-form-group col-sm-5 col-md-4 col-sm-offset-2 col-md-offset-3">
                            <label class="control-label" for="blood-type">Blood Type</label>
                            <select class="form-control other" id="blood-type">
                                <option>O+</option>
                                <option>A+</option>
                                <option>B+</option>
                                <option>AB</option>
                                <option>O-</option>
                            </select>
                        </div>
                        <div class="inner-form-group col-sm-5 col-md-4 col-md-offset-1">
                            <label class="control-label" for="birthplace">Birth Place</label>
                            <div class="">
                                <input type="text" class="form-control other" id="birthplace" name="birthplace"
                                       placeholder="Birth Place" maxlength="30">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div
                            class="inner-form-group col-sm-5 col-md-4 col-sm-offset-2 col-md-offset-3">
                            <label class="control-label  is-required" for="nationality">Nationality</label>
                            <div class="">
                                <select class="form-control other" id="nationality"
                                        name="nationality" placeholder="Nationality">
                                </select>
                            </div>
                        </div>
                        <div class="inner-form-group col-sm-5 col-md-4 col-md-offset-1">
                            <label class="control-label" for="language">Language</label>
                            <div class="">
                                <select class="form-control other" id="language">
                                    <option>English</option>
                                    <option>Sinhala</option>
                                    <option>Tamil</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div
                            class="inner-form-group col-sm-5 col-md-4 col-sm-offset-2 col-md-offset-3">
                            <label class="control-label" for="religion">Religion</label>
                            <div class="">
                                <select class="form-control other" id="religion">
                                    <option>Buddhist</option>
                                    <option>Hindu</option>
                                    <option>Christian</option>
                                </select>
                            </div>
                        </div>
                        <div class="inner-form-group col-sm-5 col-md-4 col-md-offset-1">
                            <label class="control-label" for="otherreligion">Other</label>
                            <div class="">
                                <input type="text" class="form-control other"
                                       id="other-religion" placeholder="Other Religion" maxlength="10">
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2 col-md-3"
                               for="last-name">Profile Image</label>
                        <div class="col-sm-10 col-md-9">
                            <input id="input-id" type="file" name="files[]" class="uploadFile file" accept="image/*"
                                   data-preview-file-type="text" data-show-upload="false" data-show-remove="true">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2 col-md-3 is-required"
                               for="admission">Admission Date</label>
                        <div class="col-sm-10 col-md-9">
                            <div class="input-group date">
                                <input type="text" class="form-control datepicker other"
                                       id="admission" name="admission" data-date-format="mm/dd/yyyy" />
                                <span class="input-group-addon"> <span
                                        class="glyphicon glyphicon-calendar"></span>
                                </span>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2 col-md-3 is-required"
                               for="category">Interested Program</label>
                        <div class="col-sm-10 col-md-9">
                            <select class="form-control other" id="program" name="program">
                                <option>Select Program</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2 col-md-3 is-required"
                               for="category">Student Category</label>
                        <div class="col-sm-10 col-md-9">
                            <select class="form-control other" id="category" name="category"
                                    placeholder="Student Category">
                                <option>Select Student Category</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2 col-md-3 is-required"
                               for="category">Source</label>
                        <div class="col-sm-10 col-md-9">
                            <select class="form-control other" id="source" name="source">
                                <option value="">Select Source</option>
                                <option>Friends/Existing Students</option>
                                <option>Design Club</option>
                                <option>Education Fair</option>
                                <option>Newspaper</option>
                                <option>Internet/AOD website</option>
                                <option>Radio</option>
                                <option>Facebook</option>
                                <option>Other</option>
                            </select>
                            <input type="text" class="form-control other" placeholder="State the source" id="sourceTxt" name="sourceTxt"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="form-section">
                    <h3 class="form-subheading">Personal Address Details</h3>
                    <div class="form-group">
                        <label class="control-label col-sm-3 is-required" for="add1">Street
                            Address 1</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control other" id="personal-add1"
                                   name="personal-add1" placeholder="Address 1" maxlength="50">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3" for="add2">Street
                            Address 2</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control other" id="personal-add2"
                                   placeholder="Address 2" maxlength="50">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3 is-required"
                               for="personal-city">City</label>
                        <div class="col-sm-9">
                            <select class="form-control other" id="personal-city"
                                    name="personal-city" placeholder="City"></select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3 is-required"
                               for="personal-province">Province</label>
                        <div class="col-sm-9">
                            <select class="form-control other" id="personal-province"
                                    name="personal-province" placeholder="Province/State"></select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3 is-required"
                               for="personal-country">Country</label>
                        <div class="col-sm-9">
                            <select class="form-control other" id="personal-country"
                                    name="personal-country">
                                <option>Sri Lanka</option>
                                <option>Maldives</option>
                                <option>United States of America</option>
                                <option>United Kingdom</option>
                                <option>China</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-8 col-md-4 checkbox"
                               for="is-postal"> This is Postal Address</label>
                        <div class="col-xs-1 col-push-2">
                            <input type="checkbox" class="other checkbox" id="is-postal"
                                   name="is-postal" checked="checked">
                        </div>
                    </div>
                </div>


                <div class="form-section" id="postal-address-form">
                    <h3 class="form-subheading">Postal Address Details</h3>
                    <div class="form-group">
                        <label class="control-label col-sm-3 is-required" for="add1">Street
                            Address 1</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control postalAdd ignore"
                                   id="postal-add1" name="postal-add1" placeholder="Address 1"
                                   maxlength="50">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3" for="add2">Street
                            Address 2</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control postalAdd ignore"
                                   id="postal-add2" placeholder="Address 2" maxlength="50">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3 is-required"
                               for="postal-city">City</label>
                        <div class="col-sm-9">
                            <select class="form-control postalAdd ignore" id="postal-city"
                                    name="postal-city" placeholder="City"></select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3 is-required"
                               for="postal-province">Province</label>
                        <div class="col-sm-9">
                            <select class="form-control postalAdd ignore"
                                    id="postal-province" name="postal-province"
                                    placeholder="Province/State"></select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3 is-required"
                               for="postal-country">Country</label>
                        <div class="col-sm-9">
                            <select class="form-control postalAdd ignore" id="postal-country"
                                    name="postal-country">
                                <option>Sri Lanka</option>
                                <option>Maldives</option>
                                <option>United States of America</option>
                                <option>United Kingdom</option>
                                <option>China</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="form-section">
                    <h3 class="form-subheading">Personal Contact Details</h3>
                    <div class="form-group">
                        <label class="control-label col-sm-2 col-md-3 is-required"
                               for="phone-number">Mobile Number</label>
                        <div class="inner-form-group col-sm-5 col-md-4">
                            <!--<label class="control-label" for="contact-1">Phone Number 1</label>-->

                            <input type="text" class="form-control other" id="contact-1"
                                   name="contact-1" placeholder="Mobile No. 1" maxlength="15">

                        </div>
                        <div class="inner-form-group col-sm-5 col-md-4 col-md-offset-1">
                            <!--<label class="control-label" for="contact-2">Phone Number 2</label>-->

                            <input type="text" class="form-control other" id="contact-2"  name="contact-2"
                                   placeholder="Mobile No. 2" maxlength="15">

                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2 col-md-3 "
                               for="landLine-number">Land Line Number</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control other" id="landline"
                                   name="landline" placeholder="Land Line No." maxlength="15">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2 col-md-3 is-required"
                               for="email-personal">Personal Email</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control other" id="email-personal" maxlength="100"
                                   name="email-personal" placeholder="Personal Email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2 col-md-3" for="email-college">Email</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control other" id="email" name="email" maxlength="100"
                                   placeholder="Email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2 col-md-3" for="fax">Fax</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control other" id="fax" name="fax"
                                   placeholder="Fax No.">
                        </div>
                    </div>
                </div>
                <div class="form-section">
                    <h3 class="form-subheading">How do you want to be notified?</h3>
                    <div class="form-group">
                        <label class="control-label col-sm-2 col-md-2 checkbox"
                               for="email-checkbox"> Email</label>
                        <div class="col-xs-1 col-push-2">
                            <input type="checkbox" class="other checkbox" id="email-checkbox"
                                   name="alert" checked="checked">
                        </div>
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
    </form>


</div>
<!-- ############# /CONTENT ############# -->
<%@include file="template/main/footer.jsp"%>



