<%@include file="header.jsp" %>
<div class="row">
    <div class="col-md-12">
        <div class="box box-default collapsed-box">
            <div class="box-header with-border">
                <h3 class="box-title">Add a Department</h3>
                <div class="box-tools pull-right">
                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
                </div><!-- /.box-tools -->
            </div><!-- /.box-header -->
            <div class="box-body">
                <form role="form" method="POST" action="${pageContext.request.contextPath}/admin/department/insert">
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="departmentName">Department Name</label>
                                    <input type="text" class="form-control" id="departmentName" placeholder="Enter Department Name" name="name" required>
                                </div>
                                <div class="form-group">
                                    <label for="departmentType">Type</label>
                                    <input type="text" class="form-control" id="departmentType" placeholder="Example: Human Resource, Finance etc" name="type" required>
                                </div>
                                <div class="form-group">
                                    <label for="description">Description</label>
                                    <textarea class="form-control" id="description" placeholder="Description of the department" name="description" required></textarea>
                                </div>
                            </div><!-- /.box-body -->

                            <div class="box-footer">
                                <button type="submit" class="btn btn-primary pull-right">Add</button>
                            </div>
                        </form>
            </div><!-- /.box-body -->
        </div><!-- /.box -->
    </div>
</div>
<div class="row">
    <div class="col-md-12">
        <div class="box">
            <div class="box-header">
                <h3 class="box-title">Departments</h3>
            </div><!-- /.box-header -->
            <div class="box-body no-padding">
                <table class="table">
                    <tbody>
                        <tr>
                            <th style="width: 10px">#</th>
                            <th>Name</th>
                            <th>Type</th>
                            <th>Description</th>
                            <th>Employees</th>
                            <th>Action</th>
                        </tr>

                        <c:forEach items="${departments}" var="department">
                            <tr>
                                <td>${department.getDeptId()}</td>
                                <td>${department.getName()}</td>
                                <td>${department.getType()}</td>
                                <td>${department.getDescription()}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/admin/employee?dept_id=${department.getDeptId()}">View List</a>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/admin/department/${department.getDeptId()}" class="btn btn-primary" style="margin: 3px;">Update</a>
                                    <a href="${pageContext.request.contextPath}/admin/department/delete=${department.getDeptId()}" class="btn btn-danger" style="margin: 3px;">Delete</a>
                                </td>

                            </tr>
                        </c:forEach>
                    </tbody></table>
            </div><!-- /.box-body -->
        </div><!-- /.box -->
    </div>
</div>

<%@include file="footer.jsp" %>