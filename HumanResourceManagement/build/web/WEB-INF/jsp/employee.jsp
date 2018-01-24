<%@include file="header.jsp" %>
<div class="row">
    <div class="col-md-12">
        <div class="box box-default collapsed-box">
            <div class="box-header with-border">
                <h3 class="box-title">Add an Employee</h3>
                <div class="box-tools pull-right">
                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
                </div><!-- /.box-tools -->
            </div><!-- /.box-header -->
            <div class="box-body">
                <form role="form" method="POST" action="${pageContext.request.contextPath}/admin/employee/insert">
                    <div class="box-body">
                        <div class="form-group">
                            <label for="employeeName">Full Name</label>
                            <input type="text" class="form-control" id="employeeName" placeholder="Enter Employee Name" name="name" required>
                        </div>
                        <div class="form-group">
                            <label for="employeeEmail">Email</label>
                            <input type="email" class="form-control" id="employeeType" placeholder="Example: dohnjoe@gmail.com" name="email" required>
                        </div>
                        <div class="form-group">
                            <label for="address">Address</label>
                            <input class="form-control" id="description" placeholder="Example: Maitighar" name="address" required>
                        </div>
                        <div class="form-group">
                            <label for="gemder">Gender</label>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="gender" id="optionsRadios1" value="M" checked="">
                                    Male
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="gender" id="optionsRadios2" value="F">
                                    Female
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label>Select a department</label>
                            <div class="row">
                                <div class="col-md-8">
                                    <select class="form-control" name="dept_id">
                                        <c:forEach items="${departments}" var="department">
                                            <option value="${department.getDeptId()}">${department.getName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-md-4"  style="margin-top: 8px;">
                                    <a href="${pageContext.request.contextPath}/admin/department/">Add a department</a>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label>Position</label> 
                            <select class="form-control" name="position" required>
                                <option value="Head Of Department">Head Of Department</option>
                                <option value="Manager">Manager</option>
                                <option value="Staff">Staff</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Salary</label>
                            <div class="input-group col-md-4">
                                <span class="input-group-addon">Rs</span>
                                <input type="number" class="form-control" placeholder="Amount" name="salary" maxlength="8" required>
                            </div>
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
                <h3 class="box-title">Employees</h3>
                <div class="box-tools">
                    <form action="" method="get" class="input-group">
                        <c:if test="${not empty param.dept_id}">
                            <input type="hidden" name="dept_id" value="${param.dept_id}"/>
                        </c:if>
                        <input type="text" name="name" class="form-control input-sm pull-right" style="width: 200px;" placeholder="Search by Employee's Name">
                        <div class="input-group-btn">
                            <button class="btn btn-sm btn-default" type="submit"><i class="fa fa-search"></i></button>
                        </div>
                    </form>
                </div>
            </div><!-- /.box-header -->
            <div class="box-body no-padding">
                <table class="table">
                    <tbody>
                        <tr>
                            <th style="width: 10px">#</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Address</th>
                            <th>Gender</th>
                            <th>Position</th>
                            <th>Salary</th>
                            <th>Department</th>
                            <th>Action</th>
                        </tr>

                        <c:forEach items="${employees}" var="employee">
                            <tr>
                                <td>${employee.getEmpId()}</td>
                                <td>${employee.getName()}</td>
                                <td>${employee.getEmail()}</td>
                                <td>${employee.getAddress()}</td>
                                <td>${employee.getGender()}</td>
                                <td>${employee.getPosition()}</td>
                                <td>Rs. ${employee.getSalary()}0</td>
                                <td>${employee.getDepartment().getName()}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/admin/employee/${employee.getEmpId()}" class="btn btn-primary">Update</a>
                                    <a href="${pageContext.request.contextPath}/admin/employee/delete=${employee.getEmpId()}" class="btn btn-danger">Delete</a>
                                </td>

                            </tr>
                        </c:forEach>
                    </tbody></table>
            </div><!-- /.box-body -->
        </div><!-- /.box -->
    </div>
</div>

<%@include file="footer.jsp" %>