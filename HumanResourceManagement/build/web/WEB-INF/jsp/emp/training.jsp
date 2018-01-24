<%@include file="../header.jsp" %>
<div class="row">
    <div class="col-md-12">
        <div class="box box-primary">
            <div class="box-header">
                <h3 class="box-title">Trainings in the organization</h3>
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
                        </tr>

                        <c:forEach items="${trainings}" var="training">
                            <tr>
                                <td>${training.getTraId()}</td>
                                <td>${training.getType()}</td>
                                <td>${training.getDescription()}</td>
                                <td>${training.getStartDate()}</td>
                                <td>${training.getEndDate()}</td>
                                <td>${training.getDepartment().getName()}</td>

                            </tr>
                        </c:forEach>
                    </tbody></table>
            </div><!-- /.box-body -->
        </div><!-- /.box -->
    </div>
</div>
<%@include file="../footer.jsp" %>