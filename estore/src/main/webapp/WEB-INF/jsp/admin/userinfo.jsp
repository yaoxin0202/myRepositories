<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--文件头开始-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
		<%@include file="../header.jsp" %>
		<script type="text/javascript">
			var msg = '${msg}';
			if(msg){
				alert(msg);
			}
		</script>
		
<!--文件体开始-->

		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="images/Forum_nav.gif" align="absmiddle">
                  <a href=index.jsp>杰普电子商务门户</a> → 用户信息修改
                </td>
                </tr>
		</table>
              <br>

<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
	<tr>
		<td valign=middle align=center height=25 background="images/bg2.gif"
			width=""><font color="#ffffff"><b>序号</b></font></td>
		<td valign=middle align=center height=25 background="images/bg2.gif"
			width=""><font color="#ffffff"><b>顾客名称</b></font></td>
		<td valign=middle align=center height=25 background="images/bg2.gif"
			width=""><font color="#ffffff"><b>顾客密码</b></font></td>
		<td valign=middle align=center height=25 background="images/bg2.gif"
			width=""><font color="#ffffff"><b>顾客电话</b></font></td>
		<td valign=middle align=center height=25 background="images/bg2.gif"
			width=""><font color="#ffffff"><b>顾客地址</b></font></td>
		<td valign=middle align=center height=25 background="images/bg2.gif"
			width=""><font color="#ffffff"><b>操作</b></font></td>
	</tr>

	<c:forEach items="${customers }" var="c">
		<tr>
			<form method="post" action="/admin/saveupdate" name="f1">
			<td class=tablebody2 valign=middle align=center width=""><input
				type="text" value="${c.id }" name="id" /></td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<input
				type="text" value="${c.name }" name="name" /></td>
			<td class=tablebody2 valign=middle align=center width=""><input
				type="text" value="${c.password }" name="password" /></td>
			<td class=tablebody2 valign=middle align=center width=""><input
				type="text" value="${c.telephone }" name="telephone" /></td>
			<td class=tablebody2 valign=middle align=center width=""><input
				type="text" value="${c.address }" name="address" /></td>
			<td class=tablebody1 valign=middle align=center width=""><input
				type="button" value="删除"
				onclick="javascript:window.location='/admin/delete/${book.id}';" />
				<input type="submit" value="保存修改" /></td>
			</form>
		</tr>
	</c:forEach>
</table>
<%-- <form method="post" name="reg" action="/customer/update">
	<table cellpadding="3" cellspacing="1" align="center" class="tableborder1" id="table1">
		<tr>
			<td valign="middle" colspan="2" align="center" height="25" background="images/bg2.gif">
			<font color="#ffffff"><b>用户信息修改</b></font></td>
		</tr>
		<tr>
			<td width="40%" class="tablebody1"><b>用户名</b>：<br>
			注册用户名长度限制为0－16字节</td>
			<td width="60%" class="tablebody1">
			<input type="hidden" name="id" value="${customer.id }">
			<input type="hidden" name="name" value="${customer.name }">
			<input type="text" maxLength="8" size="32" disabled value="${customer.name }" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			<font color="#FF0000">*</font></td>
		</tr>
		<tr>
			<td width="40%" class="tablebody1"><b>密码(至少6位，至多8位)</b>：<br>
			请输入密码，区分大小写。<br>
			请不要使用任何类似 \'*\'、\' \' 或 HTML 字符'
			</td>
			<td width="60%" class="tablebody1">
			<input type="password" maxLength="8" size="32" name="password" value="${customer.password }" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			<font color="#FF0000">*</font></td>
		</tr>
		<tr>
			<td width="40%" class="tablebody1"><b>密码(至少6位，至多8位)</b>：<br>
			请再输一遍确认</td>
			<td class="tablebody1">
			<input type="password" maxLength="8" size="32" name="password2" value="${customer.password }" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			<font color="#FF0000">*</font></td>
		</tr>
		<tr>
			<td class="tablebody1"><b>联系地址</b>：</td>
			<td class="tablebody1">
			<input type="text" size="64" maxlength="32" name="address" value="${customer.address }" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			</td>
		</tr>
		<tr>
			<td class="tablebody1"><b>邮编</b>：</td>
			<td class="tablebody1">
			<input type="text" size="32" maxlength="8" name="zip" value="${customer.zip }" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			</td>
		</tr>
		<tr>
			<td class="tablebody1"><b>手机</b>：</td>
			<td class="tablebody1">
			<input type="text" size="32" maxlength="16" name="telephone" value="${customer.telephone }" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			</td>
		</tr>
		<tr>
			<td class="tablebody1"><b>Email地址</b>：<br>
			请输入有效的邮件地址</td>
			<td class="tablebody1">
			<input maxLength="50" size="32" maxlength="32" name="email" value="${customer.email }" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000"></td>
		</tr>
		<tr>
			<td class="tablebody2" valign="middle" colspan="2" align="center">
			<input type="button" value="修 改" onclick="javascript:checkReg()"></td>
		</tr>
	</table>
</form> --%>
<!--文件尾开始-->
		<%@include file="../footer.jsp" %>
	</body>
</html>