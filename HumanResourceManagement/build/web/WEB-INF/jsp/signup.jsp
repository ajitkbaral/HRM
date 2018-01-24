<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>HRM | Signup </title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- Bootstrap 3.3.4 -->
        <link href="${pageContext.request.contextPath}/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- Font Awesome Icons -->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="${pageContext.request.contextPath}/assets/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
        <!-- iCheck -->
        <link href="${pageContext.request.contextPath}/assets/plugins/iCheck/square/blue.css" rel="stylesheet" type="text/css" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="register-page">
        <c:if test="${param.status eq 'false'}" >
            <div class="box-body" id="alert-dialog">
                <div class="alert alert-danger alert-dismissible">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                    <h4><i class="icon fa fa-ban"></i> ${param.title}</h4>
                    ${param.message}
                </div>
            </div>
        </c:if>
        <div class="register-box">
            <div class="register-logo">
                <a href="#"><b>HRM</b><br/>Signup</a>
            </div>

            <div class="register-box-body">
                <p class="login-box-msg">Register a new membership</p>
                <form action="" method="post">
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" placeholder="Username" name="username" required/>
                        <span class="glyphicon glyphicon-star form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="password" class="form-control" placeholder="Password" name="password" required/>
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="number" class="form-control" placeholder="Employee ID" name="emp_id" required/>
                        <span class="glyphicon glyphicon-credit-card form-control-feedback"></span>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <button type="submit" class="btn btn-primary btn-block btn-flat">Signup</button>
                        </div><!-- /.col -->
                    </div>
                </form>  
                <div class="row" style="margin-top: 10px;">
                    <div class="col-md-12">
                        <a href="${pageContext.request.contextPath}/login">I already have a membership</a>
                    </div>

                </div>

            </div><!-- /.form-box -->
        </div><!-- /.register-box -->

        <!-- jQuery 2.1.4 -->
        <script src="${pageContext.request.contextPath}/assets/plugins/jQuery/jQuery-2.1.4.min.js"></script>
        <!-- Bootstrap 3.3.2 JS -->
        <script src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

    </body>
</html>