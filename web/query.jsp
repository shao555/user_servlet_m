<%@ page import="com.cs.entity.User" %>
<%@ page import="com.cs.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/7
  Time: 14:28
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
        function ba() {
            history.back();
        }
    </script>
</head>
<body>


<form action="#" method="post">
    <table align="center" width="500px" border="1">
        <tr height="40px" align="center">
            <td colspan="2"><strong>用户信息</strong></td>
        </tr>
        <tr height="40px">
            <td align="right">编号：</td>
            <td>
                ${user.id}
            </td>
        </tr>
        <tr height="40px">
            <td align="right">用户名：</td>
            <td>
                ${user.username}
            </td>
        </tr>
        <tr height="40px">
            <td align="right">密码：</td>
            <td>
                ${user.password}
            </td>
        </tr>
        <tr height="40px">
            <td align="right">性别：</td>
            <td>
                ${user.sex}
            </td>
        </tr>
        <tr height="40px">
            <td align="right">生日：</td>
            <td>
            <td>${user.bornDate}</td>
            </td>
        </tr>
<%--        <tr height="40px">--%>
<%--            <td align="right">邮箱：</td>--%>
<%--            <td>--%>
<%--                <%=user.getEmail()%>--%>
<%--            </td>--%>
<%--        </tr>--%>
        <tr height="40px">
            <td></td>
            <td>
                <input type="button" value="返回" onclick="ba()"/>
            </td>
        </tr>
    </table>
</form>



</body>
</html>
