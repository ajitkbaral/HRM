<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>HRM | ${title}</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- Bootstrap 3.3.4 -->
        <link href="${pageContext.request.contextPath}/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- Font Awesome Icons -->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="${pageContext.request.contextPath}/assets/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
        <!-- AdminLTE Skins. Choose a skin from the css/skins
             folder instead of downloading all of them to reduce the load. -->
        <link href="${pageContext.request.contextPath}/assets/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="skin-blue sidebar-mini">
        <div class="wrapper">

            <header class="main-header">

                <!-- Logo -->
                <a href="#" class="logo">
                    <!-- mini logo for sidebar mini 50x50 pixels -->
                    <span class="logo-mini"><b>HRM</b></span>
                    <!-- logo for regular state and mobile devices -->
                    <span class="logo-lg"><b>HRM</b></span>
                </a>

                <!-- Header Navbar: style can be found in header.less -->
                <nav class="navbar navbar-static-top" role="navigation">
                    <!-- Sidebar toggle button-->
                    <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                        <span class="sr-only">Toggle navigation</span>
                    </a>
                    <!-- Navbar Right Menu -->
                    <div class="navbar-custom-menu">
                        <ul class="nav navbar-nav">
                            <!-- User Account: style can be found in dropdown.less -->
                            <li class="user user-menu">
                                <a href="#" style="background: none;">
                                    <span class="hidden-xs">${sessionScope.user.getEmployee().getDepartment().getName()}</span>
                                </a>
                            </li>
                            <li class="user user-menu">
                                <a href="${pageContext.request.contextPath}/signout">
                                    <span class="hidden-xs">Sign out</span>
                                </a>
                            </li>
                        </ul>
                    </div>

                </nav>
            </header>
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="main-sidebar">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="${pageContext.request.contextPath}/assets/img/avatar5.png" class="img-circle" alt="User Image" />
                        </div>
                        <div class="pull-left info">
                            <p>${sessionScope.user.getEmployee().getName()}</p>

                            <a href="#"><i class="fa fa-circle"></i> ${sessionScope.user.getEmployee().getPosition()}</a>
                        </div>
                        <div class="pull-left info" style="margin-top:10px;">
                            <p></p>
                        </div>
                    </div>
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu">
                        <li class="header">MAIN NAVIGATION</li>
                            <c:choose>
                                <c:when test="${sessionScope.user.getRoleId() eq 1}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/admin/dashboard">
                                        <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/admin/employee">
                                        <i class="fa fa-user "></i> <span>Employee</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/admin/department">
                                        <i class="fa fa-institution "></i> <span>Department</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/admin/training">
                                        <i class="glyphicon glyphicon-flag"></i> <span>Training</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/admin/complaint">
                                        <i class="fa fa-warning"></i> <span>Complaints</span>
                                    </a>
                                </li>   
                                <li>
                                    <a href="${pageContext.request.contextPath}/admin/settings">
                                        <i class="fa fa-gear"></i> <span>Settings</span>
                                    </a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li>
                                    <a href="${pageContext.request.contextPath}/emp/dashboard">
                                        <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/emp/employee">
                                        <i class="fa fa-user "></i> <span>Employee</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/emp/department">
                                        <i class="fa fa-institution "></i> <span>Department</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/emp/training">
                                        <i class="glyphicon glyphicon-flag"></i> <span>All Trainings</span>
                                    </a>
                                </li>
                                <!--
                                <li>
                                    <a href="${pageContext.request.contextPath}/emp/complaints">
                                        <i class="fa fa-warning"></i> <span>Complaints</span>
                                    </a>
                                </li>
                                -->
                                <li>
                                    <a href="${pageContext.request.contextPath}/emp/settings">
                                        <i class="fa fa-gear"></i> <span>Settings</span>
                                    </a>
                                </li>
                            </c:otherwise>
                        </c:choose>

                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        ${title}
                    </h1>
                </section>

                <!-- Main content -->
                <section class="content">

                    <c:if test="${param.insert eq 'success'}" >
                        <div class="box-body" id="alert-dialog">
                            <div class="alert alert-success alert-dismissible">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                                <h4><i class="icon fa fa-check"></i> Added!</h4>
                                The information has been successfully added.
                            </div>
                        </div>
                    </c:if>

                    <c:if test="${param.update eq 'success'}" >
                        <div class="box-body" id="alert-dialog">
                            <div class="alert alert-info alert-dismissible">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                                <h4><i class="icon fa fa-check"></i> Updated!</h4>
                                The information has been successfully updated.
                            </div>
                        </div>
                    </c:if>

                    <c:if test="${param.update eq 'false'}" >
                        <div class="box-body" id="alert-dialog">
                            <div class="alert alert-danger alert-dismissible">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                                <h4><i class="icon fa fa-ban"></i> Username already exists!</h4>
                                ${param.message}
                            </div>
                        </div>
                    </c:if>

                    <c:if test="${param.delete eq 'success'}" >
                        <div class="box-body" id="alert-dialog">
                            <div class="alert alert-success alert-dismissible">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                                <h4><i class="icon fa fa-check"></i> Deleted!</h4>
                                The information has been successfully deleted.
                            </div>
                        </div>
                    </c:if>