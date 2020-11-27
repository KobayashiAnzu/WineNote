<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ja">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Wine Note</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/deleteWine.css">


</head>

<body>

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

  <h5> 以下の投稿を削除しますか？</h5>
<p>" <c:out value="${wine.name}" /> "</p>
	<form action="" method="post">
        <input type="submit" name="delete" id="delete" value="削除" />
        <input type="submit" name="cancel" id="cancel" value="キャンセル" />
	</form>

</div>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>

</body>
</html>