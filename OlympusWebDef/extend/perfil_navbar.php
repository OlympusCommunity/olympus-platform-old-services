<?php 
    include '../conexion/conexion.php';     
?>
<!DOCTYPE html>
<html>

<head>
  <link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:700, 600,500,400,300' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
		<link rel="stylesheet" href="../css/perfil.css">

		<script src="https://code.jquery.com/jquery-2.2.0.min.js"></script>
		<script src="https://code.highcharts.com/highcharts.js"></script>
		<script src="https://code.highcharts.com/modules/data.js"></script>
		<script src="../js/perfil.js"></script>

	<!-- Icon -->
	<link rel="icon" type="image/png" href="../img/icono.ico" />
	<!-- Bootstrap CDN -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"> 
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
    <!-- Bootstrap core CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.7.3/css/mdb.min.css" rel="stylesheet">
</head>

<body class="bg-dark">
	<div class="header">
			<div class="logo">
				<img src="../img/logo.png" width="30" height="30">
				<span><a href="../admin/index.php">ＯＬＹＭＰＵＳ</a></span>
			</div>
			<a href="#" class="nav-trigger"><span></span></a>


		</div>
		<div class="side-nav">
			<div class="logo">
				<img src="../img/logo.png" width="30" height="30">
				<span><a href="../admin/index.php">ＯＬＹＭＰＵＳ</a></span>
			</div>
			<nav>
				<ul>
					<li class="nav-item">
						<a href="../admin/usuario.php">
							<span><img src="<?php echo $_SESSION['foto_user'] ?>" width="40" height="40" class="rounded-circle" ></span>
							<span><?php echo $_SESSION['name'] ?> <img src="../img/ChatRoom/conectado.png" width="10" height="10" class="rounded-circle"></span>
							<br>					
						</a>
					</li>
					<li class="nav-item">
						<a href="../admin/chat_room_g.php">
							<span><i class="fa fa-envelope"></i></span>
							<span>ChatRoom</span>
						</a>
					</li>
					<li class="nav-item">
						<a href="../admin/gestion_grupos.php">
							<span><i class="fa fa-bar-chart"></i></span>
							<span>Gestión de Grupos</span>
						</a>
					</li>
					<li class="nav-item">
						<a href="../admin/perfil_contract.php.php">
							<span><i class="fa fa-credit-card-alt"></i></span>
							<span>Contratos</span>
						</a>
					</li>
				</ul>
			</nav>
		</div>

	<!-- JQuery -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.2.1/js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.7.3/js/mdb.min.js"></script>
</body>
</html>