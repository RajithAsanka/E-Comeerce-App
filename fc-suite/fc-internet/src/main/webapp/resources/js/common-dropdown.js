//################### PAGE LOADS ##############################################

function setGeneratedYear(htmlId, startYear, endYear) {
    $(htmlId).empty().append('<option selected="selected" value="" >Select Year</option>');
    for (var i = endYear; i > startYear; i--) {
        $(htmlId).append('<option value="' + i + '">' + i + '</option>');
    }
}

function setMonth(htmlId) {
    var month = ["January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"];

    for (var i = 0; i < month.length; ++i) {
        $(htmlId).append('<option value="' + month[i] + '">' + month[i] + '</option>');
    }
}

function setEventFromTo(fromId, toId, fromYear, toYear) {
    $(fromId).change(function () {
        var temp = $(toId).val();
        if ($(fromId).val() == "") {
            setGeneratedYear(toId, fromYear, toYear);
        } else if ($(toId).val() == $(fromId).val()) {

        } else {
            setGeneratedYear(toId, $(fromId).val(), toYear);
        }
        $(toId).val(temp);
    });

    $(toId).change(function () {
        var temp = $(fromId).val();
        if ($(toId).val() == "") {
            setGeneratedYear(fromId, fromYear, toYear);
        } else if ($(toId).val() == temp) {
            setGeneratedYear(fromId, fromYear, toYear);
        } else {
            setGeneratedYear(fromId, fromYear, $(toId).val());
        }
        $(fromId).val(temp);
    });
}

function setSalutaionList(htmlId) {
    $.ajax({
        type: "GET",
        url: "salutaionList",
        async: false,
        success: function (data) {
            // $(htmlId).empty().append(
            // '<option value="" >Select Title</option>');
            $.each(data, function (i, item) {
                if (item.value == "Mr")
                    $(htmlId).append(
                            '<option selected="selected" value="' + item.value
                            + '" >' + item.displayText + '</option>');
                else
                    $(htmlId).append(
                            '<option  value="' + item.value + '" >'
                            + item.displayText + '</option>');
            });
        },
        error: function () {
            alert("Failed to load ");
        }
    });
}

function setBloodGroupList(htmlId) {
    $.ajax({
        type: "GET",
        url: "bloodGroupList",
        async: false,
        success: function (data) {
            $(htmlId).empty().append(
                    '<option value="" >Select BloodGroup</option>');
            $.each(data, function (i, item) {
                if (item.value == "O+")
                    $(htmlId).append(
                            '<option selected="selected" value="' + item.value
                            + '" >' + item.displayText + '</option>');
                else
                    $(htmlId).append(
                            '<option  value="' + item.value + '" >'
                            + item.displayText + '</option>');
            });
        },
        error: function () {
            alert("Failed to load ");
        }
    });
}

function setNationalistyList(htmlId) {
    $.ajax({
        type: "GET",
        url: "nationalityList",
        async: false,
        success: function (data) {
            // $(htmlId).empty().append(
            // '<option value="" >Select Nationality</option>');
            $.each(data, function (i, item) {
                if (item.value == "Sri Lankan")
                    $(htmlId).append(
                            '<option selected="selected" value="' + item.value
                            + '" >' + item.displayText + '</option>');
                else
                    $(htmlId).append(
                            '<option  value="' + item.value + '" >'
                            + item.displayText + '</option>');
            });
        },
        error: function () {
            alert("Failed to load ");
        }
    });
}

function setReligionList(htmlId) {
    $.ajax({
        type: "GET",
        url: "religionList",
        async: false,
        success: function (data) {
            $.each(data, function (i, item) {
                if (item.value == "Buddhist")
                    $(htmlId).append(
                            '<option selected="selected" value="' + item.value
                            + '" >' + item.displayText + '</option>');
                else
                    $(htmlId).append(
                            '<option  value="' + item.value + '" >'
                            + item.displayText + '</option>');
            });
        },
        error: function () {
            alert("Failed to load ");
        }
    });
}

function setLanguageList(htmlId) {
    $.ajax({
        type: "GET",
        url: "languageList",
        async: false,
        success: function (data) {
            // $(htmlId).empty().append(
            // '<option value="" >Select Lanaguage</option>');
            $.each(data, function (i, item) {
                if (item.value == "English") {
                    $(htmlId).append(
                            '<option selected="selected" value="' + item.value
                            + '" >' + item.displayText + '</option>');
                } else {
                    $(htmlId).append(
                            '<option  value="' + item.value + '" >'
                            + item.displayText + '</option>');
                }
            });
        },
        error: function () {
            alert("Failed to load ");
        }
    });
}

