<%@include file="header.jsp" %>
<div class="row">
    <div class="col-md-12">
        <div class="box">
            <div class="box-header">
                <h3 class="box-title">List of Complaints</h3>
            </div><!-- /.box-header -->
            <div class="box-body no-padding">
                <table class="table">
                    <tbody>
                        <tr>
                            <th>#</th>
                            <th>From</th>
                            <th>To</th>
                            <th>Description</th>
                        </tr>
                        <c:forEach items="${complaints}" var="complaint">
                            <tr>
                                <td>${complaint.getComplaintId()}</td>
                                <td><a href="${pageContext.request.contextPath}/admin/employee/${complaint.getByEmpId()}">${complaint.getByEmployee().getName()}</a></td>
                                <td><a href="${pageContext.request.contextPath}/admin/employee/${complaint.getToEmpId()}">${complaint.getToEmployee().getName()}</a></td>
                                <td>${complaint.getDescription()}</td>
                            </tr>
                        </c:forEach>
                    </tbody></table>
            </div><!-- /.box-body -->
        </div><!-- /.box -->
    </div>
</div>
<%@include file="footer.jsp" %>