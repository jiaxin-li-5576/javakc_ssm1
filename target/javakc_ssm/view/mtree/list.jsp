<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>测试展示列表页面</title>
		<%@ include file="../../common/jsp/header.jsp"%>
		<link href="<%=path%>/static/css/plugins/ztree/zTreeStyle/zTreeStyle.css" rel="stylesheet">
		<script type="text/javascript" src="<%=path%>/static/js/plugins/ztree/jquery.ztree.core-3.5.js"></script>

    </head>

	<script language="JavaScript">

		$(function(){

		var setting = {
			data: {
				simpleData: {
					enable: true
				}
			}
		};

		$.post(root+'mtree/queryAllcm.do',function(zNodes){
			$.fn.zTree.init($("#mtree"), setting, zNodes);
		},'json')

		})
	</script>

	<body>
		<div class="wrapper wrapper-content animated fadeInRight">
			<div class="ibox float-e-margins">
				<form id="searchForm" action="">
				<div class="col-sm-12">
					<!-- ------------按钮组 start------------ -->
	                <div class="alert alert-success" role="alert">测试详细信息</div>
	                <div class="col-sm-8">
	                	<div class="btn-group hidden-xs" role="group">
                			<button type="button" class="btn btn-primary" data-toggle="modal" id="create" name="mtree/create.jsp">
	                            <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>添加
	                        </button>
	                        <button type="button" class="btn btn-success" data-toggle="modal" id="update" name="test/view.do">
	                            <i class="glyphicon glyphicon-pencil" aria-hidden="true"></i>修改
	                        </button>
	                        <button type="button" class="btn btn-danger" data-toggle="modal" id="delete" name="test/delete.do">
	                            <i class="glyphicon glyphicon-trash" aria-hidden="true"></i>删除
	                        </button>
		                 </div>

	                <div class="col-sm-4">
	                	<input class="form-control" id="search" name="testName" value="${testEntity.testName }" type="text" placeholder="查询内容 回车搜索"/>

                        <table class="table table-striped table-bordered table-hover table-condensed">

                            <ul id="mtree" class="ztree"></ul>
                        </table>
                    </div>
                    </div>


			     </div>
			     </form>
			</div>
		</div>
	</body>
</html>