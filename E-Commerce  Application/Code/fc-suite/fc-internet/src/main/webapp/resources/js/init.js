$(document).ready(function () {

    //initialize push menus
    $('.menu-left').jPushMenu();
    $('.menu-right').jPushMenu();


    var aboveHeight = $('.header').outerHeight() + 20;
//    $(window).scroll(function () {
//        //if scrolled down more than the header's height
//
//        if ($(window).scrollTop() > aboveHeight) {
//            // if yes, add "fixed" class to the <sticknav>
//            // add padding top to the #content (value is same as the height of the sticknav)
//            $('.leftnav').addClass('fixed');
//        } else {
//            // when scroll up or less than aboveHeight, remove the "fixed" class, and the padding-top
//            $('.leftnav').removeClass('fixed');
//        }
//    });


    $('.dash-nav').click(function () {
        dashboardMenu($(this).attr('id'));
        $(this).parent().addClass('active');
    });

    // initialize Default Datepicker
    $('.datepicker').datepicker({
        autoclose: true,
        startView: 3,
    });
    
    
    $('.date').click(
    function () {
        console.log("test");
        $(this).datepicker('show');
    }
    );

    // initialize Appointment Date datepickeer
    $('.app-datepicker').datepicker({
        autoclose: true,
        startDate: '+1d'
    });

    // initialize Date of birth Date datepickeer
    $('.dob-datepicker').datepicker({
        autoclose: true,
        startView: 3,
        endDate: 'y',
        fomat: 'MM/dd/yyyy',
        forceParse: true
    });

    //    $('.datepicker').attr('readonly', 'true'); //Disable

    $('.active > ul').show();

    $('.navbar-nav > li > a[href="#"]').click(function () {
        /*if ($(this).parent().hasClass('active')) {
         $(this).parent().children('ul').slideToggle("slow");
         $(this).parent().removeClass('active');
         return false;
         }*/
        $('.active > ul').slideToggle("slow");
        $('.active').removeClass('active');
        $(this).parent().addClass('active');
        return false;
        //$(this).parent().children('ul').slideToggle("slow");
    });


});

function dashboardMenu(x) {
    $('.active').removeClass('active');
    $('.submenu').fadeOut();
    $('.submenu.' + x).slideToggle();
}

//Read only Fields in focus
function readOnlyInFocus(id) {
    $(document).on("focusin", id, function (event) {
        $(this).prop('readonly', true);
    });

    $(document).on("focusout", id, function (event) {
        $(this).prop('readonly', false);
    });
}