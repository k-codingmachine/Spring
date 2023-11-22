<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>게시판 목록</title>
    <style>
        table {
            width: 80%; /* 필요에 따라 너비 조정 */
            border-collapse: collapse;
            margin: 20px; /* 선택 사항: 더 나은 모양을 위해 여백 추가 */
        }

        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
    </style>
</head>
<body>

<h2>게시판 목록</h2>
<button id="regBtn" type="button" class="btn btn-xs btn-primary pull-right">
Register New Board
</button>
<table>
    <thead>
        <tr>
            <th>BNO</th>
            <th>이름</th>
            <th>전화번호</th>
            <th>주소</th>
            <th>이메일</th>
            <th>나이</th>
        </tr>
    </thead>
    <tbody>
   <c:forEach var="member" items="${list}">
            <tr>
                <td>
                    <a class="move" href="get?bno=${member.bno}">${member.bno}</a>
                </td>
                <td>${member.name}</td>
                <td>${member.phone}</td>
                <td>${member.address}</td>
                <td>${member.email}</td>
                <td>${member.age}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<script>
    // 버튼을 클릭했을 때 실행되는 함수
    document.getElementById("regBtn").onclick = function() {
        // register.jsp로 이동하는 코드
        window.location.href = "register";
    };

    // 게시물 번호를 클릭했을 때 실행되는 함수
    document.querySelectorAll(".move").forEach(function(link) {
        link.addEventListener("click", function(event) {
            // 클릭된 게시물 번호에 해당하는 get.jsp로 이동하는 코드
            event.preventDefault();
            window.location.href = event.target.getAttribute("href");
        });
    });
</script>

</body>
</html>