<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--文件头开始-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
		<%@include file="../header.jsp" %>

<!--文件体开始-->

		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="images/Forum_nav.gif" align="middle">
                  <a href=index.html>杰普电子商务门户</a> →
					<a href="order.html">定单列表</a> →
					定单明细
                </td>
                </tr>
		</table>
              <br>

		<form name="order" method="post" action="">
		<table cellpadding="3" cellspacing="1" align="center" class="tableborder1" id="table1">
		<tr>
			<td valign="middle" colspan="2" align="center" height="25" background="images/bg2.gif">
			<font color="#ffffff"><b>用户信息</b></font></td>
		</tr>
		<tr>
			<td width="40%" class="tablebody2" align="right"><b>用户名</b>：</td>
			<td width="60%" class="tablebody1">${customer.name }</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>联系地址</b>：</td>
			<td class="tablebody1">${customer.address }</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>邮编</b>：</td>
			<td class="tablebody1">${customer.zip }</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>手机</b>：</td>
			<td class="tablebody1">${customer.telephone }</td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>Email地址</b>：</td>
			<td class="tablebody1">${customer.email }</td>
		</tr>
	</table>
<br>
<!--文件尾开始-->
		<table cellpadding="3" cellspacing="1" align="center" class="tableborder1" id="table2">
		<tr>
			<td valign="middle" colspan="2" align="center" height="25" background="images/bg2.gif">
			<font color="#FFFFFF"><b>付款方式</b></font></td>
		</tr>
		<tr>
			<td width="40%" class="tablebody2" align="right">　</td>
			<td width="60%" class="tablebody1">货到付款</td>
		</tr>
		</table>
		<br>
		<table cellpadding=3 cellspacing=1 align=center class=tableborder1 id="table3">
		<tr>
			<td valign=middle align=center height=25 background="images/bg2.gif" colspan="5">
			<font color="#ffffff"><b>商品购物清单</b></font></td>
		</tr>
         
       <c:forEach items="${lines }" var="line">
			<tr>
				<td class=tablebody2 valign=middle align=center width="">${line.book.id }</td>
				<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="productDetail?id=${line.book.id }" target="_blank">${line.book.name }</a></td>
				<td class=tablebody2 valign=middle align=center width="">价格：${line.book.price }</td>
				<td class=tablebody1 valign=middle align=center width="">数量：${line.num }</td>
				<td class=tablebody2 valign=middle align=left width="">小计：￥${line.book.price * line.num }</td>
			</tr>
       </c:forEach>
                
		<tr>
			<td class=tablebody1 valign=middle align=center colspan="4">　</td>
			<td class=tablebody1 valign=middle align=left width="">合计：<font color="#ff0000"><b>￥${order.cost }</b></font></td>
		</tr>
		        </table>
		</form>
		<br>

		<%@include file="../footer.jsp" %>
	</body>
</html>