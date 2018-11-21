<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<%@ include file="/view/public/commons.jspf"%>

</head>

<body>
	<script type="text/javascript">
		function query(condition) {
			$("#keyword").attr("name", condition.value);
		}
	</script>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px;">
			<li><a href="#">系统管理</a></li>
			<li>权限管理</li>
		</ul>
	</div>
	<div class="row">
		<div class="col-sm-2" style="padding-left: 30px;">
			<script type="text/jscript">
				
		
        	d = new dTree('d');
		/* 	d.add(0,-1,'根目录');
            d.add(1,0,'系统管理','','提示','');
			d.add(2,1,'员工管理','${pageContext.request.contextPath}/system/authorty/getAuthortyInfo.action','提示','mainiframe');
			d.add(3,1,'角色管理','${pageContext.request.contextPath}/system/roleinfo/listRoleInfo.action','提示','mainiframe');
			d.add(4,1,'角色变更','${pageContext.request.contextPath}/system/roleinfo/listRoleInfo.action','提示','mainiframe');
			d.add(5,1,'权限管理','${pageContext.request.contextPath}/system/roleinfo/listRoleInfo.action','提示','mainiframe');
			d.add(6,1,'权限变更','${pageContext.request.contextPath}/system/roleinfo/listRoleInfo.action','提示','mainiframe');
			d.add(7,1,'数据字典','${pageContext.request.contextPath}/system/roleinfo/listRoleInfo.action','提示','mainiframe');
			
			d.add(8,0,'招生管理','','提示','');
			d.add(9,8,'学生线索','','提示','mainiframe'); */
			
			function addNode() {
				
				
				
			}
			
			document.write(d);
        
			</script>
		</div>

		<div class="col-sm-10">
			<div align="center">
				<div class="alert alert-warning"
					style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">&times;</span>
					</button>
					<p align="center" style="color: red;">权限信息-${info}</p>
				</div>
			</div>
			<iframe id="mainframe" name="mainiframe"
				style="width: 100%; border: 0px;"></iframe>
			<script type="text/javascript">
				var height = jQuery(window).height() - 300;
				jQuery("#mainframe").attr("height", height + "px");
				jQuery("#mainframe")
						.attr("src",
								"${pageContext.request.contextPath}/system/authorty/listAuthortyInfo.action");
			</script>

		</div>

	</div>


</body>
</html>
