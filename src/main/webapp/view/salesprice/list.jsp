<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>销售价展示列表页面</title>
    <%@ include file="../../common/jsp/header.jsp" %>
    <link href="<%=path%>static/css/plugins/bootstrap-switch/bootstrap-switch.min.css" rel="stylesheet">
</head>
<script>
    function change() {
        alert(document.all("salespricestatus").value)
    }
</script>
<body>
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="ibox float-e-margins">
        <form id="searchForm" action="">
            <div class="alert">
                <div class="form-group">
                    <label class="col-sm-1 control-label" for="clientid">客户</label>
                    <div class="col-sm-3">
                        <input class="form-control" id="clientIdValue" name="clientId" type="hidden"/>
                        <input class="form-control" id="clientid" type="text" readonly placeholder="点击请选择"/>
                    </div>
                    <label class="col-sm-1 control-label" for="ds_name">物资</label>
                    <div class="col-sm-3">
                        <input class="form-control" type="text" name=" "/>
                    </div>
                    <label class="col-sm-1 control-label" for="ds_name">销售组织</label>
                    <div class="col-sm-3">
                        <input class="form-control" type="text" name=" " readonly placeholder="点击请选择"/>
                    </div>

                </div>

            </div>
            <div class="alert">
                <div class="form-group">
                    <label for="disabledSelect" class="col-sm-1 control-label">状态</label>
                    <div class="col-sm-3">
                        <zhg:select onChange="change()" name="salespricestatus" codeTp="status" def="true"
                                    cls="form-control"></zhg:select>
                        <input class="form-control" id="search" name="status" value="${entity.status}" type="text"
                               placeholder="查询内容 回车搜索"/>

                    </div>

                </div>
            </div>
            <!-- ------------按钮组 start------------ -->

            <div class="col-sm-8">
                <div class="btn-group hidden-xs" role="group">
                    <button type="button" class="btn btn-primary" data-toggle="modal" id="create"
                            name="salesprice/create.jsp">
                        <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>添加
                    </button>
                    <button type="button" class="btn btn-success" data-toggle="modal" name="salesprice/view.do">
                        <i class="glyphicon glyphicon-pencil" aria-hidden="true"></i>查询
                    </button>

                </div>
            </div>

            <!-- ------------按钮组 end------------ -->

            <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
            <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
            <table class="table table-striped table-bordered table-hover table-condensed">
                <thead>
                <tr>
                    <th><input type="checkbox" id="checkall"/></th>
                    <th>销售组织</th>
                    <th>调价组</th>
                    <th>客户</th>
                    <th>销售价编号</th>
                    <th>物资</th>
                    <th>物资分类</th>
                    <th>规格</th>
                    <th>计价单位</th>
                    <th>价格员</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:set var="vs"></c:set>
                <c:forEach var="e" items="${page.list }" varStatus="v">
                    <tr>
                        <td><input type="checkbox" name="ids" value="${e.spId }"/></td>
                            <%--						                <td>${e.groupId}</td>--%>
                            <%--						                <td>${e.clientId }</td>--%>
                            <%--						                <td>${e.goodsId }</td>--%>
                        <td>${e.spPrice }</td>
                        <td>${e.spPrice}</td>
                        <td>${e.spPrice}</td>
                        <td>
                            <div class="col-sm-8">
                                <div class="btn-group hidden-xs" role="group">
                                    <a  class="btn" data-toggle="modal" id="findList"
                                        href="<%=path%>/salesprice/view/${e.spId}.do">
                                        <i class="glyphicon " aria-hidden="true"></i>${e.spId }
                                    </a>
                                </div>
                            </div></td>
                        <td>${e.spPrice}</td>
                        <td><fmt:formatDate value="${e.expiryDate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                        <td>${e.version }</td>
                        <td><fmt:formatDate value="${e.expiryDate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                        <td>${e.spPrice }</td>
                        <td>${e.status }</td>
                        <td>

                            <div class="col-sm-8">
                                <div class="btn-group hidden-xs" role="group">
                                    <a  class="btn" data-toggle="modal" id="update"
                                            href="<%=path%>/salesprice/view/${e.spId}.do">
                                        <i class="glyphicon " aria-hidden="true"></i>调价
                                        <i class="glyphicon " aria-hidden="true"></i>编辑
                                        <i class="glyphicon " aria-hidden="true"></i>审核
                                    </a>
                                </div>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="page">${page}</div>
    </form>
</div>
</div>
</body>
<script type="text/javascript" src="${path }/static/js/plugins/bootstrap-switch/bootstrap-switch.min.js"></script>
<script type="text/javascript" src="${path }/view/salesprice/js/salesprice-list.js"></script>

</html>