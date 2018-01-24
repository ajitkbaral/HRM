<%@include file="header.jsp" %>
<div class="row">
    <div class="col-md-12">
        <div class="box box-default collapsed-box">
            <div class="box-header with-border">
                <h3 class="box-title">Add a Training</h3>
                <div class="box-tools pull-right">
                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
                </div><!-- /.box-tools -->
            </div><!-- /.box-header -->
            <div class="box-body">
                <form role="form" method="POST" action="${pageContext.request.contextPath}/admin/training/insert">
                    <div class="box-body">
                        <div class="form-group">
                            <label>Type of training</label>
                            <select class="form-control" name="type" required>
                                    <option value="Effective Communication">Effective Communication</option>
                                    <option value="Time Management">Time Management</option>
                                    <option value="Project Management">Project Management</option>
                                    <option value="Leadership Training">Leadership Training</option>
                                    <option value="Diversity Training">Diversity Training</option>
                                    <option value="Workshop">Workshop</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="description">Description</label>
                            <textarea class="form-control" id="description" placeholder="Description of the training" name="description" required></textarea>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-6">
                                <label for="trainingStartDate">Start From</label>
                                <input type="date" class="form-control" id="trainingStartDate" name="start_date" disabled required/>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="trainingEndDate">End Till</label>
                                <input type="date" class="form-control" id="trainingEndDate" name="end_date" disabled required/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label>Select a Department</label>
                            <select class="form-control" name="dept_id">
                                <c:forEach items="${departments}" var="department">
                                    <option value="${department.getDeptId()}">${department.getName()}</option>
                                </c:forEach>
                            </select>
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
                <h3 class="box-title">Trainings</h3>
                <div class="box-tools">
                    <!--                    <ul class="pagination pagination-sm no-margin pull-right">
                                            <li><a href="#">«</a></li>
                                            <li><a href="#">1</a></li>
                                            <li><a href="#">2</a></li>
                                            <li><a href="#">3</a></li>
                                            <li><a href="#">»</a></li>
                                        </ul>-->
                </div>
            </div><!-- /.box-header -->
            <div class="box-body no-padding">
                <table class="table">
                    <tbody>
                        <tr>
                            <th style="width: 10px">#</th>
                            <th>Type</th>
                            <th>Description</th>
                            <th>Start From</th>
                            <th>End Till</th>
                            <th>For Department</th>
                            <th>Action</th>
                        </tr>

                        <c:forEach items="${trainings}" var="training">
                            <tr>
                                <td>${training.getTraId()}</td>
                                <td>${training.getType()}</td>
                                <td>${training.getDescription()}</td>
                                <td>${training.getStartDate()}</td>
                                <td>${training.getEndDate()}</td>
                                <td>${training.getDepartment().getName()}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/admin/training/${training.getTraId()}" class="btn btn-primary">Update</a>
                                    <a href="${pageContext.request.contextPath}/admin/training/delete=${training.getTraId()}" class="btn btn-danger">Delete</a>
                                </td>

                            </tr>
                        </c:forEach>
                    </tbody></table>
            </div><!-- /.box-body -->
        </div><!-- /.box -->
    </div>
</div>
<script>
    preventPreviousDate();
    function preventPreviousDate() {
        var startDate = document.getElementById("trainingStartDate");
        var endDate = document.getElementById("trainingEndDate");
        var today = new Date();
// Set month and day to string to add leading 0
        var day = new String(today.getDate());
        var mon = new String(today.getMonth() + 1); //January is 0!
        var yr = today.getFullYear();

        if (day.length < 2) {
            day = "0" + day;
        }
        if (mon.length < 2) {
            mon = "0" + mon;
        }

        var date = new String(yr + '-' + mon + '-' + day);

        startDate.disabled = false;
        startDate.setAttribute('min', date);
        endDate.disabled = false;
        endDate.setAttribute('min', date);
    }

    document.addEventListener('load', onLoad, false);

</script>
<%@include file="footer.jsp" %>