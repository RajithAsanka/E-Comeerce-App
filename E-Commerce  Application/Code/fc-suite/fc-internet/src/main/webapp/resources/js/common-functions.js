function getContextPath() {
    return window.location.pathname.substring(0, window.location.pathname
            .indexOf("/", 2));
}

function alreadyAvailable(checkboxId, formId) {
    $(checkboxId).change(function () {
        if ($(checkboxId).is(':checked')) {
            $(formId).show();
        } else {
            $(formId).hide();
        }
    });
}

function calculateAge(birthday) { // birthday is a date
    var today = new Date();
    var birthDate = new Date(birthday);
    var age = today.getFullYear() - birthDate.getFullYear();
    var m = today.getMonth() - birthDate.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
        age--;
    }
    return age + m;
}

function getAge(fromdate, todate) {
    if (todate)
        todate = new Date(todate);
    else
        todate = new Date();

    var age = [], fromdate = new Date(fromdate),
            y = [todate.getFullYear(), fromdate.getFullYear()],
            ydiff = y[0] - y[1],
            m = [todate.getMonth(), fromdate.getMonth()],
            mdiff = m[0] - m[1],
            d = [todate.getDate(), fromdate.getDate()],
            ddiff = d[0] - d[1];

    if (mdiff < 0 || (mdiff === 0 && ddiff < 0))
        --ydiff;
    if (mdiff < 0)
        mdiff += 12;
    if (ddiff < 0) {
        fromdate.setMonth(m[1] + 1, 0);
        ddiff = fromdate.getDate() - d[1] + d[0];
        --mdiff;
    }
    if (ydiff > 0)
        age.push(ydiff + ' year' + (ydiff > 1 ? 's ' : ' '));
    if (mdiff > 0)
        age.push(mdiff + ' month' + (mdiff > 1 ? 's' : ''));
//    if(ddiff> 0) age.push(ddiff+ ' day'+(ddiff> 1? 's':''));
    if (age.length > 1)
        age.splice(age.length - 1, 0, ' and ');
    return age.join('');
}


// override jquery validate plugin defaults
/* Validator message */
$.validator.setDefaults({
    highlight: function (element) {
        $(element).closest('.form-group').addClass('has-error');
    },
    unhighlight: function (element) {
        $(element).closest('.form-group').removeClass('has-error');
    },
    errorElement: 'span',
    errorClass: 'help-block',
    errorPlacement: function (error, element) {
        if (element.attr("name") == "alert") {
            error.appendTo(element.hasClass("placeAfter"));
        }
        else if (element.parent('.input-group').length) {
            error.insertAfter(element.parent());
        } else {
            error.insertAfter(element);
        }
    }
});

function setTodayDate(htmlId) {
    var d = new Date();
    var strDate = (d.getMonth() + 1) + "/" + d.getDate() + "/"
            + d.getFullYear();
    $(htmlId).val(strDate);
}

function showSuccessMsg(title, message) {
    BootstrapDialog.show({
        title: title,
        message: message,
        type: BootstrapDialog.TYPE_SUCCESS,
        buttons: [{
                label: 'OK',
                action: function (dialog) {
                    dialog.close();
                }
            }]
    });
}

function showMsg(title, message) {
    BootstrapDialog.show({
        title: title,
        message: message,
        buttons: [{
                label: 'OK',
                action: function (dialog) {
                    dialog.close();
                }
            }]
    });
}

// This is specifically for a table if you have two table please develop
// this with getting table id
function isDuplicate(column, text) {
    var x = document.getElementsByTagName("tr");

    var i;
    for (i = 0; i < x.length; i++) {
        var txt = x[i].cells[column].innerHTML;
        if (text == txt) {
            showErrorMsg("Error", "You are trying to add duplicate value");
            return true;
        }
    }
    return false;
}

/**
 * bootstrap table Adding function
 * @param tableId the table id you want to add
 * @param data the data you want to add this should be an object
 */
function addTable(tableId, data) {
    var allData = [];
    allData = $(tableId).bootstrapTable('getData');
    allData.push(data);
    $(tableId).bootstrapTable('load', allData);
}

//function to validate schools 
//prevents adding the same school more than once
function validateschoolTable(tableId, data, msg) {
    var allData = [];
    var result = "false";
    var idFound;
    var schoolFound;

    allData = $(tableId).bootstrapTable('getData');
    if (allData.length > 0) {
        for (var i = 0; i < allData.length; i++) {

            if (allData[i].previousSchoolName === data.previousSchoolName) {

                schoolFound = allData[i].previousSchoolName;
                idFound = allData.indexOf(allData[i]);
                result = "true";
            }
        }
        if (result != "true" && msg == "Add") {
            allData.push(data);
            $(tableId).bootstrapTable('load', allData);
        }
        else if (result = "true" && msg == "Add") {
            schoolDuplicatelError();
        }
        else if (result = "true" && msg == "Update") {

            if (idFound == data.id) {
                allData.splice(idFound, 1, data);
                $(tableId).bootstrapTable('load', allData);
                
                $("#add").text("Add");
            }
            else if (idFound != data.id) {
                if (schoolFound != data.previousSchoolName) {
                    allData.splice(data.id, 1, data);
                    $(tableId).bootstrapTable('load', allData);
                    $("#add").text("Add");
                }
                else if (schoolFound == data.previousSchoolName) {
                    schoolDuplicatelError();
                }
            }
            else {
                schoolDuplicatelError();
            }
        }
    }
    else if (allData.length == 0)
    {
        allData.push(data);
        $(tableId).bootstrapTable('load', allData);
    }
}

