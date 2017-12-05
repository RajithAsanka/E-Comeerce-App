//################### Global Variable ###############################################
var updateUrl = "student/update";
var readUrl = "create-customer/find/custormerId";


var custormerId;
var studentReff;
var title;
var admission;
var identificationNo;
var firstName;
var middleName;
var lastName;
var dob;
var age;
var bloodGroup;
var birthPlace;
var nationality;
var religion;
var language1;
var language2;
var chkEnrollment;
var chkStatus;
var gender;
var category;
var source;
var universityCode;
var dialogInstance;
var interestedProgram;


var selectedSchool;
var editRowData;
var setIndex;
var previousSchool = "Select Institute";
var prevSchool;
var reason;

var postalAddressOne;
var postalAddressTwo;
var postalAddressCountry;
var postalAddressProvince;
var postalAddressCity;

var personalAddressOne;
var personalAddressTwo;
var personalAddressCountry;
var personalAddressProvince;
var personalAddressCity;

var alertList = [];
var smsAlert;
var emailAlert;
var mobileAlert;

var username;
var isEnrolled;
var status;

var fileUpload;

var phoneOne;
var phoneTwo;
var landLineNo;
var personalEmail;
var email;
var fax;

var imageLoaded = false;
var token = $("#txtSecurityToken").val();
var resetStudentNum;

//############################# LOADINGS #############################

$(document).ready(function () {

    $('.active').removeClass('active');
    $("#student-menu").addClass("active");
    $("#sourceTxt").hide();
   

    //get lead id from url
    custormerId = getUrlVars()["customerId"];
    getSavedData();
    initRef();


});

function initRef() {
    document.getElementById("student-details-enrollment").setAttribute("href", "student-details-enrollment?studentId=" + $("#ref-no").val());
    document.getElementById("student-qualification-enrollment").setAttribute("href", "student-qualification-enrollment?studentId=" + $("#ref-no").val());
    document.getElementById("student-activity-enrollment").setAttribute("href", "student-activity-enrollment?studentId=" + $("#ref-no").val());
    document.getElementById("student-achivement-enrollment").setAttribute("href", "student-achievement-enrollment?studentId=" + $("#ref-no").val());
//    document.getElementById("student-scholarship-enrollment").setAttribute("href", "student-scholarship-enrollment?studentId=" + $("#ref-no").val());
    document.getElementById("student-sibling-enrollment").setAttribute("href", "student-siblings-enrollment?studentId=" + $("#ref-no").val());
    document.getElementById("student-details-enrollment").setAttribute("href", "student-activity-enrollment?studentId=" + $("#ref-no").val());
    document.getElementById("parent-details-enrollment").setAttribute("href", "parent-details-enrollment?studentId=" + $("#ref-no").val());
    document.getElementById("student-documents-loader").setAttribute("href", "student-documents-loader?studentId=" + $("#ref-no").val());
}


//############################# GETTER & SETTER #############################

function getData() {
    studentReff = $("#ref-no").val();
    title = $("#title").val();
    firstName = $("#first-name").val();
    middleName = $("#middle-name").val();
    lastName = $("#last-name").val();

    if (document.getElementById('male').checked) {
        gender = "male";
    } else if (document.getElementById('female').checked) {
        gender = "female";
    }

    prevSchool = $("#previous-school").val();
    reason = $("#reason").val();



    universityCode = $("#stu-no").val();
    dob = $("#dob").val();
    bloodGroup = $("#blood-type").val();
    birthPlace = $("#birthplace").val();
    nationality = $("#nationality").val();
    language1 = $("#language1").val();
    language2 = $("#language2").val();
    religion = $("#religion").val();

    identificationNo = $("#idenfition-no").val();
    identityType = $("#id-type").val();

    category = $("#category").val();
    house = $("#house").val();
    admission = $("#admission").val();
    if ($("#source").val() == "Other") {
        source = $("#sourceTxt").val();
    }
    else {
        source = $("#source").val();
    }
    interestedProgram = $("#program").val();
    personalAddressOne = $("#personal-add1").val();
    personalAddressTwo = $("#personal-add2").val();
    personalAddressCountry = $("#personal-country").val();
    personalAddressProvince = $("#personal-province").val();
    personalAddressCity = $("#personal-city").val();

    if ($("#is-postal").is(':checked')) {
        postalAddressOne = personalAddressOne;
        postalAddressTwo = personalAddressTwo;
        postalAddressCountry = personalAddressCountry;
        postalAddressProvince = personalAddressProvince;
        postalAddressCity = personalAddressCity;
    } else {

        postalAddressOne = $("#postal-add1").val();
        postalAddressTwo = $("#postal-add2").val();
        postalAddressCountry = $("#postal-country").val();
        postalAddressProvince = $("#postal-province").val();
        postalAddressCity = $("#postal-city").val();
    }

    phoneOne = $("#contact-1").val();
    phoneTwo = $("#contact-2").val();
    landLineNo = $("#landline").val();
    personalEmail = $("#email-personal").val();
    email = $("#email").val();
    fax = $("#fax").val();

    username = $("#txtUserName").val();


    isEnrolled = $("#is-enrolled").val();


    alertList = [];

    if ($("#sms").is(':checked')) {
        alertList.push("Sms");
    }
    if ($("#email-checkbox").is(':checked')) {
        alertList.push("Email");
    }
    if ($("#app").is(':checked')) {
        alertList.push("Mobile");
    }


    if ($("#is-active").is(':checked')) {
        status = "Active";
    } else {
        status = "Deactive";
    }
}

