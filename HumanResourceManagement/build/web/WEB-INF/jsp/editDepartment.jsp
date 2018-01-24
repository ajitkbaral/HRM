<%@include file="header.jsp" %>
<div class="row">
    <div class="col-md-12">
        <div class="box">
            <div class="box-header with-border">
                <h3 class="box-title">Update  department</h3>
                <div class="box-tools pull-right">
                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                </div>
            </div><!-- /.box-header -->
            <div class="box-body" style="display: block;">
                <div class="row">
                    <div class="col-md-12">
                    <form role="form" method="POST" action="${pageContext.request.contextPath}/admin/department/update/${department.getDeptId()}">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="departmentName">Department Name</label>
                                <input type="text" class="form-control" value="${department.getName()}" id="departmentName" placeholder="Enter Department Name" name="name" required>
                            </div>
                            <div class="form-group">
                                <label for="departmentType">Type</label>
                                <input type="text" value="${department.getType()}" class="form-control" id="departmentType" placeholder="Example: Human Resource, Finance etc" name="type" required>
                            </div>
                            <div class="form-group">
                                <label for="description">Description</label>
                                <textarea class="form-control" id="description" placeholder="Description of the department" name="description" required>${department.getDescription()}</textarea>
                            </div>
                        </div><!-- /.box-body -->

                        <div class="box-footer">
                            <button type="submit" class="btn btn-primary pull-right">Update</button>
                        </div>
                    </form>
                    </div>
                </div><!-- /.row -->
            </div><!-- ./box-body -->
        </div><!-- /.box -->
    </div>
</div>
<%@include file="footer.jsp" %>
