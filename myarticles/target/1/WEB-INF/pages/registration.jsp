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
<h2><fmt:message key="headreg"/></h2>

<form:form method="POST" action="/newuser" modelAttribute="user">

  <table>
    <tr>
      <td>
        <form:label path="userName">
          Login
        </form:label>
      </td>
      <td><form:input path="userName"/><form:errors path="userName" cssClass="error"/></td>
    </tr>
    <tr>
      <td>
        <form:label path="password">
          Password
        </form:label>
      </td>
      <td><form:password path="password"/><form:errors path="password" cssClass="error"/></td>
    </tr>
    <tr>
      <td>
        <form:label path="email">
          Email
        </form:label>
      </td>
      <td><form:input path="email"/><form:errors path="email" cssClass="error"/></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Register"/>
      </td>
    </tr>
  </table>

</form:form>

</body>
</html>