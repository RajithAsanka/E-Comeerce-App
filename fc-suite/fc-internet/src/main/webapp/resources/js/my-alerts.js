var token;
var data;
var exceptionDateList = [];
var username = $("#txtUserName").val();
var userType = $("#txtUserType").val();

$(document).ready(function () {
    //$('.active').removeClass('active');
    //$("#assignment-menu").addClass("active");
    token = $("#txtSecurityToken").val();

    loadData1();


});


function loadData1() {

    var serializedData = {
        username: username,
        userType: userType
    };

    data = ajaxData1('user-alert/findByUsername/json', 'GET', serializedData, token);
    //console.log(data);


    $("#user-nortification").empty();

    var havenewOne = "false";

    var studentTemp = "";
    if (data.length != 0) {
        for (var alerts = 0; alerts < data.length; alerts++) {
            if(data[alerts].sourcetype=='Custom'){
            studentTemp += "<a role='menuitem' tabindex='-1' href='javascript:void(0)' class='my-alert-class' alertid='" + data[alerts].alertId + "' style='color:" + data[alerts].color + "'>" + data[alerts].subject.substring(0, 50) + "</a>";
            }else if(data[alerts].sourcetype=='Event'){
                studentTemp += "<a role='menuitem' tabindex='-1' href='javascript:void(0)' class='my-alert-class' alertid='" + data[alerts].alertId + "' style='color:" + data[alerts].color + "'>Event : " + data[alerts].subject.substring(0, 50) + "</a>";
            }else if(data[alerts].sourcetype=='Attendence'){
                studentTemp += "<a role='menuitem' tabindex='-1' href='javascript:void(0)' class='my-alert-class' alertid='" + data[alerts].alertId + "' style='color:" + data[alerts].color + "'>Attendence : " + data[alerts].subject.substring(0, 50) + "</a>";
            }
            
        }
        
        for (var alerts = 0; alerts < data.length; alerts++) {
            if (data[alerts].color == 'red') {
                havenewOne = "true";
                break;
            }
        }
    } else {
        studentTemp += "<a role='menuitem' tabindex='-1'  >no notifications</a>";
    }
    $("#user-nortification").append(studentTemp);

    if (havenewOne=="true") {
        $("#notification-menu-icon").css( "color", "red" );
    }else{
        $("#notification-menu-icon").css( "color", "" );
    }

}

function updateNortification(alertId) {
    var serializedData = {
        alertid: alertId,
        username: username
    };

    updateData1('user-alert/updateToRead', 'POST', serializedData, token);
}




$(document).on('click', '#user-nortification .my-alert-class', function () {
    //alert($(this).attr('alertid'));
    var serializedData = {
        alertid: $(this).attr('alertid')
    };
    alertData = ajaxData1('user-alert/find/json', 'GET', serializedData, token);

    updateNortification($(this).attr('alertid'));

     if(alertData.sourcetype=='Custom'){
         showErrorMsg1("Nortification : " + alertData.subject.substring(0, 150), alertData.massage);
     }else if(alertData.sourcetype=='Event'){
         showErrorMsg1("Event : " + alertData.subject.substring(0, 150), alertData.massage);
     }else if(alertData.sourcetype=='Attendence'){
         showErrorMsg1("Attendence : " + alertData.subject.substring(0, 150), alertData.massage);
     }
    
});




// #################### Load Data ######################################

//#############################
//Other Events
//#############################
function ajaxData1(url, type, data, token) {
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

function updateData1(url, type, data, token) {
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

function showErrorMsg1(title, message) {
    BootstrapDialog.show({
        title: title,
        message: message,
        type: BootstrapDialog.TYPE_DANGER,
        buttons: [{
                label: 'OK',
                action: function (dialog) {
                    loadData1();
                    dialog.close();
                }
            }]
    });
}