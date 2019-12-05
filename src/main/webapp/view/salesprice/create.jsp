<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>销售价添加页面</title>
    <%@ include file="../../common/jsp/header.jsp" %>
    <link href="<%=path%>static/css/plugins/bootstrap-switch/bootstrap-switch.min.css" rel="stylesheet">
</head>
<body>
<div class="wrapper wrapper-content animated fadeInRight">

    <div class="ibox float-e-margins">
        <form action="${path }/dictionary/create.do" method="post" class="form-horizontal" role="form">
            <fieldset>
                <legend>销售价基本信息</legend>
                <div class="form-group">
                    <label class="col-sm-1 control-label" for="ds_host">销售组织</label>
                    <div class="col-sm-3">
                        <input class="form-control" type="text" name=" " placeholder="点击请选择"/>
                    </div>
                    <label class="col-sm-1 control-label" for="client_id">客户</label>
                    <div class="col-sm-3">
                        <input class="form-control" id="clientValue" name="clientPid" type="hidden"/>
                        <input class="form-control" id="clientpid" type="text" readonly placeholder="请点击选择"/>
                    </div>
                    <label class="col-sm-1 control-label" for="ds_name">物资</label>
                    <div class="col-sm-3">
                        <input class="form-control" type="text" name=" " placeholder="点击请选择"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-1 control-label" for="ds_host">计价单位</label>
                    <div class="col-sm-3">
                        <input class="form-control" type="text" name=" "/>
                    </div>
                    <label class="col-sm-1 control-label" for="ds_name">物资分类</label>
                    <div class="col-sm-3">
                        <input class="form-control" type="text" name=" "/>
                    </div>
                    <label class="col-sm-1 control-label" for="ds_name">规格</label>
                    <div class="col-sm-3">
                        <input class="form-control" type="text" name=" " placeholder="点击请选择"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-1 control-label" for="ds_host">价格组</label>
                    <div class="col-sm-3">
                        <input class="form-control" type="text" name=" "/>
                    </div>

                </div>
            </fieldset>
            <fieldset>
                <div class="ibox float-e-margins">
                    <form id="searchForm" action="">
                        <div class="col-sm-10">
                            <table class="table table-striped table-bordered table-hover table-condensed">
                                <thead>
                                <tr>
                                    <th>销售价</th>
                                    <th>生产日期</th>
                                    <th>失效日期</th>
                                    <th>增删行</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:set var="vs"></c:set>
                                <c:forEach var="e" items="${page.list }" varStatus="v">
                                    <tr>
                                        <td><input type="checkbox" name="ids" value="${e.spId }"/></td>
                                        <td>${e.spPrice }</td>
                                        <td><input type="date" class="form-control" value="${e.effectiveDate}"/></td>
                                        <td>${e.expiryDate}</td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                            <div class="page">${page}</div>
                        </div>
                    </form>
                </div>

                <div class="form-group">
                    <div class="col-sm-3">
                        <input type="text" name="code" class="form-control"/>
                    </div>
                    <div class="col-sm-3">
                        <input type="text" name="" class="form-control"/>
                    </div>
                    <div class="col-sm-3">
                        <input type="text" name="" class="form-control"/>
                    </div>

                    <div class="col-sm-3">
                        <input type="button" id="createLine" value="添加" class="btn btn-primary"/>
                    </div>
                </div>
                <div class="form-group" id="addLine"></div>
            </fieldset>
            <fieldset>
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-2 col-md-offset-3"><input type="button" value="返回" class="btn btn-success"
                                                                     onclick="javascript:history.back();"/></div>
                        <label class="col-sm-1 control-label" for="ds_host"></label>
                        <div class="col-sm-2">
                            <input type="reset" value="保存" class="btn btn-danger" id="resetForm"/>
                        </div>
                        <label class="col-sm-1 control-label" for="ds_host"></label>
                        <div class="col-sm-2">
                            <input type="submit" value="保存并提价" class="btn btn-primary"/>
                        </div>
                    </div>
                </div>
            </fieldset>
        </form>
    </div>
</div>
</body>
<script type="text/javascript" src="${path }/static/js/plugins/file-input/fileinput.min.js"></script>
<script type="text/javascript" src="js/salesprice.js"></script>
</html>