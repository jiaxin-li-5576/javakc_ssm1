$(function()
{
	//选择父类触发事件
	$('#clientid').click(function()
	{
		layer.open({
		  type: 2,
		  title: '客户单选列表',
		  shadeClose: true,
		  shade: 0.8,
		  area: ['65%', '65%'],
		  content: root+'/salesprice/listParent.do'
		}); 
	});

	
});