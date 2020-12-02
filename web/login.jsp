<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/6
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="dologin.jsp" method="post">
    <table align="center" width="500px" border="1">
        <tr height="40px" align="center">
            <td colspan="3"><strong>用户登录</strong></td>
        </tr>
        <tr height="40px">
            <td align="right">用户名：</td>
            <td>
                <input type="text" name="username" value=""/>
            </td>
        </tr>
        <tr height="40px">
            <td align="right">密码：</td>
            <td>
                <input type="text" name="password" value=""/>
            </td>
        </tr>
        <tr height="40px">
            <td></td>
            <td>
                <input type="submit" value="登录"/>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
