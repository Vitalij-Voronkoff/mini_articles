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

<table class="data" width="100%">
  <tr>
    <td align="center" width="100%" colspan="2"><h3>${article.title}</h3></td>
  </tr>

  <tr>
    <td width="100%" colspan="3">
      <div align="justify"
           style="padding-left: 25px;padding-right: 25px;padding-bottom: 25px;padding-top: 10px;">${article.content}</div>
    </td>
  </tr>
  <br>
  <tr>
    <td align="left" width="50%"><strong>Author: <a
            href="/userinfo/${article.author}">${article.author}</a></strong></td>
    <td align="right" width="50%">Creation time: <fmt:formatDate value="${article.date}"
                                                                 pattern="yyyy-MM-dd HH:mm"/></td>
  </tr>

</table>

<br>
<c:if test="${empty commentsList}">
  <h4>Comments nobody has left..</h4>
</c:if>
<c:if test="${!empty commentsList}">
  <h3>Users comments: </h3>
  <br>
  <c:forEach items="${commentsList}" var="comments">
    <hr>
    <table class="data" width="100%">

      <tr>
        <td align="left" width="10%"><strong>Author: <a
                href="/userinfo/${comments.author}">${comments.author}</a></strong></td>
        <td width="80%">
          <div align="justify">${comments.content}</div>
        </td>
        <c:if test="${principal==comments.author||principal eq 'admin'}">
          <td align="right"><input type="button" align="center" value="Delete this comment"
                                   onclick="location.href='/deletecomment/${article.id}/${comments.id}'"></td>
        </c:if>
        <td align="right" width="10%"><fmt:formatDate value="${comments.date}"
                                                      pattern="yyyy-MM-dd HH:mm"/></td>
      </tr>
    </table>
  </c:forEach>
</c:if>
<c:if test="${!empty principal}">
  <a name="comment"/>

  <div><h3>Add your comments: </h3></div>

  <form:form method="POST" action="/newcomment/${article.id}" modelAttribute="comments">

    <table>
      <tr>
        <td>
          <form:label path="content">
            Enter your comment:
          </form:label>
        </td>
        <td><form:textarea cols="40" rows="15" path="content"/><form:errors path="content"
                                                                            cssClass="error"/></td>
      </tr>
      <tr>
        <td colspan="2">
          <input type="submit" value="Add comment"/>
        </td>
      </tr>
    </table>

  </form:form>
</c:if>

</body>
</html>