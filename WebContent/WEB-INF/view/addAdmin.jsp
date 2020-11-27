<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
	<head>

		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Wine Note</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/addAdmin.css">



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

	<h3>新規会員登録</h3>
	<form action="" method="post">
	<dl>
		<dt>No.</dt>
		<dd>
		<input type="number" name="id" />
		<span style="color:red">${errId}</span>
		</dd>

		<dt>名前</dt>
        <dd><input type="text" name="name" /></dd>

		<dt>関係</dt>
		<dd><input type="text" name="relationship" /></dd>

		<dt>ログインID</dt>
		<dd><input type="text" name="login_id" /></dd>

		<dt>Password</dt>
		<dd><input type="text" name="login_pass" /></dd>

		<dt>Level</dt>
		<dd><input type="number"  name="auth_level" placeholder="管理者以外は１"/></dd>

		<dt>追加日</dt>
		<dd><input type="date" name="created" id = "today" /></dd>

		<div class="submit">
		  <input type="submit" name="add" value="追加" />
		  <input type="submit" name="cancel" value="キャンセル" />
	    </div>
	</dl>
	</form>
	</main>
</div>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>


</body>
</html>