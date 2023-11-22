<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Board Register</h1>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Board Register
            </div>
            <div class="panel-body">
            	<form role="from" method="post">
            		<div class="form-group">
            			<label>name</label>
            			<input class="form-control" name="name">
            		</div>
            		<div class="form-group">
            			<label>phone</label>
            			<input class="form-control" name="phone">
            		</div>
            		<div class="form-group">
            			<label>address</label>
            			<input class="form-control" name="address">
            		</div>
            		<div class="form-group">
            			<label>email</label>
            			<input class="form-control" name="email">
            		</div>
            		<div class="form-group">
            			<label>age</label>
            			<input class="form-control" name="age">
            		</div>
            		<button type="submit" class="btn btn-default">Submit Button</button>
            		<button type="reset" class="btn btn-danger">Reset Button</button>
            	</form>
            </div>
        </div>
    </div>
</div>
            
