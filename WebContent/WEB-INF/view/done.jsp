<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" %>
<html lang="ja">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Wine Note</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/done.css">
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

<header>
        <div class="center-container">

        </div><!-- /.center-container -->
</header>

<div class="main">

  <h5>操作が完了しました。</h5>
 <p style="font-weight:bold;"><a href="topPage">TopPage</a></p>

</div>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>

</body>
</html>