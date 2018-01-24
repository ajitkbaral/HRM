<%@include file="header.jsp" %>
<div class="row">
    <div class="col-md-12">
        <div class="box box-default">
            <div class="box-header with-border">
                <h3 class="box-title">Your Information</h3>
                <div class="box-tools pull-right">
                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                </div><!-- /.box-tools -->
            </div><!-- /.box-header -->
            <div class="box-body" style="display: block;">
                <form role="form" method="POST" action="${pageContext.request.contextPath}/admin/settings/">
                    <div class="box-body">
                        <div class="form-group">
                            <label for="name">Name</label>
                            <input type="text" class="form-control" id="name" placeholder="Enter Employee Name" name="name" value="${pageContext.request.getSession().getAttribute("user").getEmployee().getName()}">
                        </div>
                        <div class="form-group">
                            <label for="username">Username</label>
                            <input type="text" class="form-control" id="username" placeholder="Example: dohnjoe@gmail.com" name="username" value="${pageContext.request.getSession().getAttribute("user").getUsername()}">
                        </div>
                        <div class="form-group">
                            <label for="password">Change password</label>
                            <input type="password" class="form-control" id="password" placeholder="Enter new password" name="password">
                        </div>
                        <div class="form-group">
                            <label for="userEmail">Email</label>
                            <input type="email" class="form-control" id="userEmail" placeholder="Example: dohnjoe@gmail.com" name="email" value="${pageContext.request.getSession().getAttribute("user").getEmployee().getEmail()}">
                        </div>
                    </div><!-- /.box-body -->

                    <div class="box-footer">
                        <button type="submit" class="btn btn-primary pull-right">Update</button>
                    </div>
                </form>
            </div><!-- /.box-body -->
        </div><!-- /.box -->
    </div>
</div>
<%@include file="footer.jsp" %>