<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../includes/header.jsp" %>
    
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
                    <label>Bno</label>
                    <input class="form-control" name="bno" value="${board.bno}"  readonly="readonly">
                 </div>
                 
                 <div class="form-group">
                    <label>Title</label>
                    <input class="form-control" name="title" value="${board.title}"  readonly="readonly">
                 </div>
                 <div class="form-group">
                    <label>Text area</label>
                    <textarea class="form-control" rows="3" name="content"  readonly="readonly">${board.content}</textarea>
                 </div>
                 <div class="form-group">
                    <label>Writer</label>
                    <input class="form-control" name="writer" value="${board.writer}"  readonly="readonly">
                 </div>
           
                 <button data-oper="modify" class="btn btn-default">Modify</button>
                 <button data-oper="list" class="btn btn-info">List</button>
                 
                 <form id="operForm" action="/board/modify" method="get">
                    <input type="hidden" id="bno" name="bno" value="${board.bno}">
                    <input type="hidden"  name="pageNum" value="${cri.pageNum}">
                    <input type="hidden"  name="amount" value="${cri.amount}">
                    
                    <!-- 검색 페이지에서 list로 이동했을 다시 같은 키워드+넘버페이지로 돌아가는.. --> 
                    <input type ="hidden" name="type" value="${cri.type}"   />
                   <input type ="hidden" name="keyword" value="${cri.keyword}"   />   
                 </form>
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<!--------------------- 댓글 ------------------------>

<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                <i class ="fa fa-comments fa-fw"></i>Reply
                <button id="addReplyBtn" class="btn btn-warning btn-xs pull-right">
                   New Reply
                </button>
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                 
                 <ul class="chat">
                    <li class="left clearfix" data-rno='12'>
                       <div>
                          <div class = "header">
                             <strong class="primary-font">user00</strong>
                             <small class="pull-right text-muted">2023-11-06 11:20</small>
                          </div>
                          <p>Good Job!
                       </div>
                    </li>
                 </ul>
                 
            </div>
            <!-- /.panel-body -->
            
            <div class= "panel-footer">
            </div>
            
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<!---------------------/댓글 ------------------------>


<!-- 모달창 추가 ----------------------------------------------->
<div class="modal" id="myModal">
   <div class="modal-dialog">
      <div class="modal-content">
         <!-- Modal Header -->
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title" id="myModalLabel">REPLY MODAL</h4>
         </div>
         <!-- Modal body -->
         <div class="modal-body">
            <div class="form-group">
               <label>Reply</label> 
               <input class="form-control" name="reply" value="new Reply!!??!!">
            </div>
            <div class="form-group">
               <label>Replyer</label> 
               <input class="form-control" name="replyer" value="new Replyer">
            </div>
            <div class="form-group">
               <label>Reply Date</label> 
               <input class="form-control" name="replyDate" value="">
            </div>
         </div>
         <!-- Modal footer -->
         <div class="modal-footer">
            <button id="modalRegisterBtn" type="button" class="btn btn-primary" >Register</button>
            <button id="modalModBtn" type="button" class="btn btn-warning" >Modify</button>
            <button id="modalRemoveBtn" type="button" class="btn btn-danger" >Remove</button>
            <button id="modalCloseBtn" type="button" class="btn btn-info" data-dismiss="modal" >Close</button>
         </div>
      </div>
   </div>
</div>
<!-- /모달창 추가 ----------------------------------------------->

<style>
   .chat > li : hover{
      cursor:pointer;
   }
</style>

<script type = "text/javascript" src="/resources/js/reply.js"> </script>