function setData(data) {


    console.log(data);
    $("#ref-no").val(data.studentId);
    resetStudentNum = data.studentId;
    $("#stu-no").val(data.universityId);
    $("#title").val(data.salutationId);
    $("#first-name").val(data.firstName);
    $("#middle-name").val(data.middleName);
    $("#last-name").val(data.lastName);
    
    $("#student-house").val(data.studentHouse);
    

    $("#id-type").val(data.idType);
    idChange();
    //set gender
    if (data.gender == "1" || data.gender == "M") {
        $("#male").attr('checked', true);
    } else if (data.gender == "0" || data.gender == "F") {
        $("#female").attr('checked', true);
    }

    $("#is-enrolled").val(data.isEnrolled);

    if (data.status == "Active") {
        $("#is-active").attr('checked', true);
    }
    else if (data.status == "Deactive") {
        $("#is-active").attr('checked', false);
    }

    $("#sms").attr('checked', data.smsAlert);
    $("#email-alert").attr('checked', data.emailAlert);
    $("#app").attr('checked', data.mobilelert);
    $("#dob").val(data.dateofBirth);
    $("#age").val(getAge($("#dob").val()));
    $("#blood-type").val(data.bloodGroupId);
    $("#birthplace").val(data.birthPlace);
    $("#nationality").val(data.nationalId);
    $("#language").val(data.language);
    $("#language1").val(data.language1);
    $("#language2").val(data.language2);
    $("#religion").val(data.religion);
    $("#idenfition-no").val(data.nicNo);
    $("#category").val(data.studentCategoryId);


    $("#admission").val(data.admissionDate);
    $("#program").val(data.interestedProgram);

    if (data.source == "Friends/Existing Students" || data.source == "Design Club" || data.source == "Education Fair" || data.source == "Newspaper" || data.source == "Internet/MISY website" || data.source == "Radio" || data.source == "Facebook") {
        $("#source").val(data.source);
    }
    else {
        $("#source").val("Other");
        $("#sourceTxt").show();
        $("#sourceTxt").val(data.source);
    }

    $("#personal-add1").val(data.personalStreetAddress1);
    $("#personal-add2").val(data.personalStreetAddress2);
    setCountryList("#country");
    $("#personal-country").val(data.personalCountry);
    setProvinceList("#personal-province", data.personalCountry);
    $("#personal-province").val(data.personalProvince);
    setCityList("#personal-city", data.personalProvince);
    $("#personal-city").val(data.personalCity);



    $("#postal-add1").val(data.postalStreetAddress1);
    $("#postal-add2").val(data.postalStreetAddress2);
    setCountryList("#country");
    $("#postal-country").val(data.postalCountry);
    setProvinceList("#postal-province", data.postalCountry);
    $("#postal-province").val(data.postalProvince);
    setCityList("#postal-city", data.postalProvince);
    $("#postal-city").val(data.postalCity);

    $("#contact-1").val(data.phoneNumberOne);
    $("#contact-2").val(data.phoneNumberTwo);
    $("#landline").val(data.landLineNo);
    $("#email-personal").val(data.personalEmail);
    $("#email").val(data.email);
    $("#fax").val(data.fax);

    fileUpload = data.imageId;


    if (data.imageLoc != "") {
        $('#input-id').fileinput('reset');
        $("#imgId").attr("src", data.imageLoc);
    } else {
        $('#input-id').fileinput('clear');
    }
    var tablePrevious = $("#previous-school-table");
    tablePrevious.bootstrapTable('load', data.previousSchoolList);
}

