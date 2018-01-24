<%@include file="../header.jsp" %>
<div class="row">
    <div class="col-md-12">
        <div class="box box-danger">
            <div class="box-header with-border">
                <h3 class="box-title">Add a Complain</h3>
                <!-- /.box-tools -->
            </div><!-- /.box-header -->
            <div class="box-body">
                <form role="form" method="POST" action="${pageContext.request.contextPath}/emp/complaint">
                    <div class="box-body">
                        <c:if test="${not empty param.emp_id}">
                            <input type="hidden" name="to_emp_id" value="${param.emp_id}"/>
                        </c:if>
                        <div class="form-group">
                            <label for="employeeName">Complain about</label>
                            <input type="text" class="form-control"value="${employee.getName()}" name="name" required disabled>
                        </div>
                        <div class="form-group">
                            <label for="description">Reason</label>
                            <textarea class="form-control" id="description" placeholder="Specify your reason" name="description" required></textarea>
                        </div>
                    </div><!-- /.box-body -->

                    <div class="box-footer">
                        <button type="submit" class="btn btn-primary pull-right">Complain</button>
                    </div>
                </form>
            </div><!-- /.box-body -->
        </div><!-- /.box -->
    </div>
</div>
<%@include file="../footer.jsp" %>