<%@ page import="java.security.Principal" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ include file="include.jsp" %>

<html>
<head>
  <title><fmt:message key="title"/></title>
</head>
<body bgcolor="#f0f8ff">
<table class="data">
  <tr>
    <td rowspan="5" bgcolor="#f0da52" width="100%">
      <div style="cursor: pointer; cursor: hand;" onclick="location.href='/main.html'">
        <h2><fmt:message key="headhello"/></h2>
      </div>
      <input type="button" align="center" value="Create new blog entry" onclick="location.href='/newarticle'">
      <br>

      <h3>Blog entries available</h3>

    </td>
    <td rowspan="5" bgcolor="#f0da52">
      <c:if test="${!empty principal}">
        <h2>You registered as <a href="/userinfo/${principal}">${principal}</a></h2>
      </c:if>
    </td>
    <td rowspan="5" align="center" bgcolor="#0ef169">

      <input type="submit" value="Login" onclick="location.href='/login'">
      <br>
      <br>
      <input type="submit" value="Logout" onclick="location.href='/j_spring_security_logout'">
      <br>
      <br>
      <input type="submit" value="Register me" onclick="location.href='/register'">


    </td>
  </tr>
</table>
<c:if test="${!empty articleList}">
  <c:forEach items="${articleList}" var="article">
    <hr>
    <table class="data" width="100%">
      <tr>
        <td align="center" width="85%" colspan="3"><h3>${article.title}</h3></td>
        <c:if test="${principal==article.author||principal eq 'admin'}">
          <td width="15%" align="right"><input type="button" align="center" value="Delete this article"
                                               onclick="location.href='/deletearticle/${article.id}'"></td>
        </c:if>
      </tr>

      <tr>
        <td width="85%" colspan="3">
          <div align="justify"
               style="width: 100%; height: 95px; padding: 10px; overflow: hidden; text-overflow: ellipsis;">${article.content}</div>
        </td>
      </tr>
      <p>
        <tr>
          <td align="left" width="30%"><strong>Author: <a
                  href="/userinfo/${article.author}">${article.author}</a></strong></td>
          <c:if test="${!empty principal}">
            <td align="justify"><input type="submit" value="Add comment"
                                       onclick="location.href='/article/addcomment/${article.id}'"></td>
          </c:if>
          <td align="justify"><a href="/article/${article.id}">...Read more</a></td>
          <td align="right" width="15%">Creation time: <fmt:formatDate value="${article.date}"
                                                                       pattern="yyyy-MM-dd HH:mm"/></td>
        </tr>
      </p>
    </table>
  </c:forEach>
</c:if>

</body>
</html>