//###################### EVENTS ########################################

var previousTableId = 0;

$("#resetEmg").click(function () {
    resetPreviousSchool();
});

$('#input-id').on('fileloaded',
        function (event, file, previewId, index, reader) {
            imageLoaded = true;
            $(".file-footer-buttons").hide();
            $(".file-upload-indicator").hide();
        });

$("#add").click(function () {
    var data = "";

    var buttonStatus = $(this).html();
    selectedSchool = $("#previous-school option:selected").text();

    if (buttonStatus === "Add") {
        if (previousSchool !== selectedSchool) {
            data = {
                id: previousTableId,
                previousSchoolName: selectedSchool,
                previousSchool: $("#previous-school").val(),
                reasonForLeaving: $("#reason").val(),
                previousSchoolId: $("#previousSchoolId").val()
            }
            previousTableId++;
            validateschoolTable("#previous-school-table", data, "Add");
            $("#previous-school").val("");
            $("#reason").val("");
            $("#previousSchoolId").val("");
            $('#add').html('Add');
        }
        else {
            validateSchool();
        }
    }
    else {

        data = {
            id: setIndex,
            previousSchoolName: selectedSchool,
            previousSchool: $("#previous-school").val(),
            reasonForLeaving: $("#reason").val(),
            previousSchoolId: $("#previousSchoolId").val()
        }
        validateschoolTable("#previous-school-table", data, "Update");
    }
});

//function to clear the span error message for previous school
$("#previous-school").change(function () {
    $("#school_previous").empty();
});


$("#clear").click(function () {
    resetPreviousSchool();
});

function resetPreviousSchool() {
    $("#school_previous").css('display', 'none');
    $("#previous-school").val("");
    $("#reason").val("");
    $("#previousSchoolId").val("");
    $('#add').html('Add');
}

function hardResetPreviousSchool() {
    previousTableId = 0;
    $("#previous-school").val("");
    $("#reason").val("");
    $("#previousSchoolId").val("");
    emptyTable("#previous-school-table");
}

$("#id-type").change(function () {
    idChange();
});

function idChange() {

    if ($("#id-type").val() == "NIC") {
        $("#idenfition-no").attr('maxlength', '10');
    }
    else {
        $("#idenfition-no").attr('maxlength', '20');
    }
}

function updateEvent() {
    if (imageLoaded) {
        $('#input-id').fileinput('upload');
    } else {
        updateDetail();
    }
}

onChangeCountry("#personal-province", "#personal-country");
onChangeCountry("#postal-province", "#postal-country");

onChangeProvince("#personal-city", "#personal-province");
onChangeProvince("#postal-city", "#postal-province");

$("#source").change(function () {
    if ($("#source").val() == "Other") {
        $("#sourceTxt").show();
    }
    else {
        $("#sourceTxt").hide();
    }

});

$(".stu-no").change(function () {
    isValidStudent();
});
$(".idenfition-no").mousedown(function () {
    isValidStudent();
});
$(".contact-1").change(function () {
    isValidStudent();
});
$(".contact-2").change(function () {
    isValidStudent();
});
$(".email-personal").change(function () {
    isValidStudent();
});
$(".landline").change(function () {
    isValidStudent();
});
$(".fax").change(function () {
    isValidStudent();
});
$('#something').click(function () {
    location.reload();
});

$(".contact").change(function () {
    isValidContact();
});

$("#submit").click(function () {
    if (isValidStudent()) {
        showStudentUpdateConfirmation();
    } else {
        focusInvalid();
    }
});



$('#input-id').on('fileloaded',
        function (event, file, previewId, index, reader) {
            imageLoaded = true;
        });

$("#resetButton").click(function () {

    cancelValidation();
    $("#form-student-details")[0].reset();
    $("#ref-no").val(resetStudentNum);
    setNationalistyList("#nationality");
    $("#nationality").val("Burmese");
    setReligionList("#religion");
    $("#religion").val("Buddhism");
    setLanguageList("#language1");
    $("#language1").val("Burmese");
    setLanguageList("#language2");
    $("#language2 option[value='Burmese']").detach();
    $("#language2").val("N/A");
    setCountryListAndOthers("#personal-country", true, "#personal-province", "#personal-city");
    setCountryListAndOthers("#postal-country", true, "#postal-province", "#postal-city");



});