function setDepartmentList(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "departmentList",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Department</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setDepartmentTypeList(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "departmentTypeList",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Department Type</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setCountryListAndOthersEdit(htmlId, provinceHtmlId, cityHtmlId, country, province) {
    $.ajax({
        type: "GET",
        url: "countryList",
        async: false,
        success: function (data) {
            $.each(data, function (i, item) {
                if (item.value == "Sri Lanka")
                    $(htmlId).append(
                            '<option selected="selected"  value="' + item.value
                            + '" >' + item.displayText + '</option>');
                else
                    $(htmlId).append(
                            '<option  value="' + item.value + '" >'
                            + item.displayText + '</option>');
            });
        },
        error: function () {
            alert("Failed to load ");
        }
    });
    setProvinceList(provinceHtmlId, country);
    setCityList(cityHtmlId, province);
}

function setCountryListAndOthers(htmlId, auto, provinceHtmlId, cityHtmlId) {
    $.ajax({
        type: "GET",
        url: "countryList",
        async: false,
        success: function (data) {
            // $(htmlId)
            // .empty()
            // .append(
            // '<option selected="selected" value="" >Select Country</option>');
            $.each(data, function (i, item) {
                if (item.value == "Myanmar")
                    $(htmlId).append(
                            '<option selected="selected"  value="' + item.value
                            + '" >' + item.displayText + '</option>');
                else
                    $(htmlId).append(
                            '<option  value="' + item.value + '" >'
                            + item.displayText + '</option>');
            });
        },
        error: function () {
            alert("Failed to load ");
        }
    });
    if (auto) {
        setProvinceList(provinceHtmlId, "Myanmar");
        setCityList(cityHtmlId, "Yangon Region");
    }
}


function setCountryList(htmlId) {
    $.ajax({
        type: "GET",
        url: "countryList",
        async: false,
        success: function (data) {
            //$(htmlId).empty();
            // .append(
            // '<option selected="selected" value="" >Select Country</option>');
            $.each(data, function (i, item) {
                if (item.value == "Myanmar") {
                    $(htmlId).append('<option selected="selected"  value="' + item.value + '" >' + item.displayText + '</option>');
                }
                else {
                    $(htmlId).append('<option value="' + item.value + '" >' + item.displayText + '</option>');
                }
            });
        },
        error: function () {
            alert("Failed to load ");
        }
    });
}

function setProvinceList(htmlId, country) {
    $.ajax({
        type: "GET",
        url: "provinceList",
        async: false,
        data: {
            countryId: country
        },
        success: function (data) {
            $(htmlId).empty();
            $.each(data, function (i, item) {
                if (item.value == "Yangon Region") {
                    $(htmlId).append(
                            '<option selected="selected" value="' + item.value
                            + '" >' + item.displayText + '</option>');
                } else {
                    $(htmlId).append(
                            '<option  value="' + item.value + '" >'
                            + item.displayText + '</option>');
                }
            });
        },
        error: function () {
            alert("Failed to load ");
        }
    });
}

function onChangeCountry(provinceHtmlId, countryHtmlId) {
    $(countryHtmlId).change(function () {
        var country = $(countryHtmlId).val();
        setProvinceList(provinceHtmlId, country);
        $(provinceHtmlId).change();
    });
}

function setCityList(htmlId, province) {
    $.ajax({
        type: "GET",
        url: "cityList",
        async: false,
        data: {
            provinceId: province
        },
        success: function (data) {
            $(htmlId).empty();
            $.each(data, function (i, item) {
                if (item.value == "Yangon") {
                    $(htmlId).append(
                            '<option selected="selected" value="' + item.value
                            + '" >' + item.displayText + '</option>');
                } else {
                    $(htmlId).append(
                            '<option  value="' + item.value + '" >'
                            + item.displayText + '</option>');
                }
            });
        },
        error: function () {
            alert("Failed to load ");
        }
    });
}

function onChangeProvince(cityHtmlId, provinceHtmlId) {
    $(provinceHtmlId).change(function () {
        var province = $(provinceHtmlId).val();
        setCityList(cityHtmlId, province);
    });
}

function setEmployeeCatogeryList(htmlId) {
    $
            .ajax({
                type: "GET",
                async: false,
                url: "employeeCategoryList",
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Employee Catogery</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setAchievementCatogeryList(htmlId) {
    $
            .ajax({
                type: "GET",
                async: false,
                url: "achievementCategoryList",
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Achievement Catogery</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.achivementCategory
                                + '" >' + item.achivementCategory
                                + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setAchievementTypeList(htmlId) {
    $
            .ajax({
                type: "GET",
                async: false,
                url: "achievementTypeList",
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Achievement Type</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value
                                + '" >' + item.displayText
                                + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setActivityCatogeryList(htmlId) {
    $
            .ajax({
                type: "GET",
                async: false,
                url: "activityCategoryList",
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Activity Catogery</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.activityCategory
                                + '" >' + item.activityCategory
                                + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setActivityTypeList(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "activityTypeList",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Activity Type</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}
function setAttachmentTypeList(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "attachmentTypeList",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Attachment Type</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}




function setBatchCategoryList(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "batchCategoryList",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Batch Category</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append('<option  value="' + item.value + '" >' + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setBatchList(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "batchList",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Batch</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setClassCategoryList(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "classCategoryList",
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Class Category</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.classCategory + '" >'
                                + item.classCategory + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setClassList(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "classList",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Class</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setContactCategoryList(htmlId) {
    $.ajax({
        type: "GET",
        url: "contactCategoryList",
        success: function (data) {
            $(htmlId).empty().append(
                    '<option value="" >Select Contact Category</option>');
            $.each(data, function (i, item) {
                if (item.contactCategory == "Primary") {
                    $(htmlId).append(
                            '<option selected="selected" value="'
                            + item.contactCategory + '" >'
                            + item.contactCategory + '</option>');
                } else {
                    $(htmlId).append(
                            '<option  value="' + item.contactCategory + '" >'
                            + item.contactCategory + '</option>');
                }
            });
        },
        error: function () {
            alert("Failed to load ");
        }
    });
}

function setContactTypeList(htmlId) {
    $.ajax({
        type: "GET",
        url: "contactList",
        success: function (data) {
            $(htmlId).empty().append(
                    '<option value="" >Select Contact Type</option>');
            $.each(data, function (i, item) {
                if (item.contactType == "Mobile") {
                    $(htmlId).append(
                            '<option selected="selected"  value="'
                            + item.contactType + '" >'
                            + item.contactType + '</option>');
                } else {
                    $(htmlId).append(
                            '<option  value="' + item.contactType + '" >'
                            + item.contactType + '</option>');
                }
            });
        },
        error: function () {
            alert("Failed to load ");
        }
    });
}

function setCourseCategoryList(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "courseCategoryList",
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Program Category</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value
                                + '" >' + item.displayText
                                + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setCourseList(htmlId) {
    $.ajax({
        type: "GET",
        url: "courseList",
        async: false,
        success: function (data) {
            $(htmlId).empty().append(
                    '<option  value="" >Select Curriculum</option>');
            $.each(data, function (i, item) {
                $(htmlId).append(
                        '<option   value="' + item.value + '" >'
                        + item.displayText + '</option>');
            });
        },
        error: function () {
            alert("Failed to load ");
        }
    });
}

function setExamTypes(htmlId) {
    $.ajax({
        type: "GET",
        url: "examTypeList",
        async: false,
        success: function (data) {
            $(htmlId).empty().append(
                    '<option  value="" >Select Exam Type</option>');
            $.each(data, function (i, item) {
                $(htmlId).append(
                        '<option   value="' + item.value + '" >'
                        + item.displayText + '</option>');
            });
        },
        error: function () {
            alert("Failed to load ");
        }
    });
}

function setDegreeAwardStatusList(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "degreeawardStatusList",
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Degree Award Status</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.degreeawardStatusId
                                + '" >' + item.degreeawardStatusId
                                + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setEducationQualificationTypeList(htmlId) {
    $.ajax({
        type: "GET",
        url: "educationQualificationTypeList",
        success: function (data) {
            $(htmlId)
                    .empty()
                    .append(
                            '<option selected="selected" value="" >Select Education Qualification Type</option>');
            $.each(data, function (i, item) {
                $(htmlId).append('<option  value="' + item.value + '" >' + item.displayText + '</option>');
            });
        },
        error: function () {
            alert("Failed to load ");
        }
    });
}

function setParentGuardianTypeList(htmlId) {
    $.ajax({
        type: "GET",
        url: "parentGuardianTypeList",
        success: function (data) {
            // $(htmlId)
            // .empty()
            // .append(
            // '<option value="" >Select Parent Guardian Type</option>');
            $.each(data, function (i, item) {
                if (item.parentGuardianType == "Father") {
                    $(htmlId).append(
                            '<option selected="selected"  value="'
                            + item.parentGuardianType + '" >'
                            + item.parentGuardianType + '</option>');
                } else {
                    $(htmlId).append(
                            '<option  value="' + item.parentGuardianType
                            + '" >' + item.parentGuardianType
                            + '</option>');
                }

            });
        },
        error: function () {
            alert("Failed to load ");
        }
    });
}

function setScholarshipTypeList(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "scholarshipTypeList",
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Scholarship Type</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value
                                + '" >' + item.displayText
                                + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setScholarshipDonarList(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "sponsorDetailsList",
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Sponsor</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value
                                + '" >' + item.displayText
                                + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}
function setSiblingTypeList(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "siblingTypeList",
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Sibling Type</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setStudentCategoryList(htmlId) {
    $.ajax({
        type: "GET",
        url: "studentCategoryList",
        async: false,
        success: function (data) {
            $(htmlId).empty().append(
                    '<option value="" >Select Student Category</option>');
            $.each(data, function (i, item) {
                if (item.studentCategoryId == "Local")
                    $(htmlId).append(
                            '<option selected="selected"  value="' + item.value
                            + '" >' + item.displayText + '</option>');
                else
                    $(htmlId).append(
                            '<option  value="' + item.value + '" >'
                            + item.displayText + '</option>');
            });
        },
        error: function () {
            alert("Failed to load ");
        }
    });
}
function setStudentList(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "${pageContext.request.contextPath}/admin/studentList",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Student</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.studentId + '" >'
                                + item.studentId + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setEmployeeList(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "employeeList",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append('<option  value="" >Select Employee</option>');

                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load emp");
                }
            });
}

function setClassHeadList(htmlId, classId) {
    $
            .ajax({
                type: "GET",
                data: {
                    classId: classId
                },
                url: "classHeadList",
                dataType: "json",
                context: this,
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append('<option  value="" >Select Class Head</option>');

                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load emp");
                }
            });
}


function setEmployeeListWithDefault(htmlId, value, display) {
    $
            .ajax({
                type: "GET",
                url: "employeeList",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option  value="' + value + '" >'
                                    + display + '</option>');

                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load emp");
                }
            });
}

function setReportingEmployeeList(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "reportingEmployeeList",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append('<option selected="selected" value="" >Select Employee</option>');

                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load emp");
                }
            });
}


function setJotTitleList(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "jotTitleList",
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Job Title</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

// function setInstituteTypeList(htmlId) {
// $
// .ajax({
// type : "GET",
// url : "institueTypeList",
// success : function(data) {
// $(htmlId)
// .empty()
// .append(
// '<option selected="selected" value="" >Select Institute Type</option>');
// $.each(data, function(i, item) {
// $(htmlId).append(
// '<option value="' + item.instituteTypeId
// + '" >' + item.instituteType
// + '</option>');
// });
// },
// error : function() {
// alert("Failed to load ");
// }
// });
// }

function setInstituteList(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "institueList",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Institute</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setAreaOfExpertiseList(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "areaOfExpertiseList",
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Area of Study</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append('<option value="' + item.value + '" >' + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}


function setAreaOfExpertiseActivityList(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "areaOfExpertiseActivityList",
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Activity</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append('<option value="' + item.value + '" >' + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setModuleCategoryItems(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "moduleCategoryList",
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Module Category</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value
                                + '" >' + item.displayText
                                + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setEmployeeModuleList(htmlId, moduleId) {
    $.ajax({
        type: "GET",
        url: "employeeModuleList",
        async: false,
        data: {
            moduleId: moduleId
        },
        success: function (data) {
            $(htmlId).empty().append('<option selected="selected" value="Select Employee" >Select Employee</option>');
            $.each(data, function (i, item) {
                $(htmlId).append(
                        '<option  value="' + item.value + '" >'
                        + item.displayText + '</option>');

            });
        },
        error: function () {
            alert("Failed to load ");
        }
    });
}

// ############ OPTIONS #####################################################

function setLevels(htmlId) {
    $.ajax({
        type: "GET",
        url: "levelList",
        async: false,
        success: function (data) {
            $(htmlId)
                    .empty()
                    .append('<option selected="selected" value="" >Select Level</option>');

            $.each(data, function (i, item) {
                $(htmlId).append(
                        '<option  value="' + item.value + '" >'
                        + item.displayText + '</option>');
            });
        },
        error: function () {
            alert("Failed to load ");
        }
    });
}

function setModuleOptions(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "getModuleOptions",
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Module</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setModuleOptionsByCourse(htmlId, courseId) {
    $
            .ajax({
                type: "GET",
                url: "getModuleOptionsByCourse",
                data: {
                    courseId: courseId
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Module</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setModuleOptionsByCourseAndSemster(htmlId, courseId, semesterId) {
    $
            .ajax({
                type: "GET",
                url: "getModuleOptionsByCourseAndSemester",
                data: {
                    courseId: courseId,
                    semesterId: semesterId
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Module</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setCourseOptions(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "getCourseOptions",
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Course</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setCourseOptionsByBatch(htmlId, batchId) {
    $
            .ajax({
                type: "GET",
                url: "getCourseOptionsByBatch",
                data: {
                    batchId: batchId
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Course</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setSemesterOptions(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "getSemesterOptions",
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append('<option selected="selected" value="Select Semester" >Select Semester</option>');

                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setBatchOptions(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "getBatchOptions",
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Batch</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setModuleList(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "moduleList",
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append('<option selected="selected" value="" >Select Module</option>');

                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setModuleOptionsbyCourseAndBatch(htmlId, courseId, batchId) {
    $
            .ajax({
                type: "GET",
                url: "courseBatchModuleSemesterLinkGetModuleOptions",
                data: {
                    courseId: courseId,
                    batchId: batchId
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Module</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setBatchOptionsbyCourse(htmlId, courseId) {
    $
            .ajax({
                type: "GET",
                url: "getBatchOptionsByCourse",
                data: {
                    courseId: courseId
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Batch</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setModulesOptionsbyCourseAndBatchAndLevel(htmlId, courseId, batchId, levelId) {
    $
            .ajax({
                type: "GET",
                url: "getModuleOptionsByCourseAndBatchAndLevel",
                data: {
                    courseId: courseId,
                    batchId: batchId,
                    levelId: levelId
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Subject</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setClassIdOptionsbyCourseAndBatch(htmlId, courseId, batchId) {
    $
            .ajax({
                type: "GET",
                url: "getClassOptionsByCourseAndBatch",
                data: {
                    courseId: courseId,
                    batchId: batchId
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Class</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setDayOptionsbyCourseAndBatchAndClass(htmlId, courseId, batchId,
        classId) {
    $
            .ajax({
                type: "GET",
                url: "getDayOptionsByCourseAndBatchAndClass",
                data: {
                    courseId: courseId,
                    batchId: batchId,
                    classId: classId
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Day</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setTopicOptionsByModule(htmlId, batchId, courseId, classId, sDate) {
    $
            .ajax({
                type: "GET",
                url: "student-attendance/get-by-module-date-by-coursebatchclassdate",
                data: {
                    batch: batchId,
                    course: courseId,
                    classId: classId,
                    sDate: sDate
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Module</option>');
                    $
                            .each(
                                    data,
                                    function (i, item) {
                                        $(htmlId)
                                                .append(
                                                        '<option  value="'
                                                        + item.timetableModule.module.moduleId
                                                        + '" >'
                                                        + item.timetableModule.module.moduleName
                                                        + '</option>');
                                    });
                },
                error: function () {
                    alert("You should enter work to do in timetable create");
                }
            });
}

function setTimetOptionsByCourseBatchClassDateModuleId(htmlId, batchId,
        courseId, classId, moduleId, sDate) {
    $
            .ajax({
                type: "GET",
                url: "student-attendance/get-by-module-time-by-coursebatchclassdatemodule",
                data: {
                    batch: batchId,
                    course: courseId,
                    classId: classId,
                    moduleId: moduleId,
                    sDate: sDate
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Module</option>');
                    $
                            .each(
                                    data,
                                    function (i, item) {
                                        $(htmlId)
                                                .append(
                                                        '<option  value="'
                                                        + item.moduleTopicPK.topicSubTopicLinkId
                                                        + '" >'
                                                        + item.moduleTopicPK.moduleStartTime
                                                        + '</option>');
                                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}
// ####################################### sayyaff
// ##########################################################
function setExamTypeList(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "examTypeList",
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Examination Type</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option value="' + item.examType + '" >'
                                + item.examType + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setAcademicLevelOptionsByCourse(htmlId, courseId) {
    $
            .ajax({
                type: "GET",
                url: "academicLevelList",
                data: {
                    courseId: courseId
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Academic Level</option>');
                    $
                            .each(
                                    data,
                                    function (i, item) {
                                        if (!isOptionValueDuplicate(
                                                htmlId,
                                                item.courseModuleSemesterPK.academicLevelId)) {
                                            $(htmlId)
                                                    .append(
                                                            '<option value="'
                                                            + item.courseModuleSemesterPK.academicLevelId
                                                            + '" >'
                                                            + item.courseModuleSemesterPK.academicLevelId
                                                            + '</option>');
                                        }
                                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setSemesterOptionsByAcademicLevel(htmlId, academicLevel) {
    $
            .ajax({
                type: "GET",
                url: "semesterList",
                data: {
                    academicLevel: academicLevel
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Semester</option>');
                    $
                            .each(
                                    data,
                                    function (i, item) {
                                        if (!isOptionValueDuplicate(
                                                htmlId,
                                                item.courseModuleSemesterPK.semesterId)) {
                                            $(htmlId)
                                                    .append(
                                                            '<option value="'
                                                            + item.courseModuleSemesterPK.semesterId
                                                            + '" >'
                                                            + item.courseModuleSemesterPK.semesterId
                                                            + '</option>');
                                        }
                                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setModuleOptionsByCourseAcademicLevelSemester(htmlId, academicLevel,
        courseId, semesterId) {
    $
            .ajax({
                type: "GET",
                url: "ModuleListByCourseAcademicSemester",
                data: {
                    courseId: courseId,
                    semesterId: semesterId,
                    academicLevel: academicLevel
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Module</option>');
                    $
                            .each(
                                    data,
                                    function (i, item) {
                                        if (!isOptionValueDuplicate(
                                                htmlId,
                                                item.courseModuleSemesterPK.moduleId)) {
                                            $(htmlId)
                                                    .append(
                                                            '<option value="'
                                                            + item.courseModuleSemesterPK.moduleId
                                                            + '" >'
                                                            + item.courseModuleSemesterPK.moduleId
                                                            + '</option>');// item.courseModuleLink.module.moduleName
                                            // +
                                            // '</option>');
                                        }
                                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setExamList(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "examList",
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Exam</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option value="' + item.examCode + '" >'
                                + item.examName + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}
// ############################# SAYYAFF
// #################################################

function setHomeWorkType(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "homeWorkTypeList",
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Homework Type</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option value="' + item.homeWorkType + '" >'
                                + item.homeWorkType + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setHomeWorkTypeByCourseBatchClassAcademicSemesterModule(htmlId,
        courseId, batchId, classId, academicLevel, semester, moduleId) {
    $
            .ajax({
                type: "GET",
                url: "homeWorkList",
                data: {
                    courseId: courseId,
                    batchId: batchId,
                    classId: classId,
                    academicLevel: academicLevel,
                    semester: semester,
                    moduleId: moduleId
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Homework Type</option>');
                    $.each(data, function (i, item) {
                        if (!isOptionValueDuplicate(htmlId,
                                item.homeWorkPK.homeWorkType)) {
                            $(htmlId).append(
                                    '<option value="'
                                    + item.homeWorkPK.homeWorkType
                                    + '" >'
                                    + item.homeWorkPK.homeWorkType
                                    + '</option>');
                        }
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setExamCodeByCourseBatchClass(htmlId, courseId, batchId, classId,
        academicLevel, semester) {
    $
            .ajax({
                type: "GET",
                url: "examListByExamCode",
                data: {
                    courseId: courseId,
                    batchId: batchId,
                    classId: classId,
                    academicLevel: academicLevel,
                    semester: semester,
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Exam Code</option>');
                    $.each(data, function (i, item) {
                        if (!isOptionValueDuplicate(htmlId,
                                item.examinationCoursePK.examCode)) {
                            $(htmlId).append(
                                    '<option value="'
                                    + item.examinationCoursePK.examCode
                                    + '" >'
                                    + item.examinationCoursePK.examCode
                                    + '</option>');
                        }
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setHomeWorkTypeByHomeWorkType(htmlId, homeWorkType) {
    $
            .ajax({
                type: "GET",
                url: "homeWorkSerialByHwTypeList",
                data: {
                    homeWorkType: homeWorkType
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Homework Serial</option>');
                    $.each(data, function (i, item) {
                        if (!isOptionValueDuplicate(htmlId,
                                item.homeWorkPK.homeWorkSerial)) {
                            $(htmlId).append(
                                    '<option value="'
                                    + item.homeWorkPK.homeWorkSerial
                                    + '" >'
                                    + item.homeWorkPK.homeWorkSerial
                                    + '</option>');
                        }
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setStudentByHomeWorkPk(htmlId, homeWorkType, homeWorkSerial) {
    $
            .ajax({
                type: "GET",
                url: "studenthomeWorkMasterListByHomeWorkType",
                data: {
                    homeWorkType: homeWorkType,
                    homeWorkSerial: homeWorkSerial
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Student</option>');
                    $
                            .each(
                                    data,
                                    function (i, item) {
                                        if (!isOptionValueDuplicate(
                                                htmlId,
                                                item.studentHomeWorkMasterPK.studentId)) {
                                            $(htmlId)
                                                    .append(
                                                            '<option value="'
                                                            + item.studentHomeWorkMasterPK.studentId
                                                            + '" >'
                                                            + item.student.firstName
                                                            + " "
                                                            + item.student.lastName
                                                            + '</option>');
                                        }
                                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setExamListByExamType(htmlId, examType) {
    $
            .ajax({
                type: "GET",
                url: "examListByExamType",
                data: {
                    examType: examType
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Exam Serial</option>');
                    $.each(data, function (i, item) {
                        if (!isOptionValueDuplicate(htmlId, item.examCode)) {
                            $(htmlId).append(
                                    '<option value="' + item.examCode + '" >'
                                    + item.examName + '</option>');
                        }
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setExamListByExamCode(htmlId, examCode) {
    $
            .ajax({
                type: "GET",
                url: "examWorkSerialByExamCodeList",
                data: {
                    examCode: examCode
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Exam Serial</option>');
                    $
                            .each(
                                    data,
                                    function (i, item) {
                                        if (!isOptionValueDuplicate(
                                                htmlId,
                                                item.examinationCoursePK.examinationSerialNo)) {
                                            $(htmlId)
                                                    .append(
                                                            '<option value="'
                                                            + item.examinationCoursePK.examinationSerialNo
                                                            + '" >'
                                                            + item.examinationCoursePK.examinationSerialNo
                                                            + '</option>');
                                        }
                                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

// ####################################################################################################

// ################################## Scholarship Type List
// ###################################

function setScholarshipType(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "scholarship-type/get-select-options",
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Scholarship Type</option>');
                    $.each(data, function (i, item) {
                        console.log(item.value);
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setScholarshipCodeForType(htmlId, scholarshipSponsorHtml) {


}

function setScholarshipTypeSponsorName(scholarshipTypeHtml, scholarshipCodeHtml, scholarshipSponsorHtml) {
    setScholarshipTypeList(scholarshipTypeHtml);
    setScholarshipCode(scholarshipCodeHtml);
    setScholarshipDonarList(scholarshipSponsorHtml);

    $(scholarshipTypeHtml).change(function () {
        $.ajax({
            type: "GET",
            url: "scholarshipCodeForType",
            data: {
                id: $(scholarshipTypeHtml).val()
            },
            success: function (data) {
                $(scholarshipSponsorHtml).empty().append('<option selected="selected" value="" >Select Sponsor Name</option>');
                $.each(data, function (i, item) {
                    $(scholarshipSponsorHtml).append('<option value=\'' + JSON.stringify(item.value) + '\'>' + item.displayText + '</option>');
                });
            },
            error: function () {
                alert("Failed to load ");
            }
        });
    });

    $(scholarshipSponsorHtml).change(function () {
        var temp = JSON.parse($(scholarshipSponsorHtml).val());
        console.log(temp);
        $("#yearStart").val(temp.startDate);
        $("#yearEnd").val(temp.endDate);
    });
}

function setScholarshipTypeCodeName(scholarshipTypeHtml, scholarshipCodeHtml, scholarshipSponsorHtml) {
    setScholarshipTypeList(scholarshipTypeHtml);
    setScholarshipDonarList(scholarshipSponsorHtml);

    $(scholarshipTypeHtml).change(function () {
        $.ajax({
            type: "GET",
            url: "scholarshipCodeForType",
            data: {
                id: $(scholarshipTypeHtml).val()
            },
            success: function (data) {
                $(scholarshipCodeHtml).empty().append('<option selected="selected" value="" >Select Scholarship Name</option>');
                $.each(data, function (i, item) {
                    $(scholarshipCodeHtml).append('<option value=\'' + JSON.stringify(item.value) + '\'>' + item.displayText + '</option>');
                });
            },
            error: function () {
                alert("Failed to load ");
            }
        });
    });

    $(scholarshipCodeHtml).change(function () {
        item = JSON.parse($(scholarshipCodeHtml).val());
        $(scholarshipSponsorHtml).val(item.donorId);
    });
}

// ################################### Scholarship List
// #######################################

function setScholarshipCode(htmlId) {
    $.ajax({
        type: "GET",
        url: "scholarshipCodeList",
        async: false,
        success: function (data) {
            $(htmlId).empty().append('<option selected="selected" value="" >Select Scholarship Name</option>');
            $.each(data, function (i, item) {
                $(htmlId).append(
                        '<option  value="' + item.value + '" >' + item.displayText + '</option>');
            });
        },
        error: function () {
            alert("Failed to load ");
        }
    });
}


function setScholarshipCodeIdList(htmlId) {
    $.ajax({
        type: "GET",
        url: "scholarshipCodeIdList",
        async: false,
        success: function (data) {
            $(htmlId).empty().append('<option selected="selected" value="" >Select Scholarship Name</option>');
            $.each(data, function (i, item) {
                $(htmlId).append(
                        '<option  value="' + item.value + '" >' + item.displayText + '</option>');
            });
        },
        error: function () {
            alert("Failed to load ");
        }
    });
}


function setScholarshipOptionsbyScholarshipType(htmlId, type) {
    $
            .ajax({
                type: "GET",
                url: "scholarship-details/getScholarshipOptionsbyScholarshipType",
                data: {
                    type: type
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Scholarship</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

// ################################### Sponsorship List
// #######################################

function setSponsorshipCode(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "sponsorship-details/get-select-options",
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Sponsorship Code</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

// ################################## Donor - Scholarship - Link
// ##############################

// Get Sponsor list from Donor-Schlarship-Link
function setSponsorOptionByDonorScholarship(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "sponsorship-scholarship-detail/get-sponsor-options",
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Event Type</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

// Get Scholarship Type list from Donor-Schlarship-Link
function setScholarshipTypeOptionByDonorScholarship(htmlId, donorId) {
    $
            .ajax({
                type: "GET",
                url: "sponsorship-scholarship-detail/get-scholarship-type-options",
                data: {
                    donorId: donorId
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Event Type</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

// Get Scholarship list from Donor-Schlarship-Link
function setScholarshipOptionByDonorScholarship(htmlId, donorId,
        scholarshipType) {
    $
            .ajax({
                type: "GET",
                url: "sponsorship-scholarship-detail/get-scholarship-options",
                data: {
                    donorId: donorId,
                    scholarshipType: scholarshipType
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Event Type</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

/*
 * ###################################### Club Management
 * #############################################
 */

function setClubType(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "club-type/get-select-options",
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Club Type</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setMemberType(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "club-member-type/get-select-options",
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Club Member Type</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setInitiativeType(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "initiative-type/get-select-options",
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Club Initiative Type</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

// Get Club Type List
function setClubID(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "club-details/get-select-options",
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Club ID</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

/*
 * ############################ FEE MANAGEMENT
 * #######################################
 */

function setFeeType(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "${pageContext.request.contextPath}/admin/getFeeTypeList",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Fee Type</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.feeType + '" >'
                                + item.feeType + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setFeeCategory(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "${pageContext.request.contextPath}/admin/getFeeCategoryList",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Fee Category</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.feeCategory + '" >'
                                + item.feeCategory + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setFee(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "${pageContext.request.contextPath}/admin/getFee",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Fee</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.feeCode + '" >'
                                + item.feeCode + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setFeeFine(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "${pageContext.request.contextPath}/admin/getFineList",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Fee Fine</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.fineCode + '" >'
                                + item.fineCode + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setPaymentSchedule(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "${pageContext.request.contextPath}/admin/getPaymentScheduleList",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Payment Schedule</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="'
                                + item.feePaymentSchedulePK.scheduleId
                                + '" >'
                                + item.feePaymentSchedulePK.scheduleId
                                + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setFeeGroup(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "${pageContext.request.contextPath}/admin/getFeeGroupList",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Fee Group</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.feeEntitleGroupId
                                + '" >' + item.feeEntitleGroupId
                                + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setFeeRebate(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "${pageContext.request.contextPath}/admin/getFeeRebateList",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Fee Rebate</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.feeRebateId + '" >'
                                + item.feeRebateId + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setFeeCodeByScheduleId(htmlId, scheduleId) {
    $
            .ajax({
                type: "GET",
                url: "fee-payment-schedule/fee-payment-schedule/getFeeCodeByScheduleId",
                async: false,
                data: {
                    scheduleId: scheduleId
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Fee Code</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

// ///////////////////////////// Internship Management
// ///////////////////////////////////////////

function setOrganizationType(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "getOrganizationTypeList",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Organization Type</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.organizationType
                                + '" >' + item.organizationType
                                + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setOrganizationSector(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "getOrganizationSectorList",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Organization Sector</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.organizationSector
                                + '" >' + item.organizationSector
                                + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setOrganization(htmlId) {
    $.ajax({
        type: "GET",
        url: "getOrganizationList",
        async: false,
        success: function (data) {
            $(htmlId)
                    .empty()
                    .append(
                            '<option selected="selected" value="" >Select Organization</option>');
            $.each(data, function (i, item) {
                $(htmlId).append(
                        '<option  value="' + item.value
                        + '" >' + item.displayText
                        + '</option>');
            });
        },
        error: function () {
            alert("Failed to load ");
        }
    });
}

// /////////////////// Discipline Management
// ///////////////////////////////////////////////////////

function setDisciplineCategory(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "getDisciplineCategoryList",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Discipline Category</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.disciplineCategory
                                + '" >' + item.disciplineCategory
                                + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setDisciplineReference(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "getDisciplineRefList",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Discipline Reference</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.disciplineReferenceId
                                + '" >' + item.disciplineReferenceId
                                + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setSemester(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "semesterList",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="Select Semester" >Select Semester</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value
                                + '" >' + item.displayText
                                + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setSemesterByLevelId(htmlId, levelId) {
    $
            .ajax({
                type: "GET",
                url: "getLevelSemesterList",
                async: false,
                data: {
                    levelId: levelId
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Term</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value
                                + '" >' + item.displayText
                                + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setModulesByProgramLevelIdANDSemesterName(htmlId, programId, levelId, semesterId) {
    $
            .ajax({
                type: "GET",
                url: "getModulesByLevelAndSemester",
                async: false,
                data: {
                    programId: programId,
                    levelId: levelId,
                    semesterId: semesterId
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Module</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value
                                + '" >' + item.displayText
                                + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setModuleListByProgram(htmlId, programId) {
    $.ajax({
        type: "GET",
        url: "getModuleById",
        async: false,
        data: {
            programId: programId
        },
        success: function (data) {
            $(htmlId)
                    .empty()
                    .append(
                            '<option selected="selected" value="" >Select Module</option>');
            $.each(data, function (i, item) {
                $(htmlId).append(
                        '<option  value="' + item.value + '" >'
                        + item.displayText + '</option>');
            });
        },
        error: function () {
            alert("Failed to load ");
        }
    });

}


function setTitleList(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "jotTitleList",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Job Title</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });

}
function setBatchNamesByProgramIdList(htmlId, programId) {
    $
            .ajax({
                type: "GET",
                url: "batchNamesByList",
                async: false,
                data: {
                    programId: programId
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Batch Name</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setBatchLevelListByBatchName(htmlId, batchId) {
    $
            .ajax({
                type: "GET",
                url: "levelsByBathName",
                async: false,
                data: {
                    batchId: batchId
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Current Year Level</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setClassByBatchName(htmlId, batchId) {
    $
            .ajax({
                type: "GET",
                url: "classListByBatchName",
                async: false,
                data: {
                    batchId: batchId
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Class</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setClassLevelByClassId(htmlId, classId) {
    $
            .ajax({
                type: "GET",
                url: "getlevelListByClassId",
                async: false,
                data: {
                    classId: classId
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Class Level</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setInstituteTypeList(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "instituteTypes",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Institute Type</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });

}

function setHolidayCategoryList(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "holidayCategoryTypes",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Holiday Category</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });

}


function setEventTypeList(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "eventTypes",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Event Type</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });

}

function setAttendanceModule(htmlId, timetableId, dayofWeek) {
    $
            .ajax({
                type: "GET",
                url: "getModulesByTimeTbleIdAndDay",
                async: false,
                data: {
                    timetableId: timetableId,
                    dayofWeek: dayofWeek
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Module</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });

}

function loadPeriodsByDayOfWeek(htmlId, timetableId, dayofWeek) {
    $
            .ajax({
                type: "GET",
                url: "getPeriodsByDayOfWeek",
                async: false,
                data: {
                    timetableId: timetableId,
                    dayofWeek: dayofWeek
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Period</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });

}

function setModulesByProgramLevelBatchId(htmlId, programId, levelId, batchId) {

    $
            .ajax({
                type: "GET",
                url: "getModulesByProgramLevelBatchId",
                async: false,
                data: {
                    programId: programId,
                    levelId: levelId,
                    batchId: batchId
                },
                success: function (data) {
                    console.log(data);
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Subject</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value
                                + '" >' + item.displayText
                                + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}



function setOrganizationSupervisors(htmlId, OrganizationId) {
    $
            .ajax({
                type: "GET",
                url: "getOrganizationSupervisorList",
                async: false,
                data: {
                    OrganizationId: OrganizationId
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Supervisor</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setUserTypeList(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "getUserTypeList",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select User Type</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setUserCategoryList(htmlId, userTypeId) {
    $
            .ajax({
                type: "GET",
                url: "getUserCategoryList",
                async: false,
                data: {
                    userTypeId: userTypeId
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select User Category</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function loadClassRooms(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "getClassRooms",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Room</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });

}

function setExamTypesByCourseAndBatch(htmlId, courseId, batchId) {
    $
            .ajax({
                type: "GET",
                url: "getExamTypesByCourseAndBatch",
                async: false,
                data: {
                    courseId: courseId,
                    batchId: batchId
                },
                success: function (data) {
                    console.log(data);
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Exam Type</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setAssignmentTypesByCourseAndBatch(htmlId, courseId, batchId) {
    $
            .ajax({
                type: "GET",
                url: "getAssignmentTypesByCourseAndBatch",
                async: false,
                data: {
                    courseId: courseId,
                    batchId: batchId
                },
                success: function (data) {
                    console.log(data);
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Assignment Type</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setExamByCourseAndBatch(htmlId, courseId, batchId) {
    $
            .ajax({
                type: "GET",
                url: "getExamByCourseAndBatch",
                async: false,
                data: {
                    courseId: courseId,
                    batchId: batchId
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Exam</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setLevelsByCourseAndBatch(htmlId, courseId, batchId) {
    $
            .ajax({
                type: "GET",
                url: "getLevelsByCourseAndBatch",
                async: false,
                data: {
                    courseId: courseId,
                    batchId: batchId
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Level</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}


function setClassIdOptionsbyCourseAndBatchLevel(htmlId, courseId, batchId, levelId) {
    $
            .ajax({
                type: "GET",
                url: "getClassesByCourseAndBatchAndLevel",
                async: false,
                data: {
                    courseId: courseId,
                    batchId: batchId,
                    levelId: levelId
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Class</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}


function setAssignmentTypes(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "getAssignmentTypes",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Assignment Types</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}


function setAssignmentByClassID(htmlId, classId) {
    $
            .ajax({
                type: "GET",
                url: "getAssignmentByClassID",
                async: false,
                data: {
                    classId: classId
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Assignment</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}


function setClassesByStudentAndBatch(htmlId, batchId, studentId) {
    $
            .ajax({
                type: "GET",
                url: "getClassesByStudentAndBatch",
                async: false,
                data: {
                    batchId: batchId,
                    studentId: studentId
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Class</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function loadRecptionReportMonths(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "receptionReport",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Month</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });

}

function loadNurseryReportMonths(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "nurseryReport",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Month</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}

function setStudentHouses(htmlId) {
    $.ajax({
        type: "GET",
        url: "getStudentHouses",
        async: false,
        success: function (data) {
            $(htmlId).empty().append(
                    '<option value="" >Select Student House</option>');
            $.each(data, function (i, item) {
                $(htmlId).append(
                        '<option  value="' + item.value + '" >'
                        + item.displayText + '</option>');
            });
        },
        error: function () {
            alert("Failed to load ");
        }
    });
}



function loadfinalReportOneandTwoMonths(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "finalReportOneandTwo",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Month</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });

}

function loadfinalReportThreeSixMonths(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "finalReportThreeSix",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Month</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });

}

function loadealReportOneSixMonths(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "ealReportOneSix",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Month</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });

}

function loadealReportSevenThirteenMonths(htmlId) {
    $
            .ajax({
                type: "GET",
                url: "ealReportSevenThirteen",
                async: false,
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Month</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });

}


function setModulesForSecondaryReportByCourseId(htmlId, courseId) {
    $
            .ajax({
                type: "GET",
                url: "secondaryReportSubjects",
                async: false,
                data: {
                    courseId: courseId
                },
                success: function (data) {
                    $(htmlId)
                            .empty()
                            .append(
                                    '<option selected="selected" value="" >Select Subjects</option>');
                    $.each(data, function (i, item) {
                        $(htmlId).append(
                                '<option  value="' + item.value + '" >'
                                + item.displayText + '</option>');
                    });
                },
                error: function () {
                    alert("Failed to load ");
                }
            });
}


