<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Board Read</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Board Read page
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
           		<div class="form-group">
           			<label>bno</label>
           			<input class="form-control" name="bno" value="${member.bno}"  readonly="readonly">
           		</div>
           		
           		<div class="form-group">
           			<label>name</label>
           			<input class="form-control" name="name" value="${member.name}"  readonly="readonly">
           		</div>
           		<div class="form-group">
           			<label>phone</label>
           			<input class="form-control" name="phone"  value="${member.phone}" readonly="readonly">
           		</div>
           		<div class="form-group">
           			<label>address</label>
           			<input class="form-control" name="address" value="${member.address}" readonly="readonly">
           		</div>
           		
           		<div class="form-group">
           			<label>email</label>
           			<input class="form-control" name="email" value="${member.email}"  readonly="readonly">
           		</div>
           		
           		<div class="form-group">
           			<label>age</label>
           			<input class="form-control" name="age" value="${member.age}"  readonly="readonly">
           		</div>
				<button data-oper="modify" class="btn btn-default" onclick="redirectToModifyPage(${member.bno})">Modify</button>
				
				<button data-oper="list" class="btn btn-info" onclick="redirectToMemberList()">List</button>
           		<button data-oper="remove" class="btn btn-info" onclick="removeMember(${member.bno})">Remove</button>
           		
           		<form id="operForm" action="/member/modify" method="get">
           			<input type="hidden" id="bno" name="bno" value="${member.bno}">
           		</form>
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
    
 <script>
 	$(document).ready(function(){
 		var operForm = $("#operForm");
 		
 		$("button[data-oper='modify']").on("click", function(e){
 			operForm.attr("action", "/member/modify").submit();
 		});

 		$("button[data-oper='list']").on("click", function(e){
 			operForm.find("#bno").remove();
 			operForm.attr("action", "/member/list").submit();
 		});
 		
 		
 	});
 	 // 삭제 함수
    function removeMember(bno) {
        var confirmDelete = confirm("게시물을 삭제하시겠습니까?");
        
        if (confirmDelete) {
            // 삭제 버튼을 눌렀을 때 해당 bno를 remove 메소드로 전달
            window.location.href = "/member/remove?bno=" + bno;
        }
    }
 	 
    // List 버튼 클릭 시 실행되는 함수
    function redirectToMemberList() {
        window.location.href = "/member/list";
    }
    
    // Modify 버튼 클릭 시 실행되는 함수
    function redirectToModifyPage(bno) {
        // 해당 게시물의 bno를 이용하여 수정 폼으로 이동
        window.location.href = "/member/modify?bno=" + bno;
    }
 	
 </script>   
    
    
    
    
    
    
    
    
    
    
    
    
    
            