$('#input-id').on('fileuploaded', function (event, data, previewId, index) {
    var actulPath = getContextPath() + "/resources/uploads/student/";
    $.each(data.response, function (index, file) {
        fileName = file.renamedFileName;
    });
    fileUpload = fileName;
    updateDetail();
});

$("#dob").change(function () {
    $("#age").val(getAge($("#dob").val()));
});

$('#admission').datepicker({
    autoclose: true,
    startView: 3,
    fomat: 'MM/dd/yyyy',
    forceParse: true
});


$('#admission').datepicker().on('changeDate', function (ev) {
    $(this).datepicker('hide');
});

$("#input-id").fileinput({
    uploadUrl: "file-upload/upload-student",
    allowedFileExtensions: ['jpg', 'png', 'gif'],
    overwriteInitial: false,
    maxFileSize: 2000,
    maxFilesNum: 10,
    allowedFileTypes: ['image'],
    uploadAsync: false,
    overwriteInitial: true,
            initialPreview: ["<img id='imgId' class='file-preview-image'>"]
});
//###################### HTML UPDATES ##################################

function generateStudentViewData() {
    var content = "<table class='table table-bordered table-striped'>";
    content += "<tbody>";
    //
    content += "<tr>";
    content += "<td>Admission Date</td>";
    content += "<td>" + admission + "</td>";
    content += "</tr>";
    //
    content += "<tr>";
    content += "<td>Student Reference Number</td>";
    content += "<td>" + studentReff + "</td>";
    content += "</tr>";
    //
    content += "<tr>";
    content += "<td> Name </td>";
    content += "<td>" + firstName + " " + middleName + " " + lastName + "</td>";
    content += "</tr>";
    //
    content += "<tr>";
    content += "<td>Identification Number</td>";
    content += "<td>" + identityType + " - " + identificationNo + "</td>";
    content += "</tr>";
    //
    content += "<tr>";
    content += "<td> Date Of Birth </td>";
    content += "<td>" + dob + "</td>";
    content += "</tr>";
    //
    content += "</tbody>";
    content += "</table>";
    return content;
}

//################### AJAX CALLS #####################################
function getSavedData() {
    $.ajax({
        type: "GET",
        url: readUrl,
        async: false,
        data: {
            custormerId: custormerId
        },
        success: function (data) {
            setData(data);
        },
        error: function (error) {
        }
    });
}

function updateDetail() {
    $.ajax({
        type: "POST",
        url: updateUrl,
        async: false,
        headers: {
            'X-CSRF-TOKEN': token
        },
        data: {
            txtStudentReffNumber: studentId,
            admission: admission,
            source: source,
            universityNo: universityCode,
            idType: $("#id-type").val(),
            reasonforLeaving: reason,
            previousInstitute: prevSchool,
            txtPostalAddress1: postalAddressOne,
            txtPostalAddress2: postalAddressTwo,
            sltPostalCountry: postalAddressCountry,
            sltPostalProvince: postalAddressProvince,
            sltPostalCity: postalAddressCity,
            previousSchoolList: JSON.stringify($('#previous-school-table').bootstrapTable('getData')),
            txtPersonalAddress1: personalAddressOne,
            txtPersonalAddress2: personalAddressTwo,
            sltPersonalCountry: personalAddressCountry,
            sltPersonalProvince: personalAddressProvince,
            sltPersonalCity: personalAddressCity,
            sltTitle: title,
            txtNationalID: identificationNo,
            sltGender: gender,
            txtFirstName: firstName,
            txtMiddleName: middleName,
            txtLastName: lastName,
            txtDob: dob,
            sltBloodGroup: bloodGroup,
            sltLanguage1: language1,
            sltLanguage2: language2,
            chkActive: status,
            txtBirthPlace: birthPlace,
            sltNationality: nationality,
            sltReligion: religion,
            isEnrolled: isEnrolled,
            username: username,
            fileUpload: fileUpload,
            category: category,
            house: house,
            interestedProgram: interestedProgram,
            phoneNoOne: phoneOne,
            phoneNoTwo: phoneTwo,
            landLine: landLineNo,
            personalEmail: personalEmail,
            email: email,
            fax: fax,
            alertStringList: JSON.stringify(alertList),
            studentHouse: $("#student-house").val()
        },
        success: function (data) {
            if (data.success === "true") {
                console.log(data);
                showStudentUpdateMsg(data.result);
            } else {
                showErrorMsg("Error", data.errorMessage);
            }

        },
        error: function () {
            alert("Failed to load ");
        }
    });
}

