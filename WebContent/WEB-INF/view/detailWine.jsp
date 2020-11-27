<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html lang="ja">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Wine Note</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/detailWine.css">


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

<header>
        <div class="center-container">

        </div><!-- /.center-container -->
</header>

<div class="main">

<p>Posted by:&emsp;<c:out value="${wine.contributor}" /></p>

<div class="wine">
   <img src="uploads/<c:out value="${wine.image}" />" onerror="this.src='image/noimage.jpg';" width="300px">
</div>

    <table>
        <tr>
            <th>商品名</th>
            <td><c:out value="${wine.name}" /></td>
        </tr>
        <tr>
            <th>総合評価</th>
            <td><c:out value="${wine.evaluation}" /></td>
        </tr>
        <tr>
            <th>種類</th>
            <td><c:out value="${wine.type}" /></td>
        </tr>
         <tr>
            <th>アルコール度数</th>
            <td><c:out value="${wine.alcohol}" />％</td>
        </tr>
        <tr>
            <th>原産国</th>
            <td><c:out value="${wine.country}" /></td>
        </tr>
        <tr>
            <th>価格</th>
            <td><c:out value="${wine.price}" />円</td>
        </tr>
        <tr>
            <th>購入日</th>
            <td><fmt:formatDate value="${wine.date}" pattern="y/M/d"/></td>
        </tr>
        <tr>
            <th>購入店舗</th>
            <td><c:out value="${wine.shop}" /></td>
        </tr>
        <tr>
            <th>Comments</th>
            <td>
                <c:out value="${wine.comment}" />
            </td>
        </tr>
      </table>



    </div>

    <p>
       <a class="btn" href="deleteWine?id=<c:out value="${wine.id}" />"><img src="image/delete.png"></a>
    </p>

    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>

</body>
</html>