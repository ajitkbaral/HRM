<%@include file="header.jsp" %>
<div class="row">
    <div class="col-md-12">
        <div class="box box-default">
            <div class="box-header with-border">
                <h3 class="box-title">Update Employee</h3>
            </div><!-- /.box-header -->
            <div class="box-body">
                <form role="form" method="POST" action="${pageContext.request.contextPath}/admin/employee/update/${employee.getEmpId()}">
                    <div class="box-body">
                        <div class="form-group">
                            <label for="employeeName">Full Name</label>
                            <input type="text" class="form-control" id="employeeName" placeholder="Enter Employee Name" name="name" value="${employee.getName()}" required>
                        </div>
                        <div class="form-group">
                            <label for="employeeEmail">Email</label>
                            <input type="email" class="form-control" id="employeeType" placeholder="Example: dohnjoe@gmail.com" name="email" value="${employee.getEmail()}" required>
                        </div>
                        <div class="form-group">
                            <label for="address">Address</label>
                            <input class="form-control" id="description" placeholder="Example: Maitighar" name="address" value="${employee.getAddress()}" required>
                        </div>
                        <div class="form-group">
                            <label for="gemder">Gender</label>
                            <c:if test="${employee.getGender() == 'M'}">
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
                            </c:if>
                            <c:if test="${employee.getGender() == 'F'}">
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="gender" id="optionsRadios1" value="M">
                                        Male
                                    </label>
                                </div>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="gender" id="optionsRadios2" value="F" checked="">
                                        Female
                                    </label>
                                </div>
                            </c:if>
                        </div>
                        <div class="form-group">
                            <label>Select a department</label>
                            <p class="help-block" style="font-size: 12px;">Current: ${employee.getDepartment().getName()}</p>
                            <select class="form-control" name="dept_id" required>
                                <option value="${employee.getDeptId()}">${employee.getDepartment().getName()}</option>
                                <c:forEach items="${departments}" var="department">
                                    <c:if test="${department.getDeptId() ne employee.getDeptId()}">
                                        <option value="${department.getDeptId()}">${department.getName()}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Position</label>
                            <p class="help-block" style="font-size: 12px;">Current: ${employee.getPosition()}</p>
                            <select class="form-control" name="position" required>
                                <c:choose>
                                    <c:when test="${employee.getPosition() eq 'Head Of Department'}">
                                        <option value="Head Of Department">Head Of Department</option>
                                        <option value="Manager">Manager</option>
                                        <option value="Staff">Staff</option>
                                    </c:when>
                                    <c:when test="${employee.getPosition() eq 'Manager'}">
                                        <option value="Manager">Manager</option>
                                        <option value="Head Of Department">Head Of Department</option>
                                        <option value="Staff">Staff</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="Staff">Staff</option>
                                        <option value="Head Of Department">Head Of Department</option>
                                        <option value="Manager">Manager</option>
                                    </c:otherwise>
                                </c:choose>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Salary</label>
                            <div class="input-group col-md-4">
                                <span class="input-group-addon">Rs</span>
                                <input type="number" class="form-control" placeholder="Amount" name="salary" value="${employee.getSalary()}" maxlength="8" required>
                            </div>
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
