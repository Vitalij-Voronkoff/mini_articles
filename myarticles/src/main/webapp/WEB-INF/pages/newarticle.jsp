<%@ include file="include.jsp"%>

<html>
<head>
  <title><fmt:message key="title"/></title>
  <style>
    .error {color: red;}
  </style>
</head>
<body bgcolor="#f0f8ff">

<h2><fmt:message key="headnewart"/></h2>

<form:form method="POST" action="/createarticle" modelAttribute="article">

  <table>
    <tr>
      <td>
        <form:label path="title">
          Title
        </form:label>
      </td>
      <td><form:input path="title"/><form:errors path="title" cssClass="error"/></td>
    </tr>
    <tr>
      <td>
        <form:label path="content">
          Content
        </form:label>
      </td>
      <td><form:textarea cols="50" rows="15" path="content"/><form:errors path="content" cssClass="error"/></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Save article" />
      </td>
    </tr>
  </table>

</form:form>

</body>
</html>