function showStudentUpdateConfirmation() {
    getData();
    BootstrapDialog.show({
        title: 'Update Confirmation',
        message: generateStudentViewData(),
        buttons: [{
                label: 'Update',
                cssClass: 'btn-success',
                autospin: true,
                action: function (dialog) {
                    dialog.enableButtons(false);
                    dialog.setClosable(false);
                    updateEvent();
                    dialog.close();
                }
            }, {
                label: 'Cancel',
                action: function (dialog) {
                    dialog.close();
                }
            }]
    });
}

function showStudentUpdateMsg(studentId) {
    dialogInstance = new BootstrapDialog();
    dialogInstance.setTitle('Update Message');
    dialogInstance.setMessage("Entry Updated!, Student Id is " + studentId);
    dialogInstance.setType(BootstrapDialog.TYPE_SUCCESS);
    dialogInstance.open();

    setTimeout(function () {
        $("#ref-no").val(studentId);
        dialogInstance.close();
    }, 3000);

}


function clearDetailPage() {
    $("#txtStudentReffNumber").val("");
    $("#txtApplicationNumber").val("");
    $("#sltCourse").val("");
    $("#sltBatchId").val("");
    $("#sltClassId").val("");
    $("#sltStudentCategory").val("");
    $("#sltHouse").val("");
    $("#txtTitle").val("");
    $("#txtNIC").val("");
    $("#sltGender").val("");
    $("#txtPassport").val("");
    $("#txtDrivingLicense").val("");
    $("#txtFirstName").val("");
    $("#txtMiddleName").val("");
    $("#txtLastName").val("");
    $("#txtDob").val("");
    $("#txtAge").val("");
    $("#sltBloodGroup").val("O+");
    $("#sltReligion").val("");
    $("#sltLanguage").val("");
    $("#txtPersonalAddress1").val("");
    $("#txtPersonalAddress2").val("");
    $("#sltPersonalCountry").val("");
    $("#sltPersonalProvince").val("");
    $("#sltPersonalCity").val("");
    $("#txtPostalAddress1").val("");
    $("#txtPostalAddress2").val("");
    $("#sltPostalCountry").val("");
    $("#sltPostalProvince").val("");
    $("#sltPostalCity").val("");
    $("#contact-1").val("");
    $("#contact-2").val("");
    $("#email-personal").val("");
    $("#email-college").val("");
    $("#email").val("");
    $("#fax").val("");
    $("#emergency-name").val("");
    $("#emergency-number").val("");
    $("#emergency-relationship").val("");
}

function emgOperateFormatter(value, row, index) {
    return [
        '<a class="emgedit ml10" href="javascript:void(0)" title="Edit">',
        '<i class="glyphicon glyphicon-pencil"></i>',
        '</a>',
        '<a class="emgremove ml10" href="javascript:void(0)" title="Remove">',
        '<i class="glyphicon glyphicon-trash"></i>',
        '</a>'
    ].join('');
}


window.emgOperateEvents = {
    'click .emgedit': function (e, value, row, index) {
        setPreviousData(row, index);
    },
    'click .emgremove': function (e, value, row, index) {
        if (row.previousSchoolId == "") {
            removeTable("#previous-school-table", row);
        }
        else {
            BootstrapDialog.show({
                title: 'Delete Message',
                type: BootstrapDialog.TYPE_SUCCESS,
                message: "Are you sure you want to delete the data?",
                buttons: [{
                        label: 'Yes',
                        cssClass: 'btn-success',
                        action: function (dialog) {
                            var data = {
                                prevRefId: row.previousSchoolId
                            };
                            data = ajaxData("student/delete-prev", "POST", data, token);
                            if (data.success == "true") {
                                removeTable("#previous-school-table", row);
                                dialog.close();
                            }

                        }

                    }
                    , {
                        label: 'Cancel',
                        action: function (dialog) {
                            dialog.close();
                        }
                    }]
            });
        }
    }
}

function setPreviousData(row, index) {
    $('#previous-school').val(row.previousSchool);
    $("#reason").val(row.reasonForLeaving);
    $("#add").text("Update");
    editRowData = row;
    setIndex = index;
}


$("#language1").change(function () {
    $('#language2').empty();
    setLanguageList("#language2");
    //hide selected value from language2 dropdown
    if ($(this).val() !== "N/A") {
        $("#language2 option[value='" + $(this).val() + "']").detach();
    }
});

$("#title").change(function () {
    console.log($(this).val());
    //set gender according to title
    if ($(this).val() == 'Mr.') {
        $("#male").prop('checked', true);
    } else {
        $("#female").prop('checked', true);
    }

});

