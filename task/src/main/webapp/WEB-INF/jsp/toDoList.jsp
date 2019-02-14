<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/validate.js/0.12.0/validate.min.js"></script>
<script type="text/javascript" src="/js/validate.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/ui.css" />
<c:set var="screenKey" value="WF0201" /> <!-- 현재페이지 키값 - 메세지에서 사용 -->

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript">
$(function() {
	
	// 목록 출력
	$.ajax({
		type : "GET",
		url : "/task/list",
		success : function(data) {
			var attr = "";
			
			attr +="<tr>";
			attr +="<th>id</th>";
			attr +="<th>할 일</th>";
			attr +="<th>작성일시</th>";
			attr +="<th>최종수정일시</th>";
			attr +="<th>완료처리</th>";
			attr +="</tr>";
			for (var i = 0; i < data.length ; i++) {
				attr +="<tr>";
				attr += "<td>" + data[i].id + "</td>";
				attr += "<td>" + data[i].title + "</td>";
				attr += "<td>" + data[i].regDate + "</td>";
				attr += "<td>" + data[i].updDate + "</td>";
				attr += "<td>" + data[i].finYn + "</td>";
				attr +="</tr>";
				$("#listArea").html(attr);
		    }
		},
		error : function(e) {

		}
	});
	
	function addList(){
		$.ajax({
			type : "POST",
			url : "/task",
			success : function(data) {
				alert(data);
			},
			error : function(e) {

			}
		});
	}
	
	//할 일 추가
	$("#addBtn").click(function(e) {
		$("#addFrm").submit();
		return false;
	});
	
	$('#addFrm').validate({
		rules: {
			title: {required: true}
		},
		messages: {
			title: {
				required: "입력바람", 
			}
		},
		submitHandler: function (frm) {
			$.ajax({
	    	 	url : frm.action,
	    	 	type : 'post',
	    	 	data : $(frm).serialize(),
	    	 	success : function(data, status, xhr) {
		    	 	alert(data.result_code);
	    	 	},
	    	 	error : function(data){
	    	 	}
	    	});
		}
	});
});
</script>
</head>
<body>
<div id="wrap" class="wrap">

	<!-- container -->
	<div id="container">
		<div class="listTitle"></div>
		<form id="addFrm" action="/task" method="post">
			<input type="text" name="title"></input>
			<a id="addBtn" class="btn">추가</a>
		</form>
		<!-- table -->
		<table class="tbltype mgt30" cellpadding="0" cellspacing="0">
			<tbody id="listArea">
			</tbody>
		</table>
		<!-- //table -->
	</div>
	<!-- //container -->

</div>
</body>
</html>
