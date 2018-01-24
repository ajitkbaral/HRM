<%@include file="../header.jsp" %>
<div class="row">
    <div class="col-md-12">
        <div class="box box-success">
            <div class="box-header">
                <h3 class="box-title">Departments</h3>
            </div><!-- /.box-header -->
            <div class="box-body no-padding">
                <table class="table">
                    <tbody>
                        <tr>
                            <th>Name</th>
                            <th>Type</th>
                            <th>Description</th>
                            <th>Employees</th>
                        </tr>

                        <c:forEach items="${departments}" var="department">
                            <tr>
                                <td>${department.getName()}</td>
                                <td>${department.getType()}</td>
                                <td>${department.getDescription()}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/emp/employee?dept_id=${department.getDeptId()}">View List</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody></table>
            </div><!-- /.box-body -->
        </div><!-- /.box -->
    </div>
</div>

<%@include file="../footer.jsp" %>