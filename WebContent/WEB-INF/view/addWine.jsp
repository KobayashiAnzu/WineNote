<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Wine Note</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/addWine.css">


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


                    <h2>NewPost</h2>
                    <form action="" method="post"  enctype="multipart/form-data">
                      <dl>

                          <span style="color:red">${errImage}</span>
                          <label class="upload-img-btn">
                            &emsp;PHOTO&emsp;
                          <input type="file" name="image" value="${image}" style="display:none">
                          </label>



                            <dt>商品名</dt>
                            <dd><input type="text" name="name" value="${name}">
                            <span style="color:red">${errName}</span>
                            </dd>


                            <dt>総合評価</dt>
                            <dd>
                            <select name="evaluation" value="${evaluation}">
                              <option value="1"<c:if test="${evaluation == '1'}">selected</c:if>>1</option>
                              <option value="2"<c:if test="${evaluation == '2'}">selected</c:if>>2</option>
                              <option value="3"<c:if test="${evaluation == '3'}">selected</c:if>>3</option>
                              <option value="4"<c:if test="${evaluation == '4'}">selected</c:if>>4</option>
                              <option value="5"<c:if test="${evaluation == '5'}">selected</c:if>>5</option>
                            </select>
                            </dd>

                            <dt>種類</dt>
                            <dd>
                            <select name="type" value="${type}">
                              <option value="赤"<c:if test="${type == '赤'}">selected</c:if>>赤</option>
                              <option value="白"<c:if test="${type == '白'}">selected</c:if>>白</option>
                              <option value="スパークリング"<c:if test="${type == 'スパークリング'}">selected</c:if>>スパークリング</option>
                              <option value="ロゼ"<c:if test="${type == 'ロゼ'}">selected</c:if>>ロゼ</option>
                              <option value="デザート"<c:if test="${type == 'デザート'}">selected</c:if>>デザート</option>
                              <option value="その他"<c:if test="${type == 'その他'}">selected</c:if>>その他</option>
                            </select>
                            </dd>

                            <dt>アルコール度数</dt>
                            <dd><input type="number" name="alcohol" value="${alcohol}">%
                            <span style="color:red"> ${errAlcohol}</span>
                            </dd>

                            <dt>原産国</dt>
                            <dd><input type="text" name="country" value="${country}">
                             <span style="color:red"> ${errCountry}</span>
                            </dd>

                            <dt>価格</dt>
                            <dd><input type="number" name="price" min="0" max="1000000000"
                            value="${price}">円
                            <span style="color:red">${errPrice}</span>
                            </dd>

                             <dt>購入日</dt>
                             <dd><input type="date" name="date" value="${date}"></dd>

                             <dt>購入店舗</dt>
                             <dd><input type="text" name="shop" value="${shop}"></dd>

                             <dt>Comments</dt>
                             <dd><textarea name="comment" value="${comment} "rows="4" cols="40" maxlength="500">
                             </textarea>
                             </dd>

                             <dt>投稿者</dt>
                             <dd><input type="text" name="contributor" value="${contributor}"></dd>


                     <div class="submit">
                         <input type="submit" name="add" value="Post" style="font-weight:bold;">
                         <input type="submit" name="back" value="Back" style="font-weight:bold;">
                         </div>
                </dl>
                        </form>


        </main>
    </div><!--/.container-->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
</body>

</html>