<?php 
    include '../conexion/conexion.php'; 
?>

<!DOCTYPE html>
<html>
<head>
	
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- Icon -->
	<link rel="icon" type="image/png" href="../img/icono.ico" />
	<!-- My CSS Navbar -->
	<link rel="stylesheet" href="../css/nav.css">
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

<!-- NAVBAR AETERNUS-->
    <nav class="navbar fixed-top navbar-expand-lg navbar-dark gris scrolling-navbar">       
        <div class="container">
        <a class="navbar-brand" href="../index.php"><img src="../img/logo.png" width="50" height="50"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="../admin/index.php">ＩＮＩＣＩＯ<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="../admin/contacto.php">ＣＯＮＴＡＣＴＯ</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="../admin/planes.php">ＰＬＡＮＥＳ</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="../admin/grupos.php">ＧＲＵＰＯＳ</a>
            </li>
            
            </ul>

            <ul class="navbar-nav nav-flex-icons">
                <li class="nav-item">
                    <a class="nav-link" href="https://www.facebook.com/Olympus-Empire-364763034364787/"><i class="fab fa-facebook-f"></i></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link"><i class="fab fa-twitter"></i></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="https://www.instagram.com/olympuswebempire/" ><i class="fab fa-instagram"></i></a>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-left">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="perfil" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <img src="<?php echo $_SESSION['foto_user'] ?>" width="50" height="50" class="rounded-circle" >
                        <?php echo $_SESSION['name'] ?>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="perfil">
                        <a href="../admin/perfil.php" class="dropdown-item">Perfil</a>
                        <a href="#" class="dropdown-item">ChatRoom</a>
                        <a href="#" class="dropdown-item" id="logout">Salir</a>
                    </div>
                </li>
            </ul>
            </div>
        </div>
    </nav>
<!-- END NAVBAR AETERNUS-->
    <script type="text/javascript" src="../js/logout.js"></script>
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