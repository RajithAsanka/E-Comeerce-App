// #############################
// VARIABLES
// #############################
var saveUrl = "create-group/save";
var readUrl = "create-group/find/groups";
var updateUrl = "create-group/update";

var token = $("#txtSecurityToken").val();
var username = $("#txtUserName").val();
var table;
var clearBtn = $("#clear");
var addBtn = $("#add");

//#############################
//INITIALIZATION
//#############################

//document.title = "MISY Myanmar International School - Country Form";

function initTable() {
    table = $('#group-table').bootstrapTable({
        method: 'get',
        url: readUrl,
        cache: false,
        height: 350,
        striped: true,
        pagination: true,
        search: true,
        showColumns: true,
        pageSize: 50,
        pageList: [10, 25, 50, 100, 200],
        minimumCountColumns: 2,
        clickToSelect: true,
        columns: [{
                field: 'groupName',
                title: 'Group Name',
                align: 'left',
                valign: 'bottom',
                sortable: true
            }, {
                field: 'status',
                title: 'Status',
                align: 'left',
                valign: 'bottom',
                sortable: true
            }, {
                field: 'addmember',
                title: 'Add Member',
                align: 'left',
                valign: 'bottom',
                sortable: true,
                formatter: operateFormatterAction,
                events: operateEventAddmemeber
            },{
                field: 'action',
                title: 'Edit Group',
                align: 'left',
                valign: 'bottom',
                sortable: true,
                formatter: operateFormatter,
                events: operateEvents
            }]
    });
}

function initReference() {

    document.getElementById("create-country").setAttribute("href", "create-country");
    document.getElementById("create-state").setAttribute("href", "create-state");
    document.getElementById("create-city").setAttribute("href", "create-city");
}

//#############################
//LOADINGS
//#############################
$(document).ready(function () {
    $('.active').removeClass('active');
    $("#common-menu").addClass("active");  
    //initReference();
    //intilizing table
    initTable();
    //common-dropdown functions
    loadData();
});

//#############################
//GETTER & SETTER
//#############################
function getData() {
    allData = [{
            title: "Group Name",
            colomn: "groupName",
            value: $("#group-name").val()
        }, {
            title: "Date of Establishment",
            colomn: "establishment",
            value: $("#establishment").val()
        }, {
            title: "Group Officer",
            colomn: "groupOfficer",
            value: $("#group-officer").val()
        }, {
            title: "Meeting Day",
            colomn: "meetingDay",
            value: $("#meeting-day").val()
        }, {
            title: "Group Branch",
            colomn: "groupBranch",
            value: $("#group-Branch").val()
        }, {
            title: "Group Address",
            colomn: "groupAddress",
            value: $("#group-address").val()
        }, {
            title: "Contact Number",
            colomn: "contactNumber",
            value: $("#group-contact-number").val()
        }, {
            title: "",
            colomn: "details",
            value: $("#details").val()
        }, {
            title: "Status",
            colomn: "status",
            value: $("#status").val()
        }, {
            title: "",
            colomn: "username",
            value: username
        }];
    return allData;

}


//#############################
//GETTER & SETTER
//#############################
function getUpdateData() {
    allData = [{
            title: "",
            colomn: "groupId",
            value: $("#group-id").val()
        },{
            title: "Group Name",
            colomn: "groupName",
            value: $("#group-name").val()
        }, {
            title: "Date of Establishment",
            colomn: "establishment",
            value: $("#establishment").val()
        }, {
            title: "Group Officer",
            colomn: "groupOfficer",
            value: $("#group-officer").val()
        }, {
            title: "Meeting Day",
            colomn: "meetingDay",
            value: $("#meeting-day").val()
        }, {
            title: "Group Branch",
            colomn: "groupBranch",
            value: $("#group-Branch").val()
        }, {
            title: "Group Address",
            colomn: "groupAddress",
            value: $("#group-address").val()
        }, {
            title: "Contact Number",
            colomn: "contactNumber",
            value: $("#group-contact-number").val()
        }, {
            title: "",
            colomn: "details",
            value: $("#details").val()
        }, {
            title: "Status",
            colomn: "status",
            value: $("#status").val()
        }, {
            title: "",
            colomn: "username",
            value: username
        }];
    return allData;

}



//#############################
//EVENTS
//#############################


addBtn.click(function () {
    //show confirmation message to save
    buttonstatus = $(this).html();
    if (buttonstatus == "Add") {
        validateForm("Add");
    }
    else if (buttonstatus == "Update") {

        validateForm("Update");
    }
});