function schoolDuplicatelError() {
    $("#school_previous").css('display', 'block');
    $("#school_previous").css('color', '#de4046');
    $("#school_previous").html("* Cannot Add Same School Twice");

}


function validateExamPaper(tableId, data, msg) {
    var allData = [];
    var result = "false";
    var idFound;
    var paperFound;

    allData = $(tableId).bootstrapTable('getData');
    if (allData.length > 0) {
        for (var i = 0; i < allData.length; i++) {

            if (allData[i].paperName === data.paperName) {

                paperFound = allData[i].paperName;
                idFound = allData.indexOf(allData[i]);
                result = "true";
            }
        }
        if (result != "true" && msg == "Add") {
            allData.push(data);
            $(tableId).bootstrapTable('load', allData);
        }
        else if (result = "true" && msg == "Add") {
            examPaperDuplicatelError();
        }
        else if (result = "true" && msg == "Update") {

            if (idFound == data.id) {
                allData.splice(idFound, 1, data);
                $(tableId).bootstrapTable('load', allData);
                
                $("#add").text("Add");
            }
            else if (idFound != data.id) {
                if (paperFound != data.paperName) {
                    allData.splice(data.id, 1, data);
                    $(tableId).bootstrapTable('load', allData);
                    $("#add").text("Add");
                }
                else if (paperFound == data.paperName) {
                    examPaperDuplicatelError();
                }
            }
            else {
                examPaperDuplicatelError();
            }
        }
    }
    else if (allData.length == 0)
    {
        allData.push(data);
        $(tableId).bootstrapTable('load', allData);
    }
}

function examPaperDuplicatelError() {
    $("#exam_paper").css('display', 'block');
    $("#exam_paper").css('color', '#de4046');
    $("#exam_paper").html("* Cannot Add Same Paper Twice");

}

function emptyTable(tableId) {
    var allData = [];
    $(tableId).bootstrapTable('load', allData);
}

function removeTable(tableId, data) {

    var selects = [];
    selects.push(data);

    ids = $.map(selects, function (row) {
        console.log(row.id);
        return row.id;
    });

    $(tableId).bootstrapTable('remove', {
        field: 'id',
        values: ids
    });
}

function showErrorMsg(title, message) {
    BootstrapDialog.show({
        title: title,
        message: message,
        type: BootstrapDialog.TYPE_DANGER,
        buttons: [{
                label: 'OK',
                action: function (dialog) {
                    dialog.close();
                }
            }]
    });
}

function goBack() {
    window.history.back();
}

function relocate(url) {
    window.location.assign(url);
}

// ################### OTHER UTIL ###################################
function getUrlVars() {
    var vars = [], hash;
    var hashes = window.location.href.slice(
            window.location.href.indexOf('?') + 1).split('&');
    for (var i = 0; i < hashes.length; i++) {
        hash = hashes[i].split('=');
        vars.push(hash[0]);
        vars[hash[0]] = hash[1];
    }
    return vars;
}

function RadionButtonSelectedValueSet(name, SelectdValue) {
    $('input[name="' + name + '"][value="' + SelectdValue + '"]').prop(
            'checked', true);
}

function findAndRemove(array, value) {
    var temp = [];
    var i = 0;
    $.each(array, function (index, result) {
        if (array[index].id == value) {
        } else {
            temp[i++] = array[index];
        }
    });
    return temp;
}

// To find inserted option is already in the list
function isOptionValueDuplicate(htmlId, value) {
    return $(htmlId + " option[value='" + value + "']").length > 0;
}

//########## IMPORTANT for manual serialize #####################
function manualSerialize(data) {
    var objectItem = {};
    for (var i in data) {
        objectItem[data[i].colomn] = data[i].value;
    }
    return objectItem;
}


function ajaxData(url, type, data, token) {
    var returnData = null;
    $.ajax({
        type: type,
        url: url,
        async: false,
        headers: {
            'X-CSRF-TOKEN': token
        },
        data: data,
        success: function (data) {
            returnData = data;
        },
        error: function () {
            alert("Failed to load ");
        }
    });
    return	returnData;
}

//comma seperated value and right side alignment
$(".value").focusout(function () {
    var nStr = $('.value').val();
    x = nStr.split('.');
    x1 = x[0];
    x2 = x.length > 1 ? '.' + x[1] : '';
    var rgx = /(\d+)(\d{3})/;
    while (rgx.test(x1)) {
        x1 = x1.replace(rgx, '$1' + ',' + '$2');
    }
    $(".value").val(x1 + x2);
});

$(".value").attr('style', 'text-align: right');
