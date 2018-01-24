<%@include file="header.jsp" %>
<div class="row">
    <div class="col-md-12">
        <div class="box">
            <div class="box-header with-border">
                <h3 class="box-title">Update training</h3>
                <div class="box-tools pull-right">
                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                </div>
            </div><!-- /.box-header -->
            <div class="box-body" style="display: block;">
                <div class="row">
                    <div class="col-md-12">
                        <form role="form" method="POST" action="${pageContext.request.contextPath}/admin/training/update/${training.getTraId()}">
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="trainingType">Type</label>
                                    <input type="text" class="form-control" value="${training.getType()}" id="trainingType" placeholder="Example: Workshop, Field Visit, Brainstroming etc" name="type" required>
                                </div>
                                <div class="form-group">
                                    <label for="description">Description</label>
                                    <textarea class="form-control" id="description" placeholder="Description of the training" name="description" required>${training.getDescription()}</textarea>
                                </div>
                                <div class="row">
                                    <div class="form-group col-md-6">
                                        <label for="trainingStartDate">Start From</label>
                                        <input type="date" class="form-control" value="${training.getStartDate()}" id="trainingStartDate" name="start_date" disabled required/>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="trainingEndDate">End Till</label>
                                        <input type="date" class="form-control" value="${training.getEndDate()}" id="trainingEndDate" name="end_date" disabled required/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label>For Department</label>
                                    <select class="form-control" name="dept_id">
                                        <option value="${training.getDeptId()}">${training.getDepartment().getName()}</option>
                                        <c:forEach items="${departments}" var="department">
                                            <c:if test="${training.getDeptId() ne department.getDeptId()}">
                                                <option value="${department.getDeptId()}">${department.getName()}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div><!-- /.box-body -->
                            <div class="box-footer">
                                <button type="submit" class="btn btn-primary pull-right">Update</button>
                            </div>
                        </form>
                    </div>
                </div><!-- /.row -->
            </div><!-- ./box-body -->
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