function validateForm(msg) {

    //  if (isValidCountry()) {
    showSaveconfirmation(msg);
    // } else {
    //  focusInvalid();
    //}
}


clearBtn.click(function () {
    //validator.resetForm();  
    $('#add').html('Save');
});

//#############################
//POP UPS
//#############################
function generateViewData(data) {
    var content = "<table class='table table-bordered table-striped'>";
    content += "<tbody>";

    for (var i in data) {
        if (data[i].title != "") {
            content += "<tr>";
            content += "<td>" + data[i].title + "</td>";
            content += "<td class='wordbreak'>" + data[i].value + "</td>";
            content += "</tr>";
        }
    }

    content += "</tbody>";
    content += "</table>";
    return content;
}

function showSaveconfirmation(msg) {
    //get current data to save
    
    if (msg == "Add") {
     //saves new 
     var gatheredData = getData();
    }else{
        
     var gatheredData = getUpdateData();
    }
    BootstrapDialog.show({
        title: 'Save Confirmation',
        //automatically generating view data
        message: generateViewData(gatheredData),
        buttons: [{
                label: msg,
                cssClass: 'btn-success',
                autospin: true,
                action: function (dialog) {
                    dialog.enableButtons(false);
                    dialog.setClosable(false);
                    //Serialize Data
                    serializedData = manualSerialize(gatheredData);
                    //save country data
                    if (msg == "Add") {
                        //saves new 
                        saveData(saveUrl, "POST", serializedData);
                    }
                    else {
                        //updates exist 
                        saveData(updateUrl, "POST", serializedData);
                    }

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

function showSaveMsg(Id) {
    dialogInstance = new BootstrapDialog();
    dialogInstance.setTitle('Save Message');
    dialogInstance.setMessage("Entry saved!, Group Id is " + Id);
    dialogInstance.setType(BootstrapDialog.TYPE_SUCCESS);
    dialogInstance.open();

    setTimeout(function () {
        dialogInstance.close();
        loadData();
    }, 3000);
}


//#############################
//AJAX
//#############################
function saveData(url, type, data) {
    $.ajax({
        type: type,
        url: url,
        async: false,
        headers: {
            'X-CSRF-TOKEN': token
        },
        data: data,
        success: function (data) {
            if (data.success === "true") {
                showSaveMsg(data.result);
            } else {
                showErrorMsg("Error", data.errorMessage);
            }

        },
        error: function () {
            alert("Failed to load ");
        }
    });
}

function ajaxLoadData(url, type, groupId) {

    var returnData = null;
    console.log(groupId);
    $.ajax({
        type: type,
        url: url,
        async: false,
        data: {
            groupId: groupId
        }, headers: {
            'X-CSRF-TOKEN': token
        },
        success: function (data) {
            returnData = data;
        },
        error: function () {
            alert("Failed to load ");
        }
    });
    return	returnData;
}

function ajaxData(url, type) {
    var returnData = null;
    $.ajax({
        type: type,
        url: url,
        async: false,
        headers: {
            'X-CSRF-TOKEN': token
        },
        success: function (data) {
            returnData = data;
        },
        error: function () {
            alert("Failed to load ");
        }
    });
    return	returnData;
}

//#############################
//Other Events
//#############################
function operateFormatter(value, row, index) {
    return [
        '<a class="edit ml10" href="javascript:void(0)" title="Edit">',
        '<i class="glyphicon glyphicon-pencil"></i>',
        '</a>'
    ].join('');
}

function operateFormatterAction(value, row, index) {
    return [
        '<a class="addmemeber ml10" href="javascript:void(0)" title="addmemeber">',
        '<i class="glyphicon glyphicon-user"></i>',
        '</a>'
    ].join('');
}


window.operateEvents = {
    'click .edit': function (e, value, row, index) {
        clearBtn.click();
        $("#group-id").val(row.groupId);
        $("#group-name").val(row.groupName);
        $("#establishment").val(row.dateOfEstablishment);
        $("#group-officer").val(row.employeeName);
        $("#meeting-day").val(row.meetingDate);
        $("#group-Branch").val(row.branch);
        $("#group-contact-number").val(row.contact);
        $("#details").val(row.description);
        $("#status").val(row.status);
        $("#group-address").val(row.address);
        $('#add').html('Update');
    }
};


window.operateEventAddmemeber = {
    'click .addmemeber': function (e, value, row, index) {
        console.log("clicked",row);
        window.location.href = "create-member?groupId=" + row.groupId;
    }
};



function loadData() {
   
    //Loads from database
    data = ajaxData(readUrl, "GET", token);
    //Loading database data to bootstrap table
    table.bootstrapTable('load', data);

}
