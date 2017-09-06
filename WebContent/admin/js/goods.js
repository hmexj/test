$(function(){
$('#cc').combobox({    
    url:'/webproject/catecontroller.do',    
    valueField:'cid',    
    textField:'cname',
    onSelect:function(){
    	var cid=$(this).combobox('getValue');
    	loadGoods(cid);
    },
    onLoadSuccess:function(){
    	var datas=$(this).combobox('getData');
    	if(datas.length>0){
    		$(this).combobox('setValue',datas[0].cid);
    		var cid=$(this).combobox('getValue');
    		loadGoods(cid);
    	}
    }
   }); 
})
function loadGoods(cid){
	$('#tb').datagrid({
		url:'/webproject/goodscontroller.do',
		pagination:true,
		queryParams:{cid:cid},
		title:"商品列表",
		iconCls:'icon-ok',
		pageSize:10,
		rownumbers:true,
		striped:true,
		columns:[[
		           {field:'chk',checkbox:true},
			       {field:'gid',title:'编号',sortable:true,order:'asc',resizable:true}, 
			       {field:'gtitle',title:'商品名称',sortable:true},
			       {field:'gauthor',title:'供应商'},
			       {field:'gsaleprice',title:'售价'},
			       {field:'ginprice',title:'进价'},
			       {field:'gimg',title:'图片地址'},
			       {field:'gclicks',title:'点击量'},
			       {field:'cid',title:'类别编号'},
			       {field:'pid',title:'出版社'}
			    ]]    
	});
}
