<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Board Modify Page
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
            	<form role="form" action="/member/modify" method="post">
	           		
	           		<div class="form-group">
	           			<label>Bno</label>
	           			<input class="form-control" name="bno" value="${member.bno}"  readonly="readonly">
	           		</div>
	           		
	           		<div class="form-group">
	           			<label>name</label>
	           			<input class="form-control" name="name" value="${member.name}" readonly="readonly">
	           		</div>-==
	           		<div class="form-group">
	           			<label>phone</label>
	           			<input class="form-control" name="phone" value="${member.phone}">
	           		</div>
	           		<div class="form-group">
	           			<label>address</label>
	           			<input class="form-control" name="address" value="${member.address}"  >
	           		</div>
	           		
	           		<div class="form-group">
	           			<label>email</label>
	           			<input class="form-control" name="email" value="${member.email}"  readonly="readonly">
	           		</div>
	           		
	           		<div class="form-group">
	           			<label>age</label>
	           			<input class="form-control" name="age" value="${member.age}" >
	           		</div>
	           		
	           		
	           
	           		<button type="submit" data-abcd="modify" class="btn btn-default">Modify</button>
	
	           		
           		</form>
            </div> <!-- /.panel-body -->
            
        </div> <!-- /.panel -->
        
    </div>  <!-- /.col-lg-12 -->
   
</div> <!-- /.row -->



</body>
</html>