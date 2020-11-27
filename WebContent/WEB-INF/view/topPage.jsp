<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Wine Note</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/topPage.css">


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
                  <li class="nav-item"> <a class="nav-link" href="addWine">post&emsp;<img src="image/add.png"></a></li>
                  <li class="nav-item"> <a class="nav-link" href="adminList">管理人<img src="image/admin.png"></a></li>
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

                    <h2>List</h2>
                    <div class="row">
                    <c:forEach var="wine" items="${wines}">
                     <div class="wine col-xs-4 col-lg-3">
                     <a href="detailWine?id=<c:out value="${wine.id}" />">
                       <img class="img-thumbnail " src="uploads/<c:out value="${wine.image}" />" onerror="this.src='image/noimage.jpg';">

                     </a>
                     </div>
                     </c:forEach>

                     </div><!--/.row 各ワイン画像-->


        </main>
    </div><!--/.container-->
 <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
</body>

</html>