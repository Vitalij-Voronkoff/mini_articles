<%@ include file="include.jsp" %>

<html>
<head>
  <title><fmt:message key="title"/></title>
  <style>
    .error {
      color: red;
      border: 3px solid #ff0000;
      padding: 8px;
      margin: 16px;
    }
  </style>
</head>
<body bgcolor="#f0f8ff" onload="document.f.j_username.focus();">
<h2><fmt:message key="headlogin"/></h2>

<c:if test="${not empty error}">
  <div class="error">
    Your login attempt was not successful , try again.<br/>
    <br/>
    <spring:message code="loginPage.authenticationFailure"/>
  </div>
</c:if>

<form name="f" action="<c:url value="j_spring_security_check" />" method="POST">
  <table>
    <tr>
      <td>Login:</td>
      <td><input type="text" name="j_username"><form:errors path="userName" cssClass="error"/></td>
    </tr>
    <tr>
      <td>Password:</td>
      <td><input type="password" name="j_password"><form:errors path="password" cssClass="error"/></td>
    </tr>
    <tr>
      <td><input type="submit" value="Login"></td>
    </tr>
  </table>
</form>

</body>
</html>