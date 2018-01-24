<%@include file="../header.jsp" %>
<div class="row">
    <div class="col-md-6">
        <div class="col-md-12">
            <div class="box box-danger">
                <div class="box-header with-border">
                    <h3 class="box-title"><i class="fa fa-flag"></i><span>  My Trainings</span></h3>
                </div><!-- /.box-header -->
                <div class="box-body">
                    <table class="table table-bordered">
                        <tbody><tr>
                                <th>Type</th>
                                <th>Start Date</th>
                                <th>End Date</th>
                            </tr>
                            <c:forEach items="${trainings}" var="training">
                                <tr>
                                    <td>${training.getType()}</td>
                                    <td>${training.getStartDate()}</td>
                                    <td>${training.getEndDate()}</td>
                                </tr>
                            </c:forEach>
                        </tbody></table>
                </div><!-- /.box-body -->
            </div><!-- /.box -->
        </div>
    </div>
    <div class="col-md-6">
        <div class="box box-success">
            <div class="box-header">
                <h3 class="box-title"><i class="fa fa-user-plus"></i><span> New Employees in my department</h3>
            </div><!-- /.box-header -->
            <div class="box-body no-padding">
                <table class="table">
                    <tbody>
                        <tr>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Position</th>
                        </tr>

                        <c:forEach items="${employees}" var="employee">
                            <tr>
                                <td>${employee.getName()}</td>
                                <td>${employee.getEmail()}</td>
                                <td>${employee.getPosition()}</td>
                            </tr>
                        </c:forEach>
                    </tbody></table>
            </div><!-- /.box-body -->
        </div><!-- /.box -->
    </div>

</div>
<%@include file="../footer.jsp" %>