<script>
   var bnoValue = '${board.bno}'; //1966110
   var replyUL = $(".chat");
   
   showList(1);
   
   function showList(page){
      replyService.getList({bno:bnoValue, page: page||1}, function(replyCnt, list){
         
         console.log("replyCnt------> " + replyCnt);
         console.log(" list------> " + list);
         
         if(page == -1){
            pageNum = Math.ceil(replyCnt/10.0);
            showList(pageNum);
            return;
         }
         
         var str="";
         
         if(list == null || list.length==0){
            replyUL.html("");
            return;
         }
         for(var i=0, len=list.length || 0; i<len; i++){
            
            str += "<li class='left clearfix' data-rno='"+ list[i].rno +"'>";
            str += "<div><div class = 'header'>";
            str += "<strong class='primary-font'>"+ list[i].replyer +"</strong>";
            str += "<small class='pull-right text-muted'>"+ replyService.displayTime(list[i].replyDate) +"</small>";
            str += "<div><p>"+ list[i].reply +"</p>";
            str += "</div></li>";
         }
         replyUL.html(str);
         
         showReplyPage(replyCnt);
      }); //end function
      
   } //end showList
   
   
      var modal = $(".modal");
      var modalInputReply = modal.find("input[name='reply']");
      var modalInputReplyer = modal.find("input[name='replyer']");
      var modalInputReplyDate = modal.find("input[name='replyDate']");
      
      var modalRegisterBtn = $("#modalRegisterBtn");
      var modalModBtn = $("#modalModBtn");
      var modalRemoveBtn = $("#modalRemoveBtn");
      var modalCloseBtn = $("#modalCloseBtn");
   
   // 댓글창 보여주기
   myModal
   $("#addReplyBtn").on("click", function(e){
      
      modal.find("input").val("");
      modalInputReplyDate.closest("div").hide();
      modal.find("button[id != 'modalCloseBtn']").hide();
      modalRegisterBtn.show();
      
      $(".modal").modal("show");
   });
   
   // 댓글 등록
   modalRegisterBtn.on("click", function(e){
      var reply = {
            bno : bnoValue,
            reply : modalInputReply.val(),
            replyer : modalInputReplyer.val()
      };
      
      replyService.add(reply, function(result){
         alert(result);
         modal.find("input").val();
         modal.modal("hide");
         
         showList(-1);   //댓글 내용 새로고침
      });
   });
   
   
   
   //댓글 조회 클릭 이벤트 처리
   $(".chat").on("click", "li", function(e){ //one조심
      var rno = $(this).data("rno");
      //console.log("rno ---> " + rno);
      
      replyService.get(rno, function(reply){
         modalInputReply.val(reply.reply);
         modalInputReplyer.val(reply.replyer);
         modalInputReplyDate.val(replyService.displayTime(reply.replyDate)).attr("readonly", "readonly");
         
         modal.data("rno", reply.rno);
      
         modal.find("button[id != 'modalCloseBtn']").hide();
         modalModBtn.show();
         modalRemoveBtn.show();
         
         $(".modal").modal("show");
      });
      
   });
   
   // 댓글 수정
   modalModBtn.on("click", function(e){
      
      var reply = {
            rno: modal.data("rno"),
            reply: modalInputReply.val()
      };
      
      replyService.update(reply, function(result){
         alert(result);
         modal.modal("hide");
         showList(pageNum);
      });
   });
   
   // 댓글 삭제
   modalRemoveBtn.on("click", function(e){
      
      var rno = modal.data("rno"); //삭제니까 번호만 가면 된다-
      
      replyService.remove(rno, function(result){
         alert(result);
         modal.modal("hide");
         showList(pageNum);
      });
   });
   
    var pageNum = 1;
    var replyPageFooter = $(".panel-footer");
    
    function showReplyPage(replyCnt){
       var endNum = Math.ceil(pageNum/10.0) * 10;
       var startNum = endNum -9;
       var prev = startNum != 1;
       var next = false;
       
       if(endNum * 10 >= replyCnt){
          endNum = Math.ceil(replyCnt/10.0);
       }
       if(endNum * 10 < replyCnt){
          next = true;
       }
       var str = "<ul class='pagination pull-right'>";
       if(prev){
          str += "<li class='page-item><a class='page-link' href='" + (startNum-1)+ "'>Previous</a></li>"
       }
       for(var i = startNum; i <= endNum; i++){
          console.log(pageNum);
          var active = pageNum == i ? "active" : "";
          str += "<li class='page-item "+active+"'><a class='page-link' href='" +i+ "'>" + i +"</a></li>"
       }
       if(next){
          str += "<li class='page-item'><a class='page-link' href='"+(endNum+1)+"'>Next</a></li>";
       } 
          str += "</ul>";
          console.log(str);
          replyPageFooter.html(str);
    }
    //댓글 페이지 이벤트 처리
    
    replyPageFooter.on("click","li a", function(e){
       e.preventDefault();
       var targetPageNum = $(this).attr("href");
       pageNum = targetPageNum;
       showList(targetPageNum);
    });
      
      
   
      
   /*
   replyService.get(
      21,
      function(data) {
         console.log(data);
      },
      function(err){
         console.log(err);
      }
   );
   */
   
   /*
   replyService.update(
         {rno:7, reply:"Modify Reply....."},
         function(data){
            alert("수정완료! 수정완료! 수정완료! 수정완료!" + data);
         },
         function(er) {
            alert("실패 ㅋㅋㅋㅋㅋㅋㅋ" + er);
         }
   );
   */
   
   /*
   replyService.remove(
      11,                // 삭제할 게시글 번호
      function(data){         // 성공했을 때
         console.log(data);
         if(data === "success"){
            alert("REMOVED!!!!");
         }
      },function(err){      //실패했을 때
         alert("ERROR...T_T");
      }
   );
   */
   
   /*
   replyService.getList({bno:bnoValue, page:1}, function(list){
      for(var i=0, len = list.length || 0; i<len; i++){
         console.log(list[i]);
      }
   });
   */
   
   /* 
   var addValue = {
         reply : "JS TEST",
         replyer : "tester",
         bno : bnoValue
   };
   
   replyService.add(addValue, function(result){
      alert("RESULT :" + result);
   }); 
   */
   
</script>



<script>
   $(document).ready(function(){
   });
   
</script>
 <script>
    $(document).ready(function(){
       var operForm = $("#operForm");
       
       $("button[data-oper='modify']").on("click", function(e){
          operForm.attr("action", "/board/modify").submit();
       });

       $("button[data-oper='list']").on("click", function(e){
          operForm.find("#bno").remove();
          operForm.attr("action", "/board/list").submit();
       });
       
       
    });
 </script>   
    
    
    
    
    
    
    
    
    
    
    
    
    
            
<%@ include file="../includes/footer.jsp" %> 