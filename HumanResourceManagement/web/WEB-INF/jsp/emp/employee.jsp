<%@include file="../header.jsp" %>
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
                                <td>${employee.getDepartment().getName()}</td>
                                <td>
                                    <c:if test="${employee.getEmpId() ne sessionScope.user.getEmpId()}">
                                        <a href="${pageContext.request.contextPath}/emp/complaint?emp_id=${employee.getEmpId()}">Complain</a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody></table>
            </div><!-- /.box-body -->
        </div><!-- /.box -->
    </div>
</div>

<%@include file="../footer.jsp" %>