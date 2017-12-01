
/* Disable Copy Paste in fields */
$(".disableCopyPaste").bind("cut copy paste", function (e) {
    e.preventDefault();
});

/*String validations*/

$('.stringValClass').keypress(function (e) {

    if (e.which > 0 && e.which != 8 && !(e.which >= 65 && e.which <= 90) && // allow A-Z
            !(e.which >= 97 && e.which <= 122)) // allow a-z
    {
        e.preventDefault();
    }
});

/* Number Validation */
$('.numberValClass').keypress(function (e) {

    if (e.which > 31 && (e.which < 48 || e.which > 57)) //allow 0-9
    {
        e.preventDefault();
    }
});

/* Telephone Number Validation */
$('.tpnumberValClass').keypress(function (e) {
    if (e.which > 31 && (e.which < 48 || e.which > 57)) //allow 0-9 and +
    {
        if (e.which !== 43) {
            e.preventDefault();
        }

    }
});

//Detecting browsers by ducktyping:
var isOpera = !!window.opera || navigator.userAgent.indexOf(' OPR/') >= 0;
var isFirefox = typeof InstallTrigger !== 'undefined';   // Firefox 1.0+
var isSafari = Object.prototype.toString.call(window.HTMLElement).indexOf('Constructor') > 0;
var isChrome = !!window.chrome && !isOpera;              // Chrome 1+
var isIE = /*@cc_on!@*/false || !!document.documentMode;   // At least IE6

/*String and Number Validations */
$('.stringNumberValClass').keypress(function (e) {
    if (isFirefox) {
        if (e.keyCode == 8 || e.keyCode == 46 || e.keyCode == 37 || e.keyCode == 39 || e.keyCode == 9) {
            return true;
        } else {
            if (e.which < 48 || (e.which > 57 && e.which < 65) || (e.which > 90 && e.which < 97) || e.which > 122) {
                if (e.which !== 45 && e.which !== 47) {
                    e.preventDefault();
                }
            }
        }
    } else {
        if (e.which < 48 || (e.which > 57 && e.which < 65) || (e.which > 90 && e.which < 97) || e.which > 122) {
            if (e.which !== 45 && e.which !== 47) {
                e.preventDefault();
            }
        }
    }
});

/*Level Code Special String and Number Validations (for load the lecture div boxes in create batch) */
$('.stringNumberLevelValClass').keypress(function (e) {
    var isFirefox = typeof InstallTrigger !== 'undefined';
    if (isFirefox) {
        if (e.keyCode == 8 || e.keyCode == 46 || e.keyCode == 37 || e.keyCode == 39 || e.keyCode == 9) {
            return true;
        } else {
            if (e.which < 48 || (e.which > 57 && e.which < 65) || (e.which > 90 && e.which < 97) || e.which > 122) {
                e.preventDefault();
            }
        }
    } else {
        if (e.which < 48 || (e.which > 57 && e.which < 65) || (e.which > 90 && e.which < 97) || e.which > 122) {
            e.preventDefault();
        }
    }
});


$('.lastNameVal').keypress(function (e) {
    console.log(e.which);
    if (e.which > 0 && e.which != 8 && !(e.which >= 65 && e.which <= 90) && // allow A-Z
            !(e.which >= 97 && e.which <= 122) // allow a-z
            && e.which != 32) // allow space

    {
        e.preventDefault();
    }
});


/* NIC Validation */
$.validator.addMethod("nicOnly", function (value, element) {
    return this.optional(element) || /^[0-9]{9}[vVxX]$/.test(value);
}, "Please enter valid NIC number");

/* Sri Lankan phone Validation */
$.validator.addMethod("phoneNo", function (value, element) {
    return this.optional(element) || /^\(?0\d{2}\)?[\s\-]?\d{7,12}$/.test(value);
}, "Please enter valid contact number [Ex:0712345678]");

/* Sri Lankan Fax Validation */
$.validator.addMethod("faxNo", function (value, element) {
    return this.optional(element) || /^\(?0\d{2}\)?[\s\-]?\d{7,12}$/.test(value);
}, "Please enter valid fax number [Ex:0712345678]");
$.validator.addMethod("universityOnly", function (value, element) {
    return this.optional(element) || /^[a-zA-Z]{1}\d{8}$/.test(value);
}, "Please enter valid University Number");

$.validator.addMethod("emailOnly", function (value, element) {
    return this.optional(element) || /^[a-z0-9_\-\.]{2,}@[a-z0-9_\-\.]{2,}\.[a-z]{2,}$/.test(value);
}, "Please enter valid Email Address");


$.validator.addMethod("greaterThan", function (value, element, params) {
    if (!/Invalid|NaN/.test(new Date(value))) {
        return new Date(value) > new Date($(params).val());
    }

    return isNaN(value) && isNaN($(params).val()) || (Number(value) > Number($(params).val()));
}, 'Please select a year, greater than From Year.');


$.validator.addMethod("smallerThan", function (value, element, params) {
    if (!/Invalid|NaN/.test(new Date(value))) {
        return new Date(value) < new Date($(params).val());
    }

    return isNaN(value) && isNaN($(params).val()) || (Number(value) > Number($(params).val()));
}, 'Please select a date, smaller than Start Date.');

$.validator.addMethod("greaterThanOrEqual", function (value, element, params) {
    if (!/Invalid|NaN/.test(new Date(value))) {
        return new Date(value) >= new Date($(params).val());
    }

    return isNaN(value) && isNaN($(params).val()) || (Number(value) > Number($(params).val()));
}, 'Please select a year, greater than or equal to From Year.');



$.validator.addMethod("greaterThanDate", function (value, element, params) {
    if (!/Invalid|NaN/.test(new Date(value))) {
        return new Date(value) >= new Date($(params).val());
    }

    return isNaN(value) && isNaN($(params).val()) || (Number(value) > Number($(params).val()));
}, 'Please select a date, greater than Start Date.');

$.validator.addMethod("greaterThanSubmittedDate", function (value, element, params) {
    if (!/Invalid|NaN/.test(new Date(value))) {
        return new Date(value) >= new Date($(params).val());
    }

    return isNaN(value) && isNaN($(params).val()) || (Number(value) > Number($(params).val()));
}, 'Please select a date, greater than Submitted Date.');


$.validator.addMethod("uploadFile", function (val, element) {
    if ($('.uploadFile').val() == "") {
        return true;
    }
    else {
        var ext = $('.uploadFile').val().split('.').pop().toLowerCase();
        var allow = new Array('gif', 'png', 'jpg', 'jpeg');
        if (jQuery.inArray(ext, allow) == -1) {
            return false
        } else {
            return true
        }
    }

}, "File type error");

$.validator.addMethod("percentage", function (value, element, params) {
    if (!/Invalid|NaN/.test(value)) {
        return value <= 100;
    }

    return isNaN(value) && isNaN($(params).val()) || (Number(value) > Number($(params).val()));
}, 'Please add the value smaller than or equal 100.');


$.validator.addMethod("retypePassword", function (value, element, params) {


    return value == $(params).val();
}, 'Please type same password.');

