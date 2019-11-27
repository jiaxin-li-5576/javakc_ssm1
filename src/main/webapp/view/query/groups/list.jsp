<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>组织单选列表页面</title>
		<%@ include file="../../../common/jsp/header.jsp"%>
        <link rel="stylesheet" href="<%=path%>/static/css/plugins/ztree/zTreeStyle/zTreeStyle.css" type="text/css">
        <script type="text/javascript" src="<%=path%>/static/js/plugins/ztree/jquery.ztree.core-3.5.min.js"></script>
	</head>
    
    <script language="JavaScript">
        $(function () {
            var tree;
            var setting = {
                data: {
                    simpleData: {
                        enable: true
                    }
                },
                view: {
                    fontCss: getFontCss
                }
            };
            $.post(root+'groups/query.do',function(zNodes){
                tree=$.fn.zTree.init($("#treeDemo"), setting, zNodes);
            },'json')

            $("#query").click(function (){
                var groupName=$("#groupName").val();
                var node=tree.getNodeByParam("name",groupName,"")
                node.highlight=true;
                tree.updateNode(node);
                tree.selectNode(node);
            })

            //修改
            $("#updateGroup").click(function(){
                var nodes=tree.getSelectedNodes();
                if(nodes.length!=1){
                    alert("请选择一条数据进行修改！");
                    return false;
                }
                var id="";
                for(var i=0;i<nodes.length;i++){
                    id=nodes[i].id;
                }
                $("#groupId").val(id);
                var url = root+$(this).attr('name');
                $("#searchForm").attr('action', url).submit();

            })

            //删除
            $("#delete").click(function(){
                var nodes=tree.getSelectedNodes();
                if(nodes.length!=1){
                    alert("请选择一条数据进行删除！");
                    return false;
                }
                var id="";
                for(var i=0;i<nodes.length;i++){
                    id=nodes[i].id;
                }
                $("#groupId").val(id);
                var url=root+$(this).attr('name');
                swal({
                    title: "确定要删除吗?",
                    text: "删除后将无法恢复当前记录!",
                    type: "warning",
                    showCancelButton: true,
                    confirmButtonColor: "#DD6B55",
                    confirmButtonText: "是的, 不后悔!",
                    cancelButtonText: "算了, 再想想!",
                    closeOnConfirm: false,
                    closeOnCancel: false
                }, function(isConfirm){
                    if (isConfirm) {
                        swal("成功!", "删除成功,再也找不回来了.", "success");
                            $("#searchForm").attr('action', url).submit();
                    } else {
                        swal("取消", "吓死了,幸亏没删了!", "error");
                    }
                });
            })
        })
        function getFontCss(treeId, treeNode) {
            return (!!treeNode.highlight) ? {color:"#A60000", "font-weight":"bold"} : {color:"#333", "font-weight":"normal"};
        }

    </script>
	<body>
		<div class="wrapper wrapper-content animated fadeInRight">
			<div class="ibox float-e-margins">
				<form id="searchForm" action="">
                    <input type="hidden" name="groupId" id="groupId" value="">
				<div class="col-sm-12">
					<!-- ------------按钮组 start------------ -->
	                <div class="alert alert-success" role="alert">组织单选详细信息</div>
	                <div class="col-sm-6">
	                	<div class="btn-group hidden-xs" role="group">
                			<button type="button" class="btn btn-primary" data-toggle="modal" id="create" name="query/groups/create.jsp">
	                            <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>添加
	                        </button>
	                        <button type="button" class="btn btn-success" data-toggle="modal" id="updateGroup" name="groups/view.do">
	                            <i class="glyphicon glyphicon-pencil" aria-hidden="true"></i>修改
	                        </button>
	                        <button type="button" class="btn btn-danger" data-toggle="modal" id="delete" name="groups/delete.do">
	                            <i class="glyphicon glyphicon-trash" aria-hidden="true"></i>删除
	                        </button>
		                 </div>
	                </div>
	                <div class="col-sm-6">
                        <div class="btn-group hidden-xs col-sm-2" role="group">
                            <button type="button" class="btn btn-info" data-toggle="modal" id="query" name="">
                                <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>查看
                            </button>
                        </div>
                        <div class="col-sm-6">
                            <input class="form-control" id="groupName" name="groupName" value="" type="text"/>
                        </div>
	                </div>
	                 <!-- ------------按钮组 end------------ -->

			     </div>
                    <div class="col-sm-12">
                        <table class="table table-striped table-bordered table-hover table-condensed">
                            <ul id="treeDemo" class="ztree"></ul>
                        </table>
                    </div>
			     </form>
			</div>
		</div>
	</body>
</html>