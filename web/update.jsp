<%@ page import="com.cs.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/7
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>

    <script type="text/javascript">

    </script>

</head>
<body>

<%String id = request.getParameter("id");%>
<form action="UserServlet" method="post">
    <table align="center" width="500px" border="1">
        <input type="hidden" name="id" value="<%=id%>">
        <tr height="40px" align="center">
            <td colspan="2"><strong>用户信息</strong></td>
        </tr>
        <tr height="40px">
            <td align="right">用户名：</td>
            <td>
                <input type="text" name="username" value="${user.username}">
            </td>
        </tr>
        <tr height="40px">
            <td align="right">密码：</td>
            <td>
                <input type="text" name="password" value="${user.password}">
            </td>
        </tr>
        <tr height="40px">
            <td align="right">性别：</td>
            <td>
                <input type="text" name="sex" value="${user.sex}">
            </td>
        </tr>
        <tr height="40px">
            <td align="right">生日：</td>
            <td>
                <input type="text" name="bornDate" value="${user.bornDate}">
            </td>
        </tr>
        <tr height="40px">
            <td></td>
            <td>
                <input type="submit" name="comm" value="修改"/>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
