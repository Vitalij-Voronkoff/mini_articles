<%@ include file="include.jsp" %>

<html>
<head>
  <title><fmt:message key="title"/></title>
  <style>
    .error {
      color: red;
    }
  </style>
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

    </td>
    <td rowspan="5" bgcolor="#f0da52">
      <c:if test="${!empty principal}">
        <h2>You registered as ${principal}</h2>
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

<h2>User profile:</h2>
<br>

<h4>User name : ${user.userName}</h4>
<br>

<h4>User email: ${user.email}</h4>
<br>

<h4>Quantity articles: <a href="/userinfo/allarticles/${user.userName}">${quantity}</a></h4>
<br>
<c:if test="${! empty allarticles}">
  <h4>List of articles where author is ${user.userName}:</h4>
  <br>
  <c:forEach items="${allarticles}" var="article">
    <a href="/article/${article.id}"><h4>${article.title}</h4></a>
  </c:forEach>
</c:if>

</body>
</html>