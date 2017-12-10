<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>The First Credit - Dashboard</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="${pageContext.servletContext.contextPath}/resources/images/faviconfc.jpg" type="image/x-icon">
        <link rel="icon" href="${pageContext.servletContext.contextPath}/resources/images/faviconfc.jpg" type="image/x-icon">

    </head>
    <body>
        <!--########################## Main Header ###########################-->

        <%@include file="template/dashboard/header.jsp"%>

        <!-- ############# LEFT NAVIGATION ############# -->
        <div class="row">

            <div class="col-sm-12">
                <!-- ############# /LEFT NAVIGATION ############# -->


                <!-- ############# CONTENT ############# -->
                <div class="content">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="col-sm-9">
                                <h2 class="form-heading">Dashboard</h2> 
                            </div>
                            <span class="indicator">Last login time : <span>${lastLoginTime}</span></span>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-7 col-sm-8">
                            <ul class="dashboard-nav clearfix">
                                <li class="active">
                                    <a href="${pageContext.request.contextPath}/admin/dashboard" class="dash-nav" id="submenu-dashboard">
                                        <i class="fa fa-dashboard"></i>
                                        <span class="nav-text">Dashboard</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="dash-nav" id="submenu-category">                                          
                                        <i class="fa fa-tags"></i>
                                        <span class="nav-text">Category</span>
                                    </a> 
                                </li>  
                                <li>
                                    <a href="#" class="dash-nav" id="submenu-item">                                          
                                        <i class="fa fa-wrench"></i>
                                        <span class="nav-text">Item</span>
                                    </a> 
                                </li>  
                                <li>
                                    <a href="#" class="dash-nav" id="submenu-product">                                          
                                        <i class="fa fa-user-plus"></i>
                                        <span class="nav-text">Order</span>
                                    </a> 
                                </li>  
                                <li>
                                    <a href="#" class="dash-nav" id="submenu-product">                                          
                                        <i class="fa fa-building"></i>
                                        <span class="nav-text">Reports</span>
                                    </a> 
                                </li>  
                            </ul>
                        </div>
                        <div class="col-xs-5 col-sm-4">                                           
                            <div class="submenu submenu-category clearfix" id=""> 
                                <h4>Category</h4> 
                                <ul class="submenu-nav">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/admin/create-category" class=""> 
                                            <i class="fa fa-tags"></i>
                                            <span class="nav-text">Add Category</span>
                                        </a> 
                                    </li>                                                                                                          
                                </ul>
                            </div>
                            <div class="submenu submenu-item clearfix" id=""> 
                                <h4>Item</h4> 
                                <ul class="submenu-nav">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/admin/create-item" class=""> 
                                            <i class="fa fa-tags"></i>
                                            <span class="nav-text">Add Item</span>
                                        </a> 
                                    </li>                                                                                                          
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- ############# /CONTENT ############# -->
                <!-- ############# FOOTER ############# -->
            </div>
        </div>
        <div class="footer">
            <p>&#169; 2018,The E-commerce Application. All rights reserved.</p>  
        </div>
    </div>
    <!-- ############# FOOTER ############# -->
</body>
</html>
