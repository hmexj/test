$(function(){
$('#tab').datagrid({
		url:'/webproject/usercontroller.do?type=list',
		title:'用户信息',
		iconCls:'icon-ok',
		collapsible:true,
		//idField:'userid',
		rownumbers:true,
		//queryParams:{type:'list'},
		columns:[[
		           {field:'chk',checkbox:true},
			       {field:'userid',title:'编号'}, 
			       {field:'email',title:'邮箱'},
			       {field:'loginid',title:'用户名'},
			       {field:'upassword',title:'密码'},
			       {field:'usex',title:'性别'},
			       {field:'uaddress',title:'地址'},
			       {field:'utel',title:'电话'},
			       {field:'ustateid',title:'状态编号'},
			       {field:'uroleid',title:'角色编号'}
			    ]]    

	});
})
	