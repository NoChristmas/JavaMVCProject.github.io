<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 내역</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/orderList.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer_style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript"> 
</script>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<div class="whole">
  <div class="container">
    <div class="left-div">
    
	  <div class="page-name">내 정보</div>
	    <ul class="menu-box">
	      <li><a class="detail-menu" href="${pageContext.request.contextPath}/member/orderList.do">주문내역</a></li>
	      <li><a class="detail-menu" href="${pageContext.request.contextPath}/member/questList.do">문의내역</a></li>
	      <li><a class="detail-menu" href="${pageContext.request.contextPath}/cart/list.do">장바구니</a></li>
	      <li><a class="detail-menu" href="${pageContext.request.contextPath}/member/jjimList.do">찜한상품</a></li>
	      <li><a class="detail-menu" href="${pageContext.request.contextPath}/member/productAfter.do">상품후기</a></li>
	      <li><a class="detail-menu" href="${pageContext.request.contextPath}/member/myEditForm.do">개인정보 수정</a></li>
	      <li><a class="detail-menu" href="${pageContext.request.contextPath}/member/memberOutForm.do">회원 탈퇴</a></li>
	    </ul>
      </div>
      
      <div class="right-div">
        <div class="list-name">
          <h2> 주문 내역</h2>
        </div>
		<c:if test="${empty list}">
		  <div class="result-display">주문내역이 없습니다.</div>	
		</c:if>

        <c:if test="${count > 0}">
          <div class="list">
            <div class="list-num">주문 번호</div>
            <div class="list-list">주문 목록</div>
            <div class="list-price">총 가격</div>
            <div class="list-date">주문 날짜</div>
            <div class="list-status">배송 상태</div>
          </div>
          
          <c:forEach var="zzim" items="${list}">
            <ul class="list">
              <li class="list-num"><a href="${pageContext.request.contextPath}/member/memberEdit.do?orderNum=${zzim.order_num}">${zzim.order_num}</a></li>
              <li class="list-list-data"><a href="${pageContext.request.contextPath}/member/memberEdit.do?orderNum=${zzim.order_num}">${zzim.product_name}</a></li>
              <li class="list-price">${zzim.product_price}원</li>
              <li class="list-date">${zzim.order_date}</li>
			  <c:if test="${zzim.order_status==0}"><li class="list-status-1">주문 완료</li></c:if>
              <c:if test="${zzim.order_status==1}"><li class="list-status-2">배송중</li></c:if>
              <c:if test="${zzim.order_status==2}"><li class="list-status-3">배송 완료</li></c:if>
            </ul>
          </c:forEach>
          
        </c:if> 
        
      <div class="align-center">${page}</div>
    </div>
  </div>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>


