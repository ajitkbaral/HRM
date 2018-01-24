<%@include file="header.jsp" %>

<!-- Info boxes -->
<div class="row">
    <div class="col-md-3 col-sm-6 col-xs-12">
        <div class="info-box">
            <span class="info-box-icon bg-aqua"><i class="ion ion-ios-gear-outline"></i></span>
            <div class="info-box-content">
                <span class="info-box-text">CPU Traffic</span>
                <c:choose>
                    <c:when test="${traffic eq 'NaN'}">
                        <span class="info-box-number">0.01<small>%</small></span>
                    </c:when>
                    <c:otherwise>
                        <span class="info-box-number">${traffic}<small>%</small></span>
                    </c:otherwise>
                </c:choose>
            </div><!-- /.info-box-content -->
        </div><!-- /.info-box -->
    </div><!-- /.col -->
    <!-- fix for small devices only -->
    <div class="clearfix visible-sm-block"></div>

    <div class="col-md-3 col-sm-6 col-xs-12">
        <div class="info-box">
            <span class="info-box-icon bg-green"><i class="fa fa-institution "></i></span>
            <div class="info-box-content">
                <span class="info-box-text">Departments</span>
                <span class="info-box-number">${departments}</span>
            </div><!-- /.info-box-content -->
        </div><!-- /.info-box -->
    </div><!-- /.col -->
    <div class="col-md-3 col-sm-6 col-xs-12">
        <div class="info-box">
            <span class="info-box-icon bg-yellow"><i class="ion ion-ios-people-outline"></i></span>
            <div class="info-box-content">
                <span class="info-box-text">Employees</span>
                <span class="info-box-number">${employees}</span>
            </div><!-- /.info-box-content -->
        </div><!-- /.info-box -->
    </div><!-- /.col -->

    <div class="col-md-3 col-sm-6 col-xs-12">
        <div class="info-box">
            <span class="info-box-icon bg-red"><i class="glyphicon glyphicon-flag"></i></span>
            <div class="info-box-content">
                <span class="info-box-text">Trainings</span>
                <span class="info-box-number">${trainings}</span>
            </div><!-- /.info-box-content -->
        </div><!-- /.info-box -->
    </div><!-- /.col -->
</div><!-- /.row -->

<!-- Main row -->
<div class="row">
    <div class="col-md-12">
        <div class="col-md-6">
            <div class="box box-danger">
                <div class="box-header with-border">
                    <h3 class="box-title"><i class="fa fa-flag"></i><span>  Recent Trainings</span></h3>
                </div><!-- /.box-header -->
                <div class="box-body">
                    <table class="table table-bordered">
                        <tbody><tr>
                                <th>Type</th>
                                <th>Department</th>
                                <th>Start Date</th>
                                <th>End Date</th>
                            </tr>
                            <c:forEach items="${recentTrainings}" var="training">
                                <tr>
                                    <td>${training.getType()}</td>
                                    <td>${training.getDepartment().getName()}</td>
                                    <td>${training.getStartDate()}</td>
                                    <td>${training.getEndDate()}</td>
                                </tr>
                            </c:forEach>
                        </tbody></table>
                </div><!-- /.box-body -->
            </div><!-- /.box -->
        </div>
        <div class="col-md-6">
            <div class="box box-success">
                <div class="box-header with-border">
                    <h3 class="box-title"><i class="fa fa-institution"></i><span>  Recent added Departments</span></h3>
                </div><!-- /.box-header -->
                <div class="box-body">
                    <table class="table table-bordered">
                        <tbody><tr>
                                <th>Name</th>
                                <th>Type</th> 
                            </tr>
                            <c:forEach items="${recentDepartments}" var="department">
                                <tr>
                                    <td>${department.getName()}</td>
                                    <td>${department.getType()}</td>
                                </tr>
                            </c:forEach>
                        </tbody></table>
                </div><!-- /.box-body -->
            </div><!-- /.box -->
        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-12">
        <div class="box box-warning">
            <div class="box-header with-border">
                <h3 class="box-title"><i class="ion ion-ios-people"></i><span>  Recent added Employees</span></h3>
            </div><!-- /.box-header -->
            <div class="box-body">
                <table class="table table-bordered">
                    <tbody><tr>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Gender</th>
                            <th>Position</th>
                            <th>Department</th> 
                        </tr>
                        <c:forEach items="${recentEmployees}" var="employee">
                            <tr>
                                <td>${employee.getName()}</td>
                                <td>${employee.getEmail()}</td>
                                <td>${employee.getGender()}</td>
                                <td>${employee.getPosition()}</td>
                                <td>${employee.getDepartment().getName()}</td>
                            </tr>
                        </c:forEach>
                    </tbody></table>
            </div><!-- /.box-body -->
        </div><!-- /.box -->
    </div>
</div><!-- /.row -->
<%@include file="footer.jsp" %>