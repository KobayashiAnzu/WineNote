<!DOCTYPE html>
<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html lang="ja">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Wine Note</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/adminList.css">
  </head>

<body>
  <nav class="navbar navbar-expand-md sticky-top" style="background-color:white">
    <div class="container">
      <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#menu">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="menu">
          <ul class="navbar-nav" >
              <li class="nav-item active"> <a class="nav-link" href="logout">signout&emsp;<img src="image/logout.png"></a></li>
              <li class="nav-item"> <a class="nav-link" href="search">search&emsp;<img src="image/search.png"></a></li>
              <li class="nav-item"> <a class="nav-link" href="topPage">top&emsp;<img src="image/topPage.png"></a></li>
              <li class="nav-item"> <a class="nav-link" href="addWine">post&emsp;<img src="image/add.png"></a></li>
          </ul>
      </div>
   </div>
</nav>
    <div class="jumbotron jumbotron-fluid">
       <div class="container">
            <header>
                <h1 class="display-8 text-white">Wine Note</h1>
            </header>
       </div>
    </div>


    <div class="container">
      <main>
        <h3>Members List</h3>

	<table>
		<tr>
			<th>No.</th>
			<th>名前</th>
			<th>関係</th>
			<th>ID</th>
            <th>登録日</th>
            <th><a href="addAdmin">ADD<img src="image/users.png"></a></th>

		</tr>
		<c:forEach var="admin" items="${admins}">
		<tr>
			<td><c:out value="${admin.id}" /></td>
			<td><c:out value="${admin.name}" /></td>
			<td><c:out value="${admin.relationship}" /></td>
			<td><c:out value="${admin.loginId}" /></td>
			<td><fmt:formatDate value="${admin.created}" pattern="y/M/d"/></td>
			<td><a href="deleteAdmin?id=<c:out value="${admin.id}" />">DELETE</a></td>
		</tr>
        </c:forEach>
	</table>


</div>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>

</body>
</html>