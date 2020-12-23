<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="/hotel-admin/static/css/style.css" rel="stylesheet" type="text/css" />
<script src="/hotel-admin/static/js/bootstrap/jquery.min.js"></script>
 <!-- 引入vue -->
<script src="https://cdn.jsdelivr.net/npm/vue"></script>
<script src="https://cdn.jsdelivr.net/npm/vue-resource@1.5.1"></script>
  <!-- 引入bootstrap分页 -->
  <link rel="stylesheet" href="<%=basePath%>/static/js/bootstrap/bootstrap.css" />
  <script src="<%=basePath%>/static/js/bootstrap/bootstrap.min.js"></script>
  <script src="<%=basePath%>/static/js/bootstrap/bootstrap-paginator.js"></script>
  <script>
    $(function() {
      $('#pagination').bootstrapPaginator({
        bootstrapMajorVersion: 3,
        currentPage: ${requestScope.pageInfo.pageNum },
        totalPages: ${requestScope.pageInfo.pages },
        pageUrl: function(type, page, current) {
          return 'findCost.do?pageNum=' + page;
        },
        itemTexts: function(type, page, current) {
          switch(type) {
            case "first":
              return "首页";
            case "prev":
              return "上一页";
            case "next":
              return "下一页";
            case "last":
              return "末页";
            case "page":
              return page;
          }
        }
      });
    });
  </script>
<script type="text/javascript">

$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>
</head>

<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li><a href="#">入住管理</a></li>
    <li><a href="#">消费记录查询</a></li>
  </ul>
</div>
<div class="rightinfo">
  <div class="tools">
    <div class="toolbar1">
      <table>
        <form method="post" name="serch" action="<%=basePath%>/findCost.do">
          <tr>
            <td class="zi"><span>选择分类：</span></td>
            <td>
             <select id="conditionType">
                <option value="phone">手机号码</option>
                <option value="idcard">身份证号码</option>
              </select></td>
            <td class="zi"><span>关键字：</span></td>
            <td><input id="keyword" name="phone" type="text" placeholder="与分类关联"/></td>
            <td><input type="submit" value="查询" class="button"/></td>
          </tr>
        </form>
      </table>
    </div>
  </div>

  <script type="text/javascript">
  	jQuery(function(){
  		jQuery("#conditionType").change(function(){
  			var v = jQuery(this).find("option:selected").val();
  			jQuery("#keyword").attr("name",v);
  		});
  	});
  </script>
  
  <table class="tablelist">
    <thead>
      <tr>
        <th>编号</th>
        <th>客人姓名</th>
        <th>性别</th>
        <th>身份证号</th>
        <th>手机号</th>
        <th>房间号</th>
        <th>订单号</th>
        <th>消费金额</th>
        <th>是否结算</th>
        <th>创建时间</th>
      </tr>
    </thead>

    <tbody>
      <c:forEach var="map" items="${pageInfo.list}" varStatus="count">
        <tr>
          <td>${count.count}</td>
          <td>${map.customer_name}</td>
          <td>${map.gender=='1'?'男':'女'}</td>
          <td>${map.idcard}</td>
          <td>${map.phone}</td>
          <td>${map.room_num}</td>
          <td>${map.order_num}</td>
          <td>${map.order_money}</td>
          <td>${map.order_status=='0'?'未结算':'已经结算'}</td>
          <td>${map.create_date}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
  <ul id="pagination"></ul>

</div>
<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
